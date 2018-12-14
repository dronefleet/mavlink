package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * A mapping of antenna tracker flight modes for custom_mode field of heartbeat. 
 */
@MavlinkEnum
public enum TrackerMode {
    /**
     *  
     */
    @MavlinkEntryInfo(0)
    TRACKER_MODE_MANUAL,

    /**
     *  
     */
    @MavlinkEntryInfo(1)
    TRACKER_MODE_STOP,

    /**
     *  
     */
    @MavlinkEntryInfo(2)
    TRACKER_MODE_SCAN,

    /**
     *  
     */
    @MavlinkEntryInfo(3)
    TRACKER_MODE_SERVO_TEST,

    /**
     *  
     */
    @MavlinkEntryInfo(10)
    TRACKER_MODE_AUTO,

    /**
     *  
     */
    @MavlinkEntryInfo(16)
    TRACKER_MODE_INITIALIZING
}
