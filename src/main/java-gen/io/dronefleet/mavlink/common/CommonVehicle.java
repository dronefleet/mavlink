package io.dronefleet.mavlink.common;

import com.benbarkay.events.EventEmitter;
import com.benbarkay.events.EventSource;
import io.dronefleet.mavlink.util.EnumFlagSet;
import io.dronefleet.mavlink.vehicle.AbstractMavlinkVehicle;
import io.dronefleet.mavlink.vehicle.MavlinkVehicle;
import java.lang.Float;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.math.BigInteger;
import java.util.List;

public interface CommonVehicle extends MavlinkVehicle {
    /**
     * THIS INTERFACE IS DEPRECATED. USE SET_MESSAGE_INTERVAL INSTEAD. 
     * @param reqMessageRate The requested message rate 
     * @param targetSystem The target requested to send the message stream. 
     * @param targetComponent The target requested to send the message stream. 
     * @param reqStreamId The ID of the requested data stream 
     * @param startStop 1 to start sending, 0 to stop sending. 
     */
    default void sendRequestDataStream(int reqMessageRate, int targetSystem, int targetComponent,
            int reqStreamId, int startStop) {
        outgoing().emit(RequestDataStream.builder()
                .reqMessageRate(reqMessageRate)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .reqStreamId(reqStreamId)
                .startStop(startStop)
                .build());
    }

    /**
     * Set the vehicle attitude and body angular rates. 
     * @param timeUsec Timestamp (micros since boot or Unix epoch) 
     * @param controls Actuator controls. Normed to -1..+1 where 0 is neutral position. Throttle for single rotation 
     * direction motors is 0..1, negative range for reverse direction. Standard mapping for 
     * attitude controls (group 0): (index 0-7): roll, pitch, yaw, throttle, flaps, spoilers, 
     * airbrakes, landing gear. Load a pass-through mixer to repurpose them as generic outputs. 
     * @param groupMlx Actuator group. The "_mlx" indicates this is a multi-instance message and a MAVLink parser 
     * should use this field to difference between instances. 
     */
    default void sendActuatorControlTarget(BigInteger timeUsec, List<Float> controls,
            int groupMlx) {
        outgoing().emit(ActuatorControlTarget.builder()
                .timeUsec(timeUsec)
                .controls(controls)
                .groupMlx(groupMlx)
                .build());
    }

    /**
     * Setup a MAVLink2 signing key. If called with secret_key of all zero and zero initial_timestamp 
     * will disable signing 
     * @param initialTimestamp initial timestamp 
     * @param targetSystem system id of the target 
     * @param targetComponent component ID of the target 
     * @param secretKey signing key 
     */
    default void sendSetupSigning(BigInteger initialTimestamp, int targetSystem,
            int targetComponent, byte[] secretKey) {
        outgoing().emit(SetupSigning.builder()
                .initialTimestamp(initialTimestamp)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .secretKey(secretKey)
                .build());
    }

    /**
     * WIP: Information about flight since last arming 
     * @param armingTimeUtc Timestamp at arming (microseconds since UNIX epoch) in UTC, 0 for unknown 
     * @param takeoffTimeUtc Timestamp at takeoff (microseconds since UNIX epoch) in UTC, 0 for unknown 
     * @param flightUuid Universally unique identifier (UUID) of flight, should correspond to name of logfiles 
     * @param timeBootMs Timestamp (milliseconds since system boot) 
     */
    default void sendFlightInformation(BigInteger armingTimeUtc, BigInteger takeoffTimeUtc,
            BigInteger flightUuid, long timeBootMs) {
        outgoing().emit(FlightInformation.builder()
                .armingTimeUtc(armingTimeUtc)
                .takeoffTimeUtc(takeoffTimeUtc)
                .flightUuid(flightUuid)
                .timeBootMs(timeBootMs)
                .build());
    }

    /**
     * Obstacle distances in front of the sensor, starting from the left in increment degrees to the 
     * right 
     * @param timeUsec Timestamp (microseconds since system boot or since UNIX epoch). 
     * @param distances Distance of obstacles around the UAV with index 0 corresponding to local North. A value of 0 
     * means that the obstacle is right in front of the sensor. A value of max_distance +1 means no 
     * obstacle is present. A value of UINT16_MAX for unknown/not used. In a array element, one unit 
     * corresponds to 1cm. 
     * @param minDistance Minimum distance the sensor can measure in centimeters. 
     * @param maxDistance Maximum distance the sensor can measure in centimeters. 
     * @param sensorType Class id of the distance sensor type. 
     * @param increment Angular width in degrees of each array element. 
     */
    default void sendObstacleDistance(BigInteger timeUsec, List<Integer> distances, int minDistance,
            int maxDistance, MavDistanceSensor sensorType, int increment) {
        outgoing().emit(ObstacleDistance.builder()
                .timeUsec(timeUsec)
                .distances(distances)
                .minDistance(minDistance)
                .maxDistance(maxDistance)
                .sensorType(sensorType)
                .increment(increment)
                .build());
    }

    /**
     * The IMU readings in SI units in NED body frame 
     * @param timeUsec Timestamp (microseconds, synced to UNIX time or since system boot) 
     * @param xacc X acceleration (m/s^2) 
     * @param yacc Y acceleration (m/s^2) 
     * @param zacc Z acceleration (m/s^2) 
     * @param xgyro Angular speed around X axis in body frame (rad / sec) 
     * @param ygyro Angular speed around Y axis in body frame (rad / sec) 
     * @param zgyro Angular speed around Z axis in body frame (rad / sec) 
     * @param xmag X Magnetic field (Gauss) 
     * @param ymag Y Magnetic field (Gauss) 
     * @param zmag Z Magnetic field (Gauss) 
     * @param absPressure Absolute pressure in millibar 
     * @param diffPressure Differential pressure (airspeed) in millibar 
     * @param pressureAlt Altitude calculated from pressure 
     * @param temperature Temperature in degrees celsius 
     * @param fieldsUpdated Bitmask for fields that have updated since last message, bit 0 = xacc, bit 12: temperature, bit 
     * 31: full reset of attitude/position/velocities/etc was performed in sim. 
     */
    default void sendHilSensor(BigInteger timeUsec, float xacc, float yacc, float zacc, float xgyro,
            float ygyro, float zgyro, float xmag, float ymag, float zmag, float absPressure,
            float diffPressure, float pressureAlt, float temperature, long fieldsUpdated) {
        outgoing().emit(HilSensor.builder()
                .timeUsec(timeUsec)
                .xacc(xacc)
                .yacc(yacc)
                .zacc(zacc)
                .xgyro(xgyro)
                .ygyro(ygyro)
                .zgyro(zgyro)
                .xmag(xmag)
                .ymag(ymag)
                .zmag(zmag)
                .absPressure(absPressure)
                .diffPressure(diffPressure)
                .pressureAlt(pressureAlt)
                .temperature(temperature)
                .fieldsUpdated(fieldsUpdated)
                .build());
    }

    /**
     * Camera-IMU triggering and synchronisation message. 
     * @param timeUsec Timestamp for the image frame in microseconds 
     * @param seq Image frame sequence 
     */
    default void sendCameraTrigger(BigInteger timeUsec, long seq) {
        outgoing().emit(CameraTrigger.builder()
                .timeUsec(timeUsec)
                .seq(seq)
                .build());
    }

    /**
     * Request all parameters of this component. After this request, all parameters are emitted. 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     */
    default void sendParamRequestList(int targetSystem, int targetComponent) {
        outgoing().emit(ParamRequestList.builder()
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .build());
    }

    /**
     * RTK GPS data. Gives information on the relative baseline calculation the GPS is reporting 
     * @param timeLastBaselineMs Time since boot of last baseline message received in ms. 
     * @param tow GPS Time of Week of last baseline 
     * @param baselineAMm Current baseline in ECEF x or NED north component in mm. 
     * @param baselineBMm Current baseline in ECEF y or NED east component in mm. 
     * @param baselineCMm Current baseline in ECEF z or NED down component in mm. 
     * @param accuracy Current estimate of baseline accuracy. 
     * @param iarNumHypotheses Current number of integer ambiguity hypotheses. 
     * @param wn GPS Week Number of last baseline 
     * @param rtkReceiverId Identification of connected RTK receiver. 
     * @param rtkHealth GPS-specific health report for RTK data. 
     * @param rtkRate Rate of baseline messages being received by GPS, in HZ 
     * @param nsats Current number of sats used for RTK calculation. 
     * @param baselineCoordsType Coordinate system of baseline 
     */
    default void sendGpsRtk(long timeLastBaselineMs, long tow, int baselineAMm, int baselineBMm,
            int baselineCMm, long accuracy, int iarNumHypotheses, int wn, int rtkReceiverId,
            int rtkHealth, int rtkRate, int nsats, RtkBaselineCoordinateSystem baselineCoordsType) {
        outgoing().emit(GpsRtk.builder()
                .timeLastBaselineMs(timeLastBaselineMs)
                .tow(tow)
                .baselineAMm(baselineAMm)
                .baselineBMm(baselineBMm)
                .baselineCMm(baselineCMm)
                .accuracy(accuracy)
                .iarNumHypotheses(iarNumHypotheses)
                .wn(wn)
                .rtkReceiverId(rtkReceiverId)
                .rtkHealth(rtkHealth)
                .rtkRate(rtkRate)
                .nsats(nsats)
                .baselineCoordsType(baselineCoordsType)
                .build());
    }

    /**
     * Reports the current commanded vehicle position, velocity, and acceleration as specified by 
     * the autopilot. This should match the commands sent in {@link io.dronefleet.mavlink.common.SetPositionTargetLocalNed SetPositionTargetLocalNed} if the 
     * vehicle is being controlled this way. 
     * @param timeBootMs Timestamp in milliseconds since system boot 
     * @param x X Position in NED frame in meters 
     * @param y Y Position in NED frame in meters 
     * @param z Z Position in NED frame in meters (note, altitude is negative in NED) 
     * @param vx X velocity in NED frame in meter / s 
     * @param vy Y velocity in NED frame in meter / s 
     * @param vz Z velocity in NED frame in meter / s 
     * @param afx X acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N 
     * @param afy Y acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N 
     * @param afz Z acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N 
     * @param yaw yaw setpoint in rad 
     * @param yawRate yaw rate setpoint in rad/s 
     * @param typeMask Bitmask to indicate which dimensions should be ignored by the vehicle: a value of 
     * 0b0000000000000000 or 0b0000001000000000 indicates that none of the setpoint dimensions 
     * should be ignored. If bit 10 is set the floats afx afy afz should be interpreted as force instead 
     * of acceleration. Mapping: bit 1: x, bit 2: y, bit 3: z, bit 4: vx, bit 5: vy, bit 6: vz, bit 7: ax, bit 
     * 8: ay, bit 9: az, bit 10: is force setpoint, bit 11: yaw, bit 12: yaw rate 
     * @param coordinateFrame Valid options are: MAV_FRAME_LOCAL_NED = 1, MAV_FRAME_LOCAL_OFFSET_NED = 7, 
     * MAV_FRAME_BODY_NED = 8, MAV_FRAME_BODY_OFFSET_NED = 9 
     */
    default void sendPositionTargetLocalNed(long timeBootMs, float x, float y, float z, float vx,
            float vy, float vz, float afx, float afy, float afz, float yaw, float yawRate,
            int typeMask, MavFrame coordinateFrame) {
        outgoing().emit(PositionTargetLocalNed.builder()
                .timeBootMs(timeBootMs)
                .x(x)
                .y(y)
                .z(z)
                .vx(vx)
                .vy(vy)
                .vz(vz)
                .afx(afx)
                .afy(afy)
                .afz(afz)
                .yaw(yaw)
                .yawRate(yawRate)
                .typeMask(typeMask)
                .coordinateFrame(coordinateFrame)
                .build());
    }

    /**
     * The smoothed, monotonic system state used to feed the control loops of the system. 
     * @param timeUsec Timestamp (micros since boot or Unix epoch) 
     * @param xAcc X acceleration in body frame 
     * @param yAcc Y acceleration in body frame 
     * @param zAcc Z acceleration in body frame 
     * @param xVel X velocity in body frame 
     * @param yVel Y velocity in body frame 
     * @param zVel Z velocity in body frame 
     * @param xPos X position in local frame 
     * @param yPos Y position in local frame 
     * @param zPos Z position in local frame 
     * @param airspeed Airspeed, set to -1 if unknown 
     * @param velVariance Variance of body velocity estimate 
     * @param posVariance Variance in local position 
     * @param q The attitude, represented as Quaternion 
     * @param rollRate Angular rate in roll axis 
     * @param pitchRate Angular rate in pitch axis 
     * @param yawRate Angular rate in yaw axis 
     */
    default void sendControlSystemState(BigInteger timeUsec, float xAcc, float yAcc, float zAcc,
            float xVel, float yVel, float zVel, float xPos, float yPos, float zPos, float airspeed,
            List<Float> velVariance, List<Float> posVariance, List<Float> q, float rollRate,
            float pitchRate, float yawRate) {
        outgoing().emit(ControlSystemState.builder()
                .timeUsec(timeUsec)
                .xAcc(xAcc)
                .yAcc(yAcc)
                .zAcc(zAcc)
                .xVel(xVel)
                .yVel(yVel)
                .zVel(zVel)
                .xPos(xPos)
                .yPos(yPos)
                .zPos(zPos)
                .airspeed(airspeed)
                .velVariance(velVariance)
                .posVariance(posVariance)
                .q(q)
                .rollRate(rollRate)
                .pitchRate(pitchRate)
                .yawRate(yawRate)
                .build());
    }

    /**
     * Time synchronization message. 
     * @param tc1 Time sync timestamp 1 
     * @param ts1 Time sync timestamp 2 
     */
    default void sendTimesync(long tc1, long ts1) {
        outgoing().emit(Timesync.builder()
                .tc1(tc1)
                .ts1(ts1)
                .build());
    }

    /**
     * A certain mission item has been reached. The system will either hold this position (or circle on 
     * the orbit) or (if the autocontinue on the WP was set) continue to the next waypoint. 
     * @param seq Sequence 
     */
    default void sendMissionItemReached(int seq) {
        outgoing().emit(MissionItemReached.builder()
                .seq(seq)
                .build());
    }

    /**
     * Message implementing parts of the V2 payload specs in V1 frames for transitional support. 
     * @param messageType A code that identifies the software component that understands this message (analogous to usb 
     * device classes or mime type strings). If this code is less than 32768, it is considered a 
     * 'registered' protocol extension and the corresponding entry should be added to 
     * https://github.com/mavlink/mavlink/extension-message-ids.xml. Software creators can 
     * register blocks of message IDs as needed (useful for GCS specific metadata, etc...). 
     * Message_types greater than 32767 are considered local experiments and should not be checked 
     * in to any widely distributed codebase. 
     * @param targetNetwork Network ID (0 for broadcast) 
     * @param targetSystem System ID (0 for broadcast) 
     * @param targetComponent Component ID (0 for broadcast) 
     * @param payload Variable length payload. The length is defined by the remaining message length when 
     * subtracting the header and other fields. The entire content of this block is opaque unless you 
     * understand any the encoding message_type. The particular encoding used can be extension 
     * specific and might not always be documented as part of the mavlink specification. 
     */
    default void sendV2Extension(int messageType, int targetNetwork, int targetSystem,
            int targetComponent, byte[] payload) {
        outgoing().emit(V2Extension.builder()
                .messageType(messageType)
                .targetNetwork(targetNetwork)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .payload(payload)
                .build());
    }

    /**
     * null
     * @param timeUsec Timestamp 
     * @param x x 
     * @param y y 
     * @param z z 
     * @param name Name 
     */
    default void sendDebugVect(BigInteger timeUsec, float x, float y, float z, String name) {
        outgoing().emit(DebugVect.builder()
                .timeUsec(timeUsec)
                .x(x)
                .y(y)
                .z(z)
                .name(name)
                .build());
    }

    /**
     * Battery information 
     * @param currentConsumed Consumed charge, in milliampere hours (1 = 1 mAh), -1: autopilot does not provide mAh 
     * consumption estimate 
     * @param energyConsumed Consumed energy, in HectoJoules (intergrated U*I*dt) (1 = 100 Joule), -1: autopilot does not 
     * provide energy consumption estimate 
     * @param temperature Temperature of the battery in centi-degrees celsius. INT16_MAX for unknown temperature. 
     * @param voltages Battery voltage of cells, in millivolts (1 = 1 millivolt). Cells above the valid cell count for 
     * this battery should have the UINT16_MAX value. 
     * @param currentBattery Battery current, in 10*milliamperes (1 = 10 milliampere), -1: autopilot does not measure the 
     * current 
     * @param id Battery ID 
     * @param batteryFunction Function of the battery 
     * @param type Type (chemistry) of the battery 
     * @param batteryRemaining Remaining battery energy: (0%: 0, 100%: 100), -1: autopilot does not estimate the remaining 
     * battery 
     * @param timeRemaining Remaining battery time, in seconds (1 = 1s = 0% energy left), 0: autopilot does not provide 
     * remaining battery time estimate 
     * @param chargeState State for extent of discharge, provided by autopilot for warning or external reactions 
     */
    default void sendBatteryStatus(int currentConsumed, int energyConsumed, int temperature,
            List<Integer> voltages, int currentBattery, int id, MavBatteryFunction batteryFunction,
            MavBatteryType type, int batteryRemaining, int timeRemaining,
            MavBatteryChargeState chargeState) {
        outgoing().emit(BatteryStatus.builder()
                .currentConsumed(currentConsumed)
                .energyConsumed(energyConsumed)
                .temperature(temperature)
                .voltages(voltages)
                .currentBattery(currentBattery)
                .id(id)
                .batteryFunction(batteryFunction)
                .type(type)
                .batteryRemaining(batteryRemaining)
                .timeRemaining(timeRemaining)
                .chargeState(chargeState)
                .build());
    }

    /**
     * Message that announces the sequence number of the current active mission item. The MAV will fly 
     * towards this mission item. 
     * @param seq Sequence 
     */
    default void sendMissionCurrent(int seq) {
        outgoing().emit(MissionCurrent.builder()
                .seq(seq)
                .build());
    }

    /**
     * null
     * @param usec Timestamp (microseconds, synced to UNIX time or since system boot) 
     * @param x Global X position 
     * @param y Global Y position 
     * @param z Global Z position 
     * @param roll Roll angle in rad 
     * @param pitch Pitch angle in rad 
     * @param yaw Yaw angle in rad 
     * @param covariance Pose covariance matrix upper right triangular (first six entries are the first ROW, next five 
     * entries are the second ROW, etc.) 
     */
    default void sendVisionPositionEstimate(BigInteger usec, float x, float y, float z, float roll,
            float pitch, float yaw, List<Float> covariance) {
        outgoing().emit(VisionPositionEstimate.builder()
                .usec(usec)
                .x(x)
                .y(y)
                .z(z)
                .roll(roll)
                .pitch(pitch)
                .yaw(yaw)
                .covariance(covariance)
                .build());
    }

    /**
     * Delete all mission items at once. 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param missionType Mission type, see {@link io.dronefleet.mavlink.common.MavMissionType MavMissionType} 
     */
    default void sendMissionClearAll(int targetSystem, int targetComponent,
            MavMissionType missionType) {
        outgoing().emit(MissionClearAll.builder()
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .missionType(missionType)
                .build());
    }

    /**
     * General status information of an UAVCAN node. Please refer to the definition of the UAVCAN 
     * message "uavcan.protocol.NodeStatus" for the background information. The UAVCAN 
     * specification is available at http://uavcan.org. 
     * @param timeUsec Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
     * @param uptimeSec The number of seconds since the start-up of the node. 
     * @param vendorSpecificStatusCode Vendor-specific status information. 
     * @param health Generalized node health status. 
     * @param mode Generalized operating mode. 
     * @param subMode Not used currently. 
     */
    default void sendUavcanNodeStatus(BigInteger timeUsec, long uptimeSec,
            int vendorSpecificStatusCode, UavcanNodeHealth health, UavcanNodeMode mode,
            int subMode) {
        outgoing().emit(UavcanNodeStatus.builder()
                .timeUsec(timeUsec)
                .uptimeSec(uptimeSec)
                .vendorSpecificStatusCode(vendorSpecificStatusCode)
                .health(health)
                .mode(mode)
                .subMode(subMode)
                .build());
    }

    /**
     * Motion capture attitude and position 
     * @param timeUsec Timestamp (micros since boot or Unix epoch) 
     * @param q Attitude quaternion (w, x, y, z order, zero-rotation is 1, 0, 0, 0) 
     * @param x X position in meters (NED) 
     * @param y Y position in meters (NED) 
     * @param z Z position in meters (NED) 
     * @param covariance Pose covariance matrix upper right triangular (first six entries are the first ROW, next five 
     * entries are the second ROW, etc.) 
     */
    default void sendAttPosMocap(BigInteger timeUsec, List<Float> q, float x, float y, float z,
            List<Float> covariance) {
        outgoing().emit(AttPosMocap.builder()
                .timeUsec(timeUsec)
                .q(q)
                .x(x)
                .y(y)
                .z(z)
                .covariance(covariance)
                .build());
    }

    /**
     * Report status of a command. Includes feedback whether the command was executed. 
     * @param command Command ID, as defined by {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum. 
     * @param result See {@link io.dronefleet.mavlink.common.MavResult MavResult} enum 
     * @param progress WIP: Also used as result_param1, it can be set with a enum containing the errors reasons of why 
     * the command was denied or the progress percentage or 255 if unknown the progress when result is 
     * MAV_RESULT_IN_PROGRESS. 
     * @param resultParam2 WIP: Additional parameter of the result, example: which parameter of MAV_CMD_NAV_WAYPOINT 
     * caused it to be denied. 
     * @param targetSystem WIP: System which requested the command to be executed 
     * @param targetComponent WIP: Component which requested the command to be executed 
     */
    default void sendCommandAck(MavCmd command, MavResult result, int progress, int resultParam2,
            int targetSystem, int targetComponent) {
        outgoing().emit(CommandAck.builder()
                .command(command)
                .result(result)
                .progress(progress)
                .resultParam2(resultParam2)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .build());
    }

    /**
     * The global position, as returned by the Global Positioning System (GPS). This is NOT the global 
     * position estimate of the sytem, but rather a RAW sensor value. See message GLOBAL_POSITION for 
     * the global position estimate. 
     * @param timeUsec Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
     * @param lat Latitude (WGS84), in degrees * 1E7 
     * @param lon Longitude (WGS84), in degrees * 1E7 
     * @param alt Altitude (AMSL, not WGS84), in meters * 1000 (positive for up) 
     * @param eph GPS HDOP horizontal dilution of position in cm (m*100). If unknown, set to: 65535 
     * @param epv GPS VDOP vertical dilution of position in cm (m*100). If unknown, set to: 65535 
     * @param vel GPS ground speed in cm/s. If unknown, set to: 65535 
     * @param vn GPS velocity in cm/s in NORTH direction in earth-fixed NED frame 
     * @param ve GPS velocity in cm/s in EAST direction in earth-fixed NED frame 
     * @param vd GPS velocity in cm/s in DOWN direction in earth-fixed NED frame 
     * @param cog Course over ground (NOT heading, but direction of movement) in degrees * 100, 0.0..359.99 
     * degrees. If unknown, set to: 65535 
     * @param fixType 0-1: no fix, 2: 2D fix, 3: 3D fix. Some applications will not use the value of this field unless it 
     * is at least two, so always correctly fill in the fix. 
     * @param satellitesVisible Number of satellites visible. If unknown, set to 255 
     */
    default void sendHilGps(BigInteger timeUsec, int lat, int lon, int alt, int eph, int epv,
            int vel, int vn, int ve, int vd, int cog, int fixType, int satellitesVisible) {
        outgoing().emit(HilGps.builder()
                .timeUsec(timeUsec)
                .lat(lat)
                .lon(lon)
                .alt(alt)
                .eph(eph)
                .epv(epv)
                .vel(vel)
                .vn(vn)
                .ve(ve)
                .vd(vd)
                .cog(cog)
                .fixType(fixType)
                .satellitesVisible(satellitesVisible)
                .build());
    }

    /**
     * Request a list of available logs. On some systems calling this may stop on-board logging until 
     * LOG_REQUEST_END is called. 
     * @param start First log id (0 for first available) 
     * @param end Last log id (0xffff for last available) 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     */
    default void sendLogRequestList(int start, int end, int targetSystem, int targetComponent) {
        outgoing().emit(LogRequestList.builder()
                .start(start)
                .end(end)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .build());
    }

    /**
     * Request a chunk of a log 
     * @param ofs Offset into the log 
     * @param count Number of bytes 
     * @param id Log id (from {@link io.dronefleet.mavlink.common.LogEntry LogEntry} reply) 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     */
    default void sendLogRequestData(long ofs, long count, int id, int targetSystem,
            int targetComponent) {
        outgoing().emit(LogRequestData.builder()
                .ofs(ofs)
                .count(count)
                .id(id)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .build());
    }

