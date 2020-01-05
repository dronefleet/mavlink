package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * These flags are used in the {@link io.dronefleet.mavlink.common.AisVessel AIS_VESSEL}.fields bitmask to indicate validity of data in the other 
 * message fields. When set, the data is valid. 
 */
@MavlinkEnum
public enum AisFlags {
    /**
     * 1 = Position accuracy less than 10m, 0 = position accuracy greater than 10m. 
     */
    @MavlinkEntryInfo(1)
    AIS_FLAGS_POSITION_ACCURACY,

    /**
     *  
     */
    @MavlinkEntryInfo(2)
    AIS_FLAGS_VALID_COG,

    /**
     *  
     */
    @MavlinkEntryInfo(4)
    AIS_FLAGS_VALID_VELOCITY,

    /**
     * 1 = Velocity over 52.5765m/s (102.2 knots) 
     */
    @MavlinkEntryInfo(8)
    AIS_FLAGS_HIGH_VELOCITY,

    /**
     *  
     */
    @MavlinkEntryInfo(16)
    AIS_FLAGS_VALID_TURN_RATE,

    /**
     * Only the sign of the returned turn rate value is valid, either greater than 5deg/30s or less than 
     * -5deg/30s 
     */
    @MavlinkEntryInfo(32)
    AIS_FLAGS_TURN_RATE_SIGN_ONLY,

    /**
     *  
     */
    @MavlinkEntryInfo(64)
    AIS_FLAGS_VALID_DIMENSIONS,

    /**
     * Distance to bow is larger than 511m 
     */
    @MavlinkEntryInfo(128)
    AIS_FLAGS_LARGE_BOW_DIMENSION,

    /**
     * Distance to stern is larger than 511m 
     */
    @MavlinkEntryInfo(256)
    AIS_FLAGS_LARGE_STERN_DIMENSION,

    /**
     * Distance to port side is larger than 63m 
     */
    @MavlinkEntryInfo(512)
    AIS_FLAGS_LARGE_PORT_DIMENSION,

    /**
     * Distance to starboard side is larger than 63m 
     */
    @MavlinkEntryInfo(1024)
    AIS_FLAGS_LARGE_STARBOARD_DIMENSION,

    /**
     *  
     */
    @MavlinkEntryInfo(2048)
    AIS_FLAGS_VALID_CALLSIGN,

    /**
     *  
     */
    @MavlinkEntryInfo(4096)
    AIS_FLAGS_VALID_NAME
}
