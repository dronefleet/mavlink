package io.dronefleet.mavlink.serialization;

import io.dronefleet.mavlink.MavlinkMessage;

public interface MavlinkPacketSerializer {
    byte[] serialize(MavlinkMessage message, int sequence, int targetSystemId, int targetComponentId);
}