    /**
     * Emit the value of a parameter. The inclusion of param_count and param_index in the message 
     * allows the recipient to keep track of received parameters and allows them to re-request 
     * missing parameters after a loss or timeout. 
     * @param paramCount Total number of parameters 
     * @param paramIndex Index of this parameter 
     * @param paramId Parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT 
     * null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 
     * 16+1 bytes storage if the ID is stored as string 
     * @param paramValue Parameter value 
     * @param paramType Parameter type: see the {@link io.dronefleet.mavlink.common.MavParamExtType MavParamExtType} enum for supported data types. 
     */
    default void sendParamExtValue(int paramCount, int paramIndex, String paramId,
            String paramValue, MavParamExtType paramType) {
        outgoing().emit(ParamExtValue.builder()
                .paramCount(paramCount)
                .paramIndex(paramIndex)
                .paramId(paramId)
                .paramValue(paramValue)
                .paramType(paramType)
                .build());
    }

    /**
     * Erase all logs 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     */
    default void sendLogErase(int targetSystem, int targetComponent) {
        outgoing().emit(LogErase.builder()
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .build());
    }

    /**
     * Message appropriate for high latency connections like Iridium 
     * @param customMode A bitfield for use for autopilot-specific flags. 
     * @param latitude Latitude, expressed as degrees * 1E7 
     * @param longitude Longitude, expressed as degrees * 1E7 
     * @param roll roll (centidegrees) 
     * @param pitch pitch (centidegrees) 
     * @param heading heading (centidegrees) 
     * @param headingSp heading setpoint (centidegrees) 
     * @param altitudeAmsl Altitude above mean sea level (meters) 
     * @param altitudeSp Altitude setpoint relative to the home position (meters) 
     * @param wpDistance distance to target (meters) 
     * @param baseMode System mode bitfield, as defined by {@link io.dronefleet.mavlink.common.MavModeFlag MavModeFlag} enum. 
     * @param landedState The landed state. Is set to MAV_LANDED_STATE_UNDEFINED if landed state is unknown. 
     * @param throttle throttle (percentage) 
     * @param airspeed airspeed (m/s) 
     * @param airspeedSp airspeed setpoint (m/s) 
     * @param groundspeed groundspeed (m/s) 
     * @param climbRate climb rate (m/s) 
     * @param gpsNsat Number of satellites visible. If unknown, set to 255 
     * @param gpsFixType See the {@link io.dronefleet.mavlink.common.GpsFixType GpsFixType} enum. 
     * @param batteryRemaining Remaining battery (percentage) 
     * @param temperature Autopilot temperature (degrees C) 
     * @param temperatureAir Air temperature (degrees C) from airspeed sensor 
     * @param failsafe failsafe (each bit represents a failsafe where 0=ok, 1=failsafe active (bit0:RC, bit1:batt, 
     * bit2:GPS, bit3:GCS, bit4:fence) 
     * @param wpNum current waypoint number 
     */
    default void sendHighLatency(long customMode, int latitude, int longitude, int roll, int pitch,
            int heading, int headingSp, int altitudeAmsl, int altitudeSp, int wpDistance,
            EnumFlagSet<MavModeFlag> baseMode, MavLandedState landedState, int throttle,
            int airspeed, int airspeedSp, int groundspeed, int climbRate, int gpsNsat,
            GpsFixType gpsFixType, int batteryRemaining, int temperature, int temperatureAir,
            int failsafe, int wpNum) {
        outgoing().emit(HighLatency.builder()
                .customMode(customMode)
                .latitude(latitude)
                .longitude(longitude)
                .roll(roll)
                .pitch(pitch)
                .heading(heading)
                .headingSp(headingSp)
                .altitudeAmsl(altitudeAmsl)
                .altitudeSp(altitudeSp)
                .wpDistance(wpDistance)
                .baseMode(baseMode)
                .landedState(landedState)
                .throttle(throttle)
                .airspeed(airspeed)
                .airspeedSp(airspeedSp)
                .groundspeed(groundspeed)
                .climbRate(climbRate)
                .gpsNsat(gpsNsat)
                .gpsFixType(gpsFixType)
                .batteryRemaining(batteryRemaining)
                .temperature(temperature)
                .temperatureAir(temperatureAir)
                .failsafe(failsafe)
                .wpNum(wpNum)
                .build());
    }

    /**
     * null
     * @param timeBootMs Time since system boot 
     * @param minDistance Minimum distance the sensor can measure in centimeters 
     * @param maxDistance Maximum distance the sensor can measure in centimeters 
     * @param currentDistance Current distance reading 
     * @param type Type from {@link io.dronefleet.mavlink.common.MavDistanceSensor MavDistanceSensor} enum. 
     * @param id Onboard ID of the sensor 
     * @param orientation Direction the sensor faces from {@link io.dronefleet.mavlink.common.MavSensorOrientation MavSensorOrientation} enum. downward-facing: 
     * ROTATION_PITCH_270, upward-facing: ROTATION_PITCH_90, backward-facing: 
     * ROTATION_PITCH_180, forward-facing: ROTATION_NONE, left-facing: ROTATION_YAW_90, 
     * right-facing: ROTATION_YAW_270 
     * @param covariance Measurement covariance in centimeters, 0 for unknown / invalid readings 
     */
    default void sendDistanceSensor(long timeBootMs, int minDistance, int maxDistance,
            int currentDistance, MavDistanceSensor type, int id, MavSensorOrientation orientation,
            int covariance) {
        outgoing().emit(DistanceSensor.builder()
                .timeBootMs(timeBootMs)
                .minDistance(minDistance)
                .maxDistance(maxDistance)
                .currentDistance(currentDistance)
                .type(type)
                .id(id)
                .orientation(orientation)
                .covariance(covariance)
                .build());
    }

    /**
     * Request to read the value of a parameter with the either the param_id string id or param_index. 
     * @param paramIndex Parameter index. Set to -1 to use the Parameter ID field as identifier (else param_id will be 
     * ignored) 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param paramId Parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT 
     * null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 
     * 16+1 bytes storage if the ID is stored as string 
     */
    default void sendParamExtRequestRead(int paramIndex, int targetSystem, int targetComponent,
            String paramId) {
        outgoing().emit(ParamExtRequestRead.builder()
                .paramIndex(paramIndex)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .paramId(paramId)
                .build());
    }

    /**
     * Information about a captured image 
     * @param timeUtc Timestamp (microseconds since UNIX epoch) in UTC. 0 for unknown. 
     * @param timeBootMs Timestamp (milliseconds since system boot) 
     * @param lat Latitude, expressed as degrees * 1E7 where image was taken 
     * @param lon Longitude, expressed as degrees * 1E7 where capture was taken 
     * @param alt Altitude in meters, expressed as * 1E3 (AMSL, not WGS84) where image was taken 
     * @param relativeAlt Altitude above ground in meters, expressed as * 1E3 where image was taken 
     * @param q Quaternion of camera orientation (w, x, y, z order, zero-rotation is 0, 0, 0, 0) 
     * @param imageIndex Zero based index of this image (image count since armed -1) 
     * @param cameraId Camera ID (1 for first, 2 for second, etc.) 
     * @param captureResult Boolean indicating success (1) or failure (0) while capturing this image. 
     * @param fileUrl URL of image taken. Either local storage or http://foo.jpg if camera provides an HTTP 
     * interface. 
     */
    default void sendCameraImageCaptured(BigInteger timeUtc, long timeBootMs, int lat, int lon,
            int alt, int relativeAlt, List<Float> q, int imageIndex, int cameraId,
            int captureResult, String fileUrl) {
        outgoing().emit(CameraImageCaptured.builder()
                .timeUtc(timeUtc)
                .timeBootMs(timeBootMs)
                .lat(lat)
                .lon(lon)
                .alt(alt)
                .relativeAlt(relativeAlt)
                .q(q)
                .imageIndex(imageIndex)
                .cameraId(cameraId)
                .captureResult(captureResult)
                .fileUrl(fileUrl)
                .build());
    }

    /**
     * Report button state change 
     * @param timeBootMs Timestamp (milliseconds since system boot) 
     * @param lastChangeMs Time of last change of button state 
     * @param state Bitmap state of buttons 
     */
    default void sendButtonChange(long timeBootMs, long lastChangeMs, int state) {
        outgoing().emit(ButtonChange.builder()
                .timeBootMs(timeBootMs)
                .lastChangeMs(lastChangeMs)
                .state(state)
                .build());
    }

    /**
     * The filtered local position (e.g. fused computer vision and accelerometers). Coordinate 
     * frame is right-handed, Z-axis down (aeronautical frame, NED / north-east-down convention) 
     * @param timeUsec Timestamp (microseconds since system boot or since UNIX epoch) 
     * @param x X Position 
     * @param y Y Position 
     * @param z Z Position 
     * @param vx X Speed (m/s) 
     * @param vy Y Speed (m/s) 
     * @param vz Z Speed (m/s) 
     * @param ax X Acceleration (m/s^2) 
     * @param ay Y Acceleration (m/s^2) 
     * @param az Z Acceleration (m/s^2) 
     * @param covariance Covariance matrix upper right triangular (first nine entries are the first ROW, next eight 
     * entries are the second row, etc.) 
     * @param estimatorType Class id of the estimator this estimate originated from. 
     */
    default void sendLocalPositionNedCov(BigInteger timeUsec, float x, float y, float z, float vx,
            float vy, float vz, float ax, float ay, float az, List<Float> covariance,
            MavEstimatorType estimatorType) {
        outgoing().emit(LocalPositionNedCov.builder()
                .timeUsec(timeUsec)
                .x(x)
                .y(y)
                .z(z)
                .vx(vx)
                .vy(vy)
                .vz(vz)
                .ax(ax)
                .ay(ay)
                .az(az)
                .covariance(covariance)
                .estimatorType(estimatorType)
                .build());
    }

    /**
     * Reports the current commanded attitude of the vehicle as specified by the autopilot. This 
     * should match the commands sent in a {@link io.dronefleet.mavlink.common.SetAttitudeTarget SetAttitudeTarget} message if the vehicle is being 
     * controlled this way. 
     * @param timeBootMs Timestamp in milliseconds since system boot 
     * @param q Attitude quaternion (w, x, y, z order, zero-rotation is 1, 0, 0, 0) 
     * @param bodyRollRate Body roll rate in radians per second 
     * @param bodyPitchRate Body pitch rate in radians per second 
     * @param bodyYawRate Body yaw rate in radians per second 
     * @param thrust Collective thrust, normalized to 0 .. 1 (-1 .. 1 for vehicles capable of reverse trust) 
     * @param typeMask Mappings: If any of these bits are set, the corresponding input should be ignored: bit 1: body 
     * roll rate, bit 2: body pitch rate, bit 3: body yaw rate. bit 4-bit 7: reserved, bit 8: attitude 
     */
    default void sendAttitudeTarget(long timeBootMs, List<Float> q, float bodyRollRate,
            float bodyPitchRate, float bodyYawRate, float thrust, int typeMask) {
        outgoing().emit(AttitudeTarget.builder()
                .timeBootMs(timeBootMs)
                .q(q)
                .bodyRollRate(bodyRollRate)
                .bodyPitchRate(bodyPitchRate)
                .bodyYawRate(bodyYawRate)
                .thrust(thrust)
                .typeMask(typeMask)
                .build());
    }

    /**
     * Request to control this MAV 
     * @param targetSystem System the GCS requests control for 
     * @param controlRequest 0: request control of this MAV, 1: Release control of this MAV 
     * @param version 0: key as plaintext, 1-255: future, different hashing/encryption variants. The GCS should in 
     * general use the safest mode possible initially and then gradually move down the encryption 
     * level if it gets a NACK message indicating an encryption mismatch. 
     * @param passkey Password / Key, depending on version plaintext or encrypted. 25 or less characters, NULL 
     * terminated. The characters may involve A-Z, a-z, 0-9, and "!?,.-" 
     */
    default void sendChangeOperatorControl(int targetSystem, int controlRequest, int version,
            String passkey) {
        outgoing().emit(ChangeOperatorControl.builder()
                .targetSystem(targetSystem)
                .controlRequest(controlRequest)
                .version(version)
                .passkey(passkey)
                .build());
    }

    /**
     * Request the information of the mission item with the sequence number seq. The response of the 
     * system to this message should be a {@link io.dronefleet.mavlink.common.MissionItem MissionItem} message. 
     * https://mavlink.io/en/protocol/mission.html 
     * @param seq Sequence 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param missionType Mission type, see {@link io.dronefleet.mavlink.common.MavMissionType MavMissionType} 
     */
    default void sendMissionRequest(int seq, int targetSystem, int targetComponent,
            MavMissionType missionType) {
        outgoing().emit(MissionRequest.builder()
                .seq(seq)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .missionType(missionType)
                .build());
    }

    /**
     * The filtered global position (e.g. fused GPS and accelerometers). The position is in 
     * GPS-frame (right-handed, Z-up). It is designed as scaled integer message since the 
     * resolution of float is not sufficient. 
     * @param timeBootMs Timestamp (milliseconds since system boot) 
     * @param lat Latitude, expressed as degrees * 1E7 
     * @param lon Longitude, expressed as degrees * 1E7 
     * @param alt Altitude in meters, expressed as * 1000 (millimeters), AMSL (not WGS84 - note that virtually 
     * all GPS modules provide the AMSL as well) 
     * @param relativeAlt Altitude above ground in meters, expressed as * 1000 (millimeters) 
     * @param vx Ground X Speed (Latitude, positive north), expressed as m/s * 100 
     * @param vy Ground Y Speed (Longitude, positive east), expressed as m/s * 100 
     * @param vz Ground Z Speed (Altitude, positive down), expressed as m/s * 100 
     * @param hdg Vehicle heading (yaw angle) in degrees * 100, 0.0..359.99 degrees. If unknown, set to: 
     * UINT16_MAX 
     */
    default void sendGlobalPositionInt(long timeBootMs, int lat, int lon, int alt, int relativeAlt,
            int vx, int vy, int vz, int hdg) {
        outgoing().emit(GlobalPositionInt.builder()
                .timeBootMs(timeBootMs)
                .lat(lat)
                .lon(lon)
                .alt(alt)
                .relativeAlt(relativeAlt)
                .vx(vx)
                .vy(vy)
                .vz(vz)
                .hdg(hdg)
                .build());
    }

    /**
     * Version and capability of autopilot software 
     * @param capabilities bitmask of capabilities (see {@link io.dronefleet.mavlink.common.MavProtocolCapability MavProtocolCapability} enum) 
     * @param uid UID if provided by hardware (see uid2) 
     * @param flightSwVersion Firmware version number 
     * @param middlewareSwVersion Middleware version number 
     * @param osSwVersion Operating system version number 
     * @param boardVersion HW / board version (last 8 bytes should be silicon ID, if any) 
     * @param vendorId ID of the board vendor 
     * @param productId ID of the product 
     * @param flightCustomVersion Custom version field, commonly the first 8 bytes of the git hash. This is not an unique 
     * identifier, but should allow to identify the commit using the main version number even for very 
     * large code bases. 
     * @param middlewareCustomVersion Custom version field, commonly the first 8 bytes of the git hash. This is not an unique 
     * identifier, but should allow to identify the commit using the main version number even for very 
     * large code bases. 
     * @param osCustomVersion Custom version field, commonly the first 8 bytes of the git hash. This is not an unique 
     * identifier, but should allow to identify the commit using the main version number even for very 
     * large code bases. 
     * @param uid2 UID if provided by hardware (supersedes the uid field. If this is non-zero, use this field, 
     * otherwise use uid) 
     */
    default void sendAutopilotVersion(EnumFlagSet<MavProtocolCapability> capabilities,
            BigInteger uid, long flightSwVersion, long middlewareSwVersion, long osSwVersion,
            long boardVersion, int vendorId, int productId, byte[] flightCustomVersion,
            byte[] middlewareCustomVersion, byte[] osCustomVersion, byte[] uid2) {
        outgoing().emit(AutopilotVersion.builder()
                .capabilities(capabilities)
                .uid(uid)
                .flightSwVersion(flightSwVersion)
                .middlewareSwVersion(middlewareSwVersion)
                .osSwVersion(osSwVersion)
                .boardVersion(boardVersion)
                .vendorId(vendorId)
                .productId(productId)
                .flightCustomVersion(flightCustomVersion)
                .middlewareCustomVersion(middlewareCustomVersion)
                .osCustomVersion(osCustomVersion)
                .uid2(uid2)
                .build());
    }

    /**
     * A message containing logged data (see also MAV_CMD_LOGGING_START) 
     * @param sequence sequence number (can wrap) 
     * @param targetSystem system ID of the target 
     * @param targetComponent component ID of the target 
     * @param length data length 
     * @param firstMessageOffset offset into data where first message starts. This can be used for recovery, when a previous 
     * message got lost (set to 255 if no start exists). 
     * @param data logged data 
     */
    default void sendLoggingData(int sequence, int targetSystem, int targetComponent, int length,
            int firstMessageOffset, byte[] data) {
        outgoing().emit(LoggingData.builder()
                .sequence(sequence)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .length(length)
                .firstMessageOffset(firstMessageOffset)
                .data(data)
                .build());
    }

    /**
     * Request all parameters of this component. After this request, all parameters are emitted. 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     */
    default void sendParamExtRequestList(int targetSystem, int targetComponent) {
        outgoing().emit(ParamExtRequestList.builder()
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .build());
    }

    /**
     * null
     * @param usec Timestamp (microseconds, synced to UNIX time or since system boot) 
     * @param x Global X position 
     * @param y Global Y position 
     * @param z Global Z position 
     * @param roll Roll angle in rad 
     * @param pitch Pitch angle in rad 
     * @param yaw Yaw angle in rad 
     * @param covariance Pose covariance matrix upper right triangular (first six entries are the first ROW, next five 
     * entries are the second ROW, etc.) 
     */
    default void sendViconPositionEstimate(BigInteger usec, float x, float y, float z, float roll,
            float pitch, float yaw, List<Float> covariance) {
        outgoing().emit(ViconPositionEstimate.builder()
                .usec(usec)
                .x(x)
                .y(y)
                .z(z)
                .roll(roll)
                .pitch(pitch)
                .yaw(yaw)
                .covariance(covariance)
                .build());
    }

    /**
     * Set a parameter value. In order to deal with message loss (and retransmission of 
     * PARAM_EXT_SET), when setting a parameter value and the new value is the same as the current 
     * value, you will immediately get a PARAM_ACK_ACCEPTED response. If the current state is 
     * PARAM_ACK_IN_PROGRESS, you will accordingly receive a PARAM_ACK_IN_PROGRESS in response. 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param paramId Parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT 
     * null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 
     * 16+1 bytes storage if the ID is stored as string 
     * @param paramValue Parameter value 
     * @param paramType Parameter type: see the {@link io.dronefleet.mavlink.common.MavParamExtType MavParamExtType} enum for supported data types. 
     */
    default void sendParamExtSet(int targetSystem, int targetComponent, String paramId,
            String paramValue, MavParamExtType paramType) {
        outgoing().emit(ParamExtSet.builder()
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .paramId(paramId)
                .paramValue(paramValue)
                .paramType(paramType)
                .build());
    }

    /**
     * Emit an encrypted signature / key identifying this system. PLEASE NOTE: This protocol has been 
     * kept simple, so transmitting the key requires an encrypted channel for true safety. 
     * @param key key 
     */
    default void sendAuthKey(String key) {
        outgoing().emit(AuthKey.builder()
                .key(key)
                .build());
    }

    /**
     * Sent from autopilot to simulation. Hardware in the loop control outputs 
     * @param timeUsec Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
     * @param rollAilerons Control output -1 .. 1 
     * @param pitchElevator Control output -1 .. 1 
     * @param yawRudder Control output -1 .. 1 
     * @param throttle Throttle 0 .. 1 
     * @param aux1 Aux 1, -1 .. 1 
     * @param aux2 Aux 2, -1 .. 1 
     * @param aux3 Aux 3, -1 .. 1 
     * @param aux4 Aux 4, -1 .. 1 
     * @param mode System mode ({@link io.dronefleet.mavlink.common.MavMode MavMode}) 
     * @param navMode Navigation mode (MAV_NAV_MODE) 
     */
    default void sendHilControls(BigInteger timeUsec, float rollAilerons, float pitchElevator,
            float yawRudder, float throttle, float aux1, float aux2, float aux3, float aux4,
            MavMode mode, int navMode) {
        outgoing().emit(HilControls.builder()
                .timeUsec(timeUsec)
                .rollAilerons(rollAilerons)
                .pitchElevator(pitchElevator)
                .yawRudder(yawRudder)
                .throttle(throttle)
                .aux1(aux1)
                .aux2(aux2)
                .aux3(aux3)
                .aux4(aux4)
                .mode(mode)
                .navMode(navMode)
                .build());
    }

    /**
     * This message is sent to the MAV to write a partial list. If start index == end index, only one item 
     * will be transmitted / updated. If the start index is NOT 0 and above the current list size, this 
     * request should be REJECTED! 
     * @param startIndex Start index, 0 by default and smaller / equal to the largest index of the current onboard list. 
     * @param endIndex End index, equal or greater than start index. 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param missionType Mission type, see {@link io.dronefleet.mavlink.common.MavMissionType MavMissionType} 
     */
    default void sendMissionWritePartialList(int startIndex, int endIndex, int targetSystem,
            int targetComponent, MavMissionType missionType) {
        outgoing().emit(MissionWritePartialList.builder()
                .startIndex(startIndex)
                .endIndex(endIndex)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .missionType(missionType)
                .build());
    }

    /**
     * Provides state for additional features 
     * @param vtolState The VTOL state if applicable. Is set to MAV_VTOL_STATE_UNDEFINED if UAV is not in VTOL 
     * configuration. 
     * @param landedState The landed state. Is set to MAV_LANDED_STATE_UNDEFINED if landed state is unknown. 
     */
    default void sendExtendedSysState(MavVtolState vtolState, MavLandedState landedState) {
        outgoing().emit(ExtendedSysState.builder()
                .vtolState(vtolState)
                .landedState(landedState)
                .build());
    }

    /**
     * The RAW values of the RC channels received. The standard PPM modulation is as follows: 1000 
     * microseconds: 0%, 2000 microseconds: 100%. Individual receivers/transmitters might 
     * violate this specification. 
     * @param timeBootMs Timestamp (milliseconds since system boot) 
     * @param chan1Raw RC channel 1 value, in microseconds. A value of UINT16_MAX implies the channel is unused. 
     * @param chan2Raw RC channel 2 value, in microseconds. A value of UINT16_MAX implies the channel is unused. 
     * @param chan3Raw RC channel 3 value, in microseconds. A value of UINT16_MAX implies the channel is unused. 
     * @param chan4Raw RC channel 4 value, in microseconds. A value of UINT16_MAX implies the channel is unused. 
     * @param chan5Raw RC channel 5 value, in microseconds. A value of UINT16_MAX implies the channel is unused. 
     * @param chan6Raw RC channel 6 value, in microseconds. A value of UINT16_MAX implies the channel is unused. 
     * @param chan7Raw RC channel 7 value, in microseconds. A value of UINT16_MAX implies the channel is unused. 
     * @param chan8Raw RC channel 8 value, in microseconds. A value of UINT16_MAX implies the channel is unused. 
     * @param port Servo output port (set of 8 outputs = 1 port). Most MAVs will just use one, but this allows for more 
     * than 8 servos. 
     * @param rssi Receive signal strength indicator, 0: 0%, 100: 100%, 255: invalid/unknown. 
     */
    default void sendRcChannelsRaw(long timeBootMs, int chan1Raw, int chan2Raw, int chan3Raw,
            int chan4Raw, int chan5Raw, int chan6Raw, int chan7Raw, int chan8Raw, int port,
            int rssi) {
        outgoing().emit(RcChannelsRaw.builder()
                .timeBootMs(timeBootMs)
                .chan1Raw(chan1Raw)
                .chan2Raw(chan2Raw)
                .chan3Raw(chan3Raw)
                .chan4Raw(chan4Raw)
                .chan5Raw(chan5Raw)
                .chan6Raw(chan6Raw)
                .chan7Raw(chan7Raw)
                .chan8Raw(chan8Raw)
                .port(port)
                .rssi(rssi)
                .build());
    }

