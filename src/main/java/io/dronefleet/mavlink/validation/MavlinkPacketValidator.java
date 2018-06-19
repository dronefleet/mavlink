package io.dronefleet.mavlink.validation;

import io.dronefleet.mavlink.protocol.MavlinkPacket;

public interface MavlinkPacketValidator {
    boolean validate(MavlinkPacket packet, int crcExtra);
}
