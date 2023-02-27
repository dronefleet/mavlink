package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;
import java.lang.Deprecated;

/**
 * Commands to be executed by the MAV. They can be executed on user request, or as part of a mission 
 * script. If the action is used in a mission, the parameter mapping to the waypoint/mission 
 * message is as follows: Param 1, Param 2, Param 3, Param 4, X: Param 5, Y:Param 6, Z:Param 7. This 
 * command list is similar what ARINC 424 is for commercial aircraft: A data format how to 
 * interpret waypoint/mission data. NaN and INT32_MAX may be used in float/integer params 
 * (respectively) to indicate optional/default values (e.g. to use the component's current yaw 
 * or latitude rather than a specific value). See 
 * https://mavlink.io/en/guide/xml_schema.html#{@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} for information about the 
 * structure of the {@link io.dronefleet.mavlink.common.MavCmd MAV_CMD} entries 
 */
@MavlinkEnum
public enum MavCmd {
    /**
     * Navigate to waypoint. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Hold time. (ignored by fixed wing, time to stay at waypoint for rotary wing)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Acceptance radius (if the sphere with this radius is hit, the waypoint counts as reached)</dd>
     *
     *   <dt>param3</dt>
     *   <dd>0 to pass through the WP, if &gt; 0 radius to pass by WP. Positive value for clockwise orbit, negative 
     * value for counter-clockwise orbit. Allows trajectory control.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Desired yaw angle at waypoint (rotary wing). NaN to use the current system yaw heading mode 
     * (e.g. yaw towards next waypoint, yaw to home, etc.).</dd>
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
     *   <dd>Loiter radius around waypoint for forward-only moving vehicles (not multicopters). If 
     * positive loiter clockwise, else counter-clockwise</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Desired yaw angle. NaN to use the current system yaw heading mode (e.g. yaw towards next 
     * waypoint, yaw to home, etc.).</dd>
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
     *   <dd>Number of turns.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Leave loiter circle only once heading towards the next waypoint (0 = False)</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Loiter radius around waypoint for forward-only moving vehicles (not multicopters). If 
     * positive loiter clockwise, else counter-clockwise</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Loiter circle exit location and/or path to next waypoint ("xtrack") for forward-only moving 
     * vehicles (not multicopters). 0 for the vehicle to converge towards the center xtrack when it 
     * leaves the loiter (the line between the centers of the current and next waypoint), 1 to converge 
     * to the direct line between the location that the vehicle exits the loiter radius and the next 
     * waypoint. Otherwise the angle (in degrees) between the tangent of the loiter circle and the 
     * center xtrack at which the vehicle must leave the loiter (and converge to the center xtrack). 
     * NaN to use the current system default xtrack behaviour.</dd>
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
     * Loiter at the specified latitude, longitude and altitude for a certain amount of time. 
     * Multicopter vehicles stop at the point (within a vehicle-specific acceptance radius). 
     * Forward-only moving vehicles (e.g. fixed-wing) circle the point with the specified 
     * radius/direction. If the Heading Required parameter (2) is non-zero forward moving aircraft 
     * will only leave the loiter circle once heading towards the next waypoint. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Loiter time (only starts once Lat, Lon and Alt is reached).</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Leave loiter circle only once heading towards the next waypoint (0 = False)</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Loiter radius around waypoint for forward-only moving vehicles (not multicopters). If 
     * positive loiter clockwise, else counter-clockwise.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Loiter circle exit location and/or path to next waypoint ("xtrack") for forward-only moving 
     * vehicles (not multicopters). 0 for the vehicle to converge towards the center xtrack when it 
     * leaves the loiter (the line between the centers of the current and next waypoint), 1 to converge 
     * to the direct line between the location that the vehicle exits the loiter radius and the next 
     * waypoint. Otherwise the angle (in degrees) between the tangent of the loiter circle and the 
     * center xtrack at which the vehicle must leave the loiter (and converge to the center xtrack). 
     * NaN to use the current system default xtrack behaviour.</dd>
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
     *   <dd>Desired yaw angle. NaN to use the current system yaw heading mode (e.g. yaw towards next 
     * waypoint, yaw to home, etc.).</dd>
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
     * Takeoff from ground / hand. Vehicles that support multiple takeoff modes (e.g. VTOL 
     * quadplane) should take off using the currently configured mode. 
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
     *   <dd>Yaw angle (if magnetometer present), ignored without magnetometer. NaN to use the current 
     * system yaw heading mode (e.g. yaw towards next waypoint, yaw to home, etc.).</dd>
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
     *   <dd>Maximum accepted offset from desired landing position - computed magnitude from spherical 
     * coordinates: d = sqrt(x^2 + y^2 + z^2), which gives the maximum accepted distance between the 
     * desired landing position and the position where the vehicle is about to land</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Landing descend rate</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Desired yaw angle</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Y-axis position</dd>
     *
     *   <dt>param6</dt>
     *   <dd>X-axis position</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Z-axis / ground level position</dd>
     * </dl>
     */
    @MavlinkEntryInfo(23)
    MAV_CMD_NAV_LAND_LOCAL,

    /**
     * Takeoff from local position (local frame only) 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Minimum pitch (if airspeed sensor present), desired pitch without sensor</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Takeoff ascend rate</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Yaw angle (if magnetometer or another yaw estimation source present), ignored without one of 
     * these</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Y-axis position</dd>
     *
     *   <dt>param6</dt>
     *   <dd>X-axis position</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Z-axis position</dd>
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
     *   <dd>Radius around waypoint. If positive loiter clockwise, else counter-clockwise</dd>
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
     *   <dd>Desired altitude</dd>
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
     *   <dd>Leave loiter circle only once heading towards the next waypoint (0 = False)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Loiter radius around waypoint for forward-only moving vehicles (not multicopters). If 
     * positive loiter clockwise, negative counter-clockwise, 0 means no change to standard 
     * loiter.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Loiter circle exit location and/or path to next waypoint ("xtrack") for forward-only moving 
     * vehicles (not multicopters). 0 for the vehicle to converge towards the center xtrack when it 
     * leaves the loiter (the line between the centers of the current and next waypoint), 1 to converge 
     * to the direct line between the location that the vehicle exits the loiter radius and the next 
     * waypoint. Otherwise the angle (in degrees) between the tangent of the loiter circle and the 
     * center xtrack at which the vehicle must leave the loiter (and converge to the center xtrack). 
     * NaN to use the current system default xtrack behaviour.</dd>
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
     * Begin following a target 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>System ID (of the {@link io.dronefleet.mavlink.common.FollowTarget FOLLOW_TARGET} beacon). Send 0 to disable follow-me and return to the default 
     * position hold mode.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Altitude mode: 0: Keep current altitude, 1: keep altitude difference to target, 2: go to a fixed 
     * altitude above home.</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Altitude above home. (used if mode=2)</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Reserved</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Time to land in which the MAV should go to the default position hold mode after a message RX 
     * timeout.</dd>
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
     *   <dd>altitude offset from target</dd>
     *
     *   <dt>param6</dt>
     *   <dd>X offset from target</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Y offset from target</dd>
     * </dl>
     */
    @MavlinkEntryInfo(33)
    MAV_CMD_DO_FOLLOW_REPOSITION,

    /**
     * Start orbiting on the circumference of a circle defined by the parameters. Setting values to 
     * NaN/INT32_MAX (as appropriate) results in using defaults. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Radius of the circle. Positive: orbit clockwise. Negative: orbit counter-clockwise. NaN: 
     * Use vehicle default radius, or current radius if already orbiting.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Tangential Velocity. NaN: Use vehicle default velocity, or current velocity if already 
     * orbiting.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Yaw behavior of the vehicle.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Orbit around the centre point for this many radians (i.e. for a three-quarter orbit set 
     * 270*Pi/180). 0: Orbit forever. NaN: Use vehicle default, or current value if already 
     * orbiting.</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Center point latitude (if no {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME} specified) / X coordinate according to {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME}. 
     * INT32_MAX (or NaN if sent in {@link io.dronefleet.mavlink.common.CommandLong COMMAND_LONG}): Use current vehicle position, or current center if 
     * already orbiting.</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Center point longitude (if no {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME} specified) / Y coordinate according to {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME}. 
     * INT32_MAX (or NaN if sent in {@link io.dronefleet.mavlink.common.CommandLong COMMAND_LONG}): Use current vehicle position, or current center if 
     * already orbiting.</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Center point altitude (MSL) (if no {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME} specified) / Z coordinate according to 
     * {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME}. NaN: Use current vehicle altitude.</dd>
     * </dl>
     */
    @MavlinkEntryInfo(34)
    MAV_CMD_DO_ORBIT,

