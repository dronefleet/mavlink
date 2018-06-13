package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * THIS INTERFACE IS DEPRECATED AS OF JULY 2015. Please use MESSAGE_INTERVAL instead. A data 
 * stream is not a fixed set of messages, but rather a recommendation to the autopilot software. 
 * Individual autopilots may or may not obey the recommended messages. 
 */
@MavlinkEnum
public enum MavDataStream {
  /**
   * Enable all data streams
   */
  @MavlinkEnumEntry(0)
  MAV_DATA_STREAM_ALL,

  /**
   * Enable IMU_RAW, GPS_RAW, GPS_STATUS packets.
   */
  @MavlinkEnumEntry(1)
  MAV_DATA_STREAM_RAW_SENSORS,

  /**
   * Enable GPS_STATUS, CONTROL_STATUS, AUX_STATUS
   */
  @MavlinkEnumEntry(2)
  MAV_DATA_STREAM_EXTENDED_STATUS,

  /**
   * Enable RC_CHANNELS_SCALED, RC_CHANNELS_RAW, SERVO_OUTPUT_RAW
   */
  @MavlinkEnumEntry(3)
  MAV_DATA_STREAM_RC_CHANNELS,

  /**
   * Enable ATTITUDE_CONTROLLER_OUTPUT, POSITION_CONTROLLER_OUTPUT, NAV_CONTROLLER_OUTPUT.
   */
  @MavlinkEnumEntry(4)
  MAV_DATA_STREAM_RAW_CONTROLLER,

  /**
   * Enable LOCAL_POSITION, GLOBAL_POSITION/GLOBAL_POSITION_INT messages.
   */
  @MavlinkEnumEntry(6)
  MAV_DATA_STREAM_POSITION,

  /**
   * Dependent on the autopilot
   */
  @MavlinkEnumEntry(10)
  MAV_DATA_STREAM_EXTRA1,

  /**
   * Dependent on the autopilot
   */
  @MavlinkEnumEntry(11)
  MAV_DATA_STREAM_EXTRA2,

  /**
   * Dependent on the autopilot
   */
  @MavlinkEnumEntry(12)
  MAV_DATA_STREAM_EXTRA3,

  /**
   * Motor/ESC telemetry data.
   * <b>added by io.dronefleet.mavlink.autoquad package</b>
   */
  @MavlinkEnumEntry(13)
  MAV_DATA_STREAM_PROPULSION
}
