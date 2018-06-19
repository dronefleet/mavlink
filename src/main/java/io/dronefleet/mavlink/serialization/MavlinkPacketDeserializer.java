package io.dronefleet.mavlink.serialization;

import io.dronefleet.mavlink.protocol.MavlinkPacket;

public interface MavlinkPacketDeserializer {
    <T> T deserialize(MavlinkPacket packet, Class<T> messageType);
}
