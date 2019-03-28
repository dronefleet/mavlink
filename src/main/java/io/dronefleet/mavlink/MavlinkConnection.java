package io.dronefleet.mavlink;

import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.ardupilotmega.ArdupilotmegaDialect;
import io.dronefleet.mavlink.asluav.AsluavDialect;
import io.dronefleet.mavlink.autoquad.AutoquadDialect;
import io.dronefleet.mavlink.common.CommonDialect;
import io.dronefleet.mavlink.common.Heartbeat;
import io.dronefleet.mavlink.common.MavAutopilot;
import io.dronefleet.mavlink.paparazzi.PaparazziDialect;
import io.dronefleet.mavlink.protocol.MavlinkPacket;
import io.dronefleet.mavlink.protocol.MavlinkPacketReader;
import io.dronefleet.mavlink.serialization.payload.MavlinkPayloadDeserializer;
import io.dronefleet.mavlink.serialization.payload.MavlinkPayloadSerializer;
import io.dronefleet.mavlink.serialization.payload.reflection.ReflectionPayloadDeserializer;
import io.dronefleet.mavlink.serialization.payload.reflection.ReflectionPayloadSerializer;
import io.dronefleet.mavlink.slugs.SlugsDialect;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>Represents a Mavlink connection. This class is responsible for mid-to-low-level function of Mavlink communication.
 * A {@code MavlinkConnection} is responsible for the following:</p>
 * <ul>
 * <li>Serialization of Mavlink messages.</li>
 * <li>Tracking and resolving dialects of systems that are available through the connection.</li>
 * <li>CRC validation of packets.</li>
 * </ul>
 */
public class MavlinkConnection {
    /**
     * Builds MavlinkConnection instances.
     */
    public static final class Builder {
        private final InputStream in;
        private final OutputStream out;
        private final Map<MavAutopilot, MavlinkDialect> dialects;

        private Builder(InputStream in, OutputStream out) {
            this.in = in;
            this.out = out;
            dialects = new HashMap<>();
            dialect(MavAutopilot.MAV_AUTOPILOT_GENERIC, new CommonDialect())
                    .dialect(MavAutopilot.MAV_AUTOPILOT_AEROB, new CommonDialect())
                    .dialect(MavAutopilot.MAV_AUTOPILOT_AIRRAILS, new CommonDialect())
                    .dialect(MavAutopilot.MAV_AUTOPILOT_UDB, new CommonDialect())
                    .dialect(MavAutopilot.MAV_AUTOPILOT_SMARTAP, new CommonDialect())
                    .dialect(MavAutopilot.MAV_AUTOPILOT_SMACCMPILOT, new CommonDialect())
                    .dialect(MavAutopilot.MAV_AUTOPILOT_OPENPILOT, new CommonDialect())
                    .dialect(MavAutopilot.MAV_AUTOPILOT_FP, new CommonDialect())
                    .dialect(MavAutopilot.MAV_AUTOPILOT_ARDUPILOTMEGA, new ArdupilotmegaDialect())
                    .dialect(MavAutopilot.MAV_AUTOPILOT_PX4, new ArdupilotmegaDialect())
                    .dialect(MavAutopilot.MAV_AUTOPILOT_AUTOQUAD, new AutoquadDialect())
                    .dialect(MavAutopilot.MAV_AUTOPILOT_ASLUAV, new AsluavDialect())
                    .dialect(MavAutopilot.MAV_AUTOPILOT_SLUGS, new SlugsDialect())
                    .dialect(MavAutopilot.MAV_AUTOPILOT_AUTOQUAD, new AutoquadDialect())
                    .dialect(MavAutopilot.MAV_AUTOPILOT_PPZ, new PaparazziDialect());
        }

        /**
         * Adds a dialect entry to this builder. The added dialect will then become supported
         * by the built connection.
         *
         * @param autopilot The autopilot to associate the dialect with.
         * @param dialect   The dialect to associate.
         * @return This builder.
         */
        public Builder dialect(MavAutopilot autopilot, MavlinkDialect dialect) {
            dialects.put(autopilot, dialect);
            return this;
        }

        /**
         * Builds a ready to use connection instance.
         */
        public MavlinkConnection build() {
            return new MavlinkConnection(
                    new MavlinkPacketReader(in),
                    out,
                    dialects,
                    new ReflectionPayloadDeserializer(),
                    new ReflectionPayloadSerializer()
            );
        }
    }

    /**
     * The default dialect for systems which have not yet been associated
     * with a specific dialect.
     */
    private static MavlinkDialect COMMON_DIALECT = new CommonDialect();