    /**
     * Terrain data sent from GCS. The lat/lon and grid_spacing must be the same as a lat/lon from a 
     * {@link io.dronefleet.mavlink.common.TerrainRequest TerrainRequest} 
     * @param lat Latitude of SW corner of first grid (degrees *10^7) 
     * @param lon Longitude of SW corner of first grid (in degrees *10^7) 
     * @param gridSpacing Grid spacing in meters 
     * @param data Terrain data in meters AMSL 
     * @param gridbit bit within the terrain request mask 
     */
    default void sendTerrainData(int lat, int lon, int gridSpacing, List<Integer> data,
            int gridbit) {
        outgoing().emit(TerrainData.builder()
                .lat(lat)
                .lon(lon)
                .gridSpacing(gridSpacing)
                .data(data)
                .gridbit(gridbit)
                .build());
    }

    /**
     * DEPRECATED PACKET! Suffers from missing airspeed fields and singularities due to Euler 
     * angles. Please use HIL_STATE_QUATERNION instead. Sent from simulation to autopilot. This 
     * packet is useful for high throughput applications such as hardware in the loop simulations. 
     * @param timeUsec Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
     * @param roll Roll angle (rad) 
     * @param pitch Pitch angle (rad) 
     * @param yaw Yaw angle (rad) 
     * @param rollspeed Body frame roll / phi angular speed (rad/s) 
     * @param pitchspeed Body frame pitch / theta angular speed (rad/s) 
     * @param yawspeed Body frame yaw / psi angular speed (rad/s) 
     * @param lat Latitude, expressed as degrees * 1E7 
     * @param lon Longitude, expressed as degrees * 1E7 
     * @param alt Altitude in meters, expressed as * 1000 (millimeters) 
     * @param vx Ground X Speed (Latitude), expressed as m/s * 100 
     * @param vy Ground Y Speed (Longitude), expressed as m/s * 100 
     * @param vz Ground Z Speed (Altitude), expressed as m/s * 100 
     * @param xacc X acceleration (mg) 
     * @param yacc Y acceleration (mg) 
     * @param zacc Z acceleration (mg) 
     */
    default void sendHilState(BigInteger timeUsec, float roll, float pitch, float yaw,
            float rollspeed, float pitchspeed, float yawspeed, int lat, int lon, int alt, int vx,
            int vy, int vz, int xacc, int yacc, int zacc) {
        outgoing().emit(HilState.builder()
                .timeUsec(timeUsec)
                .roll(roll)
                .pitch(pitch)
                .yaw(yaw)
                .rollspeed(rollspeed)
                .pitchspeed(pitchspeed)
                .yawspeed(yawspeed)
                .lat(lat)
                .lon(lon)
                .alt(alt)
                .vx(vx)
                .vy(vy)
                .vz(vz)
                .xacc(xacc)
                .yacc(yacc)
                .zacc(zacc)
                .build());
    }

    /**
     * File transfer message 
     * @param targetNetwork Network ID (0 for broadcast) 
     * @param targetSystem System ID (0 for broadcast) 
     * @param targetComponent Component ID (0 for broadcast) 
     * @param payload Variable length payload. The length is defined by the remaining message length when 
     * subtracting the header and other fields. The entire content of this block is opaque unless you 
     * understand any the encoding message_type. The particular encoding used can be extension 
     * specific and might not always be documented as part of the mavlink specification. 
     */
    default void sendFileTransferProtocol(int targetNetwork, int targetSystem, int targetComponent,
            byte[] payload) {
        outgoing().emit(FileTransferProtocol.builder()
                .targetNetwork(targetNetwork)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .payload(payload)
                .build());
    }

    /**
     * null
     * @param seqnr sequence number (starting with 0 on every transmission) 
     * @param data image data bytes 
     */
    default void sendEncapsulatedData(int seqnr, byte[] data) {
        outgoing().emit(EncapsulatedData.builder()
                .seqnr(seqnr)
                .data(data)
                .build());
    }

    /**
     * This message is emitted as response to {@link io.dronefleet.mavlink.common.MissionRequestList MissionRequestList} by the MAV and to initiate a write 
     * transaction. The GCS can then request the individual mission item based on the knowledge of the 
     * total number of waypoints. 
     * @param count Number of mission items in the sequence 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param missionType Mission type, see {@link io.dronefleet.mavlink.common.MavMissionType MavMissionType} 
     */
    default void sendMissionCount(int count, int targetSystem, int targetComponent,
            MavMissionType missionType) {
        outgoing().emit(MissionCount.builder()
                .count(count)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .missionType(missionType)
                .build());
    }

    /**
     * Response from a {@link io.dronefleet.mavlink.common.ParamExtSet ParamExtSet} message. 
     * @param paramId Parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT 
     * null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 
     * 16+1 bytes storage if the ID is stored as string 
     * @param paramValue Parameter value (new value if PARAM_ACK_ACCEPTED, current value otherwise) 
     * @param paramType Parameter type: see the {@link io.dronefleet.mavlink.common.MavParamExtType MavParamExtType} enum for supported data types. 
     * @param paramResult Result code: see the {@link io.dronefleet.mavlink.common.ParamAck ParamAck} enum for possible codes. 
     */
    default void sendParamExtAck(String paramId, String paramValue, MavParamExtType paramType,
            ParamAck paramResult) {
        outgoing().emit(ParamExtAck.builder()
                .paramId(paramId)
                .paramValue(paramValue)
                .paramType(paramType)
                .paramResult(paramResult)
                .build());
    }

    /**
     * THIS INTERFACE IS DEPRECATED. USE COMMAND_LONG with MAV_CMD_DO_SET_MODE INSTEAD. Set the 
     * system mode, as defined by enum {@link io.dronefleet.mavlink.common.MavMode MavMode}. There is no target component id as the mode is by 
     * definition for the overall aircraft, not only for one component. 
     * @param customMode The new autopilot-specific mode. This field can be ignored by an autopilot. 
     * @param targetSystem The system setting the mode 
     * @param baseMode The new base mode 
     */
    default void sendSetMode(long customMode, int targetSystem, MavMode baseMode) {
        outgoing().emit(SetMode.builder()
                .customMode(customMode)
                .targetSystem(targetSystem)
                .baseMode(baseMode)
                .build());
    }

    /**
     * Vibration levels and accelerometer clipping 
     * @param timeUsec Timestamp (micros since boot or Unix epoch) 
     * @param vibrationX Vibration levels on X-axis 
     * @param vibrationY Vibration levels on Y-axis 
     * @param vibrationZ Vibration levels on Z-axis 
     * @param clipping0 first accelerometer clipping count 
     * @param clipping1 second accelerometer clipping count 
     * @param clipping2 third accelerometer clipping count 
     */
    default void sendVibration(BigInteger timeUsec, float vibrationX, float vibrationY,
            float vibrationZ, long clipping0, long clipping1, long clipping2) {
        outgoing().emit(Vibration.builder()
                .timeUsec(timeUsec)
                .vibrationX(vibrationX)
                .vibrationY(vibrationY)
                .vibrationZ(vibrationZ)
                .clipping0(clipping0)
                .clipping1(clipping1)
                .clipping2(clipping2)
                .build());
    }

    /**
     * WIP: Information about a storage medium. 
     * @param timeBootMs Timestamp (milliseconds since system boot) 
     * @param totalCapacity Total capacity in MiB 
     * @param usedCapacity Used capacity in MiB 
     * @param availableCapacity Available capacity in MiB 
     * @param readSpeed Read speed in MiB/s 
     * @param writeSpeed Write speed in MiB/s 
     * @param storageId Storage ID (1 for first, 2 for second, etc.) 
     * @param storageCount Number of storage devices 
     * @param status Status of storage (0 not available, 1 unformatted, 2 formatted) 
     */
    default void sendStorageInformation(long timeBootMs, float totalCapacity, float usedCapacity,
            float availableCapacity, float readSpeed, float writeSpeed, int storageId,
            int storageCount, int status) {
        outgoing().emit(StorageInformation.builder()
                .timeBootMs(timeBootMs)
                .totalCapacity(totalCapacity)
                .usedCapacity(usedCapacity)
                .availableCapacity(availableCapacity)
                .readSpeed(readSpeed)
                .writeSpeed(writeSpeed)
                .storageId(storageId)
                .storageCount(storageCount)
                .status(status)
                .build());
    }

    /**
     * The system time is the time of the master clock, typically the computer clock of the main onboard 
     * computer. 
     * @param timeUnixUsec Timestamp of the master clock in microseconds since UNIX epoch. 
     * @param timeBootMs Timestamp of the component clock since boot time in milliseconds. 
     */
    default void sendSystemTime(BigInteger timeUnixUsec, long timeBootMs) {
        outgoing().emit(SystemTime.builder()
                .timeUnixUsec(timeUnixUsec)
                .timeBootMs(timeBootMs)
                .build());
    }

    /**
     * Configure AP SSID and Password. 
     * @param ssid Name of Wi-Fi network (SSID). Leave it blank to leave it unchanged. 
     * @param password Password. Leave it blank for an open AP. 
     */
    default void sendWifiConfigAp(String ssid, String password) {
        outgoing().emit(WifiConfigAp.builder()
                .ssid(ssid)
                .password(password)
                .build());
    }

    /**
     * Barometer readings for 2nd barometer 
     * @param timeBootMs Timestamp (milliseconds since system boot) 
     * @param pressAbs Absolute pressure (hectopascal) 
     * @param pressDiff Differential pressure 1 (hectopascal) 
     * @param temperature Temperature measurement (0.01 degrees celsius) 
     */
    default void sendScaledPressure2(long timeBootMs, float pressAbs, float pressDiff,
            int temperature) {
        outgoing().emit(ScaledPressure2.builder()
                .timeBootMs(timeBootMs)
                .pressAbs(pressAbs)
                .pressDiff(pressDiff)
                .temperature(temperature)
                .build());
    }

    /**
     * Set a safety zone (volume), which is defined by two corners of a cube. This message can be used to 
     * tell the MAV which setpoints/waypoints to accept and which to reject. Safety areas are often 
     * enforced by national or competition regulations. 
     * @param p1x x position 1 / Latitude 1 
     * @param p1y y position 1 / Longitude 1 
     * @param p1z z position 1 / Altitude 1 
     * @param p2x x position 2 / Latitude 2 
     * @param p2y y position 2 / Longitude 2 
     * @param p2z z position 2 / Altitude 2 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param frame Coordinate frame, as defined by {@link io.dronefleet.mavlink.common.MavFrame MavFrame} enum. Can be either global, GPS, right-handed with Z 
     * axis up or local, right handed, Z axis down. 
     */
    default void sendSafetySetAllowedArea(float p1x, float p1y, float p1z, float p2x, float p2y,
            float p2z, int targetSystem, int targetComponent, MavFrame frame) {
        outgoing().emit(SafetySetAllowedArea.builder()
                .p1x(p1x)
                .p1y(p1y)
                .p1z(p1z)
                .p2x(p2x)
                .p2y(p2y)
                .p2z(p2z)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .frame(frame)
                .build());
    }

    /**
     * null
     * @param usec Timestamp (microseconds, synced to UNIX time or since system boot) 
     * @param x Global X position 
     * @param y Global Y position 
     * @param z Global Z position 
     * @param roll Roll angle in rad 
     * @param pitch Pitch angle in rad 
     * @param yaw Yaw angle in rad 
     * @param covariance Pose covariance matrix upper right triangular (first six entries are the first ROW, next five 
     * entries are the second ROW, etc.) 
     */
    default void sendGlobalVisionPositionEstimate(BigInteger usec, float x, float y, float z,
            float roll, float pitch, float yaw, List<Float> covariance) {
        outgoing().emit(GlobalVisionPositionEstimate.builder()
                .usec(usec)
                .x(x)
                .y(y)
                .z(z)
                .roll(roll)
                .pitch(pitch)
                .yaw(yaw)
                .covariance(covariance)
                .build());
    }

    /**
     * Barometer readings for 3rd barometer 
     * @param timeBootMs Timestamp (milliseconds since system boot) 
     * @param pressAbs Absolute pressure (hectopascal) 
     * @param pressDiff Differential pressure 1 (hectopascal) 
     * @param temperature Temperature measurement (0.01 degrees celsius) 
     */
    default void sendScaledPressure3(long timeBootMs, float pressAbs, float pressDiff,
            int temperature) {
        outgoing().emit(ScaledPressure3.builder()
                .timeBootMs(timeBootMs)
                .pressAbs(pressAbs)
                .pressDiff(pressDiff)
                .temperature(temperature)
                .build());
    }

    /**
     * WIP: Version and capability of protocol version. This message is the response to 
     * REQUEST_PROTOCOL_VERSION and is used as part of the handshaking to establish which MAVLink 
     * version should be used on the network. Every node should respond to REQUEST_PROTOCOL_VERSION 
     * to enable the handshaking. Library implementers should consider adding this into the default 
     * decoding state machine to allow the protocol core to respond directly. 
     * @param version Currently active MAVLink version number * 100: v1.0 is 100, v2.0 is 200, etc. 
     * @param minVersion Minimum MAVLink version supported 
     * @param maxVersion Maximum MAVLink version supported (set to the same value as version by default) 
     * @param specVersionHash The first 8 bytes (not characters printed in hex!) of the git hash. 
     * @param libraryVersionHash The first 8 bytes (not characters printed in hex!) of the git hash. 
     */
    default void sendProtocolVersion(int version, int minVersion, int maxVersion,
            byte[] specVersionHash, byte[] libraryVersionHash) {
        outgoing().emit(ProtocolVersion.builder()
                .version(version)
                .minVersion(minVersion)
                .maxVersion(maxVersion)
                .specVersionHash(specVersionHash)
                .libraryVersionHash(libraryVersionHash)
                .build());
    }

    /**
     * A ping message either requesting or responding to a ping. This allows to measure the system 
     * latencies, including serial port, radio modem and UDP connections. 
     * @param timeUsec Unix timestamp in microseconds or since system boot if smaller than MAVLink epoch (1.1.2009) 
     * @param seq PING sequence 
     * @param targetSystem 0: request ping from all receiving systems, if greater than 0: message is a ping response and 
     * number is the system id of the requesting system 
     * @param targetComponent 0: request ping from all receiving components, if greater than 0: message is a ping response and 
     * number is the system id of the requesting system 
     */
    default void sendPing(BigInteger timeUsec, long seq, int targetSystem, int targetComponent) {
        outgoing().emit(Ping.builder()
                .timeUsec(timeUsec)
                .seq(seq)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .build());
    }

    /**
     * This message can be requested by sending the MAV_CMD_GET_HOME_POSITION command. The 
     * position the system will return to and land on. The position is set automatically by the system 
     * during the takeoff in case it was not explicitely set by the operator before or after. The 
     * position the system will return to and land on. The global and local positions encode the 
     * position in the respective coordinate frames, while the q parameter encodes the orientation 
     * of the surface. Under normal conditions it describes the heading and terrain slope, which can 
     * be used by the aircraft to adjust the approach. The approach 3D vector describes the point to 
     * which the system should fly in normal flight mode and then perform a landing sequence along the 
     * vector. 
     * @param latitude Latitude (WGS84), in degrees * 1E7 
     * @param longitude Longitude (WGS84, in degrees * 1E7 
     * @param altitude Altitude (AMSL), in meters * 1000 (positive for up) 
     * @param x Local X position of this position in the local coordinate frame 
     * @param y Local Y position of this position in the local coordinate frame 
     * @param z Local Z position of this position in the local coordinate frame 
     * @param q World to surface normal and heading transformation of the takeoff position. Used to indicate 
     * the heading and slope of the ground 
     * @param approachX Local X position of the end of the approach vector. Multicopters should set this position based 
     * on their takeoff path. Grass-landing fixed wing aircraft should set it the same way as 
     * multicopters. Runway-landing fixed wing aircraft should set it to the opposite direction of 
     * the takeoff, assuming the takeoff happened from the threshold / touchdown zone. 
     * @param approachY Local Y position of the end of the approach vector. Multicopters should set this position based 
     * on their takeoff path. Grass-landing fixed wing aircraft should set it the same way as 
     * multicopters. Runway-landing fixed wing aircraft should set it to the opposite direction of 
     * the takeoff, assuming the takeoff happened from the threshold / touchdown zone. 
     * @param approachZ Local Z position of the end of the approach vector. Multicopters should set this position based 
     * on their takeoff path. Grass-landing fixed wing aircraft should set it the same way as 
     * multicopters. Runway-landing fixed wing aircraft should set it to the opposite direction of 
     * the takeoff, assuming the takeoff happened from the threshold / touchdown zone. 
     * @param timeUsec Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
     */
    default void sendHomePosition(int latitude, int longitude, int altitude, float x, float y,
            float z, List<Float> q, float approachX, float approachY, float approachZ,
            BigInteger timeUsec) {
        outgoing().emit(HomePosition.builder()
                .latitude(latitude)
                .longitude(longitude)
                .altitude(altitude)
                .x(x)
                .y(y)
                .z(z)
                .q(q)
                .approachX(approachX)
                .approachY(approachY)
                .approachZ(approachZ)
                .timeUsec(timeUsec)
                .build());
    }

    /**
     * Message encoding a mission item. This message is emitted to announce the presence of a mission 
     * item and to set a mission item on the system. The mission item can be either in x, y, z meters (type: 
     * LOCAL) or x:lat, y:lon, z:altitude. Local frame is Z-down, right handed (NED), global frame is 
     * Z-up, right handed (ENU). See also https://mavlink.io/en/protocol/mission.html. 
     * @param param1 PARAM1, see {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum 
     * @param param2 PARAM2, see {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum 
     * @param param3 PARAM3, see {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum 
     * @param param4 PARAM4, see {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum 
     * @param x PARAM5 / local: x position, global: latitude 
     * @param y PARAM6 / y position: global: longitude 
     * @param z PARAM7 / z position: global: altitude (relative or absolute, depending on frame. 
     * @param seq Sequence 
     * @param command The scheduled action for the waypoint, as defined by {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param frame The coordinate system of the waypoint, as defined by {@link io.dronefleet.mavlink.common.MavFrame MavFrame} enum 
     * @param current false:0, true:1 
     * @param autocontinue autocontinue to next wp 
     * @param missionType Mission type, see {@link io.dronefleet.mavlink.common.MavMissionType MavMissionType} 
     */
    default void sendMissionItem(float param1, float param2, float param3, float param4, float x,
            float y, float z, int seq, MavCmd command, int targetSystem, int targetComponent,
            MavFrame frame, int current, int autocontinue, MavMissionType missionType) {
        outgoing().emit(MissionItem.builder()
                .param1(param1)
                .param2(param2)
                .param3(param3)
                .param4(param4)
                .x(x)
                .y(y)
                .z(z)
                .seq(seq)
                .command(command)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .frame(frame)
                .current(current)
                .autocontinue(autocontinue)
                .missionType(missionType)
                .build());
    }

    /**
     * The RAW IMU readings for the usual 9DOF sensor setup. This message should always contain the 
     * true raw values without any scaling to allow data capture and system debugging. 
     * @param timeUsec Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
     * @param xacc X acceleration (raw) 
     * @param yacc Y acceleration (raw) 
     * @param zacc Z acceleration (raw) 
     * @param xgyro Angular speed around X axis (raw) 
     * @param ygyro Angular speed around Y axis (raw) 
     * @param zgyro Angular speed around Z axis (raw) 
     * @param xmag X Magnetic field (raw) 
     * @param ymag Y Magnetic field (raw) 
     * @param zmag Z Magnetic field (raw) 
     */
    default void sendRawImu(BigInteger timeUsec, int xacc, int yacc, int zacc, int xgyro, int ygyro,
            int zgyro, int xmag, int ymag, int zmag) {
        outgoing().emit(RawImu.builder()
                .timeUsec(timeUsec)
                .xacc(xacc)
                .yacc(yacc)
                .zacc(zacc)
                .xgyro(xgyro)
                .ygyro(ygyro)
                .zgyro(zgyro)
                .xmag(xmag)
                .ymag(ymag)
                .zmag(zmag)
                .build());
    }

    /**
     * The IMU readings in SI units in NED body frame 
     * @param timeUsec Timestamp (microseconds, synced to UNIX time or since system boot) 
     * @param xacc X acceleration (m/s^2) 
     * @param yacc Y acceleration (m/s^2) 
     * @param zacc Z acceleration (m/s^2) 
     * @param xgyro Angular speed around X axis (rad / sec) 
     * @param ygyro Angular speed around Y axis (rad / sec) 
     * @param zgyro Angular speed around Z axis (rad / sec) 
     * @param xmag X Magnetic field (Gauss) 
     * @param ymag Y Magnetic field (Gauss) 
     * @param zmag Z Magnetic field (Gauss) 
     * @param absPressure Absolute pressure in millibar 
     * @param diffPressure Differential pressure in millibar 
     * @param pressureAlt Altitude calculated from pressure 
     * @param temperature Temperature in degrees celsius 
     * @param fieldsUpdated Bitmask for fields that have updated since last message, bit 0 = xacc, bit 12: temperature 
     */
    default void sendHighresImu(BigInteger timeUsec, float xacc, float yacc, float zacc,
            float xgyro, float ygyro, float zgyro, float xmag, float ymag, float zmag,
            float absPressure, float diffPressure, float pressureAlt, float temperature,
            int fieldsUpdated) {
        outgoing().emit(HighresImu.builder()
                .timeUsec(timeUsec)
                .xacc(xacc)
                .yacc(yacc)
                .zacc(zacc)
                .xgyro(xgyro)
                .ygyro(ygyro)
                .zgyro(zgyro)
                .xmag(xmag)
                .ymag(ymag)
                .zmag(zmag)
                .absPressure(absPressure)
                .diffPressure(diffPressure)
                .pressureAlt(pressureAlt)
                .temperature(temperature)
                .fieldsUpdated(fieldsUpdated)
                .build());
    }

    /**
     * Optical flow from a flow sensor (e.g. optical mouse sensor) 
     * @param timeUsec Timestamp (UNIX) 
     * @param flowCompMX Flow in meters in x-sensor direction, angular-speed compensated 
     * @param flowCompMY Flow in meters in y-sensor direction, angular-speed compensated 
     * @param groundDistance Ground distance in meters. Positive value: distance known. Negative value: Unknown distance 
     * @param flowX Flow in pixels * 10 in x-sensor direction (dezi-pixels) 
     * @param flowY Flow in pixels * 10 in y-sensor direction (dezi-pixels) 
     * @param sensorId Sensor ID 
     * @param quality Optical flow quality / confidence. 0: bad, 255: maximum quality 
     * @param flowRateX Flow rate in radians/second about X axis 
     * @param flowRateY Flow rate in radians/second about Y axis 
     */
    default void sendOpticalFlow(BigInteger timeUsec, float flowCompMX, float flowCompMY,
            float groundDistance, int flowX, int flowY, int sensorId, int quality, float flowRateX,
            float flowRateY) {
        outgoing().emit(OpticalFlow.builder()
                .timeUsec(timeUsec)
                .flowCompMX(flowCompMX)
                .flowCompMY(flowCompMY)
                .groundDistance(groundDistance)
                .flowX(flowX)
                .flowY(flowY)
                .sensorId(sensorId)
                .quality(quality)
                .flowRateX(flowRateX)
                .flowRateY(flowRateY)
                .build());
    }

    /**
     * The location of a landing area captured from a downward facing camera 
     * @param timeUsec Timestamp (micros since boot or Unix epoch) 
     * @param angleX X-axis angular offset (in radians) of the target from the center of the image 
     * @param angleY Y-axis angular offset (in radians) of the target from the center of the image 
     * @param distance Distance to the target from the vehicle in meters 
     * @param sizeX Size in radians of target along x-axis 
     * @param sizeY Size in radians of target along y-axis 
     * @param targetNum The ID of the target if multiple targets are present 
     * @param frame {@link io.dronefleet.mavlink.common.MavFrame MavFrame} enum specifying the whether the following feilds are earth-frame, body-frame, 
     * etc. 
     * @param x X Position of the landing target on {@link io.dronefleet.mavlink.common.MavFrame MavFrame} 
     * @param y Y Position of the landing target on {@link io.dronefleet.mavlink.common.MavFrame MavFrame} 
     * @param z Z Position of the landing target on {@link io.dronefleet.mavlink.common.MavFrame MavFrame} 
     * @param q Quaternion of landing target orientation (w, x, y, z order, zero-rotation is 1, 0, 0, 0) 
     * @param type {@link io.dronefleet.mavlink.common.LandingTargetType LandingTargetType} enum specifying the type of landing target 
     * @param positionValid Boolean indicating known position (1) or default unkown position (0), for validation of 
     * positioning of the landing target 
     */
    default void sendLandingTarget(BigInteger timeUsec, float angleX, float angleY, float distance,
            float sizeX, float sizeY, int targetNum, MavFrame frame, float x, float y, float z,
            List<Float> q, LandingTargetType type, int positionValid) {
        outgoing().emit(LandingTarget.builder()
                .timeUsec(timeUsec)
                .angleX(angleX)
                .angleY(angleY)
                .distance(distance)
                .sizeX(sizeX)
                .sizeY(sizeY)
                .targetNum(targetNum)
                .frame(frame)
                .x(x)
                .y(y)
                .z(z)
                .q(q)
                .type(type)
                .positionValid(positionValid)
                .build());
    }

