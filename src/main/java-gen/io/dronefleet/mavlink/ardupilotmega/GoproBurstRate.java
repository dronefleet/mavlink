package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum GoproBurstRate {
    /**
     * 3 Shots / 1 Second 
     */
    @MavlinkEntryInfo(0)
    GOPRO_BURST_RATE_3_IN_1_SECOND,

    /**
     * 5 Shots / 1 Second 
     */
    @MavlinkEntryInfo(1)
    GOPRO_BURST_RATE_5_IN_1_SECOND,

    /**
     * 10 Shots / 1 Second 
     */
    @MavlinkEntryInfo(2)
    GOPRO_BURST_RATE_10_IN_1_SECOND,

    /**
     * 10 Shots / 2 Second 
     */
    @MavlinkEntryInfo(3)
    GOPRO_BURST_RATE_10_IN_2_SECOND,

    /**
     * 10 Shots / 3 Second (Hero 4 Only) 
     */
    @MavlinkEntryInfo(4)
    GOPRO_BURST_RATE_10_IN_3_SECOND,

    /**
     * 30 Shots / 1 Second 
     */
    @MavlinkEntryInfo(5)
    GOPRO_BURST_RATE_30_IN_1_SECOND,

    /**
     * 30 Shots / 2 Second 
     */
    @MavlinkEntryInfo(6)
    GOPRO_BURST_RATE_30_IN_2_SECOND,

    /**
     * 30 Shots / 3 Second 
     */
    @MavlinkEntryInfo(7)
    GOPRO_BURST_RATE_30_IN_3_SECOND,

    /**
     * 30 Shots / 6 Second 
     */
    @MavlinkEntryInfo(8)
    GOPRO_BURST_RATE_30_IN_6_SECOND
}
