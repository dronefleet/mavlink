package io.dronefleet.mavlink.protocol;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class MavlinkPacketReader {
    private final MavlinkFrameReader in;

    public MavlinkPacketReader(InputStream in) {
        this.in = new MavlinkFrameReader(in);
    }

    public MavlinkPacket next() throws IOException {
        while (in.next()) {
            byte[] frame = in.frame();
            switch (frame[0] & 0xff) {
                case MavlinkPacket.MAGIC_V1: return MavlinkPacket.fromV1Bytes(frame);
                case MavlinkPacket.MAGIC_V2: return MavlinkPacket.fromV2Bytes(frame);
            }

            // The frame did not begin with a magic marker that we understand.
            in.drop();
        }
        throw new EOFException("End of stream");
    }

    public void drop() throws IOException {
        in.drop();
    }
}
