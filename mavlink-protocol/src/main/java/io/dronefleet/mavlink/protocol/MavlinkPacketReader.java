package io.dronefleet.mavlink.protocol;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class MavlinkPacketReader {

    public static void main(String args[]) throws IOException {
        Socket socket = new Socket("127.0.0.1", 5762);
        MavlinkPacketReader reader = new MavlinkPacketReader(socket.getInputStream());

        while (reader.next()) {
            System.out.println(reader.packet());
        }
    }

    private final MavlinkFrameReader in;

    public MavlinkPacketReader(InputStream in) {
        this.in = new MavlinkFrameReader(in);
    }

    public boolean next() throws IOException {
        return in.next();
    }

    public MavlinkPacket packet() throws IOException {
        byte[] frame = in.frame();
        if (frame[0] == (byte) MavlinkPacket.MAGIC_V1) {
            return MavlinkPacket.fromV1Bytes(frame);
        }
        if (frame[0] == (byte) MavlinkPacket.MAGIC_V2) {
            return MavlinkPacket.fromV2Bytes(frame);
        }
        throw new MavlinkException("Unknown version marker 0x" + Integer.toHexString(frame[0]));
    }

    public void drop() throws IOException {
        in.drop();
    }

    private EOFException eof() throws EOFException {
        throw new EOFException("Reached end of stream");
    }
}
