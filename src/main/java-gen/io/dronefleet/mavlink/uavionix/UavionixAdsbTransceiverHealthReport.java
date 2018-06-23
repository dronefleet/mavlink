package io.dronefleet.mavlink.uavionix;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumFlagSet;
import java.lang.Override;
import java.lang.String;

/**
 * Transceiver heartbeat with health report (updated every 10s) 
 */
@MavlinkMessageInfo(
        id = 10003,
        crc = 4
)
public final class UavionixAdsbTransceiverHealthReport {
    /**
     * ADS-B transponder messages 
     */
    private final EnumFlagSet<UavionixAdsbRfHealth> rfhealth;

    private UavionixAdsbTransceiverHealthReport(EnumFlagSet<UavionixAdsbRfHealth> rfhealth) {
        this.rfhealth = rfhealth;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "UavionixAdsbTransceiverHealthReport{rfhealth=" + rfhealth + "}";
    }

    /**
     * ADS-B transponder messages 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final EnumFlagSet<UavionixAdsbRfHealth> rfhealth() {
        return rfhealth;
    }

    public static class Builder {
        private EnumFlagSet<UavionixAdsbRfHealth> rfhealth;

        private Builder() {
        }

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
