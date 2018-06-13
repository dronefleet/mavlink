package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * Commands to be executed by the MAV. They can be executed on user request, or as part of a mission 
 * script. If the action is used in a mission, the parameter mapping to the waypoint/mission 
 * message is as follows: Param 1, Param 2, Param 3, Param 4, X: Param 5, Y:Param 6, Z:Param 7. This 
 * command list is similar what ARINC 424 is for commercial aircraft: A data format how to 
 * interpret waypoint/mission data. 
 */
@MavlinkEnum
public enum MavCmd {
  /**
   * Navigate to waypoint.
   * param[1]: Hold time in decimal seconds. (ignored by fixed wing, time to stay at waypoint for rotary wing)
   * param[2]: Acceptance radius in meters (if the sphere with this radius is hit, the waypoint counts as reached)
   * param[3]: 0 to pass through the WP, if > 0 radius in meters to pass by WP. Positive value for clockwise orbit, negative value for counter-clockwise orbit. Allows trajectory control.
   * param[4]: Desired yaw angle at waypoint (rotary wing). NaN for unchanged.
   * param[5]: Latitude
   * param[6]: Longitude
   * param[7]: Altitude
   */
  @MavlinkEnumEntry(16)
  MAV_CMD_NAV_WAYPOINT,

  /**
   * Loiter around this waypoint an unlimited amount of time
   * param[1]: Empty
   * param[2]: Empty
   * param[3]: Radius around waypoint, in meters. If positive loiter clockwise, else counter-clockwise
   * param[4]: Desired yaw angle.
   * param[5]: Latitude
   * param[6]: Longitude
   * param[7]: Altitude
   */
  @MavlinkEnumEntry(17)
  MAV_CMD_NAV_LOITER_UNLIM,

  /**
   * Loiter around this waypoint for X turns
   * param[1]: Turns
   * param[2]: Empty
   * param[3]: Radius around waypoint, in meters. If positive loiter clockwise, else counter-clockwise
   * param[4]: Forward moving aircraft this sets exit xtrack location: 0 for center of loiter wp, 1 for exit location. Else, this is desired yaw angle
   * param[5]: Latitude
   * param[6]: Longitude
   * param[7]: Altitude
   */
  @MavlinkEnumEntry(18)
  MAV_CMD_NAV_LOITER_TURNS,

  /**
   * Loiter around this waypoint for X seconds
   * param[1]: Seconds (decimal)
   * param[2]: Empty
   * param[3]: Radius around waypoint, in meters. If positive loiter clockwise, else counter-clockwise
   * param[4]: Forward moving aircraft this sets exit xtrack location: 0 for center of loiter wp, 1 for exit location. Else, this is desired yaw angle
   * param[5]: Latitude
   * param[6]: Longitude
   * param[7]: Altitude
   */
  @MavlinkEnumEntry(19)
  MAV_CMD_NAV_LOITER_TIME,

  /**
   * Return to launch location
   * param[1]: Empty
   * param[2]: Empty
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   */
  @MavlinkEnumEntry(20)
  MAV_CMD_NAV_RETURN_TO_LAUNCH,

  /**
   * Land at location
   * param[1]: Abort Alt
   * param[2]: Precision land mode. (0 = normal landing, 1 = opportunistic precision landing, 2 = required precsion landing)
   * param[3]: Empty
   * param[4]: Desired yaw angle. NaN for unchanged.
   * param[5]: Latitude
   * param[6]: Longitude
   * param[7]: Altitude (ground level)
   */
  @MavlinkEnumEntry(21)
  MAV_CMD_NAV_LAND,

  /**
   * Takeoff from ground / hand
   * param[1]: Minimum pitch (if airspeed sensor present), desired pitch without sensor
   * param[2]: Empty
   * param[3]: Empty
   * param[4]: Yaw angle (if magnetometer present), ignored without magnetometer. NaN for unchanged.
   * param[5]: Latitude
   * param[6]: Longitude
   * param[7]: Altitude
   */
  @MavlinkEnumEntry(22)
  MAV_CMD_NAV_TAKEOFF,

  /**
   * Land at local position (local frame only)
   * param[1]: Landing target number (if available)
   * param[2]: Maximum accepted offset from desired landing position [m] - computed magnitude from spherical coordinates: d = sqrt(x^2 + y^2 + z^2), which gives the maximum accepted distance between the desired landing position and the position where the vehicle is about to land
   * param[3]: Landing descend rate [ms^-1]
   * param[4]: Desired yaw angle [rad]
   * param[5]: Y-axis position [m]
   * param[6]: X-axis position [m]
   * param[7]: Z-axis / ground level position [m]
   */
  @MavlinkEnumEntry(23)
  MAV_CMD_NAV_LAND_LOCAL,

  /**
   * Takeoff from local position (local frame only)
   * param[1]: Minimum pitch (if airspeed sensor present), desired pitch without sensor [rad]
   * param[2]: Empty
   * param[3]: Takeoff ascend rate [ms^-1]
   * param[4]: Yaw angle [rad] (if magnetometer or another yaw estimation source present), ignored without one of these
   * param[5]: Y-axis position [m]
   * param[6]: X-axis position [m]
   * param[7]: Z-axis position [m]
   */
  @MavlinkEnumEntry(24)
  MAV_CMD_NAV_TAKEOFF_LOCAL,

  /**
   * Vehicle following, i.e. this waypoint represents the position of a moving vehicle
   * param[1]: Following logic to use (e.g. loitering or sinusoidal following) - depends on specific autopilot implementation
   * param[2]: Ground speed of vehicle to be followed
   * param[3]: Radius around waypoint, in meters. If positive loiter clockwise, else counter-clockwise
   * param[4]: Desired yaw angle.
   * param[5]: Latitude
   * param[6]: Longitude
   * param[7]: Altitude
   */
  @MavlinkEnumEntry(25)
  MAV_CMD_NAV_FOLLOW,

  /**
   * Continue on the current course and climb/descend to specified altitude.  When the altitude is reached continue to the next command (i.e., don't proceed to the next command until the desired altitude is reached.
   * param[1]: Climb or Descend (0 = Neutral, command completes when within 5m of this command's altitude, 1 = Climbing, command completes when at or above this command's altitude, 2 = Descending, command completes when at or below this command's altitude.
   * param[2]: Empty
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Desired altitude in meters
   */
  @MavlinkEnumEntry(30)
  MAV_CMD_NAV_CONTINUE_AND_CHANGE_ALT,

  /**
   * Begin loiter at the specified Latitude and Longitude.  If Lat=Lon=0, then loiter at the current position.  Don't consider the navigation command complete (don't leave loiter) until the altitude has been reached.  Additionally, if the Heading Required parameter is non-zero the  aircraft will not leave the loiter until heading toward the next waypoint.
   * param[1]: Heading Required (0 = False)
   * param[2]: Radius in meters. If positive loiter clockwise, negative counter-clockwise, 0 means no change to standard loiter.
   * param[3]: Empty
   * param[4]: Forward moving aircraft this sets exit xtrack location: 0 for center of loiter wp, 1 for exit location
   * param[5]: Latitude
   * param[6]: Longitude
   * param[7]: Altitude
   */
  @MavlinkEnumEntry(31)
  MAV_CMD_NAV_LOITER_TO_ALT,

  /**
   * Being following a target
   * param[1]: System ID (the system ID of the FOLLOW_TARGET beacon). Send 0 to disable follow-me and return to the default position hold mode
   * param[2]: RESERVED
   * param[3]: RESERVED
   * param[4]: altitude flag: 0: Keep current altitude, 1: keep altitude difference to target, 2: go to a fixed altitude above home
   * param[5]: altitude
   * param[6]: RESERVED
   * param[7]: TTL in seconds in which the MAV should go to the default position hold mode after a message rx timeout
   */
  @MavlinkEnumEntry(32)
  MAV_CMD_DO_FOLLOW,

  /**
   * Reposition the MAV after a follow target command has been sent
   * param[1]: Camera q1 (where 0 is on the ray from the camera to the tracking device)
   * param[2]: Camera q2
   * param[3]: Camera q3
   * param[4]: Camera q4
   * param[5]: altitude offset from target (m)
   * param[6]: X offset from target (m)
   * param[7]: Y offset from target (m)
   */
  @MavlinkEnumEntry(33)
  MAV_CMD_DO_FOLLOW_REPOSITION,

  /**
   * THIS INTERFACE IS DEPRECATED AS OF JANUARY 2018. Please use MAV_CMD_DO_SET_ROI_* messages instead. Sets the region of interest (ROI) for a sensor set or the vehicle itself. This can then be used by the vehicles control system to control the vehicle attitude and the attitude of various sensors such as cameras.
   * param[1]: Region of intereset mode. (see MAV_ROI enum)
   * param[2]: Waypoint index/ target ID. (see MAV_ROI enum)
   * param[3]: ROI index (allows a vehicle to manage multiple ROI's)
   * param[4]: Empty
   * param[5]: x the location of the fixed ROI (see MAV_FRAME)
   * param[6]: y
   * param[7]: z
   */
  @MavlinkEnumEntry(80)
  MAV_CMD_NAV_ROI,