    /**
     * Sets the region of interest (ROI) for a sensor set or the vehicle itself. This can then be used by 
     * the vehicle's control system to control the vehicle attitude and the attitude of various 
     * sensors such as cameras. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Region of interest mode.</dd>
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
     *   <dd>Yaw angle at goal</dd>
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
     *   <dd>Hold time. (ignored by fixed wing, time to stay at waypoint for rotary wing)</dd>
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
     * The command should be ignored by vehicles that dont support both VTOL and fixed-wing flight 
     * (multicopters, boats,etc.). 
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
     *   <dd>Yaw angle. NaN to use the current system yaw heading mode (e.g. yaw towards next waypoint, yaw to 
     * home, etc.).</dd>
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
     *   <dd>Landing behaviour.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Approach altitude (with the same reference as the Altitude field). NaN if unspecified.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Yaw angle. NaN to use the current system yaw heading mode (e.g. yaw towards next waypoint, yaw to 
     * home, etc.).</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Latitude</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Longitude</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Altitude (ground level) relative to the current coordinate frame. NaN to use system default 
     * landing altitude (ignore value).</dd>
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
     *   <dd>Delay (-1 to enable time-of-day fields)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>hour (24h format, UTC, -1 to ignore)</dd>
     *
     *   <dt>param3</dt>
     *   <dd>minute (24h format, UTC, -1 to ignore)</dd>
     *
     *   <dt>param4</dt>
     *   <dd>second (24h format, UTC, -1 to ignore)</dd>
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
     * Descend and place payload. Vehicle moves to specified location, descends until it detects a 
     * hanging payload has reached the ground, and then releases the payload. If ground is not 
     * detected before the reaching the maximum descent value (param1), the command will complete 
     * without releasing the payload. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Maximum distance to descend.</dd>
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
     *   <dd>Delay</dd>
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
     * Ascend/descend to target altitude at specified rate. Delay mission state machine until 
     * desired altitude reached. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Descent / Ascend rate.</dd>
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
     *   <dd>Target Altitude</dd>
     * </dl>
     */
    @MavlinkEntryInfo(113)
    MAV_CMD_CONDITION_CHANGE_ALT,

    /**
     * Delay mission state machine until within desired distance of next NAV point. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Distance.</dd>
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
     *   <dd>target angle, 0 is north</dd>
     *
     *   <dt>param2</dt>
     *   <dd>angular speed</dd>
     *
     *   <dt>param3</dt>
     *   <dd>direction: -1: counter clockwise, 1: clockwise</dd>
     *
     *   <dt>param4</dt>
     *   <dd>0: absolute angle, 1: relative offset</dd>
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
     *   <dd>Mode</dd>
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
     * Change speed and/or throttle set points. The value persists until it is overridden or there is a 
     * mode change. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Speed type (0=Airspeed, 1=Ground Speed, 2=Climb Speed, 3=Descent Speed)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Speed (-1 indicates no change, -2 indicates return to default vehicle speed)</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Throttle (-1 indicates no change, -2 indicates return to default vehicle throttle value)</dd>
     *
     *   <dt>param4</dt>
     *   <dd></dd>
     *
     *   <dt>param5</dt>
     *   <dd></dd>
     *
     *   <dt>param6</dt>
     *   <dd></dd>
     *
     *   <dt>param7</dt>
     *   <dd></dd>
     * </dl>
     */
    @MavlinkEntryInfo(178)
    MAV_CMD_DO_CHANGE_SPEED,

    /**
     * Sets the home position to either to the current position or a specified position. The home 
     * position is the default position that the system will return to and land on. The position is set 
     * automatically by the system during the takeoff (and may also be set using this command). Note: 
     * the current home position may be emitted in a {@link io.dronefleet.mavlink.common.HomePosition HOME_POSITION} message on request (using 
     * MAV_CMD_REQUEST_MESSAGE with param1=242). 
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
     *   <dd>Yaw angle. NaN to use default heading</dd>
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
     *   <dd>Relay instance number.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Setting. (1=on, 0=off, others possible depending on system hardware)</dd>
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
     *   <dd>Relay instance number.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Cycle count.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Cycle time.</dd>
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
     *   <dd>Servo instance number.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Pulse Width Modulation.</dd>
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
     *   <dd>Servo instance number.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Pulse Width Modulation.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Cycle count.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Cycle time.</dd>
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
     * Terminate flight immediately. Flight termination immediately and irreversably terminates 
     * the current flight, returning the vehicle to ground. The vehicle will ignore RC or other input 
     * until it has been power-cycled. Termination may trigger safety measures, including: 
     * disabling motors and deployment of parachute on multicopters, and setting flight surfaces to 
     * initiate a landing pattern on fixed-wing). On multicopters without a parachute it may trigger 
     * a crash landing. Support for this command can be tested using the protocol bit: 
     * MAV_PROTOCOL_CAPABILITY_FLIGHT_TERMINATION. Support for this command can also be tested 
     * by sending the command with param1=0 (&lt; 0.5); the ACK should be either MAV_RESULT_FAILED or 
     * MAV_RESULT_UNSUPPORTED. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Flight termination activated if &gt; 0.5. Otherwise not activated and ACK with 
     * MAV_RESULT_FAILED.</dd>
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
     *   <dd>Altitude.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Frame of new altitude.</dd>
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
     * Sets actuators (e.g. servos) to a desired value. The actuator numbers are mapped to specific 
     * outputs (e.g. on any MAIN or AUX PWM or UAVCAN) using a flight-stack specific mechanism (i.e. a 
     * parameter). 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Actuator 1 value, scaled from [-1 to 1]. NaN to ignore.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Actuator 2 value, scaled from [-1 to 1]. NaN to ignore.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Actuator 3 value, scaled from [-1 to 1]. NaN to ignore.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Actuator 4 value, scaled from [-1 to 1]. NaN to ignore.</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Actuator 5 value, scaled from [-1 to 1]. NaN to ignore.</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Actuator 6 value, scaled from [-1 to 1]. NaN to ignore.</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Index of actuator set (i.e if set to 1, Actuator 1 becomes Actuator 7)</dd>
     * </dl>
     */
    @MavlinkEntryInfo(187)
    MAV_CMD_DO_SET_ACTUATOR,

    /**
     * Mission command to perform a landing. This is used as a marker in a mission to tell the autopilot 
     * where a sequence of mission items that represents a landing starts. It may also be sent via a 
     * {@link io.dronefleet.mavlink.common.CommandLong COMMAND_LONG} to trigger a landing, in which case the nearest (geographically) landing 
     * sequence in the mission will be used. The Latitude/Longitude/Altitude is optional, and may be 
     * set to 0 if not needed. If specified then it will be used to help find the closest landing 
     * sequence. 
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
    @MavlinkEntryInfo(189)
    MAV_CMD_DO_LAND_START,

    /**
     * Mission command to perform a landing from a rally point. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Break altitude</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Landing speed</dd>
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
     *   <dd>Altitude</dd>
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
     *   <dd>Bitmask of option flags.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Loiter radius for planes. Positive values only, direction is controlled by Yaw value. A value 
     * of zero or NaN is ignored.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Yaw heading. NaN to use the current system yaw heading mode (e.g. yaw towards next waypoint, yaw 
     * to home, etc.). For planes indicates loiter direction (0: clockwise, 1: counter clockwise)</dd>
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
     * Sets the region of interest (ROI) to a location. This can then be used by the vehicle's control 
     * system to control the vehicle attitude and the attitude of various sensors such as cameras. 
     * This command can be sent to a gimbal manager but not to a gimbal device. A gimbal is not to react to 
     * this message. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Component ID of gimbal device to address (or 1-6 for non-MAVLink gimbal), 0 for all gimbal 
     * device components. Send command multiple times for more than one gimbal (but not all gimbals).</dd>
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
     *   <dd>Latitude of ROI location</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Longitude of ROI location</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Altitude of ROI location</dd>
     * </dl>
     */
    @MavlinkEntryInfo(195)
    MAV_CMD_DO_SET_ROI_LOCATION,

