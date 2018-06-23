package io.dronefleet.mavlink.protocol;


import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MavlinkPacketTest {
    @Test
    public void test() {
        MavlinkPacket packet = MavlinkPacket.create(5,4,3,2, 1, new byte[] {1,2,3,4,5});
        MavlinkPacket packet2 = MavlinkPacket.fromV1Bytes(packet.getRawBytes());

        System.out.println(Arrays.toString(packet.getRawBytes()));
        assertEquals(packet, packet2);
    }
}