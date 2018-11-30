package io.dronefleet.mavlink;

import io.dronefleet.mavlink.common.Heartbeat;
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

public class CrcTests {

    private static final MavlinkPayloadSerializer serializer = new ReflectionPayloadSerializer();

    @Test
    public void cLibraryFailsInvalidCrc() {
        MavlinkPacket packet = MavlinkPacket.createMavlink1Packet(1, 255, 0, 0, 0 /*should be 50*/,
                serializer.serialize(Heartbeat.builder()
                        .build()));

        assertFalse(CLibraryTestTool.crcCheck(packet.getRawBytes()));
    }

    @Test
    public void mavlink1PacketPassesCrcCheck() {
        MavlinkPacket packet = MavlinkPacket.createMavlink1Packet(
                1, 255, 0, 0, 50, serializer.serialize(Heartbeat.builder().build()));
        assertTrue(CLibraryTestTool.crcCheck(packet.getRawBytes()));
    }

    @Test
    public void unsignedMavlink2PacketPassesCrcCheck() {
        MavlinkPacket packet = MavlinkPacket.createUnsignedMavlink2Packet(
                1, 255, 0, 0, 50, serializer.serialize(Heartbeat.builder().build()));
        assertTrue(CLibraryTestTool.crcCheck(packet.getRawBytes()));
    }

    @Test
    public void signedMavlink2PacketPassesCrcCheck() throws NoSuchAlgorithmException {
        MavlinkPacket packet = MavlinkPacket.createSignedMavlink2Packet(
                1, 255, 0, 0, 50, serializer.serialize(Heartbeat.builder().build()),
                1, 12345L, MessageDigest.getInstance("SHA-256")
                        .digest("test".getBytes(StandardCharsets.UTF_8)));
        assertTrue(CLibraryTestTool.crcCheck(packet.getRawBytes()));
    }
}