  /**
   * Control autonomous path planning on the MAV.
   * param[1]: 0: Disable local obstacle avoidance / local path planning (without resetting map), 1: Enable local path planning, 2: Enable and reset local path planning
   * param[2]: 0: Disable full path planning (without resetting map), 1: Enable, 2: Enable and reset map/occupancy grid, 3: Enable and reset planned route, but not occupancy grid
   * param[3]: Empty
   * param[4]: Yaw angle at goal, in compass degrees, [0..360]
   * param[5]: Latitude/X of goal
   * param[6]: Longitude/Y of goal
   * param[7]: Altitude/Z of goal
   */
  @MavlinkEnumEntry(81)
  MAV_CMD_NAV_PATHPLANNING,

  /**
   * Navigate to waypoint using a spline path.
   * param[1]: Hold time in decimal seconds. (ignored by fixed wing, time to stay at waypoint for rotary wing)
   * param[2]: Empty
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Latitude/X of goal
   * param[6]: Longitude/Y of goal
   * param[7]: Altitude/Z of goal
   */
  @MavlinkEnumEntry(82)
  MAV_CMD_NAV_SPLINE_WAYPOINT,

  /**
   * Takeoff from ground using VTOL mode
   * param[1]: Empty
   * param[2]: Front transition heading, see VTOL_TRANSITION_HEADING enum.
   * param[3]: Empty
   * param[4]: Yaw angle in degrees. NaN for unchanged.
   * param[5]: Latitude
   * param[6]: Longitude
   * param[7]: Altitude
   */
  @MavlinkEnumEntry(84)
  MAV_CMD_NAV_VTOL_TAKEOFF,

  /**
   * Land using VTOL mode
   * param[1]: Empty
   * param[2]: Empty
   * param[3]: Approach altitude (with the same reference as the Altitude field). NaN if unspecified.
   * param[4]: Yaw angle in degrees. NaN for unchanged.
   * param[5]: Latitude
   * param[6]: Longitude
   * param[7]: Altitude (ground level)
   */
  @MavlinkEnumEntry(85)
  MAV_CMD_NAV_VTOL_LAND,

  /**
   * hand control over to an external controller
   * param[1]: On / Off (> 0.5f on)
   * param[2]: Empty
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   */
  @MavlinkEnumEntry(92)
  MAV_CMD_NAV_GUIDED_ENABLE,

  /**
   * Delay the next navigation command a number of seconds or until a specified time
   * param[1]: Delay in seconds (decimal, -1 to enable time-of-day fields)
   * param[2]: hour (24h format, UTC, -1 to ignore)
   * param[3]: minute (24h format, UTC, -1 to ignore)
   * param[4]: second (24h format, UTC)
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   */
  @MavlinkEnumEntry(93)
  MAV_CMD_NAV_DELAY,

  /**
   * Descend and place payload.  Vehicle descends until it detects a hanging payload has reached the ground, the gripper is opened to release the payload
   * param[1]: Maximum distance to descend (meters)
   * param[2]: Empty
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Latitude (deg * 1E7)
   * param[6]: Longitude (deg * 1E7)
   * param[7]: Altitude (meters)
   */
  @MavlinkEnumEntry(94)
  MAV_CMD_NAV_PAYLOAD_PLACE,

  /**
   * NOP - This command is only used to mark the upper limit of the NAV/ACTION commands in the enumeration
   * param[1]: Empty
   * param[2]: Empty
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   */
  @MavlinkEnumEntry(95)
  MAV_CMD_NAV_LAST,

  /**
   * Delay mission state machine.
   * param[1]: Delay in seconds (decimal)
   * param[2]: Empty
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   */
  @MavlinkEnumEntry(112)
  MAV_CMD_CONDITION_DELAY,

  /**
   * Ascend/descend at rate.  Delay mission state machine until desired altitude reached.
   * param[1]: Descent / Ascend rate (m/s)
   * param[2]: Empty
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Finish Altitude
   */
  @MavlinkEnumEntry(113)
  MAV_CMD_CONDITION_CHANGE_ALT,

  /**
   * Delay mission state machine until within desired distance of next NAV point.
   * param[1]: Distance (meters)
   * param[2]: Empty
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   */
  @MavlinkEnumEntry(114)
  MAV_CMD_CONDITION_DISTANCE,

  /**
   * Reach a certain target angle.
   * param[1]: target angle: [0-360], 0 is north
   * param[2]: speed during yaw change:[deg per second]
   * param[3]: direction: negative: counter clockwise, positive: clockwise [-1,1]
   * param[4]: relative offset or absolute angle: [ 1,0]
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   */
  @MavlinkEnumEntry(115)
  MAV_CMD_CONDITION_YAW,

  /**
   * NOP - This command is only used to mark the upper limit of the CONDITION commands in the enumeration
   * param[1]: Empty
   * param[2]: Empty
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   */
  @MavlinkEnumEntry(159)
  MAV_CMD_CONDITION_LAST,

  /**
   * Set system mode.
   * param[1]: Mode, as defined by ENUM MAV_MODE
   * param[2]: Custom mode - this is system specific, please refer to the individual autopilot specifications for details.
   * param[3]: Custom sub mode - this is system specific, please refer to the individual autopilot specifications for details.
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   */
  @MavlinkEnumEntry(176)
  MAV_CMD_DO_SET_MODE,

  /**
   * Jump to the desired command in the mission list.  Repeat this action only the specified number of times
   * param[1]: Sequence number
   * param[2]: Repeat count
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   */
  @MavlinkEnumEntry(177)
  MAV_CMD_DO_JUMP,

  /**
   * Change speed and/or throttle set points.
   * param[1]: Speed type (0=Airspeed, 1=Ground Speed)
   * param[2]: Speed  (m/s, -1 indicates no change)
   * param[3]: Throttle  ( Percent, -1 indicates no change)
   * param[4]: absolute or relative [0,1]
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   */
  @MavlinkEnumEntry(178)
  MAV_CMD_DO_CHANGE_SPEED,

  /**
   * Changes the home location either to the current location or a specified location.
   * param[1]: Use current (1=use current location, 0=use specified location)
   * param[2]: Empty
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Latitude
   * param[6]: Longitude
   * param[7]: Altitude
   */
  @MavlinkEnumEntry(179)
  MAV_CMD_DO_SET_HOME,

  /**
   * Set a system parameter.  Caution!  Use of this command requires knowledge of the numeric enumeration value of the parameter.
   * param[1]: Parameter number
   * param[2]: Parameter value
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   */
  @MavlinkEnumEntry(180)
  MAV_CMD_DO_SET_PARAMETER,

  /**
   * Set a relay to a condition.
   * param[1]: Relay number
   * param[2]: Setting (1=on, 0=off, others possible depending on system hardware)
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   */
  @MavlinkEnumEntry(181)
  MAV_CMD_DO_SET_RELAY,

  /**
   * Cycle a relay on and off for a desired number of cyles with a desired period.
   * param[1]: Relay number
   * param[2]: Cycle count
   * param[3]: Cycle time (seconds, decimal)
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   */
  @MavlinkEnumEntry(182)
  MAV_CMD_DO_REPEAT_RELAY,

  /**
   * Set a servo to a desired PWM value.
   * param[1]: Servo number
   * param[2]: PWM (microseconds, 1000 to 2000 typical)
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   */
  @MavlinkEnumEntry(183)
  MAV_CMD_DO_SET_SERVO,

  /**
   * Cycle a between its nominal setting and a desired PWM for a desired number of cycles with a desired period.
   * param[1]: Servo number
   * param[2]: PWM (microseconds, 1000 to 2000 typical)
   * param[3]: Cycle count
   * param[4]: Cycle time (seconds)
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   */
  @MavlinkEnumEntry(184)
  MAV_CMD_DO_REPEAT_SERVO,

  /**
   * Terminate flight immediately
   * param[1]: Flight termination activated if > 0.5
   * param[2]: Empty
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   */
  @MavlinkEnumEntry(185)
  MAV_CMD_DO_FLIGHTTERMINATION,

  /**
   * Change altitude set point.
   * param[1]: Altitude in meters
   * param[2]: Mav frame of new altitude (see MAV_FRAME)
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   */
  @MavlinkEnumEntry(186)
  MAV_CMD_DO_CHANGE_ALTITUDE,

  /**
   * Mission command to perform a landing. This is used as a marker in a mission to tell the autopilot where a sequence of mission items that represents a landing starts. It may also be sent via a COMMAND_LONG to trigger a landing, in which case the nearest (geographically) landing sequence in the mission will be used. The Latitude/Longitude is optional, and may be set to 0 if not needed. If specified then it will be used to help find the closest landing sequence.
   * param[1]: Empty
   * param[2]: Empty
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Latitude
   * param[6]: Longitude
   * param[7]: Empty
   */
  @MavlinkEnumEntry(189)
  MAV_CMD_DO_LAND_START,

