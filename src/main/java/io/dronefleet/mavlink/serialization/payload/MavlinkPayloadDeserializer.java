package io.dronefleet.mavlink.serialization.payload;

public interface MavlinkPayloadDeserializer {
    <T> T deserialize(byte[] payload, Class<T> messageType);
}