    /**
     * Sets the region of interest (ROI) to be toward next waypoint, with optional pitch/roll/yaw 
     * offset. This can then be used by the vehicle's control system to control the vehicle attitude 
     * and the attitude of various sensors such as cameras. This command can be sent to a gimbal manager 
     * but not to a gimbal device. A gimbal device is not to react to this message. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Component ID of gimbal device to address (or 1-6 for non-MAVLink gimbal), 0 for all gimbal 
     * device components. Send command multiple times for more than one gimbal (but not all gimbals).</dd>
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
     *   <dd>Pitch offset from next waypoint, positive pitching up</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Roll offset from next waypoint, positive rolling to the right</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Yaw offset from next waypoint, positive yawing to the right</dd>
     * </dl>
     */
    @MavlinkEntryInfo(196)
    MAV_CMD_DO_SET_ROI_WPNEXT_OFFSET,

    /**
     * Cancels any previous ROI command returning the vehicle/sensors to default flight 
     * characteristics. This can then be used by the vehicle's control system to control the vehicle 
     * attitude and the attitude of various sensors such as cameras. This command can be sent to a 
     * gimbal manager but not to a gimbal device. A gimbal device is not to react to this message. After 
     * this command the gimbal manager should go back to manual input if available, and otherwise 
     * assume a neutral position. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Component ID of gimbal device to address (or 1-6 for non-MAVLink gimbal), 0 for all gimbal 
     * device components. Send command multiple times for more than one gimbal (but not all gimbals).</dd>
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
     * Mount tracks system with specified system ID. Determination of target vehicle position may be 
     * done with {@link io.dronefleet.mavlink.common.GlobalPositionInt GLOBAL_POSITION_INT} or any other means. This command can be sent to a gimbal manager 
     * but not to a gimbal device. A gimbal device is not to react to this message. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>System ID</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Component ID of gimbal device to address (or 1-6 for non-MAVLink gimbal), 0 for all gimbal 
     * device components. Send command multiple times for more than one gimbal (but not all gimbals).</dd>
     * </dl>
     */
    @MavlinkEntryInfo(198)
    MAV_CMD_DO_SET_ROI_SYSID,

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
     *   <dd>Transmission mode: 0: video stream, &gt;0: single images every n seconds</dd>
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
     * the vehicle's control system to control the vehicle attitude and the attitude of various 
     * sensors such as cameras. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Region of interest mode.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Waypoint index/ target ID (depends on param 1).</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Region of interest index. (allows a vehicle to manage multiple ROI's)</dd>
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
     *   <dd>Modes: P, TV, AV, M, Etc.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Shutter speed: Divisor number for one second.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Aperture: F stop number.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>ISO number e.g. 80, 100, 200, Etc.</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Exposure type enumerator.</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Command Identity.</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Main engine cut-off time before camera trigger. (0 means no cut-off)</dd>
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
     *   <dd>Mount operation mode</dd>
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
     * @deprecated Since 2020-01, replaced by MAV_CMD_DO_GIMBAL_MANAGER_CONFIGURE. This 
     * message has been superseded by MAV_CMD_DO_GIMBAL_MANAGER_CONFIGURE. The message can still 
     * be used to communicate with legacy gimbals implementing it. 
     */
    @MavlinkEntryInfo(204)
    @Deprecated
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
     *   <dd>altitude depending on mount mode.</dd>
     *
     *   <dt>param5</dt>
     *   <dd>latitude, set if appropriate mount mode.</dd>
     *
     *   <dt>param6</dt>
     *   <dd>longitude, set if appropriate mount mode.</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Mount mode.</dd>
     * </dl>
     * @deprecated Since 2020-01, replaced by MAV_CMD_DO_GIMBAL_MANAGER_PITCHYAW. This message 
     * is ambiguous and inconsistent. It has been superseded by 
     * MAV_CMD_DO_GIMBAL_MANAGER_PITCHYAW and MAV_CMD_DO_SET_ROI_*. The message can still be 
     * used to communicate with legacy gimbals implementing it. 
     */
    @MavlinkEntryInfo(205)
    @Deprecated
    MAV_CMD_DO_MOUNT_CONTROL,

    /**
     * Mission command to set camera trigger distance for this flight. The camera is triggered each 
     * time this distance is exceeded. This command can also be used to set the shutter integration 
     * time for the camera. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Camera trigger distance. 0 to stop triggering.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Camera shutter integration time. -1 or 0 to ignore</dd>
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
     * Mission item/command to release a parachute or enable/disable auto release. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Action</dd>
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
     * Command to perform motor test. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Motor instance number (from 1 to max number of motors on the vehicle).</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Throttle type (whether the Throttle Value in param3 is a percentage, PWM value, etc.)</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Throttle value.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Timeout between tests that are run in sequence.</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Motor count. Number of motors to test in sequence: 0/1=one motor, 2= two motors, etc. The 
     * Timeout (param4) is used between tests.</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Motor test order.</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(209)
    MAV_CMD_DO_MOTOR_TEST,

    /**
     * Change to/from inverted flight. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Inverted flight. (0=normal, 1=inverted)</dd>
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
     * Mission command to operate a gripper. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Gripper instance number.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Gripper action to perform.</dd>
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
    @MavlinkEntryInfo(211)
    MAV_CMD_DO_GRIPPER,

    /**
     * Enable/disable autotune. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Enable (1: enable, 0:disable).</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Specify which axis are autotuned. 0 indicates autopilot default settings.</dd>
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
     * Sets a desired vehicle turn angle and speed change. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Yaw angle to adjust steering by.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Speed.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Final angle. (0=absolute, 1=relative)</dd>
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
     *   <dd>Camera trigger cycle time. -1 or 0 to ignore.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Camera shutter integration time. Should be less than trigger cycle time. -1 or 0 to ignore.</dd>
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
     *   <dd>quaternion param q1, w (1 in null-rotation)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>quaternion param q2, x (0 in null-rotation)</dd>
     *
     *   <dt>param3</dt>
     *   <dd>quaternion param q3, y (0 in null-rotation)</dd>
     *
     *   <dt>param4</dt>
     *   <dd>quaternion param q4, z (0 in null-rotation)</dd>
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
     * @deprecated Since 2020-01, replaced by MAV_CMD_DO_GIMBAL_MANAGER_PITCHYAW. 
     */
    @MavlinkEntryInfo(220)
    @Deprecated
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
     *   <dd>Timeout - maximum time that external controller will be allowed to control vehicle. 0 means no 
     * timeout.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Altitude (MSL) min - if vehicle moves below this alt, the command will be aborted and the mission 
     * will continue. 0 means no lower altitude limit.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Altitude (MSL) max - if vehicle moves above this alt, the command will be aborted and the mission 
     * will continue. 0 means no upper altitude limit.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Horizontal move limit - if vehicle moves more than this distance from its location at the moment 
     * the command was executed, the command will be aborted and the mission will continue. 0 means no 
     * horizontal move limit.</dd>
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
     *   <dd>Height delay. This is for commanding engine start only after the vehicle has gained the 
     * specified height. Used in VTOL vehicles during takeoff to start engine after the aircraft is 
     * off the ground. Zero for no delay.</dd>
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
    @MavlinkEntryInfo(223)
    MAV_CMD_DO_ENGINE_CONTROL,

    /**
     * Set the mission item with sequence number seq as the current item and emit {@link io.dronefleet.mavlink.common.MissionCurrent MISSION_CURRENT} 
     * (whether or not the mission number changed). If a mission is currently being executed, the 
     * system will continue to this new mission item on the shortest path, skipping any intermediate 
     * mission items. Note that mission jump repeat counters are not reset unless param2 is set (see 
     * MAV_CMD_DO_JUMP param2). This command may trigger a mission state-machine change on some 
     * systems: for example from MISSION_STATE_NOT_STARTED or MISSION_STATE_PAUSED to 
     * MISSION_STATE_ACTIVE. If the system is in mission mode, on those systems this command might 
     * therefore start, restart or resume the mission. If the system is not in mission mode this 
     * command must not trigger a switch to mission mode. The mission may be "reset" using param2. 
     * Resetting sets jump counters to initial values (to reset counters without changing the 
     * current mission item set the param1 to `-1`). Resetting also explicitly changes a mission 
     * state of MISSION_STATE_COMPLETE to MISSION_STATE_PAUSED or MISSION_STATE_ACTIVE, 
     * potentially allowing it to resume when it is (next) in a mission mode. The command will ACK with 
     * MAV_RESULT_FAILED if the sequence number is out of range (including if there is no mission 
     * item). 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Mission sequence value to set. -1 for the current mission item (use to reset mission without 
     * changing current mission item).</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Resets mission. 1: true, 0: false. Resets jump counters to initial values and changes mission 
     * state "completed" to be "active" or "paused".</dd>
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
     * Trigger UAVCAN configuration (actuator ID assignment and direction mapping). Note that this 
     * maps to the legacy UAVCAN v0 function UAVCAN_ENUMERATE, which is intended to be executed just 
     * once during initial vehicle configuration (it is not a normal pre-flight command and has been 
     * poorly named). 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>1: Trigger actuator ID assignment and direction mapping. 0: Cancel command.</dd>
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
     *   <dd>Action to perform on the persistent parameter storage</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Action to perform on the persistent mission storage</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Onboard logging: 0: Ignore, 1: Start default rate logging, -1: Stop logging, &gt; 1: logging rate 
     * (e.g. set to 1000 for 1000 Hz logging)</dd>
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
     *   <dd>0: Do nothing for component, 1: Reboot component, 2: Shutdown component, 3: Reboot component 
     * and keep it in the bootloader until upgraded</dd>
     *
     *   <dt>param4</dt>
     *   <dd>MAVLink Component ID targeted in param3 (0 for all components).</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Reserved (set to 0)</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Reserved (set to 0)</dd>
     *
     *   <dt>param7</dt>
     *   <dd>WIP: ID (e.g. camera ID -1 for all IDs)</dd>
     * </dl>
     */
    @MavlinkEntryInfo(246)
    MAV_CMD_PREFLIGHT_REBOOT_SHUTDOWN,

    /**
     * Override current mission with command to pause mission, pause mission and move to position, 
     * continue/resume mission. When param 1 indicates that the mission is paused 
     * (MAV_GOTO_DO_HOLD), param 2 defines whether it holds in place or moves to another position. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>MAV_GOTO_DO_HOLD: pause mission and either hold or move to specified position (depending on 
     * param2), MAV_GOTO_DO_CONTINUE: resume mission.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>MAV_GOTO_HOLD_AT_CURRENT_POSITION: hold at current position, 
     * MAV_GOTO_HOLD_AT_SPECIFIED_POSITION: hold at specified position.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Coordinate frame of hold point.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Desired yaw angle.</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Latitude/X position.</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Longitude/Y position.</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Altitude/Z position.</dd>
     * </dl>
     */
    @MavlinkEntryInfo(252)
    MAV_CMD_OVERRIDE_GOTO,

    /**
     * Mission command to set a Camera Auto Mount Pivoting Oblique Survey (Replaces CAM_TRIGG_DIST 
     * for this purpose). The camera is triggered each time this distance is exceeded, then the mount 
     * moves to the next position. Params 4~6 set-up the angle limits and number of positions for 
     * oblique survey, where mount-enabled vehicles automatically roll the camera between shots to 
     * emulate an oblique camera setup (providing an increased HFOV). This command can also be used to 
     * set the shutter integration time for the camera. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Camera trigger distance. 0 to stop triggering.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Camera shutter integration time. 0 to ignore</dd>
     *
     *   <dt>param3</dt>
     *   <dd>The minimum interval in which the camera is capable of taking subsequent pictures repeatedly. 
     * 0 to ignore.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Total number of roll positions at which the camera will capture photos (images captures spread 
     * evenly across the limits defined by param5).</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Angle limits that the camera can be rolled to left and right of center.</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Fixed pitch angle that the camera will hold in oblique mode if the mount is actuated in the pitch 
     * axis.</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(260)
    MAV_CMD_OBLIQUE_SURVEY,

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
     * Actuator testing command. This is similar to MAV_CMD_DO_MOTOR_TEST but operates on the level 
     * of output functions, i.e. it is possible to test Motor1 independent from which output it is 
     * configured on. Autopilots typically refuse this command while armed. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Output value: 1 means maximum positive output, 0 to center servos or minimum motor thrust 
     * (expected to spin), -1 for maximum negative (if not supported by the motors, i.e. motor is not 
     * reversible, smaller than 0 maps to NaN). And NaN maps to disarmed (stop the motors).</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Timeout after which the test command expires and the output is restored to the previous value. A 
     * timeout has to be set for safety reasons. A timeout of 0 means to restore the previous value 
     * immediately.</dd>
     *
     *   <dt>param3</dt>
     *   <dd></dd>
     *
     *   <dt>param4</dt>
     *   <dd></dd>
     *
     *   <dt>param5</dt>
     *   <dd>Actuator Output function</dd>
     *
     *   <dt>param6</dt>
     *   <dd></dd>
     *
     *   <dt>param7</dt>
     *   <dd></dd>
     * </dl>
     */
    @MavlinkEntryInfo(310)
    MAV_CMD_ACTUATOR_TEST,

    /**
     * Actuator configuration command. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Actuator configuration action</dd>
     *
     *   <dt>param2</dt>
     *   <dd></dd>
     *
     *   <dt>param3</dt>
     *   <dd></dd>
     *
     *   <dt>param4</dt>
     *   <dd></dd>
     *
     *   <dt>param5</dt>
     *   <dd>Actuator Output function</dd>
     *
     *   <dt>param6</dt>
     *   <dd></dd>
     *
     *   <dt>param7</dt>
     *   <dd></dd>
     * </dl>
     */
    @MavlinkEntryInfo(311)
    MAV_CMD_CONFIGURE_ACTUATOR,

    /**
     * Arms / Disarms a component 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>0: disarm, 1: arm</dd>
     *
     *   <dt>param2</dt>
     *   <dd>0: arm-disarm unless prevented by safety checks (i.e. when landed), 21196: force 
     * arming/disarming (e.g. allow arming to override preflight checks and disarming in flight)</dd>
     * </dl>
     */
    @MavlinkEntryInfo(400)
    MAV_CMD_COMPONENT_ARM_DISARM,

    /**
     * Instructs a target system to run pre-arm checks. This allows preflight checks to be run on 
     * demand, which may be useful on systems that normally run them at low rate, or which do not trigger 
     * checks when the armable state might have changed. This command should return 
     * MAV_RESULT_ACCEPTED if it will run the checks. The results of the checks are usually then 
     * reported in {@link io.dronefleet.mavlink.common.SysStatus SYS_STATUS} messages (this is system-specific). The command should return 
     * MAV_RESULT_TEMPORARILY_REJECTED if the system is already armed. 
     */
    @MavlinkEntryInfo(401)
    MAV_CMD_RUN_PREARM_CHECKS,

    /**
     * Turns illuminators ON/OFF. An illuminator is a light source that is used for lighting up dark 
     * areas external to the sytstem: e.g. a torch or searchlight (as opposed to a light source for 
     * illuminating the system itself, e.g. an indicator light). 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>0: Illuminators OFF, 1: Illuminators ON</dd>
     * </dl>
     */
    @MavlinkEntryInfo(405)
    MAV_CMD_ILLUMINATOR_ON_OFF,

    /**
     * Request the home position from the vehicle. The vehicle will ACK the command and then emit the 
     * {@link io.dronefleet.mavlink.common.HomePosition HOME_POSITION} message. 
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
     * @deprecated Since 2022-04, replaced by MAV_CMD_REQUEST_MESSAGE. 
     */
    @MavlinkEntryInfo(410)
    @Deprecated
    MAV_CMD_GET_HOME_POSITION,

    /**
     * Inject artificial failure for testing purposes. Note that autopilots should implement an 
     * additional protection before accepting this command such as a specific param setting. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>The unit which is affected by the failure.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>The type how the failure manifests itself.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Instance affected by failure (0 to signal all).</dd>
     * </dl>
     */
    @MavlinkEntryInfo(420)
    MAV_CMD_INJECT_FAILURE,

    /**
     * Starts receiver pairing. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>0:Spektrum.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>RC type.</dd>
     * </dl>
     */
    @MavlinkEntryInfo(500)
    MAV_CMD_START_RX_PAIR,

    /**
     * Request the interval between messages for a particular MAVLink message ID. The receiver 
     * should ACK the command and then emit its response in a {@link io.dronefleet.mavlink.common.MessageInterval MESSAGE_INTERVAL} message. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>The MAVLink message ID</dd>
     * </dl>
     * @deprecated Since 2022-04, replaced by MAV_CMD_REQUEST_MESSAGE. 
     */
    @MavlinkEntryInfo(510)
    @Deprecated
    MAV_CMD_GET_MESSAGE_INTERVAL,

    /**
     * Set the interval between messages for a particular MAVLink message ID. This interface 
     * replaces {@link io.dronefleet.mavlink.common.RequestDataStream REQUEST_DATA_STREAM}. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>The MAVLink message ID</dd>
     *
     *   <dt>param2</dt>
     *   <dd>The interval between two messages. -1: disable. 0: request default rate (which may be zero).</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Target address of message stream (if message has target address fields). 0: Flight-stack 
     * default (recommended), 1: address of requestor, 2: broadcast.</dd>
     * </dl>
     */
    @MavlinkEntryInfo(511)
    MAV_CMD_SET_MESSAGE_INTERVAL,

    /**
     * Request the target system(s) emit a single instance of a specified message (i.e. a "one-shot" 
     * version of MAV_CMD_SET_MESSAGE_INTERVAL). 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>The MAVLink message ID of the requested message.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Use for index ID, if required. Otherwise, the use of this parameter (if any) must be defined in 
     * the requested message. By default assumed not used (0).</dd>
     *
     *   <dt>param3</dt>
     *   <dd>The use of this parameter (if any), must be defined in the requested message. By default assumed 
     * not used (0).</dd>
     *
     *   <dt>param4</dt>
     *   <dd>The use of this parameter (if any), must be defined in the requested message. By default assumed 
     * not used (0).</dd>
     *
     *   <dt>param5</dt>
     *   <dd>The use of this parameter (if any), must be defined in the requested message. By default assumed 
     * not used (0).</dd>
     *
     *   <dt>param6</dt>
     *   <dd>The use of this parameter (if any), must be defined in the requested message. By default assumed 
     * not used (0).</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Target address for requested message (if message has target address fields). 0: Flight-stack 
     * default, 1: address of requestor, 2: broadcast.</dd>
     * </dl>
     */
    @MavlinkEntryInfo(512)
    MAV_CMD_REQUEST_MESSAGE,

    /**
     * Request MAVLink protocol version compatibility. All receivers should ACK the command and 
     * then emit their capabilities in an PROTOCOL_VERSION message 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>1: Request supported protocol versions by all nodes on the network</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Reserved (all remaining params)</dd>
     * </dl>
     * @deprecated Since 2019-08, replaced by MAV_CMD_REQUEST_MESSAGE. 
     */
    @MavlinkEntryInfo(519)
    @Deprecated
    MAV_CMD_REQUEST_PROTOCOL_VERSION,

    /**
     * Request autopilot capabilities. The receiver should ACK the command and then emit its 
     * capabilities in an {@link io.dronefleet.mavlink.common.AutopilotVersion AUTOPILOT_VERSION} message 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>1: Request autopilot version</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Reserved (all remaining params)</dd>
     * </dl>
     * @deprecated Since 2019-08, replaced by MAV_CMD_REQUEST_MESSAGE. 
     */
    @MavlinkEntryInfo(520)
    @Deprecated
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
     * @deprecated Since 2019-08, replaced by MAV_CMD_REQUEST_MESSAGE. 
     */
    @MavlinkEntryInfo(521)
    @Deprecated
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
     * @deprecated Since 2019-08, replaced by MAV_CMD_REQUEST_MESSAGE. 
     */
    @MavlinkEntryInfo(522)
    @Deprecated
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
     * @deprecated Since 2019-08, replaced by MAV_CMD_REQUEST_MESSAGE. 
     */
    @MavlinkEntryInfo(525)
    @Deprecated
    MAV_CMD_REQUEST_STORAGE_INFORMATION,

    /**
     * Format a storage medium. Once format is complete, a {@link io.dronefleet.mavlink.common.StorageInformation STORAGE_INFORMATION} message is sent. Use 
     * the command's target_component to target a specific component's storage. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Storage ID (1 for first, 2 for second, etc.)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Format storage (and reset image log). 0: No action 1: Format storage</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Reset Image Log (without formatting storage medium). This will reset 
     * {@link io.dronefleet.mavlink.common.CameraCaptureStatus CAMERA_CAPTURE_STATUS}.image_count and {@link io.dronefleet.mavlink.common.CameraImageCaptured CAMERA_IMAGE_CAPTURED}.image_index. 0: No action 
     * 1: Reset Image Log</dd>
     *
     *   <dt>param4</dt>
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
     * @deprecated Since 2019-08, replaced by MAV_CMD_REQUEST_MESSAGE. 
     */
    @MavlinkEntryInfo(527)
    @Deprecated
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
     * @deprecated Since 2019-08, replaced by MAV_CMD_REQUEST_MESSAGE. 
     */
    @MavlinkEntryInfo(528)
    @Deprecated
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
     *   <dd></dd>
     *
     *   <dt>param4</dt>
     *   <dd></dd>
     *
     *   <dt>param7</dt>
     *   <dd></dd>
     * </dl>
     */
    @MavlinkEntryInfo(530)
    MAV_CMD_SET_CAMERA_MODE,

    /**
     * Set camera zoom. Camera must respond with a {@link io.dronefleet.mavlink.common.CameraSettings CAMERA_SETTINGS} message (on success). 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Zoom type</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Zoom value. The range of valid values depend on the zoom type.</dd>
     *
     *   <dt>param3</dt>
     *   <dd></dd>
     *
     *   <dt>param4</dt>
     *   <dd></dd>
     *
     *   <dt>param7</dt>
     *   <dd></dd>
     * </dl>
     */
    @MavlinkEntryInfo(531)
    MAV_CMD_SET_CAMERA_ZOOM,

    /**
     * Set camera focus. Camera must respond with a {@link io.dronefleet.mavlink.common.CameraSettings CAMERA_SETTINGS} message (on success). 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Focus type</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Focus value</dd>
     *
     *   <dt>param3</dt>
     *   <dd></dd>
     *
     *   <dt>param4</dt>
     *   <dd></dd>
     *
     *   <dt>param7</dt>
     *   <dd></dd>
     * </dl>
     */
    @MavlinkEntryInfo(532)
    MAV_CMD_SET_CAMERA_FOCUS,

    /**
     * Set that a particular storage is the preferred location for saving photos, videos, and/or 
     * other media (e.g. to set that an SD card is used for storing videos). There can only be one 
     * preferred save location for each particular media type: setting a media usage flag will 
     * clear/reset that same flag if set on any other storage. If no flag is set the system should use its 
     * default storage. A target system can choose to always use default storage, in which case it 
     * should ACK the command with MAV_RESULT_UNSUPPORTED. A target system can choose to not allow a 
     * particular storage to be set as preferred storage, in which case it should ACK the command with 
     * MAV_RESULT_DENIED. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Storage ID (1 for first, 2 for second, etc.)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Usage flags</dd>
     * </dl>
     */
    @MavlinkEntryInfo(533)
    MAV_CMD_SET_STORAGE_USAGE,

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
     *   <dd>Repeat count.</dd>
     * </dl>
     */
    @MavlinkEntryInfo(601)
    MAV_CMD_DO_JUMP_TAG,

    /**
     * High level setpoint to be sent to a gimbal manager to set a gimbal attitude. It is possible to set 
     * combinations of the values below. E.g. an angle as well as a desired angular rate can be used to 
     * get to this angle at a certain angular rate, or an angular rate only will result in continuous 
     * turning. NaN is to be used to signal unset. Note: a gimbal is never to react to this command but 
     * only the gimbal manager. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Pitch angle (positive to pitch up, relative to vehicle for FOLLOW mode, relative to world 
     * horizon for LOCK mode).</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Yaw angle (positive to yaw to the right, relative to vehicle for FOLLOW mode, absolute to North 
     * for LOCK mode).</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Pitch rate (positive to pitch up).</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Yaw rate (positive to yaw to the right).</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Gimbal manager flags to use.</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Component ID of gimbal device to address (or 1-6 for non-MAVLink gimbal), 0 for all gimbal 
     * device components. Send command multiple times for more than one gimbal (but not all gimbals).</dd>
     * </dl>
     */
    @MavlinkEntryInfo(1000)
    MAV_CMD_DO_GIMBAL_MANAGER_PITCHYAW,

    /**
     * Gimbal configuration to set which sysid/compid is in primary and secondary control. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Sysid for primary control (0: no one in control, -1: leave unchanged, -2: set itself in control 
     * (for missions where the own sysid is still unknown), -3: remove control if currently in 
     * control).</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Compid for primary control (0: no one in control, -1: leave unchanged, -2: set itself in control 
     * (for missions where the own sysid is still unknown), -3: remove control if currently in 
     * control).</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Sysid for secondary control (0: no one in control, -1: leave unchanged, -2: set itself in 
     * control (for missions where the own sysid is still unknown), -3: remove control if currently in 
     * control).</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Compid for secondary control (0: no one in control, -1: leave unchanged, -2: set itself in 
     * control (for missions where the own sysid is still unknown), -3: remove control if currently in 
     * control).</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Component ID of gimbal device to address (or 1-6 for non-MAVLink gimbal), 0 for all gimbal 
     * device components. Send command multiple times for more than one gimbal (but not all gimbals).</dd>
     * </dl>
     */
    @MavlinkEntryInfo(1001)
    MAV_CMD_DO_GIMBAL_MANAGER_CONFIGURE,

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
     *   <dd>Capture sequence number starting from 1. This is only valid for single-capture (param3 == 1), 
     * otherwise set to 0. Increment the capture ID for each capture command to prevent double 
     * captures when a command is re-transmitted.</dd>
     *
     *   <dt>param5</dt>
     *   <dd></dd>
     *
     *   <dt>param6</dt>
     *   <dd></dd>
     *
     *   <dt>param7</dt>
     *   <dd></dd>
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
     *   <dd></dd>
     *
     *   <dt>param3</dt>
     *   <dd></dd>
     *
     *   <dt>param4</dt>
     *   <dd></dd>
     *
     *   <dt>param7</dt>
     *   <dd></dd>
     * </dl>
     */
    @MavlinkEntryInfo(2001)
    MAV_CMD_IMAGE_STOP_CAPTURE,

    /**
     * Re-request a {@link io.dronefleet.mavlink.common.CameraImageCaptured CAMERA_IMAGE_CAPTURED} message. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Sequence number for missing {@link io.dronefleet.mavlink.common.CameraImageCaptured CAMERA_IMAGE_CAPTURED} message</dd>
     *
     *   <dt>param2</dt>
     *   <dd></dd>
     *
     *   <dt>param3</dt>
     *   <dd></dd>
     *
     *   <dt>param4</dt>
     *   <dd></dd>
     *
     *   <dt>param7</dt>
     *   <dd></dd>
     * </dl>
     * @deprecated Since 2019-08, replaced by MAV_CMD_REQUEST_MESSAGE. 
     */
    @MavlinkEntryInfo(2002)
    @Deprecated
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
     * If the camera supports point visual tracking (CAMERA_CAP_FLAGS_HAS_TRACKING_POINT is 
     * set), this command allows to initiate the tracking. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Point to track x value (normalized 0..1, 0 is left, 1 is right).</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Point to track y value (normalized 0..1, 0 is top, 1 is bottom).</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Point radius (normalized 0..1, 0 is image left, 1 is image right).</dd>
     * </dl>
     */
    @MavlinkEntryInfo(2004)
    MAV_CMD_CAMERA_TRACK_POINT,

    /**
     * If the camera supports rectangle visual tracking 
     * (CAMERA_CAP_FLAGS_HAS_TRACKING_RECTANGLE is set), this command allows to initiate the 
     * tracking. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Top left corner of rectangle x value (normalized 0..1, 0 is left, 1 is right).</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Top left corner of rectangle y value (normalized 0..1, 0 is top, 1 is bottom).</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Bottom right corner of rectangle x value (normalized 0..1, 0 is left, 1 is right).</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Bottom right corner of rectangle y value (normalized 0..1, 0 is top, 1 is bottom).</dd>
     * </dl>
     */
    @MavlinkEntryInfo(2005)
    MAV_CMD_CAMERA_TRACK_RECTANGLE,

    /**
     * Stops ongoing tracking. 
     */
    @MavlinkEntryInfo(2010)
    MAV_CMD_CAMERA_STOP_TRACKING,

    /**
     * Starts video capture (recording). 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Video Stream ID (0 for all streams)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Frequency {@link io.dronefleet.mavlink.common.CameraCaptureStatus CAMERA_CAPTURE_STATUS} messages should be sent while recording (0 for no messages, 
     * otherwise frequency)</dd>
     *
     *   <dt>param3</dt>
     *   <dd></dd>
     *
     *   <dt>param4</dt>
     *   <dd></dd>
     *
     *   <dt>param5</dt>
     *   <dd></dd>
     *
     *   <dt>param6</dt>
     *   <dd></dd>
     *
     *   <dt>param7</dt>
     *   <dd></dd>
     * </dl>
     */
    @MavlinkEntryInfo(2500)
    MAV_CMD_VIDEO_START_CAPTURE,

    /**
     * Stop the current video capture (recording). 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Video Stream ID (0 for all streams)</dd>
     *
     *   <dt>param2</dt>
     *   <dd></dd>
     *
     *   <dt>param3</dt>
     *   <dd></dd>
     *
     *   <dt>param4</dt>
     *   <dd></dd>
     *
     *   <dt>param5</dt>
     *   <dd></dd>
     *
     *   <dt>param6</dt>
     *   <dd></dd>
     *
     *   <dt>param7</dt>
     *   <dd></dd>
     * </dl>
     */
    @MavlinkEntryInfo(2501)
    MAV_CMD_VIDEO_STOP_CAPTURE,

    /**
     * Start video streaming 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Video Stream ID (0 for all streams, 1 for first, 2 for second, etc.)</dd>
     * </dl>
     */
    @MavlinkEntryInfo(2502)
    MAV_CMD_VIDEO_START_STREAMING,

    /**
     * Stop the given video stream 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Video Stream ID (0 for all streams, 1 for first, 2 for second, etc.)</dd>
     * </dl>
     */
    @MavlinkEntryInfo(2503)
    MAV_CMD_VIDEO_STOP_STREAMING,

    /**
     * Request video stream information ({@link io.dronefleet.mavlink.common.VideoStreamInformation VIDEO_STREAM_INFORMATION}) 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Video Stream ID (0 for all streams, 1 for first, 2 for second, etc.)</dd>
     * </dl>
     * @deprecated Since 2019-08, replaced by MAV_CMD_REQUEST_MESSAGE. 
     */
    @MavlinkEntryInfo(2504)
    @Deprecated
    MAV_CMD_REQUEST_VIDEO_STREAM_INFORMATION,

    /**
     * Request video stream status ({@link io.dronefleet.mavlink.common.VideoStreamStatus VIDEO_STREAM_STATUS}) 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Video Stream ID (0 for all streams, 1 for first, 2 for second, etc.)</dd>
     * </dl>
     * @deprecated Since 2019-08, replaced by MAV_CMD_REQUEST_MESSAGE. 
     */
    @MavlinkEntryInfo(2505)
    @Deprecated
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
     *   <dd></dd>
     *
     *   <dt>param4</dt>
     *   <dd></dd>
     *
     *   <dt>param5</dt>
     *   <dd></dd>
     *
     *   <dt>param6</dt>
     *   <dd></dd>
     *
     *   <dt>param7</dt>
     *   <dd></dd>
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
     *   <dd>Viewing angle horizontal of the panorama (+- 0.5 the total angle)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Viewing angle vertical of panorama.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Speed of the horizontal rotation.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Speed of the vertical rotation.</dd>
     * </dl>
     */
    @MavlinkEntryInfo(2800)
    MAV_CMD_PANORAMA_CREATE,

    /**
     * Request VTOL transition 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>The target VTOL state. For normal transitions, only MAV_VTOL_STATE_MC and 
     * MAV_VTOL_STATE_FW can be used.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Force immediate transition to the specified {@link io.dronefleet.mavlink.common.MavVtolState MAV_VTOL_STATE}. 1: Force immediate, 0: normal 
     * transition. Can be used, for example, to trigger an emergency "Quadchute". Caution: Can be 
     * dangerous/damage vehicle, depending on autopilot implementation of this command.</dd>
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
     *   <dd>Target latitude of center of circle in CIRCLE_MODE</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Target longitude of center of circle in CIRCLE_MODE</dd>
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
     * Fence return point (there can only be one such point in a geofence definition). If rally points 
     * are supported they should be used instead. 
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
     *   <dd>Vehicle must be inside ALL inclusion zones in a single group, vehicle must be inside at least one 
     * group, must be the same for all points in each polygon</dd>
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
     *   <dd>Radius.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Vehicle must be inside ALL inclusion zones in a single group, vehicle must be inside at least one 
     * group</dd>
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
     *   <dd>Radius.</dd>
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
     * Trigger the start of an ADSB-out IDENT. This should only be used when requested to do so by an Air 
     * Traffic Controller in controlled airspace. This starts the IDENT which is then typically held 
     * for 18 seconds by the hardware per the Mode A, C, and S transponder spec. 
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
    @MavlinkEntryInfo(10001)
    MAV_CMD_DO_ADSB_OUT_IDENT,

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
     *   <dd>Desired approach vector in compass heading. A negative value indicates the system can define 
     * the approach vector at will.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Desired ground speed at release time. This can be overridden by the airframe in case it needs to 
     * meet minimum airspeed. A negative value indicates the system can define the ground speed at 
     * will.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Minimum altitude clearance to the release position. A negative value indicates the system can 
     * define the clearance at will.</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Latitude. Note, if used in {@link io.dronefleet.mavlink.common.MissionItem MISSION_ITEM} (deprecated) the units are degrees (unscaled)</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Longitude. Note, if used in {@link io.dronefleet.mavlink.common.MissionItem MISSION_ITEM} (deprecated) the units are degrees (unscaled)</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Altitude (MSL)</dd>
     * </dl>
     * @deprecated Since 2021-06, replaced by . 
     */
    @MavlinkEntryInfo(30001)
    @Deprecated
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
     * @deprecated Since 2021-06, replaced by . 
     */
    @MavlinkEntryInfo(30002)
    @Deprecated
    MAV_CMD_PAYLOAD_CONTROL_DEPLOY,

    /**
     * Magnetometer calibration based on provided known yaw. This allows for fast calibration using 
     * WMM field tables in the vehicle, given only the known yaw of the vehicle. If Latitude and 
     * longitude are both zero then use the current vehicle location. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Yaw of vehicle in earth frame.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>CompassMask, 0 for all.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Latitude.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Longitude.</dd>
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
    @MavlinkEntryInfo(42006)
    MAV_CMD_FIXED_MAG_CAL_YAW,

    /**
     * Command to operate winch. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Winch instance number.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Action to perform.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Length of line to release (negative to wind).</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Release rate (negative to wind).</dd>
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
     *   <dd>Altitude (MSL)</dd>
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
     *   <dd>Altitude (MSL)</dd>
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
     *   <dd>Altitude (MSL)</dd>
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
     *   <dd>Altitude (MSL)</dd>
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
     *   <dd>Altitude (MSL)</dd>
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
     *   <dd>Altitude (MSL)</dd>
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
     *   <dd>Altitude (MSL)</dd>
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
     *   <dd>Altitude (MSL)</dd>
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
     *   <dd>Altitude (MSL)</dd>
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
     *   <dd>Altitude (MSL)</dd>
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
     * Request forwarding of CAN packets from the given CAN bus to this component. CAN Frames are sent 
     * using {@link io.dronefleet.mavlink.common.CanFrame CAN_FRAME} and {@link io.dronefleet.mavlink.common.CanfdFrame CANFD_FRAME} messages 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Bus number (0 to disable forwarding, 1 for first bus, 2 for 2nd bus, 3 for 3rd bus).</dd>
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
    @MavlinkEntryInfo(32000)
    MAV_CMD_CAN_FORWARD,

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
    MAV_CMD_MIDLEVEL_STORAGE,

    /**
     * Set the distance to be repeated on mission resume 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Distance.</dd>
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
    @MavlinkEntryInfo(215)
    MAV_CMD_DO_SET_RESUME_REPEAT_DIST,

    /**
     * Control attached liquid sprayer 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>0: disable sprayer. 1: enable sprayer.</dd>
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
    @MavlinkEntryInfo(216)
    MAV_CMD_DO_SPRAYER,

    /**
     * Pass instructions onto scripting, a script should be checking for a new command 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>uint16 ID value to be passed to scripting</dd>
     *
     *   <dt>param2</dt>
     *   <dd>float value to be passed to scripting</dd>
     *
     *   <dt>param3</dt>
     *   <dd>float value to be passed to scripting</dd>
     *
     *   <dt>param4</dt>
     *   <dd>float value to be passed to scripting</dd>
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
    @MavlinkEntryInfo(217)
    MAV_CMD_DO_SEND_SCRIPT_MESSAGE,

    /**
     * Execute auxiliary function 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Auxiliary Function.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Switch Level.</dd>
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
    @MavlinkEntryInfo(218)
    MAV_CMD_DO_AUX_FUNCTION,

    /**
     * Mission command to wait for an altitude or downwards vertical speed. This is meant for high 
     * altitude balloon launches, allowing the aircraft to be idle until either an altitude is 
     * reached or a negative vertical speed is reached (indicating early balloon burst). The wiggle 
     * time is how often to wiggle the control surfaces to prevent them seizing up. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Altitude.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Descent speed.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>How long to wiggle the control surfaces to prevent them seizing up.</dd>
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
     *   <dd>Magnetic declination.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Magnetic inclination.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Magnetic intensity.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Yaw.</dd>
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
     * Magnetometer calibration based on fixed expected field values. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Field strength X.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Field strength Y.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Field strength Z.</dd>
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
     * Set EKF sensor source set. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Source Set Id.</dd>
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
    @MavlinkEntryInfo(42007)
    MAV_CMD_SET_EKF_SOURCE_SET,

    /**
     * Initiate a magnetometer calibration. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Bitmask of magnetometers to calibrate. Use 0 to calibrate all sensors that can be started 
     * (sensors may not start if disabled, unhealthy, etc.). The command will NACK if calibration 
     * does not start for a sensor explicitly specified by the bitmask.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Automatically retry on failure (0=no retry, 1=retry).</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Save without user input (0=require input, 1=autosave).</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Delay.</dd>
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
     * Accept a magnetometer calibration. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Bitmask of magnetometers that calibration is accepted (0 means all).</dd>
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
     *   <dd>Bitmask of magnetometers to cancel a running calibration (0 means all).</dd>
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
     *   <dd>Position.</dd>
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
     *   <dd>0: activate test mode, 1: exit test mode.</dd>
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
     *   <dd>Current calibration progress for this axis.</dd>
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
     * Reset battery capacity for batteries that accumulate consumed battery via integration. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Bitmask of batteries to reset. Least significant bit is for the first battery.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Battery percentage remaining to set.</dd>
     * </dl>
     */
    @MavlinkEntryInfo(42651)
    MAV_CMD_BATTERY_RESET,

    /**
     * Issue a trap signal to the autopilot process, presumably to enter the debugger. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Magic number - set to 32451 to actually trap.</dd>
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
    @MavlinkEntryInfo(42700)
    MAV_CMD_DEBUG_TRAP,

    /**
     * Control onboard scripting. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Scripting command to execute</dd>
     * </dl>
     */
    @MavlinkEntryInfo(42701)
    MAV_CMD_SCRIPTING,

    /**
     * Scripting command as NAV command with wait for completion. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>integer command number (0 to 255)</dd>
     *
     *   <dt>param2</dt>
     *   <dd>timeout for operation in seconds. Zero means no timeout (0 to 255)</dd>
     *
     *   <dt>param3</dt>
     *   <dd>argument1.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>argument2.</dd>
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
    @MavlinkEntryInfo(42702)
    MAV_CMD_NAV_SCRIPT_TIME,

    /**
     * Maintain an attitude for a specified time. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Time to maintain specified attitude and climb rate</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Roll angle in degrees (positive is lean right, negative is lean left)</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Pitch angle in degrees (positive is lean back, negative is lean forward)</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Yaw angle</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Climb rate</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Empty</dd>
     * </dl>
     */
    @MavlinkEntryInfo(42703)
    MAV_CMD_NAV_ATTITUDE_TIME,

    /**
     * Change flight speed at a given rate. This slews the vehicle at a controllable rate between it's 
     * previous speed and the new one. (affects GUIDED only. Outside GUIDED, aircraft ignores these 
     * commands. Designed for onboard companion-computer command-and-control, not normally 
     * operator/GCS control.) 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Airspeed or groundspeed.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Target Speed</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Acceleration rate, 0 to take effect instantly</dd>
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
    @MavlinkEntryInfo(43000)
    MAV_CMD_GUIDED_CHANGE_SPEED,

    /**
     * Change target altitude at a given rate. This slews the vehicle at a controllable rate between 
     * it's previous altitude and the new one. (affects GUIDED only. Outside GUIDED, aircraft 
     * ignores these commands. Designed for onboard companion-computer command-and-control, not 
     * normally operator/GCS control.) 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Empty</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Rate of change, toward new altitude. 0 for maximum rate change. Positive numbers only, as 
     * negative numbers will not converge on the new target alt.</dd>
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
     *   <dd>Target Altitude</dd>
     * </dl>
     */
    @MavlinkEntryInfo(43001)
    MAV_CMD_GUIDED_CHANGE_ALTITUDE,

    /**
     * Change to target heading at a given rate, overriding previous heading/s. This slews the 
     * vehicle at a controllable rate between it's previous heading and the new one. (affects GUIDED 
     * only. Exiting GUIDED returns aircraft to normal behaviour defined elsewhere. Designed for 
     * onboard companion-computer command-and-control, not normally operator/GCS control.) 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>course-over-ground or raw vehicle heading.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Target heading.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Maximum centripetal accelearation, ie rate of change, toward new heading.</dd>
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
    @MavlinkEntryInfo(43002)
    MAV_CMD_GUIDED_CHANGE_HEADING,

    /**
     * AVSS defined command. Set PRS arm statuses. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>PRS arm statuses</dd>
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
    @MavlinkEntryInfo(60050)
    MAV_CMD_PRS_SET_ARM,

    /**
     * AVSS defined command. Gets PRS arm statuses 
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
    @MavlinkEntryInfo(60051)
    MAV_CMD_PRS_GET_ARM,

    /**
     * AVSS defined command. Get the PRS battery voltage in millivolts 
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
    @MavlinkEntryInfo(60052)
    MAV_CMD_PRS_GET_BATTERY,

    /**
     * AVSS defined command. Get the PRS error statuses. 
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
    @MavlinkEntryInfo(60053)
    MAV_CMD_PRS_GET_ERR,

    /**
     * AVSS defined command. Set the ATS arming altitude in meters. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>ATS arming altitude</dd>
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
    @MavlinkEntryInfo(60070)
    MAV_CMD_PRS_SET_ARM_ALTI,

    /**
     * AVSS defined command. Get the ATS arming altitude in meters. 
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
    @MavlinkEntryInfo(60071)
    MAV_CMD_PRS_GET_ARM_ALTI,

    /**
     * AVSS defined command. Shuts down the PRS system. 
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
    @MavlinkEntryInfo(60072)
    MAV_CMD_PRS_SHUTDOWN,

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
     * Command to a gimbal manager to control the gimbal tilt and pan angles. It is possible to set 
     * combinations of the values below. E.g. an angle as well as a desired angular rate can be used to 
     * get to this angle at a certain angular rate, or an angular rate only will result in continuous 
     * turning. NaN is to be used to signal unset. A gimbal device is never to react to this command. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Pitch/tilt angle (positive: tilt up). NaN to be ignored.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Yaw/pan angle (positive: pan to the right). NaN to be ignored. The frame is determined by the 
     * GIMBAL_DEVICE_FLAGS_YAW_IN_xxx_FRAME flags.</dd>
     *
     *   <dt>param3</dt>
     *   <dd>Pitch/tilt rate (positive: tilt up). NaN to be ignored.</dd>
     *
     *   <dt>param4</dt>
     *   <dd>Yaw/pan rate (positive: pan to the right). NaN to be ignored. The frame is determined by the 
     * GIMBAL_DEVICE_FLAGS_YAW_IN_xxx_FRAME flags.</dd>
     *
     *   <dt>param5</dt>
     *   <dd>Gimbal device flags to be applied.</dd>
     *
     *   <dt>param6</dt>
     *   <dd>Gimbal manager flags to be applied.</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Gimbal ID of the gimbal manager to address (component ID or 1-6 for non-MAVLink gimbal, 0 for all 
     * gimbals). Send command multiple times for more than one but not all gimbals. The client is 
     * copied into bits 8-15.</dd>
     * </dl>
     */
    @MavlinkEntryInfo(60002)
    MAV_CMD_STORM32_DO_GIMBAL_MANAGER_CONTROL_PITCHYAW,

    /**
     * Command to configure a gimbal manager. A gimbal device is never to react to this command. The 
     * selected profile is reported in the STORM32_GIMBAL_MANAGER_STATUS message. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Gimbal manager profile (0 = default).</dd>
     *
     *   <dt>param7</dt>
     *   <dd>Gimbal ID of the gimbal manager to address (component ID or 1-6 for non-MAVLink gimbal, 0 for all 
     * gimbals). Send command multiple times for more than one but not all gimbals.</dd>
     * </dl>
     */
    @MavlinkEntryInfo(60010)
    MAV_CMD_STORM32_DO_GIMBAL_MANAGER_SETUP,

    /**
     * Command to set the shot manager mode. 
     * <dl>
     *   <dt>param1</dt>
     *   <dd>Set shot mode.</dd>
     *
     *   <dt>param2</dt>
     *   <dd>Set shot state or command. The allowed values are specific to the selected shot mode.</dd>
     * </dl>
     */
    @MavlinkEntryInfo(60020)
    MAV_CMD_QSHOT_DO_CONFIGURE,

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
    MAV_CMD_PREFLIGHT_STORAGE_ADVANCED
}
