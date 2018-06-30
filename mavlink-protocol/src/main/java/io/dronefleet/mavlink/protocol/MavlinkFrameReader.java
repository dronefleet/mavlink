package io.dronefleet.mavlink.protocol;

import java.io.IOException;
import java.io.InputStream;

public class MavlinkFrameReader {
    private final TransactionalInputStream in;

    public MavlinkFrameReader(InputStream in) {
        this.in = new TransactionalInputStream(in, 1024);
    }

    public boolean next() throws IOException {
        int versionMarker;
        int payloadLength;

        in.commit();
        while ((versionMarker = in.read()) != -1) {
            if ((payloadLength = in.read()) == -1) {
                return false;
            }
            switch (versionMarker) {
                case MavlinkPacket.MAGIC_V1:
                    return in.advance(6 + payloadLength);
                case MavlinkPacket.MAGIC_V2:
                    return in.advance(25 + payloadLength);
                default:
                    in.rollback();
                    in.skip(1);
                    in.commit();
            }
        }
        return false;
    }

    public byte[] frame() {
        return in.getBuffer();
    }

    public void drop() throws IOException {
        in.rollback();
        in.skip(1);
        in.commit();
    }
}
