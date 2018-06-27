package io.dronefleet.mavlink;

import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.common.Heartbeat;
import io.dronefleet.mavlink.common.MavAutopilot;
import io.dronefleet.mavlink.protocol.MavlinkException;
import io.dronefleet.mavlink.protocol.MavlinkPacket;
import io.dronefleet.mavlink.protocol.MavlinkPacketReader;
import io.dronefleet.mavlink.serialization.MavlinkSerializationException;
import io.dronefleet.mavlink.serialization.payload.MavlinkPayloadDeserializer;
import io.dronefleet.mavlink.serialization.payload.MavlinkPayloadSerializer;
import io.dronefleet.mavlink.serialization.payload.reflection.ReflectionPayloadDeserializer;
import io.dronefleet.mavlink.serialization.payload.reflection.ReflectionPayloadSerializer;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class MavlinkConnection {

    public static final class Builder {
        private final InputStream in;
        private final OutputStream out;
        private final Map<MavAutopilot, MavlinkDialect> dialects;

        private Builder(InputStream in, OutputStream out) {
            this.in = in;
            this.out = out;
            dialects = new HashMap<>();
            dialects.put(MavAutopilot.MAV_AUTOPILOT_SLUGS, MavlinkDialects.SLUGS);
            dialects.put(MavAutopilot.MAV_AUTOPILOT_ASLUAV, MavlinkDialects.ASLUAV);
            dialects.put(MavAutopilot.MAV_AUTOPILOT_AUTOQUAD, MavlinkDialects.AUTOQUAD);
            dialects.put(MavAutopilot.MAV_AUTOPILOT_ARDUPILOTMEGA, MavlinkDialects.ARDUPILOTMEGA);
        }

        public Builder dialect(MavAutopilot autopilot, MavlinkDialect dialect) {
            dialects.put(autopilot, dialect);
            return this;
        }

        public MavlinkConnection build() {
            return new MavlinkConnection(
                    new MavlinkPacketReader(in),
                    out,
                    dialects,
                    new ReflectionPayloadDeserializer(),
                    new ReflectionPayloadSerializer());
        }
    }

    public static Builder builder(InputStream in, OutputStream out) {
        return new Builder(in, out);
    }

    public static MavlinkConnection create(InputStream in, OutputStream out) {
        return builder(in,out).build();
    }

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
            MavlinkPayloadSerializer serializer) {
        this.reader = reader;
        this.out = out;
        this.dialects = dialects;
        this.deserializer = deserializer;
        this.serializer = serializer;
        systemDialects = new HashMap<>();
    }

    public MavlinkMessage next() throws IOException {
        while (reader.next()) {
            MavlinkPacket packet = reader.packet();

            // Get the dialect for the system that sent this packet. If we don't know which dialect it is,
            // or we don't support the dialect of its autopilot, then we use the common dialect.
            MavlinkDialect dialect = systemDialects.getOrDefault(packet.getSystemId(), MavlinkDialects.COMMON);

            // If the packet is not supported by the dialect, then we drop the packet and continue.
            // Unfortunately, because of the inadequate design of Mavlink's CRC validation which incorporates
            // information from underlying implementations that use the message protocol, we are unable to
            // check if the packet is actually a valid one, despite not understanding it.
            // So we have to assume that we might have received a corrupted packet, and instead, try again
            // the at next byte rather than skipping the entire message. This means that if the message was
            // actually valid, but simply not understood, we are going to spend N iterations for nothing for
            // each packet, where N is the amount of bytes per packet.
            // In other words, for the best performance, don't talk to MAVs who's dialects you do not support.
            if (!dialect.supports(packet.getMessageId())) {
                reader.drop();
                continue;
            }

            Class<?> messageType = dialect.resolve(packet.getMessageId());
            MavlinkMessageInfo messageInfo = messageType.getAnnotation(MavlinkMessageInfo.class);

            if (!packet.validate(messageInfo.crc())) {
                reader.drop();
                continue;
            }

            Object payload = deserializer.deserialize(packet.getPayload(), messageType);

            // If we received a Heartbeat message, then we can use that in order to update the dialect
            // for this system.
            if (payload instanceof Heartbeat) {
                Heartbeat heartbeat = (Heartbeat) payload;
                if (dialects.containsKey(heartbeat.autopilot())) {
                    systemDialects.put(packet.getSystemId(), dialects.get(heartbeat.autopilot()));
                }
            }

            //noinspection unchecked
            return new MavlinkMessage(
                    packet.getSystemId(),
                    packet.getComponentId(),
                    payload);
        }

        throw new EOFException("End of stream");
    }

    public void send(MavlinkMessage message) {
        Object payload = message.getPayload();
        Class<?> payloadType = payload.getClass();

        if (!payloadType.isAnnotationPresent(MavlinkMessageInfo.class)) {
            throw new MavlinkSerializationException(payloadType.getName() + " is not annotated with @MavlinkMessageInfo");
        }

        MavlinkMessageInfo messageInfo = payloadType.getAnnotation(MavlinkMessageInfo.class);
        byte[] serializedPayload = serializer.serialize(message.getPayload());

        MavlinkPacket packet;
        if (message instanceof Mavlink2Message) {
            Mavlink2Message message2 = (Mavlink2Message) message;
            packet = MavlinkPacket.create(
                    message2.getIncompatibleFlags(),
                    message2.getCompatibleFlags(),
                    sequence++,
                    message2.getOriginSystemId(),
                    message2.getOriginComponentId(),
                    messageInfo.id(),
                    message2.getTargetSystemId(),
                    message2.getTargetComponentId(),
                    messageInfo.crc(),
                    serializedPayload,
                    message2.getSignature());
        } else {
            packet = MavlinkPacket.create(
                    sequence++,
                    message.getOriginSystemId(),
                    message.getOriginComponentId(),
                    messageInfo.id(),
                    messageInfo.crc(),
                    serializedPayload);
        }

        send(packet);
    }

    public MavlinkDialect getDialect(int systemId) {
        return systemDialects.get(systemId);
    }

    private synchronized void send(MavlinkPacket packet) {
        try {
            out.write(packet.getRawBytes());
        } catch (IOException e) {
            throw new MavlinkException(e);
        }
    }
}
