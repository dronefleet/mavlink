package io.dronefleet.mavlink.protocol;


import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MavlinkPacketTest {
    @Test
    public void validateSignatureReturnsTrueForSignedPacket() throws NoSuchAlgorithmException {
        MavlinkPacket packet = MavlinkPacket.create(
                0,
                0,
                3,
                4,
                5,
                6,
                7,
                new byte[] {1,2,3,4,5,6,7,8,9},
                null);
        byte[] secretKey = MessageDigest.getInstance("SHA-1").digest("test".getBytes(StandardCharsets.UTF_8));
        packet = packet.sign(1, 123456L, secretKey);

        assertTrue(packet.validateSignature(
                packet.getSignedLinkId(),
                packet.getSignedTimestamp(),
                secretKey));
    }

    @Test
    public void validateSignatureReturnsFalseForUnsignedPacket() throws NoSuchAlgorithmException {
        MavlinkPacket packet = MavlinkPacket.create(
                0,
                0,
                3,
                4,
                5,
                6,
                7,
                new byte[] {1,2,3,4,5,6,7,8,9},
                null);
        byte[] secretKey = MessageDigest.getInstance("SHA-1")
                .digest("test".getBytes(StandardCharsets.UTF_8));

        assertFalse(packet.validateSignature(
                packet.getSignedLinkId(),
                packet.getSignedTimestamp(),
                secretKey));
    }
}