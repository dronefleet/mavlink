package io.dronefleet.mavlink;

import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.ardupilotmega.ArdupilotmegaDialect;
import io.dronefleet.mavlink.asluav.AsluavDialect;
import io.dronefleet.mavlink.autoquad.AutoquadDialect;
import io.dronefleet.mavlink.common.CommonDialect;
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
import io.dronefleet.mavlink.signing.SigningConfiguration;
import io.dronefleet.mavlink.slugs.SlugsDialect;
import io.dronefleet.mavlink.util.TimeProvider;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Represents a Mavlink connection. This class is responsible for mid-to-low-level function of Mavlink communication.
 * A {@code MavlinkConnection} is responsible for the following responsibilities:</p>
 * <ul>
 *      <li>Serialization of Mavlink messages.</li>
 *      <li>Tracking and resolving dialects of systems that are available through the connection.</li>
 *      <li>Low level validation of packets.</li>
 * </ul>
 *
 * <p>This class doesn't provide any features other than the simple means of sending/reading and ensuring the validity
 * of messages in terms of transmission and protocol. Higher level features of the protocol, such as message signings
 * should be implemented by users of this class.</p>
 */
public class MavlinkConnection {

    /**
     * Builds MavlinkConnection instances.
     */
    public static final class Builder {
        private final InputStream in;
        private final OutputStream out;
        private final Map<MavAutopilot, MavlinkDialect> dialects;
        private SigningConfiguration signingConfiguration;
        private TimeProvider timeProvider;

        private Builder(InputStream in, OutputStream out) {
            this.in = in;
            this.out = out;
            dialects = new HashMap<>();
            dialects.put(MavAutopilot.MAV_AUTOPILOT_SLUGS, new SlugsDialect());
            dialects.put(MavAutopilot.MAV_AUTOPILOT_ASLUAV, new AsluavDialect());
            dialects.put(MavAutopilot.MAV_AUTOPILOT_AUTOQUAD, new AutoquadDialect());
            dialects.put(MavAutopilot.MAV_AUTOPILOT_ARDUPILOTMEGA, new ArdupilotmegaDialect());
            this.timeProvider = TimeProvider.SYSTEM_CLOCK;
        }

        /**
         * Adds a dialect entry to this builder. The added dialect will then become supported
         * by the built connection.
         * @param autopilot The autopilot to associate the dialect with.
         * @param dialect   The dialect to associate.
         * @return  This builder.
         */
        public Builder dialect(MavAutopilot autopilot, MavlinkDialect dialect) {
            dialects.put(autopilot, dialect);
            return this;
        }

        /**
         * Sets the signing configuration for this builder. The built connection will then use
         * the specified configuration in order to sign Mavlink2 messages. Using this feature require
         * requires implementations using the produced MavlinkConnection to send
         * {@link io.dronefleet.mavlink.common.SetupSigning} requests prior to sending Mavlink2 messages.
         * @param configuration The signing configuration to use when signing Mavlink2 messages.
         * @return  This builder.
         */
        public Builder signing(SigningConfiguration configuration) {
            signingConfiguration = configuration;
            return this;
        }

