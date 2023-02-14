package io.dronefleet.mavlink.avssuas;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum MavAvssCommandFailureReason {
    /**
     * AVSS defined command failure reason. PRS not steady. 
     */
    @MavlinkEntryInfo(1)
    PRS_NOT_STEADY,

    /**
     * AVSS defined command failure reason. PRS DTM not armed. 
     */
    @MavlinkEntryInfo(2)
    PRS_DTM_NOT_ARMED,

    /**
     * AVSS defined command failure reason. PRS OTM not armed. 
     */
    @MavlinkEntryInfo(3)
    PRS_OTM_NOT_ARMED
}
