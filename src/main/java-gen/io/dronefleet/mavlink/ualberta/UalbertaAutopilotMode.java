package io.dronefleet.mavlink.ualberta;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Available autopilot modes for ualberta uav 
 */
@MavlinkEnum
public enum UalbertaAutopilotMode {
    /**
     * Raw input pulse widts sent to output 
     */
    @MavlinkEntryInfo(1)
    MODE_MANUAL_DIRECT,

    /**
     * Inputs are normalized using calibration, the converted back to raw pulse widths for output 
     */
    @MavlinkEntryInfo(2)
    MODE_MANUAL_SCALED,

    /**
     * dfsdfs 
     */
    @MavlinkEntryInfo(3)
    MODE_AUTO_PID_ATT,

    /**
     * dfsfds 
     */
    @MavlinkEntryInfo(4)
    MODE_AUTO_PID_VEL,

    /**
     * dfsdfsdfs 
     */
    @MavlinkEntryInfo(5)
    MODE_AUTO_PID_POS
}
