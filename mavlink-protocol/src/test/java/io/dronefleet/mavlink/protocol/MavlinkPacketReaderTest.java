package io.dronefleet.mavlink.protocol;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class MavlinkPacketReaderTest {

    @Test
    public void itCanReadMaximumSizedMavlink2Packet() throws IOException {
        MavlinkPacket expected = MavlinkPacket.createSignedMavlink2Packet(
                0, 0, 0, 0, 0, new byte[255], 0, 0, new byte[32]);

        InputStream in = new ByteArrayInputStream(expected.getRawBytes());
        MavlinkPacketReader reader = new MavlinkPacketReader(in);
        MavlinkPacket actual = reader.next();

        assertEquals(expected, actual);
    }
}