package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum CameraFeedbackFlags {
    /**
     * Shooting photos, not video 
     */
    @MavlinkEntryInfo(0)
    CAMERA_FEEDBACK_PHOTO,

    /**
     * Shooting video, not stills 
     */
    @MavlinkEntryInfo(1)
    CAMERA_FEEDBACK_VIDEO,

    /**
     * Unable to achieve requested exposure (e.g. shutter speed too low) 
     */
    @MavlinkEntryInfo(2)
    CAMERA_FEEDBACK_BADEXPOSURE,

    /**
     * Closed loop feedback from camera, we know for sure it has successfully taken a picture 
     */
    @MavlinkEntryInfo(3)
    CAMERA_FEEDBACK_CLOSEDLOOP,

    /**
     * Open loop camera, an image trigger has been requested but we can't know for sure it has 
     * successfully taken a picture 
     */
    @MavlinkEntryInfo(4)
    CAMERA_FEEDBACK_OPENLOOP
}
