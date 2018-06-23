package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * null
 */
@MavlinkEnum
public enum GoproBurstRate {
    /**
     * 3 Shots / 1 Second<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(0)
    GOPRO_BURST_RATE_3_IN_1_SECOND,

    /**
     * 5 Shots / 1 Second<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    GOPRO_BURST_RATE_5_IN_1_SECOND,

    /**
     * 10 Shots / 1 Second<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    GOPRO_BURST_RATE_10_IN_1_SECOND,

    /**
     * 10 Shots / 2 Second<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(3)
    GOPRO_BURST_RATE_10_IN_2_SECOND,

    /**
     * 10 Shots / 3 Second (Hero 4 Only)<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(4)
    GOPRO_BURST_RATE_10_IN_3_SECOND,

    /**
     * 30 Shots / 1 Second<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(5)
    GOPRO_BURST_RATE_30_IN_1_SECOND,

    /**
     * 30 Shots / 2 Second<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(6)
    GOPRO_BURST_RATE_30_IN_2_SECOND,

    /**
     * 30 Shots / 3 Second<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(7)
    GOPRO_BURST_RATE_30_IN_3_SECOND,

    /**
     * 30 Shots / 6 Second<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(8)
    GOPRO_BURST_RATE_30_IN_6_SECOND
}