    /**
     * Creates a new builder for the specified input/output streams.
     *
     * @param in  The input stream to read messages from.
     * @param out The output stream to write messages to.
     * @return A builder instance for the specified settings.
     */
    public static Builder builder(InputStream in, OutputStream out) {
        return new Builder(in, out);
    }

    /**
     * Creates a default connection instance. The result of calling this method
     * is equivalent to calling {@code builder(in,out).build()}.
     *
     * @param in  The input stream to read messages from.
     * @param out The output stream to write messages to.
     * @return A builder instance for the specified settings.
     */
    public static MavlinkConnection create(InputStream in, OutputStream out) {
        return builder(in, out).build();
    }

    /**
     * A mapping of system IDs and their dialects. Entries are added to this map
     * when heartbeats are received.
     */
    private final Map<Integer, MavlinkDialect> systemDialects;

    /**
     * A list of default dialects used for decoding packets.
     */
    private final List<MavlinkDialect> defaultDialects;

    /**
     * The current send sequence of this connection.
     */
    private int sequence;

    /**
     * The reader that this connection reads messages from.
     */
    private final MavlinkPacketReader reader;

    /**
     * The output stream that this connection writes messages to.
     */
    private final OutputStream out;

    /**
     * A mapping of autopilot types and their associated dialects. This is used
     * in order to calculate the dialect of a system when a heartbeat is
     * received.
     */
    private final Map<MavAutopilot, MavlinkDialect> dialects;

    /**
     * The payload deserializer that this connection uses in order to deserialize
     * message payloads.
     */
    private final MavlinkPayloadDeserializer deserializer;

    /**
     * The serializer that this connection uses in order to serialize message payloads.
     */
    private final MavlinkPayloadSerializer serializer;

    /**
     * Locks calls to {@link #next()} to ensure no concurrent reads occur.
     */
    private final Lock readLock;

