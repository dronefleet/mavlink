package io.dronefleet.mavlink.serialization;

import io.dronefleet.mavlink.MavlinkMessage;
import io.dronefleet.mavlink.protocol.MavlinkPacket;

public interface MavlinkPacketDeserializer {
    <T> MavlinkMessage<T> deserialize(MavlinkPacket packet, Class<T> messageType);
}