  /**
   * Mission command to perform a landing from a rally point.
   * param[1]: Break altitude (meters)
   * param[2]: Landing speed (m/s)
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   */
  @MavlinkEnumEntry(190)
  MAV_CMD_DO_RALLY_LAND,

  /**
   * Mission command to safely abort an autonmous landing.
   * param[1]: Altitude (meters)
   * param[2]: Empty
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   */
  @MavlinkEnumEntry(191)
  MAV_CMD_DO_GO_AROUND,

  /**
   * Reposition the vehicle to a specific WGS84 global position.
   * param[1]: Ground speed, less than 0 (-1) for default
   * param[2]: Bitmask of option flags, see the MAV_DO_REPOSITION_FLAGS enum.
   * param[3]: Reserved
   * param[4]: Yaw heading, NaN for unchanged. For planes indicates loiter direction (0: clockwise, 1: counter clockwise)
   * param[5]: Latitude (deg * 1E7)
   * param[6]: Longitude (deg * 1E7)
   * param[7]: Altitude (meters)
   */
  @MavlinkEnumEntry(192)
  MAV_CMD_DO_REPOSITION,

  /**
   * If in a GPS controlled position mode, hold the current position or continue.
   * param[1]: 0: Pause current mission or reposition command, hold current position. 1: Continue mission. A VTOL capable vehicle should enter hover mode (multicopter and VTOL planes). A plane should loiter with the default loiter radius.
   * param[2]: Reserved
   * param[3]: Reserved
   * param[4]: Reserved
   * param[5]: Reserved
   * param[6]: Reserved
   * param[7]: Reserved
   */
  @MavlinkEnumEntry(193)
  MAV_CMD_DO_PAUSE_CONTINUE,

  /**
   * Set moving direction to forward or reverse.
   * param[1]: Direction (0=Forward, 1=Reverse)
   * param[2]: Empty
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   */
  @MavlinkEnumEntry(194)
  MAV_CMD_DO_SET_REVERSE,

  /**
   * Sets the region of interest (ROI) to a location. This can then be used by the vehicles control system to control the vehicle attitude and the attitude of various sensors such as cameras.
   * param[1]: Empty
   * param[2]: Empty
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Latitude
   * param[6]: Longitude
   * param[7]: Altitude
   */
  @MavlinkEnumEntry(195)
  MAV_CMD_DO_SET_ROI_LOCATION,

  /**
   * Sets the region of interest (ROI) to be toward next waypoint, with optional pitch/roll/yaw offset. This can then be used by the vehicles control system to control the vehicle attitude and the attitude of various sensors such as cameras.
   * param[1]: Empty
   * param[2]: Empty
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: pitch offset from next waypoint
   * param[6]: roll offset from next waypoint
   * param[7]: yaw offset from next waypoint
   */
  @MavlinkEnumEntry(196)
  MAV_CMD_DO_SET_ROI_WPNEXT_OFFSET,

  /**
   * Cancels any previous ROI command returning the vehicle/sensors to default flight characteristics. This can then be used by the vehicles control system to control the vehicle attitude and the attitude of various sensors such as cameras.
   * param[1]: Empty
   * param[2]: Empty
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   */
  @MavlinkEnumEntry(197)
  MAV_CMD_DO_SET_ROI_NONE,

  /**
   * Control onboard camera system.
   * param[1]: Camera ID (-1 for all)
   * param[2]: Transmission: 0: disabled, 1: enabled compressed, 2: enabled raw
   * param[3]: Transmission mode: 0: video stream, >0: single images every n seconds (decimal)
   * param[4]: Recording: 0: disabled, 1: enabled compressed, 2: enabled raw
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   */
  @MavlinkEnumEntry(200)
  MAV_CMD_DO_CONTROL_VIDEO,

  /**
   * THIS INTERFACE IS DEPRECATED AS OF JANUARY 2018. Please use MAV_CMD_DO_SET_ROI_* messages instead. Sets the region of interest (ROI) for a sensor set or the vehicle itself. This can then be used by the vehicles control system to control the vehicle attitude and the attitude of various sensors such as cameras.
   * param[1]: Region of intereset mode. (see MAV_ROI enum)
   * param[2]: Waypoint index/ target ID. (see MAV_ROI enum)
   * param[3]: ROI index (allows a vehicle to manage multiple ROI's)
   * param[4]: Empty
   * param[5]: MAV_ROI_WPNEXT: pitch offset from next waypoint, MAV_ROI_LOCATION: latitude
   * param[6]: MAV_ROI_WPNEXT: roll offset from next waypoint, MAV_ROI_LOCATION: longitude
   * param[7]: MAV_ROI_WPNEXT: yaw offset from next waypoint, MAV_ROI_LOCATION: altitude
   */
  @MavlinkEnumEntry(201)
  MAV_CMD_DO_SET_ROI,

  /**
   * THIS INTERFACE IS DEPRECATED since 2018-01. Please use PARAM_EXT_XXX messages and the camera definition format described in https://mavlink.io/en/protocol/camera_def.html.
   * param[1]: Modes: P, TV, AV, M, Etc
   * param[2]: Shutter speed: Divisor number for one second
   * param[3]: Aperture: F stop number
   * param[4]: ISO number e.g. 80, 100, 200, Etc
   * param[5]: Exposure type enumerator
   * param[6]: Command Identity
   * param[7]: Main engine cut-off time before camera trigger in seconds/10 (0 means no cut-off)
   */
  @MavlinkEnumEntry(202)
  MAV_CMD_DO_DIGICAM_CONFIGURE,

  /**
   * THIS INTERFACE IS DEPRECATED since 2018-01. Please use PARAM_EXT_XXX messages and the camera definition format described in https://mavlink.io/en/protocol/camera_def.html.
   * param[1]: Session control e.g. show/hide lens
   * param[2]: Zoom's absolute position
   * param[3]: Zooming step value to offset zoom from the current position
   * param[4]: Focus Locking, Unlocking or Re-locking
   * param[5]: Shooting Command
   * param[6]: Command Identity
   * param[7]: Test shot identifier. If set to 1, image will only be captured, but not counted towards internal frame count.
   */
  @MavlinkEnumEntry(203)
  MAV_CMD_DO_DIGICAM_CONTROL,

  /**
   * Mission command to configure a camera or antenna mount
   * param[1]: Mount operation mode (see MAV_MOUNT_MODE enum)
   * param[2]: stabilize roll? (1 = yes, 0 = no)
   * param[3]: stabilize pitch? (1 = yes, 0 = no)
   * param[4]: stabilize yaw? (1 = yes, 0 = no)
   * param[5]: roll input (0 = angle, 1 = angular rate)
   * param[6]: pitch input (0 = angle, 1 = angular rate)
   * param[7]: yaw input (0 = angle, 1 = angular rate)
   */
  @MavlinkEnumEntry(204)
  MAV_CMD_DO_MOUNT_CONFIGURE,

  /**
   * Mission command to control a camera or antenna mount
   * param[1]: pitch depending on mount mode (degrees or degrees/second depending on pitch input).
   * param[2]: roll depending on mount mode (degrees or degrees/second depending on roll input).
   * param[3]: yaw depending on mount mode (degrees or degrees/second depending on yaw input).
   * param[4]: alt in meters depending on mount mode.
   * param[5]: latitude in degrees * 1E7, set if appropriate mount mode.
   * param[6]: longitude in degrees * 1E7, set if appropriate mount mode.
   * param[7]: MAV_MOUNT_MODE enum value
   */
  @MavlinkEnumEntry(205)
  MAV_CMD_DO_MOUNT_CONTROL,

  /**
   * Mission command to set camera trigger distance for this flight. The camera is trigerred each time this distance is exceeded. This command can also be used to set the shutter integration time for the camera.
   * param[1]: Camera trigger distance (meters). 0 to stop triggering.
   * param[2]: Camera shutter integration time (milliseconds). -1 or 0 to ignore
   * param[3]: Trigger camera once immediately. (0 = no trigger, 1 = trigger)
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   */
  @MavlinkEnumEntry(206)
  MAV_CMD_DO_SET_CAM_TRIGG_DIST,

  /**
   * Mission command to enable the geofence
   * param[1]: enable? (0=disable, 1=enable, 2=disable_floor_only)
   * param[2]: Empty
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   */
  @MavlinkEnumEntry(207)
  MAV_CMD_DO_FENCE_ENABLE,

  /**
   * Mission command to trigger a parachute
   * param[1]: action (0=disable, 1=enable, 2=release, for some systems see PARACHUTE_ACTION enum, not in general message set.)
   * param[2]: Empty
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   */
  @MavlinkEnumEntry(208)
  MAV_CMD_DO_PARACHUTE,

  /**
   * Mission command to perform motor test
   * param[1]: motor number (a number from 1 to max number of motors on the vehicle)
   * param[2]: throttle type (0=throttle percentage, 1=PWM, 2=pilot throttle channel pass-through. See MOTOR_TEST_THROTTLE_TYPE enum)
   * param[3]: throttle
   * param[4]: timeout (in seconds)
   * param[5]: motor count (number of motors to test to test in sequence, waiting for the timeout above between them; 0=1 motor, 1=1 motor, 2=2 motors...)
   * param[6]: motor test order (See MOTOR_TEST_ORDER enum)
   * param[7]: Empty
   */
  @MavlinkEnumEntry(209)
  MAV_CMD_DO_MOTOR_TEST,

