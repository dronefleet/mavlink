package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;
import java.lang.Deprecated;

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
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Hold time in decimal seconds. (ignored by fixed wing, time to stay at waypoint for rotary wing)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Acceptance radius in meters (if the sphere with this radius is hit, the waypoint counts as 
     * reached)</dd>
     *
     *   <dt>param3</dt>
     *   <dd>0 to pass through the WP, if &gt; 0 radius in meters to pass by WP. Positive value for clockwise orbit, 
     * negative value for counter-clockwise orbit. Allows trajectory control.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Desired yaw angle at waypoint (rotary wing). NaN for unchanged.</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Latitude</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Longitude</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Altitude</dd>
     * </dl>
     */
    @MavlinkEntryInfo(16)
    MAV_CMD_NAV_WAYPOINT,

    /**
     * Loiter around this waypoint an unlimited amount of time 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Radius around waypoint, in meters. If positive loiter clockwise, else counter-clockwise</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Desired yaw angle.</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Latitude</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Longitude</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Altitude</dd>
     * </dl>
     */
    @MavlinkEntryInfo(17)
    MAV_CMD_NAV_LOITER_UNLIM,

    /**
     * Loiter around this waypoint for X turns 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Turns</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Radius around waypoint, in meters. If positive loiter clockwise, else counter-clockwise</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Forward moving aircraft this sets exit xtrack location: 0 for center of loiter wp, 1 for exit 
     * location. Else, this is desired yaw angle</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Latitude</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Longitude</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Altitude</dd>
     * </dl>
     */
    @MavlinkEntryInfo(18)
    MAV_CMD_NAV_LOITER_TURNS,

    /**
     * Loiter around this waypoint for X seconds 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Seconds (decimal)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Radius around waypoint, in meters. If positive loiter clockwise, else counter-clockwise</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Forward moving aircraft this sets exit xtrack location: 0 for center of loiter wp, 1 for exit 
     * location. Else, this is desired yaw angle</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Latitude</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Longitude</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Altitude</dd>
     * </dl>
     */
    @MavlinkEntryInfo(19)
    MAV_CMD_NAV_LOITER_TIME,

    /**
     * Return to launch location 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(20)
    MAV_CMD_NAV_RETURN_TO_LAUNCH,

    /**
     * Land at location. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Minimum target altitude if landing is aborted (0 = undefined/use system default).</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Precision land mode.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Desired yaw angle. NaN for unchanged.</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Latitude.</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Longitude.</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Landing altitude (ground level in current frame).</dd>
     * </dl>
     */
    @MavlinkEntryInfo(21)
    MAV_CMD_NAV_LAND,

    /**
     * Takeoff from ground / hand 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Minimum pitch (if airspeed sensor present), desired pitch without sensor</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Yaw angle (if magnetometer present), ignored without magnetometer. NaN for unchanged.</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Latitude</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Longitude</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Altitude</dd>
     * </dl>
     */
    @MavlinkEntryInfo(22)
    MAV_CMD_NAV_TAKEOFF,

    /**
     * Land at local position (local frame only) 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Landing target number (if available)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Maximum accepted offset from desired landing position [m] - computed magnitude from 
     * spherical coordinates: d = sqrt(x^2 + y^2 + z^2), which gives the maximum accepted distance 
     * between the desired landing position and the position where the vehicle is about to land</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Landing descend rate [ms^-1]</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Desired yaw angle [rad]</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Y-axis position [m]</dd>
     *
     *   <dt>param6</dt>
     *   <dd>X-axis position [m]</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Z-axis / ground level position [m]</dd>
     * </dl>
     */
    @MavlinkEntryInfo(23)
    MAV_CMD_NAV_LAND_LOCAL,

    /**
     * Takeoff from local position (local frame only) 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Minimum pitch (if airspeed sensor present), desired pitch without sensor [rad]</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Takeoff ascend rate [ms^-1]</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Yaw angle [rad] (if magnetometer or another yaw estimation source present), ignored without 
     * one of these</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Y-axis position [m]</dd>
     *
     *   <dt>param6</dt>
     *   <dd>X-axis position [m]</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Z-axis position [m]</dd>
     * </dl>
     */
    @MavlinkEntryInfo(24)
    MAV_CMD_NAV_TAKEOFF_LOCAL,

    /**
     * Vehicle following, i.e. this waypoint represents the position of a moving vehicle 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Following logic to use (e.g. loitering or sinusoidal following) - depends on specific 
     * autopilot implementation</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Ground speed of vehicle to be followed</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Radius around waypoint, in meters. If positive loiter clockwise, else counter-clockwise</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Desired yaw angle.</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Latitude</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Longitude</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Altitude</dd>
     * </dl>
     */
    @MavlinkEntryInfo(25)
    MAV_CMD_NAV_FOLLOW,

    /**
     * Continue on the current course and climb/descend to specified altitude. When the altitude is 
     * reached continue to the next command (i.e., don't proceed to the next command until the desired 
     * altitude is reached. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Climb or Descend (0 = Neutral, command completes when within 5m of this command's altitude, 1 = 
     * Climbing, command completes when at or above this command's altitude, 2 = Descending, command 
     * completes when at or below this command's altitude.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Desired altitude in meters</dd>
     * </dl>
     */
    @MavlinkEntryInfo(30)
    MAV_CMD_NAV_CONTINUE_AND_CHANGE_ALT,

    /**
     * Begin loiter at the specified Latitude and Longitude. If Lat=Lon=0, then loiter at the current 
     * position. Don't consider the navigation command complete (don't leave loiter) until the 
     * altitude has been reached. Additionally, if the Heading Required parameter is non-zero the 
     * aircraft will not leave the loiter until heading toward the next waypoint. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Heading Required (0 = False)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Radius in meters. If positive loiter clockwise, negative counter-clockwise, 0 means no 
     * change to standard loiter.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Forward moving aircraft this sets exit xtrack location: 0 for center of loiter wp, 1 for exit 
     * location</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Latitude</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Longitude</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Altitude</dd>
     * </dl>
     */
    @MavlinkEntryInfo(31)
    MAV_CMD_NAV_LOITER_TO_ALT,

    /**
     * Being following a target 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>System ID (the system ID of the {@link io.dronefleet.mavlink.common.FollowTarget FOLLOW_TARGET} beacon). Send 0 to disable follow-me and return to 
     * the default position hold mode</dd>
     *
     *   <dt>param2</dt>
     *   <dd>RESERVED</dd>
     *
     *   <dt>param3</dt>
     *   <dd>RESERVED</dd>
     *
     *   <dt>param4</dt>
     *   <dd>altitude flag: 0: Keep current altitude, 1: keep altitude difference to target, 2: go to a fixed 
     * altitude above home</dd>
     *
     *   <dt>param5</dt>
     *   <dd>altitude</dd>
     *
     *   <dt>param6</dt>
     *   <dd>RESERVED</dd>
     *
     *   <dt>param7</dt>
     *   <dd>TTL in seconds in which the MAV should go to the default position hold mode after a message rx 
     * timeout</dd>
     * </dl>
     */
    @MavlinkEntryInfo(32)
    MAV_CMD_DO_FOLLOW,

    /**
     * Reposition the MAV after a follow target command has been sent 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Camera q1 (where 0 is on the ray from the camera to the tracking device)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Camera q2</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Camera q3</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Camera q4</dd>
     *
     *   <dt>param5</dt>
     *   <dd>altitude offset from target (m)</dd>
     *
     *   <dt>param6</dt>
     *   <dd>X offset from target (m)</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Y offset from target (m)</dd>
     * </dl>
     */
    @MavlinkEntryInfo(33)
    MAV_CMD_DO_FOLLOW_REPOSITION,

    /**
     * Start orbiting on the circumference of a circle defined by the parameters. Setting any value 
     * NaN results in using defaults. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Radius of the circle in meters. positive: Orbit clockwise. negative: Orbit 
     * counter-clockwise.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Velocity tangential in m/s. NaN: Vehicle configuration default.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Yaw behavior of the vehicle. 0: vehicle front points to the center (default). 1: Hold last 
     * heading. 2: Leave yaw uncontrolled.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Reserved (e.g. for dynamic center beacon options)</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Center point latitude (if no {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME} specified) / X coordinate according to {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME}. NaN: 
     * Use current vehicle position or current center if already orbiting.</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Center point longitude (if no {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME} specified) / Y coordinate according to {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME}. 
     * NaN: Use current vehicle position or current center if already orbiting.</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Center point altitude (MSL) (if no {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME} specified) / Z coordinate according to 
     * {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME}. NaN: Use current vehicle position or current center if already orbiting.</dd>
     * </dl>
     */
    @MavlinkEntryInfo(34)
    MAV_CMD_DO_ORBIT,

    /**
     * Sets the region of interest (ROI) for a sensor set or the vehicle itself. This can then be used by 
     * the vehicles control system to control the vehicle attitude and the attitude of various 
     * sensors such as cameras. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Region of interest mode. (see {@link io.dronefleet.mavlink.common.MavRoi MAV_ROI} enum)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Waypoint index/ target ID. (see {@link io.dronefleet.mavlink.common.MavRoi MAV_ROI} enum)</dd>
     *
     *   <dt>param3</dt>
     *   <dd>ROI index (allows a vehicle to manage multiple ROI's)</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>x the location of the fixed ROI (see {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME})</dd>
     *
     *   <dt>param6</dt>
     *   <dd>y</dd>
     *
     *   <dt>param7</dt>
     *   <dd>z</dd>
     * </dl>
     * @deprecated Since 2018-01, replaced by MAV_CMD_DO_SET_ROI_*. 
     */
    @MavlinkEntryInfo(80)
    @Deprecated
    MAV_CMD_NAV_ROI,

    /**
     * Control autonomous path planning on the MAV. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>0: Disable local obstacle avoidance / local path planning (without resetting map), 1: Enable 
     * local path planning, 2: Enable and reset local path planning</dd>
     *
     *   <dt>param2</dt>
     *   <dd>0: Disable full path planning (without resetting map), 1: Enable, 2: Enable and reset 
     * map/occupancy grid, 3: Enable and reset planned route, but not occupancy grid</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Yaw angle at goal, in compass degrees, [0..360]</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Latitude/X of goal</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Longitude/Y of goal</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Altitude/Z of goal</dd>
     * </dl>
     */
    @MavlinkEntryInfo(81)
    MAV_CMD_NAV_PATHPLANNING,

    /**
     * Navigate to waypoint using a spline path. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Hold time in decimal seconds. (ignored by fixed wing, time to stay at waypoint for rotary wing)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Latitude/X of goal</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Longitude/Y of goal</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Altitude/Z of goal</dd>
     * </dl>
     */
    @MavlinkEntryInfo(82)
    MAV_CMD_NAV_SPLINE_WAYPOINT,

    /**
     * Takeoff from ground using VTOL mode, and transition to forward flight with specified heading. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Front transition heading.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Yaw angle in degrees. NaN for unchanged.</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Latitude</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Longitude</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Altitude</dd>
     * </dl>
     */
    @MavlinkEntryInfo(84)
    MAV_CMD_NAV_VTOL_TAKEOFF,

    /**
     * Land using VTOL mode 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Approach altitude (with the same reference as the Altitude field). NaN if unspecified.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Yaw angle in degrees. NaN for unchanged.</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Latitude</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Longitude</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Altitude (ground level)</dd>
     * </dl>
     */
    @MavlinkEntryInfo(85)
    MAV_CMD_NAV_VTOL_LAND,

    /**
     * hand control over to an external controller 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>On / Off (&gt; 0.5f on)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(92)
    MAV_CMD_NAV_GUIDED_ENABLE,

    /**
     * Delay the next navigation command a number of seconds or until a specified time 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Delay in seconds (decimal, -1 to enable time-of-day fields)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>hour (24h format, UTC, -1 to ignore)</dd>
     *
     *   <dt>param3</dt>
     *   <dd>minute (24h format, UTC, -1 to ignore)</dd>
     *
     *   <dt>param4</dt>
     *   <dd>second (24h format, UTC)</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(93)
    MAV_CMD_NAV_DELAY,

    /**
     * Descend and place payload. Vehicle descends until it detects a hanging payload has reached the 
     * ground, the gripper is opened to release the payload 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Maximum distance to descend (meters)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Latitude (deg * 1E7)</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Longitude (deg * 1E7)</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Altitude (meters)</dd>
     * </dl>
     */
    @MavlinkEntryInfo(94)
    MAV_CMD_NAV_PAYLOAD_PLACE,

    /**
     * NOP - This command is only used to mark the upper limit of the NAV/ACTION commands in the 
     * enumeration 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(95)
    MAV_CMD_NAV_LAST,

    /**
     * Delay mission state machine. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Delay in seconds (decimal)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(112)
    MAV_CMD_CONDITION_DELAY,

    /**
     * Ascend/descend at rate. Delay mission state machine until desired altitude reached. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Descent / Ascend rate (m/s)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Finish Altitude</dd>
     * </dl>
     */
    @MavlinkEntryInfo(113)
    MAV_CMD_CONDITION_CHANGE_ALT,

    /**
     * Delay mission state machine until within desired distance of next NAV point. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Distance (meters)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(114)
    MAV_CMD_CONDITION_DISTANCE,

    /**
     * Reach a certain target angle. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>target angle: [0-360], 0 is north</dd>
     *
     *   <dt>param2</dt>
     *   <dd>speed during yaw change:[deg per second]</dd>
     *
     *   <dt>param3</dt>
     *   <dd>direction: negative: counter clockwise, positive: clockwise [-1,1]</dd>
     *
     *   <dt>param4</dt>
     *   <dd>relative offset or absolute angle: [ 1,0]</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(115)
    MAV_CMD_CONDITION_YAW,

    /**
     * NOP - This command is only used to mark the upper limit of the CONDITION commands in the 
     * enumeration 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(159)
    MAV_CMD_CONDITION_LAST,

    /**
     * Set system mode. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Mode, as defined by ENUM {@link io.dronefleet.mavlink.common.MavMode MAV_MODE}</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Custom mode - this is system specific, please refer to the individual autopilot 
     * specifications for details.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Custom sub mode - this is system specific, please refer to the individual autopilot 
     * specifications for details.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(176)
    MAV_CMD_DO_SET_MODE,

    /**
     * Jump to the desired command in the mission list. Repeat this action only the specified number of 
     * times 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Sequence number</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Repeat count</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(177)
    MAV_CMD_DO_JUMP,

    /**
     * Change speed and/or throttle set points. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Speed type (0=Airspeed, 1=Ground Speed, 2=Climb Speed, 3=Descent Speed)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Speed (m/s, -1 indicates no change)</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Throttle ( Percent, -1 indicates no change)</dd>
     *
     *   <dt>param4</dt>
     *   <dd>absolute or relative [0,1]</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(178)
    MAV_CMD_DO_CHANGE_SPEED,

    /**
     * Changes the home location either to the current location or a specified location. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Use current (1=use current location, 0=use specified location)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Latitude</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Longitude</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Altitude</dd>
     * </dl>
     */
    @MavlinkEntryInfo(179)
    MAV_CMD_DO_SET_HOME,

    /**
     * Set a system parameter. Caution! Use of this command requires knowledge of the numeric 
     * enumeration value of the parameter. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Parameter number</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Parameter value</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(180)
    MAV_CMD_DO_SET_PARAMETER,

    /**
     * Set a relay to a condition. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Relay number</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Setting (1=on, 0=off, others possible depending on system hardware)</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(181)
    MAV_CMD_DO_SET_RELAY,

    /**
     * Cycle a relay on and off for a desired number of cycles with a desired period. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Relay number</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Cycle count</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Cycle time (seconds, decimal)</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(182)
    MAV_CMD_DO_REPEAT_RELAY,

    /**
     * Set a servo to a desired PWM value. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Servo number</dd>
     *
     *   <dt>param2</dt>
     *   <dd>PWM (microseconds, 1000 to 2000 typical)</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(183)
    MAV_CMD_DO_SET_SERVO,

    /**
     * Cycle a between its nominal setting and a desired PWM for a desired number of cycles with a 
     * desired period. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Servo number</dd>
     *
     *   <dt>param2</dt>
     *   <dd>PWM (microseconds, 1000 to 2000 typical)</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Cycle count</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Cycle time (seconds)</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(184)
    MAV_CMD_DO_REPEAT_SERVO,

    /**
     * Terminate flight immediately 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Flight termination activated if &gt; 0.5</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(185)
    MAV_CMD_DO_FLIGHTTERMINATION,

    /**
     * Change altitude set point. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Altitude in meters</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Mav frame of new altitude (see {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME})</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(186)
    MAV_CMD_DO_CHANGE_ALTITUDE,

    /**
     * Mission command to perform a landing. This is used as a marker in a mission to tell the autopilot 
     * where a sequence of mission items that represents a landing starts. It may also be sent via a 
     * {@link io.dronefleet.mavlink.common.CommandLong COMMAND_LONG} to trigger a landing, in which case the nearest (geographically) landing 
     * sequence in the mission will be used. The Latitude/Longitude is optional, and may be set to 0 if 
     * not needed. If specified then it will be used to help find the closest landing sequence. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Latitude</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Longitude</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(189)
    MAV_CMD_DO_LAND_START,

    /**
     * Mission command to perform a landing from a rally point. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Break altitude (meters)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Landing speed (m/s)</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(190)
    MAV_CMD_DO_RALLY_LAND,

    /**
     * Mission command to safely abort an autonomous landing. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Altitude (meters)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(191)
    MAV_CMD_DO_GO_AROUND,

    /**
     * Reposition the vehicle to a specific WGS84 global position. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Ground speed, less than 0 (-1) for default</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Bitmask of option flags, see the {@link io.dronefleet.mavlink.common.MavDoRepositionFlags MAV_DO_REPOSITION_FLAGS} enum.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Yaw heading, NaN for unchanged. For planes indicates loiter direction (0: clockwise, 1: 
     * counter clockwise)</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Latitude (deg * 1E7)</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Longitude (deg * 1E7)</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Altitude (meters)</dd>
     * </dl>
     */
    @MavlinkEntryInfo(192)
    MAV_CMD_DO_REPOSITION,

    /**
     * If in a GPS controlled position mode, hold the current position or continue. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>0: Pause current mission or reposition command, hold current position. 1: Continue mission. A 
     * VTOL capable vehicle should enter hover mode (multicopter and VTOL planes). A plane should 
     * loiter with the default loiter radius.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Reserved</dd>
     * </dl>
     */
    @MavlinkEntryInfo(193)
    MAV_CMD_DO_PAUSE_CONTINUE,

    /**
     * Set moving direction to forward or reverse. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Direction (0=Forward, 1=Reverse)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(194)
    MAV_CMD_DO_SET_REVERSE,

    /**
     * Sets the region of interest (ROI) to a location. This can then be used by the vehicles control 
     * system to control the vehicle attitude and the attitude of various sensors such as cameras. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Latitude</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Longitude</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Altitude</dd>
     * </dl>
     */
    @MavlinkEntryInfo(195)
    MAV_CMD_DO_SET_ROI_LOCATION,

    /**
     * Sets the region of interest (ROI) to be toward next waypoint, with optional pitch/roll/yaw 
     * offset. This can then be used by the vehicles control system to control the vehicle attitude and 
     * the attitude of various sensors such as cameras. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>pitch offset from next waypoint</dd>
     *
     *   <dt>param6</dt>
     *   <dd>roll offset from next waypoint</dd>
     *
     *   <dt>param7</dt>
     *   <dd>yaw offset from next waypoint</dd>
     * </dl>
     */
    @MavlinkEntryInfo(196)
    MAV_CMD_DO_SET_ROI_WPNEXT_OFFSET,

    /**
     * Cancels any previous ROI command returning the vehicle/sensors to default flight 
     * characteristics. This can then be used by the vehicles control system to control the vehicle 
     * attitude and the attitude of various sensors such as cameras. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(197)
    MAV_CMD_DO_SET_ROI_NONE,

    /**
     * Control onboard camera system. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Camera ID (-1 for all)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Transmission: 0: disabled, 1: enabled compressed, 2: enabled raw</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Transmission mode: 0: video stream, &gt;0: single images every n seconds (decimal)</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Recording: 0: disabled, 1: enabled compressed, 2: enabled raw</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(200)
    MAV_CMD_DO_CONTROL_VIDEO,

    /**
     * Sets the region of interest (ROI) for a sensor set or the vehicle itself. This can then be used by 
     * the vehicles control system to control the vehicle attitude and the attitude of various 
     * sensors such as cameras. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Region of interest mode. (see {@link io.dronefleet.mavlink.common.MavRoi MAV_ROI} enum)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Waypoint index/ target ID. (see {@link io.dronefleet.mavlink.common.MavRoi MAV_ROI} enum)</dd>
     *
     *   <dt>param3</dt>
     *   <dd>ROI index (allows a vehicle to manage multiple ROI's)</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>MAV_ROI_WPNEXT: pitch offset from next waypoint, MAV_ROI_LOCATION: latitude</dd>
     *
     *   <dt>param6</dt>
     *   <dd>MAV_ROI_WPNEXT: roll offset from next waypoint, MAV_ROI_LOCATION: longitude</dd>
     *
     *   <dt>param7</dt>
     *   <dd>MAV_ROI_WPNEXT: yaw offset from next waypoint, MAV_ROI_LOCATION: altitude</dd>
     * </dl>
     * @deprecated Since 2018-01, replaced by MAV_CMD_DO_SET_ROI_*. 
     */
    @MavlinkEntryInfo(201)
    @Deprecated
    MAV_CMD_DO_SET_ROI,

    /**
     * Configure digital camera. This is a fallback message for systems that have not yet implemented 
     * PARAM_EXT_XXX messages and camera definition files (see 
     * https://mavlink.io/en/services/camera_def.html ). 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Modes: P, TV, AV, M, Etc</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Shutter speed: Divisor number for one second</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Aperture: F stop number</dd>
     *
     *   <dt>param4</dt>
     *   <dd>ISO number e.g. 80, 100, 200, Etc</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Exposure type enumerator</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Command Identity</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Main engine cut-off time before camera trigger in seconds/10 (0 means no cut-off)</dd>
     * </dl>
     */
    @MavlinkEntryInfo(202)
    MAV_CMD_DO_DIGICAM_CONFIGURE,

    /**
     * Control digital camera. This is a fallback message for systems that have not yet implemented 
     * PARAM_EXT_XXX messages and camera definition files (see 
     * https://mavlink.io/en/services/camera_def.html ). 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Session control e.g. show/hide lens</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Zoom's absolute position</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Zooming step value to offset zoom from the current position</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Focus Locking, Unlocking or Re-locking</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Shooting Command</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Command Identity</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Test shot identifier. If set to 1, image will only be captured, but not counted towards internal 
     * frame count.</dd>
     * </dl>
     */
    @MavlinkEntryInfo(203)
    MAV_CMD_DO_DIGICAM_CONTROL,

    /**
     * Mission command to configure a camera or antenna mount 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Mount operation mode (see {@link io.dronefleet.mavlink.common.MavMountMode MAV_MOUNT_MODE} enum)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>stabilize roll? (1 = yes, 0 = no)</dd>
     *
     *   <dt>param3</dt>
     *   <dd>stabilize pitch? (1 = yes, 0 = no)</dd>
     *
     *   <dt>param4</dt>
     *   <dd>stabilize yaw? (1 = yes, 0 = no)</dd>
     *
     *   <dt>param5</dt>
     *   <dd>roll input (0 = angle body frame, 1 = angular rate, 2 = angle absolute frame)</dd>
     *
     *   <dt>param6</dt>
     *   <dd>pitch input (0 = angle body frame, 1 = angular rate, 2 = angle absolute frame)</dd>
     *
     *   <dt>param7</dt>
     *   <dd>yaw input (0 = angle body frame, 1 = angular rate, 2 = angle absolute frame)</dd>
     * </dl>
     */
    @MavlinkEntryInfo(204)
    MAV_CMD_DO_MOUNT_CONFIGURE,

    /**
     * Mission command to control a camera or antenna mount 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>pitch depending on mount mode (degrees or degrees/second depending on pitch input).</dd>
     *
     *   <dt>param2</dt>
     *   <dd>roll depending on mount mode (degrees or degrees/second depending on roll input).</dd>
     *
     *   <dt>param3</dt>
     *   <dd>yaw depending on mount mode (degrees or degrees/second depending on yaw input).</dd>
     *
     *   <dt>param4</dt>
     *   <dd>alt in meters depending on mount mode.</dd>
     *
     *   <dt>param5</dt>
     *   <dd>latitude in degrees * 1E7, set if appropriate mount mode.</dd>
     *
     *   <dt>param6</dt>
     *   <dd>longitude in degrees * 1E7, set if appropriate mount mode.</dd>
     *
     *   <dt>param7</dt>
     *   <dd>{@link io.dronefleet.mavlink.common.MavMountMode MAV_MOUNT_MODE} enum value</dd>
     * </dl>
     */
    @MavlinkEntryInfo(205)
    MAV_CMD_DO_MOUNT_CONTROL,

    /**
     * Mission command to set camera trigger distance for this flight. The camera is triggered each 
     * time this distance is exceeded. This command can also be used to set the shutter integration 
     * time for the camera. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Camera trigger distance (meters). 0 to stop triggering.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Camera shutter integration time (milliseconds). -1 or 0 to ignore</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Trigger camera once immediately. (0 = no trigger, 1 = trigger)</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(206)
    MAV_CMD_DO_SET_CAM_TRIGG_DIST,

    /**
     * Mission command to enable the geofence 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>enable? (0=disable, 1=enable, 2=disable_floor_only)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(207)
    MAV_CMD_DO_FENCE_ENABLE,

    /**
     * Mission command to trigger a parachute 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>action (0=disable, 1=enable, 2=release, for some systems see PARACHUTE_ACTION enum, not in 
     * general message set.)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(208)
    MAV_CMD_DO_PARACHUTE,

    /**
     * Mission command to perform motor test 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>motor number (a number from 1 to max number of motors on the vehicle)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>throttle type (0=throttle percentage, 1=PWM, 2=pilot throttle channel pass-through. See 
     * {@link io.dronefleet.mavlink.common.MotorTestThrottleType MOTOR_TEST_THROTTLE_TYPE} enum)</dd>
     *
     *   <dt>param3</dt>
     *   <dd>throttle</dd>
     *
     *   <dt>param4</dt>
     *   <dd>timeout (in seconds)</dd>
     *
     *   <dt>param5</dt>
     *   <dd>motor count (number of motors to test to test in sequence, waiting for the timeout above between 
     * them; 0=1 motor, 1=1 motor, 2=2 motors...)</dd>
     *
     *   <dt>param6</dt>
     *   <dd>motor test order (See {@link io.dronefleet.mavlink.common.MotorTestOrder MOTOR_TEST_ORDER} enum)</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(209)
    MAV_CMD_DO_MOTOR_TEST,

    /**
     * Change to/from inverted flight 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>inverted (0=normal, 1=inverted)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(210)
    MAV_CMD_DO_INVERTED_FLIGHT,

    /**
     * Sets a desired vehicle turn angle and speed change 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>yaw angle to adjust steering by in centidegress</dd>
     *
     *   <dt>param2</dt>
     *   <dd>speed - normalized to 0 .. 1</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(213)
    MAV_CMD_NAV_SET_YAW_SPEED,

    /**
     * Mission command to set camera trigger interval for this flight. If triggering is enabled, the 
     * camera is triggered each time this interval expires. This command can also be used to set the 
     * shutter integration time for the camera. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Camera trigger cycle time (milliseconds). -1 or 0 to ignore.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Camera shutter integration time (milliseconds). Should be less than trigger cycle time. -1 or 
     * 0 to ignore.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(214)
    MAV_CMD_DO_SET_CAM_TRIGG_INTERVAL,

    /**
     * Mission command to control a camera or antenna mount, using a quaternion as reference. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>q1 - quaternion param #1, w (1 in null-rotation)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>q2 - quaternion param #2, x (0 in null-rotation)</dd>
     *
     *   <dt>param3</dt>
     *   <dd>q3 - quaternion param #3, y (0 in null-rotation)</dd>
     *
     *   <dt>param4</dt>
     *   <dd>q4 - quaternion param #4, z (0 in null-rotation)</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(220)
    MAV_CMD_DO_MOUNT_CONTROL_QUAT,

    /**
     * set id of master controller 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>System ID</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Component ID</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(221)
    MAV_CMD_DO_GUIDED_MASTER,

    /**
     * Set limits for external control 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Timeout - maximum time (in seconds) that external controller will be allowed to control 
     * vehicle. 0 means no timeout.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Altitude (MSL) min, in meters - if vehicle moves below this alt, the command will be aborted and 
     * the mission will continue. 0 means no lower altitude limit.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Altitude (MSL) max, in meters - if vehicle moves above this alt, the command will be aborted and 
     * the mission will continue. 0 means no upper altitude limit.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Horizontal move limit, in meters - if vehicle moves more than this distance from its location at 
     * the moment the command was executed, the command will be aborted and the mission will continue. 
     * 0 means no horizontal move limit.</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(222)
    MAV_CMD_DO_GUIDED_LIMITS,

    /**
     * Control vehicle engine. This is interpreted by the vehicles engine controller to change the 
     * target engine state. It is intended for vehicles with internal combustion engines 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>0: Stop engine, 1:Start Engine</dd>
     *
     *   <dt>param2</dt>
     *   <dd>0: Warm start, 1:Cold start. Controls use of choke where applicable</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Height delay (meters). This is for commanding engine start only after the vehicle has gained 
     * the specified height. Used in VTOL vehicles during takeoff to start engine after the aircraft 
     * is off the ground. Zero for no delay.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(223)
    MAV_CMD_DO_ENGINE_CONTROL,

    /**
     * Set the mission item with sequence number seq as current item. This means that the MAV will 
     * continue to this mission item on the shortest path (not following the mission items 
     * in-between). 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Mission sequence value to set</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(224)
    MAV_CMD_DO_SET_MISSION_CURRENT,

    /**
     * NOP - This command is only used to mark the upper limit of the DO commands in the enumeration 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(240)
    MAV_CMD_DO_LAST,

    /**
     * Trigger calibration. This command will be only accepted if in pre-flight mode. Except for 
     * Temperature Calibration, only one sensor should be set in a single message and all others 
     * should be zero. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>1: gyro calibration, 3: gyro temperature calibration</dd>
     *
     *   <dt>param2</dt>
     *   <dd>1: magnetometer calibration</dd>
     *
     *   <dt>param3</dt>
     *   <dd>1: ground pressure calibration</dd>
     *
     *   <dt>param4</dt>
     *   <dd>1: radio RC calibration, 2: RC trim calibration</dd>
     *
     *   <dt>param5</dt>
     *   <dd>1: accelerometer calibration, 2: board level calibration, 3: accelerometer temperature 
     * calibration, 4: simple accelerometer calibration</dd>
     *
     *   <dt>param6</dt>
     *   <dd>1: APM: compass/motor interference calibration (PX4: airspeed calibration, deprecated), 
     * 2: airspeed calibration</dd>
     *
     *   <dt>param7</dt>
     *   <dd>1: ESC calibration, 3: barometer temperature calibration</dd>
     * </dl>
     */
    @MavlinkEntryInfo(241)
    MAV_CMD_PREFLIGHT_CALIBRATION,

    /**
     * Set sensor offsets. This command will be only accepted if in pre-flight mode. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Sensor to adjust the offsets for: 0: gyros, 1: accelerometer, 2: magnetometer, 3: barometer, 
     * 4: optical flow, 5: second magnetometer, 6: third magnetometer</dd>
     *
     *   <dt>param2</dt>
     *   <dd>X axis offset (or generic dimension 1), in the sensor's raw units</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Y axis offset (or generic dimension 2), in the sensor's raw units</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Z axis offset (or generic dimension 3), in the sensor's raw units</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Generic dimension 4, in the sensor's raw units</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Generic dimension 5, in the sensor's raw units</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Generic dimension 6, in the sensor's raw units</dd>
     * </dl>
     */
    @MavlinkEntryInfo(242)
    MAV_CMD_PREFLIGHT_SET_SENSOR_OFFSETS,

    /**
     * Trigger UAVCAN config. This command will be only accepted if in pre-flight mode. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>1: Trigger actuator ID assignment and direction mapping.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Reserved</dd>
     * </dl>
     */
    @MavlinkEntryInfo(243)
    MAV_CMD_PREFLIGHT_UAVCAN,

    /**
     * Request storage of different parameter values and logs. This command will be only accepted if 
     * in pre-flight mode. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Parameter storage: 0: READ FROM FLASH/EEPROM, 1: WRITE CURRENT TO FLASH/EEPROM, 2: Reset to 
     * defaults</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Mission storage: 0: READ FROM FLASH/EEPROM, 1: WRITE CURRENT TO FLASH/EEPROM, 2: Reset to 
     * defaults</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Onboard logging: 0: Ignore, 1: Start default rate logging, -1: Stop logging, &gt; 1: start logging 
     * with rate of param 3 in Hz (e.g. set to 1000 for 1000 Hz logging)</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(245)
    MAV_CMD_PREFLIGHT_STORAGE,

    /**
     * Request the reboot or shutdown of system components. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>0: Do nothing for autopilot, 1: Reboot autopilot, 2: Shutdown autopilot, 3: Reboot autopilot 
     * and keep it in the bootloader until upgraded.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>0: Do nothing for onboard computer, 1: Reboot onboard computer, 2: Shutdown onboard computer, 
     * 3: Reboot onboard computer and keep it in the bootloader until upgraded.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>WIP: 0: Do nothing for camera, 1: Reboot onboard camera, 2: Shutdown onboard camera, 3: Reboot 
     * onboard camera and keep it in the bootloader until upgraded</dd>
     *
     *   <dt>param4</dt>
     *   <dd>WIP: 0: Do nothing for mount (e.g. gimbal), 1: Reboot mount, 2: Shutdown mount, 3: Reboot mount 
     * and keep it in the bootloader until upgraded</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Reserved, send 0</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Reserved, send 0</dd>
     *
     *   <dt>param7</dt>
     *   <dd>WIP: ID (e.g. camera ID -1 for all IDs)</dd>
     * </dl>
     */
    @MavlinkEntryInfo(246)
    MAV_CMD_PREFLIGHT_REBOOT_SHUTDOWN,

    /**
     * Hold / continue the current action 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>MAV_GOTO_DO_HOLD: hold MAV_GOTO_DO_CONTINUE: continue with next item in mission plan</dd>
     *
     *   <dt>param2</dt>
     *   <dd>MAV_GOTO_HOLD_AT_CURRENT_POSITION: Hold at current position 
     * MAV_GOTO_HOLD_AT_SPECIFIED_POSITION: hold at specified position</dd>
     *
     *   <dt>param3</dt>
     *   <dd>{@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME} coordinate frame of hold point</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Desired yaw angle in degrees</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Latitude / X position</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Longitude / Y position</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Altitude / Z position</dd>
     * </dl>
     */
    @MavlinkEntryInfo(252)
    MAV_CMD_OVERRIDE_GOTO,

    /**
     * start running a mission 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>first_item: the first mission item to run</dd>
     *
     *   <dt>param2</dt>
     *   <dd>last_item: the last mission item to run (after this item is run, the mission ends)</dd>
     * </dl>
     */
    @MavlinkEntryInfo(300)
    MAV_CMD_MISSION_START,

    /**
     * Arms / Disarms a component 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>1 to arm, 0 to disarm</dd>
     * </dl>
     */
    @MavlinkEntryInfo(400)
    MAV_CMD_COMPONENT_ARM_DISARM,

    /**
     * Request the home position from the vehicle. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Reserved</dd>
     * </dl>
     */
    @MavlinkEntryInfo(410)
    MAV_CMD_GET_HOME_POSITION,

    /**
     * Starts receiver pairing 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>0:Spektrum</dd>
     *
     *   <dt>param2</dt>
     *   <dd>RC type (see {@link io.dronefleet.mavlink.common.RcType RC_TYPE} enum)</dd>
     * </dl>
     */
    @MavlinkEntryInfo(500)
    MAV_CMD_START_RX_PAIR,

    /**
     * Request the interval between messages for a particular MAVLink message ID 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>The MAVLink message ID</dd>
     * </dl>
     */
    @MavlinkEntryInfo(510)
    MAV_CMD_GET_MESSAGE_INTERVAL,

    /**
     * Set the interval between messages for a particular MAVLink message ID. This interface 
     * replaces {@link io.dronefleet.mavlink.common.RequestDataStream REQUEST_DATA_STREAM} 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>The MAVLink message ID</dd>
     *
     *   <dt>param2</dt>
     *   <dd>The interval between two messages, in microseconds. Set to -1 to disable and 0 to request 
     * default rate.</dd>
     * </dl>
     */
    @MavlinkEntryInfo(511)
    MAV_CMD_SET_MESSAGE_INTERVAL,

    /**
     * Request MAVLink protocol version compatibility 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>1: Request supported protocol versions by all nodes on the network</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Reserved (all remaining params)</dd>
     * </dl>
     */
    @MavlinkEntryInfo(519)
    MAV_CMD_REQUEST_PROTOCOL_VERSION,

    /**
     * Request autopilot capabilities 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>1: Request autopilot version</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Reserved (all remaining params)</dd>
     * </dl>
     */
    @MavlinkEntryInfo(520)
    MAV_CMD_REQUEST_AUTOPILOT_CAPABILITIES,

    /**
     * Request camera information ({@link io.dronefleet.mavlink.common.CameraInformation CAMERA_INFORMATION}). 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>0: No action 1: Request camera capabilities</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Reserved (all remaining params)</dd>
     * </dl>
     */
    @MavlinkEntryInfo(521)
    MAV_CMD_REQUEST_CAMERA_INFORMATION,

    /**
     * Request camera settings ({@link io.dronefleet.mavlink.common.CameraSettings CAMERA_SETTINGS}). 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>0: No Action 1: Request camera settings</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Reserved (all remaining params)</dd>
     * </dl>
     */
    @MavlinkEntryInfo(522)
    MAV_CMD_REQUEST_CAMERA_SETTINGS,

    /**
     * Request storage information ({@link io.dronefleet.mavlink.common.StorageInformation STORAGE_INFORMATION}). Use the command's target_component to 
     * target a specific component's storage. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Storage ID (0 for all, 1 for first, 2 for second, etc.)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>0: No Action 1: Request storage information</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Reserved (all remaining params)</dd>
     * </dl>
     */
    @MavlinkEntryInfo(525)
    MAV_CMD_REQUEST_STORAGE_INFORMATION,

    /**
     * Format a storage medium. Once format is complete, a {@link io.dronefleet.mavlink.common.StorageInformation STORAGE_INFORMATION} message is sent. Use 
     * the command's target_component to target a specific component's storage. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Storage ID (1 for first, 2 for second, etc.)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>0: No action 1: Format storage</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Reserved (all remaining params)</dd>
     * </dl>
     */
    @MavlinkEntryInfo(526)
    MAV_CMD_STORAGE_FORMAT,

    /**
     * Request camera capture status ({@link io.dronefleet.mavlink.common.CameraCaptureStatus CAMERA_CAPTURE_STATUS}) 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>0: No Action 1: Request camera capture status</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Reserved (all remaining params)</dd>
     * </dl>
     */
    @MavlinkEntryInfo(527)
    MAV_CMD_REQUEST_CAMERA_CAPTURE_STATUS,

    /**
     * Request flight information ({@link io.dronefleet.mavlink.common.FlightInformation FLIGHT_INFORMATION}) 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>1: Request flight information</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Reserved (all remaining params)</dd>
     * </dl>
     */
    @MavlinkEntryInfo(528)
    MAV_CMD_REQUEST_FLIGHT_INFORMATION,

    /**
     * Reset all camera settings to Factory Default 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>0: No Action 1: Reset all settings</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Reserved (all remaining params)</dd>
     * </dl>
     */
    @MavlinkEntryInfo(529)
    MAV_CMD_RESET_CAMERA_SETTINGS,

    /**
     * Set camera running mode. Use NaN for reserved values. GCS will send a 
     * MAV_CMD_REQUEST_VIDEO_STREAM_STATUS command after a mode change if the camera supports 
     * video streaming. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Reserved (Set to 0)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Camera mode</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Reserved (all remaining params)</dd>
     * </dl>
     */
    @MavlinkEntryInfo(530)
    MAV_CMD_SET_CAMERA_MODE,

    /**
     * Set camera zoom. Camera must respond with a {@link io.dronefleet.mavlink.common.CameraSettings CAMERA_SETTINGS} message (on success). Use NaN for 
     * reserved values. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Zoom type</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Zoom value. The range of valid values depend on the zoom type.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Reserved (all remaining params)</dd>
     * </dl>
     */
    @MavlinkEntryInfo(531)
    MAV_CMD_SET_CAMERA_ZOOM,

    /**
     * Set camera focus. Camera must respond with a {@link io.dronefleet.mavlink.common.CameraSettings CAMERA_SETTINGS} message (on success). Use NaN for 
     * reserved values. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Focus type</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Focus value</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Reserved (all remaining params)</dd>
     * </dl>
     */
    @MavlinkEntryInfo(532)
    MAV_CMD_SET_CAMERA_FOCUS,

    /**
     * Tagged jump target. Can be jumped to with MAV_CMD_DO_JUMP_TAG. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Tag.</dd>
     * </dl>
     */
    @MavlinkEntryInfo(600)
    MAV_CMD_JUMP_TAG,

    /**
     * Jump to the matching tag in the mission list. Repeat this action for the specified number of 
     * times. A mission should contain a single matching tag for each jump. If this is not the case then a 
     * jump to a missing tag should complete the mission, and a jump where there are multiple matching 
     * tags should always select the one with the lowest mission sequence number. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Target tag to jump to.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Repeat count</dd>
     * </dl>
     */
    @MavlinkEntryInfo(601)
    MAV_CMD_DO_JUMP_TAG,

    /**
     * Start image capture sequence. Sends {@link io.dronefleet.mavlink.common.CameraImageCaptured CAMERA_IMAGE_CAPTURED} after each capture. Use NaN for 
     * reserved values. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Reserved (Set to 0)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Desired elapsed time between two consecutive pictures (in seconds). Minimum values depend on 
     * hardware (typically greater than 2 seconds).</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Total number of images to capture. 0 to capture forever/until MAV_CMD_IMAGE_STOP_CAPTURE.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Capture sequence number starting from 1. This is only valid for single-capture (param3 == 1). 
     * Increment the capture ID for each capture command to prevent double captures when a command is 
     * re-transmitted. Use 0 to ignore it.</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Reserved (all remaining params)</dd>
     * </dl>
     */
    @MavlinkEntryInfo(2000)
    MAV_CMD_IMAGE_START_CAPTURE,

    /**
     * Stop image capture sequence Use NaN for reserved values. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Reserved (Set to 0)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Reserved (all remaining params)</dd>
     * </dl>
     */
    @MavlinkEntryInfo(2001)
    MAV_CMD_IMAGE_STOP_CAPTURE,

    /**
     * Re-request a CAMERA_IMAGE_CAPTURE message. Use NaN for reserved values. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Sequence number for missing CAMERA_IMAGE_CAPTURE message</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Reserved (all remaining params)</dd>
     * </dl>
     */
    @MavlinkEntryInfo(2002)
    MAV_CMD_REQUEST_CAMERA_IMAGE_CAPTURE,

    /**
     * Enable or disable on-board camera triggering system. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Trigger enable/disable (0 for disable, 1 for start), -1 to ignore</dd>
     *
     *   <dt>param2</dt>
     *   <dd>1 to reset the trigger sequence, -1 or 0 to ignore</dd>
     *
     *   <dt>param3</dt>
     *   <dd>1 to pause triggering, but without switching the camera off or retracting it. -1 to ignore</dd>
     * </dl>
     */
    @MavlinkEntryInfo(2003)
    MAV_CMD_DO_TRIGGER_CONTROL,

    /**
     * Starts video capture (recording). Use NaN for reserved values. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Video Stream ID (0 for all streams)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Frequency {@link io.dronefleet.mavlink.common.CameraCaptureStatus CAMERA_CAPTURE_STATUS} messages should be sent while recording (0 for no messages, 
     * otherwise frequency in Hz)</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Reserved (all remaining params)</dd>
     * </dl>
     */
    @MavlinkEntryInfo(2500)
    MAV_CMD_VIDEO_START_CAPTURE,

    /**
     * Stop the current video capture (recording). Use NaN for reserved values. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Video Stream ID (0 for all streams)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Reserved (all remaining params)</dd>
     * </dl>
     */
    @MavlinkEntryInfo(2501)
    MAV_CMD_VIDEO_STOP_CAPTURE,

    /**
     * Start video streaming 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Video Stream ID (0 for all streams, 1 for first, 2 for second, etc.)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Reserved</dd>
     * </dl>
     */
    @MavlinkEntryInfo(2502)
    MAV_CMD_VIDEO_START_STREAMING,

    /**
     * Stop the given video stream 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Video Stream ID (0 for all streams, 1 for first, 2 for second, etc.)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Reserved</dd>
     * </dl>
     */
    @MavlinkEntryInfo(2503)
    MAV_CMD_VIDEO_STOP_STREAMING,

    /**
     * Request video stream information ({@link io.dronefleet.mavlink.common.VideoStreamInformation VIDEO_STREAM_INFORMATION}) 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Video Stream ID (0 for all streams, 1 for first, 2 for second, etc.)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Reserved (all remaining params)</dd>
     * </dl>
     */
    @MavlinkEntryInfo(2504)
    MAV_CMD_REQUEST_VIDEO_STREAM_INFORMATION,

    /**
     * Request video stream status ({@link io.dronefleet.mavlink.common.VideoStreamStatus VIDEO_STREAM_STATUS}) 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Video Stream ID (0 for all streams, 1 for first, 2 for second, etc.)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Reserved (all remaining params)</dd>
     * </dl>
     */
    @MavlinkEntryInfo(2505)
    MAV_CMD_REQUEST_VIDEO_STREAM_STATUS,

    /**
     * Request to start streaming logging data over MAVLink (see also {@link io.dronefleet.mavlink.common.LoggingData LOGGING_DATA} message) 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Format: 0: ULog</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Reserved (set to 0)</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Reserved (set to 0)</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Reserved (set to 0)</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Reserved (set to 0)</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Reserved (set to 0)</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Reserved (set to 0)</dd>
     * </dl>
     */
    @MavlinkEntryInfo(2510)
    MAV_CMD_LOGGING_START,

    /**
     * Request to stop streaming log data over MAVLink 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Reserved (set to 0)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Reserved (set to 0)</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Reserved (set to 0)</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Reserved (set to 0)</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Reserved (set to 0)</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Reserved (set to 0)</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Reserved (set to 0)</dd>
     * </dl>
     */
    @MavlinkEntryInfo(2511)
    MAV_CMD_LOGGING_STOP,

    /**
     *  
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Landing gear ID (default: 0, -1 for all)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Landing gear position (Down: 0, Up: 1, NaN for no change)</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Reserved, set to NaN</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Reserved, set to NaN</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Reserved, set to NaN</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Reserved, set to NaN</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Reserved, set to NaN</dd>
     * </dl>
     */
    @MavlinkEntryInfo(2520)
    MAV_CMD_AIRFRAME_CONFIGURATION,

    /**
     * Request to start/stop transmitting over the high latency telemetry 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Control transmission over high latency telemetry (0: stop, 1: start)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(2600)
    MAV_CMD_CONTROL_HIGH_LATENCY,

    /**
     * Create a panorama at the current position 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Viewing angle horizontal of the panorama (in degrees, +- 0.5 the total angle)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Viewing angle vertical of panorama (in degrees)</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Speed of the horizontal rotation (in degrees per second)</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Speed of the vertical rotation (in degrees per second)</dd>
     * </dl>
     */
    @MavlinkEntryInfo(2800)
    MAV_CMD_PANORAMA_CREATE,

    /**
     * Request VTOL transition 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>The target VTOL state, as defined by ENUM {@link io.dronefleet.mavlink.common.MavVtolState MAV_VTOL_STATE}. Only MAV_VTOL_STATE_MC and 
     * MAV_VTOL_STATE_FW can be used.</dd>
     * </dl>
     */
    @MavlinkEntryInfo(3000)
    MAV_CMD_DO_VTOL_TRANSITION,

    /**
     * Request authorization to arm the vehicle to a external entity, the arm authorizer is 
     * responsible to request all data that is needs from the vehicle before authorize or deny the 
     * request. If approved the progress of command_ack message should be set with period of time that 
     * this authorization is valid in seconds or in case it was denied it should be set with one of the 
     * reasons in ARM_AUTH_DENIED_REASON. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Vehicle system id, this way ground station can request arm authorization on behalf of any 
     * vehicle</dd>
     * </dl>
     */
    @MavlinkEntryInfo(3001)
    MAV_CMD_ARM_AUTHORIZATION_REQUEST,

    /**
     * This command sets the submode to standard guided when vehicle is in guided mode. The vehicle 
     * holds position and altitude and the user can input the desired velocities along all three axes. 
     */
    @MavlinkEntryInfo(4000)
    MAV_CMD_SET_GUIDED_SUBMODE_STANDARD,

    /**
     * This command sets submode circle when vehicle is in guided mode. Vehicle flies along a circle 
     * facing the center of the circle. The user can input the velocity along the circle and change the 
     * radius. If no input is given the vehicle will hold position. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Radius of desired circle in CIRCLE_MODE</dd>
     *
     *   <dt>param2</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param3</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param4</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Unscaled target latitude of center of circle in CIRCLE_MODE</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Unscaled target longitude of center of circle in CIRCLE_MODE</dd>
     * </dl>
     */
    @MavlinkEntryInfo(4001)
    MAV_CMD_SET_GUIDED_SUBMODE_CIRCLE,

    /**
     * Delay mission state machine until gate has been reached. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Geometry: 0: orthogonal to path between previous and next waypoint.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Altitude: 0: ignore altitude</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Latitude</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Longitude</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Altitude</dd>
     * </dl>
     */
    @MavlinkEntryInfo(4501)
    MAV_CMD_CONDITION_GATE,

    /**
     * Fence return point. There can only be one fence return point. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Latitude</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Longitude</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Altitude</dd>
     * </dl>
     */
    @MavlinkEntryInfo(5000)
    MAV_CMD_NAV_FENCE_RETURN_POINT,

    /**
     * Fence vertex for an inclusion polygon (the polygon must not be self-intersecting). The 
     * vehicle must stay within this area. Minimum of 3 vertices required. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Polygon vertex count</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Latitude</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Longitude</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Reserved</dd>
     * </dl>
     */
    @MavlinkEntryInfo(5001)
    MAV_CMD_NAV_FENCE_POLYGON_VERTEX_INCLUSION,

    /**
     * Fence vertex for an exclusion polygon (the polygon must not be self-intersecting). The 
     * vehicle must stay outside this area. Minimum of 3 vertices required. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Polygon vertex count</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Latitude</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Longitude</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Reserved</dd>
     * </dl>
     */
    @MavlinkEntryInfo(5002)
    MAV_CMD_NAV_FENCE_POLYGON_VERTEX_EXCLUSION,

    /**
     * Circular fence area. The vehicle must stay inside this area. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>radius in meters</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Latitude</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Longitude</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Reserved</dd>
     * </dl>
     */
    @MavlinkEntryInfo(5003)
    MAV_CMD_NAV_FENCE_CIRCLE_INCLUSION,

    /**
     * Circular fence area. The vehicle must stay outside this area. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>radius in meters</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Latitude</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Longitude</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Reserved</dd>
     * </dl>
     */
    @MavlinkEntryInfo(5004)
    MAV_CMD_NAV_FENCE_CIRCLE_EXCLUSION,

    /**
     * Rally point. You can have multiple rally points defined. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Latitude</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Longitude</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Altitude</dd>
     * </dl>
     */
    @MavlinkEntryInfo(5100)
    MAV_CMD_NAV_RALLY_POINT,

    /**
     * Commands the vehicle to respond with a sequence of messages {@link io.dronefleet.mavlink.common.UavcanNodeInfo UAVCAN_NODE_INFO}, one message per 
     * every UAVCAN node that is online. Note that some of the response messages can be lost, which the 
     * receiver can detect easily by checking whether every received {@link io.dronefleet.mavlink.common.UavcanNodeStatus UAVCAN_NODE_STATUS} has a 
     * matching message {@link io.dronefleet.mavlink.common.UavcanNodeInfo UAVCAN_NODE_INFO} received earlier; if not, this command should be sent 
     * again in order to request re-transmission of the node information messages. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Reserved (set to 0)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Reserved (set to 0)</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Reserved (set to 0)</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Reserved (set to 0)</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Reserved (set to 0)</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Reserved (set to 0)</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Reserved (set to 0)</dd>
     * </dl>
     */
    @MavlinkEntryInfo(5200)
    MAV_CMD_UAVCAN_GET_NODE_INFO,

    /**
     * Deploy payload on a Lat / Lon / Alt position. This includes the navigation to reach the required 
     * release position and velocity. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Operation mode. 0: prepare single payload deploy (overwriting previous requests), but do not 
     * execute it. 1: execute payload deploy immediately (rejecting further deploy commands during 
     * execution, but allowing abort). 2: add payload deploy to existing deployment list.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Desired approach vector in degrees compass heading (0..360). A negative value indicates the 
     * system can define the approach vector at will.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Desired ground speed at release time. This can be overridden by the airframe in case it needs to 
     * meet minimum airspeed. A negative value indicates the system can define the ground speed at 
     * will.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Minimum altitude clearance to the release position in meters. A negative value indicates the 
     * system can define the clearance at will.</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Latitude unscaled for {@link io.dronefleet.mavlink.common.MissionItem MISSION_ITEM} or in 1e7 degrees for {@link io.dronefleet.mavlink.common.MissionItemInt MISSION_ITEM_INT}</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Longitude unscaled for {@link io.dronefleet.mavlink.common.MissionItem MISSION_ITEM} or in 1e7 degrees for {@link io.dronefleet.mavlink.common.MissionItemInt MISSION_ITEM_INT}</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Altitude (MSL), in meters</dd>
     * </dl>
     */
    @MavlinkEntryInfo(30001)
    MAV_CMD_PAYLOAD_PREPARE_DEPLOY,

    /**
     * Control the payload deployment. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Operation mode. 0: Abort deployment, continue normal mission. 1: switch to payload 
     * deployment mode. 100: delete first payload deployment request. 101: delete all payload 
     * deployment requests.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Reserved</dd>
     * </dl>
     */
    @MavlinkEntryInfo(30002)
    MAV_CMD_PAYLOAD_CONTROL_DEPLOY,

    /**
     * User defined waypoint item. Ground Station will show the Vehicle as flying through this item. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param2</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param3</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param4</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Latitude unscaled</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Longitude unscaled</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Altitude (MSL), in meters</dd>
     * </dl>
     */
    @MavlinkEntryInfo(31000)
    MAV_CMD_WAYPOINT_USER_1,

    /**
     * User defined waypoint item. Ground Station will show the Vehicle as flying through this item. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param2</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param3</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param4</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Latitude unscaled</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Longitude unscaled</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Altitude (MSL), in meters</dd>
     * </dl>
     */
    @MavlinkEntryInfo(31001)
    MAV_CMD_WAYPOINT_USER_2,

    /**
     * User defined waypoint item. Ground Station will show the Vehicle as flying through this item. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param2</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param3</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param4</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Latitude unscaled</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Longitude unscaled</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Altitude (MSL), in meters</dd>
     * </dl>
     */
    @MavlinkEntryInfo(31002)
    MAV_CMD_WAYPOINT_USER_3,

    /**
     * User defined waypoint item. Ground Station will show the Vehicle as flying through this item. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param2</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param3</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param4</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Latitude unscaled</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Longitude unscaled</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Altitude (MSL), in meters</dd>
     * </dl>
     */
    @MavlinkEntryInfo(31003)
    MAV_CMD_WAYPOINT_USER_4,

    /**
     * User defined waypoint item. Ground Station will show the Vehicle as flying through this item. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param2</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param3</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param4</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Latitude unscaled</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Longitude unscaled</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Altitude (MSL), in meters</dd>
     * </dl>
     */
    @MavlinkEntryInfo(31004)
    MAV_CMD_WAYPOINT_USER_5,

    /**
     * User defined spatial item. Ground Station will not show the Vehicle as flying through this 
     * item. Example: ROI item. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param2</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param3</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param4</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Latitude unscaled</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Longitude unscaled</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Altitude (MSL), in meters</dd>
     * </dl>
     */
    @MavlinkEntryInfo(31005)
    MAV_CMD_SPATIAL_USER_1,

    /**
     * User defined spatial item. Ground Station will not show the Vehicle as flying through this 
     * item. Example: ROI item. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param2</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param3</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param4</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Latitude unscaled</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Longitude unscaled</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Altitude (MSL), in meters</dd>
     * </dl>
     */
    @MavlinkEntryInfo(31006)
    MAV_CMD_SPATIAL_USER_2,

    /**
     * User defined spatial item. Ground Station will not show the Vehicle as flying through this 
     * item. Example: ROI item. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param2</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param3</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param4</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Latitude unscaled</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Longitude unscaled</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Altitude (MSL), in meters</dd>
     * </dl>
     */
    @MavlinkEntryInfo(31007)
    MAV_CMD_SPATIAL_USER_3,

    /**
     * User defined spatial item. Ground Station will not show the Vehicle as flying through this 
     * item. Example: ROI item. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param2</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param3</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param4</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Latitude unscaled</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Longitude unscaled</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Altitude (MSL), in meters</dd>
     * </dl>
     */
    @MavlinkEntryInfo(31008)
    MAV_CMD_SPATIAL_USER_4,

    /**
     * User defined spatial item. Ground Station will not show the Vehicle as flying through this 
     * item. Example: ROI item. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param2</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param3</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param4</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Latitude unscaled</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Longitude unscaled</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Altitude (MSL), in meters</dd>
     * </dl>
     */
    @MavlinkEntryInfo(31009)
    MAV_CMD_SPATIAL_USER_5,

    /**
     * User defined command. Ground Station will not show the Vehicle as flying through this item. 
     * Example: MAV_CMD_DO_SET_PARAMETER item. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param2</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param3</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param4</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param5</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param6</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param7</dt>
     *   <dd>User defined</dd>
     * </dl>
     */
    @MavlinkEntryInfo(31010)
    MAV_CMD_USER_1,

    /**
     * User defined command. Ground Station will not show the Vehicle as flying through this item. 
     * Example: MAV_CMD_DO_SET_PARAMETER item. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param2</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param3</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param4</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param5</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param6</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param7</dt>
     *   <dd>User defined</dd>
     * </dl>
     */
    @MavlinkEntryInfo(31011)
    MAV_CMD_USER_2,

    /**
     * User defined command. Ground Station will not show the Vehicle as flying through this item. 
     * Example: MAV_CMD_DO_SET_PARAMETER item. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param2</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param3</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param4</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param5</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param6</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param7</dt>
     *   <dd>User defined</dd>
     * </dl>
     */
    @MavlinkEntryInfo(31012)
    MAV_CMD_USER_3,

    /**
     * User defined command. Ground Station will not show the Vehicle as flying through this item. 
     * Example: MAV_CMD_DO_SET_PARAMETER item. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param2</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param3</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param4</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param5</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param6</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param7</dt>
     *   <dd>User defined</dd>
     * </dl>
     */
    @MavlinkEntryInfo(31013)
    MAV_CMD_USER_4,

    /**
     * User defined command. Ground Station will not show the Vehicle as flying through this item. 
     * Example: MAV_CMD_DO_SET_PARAMETER item. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param2</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param3</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param4</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param5</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param6</dt>
     *   <dd>User defined</dd>
     *
     *   <dt>param7</dt>
     *   <dd>User defined</dd>
     * </dl>
     */
    @MavlinkEntryInfo(31014)
    MAV_CMD_USER_5,

    /**
     * Mission command to operate EPM gripper. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Gripper number (a number from 1 to max number of grippers on the vehicle).</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Gripper action (0=release, 1=grab. See {@link io.dronefleet.mavlink.ardupilotmega.GripperActions GRIPPER_ACTIONS} enum).</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty.</dd>
     * </dl>
     */
    @MavlinkEntryInfo(211)
    MAV_CMD_DO_GRIPPER,

    /**
     * Enable/disable autotune. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Enable (1: enable, 0:disable).</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty.</dd>
     * </dl>
     */
    @MavlinkEntryInfo(212)
    MAV_CMD_DO_AUTOTUNE_ENABLE,

    /**
     * Mission command to wait for an altitude or downwards vertical speed. This is meant for high 
     * altitude balloon launches, allowing the aircraft to be idle until either an altitude is 
     * reached or a negative vertical speed is reached (indicating early balloon burst). The wiggle 
     * time is how often to wiggle the control surfaces to prevent them seizing up. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Altitude (m).</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Descent speed (m/s).</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Wiggle Time (s).</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty.</dd>
     * </dl>
     */
    @MavlinkEntryInfo(83)
    MAV_CMD_NAV_ALTITUDE_WAIT,

    /**
     * A system wide power-off event has been initiated. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty.</dd>
     * </dl>
     */
    @MavlinkEntryInfo(42000)
    MAV_CMD_POWER_OFF_INITIATED,

    /**
     * FLY button has been clicked. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty.</dd>
     * </dl>
     */
    @MavlinkEntryInfo(42001)
    MAV_CMD_SOLO_BTN_FLY_CLICK,

    /**
     * FLY button has been held for 1.5 seconds. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Takeoff altitude.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty.</dd>
     * </dl>
     */
    @MavlinkEntryInfo(42002)
    MAV_CMD_SOLO_BTN_FLY_HOLD,

    /**
     * PAUSE button has been clicked. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>1 if Solo is in a shot mode, 0 otherwise.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty.</dd>
     * </dl>
     */
    @MavlinkEntryInfo(42003)
    MAV_CMD_SOLO_BTN_PAUSE_CLICK,

    /**
     * Magnetometer calibration based on fixed position in earth field given by inclination, 
     * declination and intensity. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>MagDeclinationDegrees.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>MagInclinationDegrees.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>MagIntensityMilliGauss.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>YawDegrees.</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty.</dd>
     * </dl>
     */
    @MavlinkEntryInfo(42004)
    MAV_CMD_FIXED_MAG_CAL,

    /**
     * Magnetometer calibration based on fixed expected field values in milliGauss. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>FieldX.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>FieldY.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>FieldZ.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty.</dd>
     * </dl>
     */
    @MavlinkEntryInfo(42005)
    MAV_CMD_FIXED_MAG_CAL_FIELD,

    /**
     * Initiate a magnetometer calibration. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>uint8_t bitmask of magnetometers (0 means all).</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Automatically retry on failure (0=no retry, 1=retry).</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Save without user input (0=require input, 1=autosave).</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Delay (seconds).</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Autoreboot (0=user reboot, 1=autoreboot).</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty.</dd>
     * </dl>
     */
    @MavlinkEntryInfo(42424)
    MAV_CMD_DO_START_MAG_CAL,

    /**
     * Initiate a magnetometer calibration. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>uint8_t bitmask of magnetometers (0 means all).</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty.</dd>
     * </dl>
     */
    @MavlinkEntryInfo(42425)
    MAV_CMD_DO_ACCEPT_MAG_CAL,

    /**
     * Cancel a running magnetometer calibration. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>uint8_t bitmask of magnetometers (0 means all).</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty.</dd>
     * </dl>
     */
    @MavlinkEntryInfo(42426)
    MAV_CMD_DO_CANCEL_MAG_CAL,

    /**
     * Used when doing accelerometer calibration. When sent to the GCS tells it what position to put 
     * the vehicle in. When sent to the vehicle says what position the vehicle is in. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Position, one of the {@link io.dronefleet.mavlink.ardupilotmega.AccelcalVehiclePos ACCELCAL_VEHICLE_POS} enum values.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty.</dd>
     * </dl>
     */
    @MavlinkEntryInfo(42429)
    MAV_CMD_ACCELCAL_VEHICLE_POS,

    /**
     * Reply with the version banner. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty.</dd>
     * </dl>
     */
    @MavlinkEntryInfo(42428)
    MAV_CMD_DO_SEND_BANNER,

    /**
     * Command autopilot to get into factory test/diagnostic mode. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>0 means get out of test mode, 1 means get into test mode.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty.</dd>
     * </dl>
     */
    @MavlinkEntryInfo(42427)
    MAV_CMD_SET_FACTORY_TEST_MODE,

    /**
     * Causes the gimbal to reset and boot as if it was just powered on. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty.</dd>
     * </dl>
     */
    @MavlinkEntryInfo(42501)
    MAV_CMD_GIMBAL_RESET,

    /**
     * Reports progress and success or failure of gimbal axis calibration procedure. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Gimbal axis we're reporting calibration progress for.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Current calibration progress for this axis, 0x64=100%.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Status of the calibration.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty.</dd>
     * </dl>
     */
    @MavlinkEntryInfo(42502)
    MAV_CMD_GIMBAL_AXIS_CALIBRATION_STATUS,

    /**
     * Starts commutation calibration on the gimbal. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty.</dd>
     * </dl>
     */
    @MavlinkEntryInfo(42503)
    MAV_CMD_GIMBAL_REQUEST_AXIS_CALIBRATION,

    /**
     * Erases gimbal application and parameters. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Magic number.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Magic number.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Magic number.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Magic number.</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Magic number.</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Magic number.</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Magic number.</dd>
     * </dl>
     */
    @MavlinkEntryInfo(42505)
    MAV_CMD_GIMBAL_FULL_RESET,

    /**
     * Command to operate winch. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Winch number (0 for the default winch, otherwise a number from 1 to max number of winches on the 
     * vehicle).</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Action (0=relax, 1=relative length control, 2=rate control. See {@link io.dronefleet.mavlink.ardupilotmega.WinchActions WINCH_ACTIONS} enum.).</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Release length (cable distance to unwind in meters, negative numbers to wind in cable).</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Release rate (meters/second).</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty.</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty.</dd>
     * </dl>
     */
    @MavlinkEntryInfo(42600)
    MAV_CMD_DO_WINCH,

    /**
     * Update the bootloader 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Magic number - set to 290876 to actually flash</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(42650)
    MAV_CMD_FLASH_BOOTLOADER,

    /**
     * Orbit a waypoint. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Orbit radius in meters</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Loiter time in decimal seconds</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Maximum horizontal speed in m/s</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Desired yaw angle at waypoint</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Latitude</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Longitude</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Altitude</dd>
     * </dl>
     */
    @MavlinkEntryInfo(1)
    MAV_CMD_AQ_NAV_LEG_ORBIT,

    /**
     * Start/stop AutoQuad telemetry values stream. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Start or stop (1 or 0)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Stream frequency in us</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Dataset ID (refer to aq_mavlink.h::mavlinkCustomDataSets enum in AQ flight controller 
     * code)</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(2)
    MAV_CMD_AQ_TELEMETRY,

    /**
     * Request AutoQuad firmware version number. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(4)
    MAV_CMD_AQ_REQUEST_VERSION,

    /**
     * Mission command to reset Maximum Power Point Tracker (MPPT) 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>MPPT number</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(40001)
    MAV_CMD_RESET_MPPT,

    /**
     * Mission command to perform a power cycle on payload 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Complete power cycle</dd>
     *
     *   <dt>param2</dt>
     *   <dd>VISensor power cycle</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(40002)
    MAV_CMD_PAYLOAD_CONTROL,

    /**
     * Request storage of different parameter values and logs. This command will be only accepted if 
     * in pre-flight mode. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Storage action: Action defined by MAV_PREFLIGHT_STORAGE_ACTION_ADVANCED</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Storage area as defined by parameter database</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Storage flags as defined by parameter database</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(0)
    MAV_CMD_PREFLIGHT_STORAGE_ADVANCED,

    /**
     * Does nothing. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>1 to arm, 0 to disarm</dd>
     * </dl>
     */
    @MavlinkEntryInfo(10001)
    MAV_CMD_DO_NOTHING,

    /**
     * Return vehicle to base. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>0: return to base, 1: track mobile base</dd>
     * </dl>
     */
    @MavlinkEntryInfo(10011)
    MAV_CMD_RETURN_TO_BASE,

    /**
     * Stops the vehicle from returning to base and resumes flight. 
     */
    @MavlinkEntryInfo(10012)
    MAV_CMD_STOP_RETURN_TO_BASE,

    /**
     * Turns the vehicle's visible or infrared lights on or off. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>0: visible lights, 1: infrared lights</dd>
     *
     *   <dt>param2</dt>
     *   <dd>0: turn on, 1: turn off</dd>
     * </dl>
     */
    @MavlinkEntryInfo(10013)
    MAV_CMD_TURN_LIGHT,

    /**
     * Requests vehicle to send current mid-level commands to ground station. 
     */
    @MavlinkEntryInfo(10014)
    MAV_CMD_GET_MID_LEVEL_COMMANDS,

    /**
     * Requests storage of mid-level commands. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Mid-level command storage: 0: read from flash/EEPROM, 1: write to flash/EEPROM</dd>
     * </dl>
     */
    @MavlinkEntryInfo(10015)
    MAV_CMD_MIDLEVEL_STORAGE
}
