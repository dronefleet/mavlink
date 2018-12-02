package io.dronefleet.mavlink.protocol;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/**
 * <p>
 * Reads Mavlink protocol packets from an {@link InputStream}.
 * <p>
 * The packets read by this class are not CRC checked, and may not be valid. Users of this class
 * should {@link MavlinkPacket#validateCrc(int) validate packet CRC}s and {@link #drop() drop}
 * packets which do not pass validation. Doing so ensures that no invalid packets are processed,
 * and that valid packets are not skipped in favor of invalid packets.
 */
public class MavlinkPacketReader {
    private final MavlinkFrameReader in;

    /**
     * Constructs a new reader for the specified {@link InputStream}
     *
     * @param in The input stream to read from.
     */
    public MavlinkPacketReader(InputStream in) {
        this.in = new MavlinkFrameReader(in);
    }

    /**
     * Reads the next packet from the stream.
     *
     * @throws IOException  if an IO error occurs.
     * @throws EOFException if reached the end of stream.
     */
    public MavlinkPacket next() throws IOException {
        while (in.next()) {
            byte[] frame = in.frame();
            switch (frame[0] & 0xff) {
                case MavlinkPacket.MAGIC_V1:
                    return MavlinkPacket.fromV1Bytes(frame);
                case MavlinkPacket.MAGIC_V2:
                    return MavlinkPacket.fromV2Bytes(frame);
            }

            // The frame did not begin with a magic marker that we understand.
            in.drop();
        }
        throw new EOFException("End of stream");
    }

    /**
     * Drops the last read packet, returning its bytes to the stream skipping the first byte.
     *
     * @throws IOException if an IO error occurs.
     */
    public void drop() throws IOException {
        in.drop();
    }
}