        /**
         * The time provider to use when querying for the current time. The default value is
         * {@link TimeProvider#SYSTEM_CLOCK} which uses the {@code java.time} package in order to
         * get the actual current time.
         * @param timeProvider  The time provider to use.
         * @return  This builder.
         */
        public Builder timeProvider(TimeProvider timeProvider) {
            this.timeProvider = timeProvider;
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
                    new ReflectionPayloadSerializer(), signingConfiguration, timeProvider);
        }
    }

    /**
     * The default dialect for systems which have not yet been associated
     * with a specific dialect.
     */
    private static MavlinkDialect COMMON_DIALECT = new CommonDialect();

    /**
     * Creates a new builder for the specified input/output streams.
     * @param in    The input stream to read messages from.
     * @param out   The output stream to write messages to.
     * @return  A builder instance for the specified settings.
     */
    public static Builder builder(InputStream in, OutputStream out) {
        return new Builder(in, out);
    }

    /**
     * Creates a default connection instance. The result of calling this method
     * is equivalent to calling {@code builder(in,out).build()}.
     * @param in    The input stream to read messages from.
     * @param out   The output stream to write messages to.
     * @return A builder instance for the specified settings.
     */
    public static MavlinkConnection create(InputStream in, OutputStream out) {
        return builder(in,out).build();
    }

    /**
     * A mapping of system IDs and their dialects. Entries are added to this map
     * when heartbeats are received.
     */
    private final Map<Integer, MavlinkDialect> systemDialects;

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
     * The signing configuration to use when sending Mavlink2 packets, or {@code null}
     * if packets should not be signed.
     */
    private final SigningConfiguration signingConfiguration;

    /**
     * A time provider to use for signing.
     */
    private final TimeProvider timeProvider;

    /**
     * The last timestamp used when signing.
     */
    private long lastSignatureTimestamp;

    MavlinkConnection(
            MavlinkPacketReader reader,
            OutputStream out,
            Map<MavAutopilot, MavlinkDialect> dialects,
            MavlinkPayloadDeserializer deserializer,
            MavlinkPayloadSerializer serializer,
            SigningConfiguration signingConfiguration,
            TimeProvider timeProvider) {
        this.reader = reader;
        this.out = out;
        this.dialects = dialects;
        this.deserializer = deserializer;
        this.serializer = serializer;
        this.signingConfiguration = signingConfiguration;
        this.timeProvider = timeProvider;
        systemDialects = new HashMap<>();
        if (isSigningEnabled()) {
            lastSignatureTimestamp = signingConfiguration.getTimestamp();
        }
    }

    /**
     * <p>Reads a single message from this connection. This method drops messages, attempting to read the next
     * message when given the following conditions:</p>
     *
     * <ul>
     *     <li>The currently configured dialect for the origin system does not support the received message.</li>
     *     <li>The received message failed to pass CRC validation.</li>
     * </ul>
     *
     * <p>When a heartbeat is read, this method resolves the dialect of the originating system by using the
     * dialect map that was specified when this connection was constructed. The resolved dialect will then be used
     * when evaluating the next messages received from that system.</p>
     *
     * <p>When receiving messages from an origin which dialect is unknown or unsupported -- Such as before receiving
     * a heartbeat, or if the autopilot of the heartbeat is unrecognized, this method defaults to using the
     * {@link io.dronefleet.mavlink.common.CommonDialect common} dialect.</p>
     *
     * @return  The next supported and valid Mavlink message.
     * @throws EOFException When the stream ends.
     * @throws IOException If there has been an error reading from the stream.
     */
    public MavlinkMessage next() throws IOException {
        while (reader.next()) {
            MavlinkPacket packet = reader.packet();

            // Get the dialect for the system that sent this packet. If we don't know which dialect it is,
            // or we don't support the dialect of its autopilot, then we use the common dialect.
            MavlinkDialect dialect = systemDialects.getOrDefault(packet.getSystemId(), COMMON_DIALECT);

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

            if (!packet.validateCrc(messageInfo.crc())) {
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

    /**
     * Sends the specified message to the output stream of this connection.
     * @param message   The message to send. The specified message could be either a {@link MavlinkMessage mavlink1 message}
     *                  or a {@link Mavlink2Message mavlink2 message}.
     */
    public synchronized void send(MavlinkMessage message) {
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
                    serializedPayload);

            if (isSigningEnabled()) {
                lastSignatureTimestamp = Math.max(
                        timeProvider.microsSince1stJan2015GMT() / 10,
                        lastSignatureTimestamp + 1);
                packet = packet.sign(
                        signingConfiguration.getLinkId(),
                        lastSignatureTimestamp,
                        signingConfiguration.getSecretKey());
            }
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

    /**
     * Whether or not signing is enabled for this connection.
     * @see #getSigningConfiguration()
     */
    public boolean isSigningEnabled() {
        return signingConfiguration != null;
    }

    /**
     * Returns this connection's signing configuration. The returned configuration includes the last timestamp
     * which has been used for signing by this connection.
     * @throws IllegalStateException if signing is not enabled for this connection.
     * @see #isSigningEnabled()
     */
    public SigningConfiguration getSigningConfiguration() {
        if (signingConfiguration == null) {
            throw new IllegalStateException("Signing is not enabled for this connection");
        }
        return new SigningConfiguration(
                Math.max(lastSignatureTimestamp, signingConfiguration.getTimestamp()),
                signingConfiguration.getLinkId(),
                signingConfiguration.getSecretKey());
    }

    /**
     * Resolves the dialect of the specified system by its ID. This method relies on that
     * a heartbeat has previously been received for the system for which the dialect is
     * requested.
     * @param systemId  The ID of the system for which dialect resolution is requested.
     * @return  The dialect of the system of the specified ID, or {@code null} if a
     *          heartbeat has not yet been received for that system or if there is no
     *          dialect configured for that system's autopilot.
     */
    public MavlinkDialect getDialect(int systemId) {
        return systemDialects.get(systemId);
    }

    /**
     * Sends the specified packet directly to the stream.
     * @param packet    The packet to send.
     */
    private void send(MavlinkPacket packet) {
        try {
            out.write(packet.getRawBytes());
        } catch (IOException e) {
            throw new MavlinkException(e);
        }
    }
}