  /**
   * Change to/from inverted flight
   * param[1]: inverted (0=normal, 1=inverted)
   * param[2]: Empty
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   */
  @MavlinkEnumEntry(210)
  MAV_CMD_DO_INVERTED_FLIGHT,

  /**
   * Sets a desired vehicle turn angle and speed change
   * param[1]: yaw angle to adjust steering by in centidegress
   * param[2]: speed - normalized to 0 .. 1
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   */
  @MavlinkEnumEntry(213)
  MAV_CMD_NAV_SET_YAW_SPEED,

  /**
   * Mission command to set camera trigger interval for this flight. If triggering is enabled, the camera is triggered each time this interval expires. This command can also be used to set the shutter integration time for the camera.
   * param[1]: Camera trigger cycle time (milliseconds). -1 or 0 to ignore.
   * param[2]: Camera shutter integration time (milliseconds). Should be less than trigger cycle time. -1 or 0 to ignore.
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   */
  @MavlinkEnumEntry(214)
  MAV_CMD_DO_SET_CAM_TRIGG_INTERVAL,

  /**
   * Mission command to control a camera or antenna mount, using a quaternion as reference.
   * param[1]: q1 - quaternion param #1, w (1 in null-rotation)
   * param[2]: q2 - quaternion param #2, x (0 in null-rotation)
   * param[3]: q3 - quaternion param #3, y (0 in null-rotation)
   * param[4]: q4 - quaternion param #4, z (0 in null-rotation)
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   */
  @MavlinkEnumEntry(220)
  MAV_CMD_DO_MOUNT_CONTROL_QUAT,

  /**
   * set id of master controller
   * param[1]: System ID
   * param[2]: Component ID
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   */
  @MavlinkEnumEntry(221)
  MAV_CMD_DO_GUIDED_MASTER,

  /**
   * set limits for external control
   * param[1]: timeout - maximum time (in seconds) that external controller will be allowed to control vehicle. 0 means no timeout
   * param[2]: absolute altitude min (in meters, AMSL) - if vehicle moves below this alt, the command will be aborted and the mission will continue.  0 means no lower altitude limit
   * param[3]: absolute altitude max (in meters)- if vehicle moves above this alt, the command will be aborted and the mission will continue.  0 means no upper altitude limit
   * param[4]: horizontal move limit (in meters, AMSL) - if vehicle moves more than this distance from it's location at the moment the command was executed, the command will be aborted and the mission will continue. 0 means no horizontal altitude limit
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   */
  @MavlinkEnumEntry(222)
  MAV_CMD_DO_GUIDED_LIMITS,

  /**
   * Control vehicle engine. This is interpreted by the vehicles engine controller to change the target engine state. It is intended for vehicles with internal combustion engines
   * param[1]: 0: Stop engine, 1:Start Engine
   * param[2]: 0: Warm start, 1:Cold start. Controls use of choke where applicable
   * param[3]: Height delay (meters). This is for commanding engine start only after the vehicle has gained the specified height. Used in VTOL vehicles during takeoff to start engine after the aircraft is off the ground. Zero for no delay.
   * param[4]: Empty
   * param[5]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   */
  @MavlinkEnumEntry(223)
  MAV_CMD_DO_ENGINE_CONTROL,

  /**
   * NOP - This command is only used to mark the upper limit of the DO commands in the enumeration
   * param[1]: Empty
   * param[2]: Empty
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   */
  @MavlinkEnumEntry(240)
  MAV_CMD_DO_LAST,

  /**
   * Trigger calibration. This command will be only accepted if in pre-flight mode. Except for Temperature Calibration, only one sensor should be set in a single message and all others should be zero.
   * param[1]: 1: gyro calibration, 3: gyro temperature calibration
   * param[2]: 1: magnetometer calibration
   * param[3]: 1: ground pressure calibration
   * param[4]: 1: radio RC calibration, 2: RC trim calibration
   * param[5]: 1: accelerometer calibration, 2: board level calibration, 3: accelerometer temperature calibration, 4: simple accelerometer calibration
   * param[6]: 1: APM: compass/motor interference calibration (PX4: airspeed calibration, deprecated), 2: airspeed calibration
   * param[7]: 1: ESC calibration, 3: barometer temperature calibration
   */
  @MavlinkEnumEntry(241)
  MAV_CMD_PREFLIGHT_CALIBRATION,

  /**
   * Set sensor offsets. This command will be only accepted if in pre-flight mode.
   * param[1]: Sensor to adjust the offsets for: 0: gyros, 1: accelerometer, 2: magnetometer, 3: barometer, 4: optical flow, 5: second magnetometer, 6: third magnetometer
   * param[2]: X axis offset (or generic dimension 1), in the sensor's raw units
   * param[3]: Y axis offset (or generic dimension 2), in the sensor's raw units
   * param[4]: Z axis offset (or generic dimension 3), in the sensor's raw units
   * param[5]: Generic dimension 4, in the sensor's raw units
   * param[6]: Generic dimension 5, in the sensor's raw units
   * param[7]: Generic dimension 6, in the sensor's raw units
   */
  @MavlinkEnumEntry(242)
  MAV_CMD_PREFLIGHT_SET_SENSOR_OFFSETS,

  /**
   * Trigger UAVCAN config. This command will be only accepted if in pre-flight mode.
   * param[1]: 1: Trigger actuator ID assignment and direction mapping.
   * param[2]: Reserved
   * param[3]: Reserved
   * param[4]: Reserved
   * param[5]: Reserved
   * param[6]: Reserved
   * param[7]: Reserved
   */
  @MavlinkEnumEntry(243)
  MAV_CMD_PREFLIGHT_UAVCAN,

  /**
   * Request storage of different parameter values and logs. This command will be only accepted if in pre-flight mode.
   * param[1]: Parameter storage: 0: READ FROM FLASH/EEPROM, 1: WRITE CURRENT TO FLASH/EEPROM, 2: Reset to defaults
   * param[2]: Mission storage: 0: READ FROM FLASH/EEPROM, 1: WRITE CURRENT TO FLASH/EEPROM, 2: Reset to defaults
   * param[3]: Onboard logging: 0: Ignore, 1: Start default rate logging, -1: Stop logging, > 1: start logging with rate of param 3 in Hz (e.g. set to 1000 for 1000 Hz logging)
   * param[4]: Reserved
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   */
  @MavlinkEnumEntry(245)
  MAV_CMD_PREFLIGHT_STORAGE,

  /**
   * Request the reboot or shutdown of system components.
   * param[1]: 0: Do nothing for autopilot, 1: Reboot autopilot, 2: Shutdown autopilot, 3: Reboot autopilot and keep it in the bootloader until upgraded.
   * param[2]: 0: Do nothing for onboard computer, 1: Reboot onboard computer, 2: Shutdown onboard computer, 3: Reboot onboard computer and keep it in the bootloader until upgraded.
   * param[3]: WIP: 0: Do nothing for camera, 1: Reboot onboard camera, 2: Shutdown onboard camera, 3: Reboot onboard camera and keep it in the bootloader until upgraded
   * param[4]: WIP: 0: Do nothing for mount (e.g. gimbal), 1: Reboot mount, 2: Shutdown mount, 3: Reboot mount and keep it in the bootloader until upgraded
   * param[5]: Reserved, send 0
   * param[6]: Reserved, send 0
   * param[7]: WIP: ID (e.g. camera ID -1 for all IDs)
   */
  @MavlinkEnumEntry(246)
  MAV_CMD_PREFLIGHT_REBOOT_SHUTDOWN,

  /**
   * Hold / continue the current action
   * param[1]: MAV_GOTO_DO_HOLD: hold MAV_GOTO_DO_CONTINUE: continue with next item in mission plan
   * param[2]: MAV_GOTO_HOLD_AT_CURRENT_POSITION: Hold at current position MAV_GOTO_HOLD_AT_SPECIFIED_POSITION: hold at specified position
   * param[3]: MAV_FRAME coordinate frame of hold point
   * param[4]: Desired yaw angle in degrees
   * param[5]: Latitude / X position
   * param[6]: Longitude / Y position
   * param[7]: Altitude / Z position
   */
  @MavlinkEnumEntry(252)
  MAV_CMD_OVERRIDE_GOTO,

  /**
   * start running a mission
   * param[1]: first_item: the first mission item to run
   * param[2]: last_item:  the last mission item to run (after this item is run, the mission ends)
   */
  @MavlinkEnumEntry(300)
  MAV_CMD_MISSION_START,

  /**
   * Arms / Disarms a component
   * param[1]: 1 to arm, 0 to disarm
   */
  @MavlinkEnumEntry(400)
  MAV_CMD_COMPONENT_ARM_DISARM,

