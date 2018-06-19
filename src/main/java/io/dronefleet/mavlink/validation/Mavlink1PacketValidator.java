package io.dronefleet.mavlink.validation;

import io.dronefleet.mavlink.protocol.MavlinkPacket;

public class Mavlink1PacketValidator implements MavlinkPacketValidator {
    @Override
    public boolean validate(MavlinkPacket packet, int crcExtra) {
        CrcX25 crcX25 = new CrcX25();
        crcX25.accumulate(packet.getRawBytes(), 1, 6 + packet.getPayload().length);
        crcX25.accumulate(crcExtra);
        return crcX25.checksum() == packet.getChecksum();
    }
}
