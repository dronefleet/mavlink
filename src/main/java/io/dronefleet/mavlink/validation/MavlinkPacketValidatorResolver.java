package io.dronefleet.mavlink.validation;

import io.dronefleet.mavlink.protocol.MavlinkPacket;

public class MavlinkPacketValidatorResolver implements MavlinkPacketValidator {

    private final MavlinkPacketValidator mavlink1Validator;
    private final MavlinkPacketValidator mavlink2Validator;

    public MavlinkPacketValidatorResolver(
            MavlinkPacketValidator mavlink1Validator,
            MavlinkPacketValidator mavlink2Validator) {
        this.mavlink1Validator = mavlink1Validator;
        this.mavlink2Validator = mavlink2Validator;
    }

    @Override
    public boolean validate(MavlinkPacket packet, int crcExtra) {
        MavlinkPacketValidator validator;
        switch (packet.getVersionMarker()) {
            case MavlinkPacket.MAGIC_V1:
                validator = mavlink1Validator;
                break;

            case MavlinkPacket.MAGIC_V2:
                validator = mavlink2Validator;
                break;

            default:
                throw new IllegalStateException("unknown version marker " + Integer.toHexString(packet.getVersionMarker()));
        }
        return validator.validate(packet, crcExtra);
    }
}