    /**
     * Locks write calls to ensure no concurrent writes.
     */
    private final Lock writeLock;

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
        defaultDialects = new ArrayList<>();
        readLock = new ReentrantLock();
        writeLock = new ReentrantLock();
    }

    /**
     * Adds a default dialect. The added dialect will be used to decode the packets
     * without relying on detecting dialects by heartbeat.
     *
     * @param dialect The dialect to add.
     * @return This Mavlink connection.
     */
    public MavlinkConnection addDefaultDialect(MavlinkDialect dialect) {
        defaultDialects.add(dialect);
        return this;
    }

    /**
     * <p>Reads a single message from this connection. This method drops messages, attempting to read the next
     * message when given the following conditions:</p>
     * <p>
     * <ul>
     * <li>The currently configured dialect for the origin system does not support the received message.</li>
     * <li>The received message failed to pass CRC validation.</li>
     * </ul>
     * <p>
     * <p>When a heartbeat is read, this method resolves the dialect of the originating system by using the
     * dialect map that was specified when this connection was constructed. The resolved dialect will then be used
     * when evaluating the next messages received from that system.</p>
     * <p>
     * <p>When receiving messages from an origin which dialect is unknown or unsupported -- Such as before receiving
     * a heartbeat, or if the autopilot of the heartbeat is unrecognized, this method defaults to using the
     * {@link io.dronefleet.mavlink.common.CommonDialect common} dialect.</p>
     *
     * @return The next supported and valid Mavlink message.
     * @throws EOFException When the stream ends.
     * @throws IOException  If there has been an error reading from the stream.
     */
    public MavlinkMessage next() throws IOException {
        readLock.lock();
        try {
            MavlinkPacket packet;
            while ((packet = reader.next()) != null) {
                // Get the dialect for the system that sent this packet. If we don't know which dialect it is,
                // or we don't support the dialect of its autopilot, then we use the common dialect.
                MavlinkDialect dialect = systemDialects.getOrDefault(packet.getSystemId(), COMMON_DIALECT);

                // Try to get supported dialect from default dialects
                // instead of system dialects which are detected from heartbeat
                for (MavlinkDialect mavlinkDialect:defaultDialects){
                    if (mavlinkDialect.supports(packet.getMessageId())){
                        dialect = mavlinkDialect;
                        break;
                    }
                }

                // If the packet is not supported by the dialect, then we drop the packet and continue.
                // Unfortunately, because of the inadequate design of Mavlink's CRC validation which incorporates
                // information from underlying implementations that use the message protocol, we are unable to
                // check if the packet is actually a valid one, despite not understanding it.
                // So we have to assume that we might have received a corrupted packet, and instead, try again
                // at the next byte rather than skipping the entire message.
                if (!dialect.supports(packet.getMessageId())) {
                    reader.drop();
                    continue;
                }

                // Get the message type and deserialize the payload.
                Class<?> messageType = dialect.resolve(packet.getMessageId());
                MavlinkMessageInfo messageInfo = messageType.getAnnotation(MavlinkMessageInfo.class);
                if (!packet.validateCrc(messageInfo.crc())) {
                    // This packet did not pass CRC validation. It may be dropped.
                    reader.drop();
                    continue;
                }
                Object payload = deserializer.deserialize(packet.getPayload(), messageType);

                // If we received a Heartbeat message, then we can use that in order to update the dialect
                // for this system.
                if (payload instanceof Heartbeat) {
                    Heartbeat heartbeat = (Heartbeat) payload;
                    if (dialects.containsKey(heartbeat.autopilot().entry())) {
                        systemDialects.put(packet.getSystemId(), dialects.get(heartbeat.autopilot().entry()));
                    }
                }

                if (packet.isMavlink2()) {
                    //noinspection unchecked
                    return new Mavlink2Message(packet, payload);
                } else {
                    //noinspection unchecked
                    return new MavlinkMessage(packet, payload);
                }
            }

            throw new EOFException("End of stream");
        } finally {
            readLock.unlock();
        }
    }

    /**
     * Sends a Mavlink 1 message using the specified settings.
     *
     * @param systemId    The system ID that originated this message.
     * @param componentId The component ID that originated this message.
     * @param payload     The payload to send.
     * @throws IOException if an I/O error occurs.
     */
    public void send1(int systemId, int componentId, Object payload) throws IOException {
        MavlinkMessageInfo messageInfo = payload.getClass()
                .getAnnotation(MavlinkMessageInfo.class);
        byte[] serializedPayload = serializer.serialize(payload);
        writeLock.lock();
        try {
            send(MavlinkPacket.createMavlink1Packet(
                    sequence++,
                    systemId,
                    componentId,
                    messageInfo.id(),
                    messageInfo.crc(),
                    serializedPayload));
        } finally {
            writeLock.unlock();
        }
    }

    /**
     * Sends an unsigned Mavlink 2 message using the specified settings.
     *
     * @param systemId    The system ID that originated this message.
     * @param componentId The component ID that originated this message.
     * @param payload     The payload to send.
     * @throws IOException if an I/O error occurs.
     */
    public void send2(int systemId, int componentId, Object payload) throws IOException {
        MavlinkMessageInfo messageInfo = payload.getClass()
                .getAnnotation(MavlinkMessageInfo.class);
        byte[] serializedPayload = serializer.serialize(payload);
        writeLock.lock();
        try {
            send(MavlinkPacket.createUnsignedMavlink2Packet(
                    sequence++,
                    systemId,
                    componentId,
                    messageInfo.id(),
                    messageInfo.crc(),
                    serializedPayload));
        } finally {
            writeLock.unlock();
        }
    }

    /**
     * Sends a signed Mavlink 2 message using the specified settings.
     *
     * @param systemId    The system ID that originated this message.
     * @param componentId The component ID that originated this message.
     * @param payload     The payload to send.
     * @param linkId      The link ID to use when signing.
     * @param timestamp   The timestamp to use when signing.
     * @param secretKey   The secret key to use when signing.
     * @throws IOException if an I/O error occurs.
     */
    public void send2(int systemId, int componentId, Object payload, int linkId,
                      long timestamp, byte[] secretKey) throws IOException {
        MavlinkMessageInfo messageInfo = payload.getClass()
                .getAnnotation(MavlinkMessageInfo.class);
        byte[] serializedPayload = serializer.serialize(payload);
        writeLock.lock();
        try {
            send(MavlinkPacket.createSignedMavlink2Packet(
                    sequence++,
                    systemId,
                    componentId,
                    messageInfo.id(),
                    messageInfo.crc(),
                    serializedPayload,
                    linkId,
                    timestamp,
                    secretKey));
        } finally {
            writeLock.unlock();
        }
    }

    /**
     * Resolves the dialect of the specified system by its ID. This method relies on that
     * a heartbeat has previously been received for the system for which the dialect is
     * requested.
     *
     * @param systemId The ID of the system for which dialect resolution is requested.
     * @return The dialect of the system of the specified ID, or {@code null} if a
     * heartbeat has not yet been received for that system or if there is no
     * dialect configured for that system's autopilot.
     */
    public MavlinkDialect getDialect(int systemId) {
        return systemDialects.get(systemId);
    }

    /**
     * Sends the specified packet directly to the stream.
     *
     * @param packet The packet to send.
     */
    private void send(MavlinkPacket packet) throws IOException {
        out.write(packet.getRawBytes());
    }
}
