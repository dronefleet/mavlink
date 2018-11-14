package io.dronefleet.mavlink;

import io.dronefleet.mavlink.common.Heartbeat;
import io.dronefleet.mavlink.common.MavAutopilot;
import io.dronefleet.mavlink.common.MavState;
import io.dronefleet.mavlink.common.MavType;
import io.dronefleet.mavlink.protocol.MavlinkPacket;
import io.dronefleet.mavlink.serialization.payload.MavlinkPayloadSerializer;
import io.dronefleet.mavlink.serialization.payload.reflection.ReflectionPayloadSerializer;
import io.dronefleet.mavlink.testtool.CLibraryTestTool;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SigningTests {

    @Test
    public void signedPacketsPassCLibrarySigningCheck() throws NoSuchAlgorithmException {
        MavlinkPacket packet = createUnsignedHeartbeatPacket();
        byte[] secretKey = MessageDigest.getInstance("SHA-256")
                .digest("test".getBytes(StandardCharsets.UTF_8));
        packet = packet.sign(1, 123456L, secretKey);

        boolean result = CLibraryTestTool.signatureCheck(
                packet.getSignedLinkId(),
                packet.getSignedTimestamp(),
                secretKey,
                packet.getRawBytes());

        assertTrue(result);
    }

    @Test
    public void validateSignatureReturnsTrueForSignedPacket() throws NoSuchAlgorithmException {
        MavlinkPacket packet = createUnsignedHeartbeatPacket();
        byte[] secretKey = MessageDigest.getInstance("SHA-256")
                .digest("test".getBytes(StandardCharsets.UTF_8));
        packet = packet.sign(1, 123456L, secretKey);

        assertTrue(packet.validateSignature(
                packet.getSignedLinkId(),
                packet.getSignedTimestamp(),
                secretKey));
    }

    @Test
    public void validateSignatureReturnsFalseForInvalidSecretKey() throws NoSuchAlgorithmException {
        MavlinkPacket packet = createUnsignedHeartbeatPacket();
        byte[] secretKey = MessageDigest.getInstance("SHA-256")
                .digest("test".getBytes(StandardCharsets.UTF_8));
        packet = packet.sign(1, 123456L, secretKey);

        // shift the array 1 byte to the left
        System.arraycopy(secretKey, 1, secretKey, 0, secretKey.length - 1);

        assertFalse(packet.validateSignature(
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
                new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9},
                null);
        byte[] secretKey = MessageDigest.getInstance("SHA-256")
                .digest("test".getBytes(StandardCharsets.UTF_8));

        assertFalse(packet.validateSignature(
                packet.getSignedLinkId(),
                packet.getSignedTimestamp(),
                secretKey));
    }

    private MavlinkPacket createUnsignedHeartbeatPacket() {
        MavlinkPayloadSerializer payloadDeserializer = new ReflectionPayloadSerializer();
        return MavlinkPacket.create(
                1,
                0,
                1,
                255,
                0,
                0,
                50,
                payloadDeserializer.serialize(Heartbeat.builder()
                        .type(MavType.MAV_TYPE_GCS)
                        .autopilot(MavAutopilot.MAV_AUTOPILOT_INVALID)
                        .systemStatus(MavState.MAV_STATE_UNINIT)
                        .mavlinkVersion(3)
                        .build()));
    }

}