    /**
     * General information describing a particular UAVCAN node. Please refer to the definition of 
     * the UAVCAN service "uavcan.protocol.GetNodeInfo" for the background information. This 
     * message should be emitted by the system whenever a new node appears online, or an existing node 
     * reboots. Additionally, it can be emitted upon request from the other end of the MAVLink channel 
     * (see MAV_CMD_UAVCAN_GET_NODE_INFO). It is also not prohibited to emit this message 
     * unconditionally at a low frequency. The UAVCAN specification is available at 
     * http://uavcan.org. 
     * @param timeUsec Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
     * @param uptimeSec The number of seconds since the start-up of the node. 
     * @param swVcsCommit Version control system (VCS) revision identifier (e.g. git short commit hash). Zero if 
     * unknown. 
     * @param name Node name string. For example, "sapog.px4.io". 
     * @param hwVersionMajor Hardware major version number. 
     * @param hwVersionMinor Hardware minor version number. 
     * @param hwUniqueId Hardware unique 128-bit ID. 
     * @param swVersionMajor Software major version number. 
     * @param swVersionMinor Software minor version number. 
     */
    default void sendUavcanNodeInfo(BigInteger timeUsec, long uptimeSec, long swVcsCommit,
            String name, int hwVersionMajor, int hwVersionMinor, byte[] hwUniqueId,
            int swVersionMajor, int swVersionMinor) {
        outgoing().emit(UavcanNodeInfo.builder()
                .timeUsec(timeUsec)
                .uptimeSec(uptimeSec)
                .swVcsCommit(swVcsCommit)
                .name(name)
                .hwVersionMajor(hwVersionMajor)
                .hwVersionMinor(hwVersionMinor)
                .hwUniqueId(hwUniqueId)
                .swVersionMajor(swVersionMajor)
                .swVersionMinor(swVersionMinor)
                .build());
    }

    /**
     * Send a command with up to seven parameters to the MAV 
     * @param param1 Parameter 1, as defined by {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum. 
     * @param param2 Parameter 2, as defined by {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum. 
     * @param param3 Parameter 3, as defined by {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum. 
     * @param param4 Parameter 4, as defined by {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum. 
     * @param param5 Parameter 5, as defined by {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum. 
     * @param param6 Parameter 6, as defined by {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum. 
     * @param param7 Parameter 7, as defined by {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum. 
     * @param command Command ID, as defined by {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum. 
     * @param targetSystem System which should execute the command 
     * @param targetComponent Component which should execute the command, 0 for all components 
     * @param confirmation 0: First transmission of this command. 1-255: Confirmation transmissions (e.g. for kill 
     * command) 
     */
    default void sendCommandLong(float param1, float param2, float param3, float param4,
            float param5, float param6, float param7, MavCmd command, int targetSystem,
            int targetComponent, int confirmation) {
        outgoing().emit(CommandLong.builder()
                .param1(param1)
                .param2(param2)
                .param3(param3)
                .param4(param4)
                .param5(param5)
                .param6(param6)
                .param7(param7)
                .command(command)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .confirmation(confirmation)
                .build());
    }

    /**
     * The attitude in the aeronautical frame (right-handed, Z-down, X-front, Y-right), expressed 
     * as quaternion. Quaternion order is w, x, y, z and a zero rotation would be expressed as (1 0 0 0). 
     * @param timeBootMs Timestamp (milliseconds since system boot) 
     * @param q1 Quaternion component 1, w (1 in null-rotation) 
     * @param q2 Quaternion component 2, x (0 in null-rotation) 
     * @param q3 Quaternion component 3, y (0 in null-rotation) 
     * @param q4 Quaternion component 4, z (0 in null-rotation) 
     * @param rollspeed Roll angular speed (rad/s) 
     * @param pitchspeed Pitch angular speed (rad/s) 
     * @param yawspeed Yaw angular speed (rad/s) 
     */
    default void sendAttitudeQuaternion(long timeBootMs, float q1, float q2, float q3, float q4,
            float rollspeed, float pitchspeed, float yawspeed) {
        outgoing().emit(AttitudeQuaternion.builder()
                .timeBootMs(timeBootMs)
                .q1(q1)
                .q2(q2)
                .q3(q3)
                .q4(q4)
                .rollspeed(rollspeed)
                .pitchspeed(pitchspeed)
                .yawspeed(yawspeed)
                .build());
    }

    /**
     * The RAW IMU readings for secondary 9DOF sensor setup. This message should contain the scaled 
     * values to the described units 
     * @param timeBootMs Timestamp (milliseconds since system boot) 
     * @param xacc X acceleration (mg) 
     * @param yacc Y acceleration (mg) 
     * @param zacc Z acceleration (mg) 
     * @param xgyro Angular speed around X axis (millirad /sec) 
     * @param ygyro Angular speed around Y axis (millirad /sec) 
     * @param zgyro Angular speed around Z axis (millirad /sec) 
     * @param xmag X Magnetic field (milli tesla) 
     * @param ymag Y Magnetic field (milli tesla) 
     * @param zmag Z Magnetic field (milli tesla) 
     */
    default void sendScaledImu2(long timeBootMs, int xacc, int yacc, int zacc, int xgyro, int ygyro,
            int zgyro, int xmag, int ymag, int zmag) {
        outgoing().emit(ScaledImu2.builder()
                .timeBootMs(timeBootMs)
                .xacc(xacc)
                .yacc(yacc)
                .zacc(zacc)
                .xgyro(xgyro)
                .ygyro(ygyro)
                .zgyro(zgyro)
                .xmag(xmag)
                .ymag(ymag)
                .zmag(zmag)
                .build());
    }

    /**
     * THIS INTERFACE IS DEPRECATED. USE MESSAGE_INTERVAL INSTEAD. 
     * @param messageRate The message rate 
     * @param streamId The ID of the requested data stream 
     * @param onOff 1 stream is enabled, 0 stream is stopped. 
     */
    default void sendDataStream(int messageRate, int streamId, int onOff) {
        outgoing().emit(DataStream.builder()
                .messageRate(messageRate)
                .streamId(streamId)
                .onOff(onOff)
                .build());
    }

    /**
     * The RAW IMU readings for 3rd 9DOF sensor setup. This message should contain the scaled values to 
     * the described units 
     * @param timeBootMs Timestamp (milliseconds since system boot) 
     * @param xacc X acceleration (mg) 
     * @param yacc Y acceleration (mg) 
     * @param zacc Z acceleration (mg) 
     * @param xgyro Angular speed around X axis (millirad /sec) 
     * @param ygyro Angular speed around Y axis (millirad /sec) 
     * @param zgyro Angular speed around Z axis (millirad /sec) 
     * @param xmag X Magnetic field (milli tesla) 
     * @param ymag Y Magnetic field (milli tesla) 
     * @param zmag Z Magnetic field (milli tesla) 
     */
    default void sendScaledImu3(long timeBootMs, int xacc, int yacc, int zacc, int xgyro, int ygyro,
            int zgyro, int xmag, int ymag, int zmag) {
        outgoing().emit(ScaledImu3.builder()
                .timeBootMs(timeBootMs)
                .xacc(xacc)
                .yacc(yacc)
                .zacc(zacc)
                .xgyro(xgyro)
                .ygyro(ygyro)
                .zgyro(zgyro)
                .xmag(xmag)
                .ymag(ymag)
                .zmag(zmag)
                .build());
    }

    /**
     * Accept / deny control of this MAV 
     * @param gcsSystemId ID of the GCS this message 
     * @param controlRequest 0: request control of this MAV, 1: Release control of this MAV 
     * @param ack 0: ACK, 1: NACK: Wrong passkey, 2: NACK: Unsupported passkey encryption method, 3: NACK: 
     * Already under control 
     */
    default void sendChangeOperatorControlAck(int gcsSystemId, int controlRequest, int ack) {
        outgoing().emit(ChangeOperatorControlAck.builder()
                .gcsSystemId(gcsSystemId)
                .controlRequest(controlRequest)
                .ack(ack)
                .build());
    }

    /**
     * Request for terrain data and terrain status 
     * @param mask Bitmask of requested 4x4 grids (row major 8x7 array of grids, 56 bits) 
     * @param lat Latitude of SW corner of first grid (degrees *10^7) 
     * @param lon Longitude of SW corner of first grid (in degrees *10^7) 
     * @param gridSpacing Grid spacing in meters 
     */
    default void sendTerrainRequest(BigInteger mask, int lat, int lon, int gridSpacing) {
        outgoing().emit(TerrainRequest.builder()
                .mask(mask)
                .lat(lat)
                .lon(lon)
                .gridSpacing(gridSpacing)
                .build());
    }

    /**
     * Request that the vehicle report terrain height at the given location. Used by GCS to check if 
     * vehicle has all terrain data needed for a mission. 
     * @param lat Latitude (degrees *10^7) 
     * @param lon Longitude (degrees *10^7) 
     */
    default void sendTerrainCheck(int lat, int lon) {
        outgoing().emit(TerrainCheck.builder()
                .lat(lat)
                .lon(lon)
                .build());
    }

    /**
     * The location and information of an ADSB vehicle 
     * @param icaoAddress ICAO address 
     * @param lat Latitude, expressed as degrees * 1E7 
     * @param lon Longitude, expressed as degrees * 1E7 
     * @param altitude Altitude(ASL) in millimeters 
     * @param heading Course over ground in centidegrees 
     * @param horVelocity The horizontal velocity in centimeters/second 
     * @param verVelocity The vertical velocity in centimeters/second, positive is up 
     * @param flags Flags to indicate various statuses including valid data fields 
     * @param squawk Squawk code 
     * @param altitudeType Type from {@link io.dronefleet.mavlink.common.AdsbAltitudeType AdsbAltitudeType} enum 
     * @param callsign The callsign, 8+null 
     * @param emitterType Type from {@link io.dronefleet.mavlink.common.AdsbEmitterType AdsbEmitterType} enum 
     * @param tslc Time since last communication in seconds 
     */
    default void sendAdsbVehicle(long icaoAddress, int lat, int lon, int altitude, int heading,
            int horVelocity, int verVelocity, EnumFlagSet<AdsbFlags> flags, int squawk,
            AdsbAltitudeType altitudeType, String callsign, AdsbEmitterType emitterType, int tslc) {
        outgoing().emit(AdsbVehicle.builder()
                .icaoAddress(icaoAddress)
                .lat(lat)
                .lon(lon)
                .altitude(altitude)
                .heading(heading)
                .horVelocity(horVelocity)
                .verVelocity(verVelocity)
                .flags(flags)
                .squawk(squawk)
                .altitudeType(altitudeType)
                .callsign(callsign)
                .emitterType(emitterType)
                .tslc(tslc)
                .build());
    }

    /**
     * Send raw controller memory. The use of this message is discouraged for normal packets, but a 
     * quite efficient way for testing new messages and getting experimental debug output. 
     * @param address Starting address of the debug variables 
     * @param ver Version code of the type variable. 0=unknown, type ignored and assumed int16_t. 1=as below 
     * @param type Type code of the memory variables. for ver = 1: 0=16 x int16_t, 1=16 x uint16_t, 2=16 x Q15, 3=16 x 
     * 1Q14 
     * @param value Memory contents at specified address 
     */
    default void sendMemoryVect(int address, int ver, int type, List<Integer> value) {
        outgoing().emit(MemoryVect.builder()
                .address(address)
                .ver(ver)
                .type(type)
                .value(value)
                .build());
    }

    /**
     * Sent from simulation to autopilot. The RAW values of the RC channels received. The standard PPM 
     * modulation is as follows: 1000 microseconds: 0%, 2000 microseconds: 100%. Individual 
     * receivers/transmitters might violate this specification. 
     * @param timeUsec Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
     * @param chan1Raw RC channel 1 value, in microseconds 
     * @param chan2Raw RC channel 2 value, in microseconds 
     * @param chan3Raw RC channel 3 value, in microseconds 
     * @param chan4Raw RC channel 4 value, in microseconds 
     * @param chan5Raw RC channel 5 value, in microseconds 
     * @param chan6Raw RC channel 6 value, in microseconds 
     * @param chan7Raw RC channel 7 value, in microseconds 
     * @param chan8Raw RC channel 8 value, in microseconds 
     * @param chan9Raw RC channel 9 value, in microseconds 
     * @param chan10Raw RC channel 10 value, in microseconds 
     * @param chan11Raw RC channel 11 value, in microseconds 
     * @param chan12Raw RC channel 12 value, in microseconds 
     * @param rssi Receive signal strength indicator, 0: 0%, 255: 100% 
     */
    default void sendHilRcInputsRaw(BigInteger timeUsec, int chan1Raw, int chan2Raw, int chan3Raw,
            int chan4Raw, int chan5Raw, int chan6Raw, int chan7Raw, int chan8Raw, int chan9Raw,
            int chan10Raw, int chan11Raw, int chan12Raw, int rssi) {
        outgoing().emit(HilRcInputsRaw.builder()
                .timeUsec(timeUsec)
                .chan1Raw(chan1Raw)
                .chan2Raw(chan2Raw)
                .chan3Raw(chan3Raw)
                .chan4Raw(chan4Raw)
                .chan5Raw(chan5Raw)
                .chan6Raw(chan6Raw)
                .chan7Raw(chan7Raw)
                .chan8Raw(chan8Raw)
                .chan9Raw(chan9Raw)
                .chan10Raw(chan10Raw)
                .chan11Raw(chan11Raw)
                .chan12Raw(chan12Raw)
                .rssi(rssi)
                .build());
    }

    /**
     * RTCM message for injecting into the onboard GPS (used for DGPS) 
     * @param flags LSB: 1 means message is fragmented, next 2 bits are the fragment ID, the remaining 5 bits are used 
     * for the sequence ID. Messages are only to be flushed to the GPS when the entire message has been 
     * reconstructed on the autopilot. The fragment ID specifies which order the fragments should be 
     * assembled into a buffer, while the sequence ID is used to detect a mismatch between different 
     * buffers. The buffer is considered fully reconstructed when either all 4 fragments are 
     * present, or all the fragments before the first fragment with a non full payload is received. 
     * This management is used to ensure that normal GPS operation doesn't corrupt RTCM data, and to 
     * recover from a unreliable transport delivery order. 
     * @param len data length 
     * @param data RTCM message (may be fragmented) 
     */
    default void sendGpsRtcmData(int flags, int len, byte[] data) {
        outgoing().emit(GpsRtcmData.builder()
                .flags(flags)
                .len(len)
                .data(data)
                .build());
    }

    /**
     * The RAW pressure readings for the typical setup of one absolute pressure and one differential 
     * pressure sensor. The sensor values should be the raw, UNSCALED ADC values. 
     * @param timeUsec Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
     * @param pressAbs Absolute pressure (raw) 
     * @param pressDiff1 Differential pressure 1 (raw, 0 if nonexistant) 
     * @param pressDiff2 Differential pressure 2 (raw, 0 if nonexistant) 
     * @param temperature Raw Temperature measurement (raw) 
     */
    default void sendRawPressure(BigInteger timeUsec, int pressAbs, int pressDiff1, int pressDiff2,
            int temperature) {
        outgoing().emit(RawPressure.builder()
                .timeUsec(timeUsec)
                .pressAbs(pressAbs)
                .pressDiff1(pressDiff1)
                .pressDiff2(pressDiff2)
                .temperature(temperature)
                .build());
    }

    /**
     * Settings of a camera, can be requested using MAV_CMD_REQUEST_CAMERA_SETTINGS. 
     * @param timeBootMs Timestamp (milliseconds since system boot) 
     * @param modeId Camera mode ({@link io.dronefleet.mavlink.common.CameraMode CameraMode}) 
     */
    default void sendCameraSettings(long timeBootMs, CameraMode modeId) {
        outgoing().emit(CameraSettings.builder()
                .timeBootMs(timeBootMs)
                .modeId(modeId)
                .build());
    }

    /**
     * null
     * @param timeUsec Timestamp (micros since boot or Unix epoch) 
     * @param windX Wind in X (NED) direction in m/s 
     * @param windY Wind in Y (NED) direction in m/s 
     * @param windZ Wind in Z (NED) direction in m/s 
     * @param varHoriz Variability of the wind in XY. RMS of a 1 Hz lowpassed wind estimate. 
     * @param varVert Variability of the wind in Z. RMS of a 1 Hz lowpassed wind estimate. 
     * @param windAlt AMSL altitude (m) this measurement was taken at 
     * @param horizAccuracy Horizontal speed 1-STD accuracy 
     * @param vertAccuracy Vertical speed 1-STD accuracy 
     */
    default void sendWindCov(BigInteger timeUsec, float windX, float windY, float windZ,
            float varHoriz, float varVert, float windAlt, float horizAccuracy, float vertAccuracy) {
        outgoing().emit(WindCov.builder()
                .timeUsec(timeUsec)
                .windX(windX)
                .windY(windY)
                .windZ(windZ)
                .varHoriz(varHoriz)
                .varVert(varVert)
                .windAlt(windAlt)
                .horizAccuracy(horizAccuracy)
                .vertAccuracy(vertAccuracy)
                .build());
    }

    /**
     * WIP: Message appropriate for high latency connections like Iridium (version 2) 
     * @param timestamp Timestamp (milliseconds since boot or Unix epoch) 
     * @param latitude Latitude, expressed as degrees * 1E7 
     * @param longitude Longitude, expressed as degrees * 1E7 
     * @param customMode A bitfield for use for autopilot-specific flags (2 byte version). 
     * @param altitude Altitude above mean sea level 
     * @param targetAltitude Altitude setpoint 
     * @param targetDistance Distance to target waypoint or position (meters / 10) 
     * @param wpNum Current waypoint number 
     * @param failureFlags Indicates failures as defined in {@link io.dronefleet.mavlink.common.HlFailureFlag HlFailureFlag} ENUM. 
     * @param type Type of the MAV (quadrotor, helicopter, etc., up to 15 types, defined in {@link io.dronefleet.mavlink.common.MavType MavType} ENUM) 
     * @param autopilot Autopilot type / class. defined in {@link io.dronefleet.mavlink.common.MavAutopilot MavAutopilot} ENUM 
     * @param heading Heading (degrees / 2) 
     * @param targetHeading Heading setpoint (degrees / 2) 
     * @param throttle Throttle (percentage) 
     * @param airspeed Airspeed (m/s * 5) 
     * @param airspeedSp Airspeed setpoint (m/s * 5) 
     * @param groundspeed Groundspeed (m/s * 5) 
     * @param windspeed Windspeed (m/s * 5) 
     * @param windHeading Wind heading (deg / 2) 
     * @param eph Maximum error horizontal position since last message (m * 10) 
     * @param epv Maximum error vertical position since last message (m * 10) 
     * @param temperatureAir Air temperature (degrees C) from airspeed sensor 
     * @param climbRate Maximum climb rate magnitude since last message (m/s * 10) 
     * @param battery Battery (percentage, -1 for DNU) 
     * @param custom0 Field for custom payload. 
     * @param custom1 Field for custom payload. 
     * @param custom2 Field for custom payload. 
     */
    default void sendHighLatency2(long timestamp, int latitude, int longitude, int customMode,
            int altitude, int targetAltitude, int targetDistance, int wpNum,
            EnumFlagSet<HlFailureFlag> failureFlags, MavType type, MavAutopilot autopilot,
            int heading, int targetHeading, int throttle, int airspeed, int airspeedSp,
            int groundspeed, int windspeed, int windHeading, int eph, int epv, int temperatureAir,
            int climbRate, int battery, int custom0, int custom1, int custom2) {
        outgoing().emit(HighLatency2.builder()
                .timestamp(timestamp)
                .latitude(latitude)
                .longitude(longitude)
                .customMode(customMode)
                .altitude(altitude)
                .targetAltitude(targetAltitude)
                .targetDistance(targetDistance)
                .wpNum(wpNum)
                .failureFlags(failureFlags)
                .type(type)
                .autopilot(autopilot)
                .heading(heading)
                .targetHeading(targetHeading)
                .throttle(throttle)
                .airspeed(airspeed)
                .airspeedSp(airspeedSp)
                .groundspeed(groundspeed)
                .windspeed(windspeed)
                .windHeading(windHeading)
                .eph(eph)
                .epv(epv)
                .temperatureAir(temperatureAir)
                .climbRate(climbRate)
                .battery(battery)
                .custom0(custom0)
                .custom1(custom1)
                .custom2(custom2)
                .build());
    }

    /**
     * The filtered local position (e.g. fused computer vision and accelerometers). Coordinate 
     * frame is right-handed, Z-axis down (aeronautical frame, NED / north-east-down convention) 
     * @param timeBootMs Timestamp (milliseconds since system boot) 
     * @param x X Position 
     * @param y Y Position 
     * @param z Z Position 
     * @param vx X Speed 
     * @param vy Y Speed 
     * @param vz Z Speed 
     */
    default void sendLocalPositionNed(long timeBootMs, float x, float y, float z, float vx,
            float vy, float vz) {
        outgoing().emit(LocalPositionNed.builder()
                .timeBootMs(timeBootMs)
                .x(x)
                .y(y)
                .z(z)
                .vx(vx)
                .vy(vy)
                .vz(vz)
                .build());
    }

    /**
     * The state of the fixed wing navigation and position controller. 
     * @param navRoll Current desired roll in degrees 
     * @param navPitch Current desired pitch in degrees 
     * @param altError Current altitude error in meters 
     * @param aspdError Current airspeed error in meters/second 
     * @param xtrackError Current crosstrack error on x-y plane in meters 
     * @param navBearing Current desired heading in degrees 
     * @param targetBearing Bearing to current waypoint/target in degrees 
     * @param wpDist Distance to active waypoint in meters 
     */
    default void sendNavControllerOutput(float navRoll, float navPitch, float altError,
            float aspdError, float xtrackError, int navBearing, int targetBearing, int wpDist) {
        outgoing().emit(NavControllerOutput.builder()
                .navRoll(navRoll)
                .navPitch(navPitch)
                .altError(altError)
                .aspdError(aspdError)
                .xtrackError(xtrackError)
                .navBearing(navBearing)
                .targetBearing(targetBearing)
                .wpDist(wpDist)
                .build());
    }

    /**
     * RTK GPS data. Gives information on the relative baseline calculation the GPS is reporting 
     * @param timeLastBaselineMs Time since boot of last baseline message received in ms. 
     * @param tow GPS Time of Week of last baseline 
     * @param baselineAMm Current baseline in ECEF x or NED north component in mm. 
     * @param baselineBMm Current baseline in ECEF y or NED east component in mm. 
     * @param baselineCMm Current baseline in ECEF z or NED down component in mm. 
     * @param accuracy Current estimate of baseline accuracy. 
     * @param iarNumHypotheses Current number of integer ambiguity hypotheses. 
     * @param wn GPS Week Number of last baseline 
     * @param rtkReceiverId Identification of connected RTK receiver. 
     * @param rtkHealth GPS-specific health report for RTK data. 
     * @param rtkRate Rate of baseline messages being received by GPS, in HZ 
     * @param nsats Current number of sats used for RTK calculation. 
     * @param baselineCoordsType Coordinate system of baseline 
     */
    default void sendGps2Rtk(long timeLastBaselineMs, long tow, int baselineAMm, int baselineBMm,
            int baselineCMm, long accuracy, int iarNumHypotheses, int wn, int rtkReceiverId,
            int rtkHealth, int rtkRate, int nsats, RtkBaselineCoordinateSystem baselineCoordsType) {
        outgoing().emit(Gps2Rtk.builder()
                .timeLastBaselineMs(timeLastBaselineMs)
                .tow(tow)
                .baselineAMm(baselineAMm)
                .baselineBMm(baselineBMm)
                .baselineCMm(baselineCMm)
                .accuracy(accuracy)
                .iarNumHypotheses(iarNumHypotheses)
                .wn(wn)
                .rtkReceiverId(rtkReceiverId)
                .rtkHealth(rtkHealth)
                .rtkRate(rtkRate)
                .nsats(nsats)
                .baselineCoordsType(baselineCoordsType)
                .build());
    }

    /**
     * As local waypoints exist, the global waypoint reference allows to transform between the local 
     * coordinate frame and the global (GPS) coordinate frame. This can be necessary when e.g. in- and 
     * outdoor settings are connected and the MAV should move from in- to outdoor. 
     * @param latitude Latitude (WGS84), in degrees * 1E7 
     * @param longitude Longitude (WGS84), in degrees * 1E7 
     * @param altitude Altitude (AMSL), in meters * 1000 (positive for up) 
     * @param targetSystem System ID 
     * @param timeUsec Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
     */
    default void sendSetGpsGlobalOrigin(int latitude, int longitude, int altitude, int targetSystem,
            BigInteger timeUsec) {
        outgoing().emit(SetGpsGlobalOrigin.builder()
                .latitude(latitude)
                .longitude(longitude)
                .altitude(altitude)
                .targetSystem(targetSystem)
                .timeUsec(timeUsec)
                .build());
    }

