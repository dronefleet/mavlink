package io.dronefleet.mavlink.uavionix;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumFlagSet;

/**
 * Transceiver heartbeat with health report (updated every 10s) 
 */
@MavlinkMessageInfo(
        id = 10003,
        crc = 4
)
public final class UavionixAdsbTransceiverHealthReport {
    private final EnumFlagSet<UavionixAdsbRfHealth> rfhealth;

    private UavionixAdsbTransceiverHealthReport(EnumFlagSet<UavionixAdsbRfHealth> rfhealth) {
        this.rfhealth = rfhealth;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * ADS-B transponder messages 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final EnumFlagSet<UavionixAdsbRfHealth> rfhealth() {
        return this.rfhealth;
    }

    public static final class Builder {
        private EnumFlagSet<UavionixAdsbRfHealth> rfhealth;

        /**
         * ADS-B transponder messages 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1
        )
        public final Builder rfhealth(EnumFlagSet<UavionixAdsbRfHealth> rfhealth) {
            this.rfhealth = rfhealth;
            return this;
        }

        public final UavionixAdsbTransceiverHealthReport build() {
            return new UavionixAdsbTransceiverHealthReport(rfhealth);
        }
    }
}
