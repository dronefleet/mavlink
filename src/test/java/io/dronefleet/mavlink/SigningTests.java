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

    private static final MavlinkPayloadSerializer serializer = new ReflectionPayloadSerializer();

    @Test
    public void signedPacketsPassCLibrarySigningCheck() throws NoSuchAlgorithmException {
        byte[] secretKey = MessageDigest.getInstance("SHA-256")
                .digest("test".getBytes(StandardCharsets.UTF_8));

        MavlinkPacket packet = MavlinkPacket.createSignedMavlink2Packet(1, 255, 0, 0, 50,
                serializer.serialize(Heartbeat.builder()
                        .type(MavType.MAV_TYPE_GCS)
                        .autopilot(MavAutopilot.MAV_AUTOPILOT_INVALID)
                        .systemStatus(MavState.MAV_STATE_UNINIT)
                        .mavlinkVersion(3)
                        .build()),
                1, 123456L, secretKey);

        boolean result = CLibraryTestTool.signatureCheck(
                packet.getSignatureLinkId(),
                packet.getSignatureTimestamp(),
                secretKey,
                packet.getRawBytes());

        assertTrue(result);
    }

    @Test
    public void cLibraryFailsSigningCheckWithWrongSecretKey() throws NoSuchAlgorithmException {
        byte[] secretKey = MessageDigest.getInstance("SHA-256")
                .digest("test".getBytes(StandardCharsets.UTF_8));

        MavlinkPacket packet = MavlinkPacket.createSignedMavlink2Packet(1, 255, 0, 0, 50,
                serializer.serialize(Heartbeat.builder()
                        .type(MavType.MAV_TYPE_GCS)
                        .autopilot(MavAutopilot.MAV_AUTOPILOT_INVALID)
                        .systemStatus(MavState.MAV_STATE_UNINIT)
                        .mavlinkVersion(3)
                        .build()),
                1, 123456L, secretKey);

        // shift the array 1 byte to the left
        System.arraycopy(secretKey, 1, secretKey, 0, secretKey.length - 1);

        boolean result = CLibraryTestTool.signatureCheck(
                packet.getSignatureLinkId(),
                packet.getSignatureTimestamp(),
                secretKey,
                packet.getRawBytes());

        assertFalse(result);
    }

    @Test
    public void validateSignatureReturnsTrueForSignedPacket() throws NoSuchAlgorithmException {
        byte[] secretKey = MessageDigest.getInstance("SHA-256")
                .digest("test".getBytes(StandardCharsets.UTF_8));

        MavlinkPacket packet = MavlinkPacket.createSignedMavlink2Packet(1, 255, 0, 0, 50,
                serializer.serialize(Heartbeat.builder()
                        .type(MavType.MAV_TYPE_GCS)
                        .autopilot(MavAutopilot.MAV_AUTOPILOT_INVALID)
                        .systemStatus(MavState.MAV_STATE_UNINIT)
                        .mavlinkVersion(3)
                        .build()),
                1, 123456L, secretKey);

        assertTrue(packet.validateSignature(secretKey));
    }

    @Test
    public void validateSignatureReturnsFalseForInvalidSecretKey() throws NoSuchAlgorithmException {
        byte[] secretKey = MessageDigest.getInstance("SHA-256")
                .digest("test".getBytes(StandardCharsets.UTF_8));

        MavlinkPacket packet = MavlinkPacket.createSignedMavlink2Packet(1, 255, 0, 0, 50,
                serializer.serialize(Heartbeat.builder()
                        .type(MavType.MAV_TYPE_GCS)
                        .autopilot(MavAutopilot.MAV_AUTOPILOT_INVALID)
                        .systemStatus(MavState.MAV_STATE_UNINIT)
                        .mavlinkVersion(3)
                        .build()),
                1, 123456L, secretKey);

        // shift the array 1 byte to the left
        System.arraycopy(secretKey, 1, secretKey, 0, secretKey.length - 1);

        assertFalse(packet.validateSignature(secretKey));
    }

    @Test
    public void validateSignatureReturnsFalseForUnsignedPacket() throws NoSuchAlgorithmException {
        byte[] secretKey = MessageDigest.getInstance("SHA-256")
                .digest("test".getBytes(StandardCharsets.UTF_8));

        MavlinkPacket packet = MavlinkPacket.createUnsignedMavlink2Packet(1, 255, 0, 0, 50,
                serializer.serialize(Heartbeat.builder()
                        .type(MavType.MAV_TYPE_GCS)
                        .autopilot(MavAutopilot.MAV_AUTOPILOT_INVALID)
                        .systemStatus(MavState.MAV_STATE_UNINIT)
                        .mavlinkVersion(3)
                        .build()));

        assertFalse(packet.validateSignature(secretKey));
    }

}