    /**
     * Information about a potential collision 
     * @param id Unique identifier, domain based on src field 
     * @param timeToMinimumDelta Estimated time until collision occurs (seconds) 
     * @param altitudeMinimumDelta Closest vertical distance in meters between vehicle and object 
     * @param horizontalMinimumDelta Closest horizontal distance in meteres between vehicle and object 
     * @param src Collision data source 
     * @param action Action that is being taken to avoid this collision 
     * @param threatLevel How concerned the aircraft is about this collision 
     */
    default void sendCollision(long id, float timeToMinimumDelta, float altitudeMinimumDelta,
            float horizontalMinimumDelta, MavCollisionSrc src, MavCollisionAction action,
            MavCollisionThreatLevel threatLevel) {
        outgoing().emit(Collision.builder()
                .id(id)
                .timeToMinimumDelta(timeToMinimumDelta)
                .altitudeMinimumDelta(altitudeMinimumDelta)
                .horizontalMinimumDelta(horizontalMinimumDelta)
                .src(src)
                .action(action)
                .threatLevel(threatLevel)
                .build());
    }

    /**
     * Reply to {@link io.dronefleet.mavlink.common.LogRequestData LogRequestData} 
     * @param ofs Offset into the log 
     * @param id Log id (from {@link io.dronefleet.mavlink.common.LogEntry LogEntry} reply) 
     * @param count Number of bytes (zero for end of log) 
     * @param data log data 
     */
    default void sendLogData(long ofs, int id, int count, byte[] data) {
        outgoing().emit(LogData.builder()
                .ofs(ofs)
                .id(id)
                .count(count)
                .data(data)
                .build());
    }

    /**
     * Estimator status message including flags, innovation test ratios and estimated accuracies. 
     * The flags message is an integer bitmask containing information on which EKF outputs are valid. 
     * See the {@link io.dronefleet.mavlink.common.EstimatorStatusFlags EstimatorStatusFlags} enum definition for further information. The innovaton test 
     * ratios show the magnitude of the sensor innovation divided by the innovation check threshold. 
     * Under normal operation the innovaton test ratios should be below 0.5 with occasional values up 
     * to 1.0. Values greater than 1.0 should be rare under normal operation and indicate that a 
     * measurement has been rejected by the filter. The user should be notified if an innovation test 
     * ratio greater than 1.0 is recorded. Notifications for values in the range between 0.5 and 1.0 
     * should be optional and controllable by the user. 
     * @param timeUsec Timestamp (micros since boot or Unix epoch) 
     * @param velRatio Velocity innovation test ratio 
     * @param posHorizRatio Horizontal position innovation test ratio 
     * @param posVertRatio Vertical position innovation test ratio 
     * @param magRatio Magnetometer innovation test ratio 
     * @param haglRatio Height above terrain innovation test ratio 
     * @param tasRatio True airspeed innovation test ratio 
     * @param posHorizAccuracy Horizontal position 1-STD accuracy relative to the EKF local origin (m) 
     * @param posVertAccuracy Vertical position 1-STD accuracy relative to the EKF local origin (m) 
     * @param flags Integer bitmask indicating which EKF outputs are valid. See definition for 
     * {@link io.dronefleet.mavlink.common.EstimatorStatusFlags EstimatorStatusFlags}. 
     */
    default void sendEstimatorStatus(BigInteger timeUsec, float velRatio, float posHorizRatio,
            float posVertRatio, float magRatio, float haglRatio, float tasRatio,
            float posHorizAccuracy, float posVertAccuracy,
            EnumFlagSet<EstimatorStatusFlags> flags) {
        outgoing().emit(EstimatorStatus.builder()
                .timeUsec(timeUsec)
                .velRatio(velRatio)
                .posHorizRatio(posHorizRatio)
                .posVertRatio(posVertRatio)
                .magRatio(magRatio)
                .haglRatio(haglRatio)
                .tasRatio(tasRatio)
                .posHorizAccuracy(posHorizAccuracy)
                .posVertAccuracy(posVertAccuracy)
                .flags(flags)
                .build());
    }

    /**
     * The attitude in the aeronautical frame (right-handed, Z-down, X-front, Y-right). 
     * @param timeBootMs Timestamp (milliseconds since system boot) 
     * @param roll Roll angle (rad, -pi..+pi) 
     * @param pitch Pitch angle (rad, -pi..+pi) 
     * @param yaw Yaw angle (rad, -pi..+pi) 
     * @param rollspeed Roll angular speed (rad/s) 
     * @param pitchspeed Pitch angular speed (rad/s) 
     * @param yawspeed Yaw angular speed (rad/s) 
     */
    default void sendAttitude(long timeBootMs, float roll, float pitch, float yaw, float rollspeed,
            float pitchspeed, float yawspeed) {
        outgoing().emit(Attitude.builder()
                .timeBootMs(timeBootMs)
                .roll(roll)
                .pitch(pitch)
                .yaw(yaw)
                .rollspeed(rollspeed)
                .pitchspeed(pitchspeed)
                .yawspeed(yawspeed)
                .build());
    }

    /**
     * Control a serial port. This can be used for raw access to an onboard serial peripheral such as a 
     * GPS or telemetry radio. It is designed to make it possible to update the devices firmware via 
     * MAVLink messages or change the devices settings. A message with zero bytes can be used to change 
     * just the baudrate. 
     * @param baudrate Baudrate of transfer. Zero means no change. 
     * @param timeout Timeout for reply data in milliseconds 
     * @param device See {@link io.dronefleet.mavlink.common.SerialControlDev SerialControlDev} enum 
     * @param flags See {@link io.dronefleet.mavlink.common.SerialControlFlag SerialControlFlag} enum 
     * @param count how many bytes in this transfer 
     * @param data serial data 
     */
    default void sendSerialControl(long baudrate, int timeout, SerialControlDev device,
            EnumFlagSet<SerialControlFlag> flags, int count, byte[] data) {
        outgoing().emit(SerialControl.builder()
                .baudrate(baudrate)
                .timeout(timeout)
                .device(device)
                .flags(flags)
                .count(count)
                .data(data)
                .build());
    }

    /**
     * A message containing logged data which requires a LOGGING_ACK to be sent back 
     * @param sequence sequence number (can wrap) 
     * @param targetSystem system ID of the target 
     * @param targetComponent component ID of the target 
     * @param length data length 
     * @param firstMessageOffset offset into data where first message starts. This can be used for recovery, when a previous 
     * message got lost (set to 255 if no start exists). 
     * @param data logged data 
     */
    default void sendLoggingDataAcked(int sequence, int targetSystem, int targetComponent,
            int length, int firstMessageOffset, byte[] data) {
        outgoing().emit(LoggingDataAcked.builder()
                .sequence(sequence)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .length(length)
                .firstMessageOffset(firstMessageOffset)
                .data(data)
                .build());
    }

    /**
     * Emit the value of a onboard parameter. The inclusion of param_count and param_index in the 
     * message allows the recipient to keep track of received parameters and allows him to re-request 
     * missing parameters after a loss or timeout. 
     * @param paramValue Onboard parameter value 
     * @param paramCount Total number of onboard parameters 
     * @param paramIndex Index of this onboard parameter 
     * @param paramId Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and 
     * WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to 
     * provide 16+1 bytes storage if the ID is stored as string 
     * @param paramType Onboard parameter type: see the {@link io.dronefleet.mavlink.common.MavParamType MavParamType} enum for supported data types. 
     */
    default void sendParamValue(float paramValue, int paramCount, int paramIndex, String paramId,
            MavParamType paramType) {
        outgoing().emit(ParamValue.builder()
                .paramValue(paramValue)
                .paramCount(paramCount)
                .paramIndex(paramIndex)
                .paramId(paramId)
                .paramType(paramType)
                .build());
    }

    /**
     * Status of simulation environment, if used 
     * @param q1 True attitude quaternion component 1, w (1 in null-rotation) 
     * @param q2 True attitude quaternion component 2, x (0 in null-rotation) 
     * @param q3 True attitude quaternion component 3, y (0 in null-rotation) 
     * @param q4 True attitude quaternion component 4, z (0 in null-rotation) 
     * @param roll Attitude roll expressed as Euler angles, not recommended except for human-readable outputs 
     * @param pitch Attitude pitch expressed as Euler angles, not recommended except for human-readable outputs 
     * @param yaw Attitude yaw expressed as Euler angles, not recommended except for human-readable outputs 
     * @param xacc X acceleration m/s/s 
     * @param yacc Y acceleration m/s/s 
     * @param zacc Z acceleration m/s/s 
     * @param xgyro Angular speed around X axis rad/s 
     * @param ygyro Angular speed around Y axis rad/s 
     * @param zgyro Angular speed around Z axis rad/s 
     * @param lat Latitude in degrees 
     * @param lon Longitude in degrees 
     * @param alt Altitude in meters 
     * @param stdDevHorz Horizontal position standard deviation 
     * @param stdDevVert Vertical position standard deviation 
     * @param vn True velocity in m/s in NORTH direction in earth-fixed NED frame 
     * @param ve True velocity in m/s in EAST direction in earth-fixed NED frame 
     * @param vd True velocity in m/s in DOWN direction in earth-fixed NED frame 
     */
    default void sendSimState(float q1, float q2, float q3, float q4, float roll, float pitch,
            float yaw, float xacc, float yacc, float zacc, float xgyro, float ygyro, float zgyro,
            float lat, float lon, float alt, float stdDevHorz, float stdDevVert, float vn, float ve,
            float vd) {
        outgoing().emit(SimState.builder()
                .q1(q1)
                .q2(q2)
                .q3(q3)
                .q4(q4)
                .roll(roll)
                .pitch(pitch)
                .yaw(yaw)
                .xacc(xacc)
                .yacc(yacc)
                .zacc(zacc)
                .xgyro(xgyro)
                .ygyro(ygyro)
                .zgyro(zgyro)
                .lat(lat)
                .lon(lon)
                .alt(alt)
                .stdDevHorz(stdDevHorz)
                .stdDevVert(stdDevVert)
                .vn(vn)
                .ve(ve)
                .vd(vd)
                .build());
    }

    /**
     * Orientation of a mount 
     * @param timeBootMs Timestamp (milliseconds since system boot) 
     * @param roll Roll in global frame in degrees (set to NaN for invalid). 
     * @param pitch Pitch in global frame in degrees (set to NaN for invalid). 
     * @param yaw Yaw relative to vehicle in degrees (set to NaN for invalid). 
     * @param yawAbsolute Yaw in absolute frame in degrees, North is 0 (set to NaN for invalid). 
     */
    default void sendMountOrientation(long timeBootMs, float roll, float pitch, float yaw,
            float yawAbsolute) {
        outgoing().emit(MountOrientation.builder()
                .timeBootMs(timeBootMs)
                .roll(roll)
                .pitch(pitch)
                .yaw(yaw)
                .yawAbsolute(yawAbsolute)
                .build());
    }

    /**
     * Sets a desired vehicle attitude. Used by an external controller to command the vehicle (manual 
     * controller or other system). 
     * @param timeBootMs Timestamp in milliseconds since system boot 
     * @param q Attitude quaternion (w, x, y, z order, zero-rotation is 1, 0, 0, 0) 
     * @param bodyRollRate Body roll rate in radians per second 
     * @param bodyPitchRate Body pitch rate in radians per second 
     * @param bodyYawRate Body yaw rate in radians per second 
     * @param thrust Collective thrust, normalized to 0 .. 1 (-1 .. 1 for vehicles capable of reverse trust) 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param typeMask Mappings: If any of these bits are set, the corresponding input should be ignored: bit 1: body 
     * roll rate, bit 2: body pitch rate, bit 3: body yaw rate. bit 4-bit 6: reserved, bit 7: throttle, 
     * bit 8: attitude 
     */
    default void sendSetAttitudeTarget(long timeBootMs, List<Float> q, float bodyRollRate,
            float bodyPitchRate, float bodyYawRate, float thrust, int targetSystem,
            int targetComponent, int typeMask) {
        outgoing().emit(SetAttitudeTarget.builder()
                .timeBootMs(timeBootMs)
                .q(q)
                .bodyRollRate(bodyRollRate)
                .bodyPitchRate(bodyPitchRate)
                .bodyYawRate(bodyYawRate)
                .thrust(thrust)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .typeMask(typeMask)
                .build());
    }

    /**
     * Read out the safety zone the MAV currently assumes. 
     * @param p1x x position 1 / Latitude 1 
     * @param p1y y position 1 / Longitude 1 
     * @param p1z z position 1 / Altitude 1 
     * @param p2x x position 2 / Latitude 2 
     * @param p2y y position 2 / Longitude 2 
     * @param p2z z position 2 / Altitude 2 
     * @param frame Coordinate frame, as defined by {@link io.dronefleet.mavlink.common.MavFrame MavFrame} enum. Can be either global, GPS, right-handed with Z 
     * axis up or local, right handed, Z axis down. 
     */
    default void sendSafetyAllowedArea(float p1x, float p1y, float p1z, float p2x, float p2y,
            float p2z, MavFrame frame) {
        outgoing().emit(SafetyAllowedArea.builder()
                .p1x(p1x)
                .p1y(p1y)
                .p1z(p1z)
                .p2x(p2x)
                .p2y(p2y)
                .p2z(p2z)
                .frame(frame)
                .build());
    }

    /**
     * Once the MAV sets a new GPS-Local correspondence, this message announces the origin (0,0,0) 
     * position 
     * @param latitude Latitude (WGS84), in degrees * 1E7 
     * @param longitude Longitude (WGS84), in degrees * 1E7 
     * @param altitude Altitude (AMSL), in meters * 1000 (positive for up) 
     * @param timeUsec Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
     */
    default void sendGpsGlobalOrigin(int latitude, int longitude, int altitude,
            BigInteger timeUsec) {
        outgoing().emit(GpsGlobalOrigin.builder()
                .latitude(latitude)
                .longitude(longitude)
                .altitude(altitude)
                .timeUsec(timeUsec)
                .build());
    }

    /**
     * Stop log transfer and resume normal logging 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     */
    default void sendLogRequestEnd(int targetSystem, int targetComponent) {
        outgoing().emit(LogRequestEnd.builder()
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .build());
    }

    /**
     * Status generated by radio and injected into MAVLink stream. 
     * @param rxerrors Receive errors 
     * @param fixed Count of error corrected packets 
     * @param rssi Local signal strength 
     * @param remrssi Remote signal strength 
     * @param txbuf Remaining free buffer space in percent. 
     * @param noise Background noise level 
     * @param remnoise Remote background noise level 
     */
    default void sendRadioStatus(int rxerrors, int fixed, int rssi, int remrssi, int txbuf,
            int noise, int remnoise) {
        outgoing().emit(RadioStatus.builder()
                .rxerrors(rxerrors)
                .fixed(fixed)
                .rssi(rssi)
                .remrssi(remrssi)
                .txbuf(txbuf)
                .noise(noise)
                .remnoise(remnoise)
                .build());
    }

    /**
     * current motion information from a designated system 
     * @param timestamp Timestamp in milliseconds since system boot 
     * @param customState button states or switches of a tracker device 
     * @param lat Latitude (WGS84), in degrees * 1E7 
     * @param lon Longitude (WGS84), in degrees * 1E7 
     * @param alt AMSL, in meters 
     * @param vel target velocity (0,0,0) for unknown 
     * @param acc linear target acceleration (0,0,0) for unknown 
     * @param attitudeQ (1 0 0 0 for unknown) 
     * @param rates (0 0 0 for unknown) 
     * @param positionCov eph epv 
     * @param estCapabilities bit positions for tracker reporting capabilities (POS = 0, VEL = 1, ACCEL = 2, ATT + RATES = 3) 
     */
    default void sendFollowTarget(BigInteger timestamp, BigInteger customState, int lat, int lon,
            float alt, List<Float> vel, List<Float> acc, List<Float> attitudeQ, List<Float> rates,
            List<Float> positionCov, int estCapabilities) {
        outgoing().emit(FollowTarget.builder()
                .timestamp(timestamp)
                .customState(customState)
                .lat(lat)
                .lon(lon)
                .alt(alt)
                .vel(vel)
                .acc(acc)
                .attitudeQ(attitudeQ)
                .rates(rates)
                .positionCov(positionCov)
                .estCapabilities(estCapabilities)
                .build());
    }

    /**
     * The global position, as returned by the Global Positioning System (GPS). This is NOT the global 
     * position estimate of the system, but rather a RAW sensor value. See message GLOBAL_POSITION 
     * for the global position estimate. 
     * @param timeUsec Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
     * @param lat Latitude (WGS84, EGM96 ellipsoid), in degrees * 1E7 
     * @param lon Longitude (WGS84, EGM96 ellipsoid), in degrees * 1E7 
     * @param alt Altitude (AMSL, NOT WGS84), in meters * 1000 (positive for up). Note that virtually all GPS 
     * modules provide the AMSL altitude in addition to the WGS84 altitude. 
     * @param eph GPS HDOP horizontal dilution of position (unitless). If unknown, set to: UINT16_MAX 
     * @param epv GPS VDOP vertical dilution of position (unitless). If unknown, set to: UINT16_MAX 
     * @param vel GPS ground speed (m/s * 100). If unknown, set to: UINT16_MAX 
     * @param cog Course over ground (NOT heading, but direction of movement) in degrees * 100, 0.0..359.99 
     * degrees. If unknown, set to: UINT16_MAX 
     * @param fixType See the {@link io.dronefleet.mavlink.common.GpsFixType GpsFixType} enum. 
     * @param satellitesVisible Number of satellites visible. If unknown, set to 255 
     * @param altEllipsoid Altitude (above WGS84, EGM96 ellipsoid), in meters * 1000 (positive for up). 
     * @param hAcc Position uncertainty in meters * 1000 (positive for up). 
     * @param vAcc Altitude uncertainty in meters * 1000 (positive for up). 
     * @param velAcc Speed uncertainty in meters * 1000 (positive for up). 
     * @param hdgAcc Heading / track uncertainty in degrees * 1e5. 
     */
    default void sendGpsRawInt(BigInteger timeUsec, int lat, int lon, int alt, int eph, int epv,
            int vel, int cog, GpsFixType fixType, int satellitesVisible, int altEllipsoid,
            long hAcc, long vAcc, long velAcc, long hdgAcc) {
        outgoing().emit(GpsRawInt.builder()
                .timeUsec(timeUsec)
                .lat(lat)
                .lon(lon)
                .alt(alt)
                .eph(eph)
                .epv(epv)
                .vel(vel)
                .cog(cog)
                .fixType(fixType)
                .satellitesVisible(satellitesVisible)
                .altEllipsoid(altEllipsoid)
                .hAcc(hAcc)
                .vAcc(vAcc)
                .velAcc(velAcc)
                .hdgAcc(hdgAcc)
                .build());
    }

    /**
     * The general system state. If the system is following the MAVLink standard, the system state is 
     * mainly defined by three orthogonal states/modes: The system mode, which is either LOCKED 
     * (motors shut down and locked), MANUAL (system under RC control), GUIDED (system with 
     * autonomous position control, position setpoint controlled manually) or AUTO (system guided 
     * by path/waypoint planner). The NAV_MODE defined the current flight state: LIFTOFF (often an 
     * open-loop maneuver), LANDING, WAYPOINTS or VECTOR. This represents the internal navigation 
     * state machine. The system status shows whether the system is currently active or not and if an 
     * emergency occured. During the CRITICAL and EMERGENCY states the MAV is still considered to be 
     * active, but should start emergency procedures autonomously. After a failure occured it 
     * should first move from active to critical to allow manual intervention and then move to 
     * emergency after a certain timeout. 
     * @param onboardControlSensorsPresent Bitmask showing which onboard controllers and sensors are present. Value of 0: not present. 
     * Value of 1: present. Indices defined by ENUM {@link io.dronefleet.mavlink.common.MavSysStatusSensor MavSysStatusSensor} 
     * @param onboardControlSensorsEnabled Bitmask showing which onboard controllers and sensors are enabled: Value of 0: not enabled. 
     * Value of 1: enabled. Indices defined by ENUM {@link io.dronefleet.mavlink.common.MavSysStatusSensor MavSysStatusSensor} 
     * @param onboardControlSensorsHealth Bitmask showing which onboard controllers and sensors are operational or have an error: Value 
     * of 0: not enabled. Value of 1: enabled. Indices defined by ENUM {@link io.dronefleet.mavlink.common.MavSysStatusSensor MavSysStatusSensor} 
     * @param load Maximum usage in percent of the mainloop time, (0%: 0, 100%: 1000) should be always below 1000 
     * @param voltageBattery Battery voltage, in millivolts (1 = 1 millivolt) 
     * @param currentBattery Battery current, in 10*milliamperes (1 = 10 milliampere), -1: autopilot does not measure the 
     * current 
     * @param dropRateComm Communication drops in percent, (0%: 0, 100%: 10'000), (UART, I2C, SPI, CAN), dropped packets 
     * on all links (packets that were corrupted on reception on the MAV) 
     * @param errorsComm Communication errors (UART, I2C, SPI, CAN), dropped packets on all links (packets that were 
     * corrupted on reception on the MAV) 
     * @param errorsCount1 Autopilot-specific errors 
     * @param errorsCount2 Autopilot-specific errors 
     * @param errorsCount3 Autopilot-specific errors 
     * @param errorsCount4 Autopilot-specific errors 
     * @param batteryRemaining Remaining battery energy: (0%: 0, 100%: 100), -1: autopilot estimate the remaining battery 
     */
    default void sendSysStatus(EnumFlagSet<MavSysStatusSensor> onboardControlSensorsPresent,
            EnumFlagSet<MavSysStatusSensor> onboardControlSensorsEnabled,
            EnumFlagSet<MavSysStatusSensor> onboardControlSensorsHealth, int load,
            int voltageBattery, int currentBattery, int dropRateComm, int errorsComm,
            int errorsCount1, int errorsCount2, int errorsCount3, int errorsCount4,
            int batteryRemaining) {
        outgoing().emit(SysStatus.builder()
                .onboardControlSensorsPresent(onboardControlSensorsPresent)
                .onboardControlSensorsEnabled(onboardControlSensorsEnabled)
                .onboardControlSensorsHealth(onboardControlSensorsHealth)
                .load(load)
                .voltageBattery(voltageBattery)
                .currentBattery(currentBattery)
                .dropRateComm(dropRateComm)
                .errorsComm(errorsComm)
                .errorsCount1(errorsCount1)
                .errorsCount2(errorsCount2)
                .errorsCount3(errorsCount3)
                .errorsCount4(errorsCount4)
                .batteryRemaining(batteryRemaining)
                .build());
    }

    /**
     * Message encoding a mission item. This message is emitted to announce the presence of a mission 
     * item and to set a mission item on the system. The mission item can be either in x, y, z meters (type: 
     * LOCAL) or x:lat, y:lon, z:altitude. Local frame is Z-down, right handed (NED), global frame is 
     * Z-up, right handed (ENU). See also https://mavlink.io/en/protocol/mission.html. 
     * @param param1 PARAM1, see {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum 
     * @param param2 PARAM2, see {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum 
     * @param param3 PARAM3, see {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum 
     * @param param4 PARAM4, see {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum 
     * @param x PARAM5 / local: x position in meters * 1e4, global: latitude in degrees * 10^7 
     * @param y PARAM6 / y position: local: x position in meters * 1e4, global: longitude in degrees *10^7 
     * @param z PARAM7 / z position: global: altitude in meters (relative or absolute, depending on frame. 
     * @param seq Waypoint ID (sequence number). Starts at zero. Increases monotonically for each waypoint, no 
     * gaps in the sequence (0,1,2,3,4). 
     * @param command The scheduled action for the waypoint, as defined by {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param frame The coordinate system of the waypoint, as defined by {@link io.dronefleet.mavlink.common.MavFrame MavFrame} enum 
     * @param current false:0, true:1 
     * @param autocontinue autocontinue to next wp 
     * @param missionType Mission type, see {@link io.dronefleet.mavlink.common.MavMissionType MavMissionType} 
     */
    default void sendMissionItemInt(float param1, float param2, float param3, float param4, int x,
            int y, float z, int seq, MavCmd command, int targetSystem, int targetComponent,
            MavFrame frame, int current, int autocontinue, MavMissionType missionType) {
        outgoing().emit(MissionItemInt.builder()
                .param1(param1)
                .param2(param2)
                .param3(param3)
                .param4(param4)
                .x(x)
                .y(y)
                .z(z)
                .seq(seq)
                .command(command)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .frame(frame)
                .current(current)
                .autocontinue(autocontinue)
                .missionType(missionType)
                .build());
    }