  /**
   * Request the home position from the vehicle.
   * param[1]: Reserved
   * param[2]: Reserved
   * param[3]: Reserved
   * param[4]: Reserved
   * param[5]: Reserved
   * param[6]: Reserved
   * param[7]: Reserved
   */
  @MavlinkEnumEntry(410)
  MAV_CMD_GET_HOME_POSITION,

  /**
   * Starts receiver pairing
   * param[1]: 0:Spektrum
   * param[2]: RC type (see RC_TYPE enum)
   */
  @MavlinkEnumEntry(500)
  MAV_CMD_START_RX_PAIR,

  /**
   * Request the interval between messages for a particular MAVLink message ID
   * param[1]: The MAVLink message ID
   */
  @MavlinkEnumEntry(510)
  MAV_CMD_GET_MESSAGE_INTERVAL,

  /**
   * Set the interval between messages for a particular MAVLink message ID. This interface replaces REQUEST_DATA_STREAM
   * param[1]: The MAVLink message ID
   * param[2]: The interval between two messages, in microseconds. Set to -1 to disable and 0 to request default rate.
   */
  @MavlinkEnumEntry(511)
  MAV_CMD_SET_MESSAGE_INTERVAL,

  /**
   * Request MAVLink protocol version compatibility
   * param[1]: 1: Request supported protocol versions by all nodes on the network
   * param[2]: Reserved (all remaining params)
   */
  @MavlinkEnumEntry(519)
  MAV_CMD_REQUEST_PROTOCOL_VERSION,

  /**
   * Request autopilot capabilities
   * param[1]: 1: Request autopilot version
   * param[2]: Reserved (all remaining params)
   */
  @MavlinkEnumEntry(520)
  MAV_CMD_REQUEST_AUTOPILOT_CAPABILITIES,

  /**
   * Request camera information (CAMERA_INFORMATION).
   * param[1]: 0: No action 1: Request camera capabilities
   * param[2]: Reserved (all remaining params)
   */
  @MavlinkEnumEntry(521)
  MAV_CMD_REQUEST_CAMERA_INFORMATION,

  /**
   * Request camera settings (CAMERA_SETTINGS).
   * param[1]: 0: No Action 1: Request camera settings
   * param[2]: Reserved (all remaining params)
   */
  @MavlinkEnumEntry(522)
  MAV_CMD_REQUEST_CAMERA_SETTINGS,

  /**
   * WIP: Request storage information (STORAGE_INFORMATION). Use the command's target_component to target a specific component's storage.
   * param[1]: Storage ID (0 for all, 1 for first, 2 for second, etc.)
   * param[2]: 0: No Action 1: Request storage information
   * param[3]: Reserved (all remaining params)
   */
  @MavlinkEnumEntry(525)
  MAV_CMD_REQUEST_STORAGE_INFORMATION,

  /**
   * WIP: Format a storage medium. Once format is complete, a STORAGE_INFORMATION message is sent. Use the command's target_component to target a specific component's storage.
   * param[1]: Storage ID (1 for first, 2 for second, etc.)
   * param[2]: 0: No action 1: Format storage
   * param[3]: Reserved (all remaining params)
   */
  @MavlinkEnumEntry(526)
  MAV_CMD_STORAGE_FORMAT,

  /**
   * Request camera capture status (CAMERA_CAPTURE_STATUS)
   * param[1]: 0: No Action 1: Request camera capture status
   * param[2]: Reserved (all remaining params)
   */
  @MavlinkEnumEntry(527)
  MAV_CMD_REQUEST_CAMERA_CAPTURE_STATUS,

  /**
   * WIP: Request flight information (FLIGHT_INFORMATION)
   * param[1]: 1: Request flight information
   * param[2]: Reserved (all remaining params)
   */
  @MavlinkEnumEntry(528)
  MAV_CMD_REQUEST_FLIGHT_INFORMATION,

  /**
   * Reset all camera settings to Factory Default
   * param[1]: 0: No Action 1: Reset all settings
   * param[2]: Reserved (all remaining params)
   */
  @MavlinkEnumEntry(529)
  MAV_CMD_RESET_CAMERA_SETTINGS,

  /**
   * Set camera running mode. Use NAN for reserved values.
   * param[1]: Reserved (Set to 0)
   * param[2]: Camera mode (see CAMERA_MODE enum)
   * param[3]: Reserved (all remaining params)
   */
  @MavlinkEnumEntry(530)
  MAV_CMD_SET_CAMERA_MODE,

  /**
   * Start image capture sequence. Sends CAMERA_IMAGE_CAPTURED after each capture. Use NAN for reserved values.
   * param[1]: Reserved (Set to 0)
   * param[2]: Duration between two consecutive pictures (in seconds)
   * param[3]: Number of images to capture total - 0 for unlimited capture
   * param[4]: Capture sequence (ID to prevent double captures when a command is retransmitted, 0: unused, >= 1: used)
   * param[5]: Reserved (all remaining params)
   */
  @MavlinkEnumEntry(2000)
  MAV_CMD_IMAGE_START_CAPTURE,

  /**
   * Stop image capture sequence Use NAN for reserved values.
   * param[1]: Reserved (Set to 0)
   * param[2]: Reserved (all remaining params)
   */
  @MavlinkEnumEntry(2001)
  MAV_CMD_IMAGE_STOP_CAPTURE,

  /**
   * WIP: Re-request a CAMERA_IMAGE_CAPTURE packet. Use NAN for reserved values.
   * param[1]: Sequence number for missing CAMERA_IMAGE_CAPTURE packet
   * param[2]: Reserved (all remaining params)
   */
  @MavlinkEnumEntry(2002)
  MAV_CMD_REQUEST_CAMERA_IMAGE_CAPTURE,

  /**
   * Enable or disable on-board camera triggering system.
   * param[1]: Trigger enable/disable (0 for disable, 1 for start), -1 to ignore
   * param[2]: 1 to reset the trigger sequence, -1 or 0 to ignore
   * param[3]: 1 to pause triggering, but without switching the camera off or retracting it. -1 to ignore
   */
  @MavlinkEnumEntry(2003)
  MAV_CMD_DO_TRIGGER_CONTROL,

  /**
   * Starts video capture (recording). Use NAN for reserved values.
   * param[1]: Reserved (Set to 0)
   * param[2]: Frequency CAMERA_CAPTURE_STATUS messages should be sent while recording (0 for no messages, otherwise frequency in Hz)
   * param[3]: Reserved (all remaining params)
   */
  @MavlinkEnumEntry(2500)
  MAV_CMD_VIDEO_START_CAPTURE,

  /**
   * Stop the current video capture (recording). Use NAN for reserved values.
   * param[1]: Reserved (Set to 0)
   * param[2]: Reserved (all remaining params)
   */
  @MavlinkEnumEntry(2501)
  MAV_CMD_VIDEO_STOP_CAPTURE,

  /**
   * WIP: Start video streaming
   * param[1]: Camera ID (0 for all cameras, 1 for first, 2 for second, etc.)
   * param[2]: Reserved
   */
  @MavlinkEnumEntry(2502)
  MAV_CMD_VIDEO_START_STREAMING,

  /**
   * WIP: Stop the current video streaming
   * param[1]: Camera ID (0 for all cameras, 1 for first, 2 for second, etc.)
   * param[2]: Reserved
   */
  @MavlinkEnumEntry(2503)
  MAV_CMD_VIDEO_STOP_STREAMING,

  /**
   * WIP: Request video stream information (VIDEO_STREAM_INFORMATION)
   * param[1]: Camera ID (0 for all cameras, 1 for first, 2 for second, etc.)
   * param[2]: 0: No Action 1: Request video stream information
   * param[3]: Reserved (all remaining params)
   */
  @MavlinkEnumEntry(2504)
  MAV_CMD_REQUEST_VIDEO_STREAM_INFORMATION,

  /**
   * Request to start streaming logging data over MAVLink (see also LOGGING_DATA message)
   * param[1]: Format: 0: ULog
   * param[2]: Reserved (set to 0)
   * param[3]: Reserved (set to 0)
   * param[4]: Reserved (set to 0)
   * param[5]: Reserved (set to 0)
   * param[6]: Reserved (set to 0)
   * param[7]: Reserved (set to 0)
   */
  @MavlinkEnumEntry(2510)
  MAV_CMD_LOGGING_START,

  /**
   * Request to stop streaming log data over MAVLink
   * param[1]: Reserved (set to 0)
   * param[2]: Reserved (set to 0)
   * param[3]: Reserved (set to 0)
   * param[4]: Reserved (set to 0)
   * param[5]: Reserved (set to 0)
   * param[6]: Reserved (set to 0)
   * param[7]: Reserved (set to 0)
   */
  @MavlinkEnumEntry(2511)
  MAV_CMD_LOGGING_STOP,

  /**
   * null
   * param[1]: Landing gear ID (default: 0, -1 for all)
   * param[2]: Landing gear position (Down: 0, Up: 1, NAN for no change)
   * param[3]: Reserved, set to NAN
   * param[4]: Reserved, set to NAN
   * param[5]: Reserved, set to NAN
   * param[6]: Reserved, set to NAN
   * param[7]: Reserved, set to NAN
   */
  @MavlinkEnumEntry(2520)
  MAV_CMD_AIRFRAME_CONFIGURATION,

