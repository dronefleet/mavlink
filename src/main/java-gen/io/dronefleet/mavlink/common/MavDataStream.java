package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * A data stream is not a fixed set of messages, but rather a recommendation to the autopilot 
 * software. Individual autopilots may or may not obey the recommended messages. 
 */
@MavlinkEnum
public enum MavDataStream {
    /**
     * Enable all data streams 
     */
    @MavlinkEntryInfo(0)
    MAV_DATA_STREAM_ALL,

    /**
     * Enable IMU_RAW, GPS_RAW, {@link io.dronefleet.mavlink.common.GpsStatus GPS_STATUS} packets. 
     */
    @MavlinkEntryInfo(1)
    MAV_DATA_STREAM_RAW_SENSORS,

    /**
     * Enable {@link io.dronefleet.mavlink.common.GpsStatus GPS_STATUS}, CONTROL_STATUS, AUX_STATUS 
     */
    @MavlinkEntryInfo(2)
    MAV_DATA_STREAM_EXTENDED_STATUS,

    /**
     * Enable {@link io.dronefleet.mavlink.common.RcChannelsScaled RC_CHANNELS_SCALED}, {@link io.dronefleet.mavlink.common.RcChannelsRaw RC_CHANNELS_RAW}, {@link io.dronefleet.mavlink.common.ServoOutputRaw SERVO_OUTPUT_RAW} 
     */
    @MavlinkEntryInfo(3)
    MAV_DATA_STREAM_RC_CHANNELS,

    /**
     * Enable ATTITUDE_CONTROLLER_OUTPUT, POSITION_CONTROLLER_OUTPUT, 
     * {@link io.dronefleet.mavlink.common.NavControllerOutput NAV_CONTROLLER_OUTPUT}. 
     */
    @MavlinkEntryInfo(4)
    MAV_DATA_STREAM_RAW_CONTROLLER,

    /**
     * Enable LOCAL_POSITION, GLOBAL_POSITION/{@link io.dronefleet.mavlink.common.GlobalPositionInt GLOBAL_POSITION_INT} messages. 
     */
    @MavlinkEntryInfo(6)
    MAV_DATA_STREAM_POSITION,

    /**
     * Dependent on the autopilot 
     */
    @MavlinkEntryInfo(10)
    MAV_DATA_STREAM_EXTRA1,

    /**
     * Dependent on the autopilot 
     */
    @MavlinkEntryInfo(11)
    MAV_DATA_STREAM_EXTRA2,

    /**
     * Dependent on the autopilot 
     */
    @MavlinkEntryInfo(12)
    MAV_DATA_STREAM_EXTRA3,

    /**
     * Motor/ESC telemetry data. 
     */
    @MavlinkEntryInfo(13)
    MAV_DATA_STREAM_PROPULSION
}