    /**
     * Request the information of the mission item with the sequence number seq. The response of the 
     * system to this message should be a MISSION_ITEM_INT message. 
     * https://mavlink.io/en/protocol/mission.html 
     * @param seq Sequence 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param missionType Mission type, see {@link io.dronefleet.mavlink.common.MavMissionType MavMissionType} 
     */
    default void sendMissionRequestInt(int seq, int targetSystem, int targetComponent,
            MavMissionType missionType) {
        outgoing().emit(MissionRequestInt.builder()
                .seq(seq)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .missionType(missionType)
                .build());
    }

    /**
     * Setpoint in roll, pitch, yaw and thrust from the operator 
     * @param timeBootMs Timestamp in milliseconds since system boot 
     * @param roll Desired roll rate in radians per second 
     * @param pitch Desired pitch rate in radians per second 
     * @param yaw Desired yaw rate in radians per second 
     * @param thrust Collective thrust, normalized to 0 .. 1 
     * @param modeSwitch Flight mode switch position, 0.. 255 
     * @param manualOverrideSwitch Override mode switch position, 0.. 255 
     */
    default void sendManualSetpoint(long timeBootMs, float roll, float pitch, float yaw,
            float thrust, int modeSwitch, int manualOverrideSwitch) {
        outgoing().emit(ManualSetpoint.builder()
                .timeBootMs(timeBootMs)
                .roll(roll)
                .pitch(pitch)
                .yaw(yaw)
                .thrust(thrust)
                .modeSwitch(modeSwitch)
                .manualOverrideSwitch(manualOverrideSwitch)
                .build());
    }

    /**
     * Send a key-value pair as float. The use of this message is discouraged for normal packets, but a 
     * quite efficient way for testing new messages and getting experimental debug output. 
     * @param timeBootMs Timestamp (milliseconds since system boot) 
     * @param value Floating point value 
     * @param name Name of the debug variable 
     */
    default void sendNamedValueFloat(long timeBootMs, float value, String name) {
        outgoing().emit(NamedValueFloat.builder()
                .timeBootMs(timeBootMs)
                .value(value)
                .name(name)
                .build());
    }

    /**
     * The RAW IMU readings for the usual 9DOF sensor setup. This message should contain the scaled 
     * values to the described units 
     * @param timeBootMs Timestamp (milliseconds since system boot) 
     * @param xacc X acceleration (mg) 
     * @param yacc Y acceleration (mg) 
     * @param zacc Z acceleration (mg) 
     * @param xgyro Angular speed around X axis (millirad /sec) 
     * @param ygyro Angular speed around Y axis (millirad /sec) 
     * @param zgyro Angular speed around Z axis (millirad /sec) 
     * @param xmag X Magnetic field (milli tesla) 
     * @param ymag Y Magnetic field (milli tesla) 
     * @param zmag Z Magnetic field (milli tesla) 
     */
    default void sendScaledImu(long timeBootMs, int xacc, int yacc, int zacc, int xgyro, int ygyro,
            int zgyro, int xmag, int ymag, int zmag) {
        outgoing().emit(ScaledImu.builder()
                .timeBootMs(timeBootMs)
                .xacc(xacc)
                .yacc(yacc)
                .zacc(zacc)
                .xgyro(xgyro)
                .ygyro(ygyro)
                .zgyro(zgyro)
                .xmag(xmag)
                .ymag(ymag)
                .zmag(zmag)
                .build());
    }

    /**
     * The scaled values of the RC channels received. (-100%) -10000, (0%) 0, (100%) 10000. Channels 
     * that are inactive should be set to UINT16_MAX. 
     * @param timeBootMs Timestamp (milliseconds since system boot) 
     * @param chan1Scaled RC channel 1 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) INT16_MAX. 
     * @param chan2Scaled RC channel 2 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) INT16_MAX. 
     * @param chan3Scaled RC channel 3 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) INT16_MAX. 
     * @param chan4Scaled RC channel 4 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) INT16_MAX. 
     * @param chan5Scaled RC channel 5 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) INT16_MAX. 
     * @param chan6Scaled RC channel 6 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) INT16_MAX. 
     * @param chan7Scaled RC channel 7 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) INT16_MAX. 
     * @param chan8Scaled RC channel 8 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) INT16_MAX. 
     * @param port Servo output port (set of 8 outputs = 1 port). Most MAVs will just use one, but this allows for more 
     * than 8 servos. 
     * @param rssi Receive signal strength indicator, 0: 0%, 100: 100%, 255: invalid/unknown. 
     */
    default void sendRcChannelsScaled(long timeBootMs, int chan1Scaled, int chan2Scaled,
            int chan3Scaled, int chan4Scaled, int chan5Scaled, int chan6Scaled, int chan7Scaled,
            int chan8Scaled, int port, int rssi) {
        outgoing().emit(RcChannelsScaled.builder()
                .timeBootMs(timeBootMs)
                .chan1Scaled(chan1Scaled)
                .chan2Scaled(chan2Scaled)
                .chan3Scaled(chan3Scaled)
                .chan4Scaled(chan4Scaled)
                .chan5Scaled(chan5Scaled)
                .chan6Scaled(chan6Scaled)
                .chan7Scaled(chan7Scaled)
                .chan8Scaled(chan8Scaled)
                .port(port)
                .rssi(rssi)
                .build());
    }

    /**
     * The current system altitude. 
     * @param timeUsec Timestamp (micros since boot or Unix epoch) 
     * @param altitudeMonotonic This altitude measure is initialized on system boot and monotonic (it is never reset, but 
     * represents the local altitude change). The only guarantee on this field is that it will never be 
     * reset and is consistent within a flight. The recommended value for this field is the 
     * uncorrected barometric altitude at boot time. This altitude will also drift and vary between 
     * flights. 
     * @param altitudeAmsl This altitude measure is strictly above mean sea level and might be non-monotonic (it might 
     * reset on events like GPS lock or when a new QNH value is set). It should be the altitude to which 
     * global altitude waypoints are compared to. Note that it is *not* the GPS altitude, however, 
     * most GPS modules already output AMSL by default and not the WGS84 altitude. 
     * @param altitudeLocal This is the local altitude in the local coordinate frame. It is not the altitude above home, but 
     * in reference to the coordinate origin (0, 0, 0). It is up-positive. 
     * @param altitudeRelative This is the altitude above the home position. It resets on each change of the current home 
     * position. 
     * @param altitudeTerrain This is the altitude above terrain. It might be fed by a terrain database or an altimeter. Values 
     * smaller than -1000 should be interpreted as unknown. 
     * @param bottomClearance This is not the altitude, but the clear space below the system according to the fused clearance 
     * estimate. It generally should max out at the maximum range of e.g. the laser altimeter. It is 
     * generally a moving target. A negative value indicates no measurement available. 
     */
    default void sendAltitude(BigInteger timeUsec, float altitudeMonotonic, float altitudeAmsl,
            float altitudeLocal, float altitudeRelative, float altitudeTerrain,
            float bottomClearance) {
        outgoing().emit(Altitude.builder()
                .timeUsec(timeUsec)
                .altitudeMonotonic(altitudeMonotonic)
                .altitudeAmsl(altitudeAmsl)
                .altitudeLocal(altitudeLocal)
                .altitudeRelative(altitudeRelative)
                .altitudeTerrain(altitudeTerrain)
                .bottomClearance(bottomClearance)
                .build());
    }

    /**
     * Request a partial list of mission items from the system/component. 
     * https://mavlink.io/en/protocol/mission.html. If start and end index are the same, just 
     * send one waypoint. 
     * @param startIndex Start index, 0 by default 
     * @param endIndex End index, -1 by default (-1: send list to end). Else a valid index of the list 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param missionType Mission type, see {@link io.dronefleet.mavlink.common.MavMissionType MavMissionType} 
     */
    default void sendMissionRequestPartialList(int startIndex, int endIndex, int targetSystem,
            int targetComponent, MavMissionType missionType) {
        outgoing().emit(MissionRequestPartialList.builder()
                .startIndex(startIndex)
                .endIndex(endIndex)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .missionType(missionType)
                .build());
    }

    /**
     * The filtered global position (e.g. fused GPS and accelerometers). The position is in 
     * GPS-frame (right-handed, Z-up). It is designed as scaled integer message since the 
     * resolution of float is not sufficient. NOTE: This message is intended for onboard networks / 
     * companion computers and higher-bandwidth links and optimized for accuracy and 
     * completeness. Please use the {@link io.dronefleet.mavlink.common.GlobalPositionInt GlobalPositionInt} message for a minimal subset. 
     * @param timeUsec Timestamp (microseconds since system boot or since UNIX epoch) 
     * @param lat Latitude, expressed as degrees * 1E7 
     * @param lon Longitude, expressed as degrees * 1E7 
     * @param alt Altitude in meters, expressed as * 1000 (millimeters), above MSL 
     * @param relativeAlt Altitude above ground in meters, expressed as * 1000 (millimeters) 
     * @param vx Ground X Speed (Latitude), expressed as m/s 
     * @param vy Ground Y Speed (Longitude), expressed as m/s 
     * @param vz Ground Z Speed (Altitude), expressed as m/s 
     * @param covariance Covariance matrix (first six entries are the first ROW, next six entries are the second row, 
     * etc.) 
     * @param estimatorType Class id of the estimator this estimate originated from. 
     */
    default void sendGlobalPositionIntCov(BigInteger timeUsec, int lat, int lon, int alt,
            int relativeAlt, float vx, float vy, float vz, List<Float> covariance,
            MavEstimatorType estimatorType) {
        outgoing().emit(GlobalPositionIntCov.builder()
                .timeUsec(timeUsec)
                .lat(lat)
                .lon(lon)
                .alt(alt)
                .relativeAlt(relativeAlt)
                .vx(vx)
                .vy(vy)
                .vz(vz)
                .covariance(covariance)
                .estimatorType(estimatorType)
                .build());
    }

    /**
     * null
     * @param usec Timestamp (microseconds, synced to UNIX time or since system boot) 
     * @param x Global X speed 
     * @param y Global Y speed 
     * @param z Global Z speed 
     * @param covariance Linear velocity covariance matrix (1st three entries - 1st row, etc.) 
     */
    default void sendVisionSpeedEstimate(BigInteger usec, float x, float y, float z,
            List<Float> covariance) {
        outgoing().emit(VisionSpeedEstimate.builder()
                .usec(usec)
                .x(x)
                .y(y)
                .z(z)
                .covariance(covariance)
                .build());
    }

    /**
     * The RAW values of the RC channels sent to the MAV to override info received from the RC radio. A 
     * value of UINT16_MAX means no change to that channel. A value of 0 means control of that channel 
     * should be released back to the RC radio. The standard PPM modulation is as follows: 1000 
     * microseconds: 0%, 2000 microseconds: 100%. Individual receivers/transmitters might 
     * violate this specification. 
     * @param chan1Raw RC channel 1 value, in microseconds. A value of UINT16_MAX means to ignore this field. 
     * @param chan2Raw RC channel 2 value, in microseconds. A value of UINT16_MAX means to ignore this field. 
     * @param chan3Raw RC channel 3 value, in microseconds. A value of UINT16_MAX means to ignore this field. 
     * @param chan4Raw RC channel 4 value, in microseconds. A value of UINT16_MAX means to ignore this field. 
     * @param chan5Raw RC channel 5 value, in microseconds. A value of UINT16_MAX means to ignore this field. 
     * @param chan6Raw RC channel 6 value, in microseconds. A value of UINT16_MAX means to ignore this field. 
     * @param chan7Raw RC channel 7 value, in microseconds. A value of UINT16_MAX means to ignore this field. 
     * @param chan8Raw RC channel 8 value, in microseconds. A value of UINT16_MAX means to ignore this field. 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param chan9Raw RC channel 9 value, in microseconds. A value of 0 means to ignore this field. 
     * @param chan10Raw RC channel 10 value, in microseconds. A value of 0 or UINT16_MAX means to ignore this field. 
     * @param chan11Raw RC channel 11 value, in microseconds. A value of 0 or UINT16_MAX means to ignore this field. 
     * @param chan12Raw RC channel 12 value, in microseconds. A value of 0 or UINT16_MAX means to ignore this field. 
     * @param chan13Raw RC channel 13 value, in microseconds. A value of 0 or UINT16_MAX means to ignore this field. 
     * @param chan14Raw RC channel 14 value, in microseconds. A value of 0 or UINT16_MAX means to ignore this field. 
     * @param chan15Raw RC channel 15 value, in microseconds. A value of 0 or UINT16_MAX means to ignore this field. 
     * @param chan16Raw RC channel 16 value, in microseconds. A value of 0 or UINT16_MAX means to ignore this field. 
     * @param chan17Raw RC channel 17 value, in microseconds. A value of 0 or UINT16_MAX means to ignore this field. 
     * @param chan18Raw RC channel 18 value, in microseconds. A value of 0 or UINT16_MAX means to ignore this field. 
     */
    default void sendRcChannelsOverride(int chan1Raw, int chan2Raw, int chan3Raw, int chan4Raw,
            int chan5Raw, int chan6Raw, int chan7Raw, int chan8Raw, int targetSystem,
            int targetComponent, int chan9Raw, int chan10Raw, int chan11Raw, int chan12Raw,
            int chan13Raw, int chan14Raw, int chan15Raw, int chan16Raw, int chan17Raw,
            int chan18Raw) {
        outgoing().emit(RcChannelsOverride.builder()
                .chan1Raw(chan1Raw)
                .chan2Raw(chan2Raw)
                .chan3Raw(chan3Raw)
                .chan4Raw(chan4Raw)
                .chan5Raw(chan5Raw)
                .chan6Raw(chan6Raw)
                .chan7Raw(chan7Raw)
                .chan8Raw(chan8Raw)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .chan9Raw(chan9Raw)
                .chan10Raw(chan10Raw)
                .chan11Raw(chan11Raw)
                .chan12Raw(chan12Raw)
                .chan13Raw(chan13Raw)
                .chan14Raw(chan14Raw)
                .chan15Raw(chan15Raw)
                .chan16Raw(chan16Raw)
                .chan17Raw(chan17Raw)
                .chan18Raw(chan18Raw)
                .build());
    }

    /**
     * Information about the status of a capture 
     * @param timeBootMs Timestamp (milliseconds since system boot) 
     * @param imageInterval Image capture interval in seconds 
     * @param recordingTimeMs Time in milliseconds since recording started 
     * @param availableCapacity Available storage capacity in MiB 
     * @param imageStatus Current status of image capturing (0: idle, 1: capture in progress, 2: interval set but idle, 3: 
     * interval set and capture in progress) 
     * @param videoStatus Current status of video capturing (0: idle, 1: capture in progress) 
     */
    default void sendCameraCaptureStatus(long timeBootMs, float imageInterval, long recordingTimeMs,
            float availableCapacity, int imageStatus, int videoStatus) {
        outgoing().emit(CameraCaptureStatus.builder()
                .timeBootMs(timeBootMs)
                .imageInterval(imageInterval)
                .recordingTimeMs(recordingTimeMs)
                .availableCapacity(availableCapacity)
                .imageStatus(imageStatus)
                .videoStatus(videoStatus)
                .build());
    }

    /**
     * An ack for a {@link io.dronefleet.mavlink.common.LoggingDataAcked LoggingDataAcked} message 
     * @param sequence sequence number (must match the one in {@link io.dronefleet.mavlink.common.LoggingDataAcked LoggingDataAcked}) 
     * @param targetSystem system ID of the target 
     * @param targetComponent component ID of the target 
     */
    default void sendLoggingAck(int sequence, int targetSystem, int targetComponent) {
        outgoing().emit(LoggingAck.builder()
                .sequence(sequence)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .build());
    }

    /**
     * Metrics typically displayed on a HUD for fixed wing aircraft 
     * @param airspeed Current airspeed in m/s 
     * @param groundspeed Current ground speed in m/s 
     * @param alt Current altitude (MSL), in meters 
     * @param climb Current climb rate in meters/second 
     * @param heading Current heading in degrees, in compass units (0..360, 0=north) 
     * @param throttle Current throttle setting in integer percent, 0 to 100 
     */
    default void sendVfrHud(float airspeed, float groundspeed, float alt, float climb, int heading,
            int throttle) {
        outgoing().emit(VfrHud.builder()
                .airspeed(airspeed)
                .groundspeed(groundspeed)
                .alt(alt)
                .climb(climb)
                .heading(heading)
                .throttle(throttle)
                .build());
    }

    /**
     * Optical flow from an angular rate flow sensor (e.g. PX4FLOW or mouse sensor) 
     * @param timeUsec Timestamp (microseconds, synced to UNIX time or since system boot) 
     * @param integrationTimeUs Integration time in microseconds. Divide integrated_x and integrated_y by the integration 
     * time to obtain average flow. The integration time also indicates the. 
     * @param integratedX Flow in radians around X axis (Sensor RH rotation about the X axis induces a positive flow. 
     * Sensor linear motion along the positive Y axis induces a negative flow.) 
     * @param integratedY Flow in radians around Y axis (Sensor RH rotation about the Y axis induces a positive flow. 
     * Sensor linear motion along the positive X axis induces a positive flow.) 
     * @param integratedXgyro RH rotation around X axis (rad) 
     * @param integratedYgyro RH rotation around Y axis (rad) 
     * @param integratedZgyro RH rotation around Z axis (rad) 
     * @param timeDeltaDistanceUs Time in microseconds since the distance was sampled. 
     * @param distance Distance to the center of the flow field in meters. Positive value (including zero): distance 
     * known. Negative value: Unknown distance. 
     * @param temperature Temperature * 100 in centi-degrees Celsius 
     * @param sensorId Sensor ID 
     * @param quality Optical flow quality / confidence. 0: no valid flow, 255: maximum quality 
     */
    default void sendOpticalFlowRad(BigInteger timeUsec, long integrationTimeUs, float integratedX,
            float integratedY, float integratedXgyro, float integratedYgyro, float integratedZgyro,
            long timeDeltaDistanceUs, float distance, int temperature, int sensorId, int quality) {
        outgoing().emit(OpticalFlowRad.builder()
                .timeUsec(timeUsec)
                .integrationTimeUs(integrationTimeUs)
                .integratedX(integratedX)
                .integratedY(integratedY)
                .integratedXgyro(integratedXgyro)
                .integratedYgyro(integratedYgyro)
                .integratedZgyro(integratedZgyro)
                .timeDeltaDistanceUs(timeDeltaDistanceUs)
                .distance(distance)
                .temperature(temperature)
                .sensorId(sensorId)
                .quality(quality)
                .build());
    }

    /**
     * Sets a desired vehicle position in a local north-east-down coordinate frame. Used by an 
     * external controller to command the vehicle (manual controller or other system). 
     * @param timeBootMs Timestamp in milliseconds since system boot 
     * @param x X Position in NED frame in meters 
     * @param y Y Position in NED frame in meters 
     * @param z Z Position in NED frame in meters (note, altitude is negative in NED) 
     * @param vx X velocity in NED frame in meter / s 
     * @param vy Y velocity in NED frame in meter / s 
     * @param vz Z velocity in NED frame in meter / s 
     * @param afx X acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N 
     * @param afy Y acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N 
     * @param afz Z acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N 
     * @param yaw yaw setpoint in rad 
     * @param yawRate yaw rate setpoint in rad/s 
     * @param typeMask Bitmask to indicate which dimensions should be ignored by the vehicle: a value of 
     * 0b0000000000000000 or 0b0000001000000000 indicates that none of the setpoint dimensions 
     * should be ignored. If bit 10 is set the floats afx afy afz should be interpreted as force instead 
     * of acceleration. Mapping: bit 1: x, bit 2: y, bit 3: z, bit 4: vx, bit 5: vy, bit 6: vz, bit 7: ax, bit 
     * 8: ay, bit 9: az, bit 10: is force setpoint, bit 11: yaw, bit 12: yaw rate 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param coordinateFrame Valid options are: MAV_FRAME_LOCAL_NED = 1, MAV_FRAME_LOCAL_OFFSET_NED = 7, 
     * MAV_FRAME_BODY_NED = 8, MAV_FRAME_BODY_OFFSET_NED = 9 
     */
    default void sendSetPositionTargetLocalNed(long timeBootMs, float x, float y, float z, float vx,
            float vy, float vz, float afx, float afy, float afz, float yaw, float yawRate,
            int typeMask, int targetSystem, int targetComponent, MavFrame coordinateFrame) {
        outgoing().emit(SetPositionTargetLocalNed.builder()
                .timeBootMs(timeBootMs)
                .x(x)
                .y(y)
                .z(z)
                .vx(vx)
                .vy(vy)
                .vz(vz)
                .afx(afx)
                .afy(afy)
                .afz(afz)
                .yaw(yaw)
                .yawRate(yawRate)
                .typeMask(typeMask)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .coordinateFrame(coordinateFrame)
                .build());
    }

    /**
     * Reply to {@link io.dronefleet.mavlink.common.LogRequestList LogRequestList} 
     * @param timeUtc UTC timestamp of log in seconds since 1970, or 0 if not available 
     * @param size Size of the log (may be approximate) in bytes 
     * @param id Log id 
     * @param numLogs Total number of logs 
     * @param lastLogNum High log number 
     */
    default void sendLogEntry(long timeUtc, long size, int id, int numLogs, int lastLogNum) {
        outgoing().emit(LogEntry.builder()
                .timeUtc(timeUtc)
                .size(size)
                .id(id)
                .numLogs(numLogs)
                .lastLogNum(lastLogNum)
                .build());
    }

    /**
     * null
     * @param size total data size in bytes (set on ACK only) 
     * @param width Width of a matrix or image 
     * @param height Height of a matrix or image 
     * @param packets number of packets beeing sent (set on ACK only) 
     * @param type type of requested/acknowledged data (as defined in ENUM DATA_TYPES in 
     * mavlink/include/mavlink_types.h) 
     * @param payload payload size per packet (normally 253 byte, see DATA field size in message ENCAPSULATED_DATA) 
     * (set on ACK only) 
     * @param jpgQuality JPEG quality out of [1,100] 
     */
    default void sendDataTransmissionHandshake(long size, int width, int height, int packets,
            int type, int payload, int jpgQuality) {
        outgoing().emit(DataTransmissionHandshake.builder()
                .size(size)
                .width(width)
                .height(height)
                .packets(packets)
                .type(type)
                .payload(payload)
                .jpgQuality(jpgQuality)
                .build());
    }

    /**
     * The position the system will return to and land on. The position is set automatically by the 
     * system during the takeoff in case it was not explicitely set by the operator before or after. The 
     * global and local positions encode the position in the respective coordinate frames, while the 
     * q parameter encodes the orientation of the surface. Under normal conditions it describes the 
     * heading and terrain slope, which can be used by the aircraft to adjust the approach. The 
     * approach 3D vector describes the point to which the system should fly in normal flight mode and 
     * then perform a landing sequence along the vector. 
     * @param latitude Latitude (WGS84), in degrees * 1E7 
     * @param longitude Longitude (WGS84, in degrees * 1E7 
     * @param altitude Altitude (AMSL), in meters * 1000 (positive for up) 
     * @param x Local X position of this position in the local coordinate frame 
     * @param y Local Y position of this position in the local coordinate frame 
     * @param z Local Z position of this position in the local coordinate frame 
     * @param q World to surface normal and heading transformation of the takeoff position. Used to indicate 
     * the heading and slope of the ground 
     * @param approachX Local X position of the end of the approach vector. Multicopters should set this position based 
     * on their takeoff path. Grass-landing fixed wing aircraft should set it the same way as 
     * multicopters. Runway-landing fixed wing aircraft should set it to the opposite direction of 
     * the takeoff, assuming the takeoff happened from the threshold / touchdown zone. 
     * @param approachY Local Y position of the end of the approach vector. Multicopters should set this position based 
     * on their takeoff path. Grass-landing fixed wing aircraft should set it the same way as 
     * multicopters. Runway-landing fixed wing aircraft should set it to the opposite direction of 
     * the takeoff, assuming the takeoff happened from the threshold / touchdown zone. 
     * @param approachZ Local Z position of the end of the approach vector. Multicopters should set this position based 
     * on their takeoff path. Grass-landing fixed wing aircraft should set it the same way as 
     * multicopters. Runway-landing fixed wing aircraft should set it to the opposite direction of 
     * the takeoff, assuming the takeoff happened from the threshold / touchdown zone. 
     * @param targetSystem System ID. 
     * @param timeUsec Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
     */
    default void sendSetHomePosition(int latitude, int longitude, int altitude, float x, float y,
            float z, List<Float> q, float approachX, float approachY, float approachZ,
            int targetSystem, BigInteger timeUsec) {
        outgoing().emit(SetHomePosition.builder()
                .latitude(latitude)
                .longitude(longitude)
                .altitude(altitude)
                .x(x)
                .y(y)
                .z(z)
                .q(q)
                .approachX(approachX)
                .approachY(approachY)
                .approachZ(approachZ)
                .targetSystem(targetSystem)
                .timeUsec(timeUsec)
                .build());
    }