  /**
   * Request to start/stop transmitting over the high latency telemetry
   * param[1]: Control transmittion over high latency telemetry (0: stop, 1: start)
   * param[2]: Empty
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   */
  @MavlinkEnumEntry(2600)
  MAV_CMD_CONTROL_HIGH_LATENCY,

  /**
   * Create a panorama at the current position
   * param[1]: Viewing angle horizontal of the panorama (in degrees, +- 0.5 the total angle)
   * param[2]: Viewing angle vertical of panorama (in degrees)
   * param[3]: Speed of the horizontal rotation (in degrees per second)
   * param[4]: Speed of the vertical rotation (in degrees per second)
   */
  @MavlinkEnumEntry(2800)
  MAV_CMD_PANORAMA_CREATE,

  /**
   * Request VTOL transition
   * param[1]: The target VTOL state, as defined by ENUM MAV_VTOL_STATE. Only MAV_VTOL_STATE_MC and MAV_VTOL_STATE_FW can be used.
   */
  @MavlinkEnumEntry(3000)
  MAV_CMD_DO_VTOL_TRANSITION,

  /**
   * This command sets the submode to standard guided when vehicle is in guided mode. The vehicle holds position and altitude and the user can input the desired velocites along all three axes.
   */
  @MavlinkEnumEntry(4000)
  MAV_CMD_SET_GUIDED_SUBMODE_STANDARD,

  /**
   * This command sets submode circle when vehicle is in guided mode. Vehicle flies along a circle facing the center of the circle. The user can input the velocity along the circle and change the radius. If no input is given the vehicle will hold position.
   * param[1]: Radius of desired circle in CIRCLE_MODE
   * param[2]: User defined
   * param[3]: User defined
   * param[4]: User defined
   * param[5]: Unscaled target latitude of center of circle in CIRCLE_MODE
   * param[6]: Unscaled target longitude of center of circle in CIRCLE_MODE
   */
  @MavlinkEnumEntry(4001)
  MAV_CMD_SET_GUIDED_SUBMODE_CIRCLE,

  /**
   * WIP: Delay mission state machine until gate has been reached.
   * param[1]: Geometry: 0: orthogonal to path between previous and next waypoint.
   * param[2]: Altitude: 0: ignore altitude
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Latitude
   * param[6]: Longitude
   * param[7]: Altitude
   */
  @MavlinkEnumEntry(4501)
  MAV_CMD_CONDITION_GATE,

  /**
   * Request authorization to arm the vehicle to a external entity, the arm authorizer is resposible to request all data that is needs from the vehicle before authorize or deny the request. If approved the progress of command_ack message should be set with period of time that this authorization is valid in seconds or in case it was denied it should be set with one of the reasons in ARM_AUTH_DENIED_REASON.
   * param[1]: Vehicle system id, this way ground station can request arm authorization on behalf of any vehicle
   */
  @MavlinkEnumEntry(3001)
  MAV_CMD_ARM_AUTHORIZATION_REQUEST,

  /**
   * Fence return point. There can only be one fence return point.
   * param[1]: Reserved
   * param[2]: Reserved
   * param[3]: Reserved
   * param[4]: Reserved
   * param[5]: Latitude
   * param[6]: Longitude
   * param[7]: Altitude
   */
  @MavlinkEnumEntry(5000)
  MAV_CMD_NAV_FENCE_RETURN_POINT,

  /**
   * Fence vertex for an inclusion polygon (the polygon must not be self-intersecting). The vehicle must stay within this area. Minimum of 3 vertices required.
   * param[1]: Polygon vertex count
   * param[2]: Reserved
   * param[3]: Reserved
   * param[4]: Reserved
   * param[5]: Latitude
   * param[6]: Longitude
   * param[7]: Reserved
   */
  @MavlinkEnumEntry(5001)
  MAV_CMD_NAV_FENCE_POLYGON_VERTEX_INCLUSION,

  /**
   * Fence vertex for an exclusion polygon (the polygon must not be self-intersecting). The vehicle must stay outside this area. Minimum of 3 vertices required.
   * param[1]: Polygon vertex count
   * param[2]: Reserved
   * param[3]: Reserved
   * param[4]: Reserved
   * param[5]: Latitude
   * param[6]: Longitude
   * param[7]: Reserved
   */
  @MavlinkEnumEntry(5002)
  MAV_CMD_NAV_FENCE_POLYGON_VERTEX_EXCLUSION,

  /**
   * Circular fence area. The vehicle must stay inside this area.
   * param[1]: radius in meters
   * param[2]: Reserved
   * param[3]: Reserved
   * param[4]: Reserved
   * param[5]: Latitude
   * param[6]: Longitude
   * param[7]: Reserved
   */
  @MavlinkEnumEntry(5003)
  MAV_CMD_NAV_FENCE_CIRCLE_INCLUSION,

  /**
   * Circular fence area. The vehicle must stay outside this area.
   * param[1]: radius in meters
   * param[2]: Reserved
   * param[3]: Reserved
   * param[4]: Reserved
   * param[5]: Latitude
   * param[6]: Longitude
   * param[7]: Reserved
   */
  @MavlinkEnumEntry(5004)
  MAV_CMD_NAV_FENCE_CIRCLE_EXCLUSION,

  /**
   * Rally point. You can have multiple rally points defined.
   * param[1]: Reserved
   * param[2]: Reserved
   * param[3]: Reserved
   * param[4]: Reserved
   * param[5]: Latitude
   * param[6]: Longitude
   * param[7]: Altitude
   */
  @MavlinkEnumEntry(5100)
  MAV_CMD_NAV_RALLY_POINT,

  /**
   * Commands the vehicle to respond with a sequence of messages UAVCAN_NODE_INFO, one message per every UAVCAN node that is online. Note that some of the response messages can be lost, which the receiver can detect easily by checking whether every received UAVCAN_NODE_STATUS has a matching message UAVCAN_NODE_INFO received earlier; if not, this command should be sent again in order to request re-transmission of the node information messages.
   * param[1]: Reserved (set to 0)
   * param[2]: Reserved (set to 0)
   * param[3]: Reserved (set to 0)
   * param[4]: Reserved (set to 0)
   * param[5]: Reserved (set to 0)
   * param[6]: Reserved (set to 0)
   * param[7]: Reserved (set to 0)
   */
  @MavlinkEnumEntry(5200)
  MAV_CMD_UAVCAN_GET_NODE_INFO,

  /**
   * Deploy payload on a Lat / Lon / Alt position. This includes the navigation to reach the required release position and velocity.
   * param[1]: Operation mode. 0: prepare single payload deploy (overwriting previous requests), but do not execute it. 1: execute payload deploy immediately (rejecting further deploy commands during execution, but allowing abort). 2: add payload deploy to existing deployment list.
   * param[2]: Desired approach vector in degrees compass heading (0..360). A negative value indicates the system can define the approach vector at will.
   * param[3]: Desired ground speed at release time. This can be overriden by the airframe in case it needs to meet minimum airspeed. A negative value indicates the system can define the ground speed at will.
   * param[4]: Minimum altitude clearance to the release position in meters. A negative value indicates the system can define the clearance at will.
   * param[5]: Latitude unscaled for MISSION_ITEM or in 1e7 degrees for MISSION_ITEM_INT
   * param[6]: Longitude unscaled for MISSION_ITEM or in 1e7 degrees for MISSION_ITEM_INT
   * param[7]: Altitude, in meters AMSL
   */
  @MavlinkEnumEntry(30001)
  MAV_CMD_PAYLOAD_PREPARE_DEPLOY,

  /**
   * Control the payload deployment.
   * param[1]: Operation mode. 0: Abort deployment, continue normal mission. 1: switch to payload deploment mode. 100: delete first payload deployment request. 101: delete all payload deployment requests.
   * param[2]: Reserved
   * param[3]: Reserved
   * param[4]: Reserved
   * param[5]: Reserved
   * param[6]: Reserved
   * param[7]: Reserved
   */
  @MavlinkEnumEntry(30002)
  MAV_CMD_PAYLOAD_CONTROL_DEPLOY,

  /**
   * User defined waypoint item. Ground Station will show the Vehicle as flying through this item.
   * param[1]: User defined
   * param[2]: User defined
   * param[3]: User defined
   * param[4]: User defined
   * param[5]: Latitude unscaled
   * param[6]: Longitude unscaled
   * param[7]: Altitude, in meters AMSL
   */
  @MavlinkEnumEntry(31000)
  MAV_CMD_WAYPOINT_USER_1,

  /**
   * User defined waypoint item. Ground Station will show the Vehicle as flying through this item.
   * param[1]: User defined
   * param[2]: User defined
   * param[3]: User defined
   * param[4]: User defined
   * param[5]: Latitude unscaled
   * param[6]: Longitude unscaled
   * param[7]: Altitude, in meters AMSL
   */
  @MavlinkEnumEntry(31001)
  MAV_CMD_WAYPOINT_USER_2,

