package io.dronefleet.mavlink.protocol;

import java.io.IOException;
import java.io.InputStream;

public class MavlinkFrameReader {
    private final TransactionalInputStream in;

    public MavlinkFrameReader(InputStream in) {
        this.in = new TransactionalInputStream(in, 279);
    }

    public boolean next() throws IOException {
        int versionMarker;
        int payloadLength;
        int incompatibleFlags;

        in.commit();
        while ((versionMarker = in.read()) != -1) {
            if ((payloadLength = in.read()) == -1) {
                return false;
            }
            switch (versionMarker) {
                case MavlinkPacket.MAGIC_V1:
                    return in.advance(6 + payloadLength);
                case MavlinkPacket.MAGIC_V2:
                    return (incompatibleFlags = in.read()) != -1
                            && in.advance(11 + payloadLength + (incompatibleFlags & 1) * 13);
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
