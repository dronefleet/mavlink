package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * ACK / NACK / ERROR values as a result of {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD}s and for mission item transmission. 
 */
@MavlinkEnum
public enum MavCmdAck {
    /**
     * Command / mission item is ok. 
     */
    @MavlinkEntryInfo(0)
    MAV_CMD_ACK_OK,

    /**
     * Generic error message if none of the other reasons fails or if no detailed error reporting is 
     * implemented. 
     */
    @MavlinkEntryInfo(1)
    MAV_CMD_ACK_ERR_FAIL,

    /**
     * The system is refusing to accept this command from this source / communication partner. 
     */
    @MavlinkEntryInfo(2)
    MAV_CMD_ACK_ERR_ACCESS_DENIED,

    /**
     * Command or mission item is not supported, other commands would be accepted. 
     */
    @MavlinkEntryInfo(3)
    MAV_CMD_ACK_ERR_NOT_SUPPORTED,

    /**
     * The coordinate frame of this command / mission item is not supported. 
     */
    @MavlinkEntryInfo(4)
    MAV_CMD_ACK_ERR_COORDINATE_FRAME_NOT_SUPPORTED,

    /**
     * The coordinate frame of this command is ok, but he coordinate values exceed the safety limits of 
     * this system. This is a generic error, please use the more specific error messages below if 
     * possible. 
     */
    @MavlinkEntryInfo(5)
    MAV_CMD_ACK_ERR_COORDINATES_OUT_OF_RANGE,

    /**
     * The X or latitude value is out of range. 
     */
    @MavlinkEntryInfo(6)
    MAV_CMD_ACK_ERR_X_LAT_OUT_OF_RANGE,

    /**
     * The Y or longitude value is out of range. 
     */
    @MavlinkEntryInfo(7)
    MAV_CMD_ACK_ERR_Y_LON_OUT_OF_RANGE,

    /**
     * The Z or altitude value is out of range. 
     */
    @MavlinkEntryInfo(8)
    MAV_CMD_ACK_ERR_Z_ALT_OUT_OF_RANGE
}