  /**
   * User defined waypoint item. Ground Station will show the Vehicle as flying through this item.
   * param[1]: User defined
   * param[2]: User defined
   * param[3]: User defined
   * param[4]: User defined
   * param[5]: Latitude unscaled
   * param[6]: Longitude unscaled
   * param[7]: Altitude, in meters AMSL
   */
  @MavlinkEnumEntry(31002)
  MAV_CMD_WAYPOINT_USER_3,

  /**
   * User defined waypoint item. Ground Station will show the Vehicle as flying through this item.
   * param[1]: User defined
   * param[2]: User defined
   * param[3]: User defined
   * param[4]: User defined
   * param[5]: Latitude unscaled
   * param[6]: Longitude unscaled
   * param[7]: Altitude, in meters AMSL
   */
  @MavlinkEnumEntry(31003)
  MAV_CMD_WAYPOINT_USER_4,

  /**
   * User defined waypoint item. Ground Station will show the Vehicle as flying through this item.
   * param[1]: User defined
   * param[2]: User defined
   * param[3]: User defined
   * param[4]: User defined
   * param[5]: Latitude unscaled
   * param[6]: Longitude unscaled
   * param[7]: Altitude, in meters AMSL
   */
  @MavlinkEnumEntry(31004)
  MAV_CMD_WAYPOINT_USER_5,

  /**
   * User defined spatial item. Ground Station will not show the Vehicle as flying through this item. Example: ROI item.
   * param[1]: User defined
   * param[2]: User defined
   * param[3]: User defined
   * param[4]: User defined
   * param[5]: Latitude unscaled
   * param[6]: Longitude unscaled
   * param[7]: Altitude, in meters AMSL
   */
  @MavlinkEnumEntry(31005)
  MAV_CMD_SPATIAL_USER_1,

  /**
   * User defined spatial item. Ground Station will not show the Vehicle as flying through this item. Example: ROI item.
   * param[1]: User defined
   * param[2]: User defined
   * param[3]: User defined
   * param[4]: User defined
   * param[5]: Latitude unscaled
   * param[6]: Longitude unscaled
   * param[7]: Altitude, in meters AMSL
   */
  @MavlinkEnumEntry(31006)
  MAV_CMD_SPATIAL_USER_2,

  /**
   * User defined spatial item. Ground Station will not show the Vehicle as flying through this item. Example: ROI item.
   * param[1]: User defined
   * param[2]: User defined
   * param[3]: User defined
   * param[4]: User defined
   * param[5]: Latitude unscaled
   * param[6]: Longitude unscaled
   * param[7]: Altitude, in meters AMSL
   */
  @MavlinkEnumEntry(31007)
  MAV_CMD_SPATIAL_USER_3,

  /**
   * User defined spatial item. Ground Station will not show the Vehicle as flying through this item. Example: ROI item.
   * param[1]: User defined
   * param[2]: User defined
   * param[3]: User defined
   * param[4]: User defined
   * param[5]: Latitude unscaled
   * param[6]: Longitude unscaled
   * param[7]: Altitude, in meters AMSL
   */
  @MavlinkEnumEntry(31008)
  MAV_CMD_SPATIAL_USER_4,

  /**
   * User defined spatial item. Ground Station will not show the Vehicle as flying through this item. Example: ROI item.
   * param[1]: User defined
   * param[2]: User defined
   * param[3]: User defined
   * param[4]: User defined
   * param[5]: Latitude unscaled
   * param[6]: Longitude unscaled
   * param[7]: Altitude, in meters AMSL
   */
  @MavlinkEnumEntry(31009)
  MAV_CMD_SPATIAL_USER_5,

  /**
   * User defined command. Ground Station will not show the Vehicle as flying through this item. Example: MAV_CMD_DO_SET_PARAMETER item.
   * param[1]: User defined
   * param[2]: User defined
   * param[3]: User defined
   * param[4]: User defined
   * param[5]: User defined
   * param[6]: User defined
   * param[7]: User defined
   */
  @MavlinkEnumEntry(31010)
  MAV_CMD_USER_1,

  /**
   * User defined command. Ground Station will not show the Vehicle as flying through this item. Example: MAV_CMD_DO_SET_PARAMETER item.
   * param[1]: User defined
   * param[2]: User defined
   * param[3]: User defined
   * param[4]: User defined
   * param[5]: User defined
   * param[6]: User defined
   * param[7]: User defined
   */
  @MavlinkEnumEntry(31011)
  MAV_CMD_USER_2,

  /**
   * User defined command. Ground Station will not show the Vehicle as flying through this item. Example: MAV_CMD_DO_SET_PARAMETER item.
   * param[1]: User defined
   * param[2]: User defined
   * param[3]: User defined
   * param[4]: User defined
   * param[5]: User defined
   * param[6]: User defined
   * param[7]: User defined
   */
  @MavlinkEnumEntry(31012)
  MAV_CMD_USER_3,

  /**
   * User defined command. Ground Station will not show the Vehicle as flying through this item. Example: MAV_CMD_DO_SET_PARAMETER item.
   * param[1]: User defined
   * param[2]: User defined
   * param[3]: User defined
   * param[4]: User defined
   * param[5]: User defined
   * param[6]: User defined
   * param[7]: User defined
   */
  @MavlinkEnumEntry(31013)
  MAV_CMD_USER_4,

  /**
   * User defined command. Ground Station will not show the Vehicle as flying through this item. Example: MAV_CMD_DO_SET_PARAMETER item.
   * param[1]: User defined
   * param[2]: User defined
   * param[3]: User defined
   * param[4]: User defined
   * param[5]: User defined
   * param[6]: User defined
   * param[7]: User defined
   */
  @MavlinkEnumEntry(31014)
  MAV_CMD_USER_5,

  /**
   * Mission command to operate EPM gripper
   * param[1]: gripper number (a number from 1 to max number of grippers on the vehicle)
   * param[2]: gripper action (0=release, 1=grab. See GRIPPER_ACTIONS enum)
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   * <b>added by io.dronefleet.mavlink.ardupilotmega package</b>
   */
  @MavlinkEnumEntry(211)
  MAV_CMD_DO_GRIPPER,

  /**
   * Enable/disable autotune
   * param[1]: enable (1: enable, 0:disable)
   * param[2]: Empty
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   * <b>added by io.dronefleet.mavlink.ardupilotmega package</b>
   */
  @MavlinkEnumEntry(212)
  MAV_CMD_DO_AUTOTUNE_ENABLE,

  /**
   * Mission command to wait for an altitude or downwards vertical speed. This is meant for high altitude balloon launches, allowing the aircraft to be idle until either an altitude is reached or a negative vertical speed is reached (indicating early balloon burst). The wiggle time is how often to wiggle the control surfaces to prevent them seizing up.
   * param[1]: altitude (m)
   * param[2]: descent speed (m/s)
   * param[3]: Wiggle Time (s)
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   * <b>added by io.dronefleet.mavlink.ardupilotmega package</b>
   */
  @MavlinkEnumEntry(83)
  MAV_CMD_NAV_ALTITUDE_WAIT,

  /**
   * A system wide power-off event has been initiated.
   * param[1]: Empty
   * param[2]: Empty
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   * <b>added by io.dronefleet.mavlink.ardupilotmega package</b>
   */
  @MavlinkEnumEntry(42000)
  MAV_CMD_POWER_OFF_INITIATED,

  /**
   * FLY button has been clicked.
   * param[1]: Empty
   * param[2]: Empty
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   * <b>added by io.dronefleet.mavlink.ardupilotmega package</b>
   */
  @MavlinkEnumEntry(42001)
  MAV_CMD_SOLO_BTN_FLY_CLICK,

  /**
   * FLY button has been held for 1.5 seconds.
   * param[1]: Takeoff altitude
   * param[2]: Empty
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   * <b>added by io.dronefleet.mavlink.ardupilotmega package</b>
   */
  @MavlinkEnumEntry(42002)
  MAV_CMD_SOLO_BTN_FLY_HOLD,

  /**
   * PAUSE button has been clicked.
   * param[1]: 1 if Solo is in a shot mode, 0 otherwise
   * param[2]: Empty
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   * <b>added by io.dronefleet.mavlink.ardupilotmega package</b>
   */
  @MavlinkEnumEntry(42003)
  MAV_CMD_SOLO_BTN_PAUSE_CLICK,

  /**
   * Magnetometer calibration based on fixed position
   *         in earth field given by inclination, declination and intensity
   * param[1]: MagDeclinationDegrees
   * param[2]: MagInclinationDegrees
   * param[3]: MagIntensityMilliGauss
   * param[4]: YawDegrees
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   * <b>added by io.dronefleet.mavlink.ardupilotmega package</b>
   */
  @MavlinkEnumEntry(42004)
  MAV_CMD_FIXED_MAG_CAL,

