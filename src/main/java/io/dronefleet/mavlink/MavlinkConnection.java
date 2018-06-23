package io.dronefleet.mavlink;

import com.benbarkay.events.EventBus;
import com.benbarkay.events.EventEmitter;
import com.benbarkay.events.EventSource;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.common.Heartbeat;
import io.dronefleet.mavlink.common.MavAutopilot;
import io.dronefleet.mavlink.protocol.MavlinkException;
import io.dronefleet.mavlink.protocol.MavlinkPacket;
import io.dronefleet.mavlink.protocol.MavlinkPacketReader;
import io.dronefleet.mavlink.serialization.MavlinkSerializationException;
import io.dronefleet.mavlink.serialization.payload.MavlinkPayloadDeserializer;
import io.dronefleet.mavlink.serialization.payload.MavlinkPayloadSerializer;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MavlinkConnection implements Runnable {

    private static final int HEARTBEAT_MESSAGE_ID;
    private static final int HEARTBEAT_CRC;

    static {
        if (Heartbeat.class.isAnnotationPresent(MavlinkMessageInfo.class)) {
            MavlinkMessageInfo info = Heartbeat.class.getAnnotation(MavlinkMessageInfo.class);
            HEARTBEAT_MESSAGE_ID = info.id();
            HEARTBEAT_CRC = info.crc();
        } else {
            throw new IllegalStateException(Heartbeat.class.getName() + " is not annotated with @MavlinkMessageInfo");
        }
    }

    private final Lock runLock;
    private final EventBus<MavlinkMessage> recvQueue;
    private final EventBus<MavlinkMessage> sendQueue;
    private final EventBus<Void> disconnected;

    private final Map<Integer, MavlinkDialect> systemDialects;
    private int sequence;

    private final MavlinkPacketReader reader;
    private final OutputStream out;
    private final Map<MavAutopilot, MavlinkDialect> dialects;
    private final MavlinkPayloadDeserializer deserializer;
    private final MavlinkPayloadSerializer serializer;

    MavlinkConnection(
            MavlinkPacketReader reader,
            OutputStream out,
            Map<MavAutopilot, MavlinkDialect> dialects,
            MavlinkPayloadDeserializer deserializer,
            MavlinkPayloadSerializer serializer,
            Executor executor) {
        this.reader = reader;
        this.out = out;
        this.dialects = dialects;
        this.deserializer = deserializer;
        this.serializer = serializer;
        runLock = new ReentrantLock();
        recvQueue = EventBus.create(executor);
        sendQueue = EventBus.create(executor);
        disconnected = EventBus.create(recvQueue.executor());
        systemDialects = new HashMap<>();

        sendQueue.map(this::createPacket)
                .error(Throwable::printStackTrace)
                .consume(this::send);
    }

    @Override
    public void run() {
        if (!runLock.tryLock()) {
            throw new IllegalStateException(getClass().getSimpleName() + " instances may only be run once");
        }
        try {
            while (reader.next()) {
                MavlinkPacket packet = reader.packet();

                Object payload;

                if (packet.getMessageId() == HEARTBEAT_MESSAGE_ID) {
                    if (!packet.validate(HEARTBEAT_CRC)) {
                        reader.drop();
                        continue;
                    }

                    Heartbeat heartbeat = deserializer.deserialize(packet.getPayload(), Heartbeat.class);
                    systemDialects.put(
                            packet.getSystemId(),
                            dialects.get(heartbeat.autopilot()));

                    payload = heartbeat;

                } else {
                    if (!systemDialects.containsKey(packet.getSystemId())) {
                        System.err.println("No dialect for system ID " + packet.getSystemId() + ", skipping packet with message ID " + packet.getMessageId());
                        continue;
                    }
                    MavlinkDialect dialect = systemDialects.get(packet.getSystemId());

                    if (!dialect.supports(packet.getMessageId())) {
                        System.err.println("Dialect " + dialect.getClass().getSimpleName() + " does not support a message with ID " + packet.getMessageId() + ".");
                        continue;
                    }

                    Class<?> messageType = dialect.resolve(packet.getMessageId());
                    MavlinkMessageInfo messageInfo = messageType.getAnnotation(MavlinkMessageInfo.class);

                    if (!packet.validate(messageInfo.crc())) {
                        reader.drop();
                        System.err.println("Packet dropped");
                        continue;
                    }

                    payload = deserializer.deserialize(packet.getPayload(), messageType);
                }

                //noinspection unchecked
                recvQueue.emit(new MavlinkMessage(
                        packet.getSystemId(),
                        packet.getComponentId(),
                        payload));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            disconnected.emit(null);
        }
    }

    private MavlinkPacket createPacket(MavlinkMessage message) {
        Object payload = message.getPayload();
        Class<?> payloadType = payload.getClass();

        if (!payloadType.isAnnotationPresent(MavlinkMessageInfo.class)) {
            throw new MavlinkSerializationException(payloadType.getName() + " is not annotated with @MavlinkMessageInfo");
        }

        MavlinkMessageInfo messageInfo = payloadType.getAnnotation(MavlinkMessageInfo.class);
        return MavlinkPacket.create(
                sequence++,
                message.getOriginSystemId(),
                message.getOriginComponentId(),
                messageInfo.id(),
                messageInfo.crc(),
                serializer.serialize(message.getPayload()));
    }

    private void send(MavlinkPacket packet) {
        try {
            out.write(packet.getRawBytes());
        } catch (IOException e) {
            throw new MavlinkException(e);
        }
    }

    public EventEmitter<MavlinkMessage> outgoing() {
        return sendQueue;
    }

    public EventSource<MavlinkMessage> incoming() {
        return recvQueue;
    }

    public EventSource<Void> disconnected() {
        return disconnected;
    }
}
