package io.dronefleet.mavlink;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.common.*;
import io.dronefleet.mavlink.protocol.MavlinkPacket;
import io.dronefleet.mavlink.protocol.MavlinkPacketReader;
import io.dronefleet.mavlink.serialization.MavlinkPacketDeserializer;
import io.dronefleet.mavlink.serialization.MavlinkPacketSerializer;
import io.dronefleet.mavlink.serialization.ReflectionPacketDeserializer;
import io.dronefleet.mavlink.serialization.ReflectionPacketSerializer;
import io.dronefleet.mavlink.validation.Mavlink1PacketValidator;
import io.dronefleet.mavlink.validation.Mavlink2PacketValidator;
import io.dronefleet.mavlink.validation.MavlinkPacketValidator;
import io.dronefleet.mavlink.validation.MavlinkPacketValidatorResolver;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Mavlink implements Runnable {

    public static void main(String args[]) throws IOException {
        Socket socket = new Socket("127.0.0.1", 5762);

        Map<Integer, Class> messageTypes = new HashMap<>();
        messageTypes.put(0, Heartbeat.class);
        messageTypes.put(1, SysStatus.class);
        messageTypes.put(125, PowerStatus.class);
        messageTypes.put(253, Statustext.class);
        messageTypes.put(111, Timesync.class);
        messageTypes.put(77, CommandAck.class);
        messageTypes.put(22, ParamValue.class);
        messageTypes.put(242, HomePosition.class);
        messageTypes.put(49, GpsGlobalOrigin.class);

        Mavlink mavlink = new Mavlink(
                new MavlinkPacketReader(socket.getInputStream()),
                socket.getOutputStream(),
                messageTypes,
                new MavlinkPacketValidatorResolver(
                        new Mavlink1PacketValidator(),
                        new Mavlink2PacketValidator()),
                new ReflectionPacketDeserializer(),
                new ReflectionPacketSerializer());

        mavlink.send(CommandLong.builder()
                .command(MavCmd.MAV_CMD_NAV_TAKEOFF)
                .targetComponent(1)
                .targetSystem(1)
                .confirmation(0)
                .build());

        mavlink.run();
    }

    private final Lock runLock;
    private final MavlinkPacketReader reader;
    private final OutputStream out;
    private final Map<Integer, Class> messageTypes;
    private final MavlinkPacketValidator validator;
    private final MavlinkPacketDeserializer deserializer;
    private final MavlinkPacketSerializer serializer;
    private int sequence;

    public Mavlink(
            MavlinkPacketReader reader,
            OutputStream out,
            Map<Integer, Class> messageTypes,
            MavlinkPacketValidator validator,
            MavlinkPacketDeserializer deserializer,
            MavlinkPacketSerializer serializer) {
        this.reader = reader;
        this.out = out;
        this.messageTypes = messageTypes;
        this.validator = validator;
        this.deserializer = deserializer;
        this.serializer = serializer;
        runLock = new ReentrantLock();
    }

    @Override
    public void run() {
        if (!runLock.tryLock()) {
            throw new IllegalStateException(getClass().getSimpleName() + " instances may only be run once");
        }
        try {
            while (reader.next()) {
                MavlinkPacket packet = reader.packet();

                if (!messageTypes.containsKey(packet.getMessageId())) {
                    System.err.println("Got message with ID " + packet.getMessageId() + ", but I don't know this message.");
                    continue;
                }

                Class<?> messageType = messageTypes.get(packet.getMessageId());
                int crc = messageType.getAnnotation(MavlinkMessage.class).crc();

                if (!validator.validate(packet, crc)) {
                    reader.drop();
                    continue;
                }

                Object message = deserializer.deserialize(packet, messageType);
                System.out.println(packet.getSystemId() + ":" + packet.getComponentId() + " -> " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void send(Object o) throws IOException {
        out.write(serializer.serialize(o,
                sequence++,
                1,
                1));
    }
}