  /**
   * Magnetometer calibration based on fixed expected field values in milliGauss
   * param[1]: FieldX
   * param[2]: FieldY
   * param[3]: FieldZ
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   * <b>added by io.dronefleet.mavlink.ardupilotmega package</b>
   */
  @MavlinkEnumEntry(42005)
  MAV_CMD_FIXED_MAG_CAL_FIELD,

  /**
   * Initiate a magnetometer calibration
   * param[1]: uint8_t bitmask of magnetometers (0 means all)
   * param[2]: Automatically retry on failure (0=no retry, 1=retry).
   * param[3]: Save without user input (0=require input, 1=autosave).
   * param[4]: Delay (seconds)
   * param[5]: Autoreboot (0=user reboot, 1=autoreboot)
   * param[6]: Empty
   * param[7]: Empty
   * <b>added by io.dronefleet.mavlink.ardupilotmega package</b>
   */
  @MavlinkEnumEntry(42424)
  MAV_CMD_DO_START_MAG_CAL,

  /**
   * Initiate a magnetometer calibration
   * param[1]: uint8_t bitmask of magnetometers (0 means all)
   * param[2]: Empty
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   * <b>added by io.dronefleet.mavlink.ardupilotmega package</b>
   */
  @MavlinkEnumEntry(42425)
  MAV_CMD_DO_ACCEPT_MAG_CAL,

  /**
   * Cancel a running magnetometer calibration
   * param[1]: uint8_t bitmask of magnetometers (0 means all)
   * param[2]: Empty
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   * <b>added by io.dronefleet.mavlink.ardupilotmega package</b>
   */
  @MavlinkEnumEntry(42426)
  MAV_CMD_DO_CANCEL_MAG_CAL,

  /**
   * Used when doing accelerometer calibration. When sent to the GCS tells it what position to put the vehicle in. When sent to the vehicle says what position the vehicle is in.
   * param[1]: Position, one of the ACCELCAL_VEHICLE_POS enum values
   * param[2]: Empty
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   * <b>added by io.dronefleet.mavlink.ardupilotmega package</b>
   */
  @MavlinkEnumEntry(42429)
  MAV_CMD_ACCELCAL_VEHICLE_POS,

  /**
   * Reply with the version banner
   * param[1]: Empty
   * param[2]: Empty
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   * <b>added by io.dronefleet.mavlink.ardupilotmega package</b>
   */
  @MavlinkEnumEntry(42428)
  MAV_CMD_DO_SEND_BANNER,

  /**
   * Command autopilot to get into factory test/diagnostic mode
   * param[1]: 0 means get out of test mode, 1 means get into test mode
   * param[2]: Empty
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   * <b>added by io.dronefleet.mavlink.ardupilotmega package</b>
   */
  @MavlinkEnumEntry(42427)
  MAV_CMD_SET_FACTORY_TEST_MODE,

  /**
   * Causes the gimbal to reset and boot as if it was just powered on
   * param[1]: Empty
   * param[2]: Empty
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   * <b>added by io.dronefleet.mavlink.ardupilotmega package</b>
   */
  @MavlinkEnumEntry(42501)
  MAV_CMD_GIMBAL_RESET,

  /**
   * Reports progress and success or failure of gimbal axis calibration procedure
   * param[1]: Gimbal axis we're reporting calibration progress for
   * param[2]: Current calibration progress for this axis, 0x64=100%
   * param[3]: Status of the calibration
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   * <b>added by io.dronefleet.mavlink.ardupilotmega package</b>
   */
  @MavlinkEnumEntry(42502)
  MAV_CMD_GIMBAL_AXIS_CALIBRATION_STATUS,

  /**
   * Starts commutation calibration on the gimbal
   * param[1]: Empty
   * param[2]: Empty
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   * <b>added by io.dronefleet.mavlink.ardupilotmega package</b>
   */
  @MavlinkEnumEntry(42503)
  MAV_CMD_GIMBAL_REQUEST_AXIS_CALIBRATION,

  /**
   * Erases gimbal application and parameters
   * param[1]: Magic number
   * param[2]: Magic number
   * param[3]: Magic number
   * param[4]: Magic number
   * param[5]: Magic number
   * param[6]: Magic number
   * param[7]: Magic number
   * <b>added by io.dronefleet.mavlink.ardupilotmega package</b>
   */
  @MavlinkEnumEntry(42505)
  MAV_CMD_GIMBAL_FULL_RESET,

  /**
   * Command to operate winch
   * param[1]: winch number (0 for the default winch, otherwise a number from 1 to max number of winches on the vehicle)
   * param[2]: action (0=relax, 1=relative length control, 2=rate control.  See WINCH_ACTIONS enum)
   * param[3]: release length (cable distance to unwind in meters, negative numbers to wind in cable)
   * param[4]: release rate (meters/second)
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   * <b>added by io.dronefleet.mavlink.ardupilotmega package</b>
   */
  @MavlinkEnumEntry(42600)
  MAV_CMD_DO_WINCH,

  /**
   * Does nothing.
   * param[1]: 1 to arm, 0 to disarm
   * <b>added by io.dronefleet.mavlink.slugs package</b>
   */
  @MavlinkEnumEntry(10001)
  MAV_CMD_DO_NOTHING,

  /**
   * Return vehicle to base.
   * param[1]: 0: return to base, 1: track mobile base
   * <b>added by io.dronefleet.mavlink.slugs package</b>
   */
  @MavlinkEnumEntry(10011)
  MAV_CMD_RETURN_TO_BASE,

  /**
   * Stops the vehicle from returning to base and resumes flight.
   * <b>added by io.dronefleet.mavlink.slugs package</b>
   */
  @MavlinkEnumEntry(10012)
  MAV_CMD_STOP_RETURN_TO_BASE,

  /**
   * Turns the vehicle's visible or infrared lights on or off.
   * param[1]: 0: visible lights, 1: infrared lights
   * param[2]: 0: turn on, 1: turn off
   * <b>added by io.dronefleet.mavlink.slugs package</b>
   */
  @MavlinkEnumEntry(10013)
  MAV_CMD_TURN_LIGHT,

  /**
   * Requests vehicle to send current mid-level commands to ground station.
   * <b>added by io.dronefleet.mavlink.slugs package</b>
   */
  @MavlinkEnumEntry(10014)
  MAV_CMD_GET_MID_LEVEL_COMMANDS,

  /**
   * Requests storage of mid-level commands.
   * param[1]: Mid-level command storage: 0: read from flash/EEPROM, 1: write to flash/EEPROM
   * <b>added by io.dronefleet.mavlink.slugs package</b>
   */
  @MavlinkEnumEntry(10015)
  MAV_CMD_MIDLEVEL_STORAGE,

  /**
   * Mission command to reset Maximum Power Point Tracker (MPPT)
   * param[1]: MPPT number
   * param[2]: Empty
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   * <b>added by io.dronefleet.mavlink.asluav package</b>
   */
  @MavlinkEnumEntry(40001)
  MAV_CMD_RESET_MPPT,

  /**
   * Mission command to perform a power cycle on payload
   * param[1]: Complete power cycle
   * param[2]: VISensor power cycle
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   * <b>added by io.dronefleet.mavlink.asluav package</b>
   */
  @MavlinkEnumEntry(40002)
  MAV_CMD_PAYLOAD_CONTROL,

  /**
   * Request storage of different parameter values and logs. This command will be only accepted if in pre-flight mode.
   * param[1]: Storage action: Action defined by MAV_PREFLIGHT_STORAGE_ACTION_ADVANCED
   * param[2]: Storage area as defined by parameter database
   * param[3]: Storage flags as defined by parameter database
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   * <b>added by io.dronefleet.mavlink.matrixpilot package</b>
   */
  @MavlinkEnumEntry(0)
  MAV_CMD_PREFLIGHT_STORAGE_ADVANCED,

  /**
   * Orbit a waypoint.
   * param[1]: Orbit radius in meters
   * param[2]: Loiter time in decimal seconds
   * param[3]: Maximum horizontal speed in m/s
   * param[4]: Desired yaw angle at waypoint
   * param[5]: Latitude
   * param[6]: Longitude
   * param[7]: Altitude
   * <b>added by io.dronefleet.mavlink.autoquad package</b>
   */
  @MavlinkEnumEntry(1)
  MAV_CMD_AQ_NAV_LEG_ORBIT,

  /**
   * Start/stop AutoQuad telemetry values stream.
   * param[1]: Start or stop (1 or 0)
   * param[2]: Stream frequency in us
   * param[3]: Dataset ID (refer to aq_mavlink.h::mavlinkCustomDataSets enum in AQ flight controller code)
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   * <b>added by io.dronefleet.mavlink.autoquad package</b>
   */
  @MavlinkEnumEntry(2)
  MAV_CMD_AQ_TELEMETRY,

  /**
   * Request AutoQuad firmware version number.
   * param[1]: Empty
   * param[2]: Empty
   * param[3]: Empty
   * param[4]: Empty
   * param[5]: Empty
   * param[6]: Empty
   * param[7]: Empty
   * <b>added by io.dronefleet.mavlink.autoquad package</b>
   */
  @MavlinkEnumEntry(4)
  MAV_CMD_AQ_REQUEST_VERSION
}
