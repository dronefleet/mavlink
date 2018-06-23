package io.dronefleet.mavlink.serialization.payload;

public interface MavlinkPayloadSerializer {
    byte[] serialize(Object message);
}
