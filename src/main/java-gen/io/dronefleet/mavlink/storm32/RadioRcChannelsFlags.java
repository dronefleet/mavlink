package io.dronefleet.mavlink.storm32;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * {@link io.dronefleet.mavlink.storm32.RadioRcChannels RADIO_RC_CHANNELS} flags (bitmask). 
 */
@MavlinkEnum
public enum RadioRcChannelsFlags {
    /**
     * Failsafe is active. 
     */
    @MavlinkEntryInfo(1)
    RADIO_RC_CHANNELS_FLAGS_FAILSAFE,

    /**
     * Indicates that the current frame has not been received. Channel values are frozen. 
     */
    @MavlinkEntryInfo(2)
    RADIO_RC_CHANNELS_FLAGS_FRAME_MISSED
}