    /**
     * Second GPS data. 
     * @param timeUsec Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
     * @param lat Latitude (WGS84), in degrees * 1E7 
     * @param lon Longitude (WGS84), in degrees * 1E7 
     * @param alt Altitude (AMSL, not WGS84), in meters * 1000 (positive for up) 
     * @param dgpsAge Age of DGPS info 
     * @param eph GPS HDOP horizontal dilution of position in cm (m*100). If unknown, set to: UINT16_MAX 
     * @param epv GPS VDOP vertical dilution of position in cm (m*100). If unknown, set to: UINT16_MAX 
     * @param vel GPS ground speed (m/s * 100). If unknown, set to: UINT16_MAX 
     * @param cog Course over ground (NOT heading, but direction of movement) in degrees * 100, 0.0..359.99 
     * degrees. If unknown, set to: UINT16_MAX 
     * @param fixType See the {@link io.dronefleet.mavlink.common.GpsFixType GpsFixType} enum. 
     * @param satellitesVisible Number of satellites visible. If unknown, set to 255 
     * @param dgpsNumch Number of DGPS satellites 
     */
    default void sendGps2Raw(BigInteger timeUsec, int lat, int lon, int alt, long dgpsAge, int eph,
            int epv, int vel, int cog, GpsFixType fixType, int satellitesVisible, int dgpsNumch) {
        outgoing().emit(Gps2Raw.builder()
                .timeUsec(timeUsec)
                .lat(lat)
                .lon(lon)
                .alt(alt)
                .dgpsAge(dgpsAge)
                .eph(eph)
                .epv(epv)
                .vel(vel)
                .cog(cog)
                .fixType(fixType)
                .satellitesVisible(satellitesVisible)
                .dgpsNumch(dgpsNumch)
                .build());
    }

    /**
     * Reports the current commanded vehicle position, velocity, and acceleration as specified by 
     * the autopilot. This should match the commands sent in {@link io.dronefleet.mavlink.common.SetPositionTargetGlobalInt SetPositionTargetGlobalInt} if the 
     * vehicle is being controlled this way. 
     * @param timeBootMs Timestamp in milliseconds since system boot. The rationale for the timestamp in the setpoint 
     * is to allow the system to compensate for the transport delay of the setpoint. This allows the 
     * system to compensate processing latency. 
     * @param latInt X Position in WGS84 frame in 1e7 * degrees 
     * @param lonInt Y Position in WGS84 frame in 1e7 * degrees 
     * @param alt Altitude in meters in AMSL altitude, not WGS84 if absolute or relative, above terrain if 
     * GLOBAL_TERRAIN_ALT_INT 
     * @param vx X velocity in NED frame in meter / s 
     * @param vy Y velocity in NED frame in meter / s 
     * @param vz Z velocity in NED frame in meter / s 
     * @param afx X acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N 
     * @param afy Y acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N 
     * @param afz Z acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N 
     * @param yaw yaw setpoint in rad 
     * @param yawRate yaw rate setpoint in rad/s 
     * @param typeMask Bitmask to indicate which dimensions should be ignored by the vehicle: a value of 
     * 0b0000000000000000 or 0b0000001000000000 indicates that none of the setpoint dimensions 
     * should be ignored. If bit 10 is set the floats afx afy afz should be interpreted as force instead 
     * of acceleration. Mapping: bit 1: x, bit 2: y, bit 3: z, bit 4: vx, bit 5: vy, bit 6: vz, bit 7: ax, bit 
     * 8: ay, bit 9: az, bit 10: is force setpoint, bit 11: yaw, bit 12: yaw rate 
     * @param coordinateFrame Valid options are: MAV_FRAME_GLOBAL_INT = 5, MAV_FRAME_GLOBAL_RELATIVE_ALT_INT = 6, 
     * MAV_FRAME_GLOBAL_TERRAIN_ALT_INT = 11 
     */
    default void sendPositionTargetGlobalInt(long timeBootMs, int latInt, int lonInt, float alt,
            float vx, float vy, float vz, float afx, float afy, float afz, float yaw, float yawRate,
            int typeMask, MavFrame coordinateFrame) {
        outgoing().emit(PositionTargetGlobalInt.builder()
                .timeBootMs(timeBootMs)
                .latInt(latInt)
                .lonInt(lonInt)
                .alt(alt)
                .vx(vx)
                .vy(vy)
                .vz(vz)
                .afx(afx)
                .afy(afy)
                .afz(afz)
                .yaw(yaw)
                .yawRate(yawRate)
                .typeMask(typeMask)
                .coordinateFrame(coordinateFrame)
                .build());
    }

    /**
     * Send a key-value pair as integer. The use of this message is discouraged for normal packets, but 
     * a quite efficient way for testing new messages and getting experimental debug output. 
     * @param timeBootMs Timestamp (milliseconds since system boot) 
     * @param value Signed integer value 
     * @param name Name of the debug variable 
     */
    default void sendNamedValueInt(long timeBootMs, int value, String name) {
        outgoing().emit(NamedValueInt.builder()
                .timeBootMs(timeBootMs)
                .value(value)
                .name(name)
                .build());
    }

    /**
     * Information about a camera 
     * @param timeBootMs Timestamp (milliseconds since system boot) 
     * @param firmwareVersion Version of the camera firmware (v << 24 & 0xff = Dev, v << 16 & 0xff = Patch, v << 8 & 0xff = Minor, v & 
     * 0xff = Major) 
     * @param focalLength Focal length in mm 
     * @param sensorSizeH Image sensor size horizontal in mm 
     * @param sensorSizeV Image sensor size vertical in mm 
     * @param flags {@link io.dronefleet.mavlink.common.CameraCapFlags CameraCapFlags} enum flags (bitmap) describing camera capabilities. 
     * @param resolutionH Image resolution in pixels horizontal 
     * @param resolutionV Image resolution in pixels vertical 
     * @param camDefinitionVersion Camera definition version (iteration) 
     * @param vendorName Name of the camera vendor 
     * @param modelName Name of the camera model 
     * @param lensId Reserved for a lens ID 
     * @param camDefinitionUri Camera definition URI (if any, otherwise only basic functions will be available). 
     */
    default void sendCameraInformation(long timeBootMs, long firmwareVersion, float focalLength,
            float sensorSizeH, float sensorSizeV, CameraCapFlags flags, int resolutionH,
            int resolutionV, int camDefinitionVersion, byte[] vendorName, byte[] modelName,
            int lensId, String camDefinitionUri) {
        outgoing().emit(CameraInformation.builder()
                .timeBootMs(timeBootMs)
                .firmwareVersion(firmwareVersion)
                .focalLength(focalLength)
                .sensorSizeH(sensorSizeH)
                .sensorSizeV(sensorSizeV)
                .flags(flags)
                .resolutionH(resolutionH)
                .resolutionV(resolutionV)
                .camDefinitionVersion(camDefinitionVersion)
                .vendorName(vendorName)
                .modelName(modelName)
                .lensId(lensId)
                .camDefinitionUri(camDefinitionUri)
                .build());
    }

    /**
     * The heartbeat message shows that a system is present and responding. The type of the MAV and 
     * Autopilot hardware allow the receiving system to treat further messages from this system 
     * appropriate (e.g. by laying out the user interface based on the autopilot). 
     * @param customMode A bitfield for use for autopilot-specific flags 
     * @param type Type of the MAV (quadrotor, helicopter, etc., up to 15 types, defined in {@link io.dronefleet.mavlink.common.MavType MavType} ENUM) 
     * @param autopilot Autopilot type / class. defined in {@link io.dronefleet.mavlink.common.MavAutopilot MavAutopilot} ENUM 
     * @param baseMode System mode bitfield, as defined by {@link io.dronefleet.mavlink.common.MavModeFlag MavModeFlag} enum 
     * @param systemStatus System status flag, as defined by {@link io.dronefleet.mavlink.common.MavState MavState} enum 
     * @param mavlinkVersion MAVLink version, not writable by user, gets added by protocol because of magic data type: 
     * uint8_t_mavlink_version 
     */
    default void sendHeartbeat(long customMode, MavType type, MavAutopilot autopilot,
            EnumFlagSet<MavModeFlag> baseMode, MavState systemStatus, int mavlinkVersion) {
        outgoing().emit(Heartbeat.builder()
                .customMode(customMode)
                .type(type)
                .autopilot(autopilot)
                .baseMode(baseMode)
                .systemStatus(systemStatus)
                .mavlinkVersion(mavlinkVersion)
                .build());
    }

    /**
     * Response from a {@link io.dronefleet.mavlink.common.TerrainCheck TerrainCheck} request 
     * @param lat Latitude (degrees *10^7) 
     * @param lon Longitude (degrees *10^7) 
     * @param terrainHeight Terrain height in meters AMSL 
     * @param currentHeight Current vehicle height above lat/lon terrain height (meters) 
     * @param spacing grid spacing (zero if terrain at this location unavailable) 
     * @param pending Number of 4x4 terrain blocks waiting to be received or read from disk 
     * @param loaded Number of 4x4 terrain blocks in memory 
     */
    default void sendTerrainReport(int lat, int lon, float terrainHeight, float currentHeight,
            int spacing, int pending, int loaded) {
        outgoing().emit(TerrainReport.builder()
                .lat(lat)
                .lon(lon)
                .terrainHeight(terrainHeight)
                .currentHeight(currentHeight)
                .spacing(spacing)
                .pending(pending)
                .loaded(loaded)
                .build());
    }

    /**
     * Ack message during waypoint handling. The type field states if this message is a positive ack 
     * (type=0) or if an error happened (type=non-zero). 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param type See {@link io.dronefleet.mavlink.common.MavMissionResult MavMissionResult} enum 
     * @param missionType Mission type, see {@link io.dronefleet.mavlink.common.MavMissionType MavMissionType} 
     */
    default void sendMissionAck(int targetSystem, int targetComponent, MavMissionResult type,
            MavMissionType missionType) {
        outgoing().emit(MissionAck.builder()
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .type(type)
                .missionType(missionType)
                .build());
    }

    /**
     * Request the overall list of mission items from the system/component. 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param missionType Mission type, see {@link io.dronefleet.mavlink.common.MavMissionType MavMissionType} 
     */
    default void sendMissionRequestList(int targetSystem, int targetComponent,
            MavMissionType missionType) {
        outgoing().emit(MissionRequestList.builder()
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .missionType(missionType)
                .build());
    }

    /**
     * Control vehicle tone generation (buzzer) 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param tune tune in board specific format 
     */
    default void sendPlayTune(int targetSystem, int targetComponent, String tune) {
        outgoing().emit(PlayTune.builder()
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .tune(tune)
                .build());
    }

    /**
     * Set a parameter value TEMPORARILY to RAM. It will be reset to default on system reboot. Send the 
     * ACTION MAV_ACTION_STORAGE_WRITE to PERMANENTLY write the RAM contents to EEPROM. 
     * IMPORTANT: The receiving component should acknowledge the new parameter value by sending a 
     * param_value message to all communication partners. This will also ensure that multiple GCS 
     * all have an up-to-date list of all parameters. If the sending GCS did not receive a {@link io.dronefleet.mavlink.common.ParamValue ParamValue} 
     * message within its timeout time, it should re-send the PARAM_SET message. 
     * @param paramValue Onboard parameter value 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param paramId Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and 
     * WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to 
     * provide 16+1 bytes storage if the ID is stored as string 
     * @param paramType Onboard parameter type: see the {@link io.dronefleet.mavlink.common.MavParamType MavParamType} enum for supported data types. 
     */
    default void sendParamSet(float paramValue, int targetSystem, int targetComponent,
            String paramId, MavParamType paramType) {
        outgoing().emit(ParamSet.builder()
                .paramValue(paramValue)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .paramId(paramId)
                .paramType(paramType)
                .build());
    }

    /**
     * WORK IN PROGRESS! DO NOT DEPLOY! Message to describe a trajectory in the local frame. Supported 
     * trajectory types are enumerated in {@link io.dronefleet.mavlink.common.MavTrajectoryRepresentation MavTrajectoryRepresentation} 
     * @param timeUsec Timestamp (microseconds since system boot or since UNIX epoch). 
     * @param point1 Depending on the type (see {@link io.dronefleet.mavlink.common.MavTrajectoryRepresentation MavTrajectoryRepresentation}) 
     * @param point2 Depending on the type (see {@link io.dronefleet.mavlink.common.MavTrajectoryRepresentation MavTrajectoryRepresentation}) 
     * @param point3 Depending on the type (see {@link io.dronefleet.mavlink.common.MavTrajectoryRepresentation MavTrajectoryRepresentation}) 
     * @param point4 Depending on the type (see {@link io.dronefleet.mavlink.common.MavTrajectoryRepresentation MavTrajectoryRepresentation}) 
     * @param point5 Depending on the type (see {@link io.dronefleet.mavlink.common.MavTrajectoryRepresentation MavTrajectoryRepresentation}) 
     * @param type Waypoints, Bezier etc. see {@link io.dronefleet.mavlink.common.MavTrajectoryRepresentation MavTrajectoryRepresentation} 
     * @param pointValid States if respective point is valid (boolean) 
     */
    default void sendTrajectory(BigInteger timeUsec, List<Float> point1, List<Float> point2,
            List<Float> point3, List<Float> point4, List<Float> point5,
            MavTrajectoryRepresentation type, byte[] pointValid) {
        outgoing().emit(Trajectory.builder()
                .timeUsec(timeUsec)
                .point1(point1)
                .point2(point2)
                .point3(point3)
                .point4(point4)
                .point5(point5)
                .type(type)
                .pointValid(pointValid)
                .build());
    }

    /**
     * The positioning status, as reported by GPS. This message is intended to display status 
     * information about each satellite visible to the receiver. See message GLOBAL_POSITION for 
     * the global position estimate. This message can contain information for up to 20 satellites. 
     * @param satellitesVisible Number of satellites visible 
     * @param satellitePrn Global satellite ID 
     * @param satelliteUsed 0: Satellite not used, 1: used for localization 
     * @param satelliteElevation Elevation (0: right on top of receiver, 90: on the horizon) of satellite 
     * @param satelliteAzimuth Direction of satellite, 0: 0 deg, 255: 360 deg. 
     * @param satelliteSnr Signal to noise ratio of satellite 
     */
    default void sendGpsStatus(int satellitesVisible, byte[] satellitePrn, byte[] satelliteUsed,
            byte[] satelliteElevation, byte[] satelliteAzimuth, byte[] satelliteSnr) {
        outgoing().emit(GpsStatus.builder()
                .satellitesVisible(satellitesVisible)
                .satellitePrn(satellitePrn)
                .satelliteUsed(satelliteUsed)
                .satelliteElevation(satelliteElevation)
                .satelliteAzimuth(satelliteAzimuth)
                .satelliteSnr(satelliteSnr)
                .build());
    }

    /**
     * Sets a desired vehicle position, velocity, and/or acceleration in a global coordinate system 
     * (WGS84). Used by an external controller to command the vehicle (manual controller or other 
     * system). 
     * @param timeBootMs Timestamp in milliseconds since system boot. The rationale for the timestamp in the setpoint 
     * is to allow the system to compensate for the transport delay of the setpoint. This allows the 
     * system to compensate processing latency. 
     * @param latInt X Position in WGS84 frame in 1e7 * degrees 
     * @param lonInt Y Position in WGS84 frame in 1e7 * degrees 
     * @param alt Altitude in meters in AMSL altitude, not WGS84 if absolute or relative, above terrain if 
     * GLOBAL_TERRAIN_ALT_INT 
     * @param vx X velocity in NED frame in meter / s 
     * @param vy Y velocity in NED frame in meter / s 
     * @param vz Z velocity in NED frame in meter / s 
     * @param afx X acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N 
     * @param afy Y acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N 
     * @param afz Z acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N 
     * @param yaw yaw setpoint in rad 
     * @param yawRate yaw rate setpoint in rad/s 
     * @param typeMask Bitmask to indicate which dimensions should be ignored by the vehicle: a value of 
     * 0b0000000000000000 or 0b0000001000000000 indicates that none of the setpoint dimensions 
     * should be ignored. If bit 10 is set the floats afx afy afz should be interpreted as force instead 
     * of acceleration. Mapping: bit 1: x, bit 2: y, bit 3: z, bit 4: vx, bit 5: vy, bit 6: vz, bit 7: ax, bit 
     * 8: ay, bit 9: az, bit 10: is force setpoint, bit 11: yaw, bit 12: yaw rate 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param coordinateFrame Valid options are: MAV_FRAME_GLOBAL_INT = 5, MAV_FRAME_GLOBAL_RELATIVE_ALT_INT = 6, 
     * MAV_FRAME_GLOBAL_TERRAIN_ALT_INT = 11 
     */
    default void sendSetPositionTargetGlobalInt(long timeBootMs, int latInt, int lonInt, float alt,
            float vx, float vy, float vz, float afx, float afy, float afz, float yaw, float yawRate,
            int typeMask, int targetSystem, int targetComponent, MavFrame coordinateFrame) {
        outgoing().emit(SetPositionTargetGlobalInt.builder()
                .timeBootMs(timeBootMs)
                .latInt(latInt)
                .lonInt(lonInt)
                .alt(alt)
                .vx(vx)
                .vy(vy)
                .vz(vz)
                .afx(afx)
                .afy(afy)
                .afz(afz)
                .yaw(yaw)
                .yawRate(yawRate)
                .typeMask(typeMask)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .coordinateFrame(coordinateFrame)
                .build());
    }

    /**
     * Sent from autopilot to simulation. Hardware in the loop control outputs (replacement for 
     * {@link io.dronefleet.mavlink.common.HilControls HilControls}) 
     * @param timeUsec Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
     * @param flags Flags as bitfield, reserved for future use. 
     * @param controls Control outputs -1 .. 1. Channel assignment depends on the simulated hardware. 
     * @param mode System mode ({@link io.dronefleet.mavlink.common.MavMode MavMode}), includes arming state. 
     */
    default void sendHilActuatorControls(BigInteger timeUsec, BigInteger flags,
            List<Float> controls, MavMode mode) {
        outgoing().emit(HilActuatorControls.builder()
                .timeUsec(timeUsec)
                .flags(flags)
                .controls(controls)
                .mode(mode)
                .build());
    }

    /**
     * This message provides an API for manually controlling the vehicle using standard joystick 
     * axes nomenclature, along with a joystick-like input device. Unused axes can be disabled an 
     * buttons are also transmit as boolean values of their 
     * @param x X-axis, normalized to the range [-1000,1000]. A value of INT16_MAX indicates that this axis is 
     * invalid. Generally corresponds to forward(1000)-backward(-1000) movement on a joystick 
     * and the pitch of a vehicle. 
     * @param y Y-axis, normalized to the range [-1000,1000]. A value of INT16_MAX indicates that this axis is 
     * invalid. Generally corresponds to left(-1000)-right(1000) movement on a joystick and the 
     * roll of a vehicle. 
     * @param z Z-axis, normalized to the range [-1000,1000]. A value of INT16_MAX indicates that this axis is 
     * invalid. Generally corresponds to a separate slider movement with maximum being 1000 and 
     * minimum being -1000 on a joystick and the thrust of a vehicle. Positive values are positive 
     * thrust, negative values are negative thrust. 
     * @param r R-axis, normalized to the range [-1000,1000]. A value of INT16_MAX indicates that this axis is 
     * invalid. Generally corresponds to a twisting of the joystick, with counter-clockwise being 
     * 1000 and clockwise being -1000, and the yaw of a vehicle. 
     * @param buttons A bitfield corresponding to the joystick buttons' current state, 1 for pressed, 0 for 
     * released. The lowest bit corresponds to Button 1. 
     * @param target The system to be controlled. 
     */
    default void sendManualControl(int x, int y, int z, int r, int buttons, int target) {
        outgoing().emit(ManualControl.builder()
                .x(x)
                .y(y)
                .z(z)
                .r(r)
                .buttons(buttons)
                .target(target)
                .build());
    }

    /**
     * The interval between messages for a particular MAVLink message ID. This interface replaces 
     * {@link io.dronefleet.mavlink.common.DataStream DataStream} 
     * @param intervalUs The interval between two messages, in microseconds. A value of -1 indicates this stream is 
     * disabled, 0 indicates it is not available, > 0 indicates the interval at which it is sent. 
     * @param messageId The ID of the requested MAVLink message. v1.0 is limited to 254 messages. 
     */
    default void sendMessageInterval(int intervalUs, int messageId) {
        outgoing().emit(MessageInterval.builder()
                .intervalUs(intervalUs)
                .messageId(messageId)
                .build());
    }

    /**
     * The pressure readings for the typical setup of one absolute and differential pressure sensor. 
     * The units are as specified in each field. 
     * @param timeBootMs Timestamp (milliseconds since system boot) 
     * @param pressAbs Absolute pressure (hectopascal) 
     * @param pressDiff Differential pressure 1 (hectopascal) 
     * @param temperature Temperature measurement (0.01 degrees celsius) 
     */
    default void sendScaledPressure(long timeBootMs, float pressAbs, float pressDiff,
            int temperature) {
        outgoing().emit(ScaledPressure.builder()
                .timeBootMs(timeBootMs)
                .pressAbs(pressAbs)
                .pressDiff(pressDiff)
                .temperature(temperature)
                .build());
    }

    /**
     * Sent from simulation to autopilot, avoids in contrast to {@link io.dronefleet.mavlink.common.HilState HilState} singularities. This 
     * packet is useful for high throughput applications such as hardware in the loop simulations. 
     * @param timeUsec Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
     * @param attitudeQuaternion Vehicle attitude expressed as normalized quaternion in w, x, y, z order (with 1 0 0 0 being the 
     * null-rotation) 
     * @param rollspeed Body frame roll / phi angular speed (rad/s) 
     * @param pitchspeed Body frame pitch / theta angular speed (rad/s) 
     * @param yawspeed Body frame yaw / psi angular speed (rad/s) 
     * @param lat Latitude, expressed as degrees * 1E7 
     * @param lon Longitude, expressed as degrees * 1E7 
     * @param alt Altitude in meters, expressed as * 1000 (millimeters) 
     * @param vx Ground X Speed (Latitude), expressed as cm/s 
     * @param vy Ground Y Speed (Longitude), expressed as cm/s 
     * @param vz Ground Z Speed (Altitude), expressed as cm/s 
     * @param indAirspeed Indicated airspeed, expressed as cm/s 
     * @param trueAirspeed True airspeed, expressed as cm/s 
     * @param xacc X acceleration (mg) 
     * @param yacc Y acceleration (mg) 
     * @param zacc Z acceleration (mg) 
     */
    default void sendHilStateQuaternion(BigInteger timeUsec, List<Float> attitudeQuaternion,
            float rollspeed, float pitchspeed, float yawspeed, int lat, int lon, int alt, int vx,
            int vy, int vz, int indAirspeed, int trueAirspeed, int xacc, int yacc, int zacc) {
        outgoing().emit(HilStateQuaternion.builder()
                .timeUsec(timeUsec)
                .attitudeQuaternion(attitudeQuaternion)
                .rollspeed(rollspeed)
                .pitchspeed(pitchspeed)
                .yawspeed(yawspeed)
                .lat(lat)
                .lon(lon)
                .alt(alt)
                .vx(vx)
                .vy(vy)
                .vz(vz)
                .indAirspeed(indAirspeed)
                .trueAirspeed(trueAirspeed)
                .xacc(xacc)
                .yacc(yacc)
                .zacc(zacc)
                .build());
    }

    /**
     * Status text message. These messages are printed in yellow in the COMM console of 
     * QGroundControl. WARNING: They consume quite some bandwidth, so use only for important status 
     * and error messages. If implemented wisely, these messages are buffered on the MCU and sent only 
     * at a limited rate (e.g. 10 Hz). 
     * @param severity Severity of status. Relies on the definitions within RFC-5424. See enum {@link io.dronefleet.mavlink.common.MavSeverity MavSeverity}. 
     * @param text Status text message, without null termination character 
     */
    default void sendStatustext(MavSeverity severity, String text) {
        outgoing().emit(Statustext.builder()
                .severity(severity)
                .text(text)
                .build());
    }

