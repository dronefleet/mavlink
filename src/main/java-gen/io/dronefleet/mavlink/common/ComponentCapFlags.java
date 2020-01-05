package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Component capability flags (Bitmap) 
 */
@MavlinkEnum
public enum ComponentCapFlags {
    /**
     * Component has parameters, and supports the parameter protocol (PARAM messages). 
     */
    @MavlinkEntryInfo(1)
    COMPONENT_CAP_FLAGS_PARAM,

    /**
     * Component has parameters, and supports the extended parameter protocol (PARAM_EXT 
     * messages). 
     */
    @MavlinkEntryInfo(2)
    COMPONENT_CAP_FLAGS_PARAM_EXT
}
