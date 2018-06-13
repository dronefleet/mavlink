package io.dronefleet.mavlink.annotations;

public @interface MavlinkMessage {
    int id();
    int crc();
}