    /**
     * Bind a RC channel to a parameter. The parameter should change accoding to the RC channel value. 
     * @param paramValue0 Initial parameter value 
     * @param scale Scale, maps the RC range [-1, 1] to a parameter value 
     * @param paramValueMin Minimum param value. The protocol does not define if this overwrites an onboard minimum value. 
     * (Depends on implementation) 
     * @param paramValueMax Maximum param value. The protocol does not define if this overwrites an onboard maximum value. 
     * (Depends on implementation) 
     * @param paramIndex Parameter index. Send -1 to use the param ID field as identifier (else the param id will be 
     * ignored), send -2 to disable any existing map for this rc_channel_index. 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param paramId Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and 
     * WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to 
     * provide 16+1 bytes storage if the ID is stored as string 
     * @param parameterRcChannelIndex Index of parameter RC channel. Not equal to the RC channel id. Typically correpsonds to a 
     * potentiometer-knob on the RC. 
     */
    default void sendParamMapRc(float paramValue0, float scale, float paramValueMin,
            float paramValueMax, int paramIndex, int targetSystem, int targetComponent,
            String paramId, int parameterRcChannelIndex) {
        outgoing().emit(ParamMapRc.builder()
                .paramValue0(paramValue0)
                .scale(scale)
                .paramValueMin(paramValueMin)
                .paramValueMax(paramValueMax)
                .paramIndex(paramIndex)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .paramId(paramId)
                .parameterRcChannelIndex(parameterRcChannelIndex)
                .build());
    }

    /**
     * Power supply status 
     * @param vcc 5V rail voltage in millivolts 
     * @param vservo servo rail voltage in millivolts 
     * @param flags power supply status flags (see {@link io.dronefleet.mavlink.common.MavPowerStatus MavPowerStatus} enum) 
     */
    default void sendPowerStatus(int vcc, int vservo, EnumFlagSet<MavPowerStatus> flags) {
        outgoing().emit(PowerStatus.builder()
                .vcc(vcc)
                .vservo(vservo)
                .flags(flags)
                .build());
    }

    /**
     * The attitude in the aeronautical frame (right-handed, Z-down, X-front, Y-right), expressed 
     * as quaternion. Quaternion order is w, x, y, z and a zero rotation would be expressed as (1 0 0 0). 
     * @param timeUsec Timestamp (microseconds since system boot or since UNIX epoch) 
     * @param q Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation) 
     * @param rollspeed Roll angular speed (rad/s) 
     * @param pitchspeed Pitch angular speed (rad/s) 
     * @param yawspeed Yaw angular speed (rad/s) 
     * @param covariance Attitude covariance 
     */
    default void sendAttitudeQuaternionCov(BigInteger timeUsec, List<Float> q, float rollspeed,
            float pitchspeed, float yawspeed, List<Float> covariance) {
        outgoing().emit(AttitudeQuaternionCov.builder()
                .timeUsec(timeUsec)
                .q(q)
                .rollspeed(rollspeed)
                .pitchspeed(pitchspeed)
                .yawspeed(yawspeed)
                .covariance(covariance)
                .build());
    }

    /**
     * Simulated optical flow from a flow sensor (e.g. PX4FLOW or optical mouse sensor) 
     * @param timeUsec Timestamp (microseconds, synced to UNIX time or since system boot) 
     * @param integrationTimeUs Integration time in microseconds. Divide integrated_x and integrated_y by the integration 
     * time to obtain average flow. The integration time also indicates the. 
     * @param integratedX Flow in radians around X axis (Sensor RH rotation about the X axis induces a positive flow. 
     * Sensor linear motion along the positive Y axis induces a negative flow.) 
     * @param integratedY Flow in radians around Y axis (Sensor RH rotation about the Y axis induces a positive flow. 
     * Sensor linear motion along the positive X axis induces a positive flow.) 
     * @param integratedXgyro RH rotation around X axis (rad) 
     * @param integratedYgyro RH rotation around Y axis (rad) 
     * @param integratedZgyro RH rotation around Z axis (rad) 
     * @param timeDeltaDistanceUs Time in microseconds since the distance was sampled. 
     * @param distance Distance to the center of the flow field in meters. Positive value (including zero): distance 
     * known. Negative value: Unknown distance. 
     * @param temperature Temperature * 100 in centi-degrees Celsius 
     * @param sensorId Sensor ID 
     * @param quality Optical flow quality / confidence. 0: no valid flow, 255: maximum quality 
     */
    default void sendHilOpticalFlow(BigInteger timeUsec, long integrationTimeUs, float integratedX,
            float integratedY, float integratedXgyro, float integratedYgyro, float integratedZgyro,
            long timeDeltaDistanceUs, float distance, int temperature, int sensorId, int quality) {
        outgoing().emit(HilOpticalFlow.builder()
                .timeUsec(timeUsec)
                .integrationTimeUs(integrationTimeUs)
                .integratedX(integratedX)
                .integratedY(integratedY)
                .integratedXgyro(integratedXgyro)
                .integratedYgyro(integratedYgyro)
                .integratedZgyro(integratedZgyro)
                .timeDeltaDistanceUs(timeDeltaDistanceUs)
                .distance(distance)
                .temperature(temperature)
                .sensorId(sensorId)
                .quality(quality)
                .build());
    }

    /**
     * The RAW values of the servo outputs (for RC input from the remote, use the RC_CHANNELS 
     * messages). The standard PPM modulation is as follows: 1000 microseconds: 0%, 2000 
     * microseconds: 100%. 
     * @param timeUsec Timestamp (microseconds since system boot) 
     * @param servo1Raw Servo output 1 value, in microseconds 
     * @param servo2Raw Servo output 2 value, in microseconds 
     * @param servo3Raw Servo output 3 value, in microseconds 
     * @param servo4Raw Servo output 4 value, in microseconds 
     * @param servo5Raw Servo output 5 value, in microseconds 
     * @param servo6Raw Servo output 6 value, in microseconds 
     * @param servo7Raw Servo output 7 value, in microseconds 
     * @param servo8Raw Servo output 8 value, in microseconds 
     * @param port Servo output port (set of 8 outputs = 1 port). Most MAVs will just use one, but this allows to 
     * encode more than 8 servos. 
     * @param servo9Raw Servo output 9 value, in microseconds 
     * @param servo10Raw Servo output 10 value, in microseconds 
     * @param servo11Raw Servo output 11 value, in microseconds 
     * @param servo12Raw Servo output 12 value, in microseconds 
     * @param servo13Raw Servo output 13 value, in microseconds 
     * @param servo14Raw Servo output 14 value, in microseconds 
     * @param servo15Raw Servo output 15 value, in microseconds 
     * @param servo16Raw Servo output 16 value, in microseconds 
     */
    default void sendServoOutputRaw(long timeUsec, int servo1Raw, int servo2Raw, int servo3Raw,
            int servo4Raw, int servo5Raw, int servo6Raw, int servo7Raw, int servo8Raw, int port,
            int servo9Raw, int servo10Raw, int servo11Raw, int servo12Raw, int servo13Raw,
            int servo14Raw, int servo15Raw, int servo16Raw) {
        outgoing().emit(ServoOutputRaw.builder()
                .timeUsec(timeUsec)
                .servo1Raw(servo1Raw)
                .servo2Raw(servo2Raw)
                .servo3Raw(servo3Raw)
                .servo4Raw(servo4Raw)
                .servo5Raw(servo5Raw)
                .servo6Raw(servo6Raw)
                .servo7Raw(servo7Raw)
                .servo8Raw(servo8Raw)
                .port(port)
                .servo9Raw(servo9Raw)
                .servo10Raw(servo10Raw)
                .servo11Raw(servo11Raw)
                .servo12Raw(servo12Raw)
                .servo13Raw(servo13Raw)
                .servo14Raw(servo14Raw)
                .servo15Raw(servo15Raw)
                .servo16Raw(servo16Raw)
                .build());
    }

    /**
     * Send a debug value. The index is used to discriminate between values. These values show up in the 
     * plot of QGroundControl as DEBUG N. 
     * @param timeBootMs Timestamp (milliseconds since system boot) 
     * @param value DEBUG value 
     * @param ind index of debug variable 
     */
    default void sendDebug(long timeBootMs, float value, int ind) {
        outgoing().emit(Debug.builder()
                .timeBootMs(timeBootMs)
                .value(value)
                .ind(ind)
                .build());
    }

    /**
     * Request to read the onboard parameter with the param_id string id. Onboard parameters are 
     * stored as key[const char*] -> value[float]. This allows to send a parameter to any other 
     * component (such as the GCS) without the need of previous knowledge of possible parameter 
     * names. Thus the same GCS can store different parameters for different autopilots. See also 
     * https://mavlink.io/en/protocol/parameter.html for a full documentation of 
     * QGroundControl and IMU code. 
     * @param paramIndex Parameter index. Send -1 to use the param ID field as identifier (else the param id will be 
     * ignored) 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param paramId Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and 
     * WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to 
     * provide 16+1 bytes storage if the ID is stored as string 
     */
    default void sendParamRequestRead(int paramIndex, int targetSystem, int targetComponent,
            String paramId) {
        outgoing().emit(ParamRequestRead.builder()
                .paramIndex(paramIndex)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .paramId(paramId)
                .build());
    }

    /**
     * Message encoding a command with parameters as scaled integers. Scaling depends on the actual 
     * command value. 
     * @param param1 PARAM1, see {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum 
     * @param param2 PARAM2, see {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum 
     * @param param3 PARAM3, see {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum 
     * @param param4 PARAM4, see {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum 
     * @param x PARAM5 / local: x position in meters * 1e4, global: latitude in degrees * 10^7 
     * @param y PARAM6 / local: y position in meters * 1e4, global: longitude in degrees * 10^7 
     * @param z PARAM7 / z position: global: altitude in meters (relative or absolute, depending on frame. 
     * @param command The scheduled action for the mission item, as defined by {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param frame The coordinate system of the COMMAND, as defined by {@link io.dronefleet.mavlink.common.MavFrame MavFrame} enum 
     * @param current false:0, true:1 
     * @param autocontinue autocontinue to next wp 
     */
    default void sendCommandInt(float param1, float param2, float param3, float param4, int x,
            int y, float z, MavCmd command, int targetSystem, int targetComponent, MavFrame frame,
            int current, int autocontinue) {
        outgoing().emit(CommandInt.builder()
                .param1(param1)
                .param2(param2)
                .param3(param3)
                .param4(param4)
                .x(x)
                .y(y)
                .z(z)
                .command(command)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .frame(frame)
                .current(current)
                .autocontinue(autocontinue)
                .build());
    }

    /**
     * GPS sensor input message. This is a raw sensor value sent by the GPS. This is NOT the global 
     * position estimate of the sytem. 
     * @param timeUsec Timestamp (micros since boot or Unix epoch) 
     * @param timeWeekMs GPS time (milliseconds from start of GPS week) 
     * @param lat Latitude (WGS84), in degrees * 1E7 
     * @param lon Longitude (WGS84), in degrees * 1E7 
     * @param alt Altitude (AMSL, not WGS84), in m (positive for up) 
     * @param hdop GPS HDOP horizontal dilution of position in m 
     * @param vdop GPS VDOP vertical dilution of position in m 
     * @param vn GPS velocity in m/s in NORTH direction in earth-fixed NED frame 
     * @param ve GPS velocity in m/s in EAST direction in earth-fixed NED frame 
     * @param vd GPS velocity in m/s in DOWN direction in earth-fixed NED frame 
     * @param speedAccuracy GPS speed accuracy in m/s 
     * @param horizAccuracy GPS horizontal accuracy in m 
     * @param vertAccuracy GPS vertical accuracy in m 
     * @param ignoreFlags Flags indicating which fields to ignore (see {@link io.dronefleet.mavlink.common.GpsInputIgnoreFlags GpsInputIgnoreFlags} enum). All other fields 
     * must be provided. 
     * @param timeWeek GPS week number 
     * @param gpsId ID of the GPS for multiple GPS inputs 
     * @param fixType 0-1: no fix, 2: 2D fix, 3: 3D fix. 4: 3D with DGPS. 5: 3D with RTK 
     * @param satellitesVisible Number of satellites visible. 
     */
    default void sendGpsInput(BigInteger timeUsec, long timeWeekMs, int lat, int lon, float alt,
            float hdop, float vdop, float vn, float ve, float vd, float speedAccuracy,
            float horizAccuracy, float vertAccuracy, EnumFlagSet<GpsInputIgnoreFlags> ignoreFlags,
            int timeWeek, int gpsId, int fixType, int satellitesVisible) {
        outgoing().emit(GpsInput.builder()
                .timeUsec(timeUsec)
                .timeWeekMs(timeWeekMs)
                .lat(lat)
                .lon(lon)
                .alt(alt)
                .hdop(hdop)
                .vdop(vdop)
                .vn(vn)
                .ve(ve)
                .vd(vd)
                .speedAccuracy(speedAccuracy)
                .horizAccuracy(horizAccuracy)
                .vertAccuracy(vertAccuracy)
                .ignoreFlags(ignoreFlags)
                .timeWeek(timeWeek)
                .gpsId(gpsId)
                .fixType(fixType)
                .satellitesVisible(satellitesVisible)
                .build());
    }

    /**
     * Set the mission item with sequence number seq as current item. This means that the MAV will 
     * continue to this mission item on the shortest path (not following the mission items 
     * in-between). 
     * @param seq Sequence 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     */
    default void sendMissionSetCurrent(int seq, int targetSystem, int targetComponent) {
        outgoing().emit(MissionSetCurrent.builder()
                .seq(seq)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .build());
    }

    /**
     * The PPM values of the RC channels received. The standard PPM modulation is as follows: 1000 
     * microseconds: 0%, 2000 microseconds: 100%. Individual receivers/transmitters might 
     * violate this specification. 
     * @param timeBootMs Timestamp (milliseconds since system boot) 
     * @param chan1Raw RC channel 1 value, in microseconds. A value of UINT16_MAX implies the channel is unused. 
     * @param chan2Raw RC channel 2 value, in microseconds. A value of UINT16_MAX implies the channel is unused. 
     * @param chan3Raw RC channel 3 value, in microseconds. A value of UINT16_MAX implies the channel is unused. 
     * @param chan4Raw RC channel 4 value, in microseconds. A value of UINT16_MAX implies the channel is unused. 
     * @param chan5Raw RC channel 5 value, in microseconds. A value of UINT16_MAX implies the channel is unused. 
     * @param chan6Raw RC channel 6 value, in microseconds. A value of UINT16_MAX implies the channel is unused. 
     * @param chan7Raw RC channel 7 value, in microseconds. A value of UINT16_MAX implies the channel is unused. 
     * @param chan8Raw RC channel 8 value, in microseconds. A value of UINT16_MAX implies the channel is unused. 
     * @param chan9Raw RC channel 9 value, in microseconds. A value of UINT16_MAX implies the channel is unused. 
     * @param chan10Raw RC channel 10 value, in microseconds. A value of UINT16_MAX implies the channel is unused. 
     * @param chan11Raw RC channel 11 value, in microseconds. A value of UINT16_MAX implies the channel is unused. 
     * @param chan12Raw RC channel 12 value, in microseconds. A value of UINT16_MAX implies the channel is unused. 
     * @param chan13Raw RC channel 13 value, in microseconds. A value of UINT16_MAX implies the channel is unused. 
     * @param chan14Raw RC channel 14 value, in microseconds. A value of UINT16_MAX implies the channel is unused. 
     * @param chan15Raw RC channel 15 value, in microseconds. A value of UINT16_MAX implies the channel is unused. 
     * @param chan16Raw RC channel 16 value, in microseconds. A value of UINT16_MAX implies the channel is unused. 
     * @param chan17Raw RC channel 17 value, in microseconds. A value of UINT16_MAX implies the channel is unused. 
     * @param chan18Raw RC channel 18 value, in microseconds. A value of UINT16_MAX implies the channel is unused. 
     * @param chancount Total number of RC channels being received. This can be larger than 18, indicating that more 
     * channels are available but not given in this message. This value should be 0 when no RC channels 
     * are available. 
     * @param rssi Receive signal strength indicator, 0: 0%, 100: 100%, 255: invalid/unknown. 
     */
    default void sendRcChannels(long timeBootMs, int chan1Raw, int chan2Raw, int chan3Raw,
            int chan4Raw, int chan5Raw, int chan6Raw, int chan7Raw, int chan8Raw, int chan9Raw,
            int chan10Raw, int chan11Raw, int chan12Raw, int chan13Raw, int chan14Raw,
            int chan15Raw, int chan16Raw, int chan17Raw, int chan18Raw, int chancount, int rssi) {
        outgoing().emit(RcChannels.builder()
                .timeBootMs(timeBootMs)
                .chan1Raw(chan1Raw)
                .chan2Raw(chan2Raw)
                .chan3Raw(chan3Raw)
                .chan4Raw(chan4Raw)
                .chan5Raw(chan5Raw)
                .chan6Raw(chan6Raw)
                .chan7Raw(chan7Raw)
                .chan8Raw(chan8Raw)
                .chan9Raw(chan9Raw)
                .chan10Raw(chan10Raw)
                .chan11Raw(chan11Raw)
                .chan12Raw(chan12Raw)
                .chan13Raw(chan13Raw)
                .chan14Raw(chan14Raw)
                .chan15Raw(chan15Raw)
                .chan16Raw(chan16Raw)
                .chan17Raw(chan17Raw)
                .chan18Raw(chan18Raw)
                .chancount(chancount)
                .rssi(rssi)
                .build());
    }

    /**
     * data for injecting into the onboard GPS (used for DGPS) 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param len data length 
     * @param data raw data (110 is enough for 12 satellites of RTCMv2) 
     */
    default void sendGpsInjectData(int targetSystem, int targetComponent, int len, byte[] data) {
        outgoing().emit(GpsInjectData.builder()
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .len(len)
                .data(data)
                .build());
    }

    /**
     * Set the vehicle attitude and body angular rates. 
     * @param timeUsec Timestamp (micros since boot or Unix epoch) 
     * @param controls Actuator controls. Normed to -1..+1 where 0 is neutral position. Throttle for single rotation 
     * direction motors is 0..1, negative range for reverse direction. Standard mapping for 
     * attitude controls (group 0): (index 0-7): roll, pitch, yaw, throttle, flaps, spoilers, 
     * airbrakes, landing gear. Load a pass-through mixer to repurpose them as generic outputs. 
     * @param groupMlx Actuator group. The "_mlx" indicates this is a multi-instance message and a MAVLink parser 
     * should use this field to difference between instances. 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     */
    default void sendSetActuatorControlTarget(BigInteger timeUsec, List<Float> controls,
            int groupMlx, int targetSystem, int targetComponent) {
        outgoing().emit(SetActuatorControlTarget.builder()
                .timeUsec(timeUsec)
                .controls(controls)
                .groupMlx(groupMlx)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .build());
    }

    /**
     * Odometry message to communicate odometry information with an external interface. Fits ROS 
     * REP 147 standard for aerial vehicles (http://www.ros.org/reps/rep-0147.html). 
     * @param timeUsec Timestamp (microseconds since system boot or since UNIX epoch). 
     * @param x X Position 
     * @param y Y Position 
     * @param z Z Position 
     * @param q Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation) 
     * @param vx X linear speed 
     * @param vy Y linear speed 
     * @param vz Z linear speed 
     * @param rollspeed Roll angular speed 
     * @param pitchspeed Pitch angular speed 
     * @param yawspeed Yaw angular speed 
     * @param poseCovariance Pose (states: x, y, z, roll, pitch, yaw) covariance matrix upper right triangle (first six 
     * entries are the first ROW, next five entries are the second ROW, etc.) 
     * @param twistCovariance Twist (states: vx, vy, vz, rollspeed, pitchspeed, yawspeed) covariance matrix upper right 
     * triangle (first six entries are the first ROW, next five entries are the second ROW, etc.) 
     * @param frameId Coordinate frame of reference for the pose data, as defined by {@link io.dronefleet.mavlink.common.MavFrame MavFrame} enum. 
     * @param childFrameId Coordinate frame of reference for the velocity in free space (twist) data, as defined by 
     * {@link io.dronefleet.mavlink.common.MavFrame MavFrame} enum. 
     */
    default void sendOdometry(BigInteger timeUsec, float x, float y, float z, List<Float> q,
            float vx, float vy, float vz, float rollspeed, float pitchspeed, float yawspeed,
            List<Float> poseCovariance, List<Float> twistCovariance, MavFrame frameId,
            MavFrame childFrameId) {
        outgoing().emit(Odometry.builder()
                .timeUsec(timeUsec)
                .x(x)
                .y(y)
                .z(z)
                .q(q)
                .vx(vx)
                .vy(vy)
                .vz(vz)
                .rollspeed(rollspeed)
                .pitchspeed(pitchspeed)
                .yawspeed(yawspeed)
                .poseCovariance(poseCovariance)
                .twistCovariance(twistCovariance)
                .frameId(frameId)
                .childFrameId(childFrameId)
                .build());
    }

    /**
     * WIP: Information about video stream 
     * @param framerate Frames per second 
     * @param bitrate Bit rate in bits per second 
     * @param resolutionH Resolution horizontal in pixels 
     * @param resolutionV Resolution vertical in pixels 
     * @param rotation Video image rotation clockwise 
     * @param cameraId Camera ID (1 for first, 2 for second, etc.) 
     * @param status Current status of video streaming (0: not running, 1: in progress) 
     * @param uri Video stream URI 
     */
    default void sendVideoStreamInformation(float framerate, long bitrate, int resolutionH,
            int resolutionV, int rotation, int cameraId, int status, String uri) {
        outgoing().emit(VideoStreamInformation.builder()
                .framerate(framerate)
                .bitrate(bitrate)
                .resolutionH(resolutionH)
                .resolutionV(resolutionV)
                .rotation(rotation)
                .cameraId(cameraId)
                .status(status)
                .uri(uri)
                .build());
    }

    /**
     * The offset in X, Y, Z and yaw between the {@link io.dronefleet.mavlink.common.LocalPositionNed LocalPositionNed} messages of MAV X and the global 
     * coordinate frame in NED coordinates. Coordinate frame is right-handed, Z-axis down 
     * (aeronautical frame, NED / north-east-down convention) 
     * @param timeBootMs Timestamp (milliseconds since system boot) 
     * @param x X Position 
     * @param y Y Position 
     * @param z Z Position 
     * @param roll Roll 
     * @param pitch Pitch 
     * @param yaw Yaw 
     */
    default void sendLocalPositionNedSystemGlobalOffset(long timeBootMs, float x, float y, float z,
            float roll, float pitch, float yaw) {
        outgoing().emit(LocalPositionNedSystemGlobalOffset.builder()
                .timeBootMs(timeBootMs)
                .x(x)
                .y(y)
                .z(z)
                .roll(roll)
                .pitch(pitch)
                .yaw(yaw)
                .build());
    }

    /**
     * The autopilot is requesting a resource (file, binary, other type of data) 
     * @param requestId Request ID. This ID should be re-used when sending back URI contents 
     * @param uriType The type of requested URI. 0 = a file via URL. 1 = a UAVCAN binary 
     * @param uri The requested unique resource identifier (URI). It is not necessarily a straight domain name 
     * (depends on the URI type enum) 
     * @param transferType The way the autopilot wants to receive the URI. 0 = MAVLink FTP. 1 = binary stream. 
     * @param storage The storage path the autopilot wants the URI to be stored in. Will only be valid if the 
     * transfer_type has a storage associated (e.g. MAVLink FTP). 
     */
    default void sendResourceRequest(int requestId, int uriType, byte[] uri, int transferType,
            byte[] storage) {
        outgoing().emit(ResourceRequest.builder()
                .requestId(requestId)
                .uriType(uriType)
                .uri(uri)
                .transferType(transferType)
                .storage(storage)
                .build());
    }

    /**
     * WIP: Message that sets video stream settings 
     * @param framerate Frames per second (set to -1 for highest framerate possible) 
     * @param bitrate Bit rate in bits per second (set to -1 for auto) 
     * @param resolutionH Resolution horizontal in pixels (set to -1 for highest resolution possible) 
     * @param resolutionV Resolution vertical in pixels (set to -1 for highest resolution possible) 
     * @param rotation Video image rotation clockwise (0-359 degrees) 
     * @param targetSystem system ID of the target 
     * @param targetComponent component ID of the target 
     * @param cameraId Camera ID (1 for first, 2 for second, etc.) 
     * @param uri Video stream URI 
     */
    default void sendSetVideoStreamSettings(float framerate, long bitrate, int resolutionH,
            int resolutionV, int rotation, int targetSystem, int targetComponent, int cameraId,
            String uri) {
        outgoing().emit(SetVideoStreamSettings.builder()
                .framerate(framerate)
                .bitrate(bitrate)
                .resolutionH(resolutionH)
                .resolutionV(resolutionV)
                .rotation(rotation)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .cameraId(cameraId)
                .uri(uri)
                .build());
    }

    final class Impl extends AbstractMavlinkVehicle implements CommonVehicle {
        Impl(int systemId, EventSource<Object> incoming, EventEmitter<Object> outgoing) {
            super(systemId, incoming, outgoing);
        }
    }
}
