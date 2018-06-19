package io.dronefleet.mavlink.serialization;

public interface MavlinkPacketSerializer {
    byte[] serialize(Object message, int sequence, int targetSystemId, int targetComponentId);
}
