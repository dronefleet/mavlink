package io.dronefleet.mavlink.matrixpilot;

import com.benbarkay.events.EventEmitter;
import com.benbarkay.events.EventSource;
import io.dronefleet.mavlink.common.CommonVehicle;
import io.dronefleet.mavlink.vehicle.AbstractMavlinkVehicle;
import java.lang.Integer;
import java.lang.Object;
import java.util.List;

public interface MatrixpilotVehicle extends CommonVehicle {
    /**
     * Backwards compatible version of SERIAL_UDB_EXTRA F22 format 
     * @param sueAccelXAtCalibration SUE X accelerometer at calibration time 
     * @param sueAccelYAtCalibration SUE Y accelerometer at calibration time 
     * @param sueAccelZAtCalibration SUE Z accelerometer at calibration time 
     * @param sueGyroXAtCalibration SUE X gyro at calibration time 
     * @param sueGyroYAtCalibration SUE Y gyro at calibration time 
     * @param sueGyroZAtCalibration SUE Z gyro at calibration time 
     */
    default void sendSerialUdbExtraF22(int sueAccelXAtCalibration, int sueAccelYAtCalibration,
            int sueAccelZAtCalibration, int sueGyroXAtCalibration, int sueGyroYAtCalibration,
            int sueGyroZAtCalibration) {
        outgoing().emit(SerialUdbExtraF22.builder()
                .sueAccelXAtCalibration(sueAccelXAtCalibration)
                .sueAccelYAtCalibration(sueAccelYAtCalibration)
                .sueAccelZAtCalibration(sueAccelZAtCalibration)
                .sueGyroXAtCalibration(sueGyroXAtCalibration)
                .sueGyroYAtCalibration(sueGyroYAtCalibration)
                .sueGyroZAtCalibration(sueGyroZAtCalibration)
                .build());
    }

    /**
     * The airspeed measured by sensors and IMU 
     * @param timeBootMs Timestamp (milliseconds since system boot) 
     * @param airspeedImu Airspeed estimate from IMU, cm/s 
     * @param airspeedPitot Pitot measured forward airpseed, cm/s 
     * @param airspeedHotWire Hot wire anenometer measured airspeed, cm/s 
     * @param airspeedUltrasonic Ultrasonic measured airspeed, cm/s 
     * @param aoa Angle of attack sensor, degrees * 10 
     * @param aoy Yaw angle sensor, degrees * 10 
     */
    default void sendAirspeeds(long timeBootMs, int airspeedImu, int airspeedPitot,
            int airspeedHotWire, int airspeedUltrasonic, int aoa, int aoy) {
        outgoing().emit(Airspeeds.builder()
                .timeBootMs(timeBootMs)
                .airspeedImu(airspeedImu)
                .airspeedPitot(airspeedPitot)
                .airspeedHotWire(airspeedHotWire)
                .airspeedUltrasonic(airspeedUltrasonic)
                .aoa(aoa)
                .aoy(aoy)
                .build());
    }

    /**
     * Depreciated but used as a compiler flag. Do not remove 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     */
    default void sendFlexifunctionSet(int targetSystem, int targetComponent) {
        outgoing().emit(FlexifunctionSet.builder()
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .build());
    }

    /**
     * Flexifunction type and parameters for component at function index from buffer 
     * @param funcIndex Function index 
     * @param funcCount Total count of functions 
     * @param dataAddress Address in the flexifunction data, Set to 0xFFFF to use address in target memory 
     * @param dataSize Size of the 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param data Settings data 
     */
    default void sendFlexifunctionBufferFunction(int funcIndex, int funcCount, int dataAddress,
            int dataSize, int targetSystem, int targetComponent, List<Integer> data) {
        outgoing().emit(FlexifunctionBufferFunction.builder()
                .funcIndex(funcIndex)
                .funcCount(funcCount)
                .dataAddress(dataAddress)
                .dataSize(dataSize)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .data(data)
                .build());
    }

    /**
     * Backwards compatible version of SERIAL_UDB_EXTRA - F2: Part B 
     * @param sueTime Serial UDB Extra Time 
     * @param sueFlags Serial UDB Extra Status Flags 
     * @param sueBaromPress SUE barometer pressure 
     * @param sueBaromAlt SUE barometer altitude 
     * @param suePwmInput1 Serial UDB Extra PWM Input Channel 1 
     * @param suePwmInput2 Serial UDB Extra PWM Input Channel 2 
     * @param suePwmInput3 Serial UDB Extra PWM Input Channel 3 
     * @param suePwmInput4 Serial UDB Extra PWM Input Channel 4 
     * @param suePwmInput5 Serial UDB Extra PWM Input Channel 5 
     * @param suePwmInput6 Serial UDB Extra PWM Input Channel 6 
     * @param suePwmInput7 Serial UDB Extra PWM Input Channel 7 
     * @param suePwmInput8 Serial UDB Extra PWM Input Channel 8 
     * @param suePwmInput9 Serial UDB Extra PWM Input Channel 9 
     * @param suePwmInput10 Serial UDB Extra PWM Input Channel 10 
     * @param suePwmInput11 Serial UDB Extra PWM Input Channel 11 
     * @param suePwmInput12 Serial UDB Extra PWM Input Channel 12 
     * @param suePwmOutput1 Serial UDB Extra PWM Output Channel 1 
     * @param suePwmOutput2 Serial UDB Extra PWM Output Channel 2 
     * @param suePwmOutput3 Serial UDB Extra PWM Output Channel 3 
     * @param suePwmOutput4 Serial UDB Extra PWM Output Channel 4 
     * @param suePwmOutput5 Serial UDB Extra PWM Output Channel 5 
     * @param suePwmOutput6 Serial UDB Extra PWM Output Channel 6 
     * @param suePwmOutput7 Serial UDB Extra PWM Output Channel 7 
     * @param suePwmOutput8 Serial UDB Extra PWM Output Channel 8 
     * @param suePwmOutput9 Serial UDB Extra PWM Output Channel 9 
     * @param suePwmOutput10 Serial UDB Extra PWM Output Channel 10 
     * @param suePwmOutput11 Serial UDB Extra PWM Output Channel 11 
     * @param suePwmOutput12 Serial UDB Extra PWM Output Channel 12 
     * @param sueImuLocationX Serial UDB Extra IMU Location X 
     * @param sueImuLocationY Serial UDB Extra IMU Location Y 
     * @param sueImuLocationZ Serial UDB Extra IMU Location Z 
     * @param sueLocationErrorEarthX Serial UDB Location Error Earth X 
     * @param sueLocationErrorEarthY Serial UDB Location Error Earth Y 
     * @param sueLocationErrorEarthZ Serial UDB Location Error Earth Z 
     * @param sueOscFails Serial UDB Extra Oscillator Failure Count 
     * @param sueImuVelocityX Serial UDB Extra IMU Velocity X 
     * @param sueImuVelocityY Serial UDB Extra IMU Velocity Y 
     * @param sueImuVelocityZ Serial UDB Extra IMU Velocity Z 
     * @param sueWaypointGoalX Serial UDB Extra Current Waypoint Goal X 
     * @param sueWaypointGoalY Serial UDB Extra Current Waypoint Goal Y 
     * @param sueWaypointGoalZ Serial UDB Extra Current Waypoint Goal Z 
     * @param sueAeroX Aeroforce in UDB X Axis 
     * @param sueAeroY Aeroforce in UDB Y Axis 
     * @param sueAeroZ Aeroforce in UDB Z axis 
     * @param sueBaromTemp SUE barometer temperature 
     * @param sueBatVolt SUE battery voltage 
     * @param sueBatAmp SUE battery current 
     * @param sueBatAmpHours SUE battery milli amp hours used 
     * @param sueDesiredHeight Sue autopilot desired height 
     * @param sueMemoryStackFree Serial UDB Extra Stack Memory Free 
     */
    default void sendSerialUdbExtraF2B(long sueTime, long sueFlags, int sueBaromPress,
            int sueBaromAlt, int suePwmInput1, int suePwmInput2, int suePwmInput3, int suePwmInput4,
            int suePwmInput5, int suePwmInput6, int suePwmInput7, int suePwmInput8,
            int suePwmInput9, int suePwmInput10, int suePwmInput11, int suePwmInput12,
            int suePwmOutput1, int suePwmOutput2, int suePwmOutput3, int suePwmOutput4,
            int suePwmOutput5, int suePwmOutput6, int suePwmOutput7, int suePwmOutput8,
            int suePwmOutput9, int suePwmOutput10, int suePwmOutput11, int suePwmOutput12,
            int sueImuLocationX, int sueImuLocationY, int sueImuLocationZ,
            int sueLocationErrorEarthX, int sueLocationErrorEarthY, int sueLocationErrorEarthZ,
            int sueOscFails, int sueImuVelocityX, int sueImuVelocityY, int sueImuVelocityZ,
            int sueWaypointGoalX, int sueWaypointGoalY, int sueWaypointGoalZ, int sueAeroX,
            int sueAeroY, int sueAeroZ, int sueBaromTemp, int sueBatVolt, int sueBatAmp,
            int sueBatAmpHours, int sueDesiredHeight, int sueMemoryStackFree) {
        outgoing().emit(SerialUdbExtraF2B.builder()
                .sueTime(sueTime)
                .sueFlags(sueFlags)
                .sueBaromPress(sueBaromPress)
                .sueBaromAlt(sueBaromAlt)
                .suePwmInput1(suePwmInput1)
                .suePwmInput2(suePwmInput2)
                .suePwmInput3(suePwmInput3)
                .suePwmInput4(suePwmInput4)
                .suePwmInput5(suePwmInput5)
                .suePwmInput6(suePwmInput6)
                .suePwmInput7(suePwmInput7)
                .suePwmInput8(suePwmInput8)
                .suePwmInput9(suePwmInput9)
                .suePwmInput10(suePwmInput10)
                .suePwmInput11(suePwmInput11)
                .suePwmInput12(suePwmInput12)
                .suePwmOutput1(suePwmOutput1)
                .suePwmOutput2(suePwmOutput2)
                .suePwmOutput3(suePwmOutput3)
                .suePwmOutput4(suePwmOutput4)
                .suePwmOutput5(suePwmOutput5)
                .suePwmOutput6(suePwmOutput6)
                .suePwmOutput7(suePwmOutput7)
                .suePwmOutput8(suePwmOutput8)
                .suePwmOutput9(suePwmOutput9)
                .suePwmOutput10(suePwmOutput10)
                .suePwmOutput11(suePwmOutput11)
                .suePwmOutput12(suePwmOutput12)
                .sueImuLocationX(sueImuLocationX)
                .sueImuLocationY(sueImuLocationY)
                .sueImuLocationZ(sueImuLocationZ)
                .sueLocationErrorEarthX(sueLocationErrorEarthX)
                .sueLocationErrorEarthY(sueLocationErrorEarthY)
                .sueLocationErrorEarthZ(sueLocationErrorEarthZ)
                .sueOscFails(sueOscFails)
                .sueImuVelocityX(sueImuVelocityX)
                .sueImuVelocityY(sueImuVelocityY)
                .sueImuVelocityZ(sueImuVelocityZ)
                .sueWaypointGoalX(sueWaypointGoalX)
                .sueWaypointGoalY(sueWaypointGoalY)
                .sueWaypointGoalZ(sueWaypointGoalZ)
                .sueAeroX(sueAeroX)
                .sueAeroY(sueAeroY)
                .sueAeroZ(sueAeroZ)
                .sueBaromTemp(sueBaromTemp)
                .sueBatVolt(sueBatVolt)
                .sueBatAmp(sueBatAmp)
                .sueBatAmpHours(sueBatAmpHours)
                .sueDesiredHeight(sueDesiredHeight)
                .sueMemoryStackFree(sueMemoryStackFree)
                .build());
    }

    /**
     * Backwards compatible version of SERIAL_UDB_EXTRA F15 format 
     * @param sueIdVehicleModelName Serial UDB Extra Model Name Of Vehicle 
     * @param sueIdVehicleRegistration Serial UDB Extra Registraton Number of Vehicle 
     */
    default void sendSerialUdbExtraF15(byte[] sueIdVehicleModelName,
            byte[] sueIdVehicleRegistration) {
        outgoing().emit(SerialUdbExtraF15.builder()
                .sueIdVehicleModelName(sueIdVehicleModelName)
                .sueIdVehicleRegistration(sueIdVehicleRegistration)
                .build());
    }

    /**
     * Backwards compatible MAVLink version of SERIAL_UDB_EXTRA - F2: Format Part A 
     * @param sueTime Serial UDB Extra Time 
     * @param sueLatitude Serial UDB Extra Latitude 
     * @param sueLongitude Serial UDB Extra Longitude 
     * @param sueAltitude Serial UDB Extra Altitude 
     * @param sueWaypointIndex Serial UDB Extra Waypoint Index 
     * @param sueRmat0 Serial UDB Extra Rmat 0 
     * @param sueRmat1 Serial UDB Extra Rmat 1 
     * @param sueRmat2 Serial UDB Extra Rmat 2 
     * @param sueRmat3 Serial UDB Extra Rmat 3 
     * @param sueRmat4 Serial UDB Extra Rmat 4 
     * @param sueRmat5 Serial UDB Extra Rmat 5 
     * @param sueRmat6 Serial UDB Extra Rmat 6 
     * @param sueRmat7 Serial UDB Extra Rmat 7 
     * @param sueRmat8 Serial UDB Extra Rmat 8 
     * @param sueCog Serial UDB Extra GPS Course Over Ground 
     * @param sueSog Serial UDB Extra Speed Over Ground 
     * @param sueCpuLoad Serial UDB Extra CPU Load 
     * @param sueAirSpeed3dimu Serial UDB Extra 3D IMU Air Speed 
     * @param sueEstimatedWind0 Serial UDB Extra Estimated Wind 0 
     * @param sueEstimatedWind1 Serial UDB Extra Estimated Wind 1 
     * @param sueEstimatedWind2 Serial UDB Extra Estimated Wind 2 
     * @param sueMagfieldearth0 Serial UDB Extra Magnetic Field Earth 0 
     * @param sueMagfieldearth1 Serial UDB Extra Magnetic Field Earth 1 
     * @param sueMagfieldearth2 Serial UDB Extra Magnetic Field Earth 2 
     * @param sueSvs Serial UDB Extra Number of Sattelites in View 
     * @param sueHdop Serial UDB Extra GPS Horizontal Dilution of Precision 
     * @param sueStatus Serial UDB Extra Status 
     */
    default void sendSerialUdbExtraF2A(long sueTime, int sueLatitude, int sueLongitude,
            int sueAltitude, int sueWaypointIndex, int sueRmat0, int sueRmat1, int sueRmat2,
            int sueRmat3, int sueRmat4, int sueRmat5, int sueRmat6, int sueRmat7, int sueRmat8,
            int sueCog, int sueSog, int sueCpuLoad, int sueAirSpeed3dimu, int sueEstimatedWind0,
            int sueEstimatedWind1, int sueEstimatedWind2, int sueMagfieldearth0,
            int sueMagfieldearth1, int sueMagfieldearth2, int sueSvs, int sueHdop, int sueStatus) {
        outgoing().emit(SerialUdbExtraF2A.builder()
                .sueTime(sueTime)
                .sueLatitude(sueLatitude)
                .sueLongitude(sueLongitude)
                .sueAltitude(sueAltitude)
                .sueWaypointIndex(sueWaypointIndex)
                .sueRmat0(sueRmat0)
                .sueRmat1(sueRmat1)
                .sueRmat2(sueRmat2)
                .sueRmat3(sueRmat3)
                .sueRmat4(sueRmat4)
                .sueRmat5(sueRmat5)
                .sueRmat6(sueRmat6)
                .sueRmat7(sueRmat7)
                .sueRmat8(sueRmat8)
                .sueCog(sueCog)
                .sueSog(sueSog)
                .sueCpuLoad(sueCpuLoad)
                .sueAirSpeed3dimu(sueAirSpeed3dimu)
                .sueEstimatedWind0(sueEstimatedWind0)
                .sueEstimatedWind1(sueEstimatedWind1)
                .sueEstimatedWind2(sueEstimatedWind2)
                .sueMagfieldearth0(sueMagfieldearth0)
                .sueMagfieldearth1(sueMagfieldearth1)
                .sueMagfieldearth2(sueMagfieldearth2)
                .sueSvs(sueSvs)
                .sueHdop(sueHdop)
                .sueStatus(sueStatus)
                .build());
    }

    /**
     * Backwards compatible version of SERIAL_UDB_EXTRA F16 format 
     * @param sueIdLeadPilot Serial UDB Extra Name of Expected Lead Pilot 
     * @param sueIdDiyDronesUrl Serial UDB Extra URL of Lead Pilot or Team 
     */
    default void sendSerialUdbExtraF16(byte[] sueIdLeadPilot, byte[] sueIdDiyDronesUrl) {
        outgoing().emit(SerialUdbExtraF16.builder()
                .sueIdLeadPilot(sueIdLeadPilot)
                .sueIdDiyDronesUrl(sueIdDiyDronesUrl)
                .build());
    }

    /**
     * Reqest reading of flexifunction data 
     * @param readReqType Type of flexifunction data requested 
     * @param dataIndex index into data where needed 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     */
    default void sendFlexifunctionReadReq(int readReqType, int dataIndex, int targetSystem,
            int targetComponent) {
        outgoing().emit(FlexifunctionReadReq.builder()
                .readReqType(readReqType)
                .dataIndex(dataIndex)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .build());
    }

    /**
     * Backwards compatible version of SERIAL_UDB_EXTRA F17 format 
     * @param sueFeedForward SUE Feed Forward Gain 
     * @param sueTurnRateNav SUE Max Turn Rate when Navigating 
     * @param sueTurnRateFbw SUE Max Turn Rate in Fly By Wire Mode 
     */
    default void sendSerialUdbExtraF17(float sueFeedForward, float sueTurnRateNav,
            float sueTurnRateFbw) {
        outgoing().emit(SerialUdbExtraF17.builder()
                .sueFeedForward(sueFeedForward)
                .sueTurnRateNav(sueTurnRateNav)
                .sueTurnRateFbw(sueTurnRateFbw)
                .build());
    }

    /**
     * Backwards compatible version of SERIAL_UDB_EXTRA F18 format 
     * @param angleOfAttackNormal SUE Angle of Attack Normal 
     * @param angleOfAttackInverted SUE Angle of Attack Inverted 
     * @param elevatorTrimNormal SUE Elevator Trim Normal 
     * @param elevatorTrimInverted SUE Elevator Trim Inverted 
     * @param referenceSpeed SUE reference_speed 
     */
    default void sendSerialUdbExtraF18(float angleOfAttackNormal, float angleOfAttackInverted,
            float elevatorTrimNormal, float elevatorTrimInverted, float referenceSpeed) {
        outgoing().emit(SerialUdbExtraF18.builder()
                .angleOfAttackNormal(angleOfAttackNormal)
                .angleOfAttackInverted(angleOfAttackInverted)
                .elevatorTrimNormal(elevatorTrimNormal)
                .elevatorTrimInverted(elevatorTrimInverted)
                .referenceSpeed(referenceSpeed)
                .build());
    }

    /**
     * Backwards compatible version of SERIAL_UDB_EXTRA F8: format 
     * @param sueHeightTargetMax Serial UDB Extra HEIGHT_TARGET_MAX 
     * @param sueHeightTargetMin Serial UDB Extra HEIGHT_TARGET_MIN 
     * @param sueAltHoldThrottleMin Serial UDB Extra ALT_HOLD_THROTTLE_MIN 
     * @param sueAltHoldThrottleMax Serial UDB Extra ALT_HOLD_THROTTLE_MAX 
     * @param sueAltHoldPitchMin Serial UDB Extra ALT_HOLD_PITCH_MIN 
     * @param sueAltHoldPitchMax Serial UDB Extra ALT_HOLD_PITCH_MAX 
     * @param sueAltHoldPitchHigh Serial UDB Extra ALT_HOLD_PITCH_HIGH 
     */
    default void sendSerialUdbExtraF8(float sueHeightTargetMax, float sueHeightTargetMin,
            float sueAltHoldThrottleMin, float sueAltHoldThrottleMax, float sueAltHoldPitchMin,
            float sueAltHoldPitchMax, float sueAltHoldPitchHigh) {
        outgoing().emit(SerialUdbExtraF8.builder()
                .sueHeightTargetMax(sueHeightTargetMax)
                .sueHeightTargetMin(sueHeightTargetMin)
                .sueAltHoldThrottleMin(sueAltHoldThrottleMin)
                .sueAltHoldThrottleMax(sueAltHoldThrottleMax)
                .sueAltHoldPitchMin(sueAltHoldPitchMin)
                .sueAltHoldPitchMax(sueAltHoldPitchMax)
                .sueAltHoldPitchHigh(sueAltHoldPitchHigh)
                .build());
    }

    /**
     * Backwards compatible version of SERIAL_UDB_EXTRA F13: format 
     * @param sueLatOrigin Serial UDB Extra MP Origin Latitude 
     * @param sueLonOrigin Serial UDB Extra MP Origin Longitude 
     * @param sueAltOrigin Serial UDB Extra MP Origin Altitude Above Sea Level 
     * @param sueWeekNo Serial UDB Extra GPS Week Number 
     */
    default void sendSerialUdbExtraF13(int sueLatOrigin, int sueLonOrigin, int sueAltOrigin,
            int sueWeekNo) {
        outgoing().emit(SerialUdbExtraF13.builder()
                .sueLatOrigin(sueLatOrigin)
                .sueLonOrigin(sueLonOrigin)
                .sueAltOrigin(sueAltOrigin)
                .sueWeekNo(sueWeekNo)
                .build());
    }

    /**
     * Backwards compatible version of SERIAL_UDB_EXTRA F14: format 
     * @param sueTrapSource Serial UDB Extra Type Program Address of Last Trap 
     * @param sueRcon Serial UDB Extra Reboot Register of DSPIC 
     * @param sueTrapFlags Serial UDB Extra Last dspic Trap Flags 
     * @param sueOscFailCount Serial UDB Extra Number of Ocillator Failures 
     * @param sueWindEstimation Serial UDB Extra Wind Estimation Enabled 
     * @param sueGpsType Serial UDB Extra Type of GPS Unit 
     * @param sueDr Serial UDB Extra Dead Reckoning Enabled 
     * @param sueBoardType Serial UDB Extra Type of UDB Hardware 
     * @param sueAirframe Serial UDB Extra Type of Airframe 
     * @param sueClockConfig Serial UDB Extra UDB Internal Clock Configuration 
     * @param sueFlightPlanType Serial UDB Extra Type of Flight Plan 
     */
    default void sendSerialUdbExtraF14(long sueTrapSource, int sueRcon, int sueTrapFlags,
            int sueOscFailCount, int sueWindEstimation, int sueGpsType, int sueDr, int sueBoardType,
            int sueAirframe, int sueClockConfig, int sueFlightPlanType) {
        outgoing().emit(SerialUdbExtraF14.builder()
                .sueTrapSource(sueTrapSource)
                .sueRcon(sueRcon)
                .sueTrapFlags(sueTrapFlags)
                .sueOscFailCount(sueOscFailCount)
                .sueWindEstimation(sueWindEstimation)
                .sueGpsType(sueGpsType)
                .sueDr(sueDr)
                .sueBoardType(sueBoardType)
                .sueAirframe(sueAirframe)
                .sueClockConfig(sueClockConfig)
                .sueFlightPlanType(sueFlightPlanType)
                .build());
    }

    /**
     * Backwards compatible version of SERIAL_UDB_EXTRA F5: format 
     * @param sueYawkpAileron Serial UDB YAWKP_AILERON Gain for Proporional control of navigation 
     * @param sueYawkdAileron Serial UDB YAWKD_AILERON Gain for Rate control of navigation 
     * @param sueRollkp Serial UDB Extra ROLLKP Gain for Proportional control of roll stabilization 
     * @param sueRollkd Serial UDB Extra ROLLKD Gain for Rate control of roll stabilization 
     */
    default void sendSerialUdbExtraF5(float sueYawkpAileron, float sueYawkdAileron, float sueRollkp,
            float sueRollkd) {
        outgoing().emit(SerialUdbExtraF5.builder()
                .sueYawkpAileron(sueYawkpAileron)
                .sueYawkdAileron(sueYawkdAileron)
                .sueRollkp(sueRollkp)
                .sueRollkd(sueRollkd)
                .build());
    }

    /**
     * Backwards compatible version of SERIAL_UDB_EXTRA F4: format 
     * @param sueRollStabilizationAilerons Serial UDB Extra Roll Stabilization with Ailerons Enabled 
     * @param sueRollStabilizationRudder Serial UDB Extra Roll Stabilization with Rudder Enabled 
     * @param suePitchStabilization Serial UDB Extra Pitch Stabilization Enabled 
     * @param sueYawStabilizationRudder Serial UDB Extra Yaw Stabilization using Rudder Enabled 
     * @param sueYawStabilizationAileron Serial UDB Extra Yaw Stabilization using Ailerons Enabled 
     * @param sueAileronNavigation Serial UDB Extra Navigation with Ailerons Enabled 
     * @param sueRudderNavigation Serial UDB Extra Navigation with Rudder Enabled 
     * @param sueAltitudeholdStabilized Serial UDB Extra Type of Alitude Hold when in Stabilized Mode 
     * @param sueAltitudeholdWaypoint Serial UDB Extra Type of Alitude Hold when in Waypoint Mode 
     * @param sueRacingMode Serial UDB Extra Firmware racing mode enabled 
     */
    default void sendSerialUdbExtraF4(int sueRollStabilizationAilerons,
            int sueRollStabilizationRudder, int suePitchStabilization,
            int sueYawStabilizationRudder, int sueYawStabilizationAileron, int sueAileronNavigation,
            int sueRudderNavigation, int sueAltitudeholdStabilized, int sueAltitudeholdWaypoint,
            int sueRacingMode) {
        outgoing().emit(SerialUdbExtraF4.builder()
                .sueRollStabilizationAilerons(sueRollStabilizationAilerons)
                .sueRollStabilizationRudder(sueRollStabilizationRudder)
                .suePitchStabilization(suePitchStabilization)
                .sueYawStabilizationRudder(sueYawStabilizationRudder)
                .sueYawStabilizationAileron(sueYawStabilizationAileron)
                .sueAileronNavigation(sueAileronNavigation)
                .sueRudderNavigation(sueRudderNavigation)
                .sueAltitudeholdStabilized(sueAltitudeholdStabilized)
                .sueAltitudeholdWaypoint(sueAltitudeholdWaypoint)
                .sueRacingMode(sueRacingMode)
                .build());
    }

    /**
     * Backwards compatible version of SERIAL_UDB_EXTRA F7: format 
     * @param sueYawkpRudder Serial UDB YAWKP_RUDDER Gain for Proporional control of navigation 
     * @param sueYawkdRudder Serial UDB YAWKD_RUDDER Gain for Rate control of navigation 
     * @param sueRollkpRudder Serial UDB Extra ROLLKP_RUDDER Gain for Proportional control of roll stabilization 
     * @param sueRollkdRudder Serial UDB Extra ROLLKD_RUDDER Gain for Rate control of roll stabilization 
     * @param sueRudderBoost SERIAL UDB EXTRA Rudder Boost Gain to Manual Control when stabilized 
     * @param sueRtlPitchDown Serial UDB Extra Return To Landing - Angle to Pitch Plane Down 
     */
    default void sendSerialUdbExtraF7(float sueYawkpRudder, float sueYawkdRudder,
            float sueRollkpRudder, float sueRollkdRudder, float sueRudderBoost,
            float sueRtlPitchDown) {
        outgoing().emit(SerialUdbExtraF7.builder()
                .sueYawkpRudder(sueYawkpRudder)
                .sueYawkdRudder(sueYawkdRudder)
                .sueRollkpRudder(sueRollkpRudder)
                .sueRollkdRudder(sueRollkdRudder)
                .sueRudderBoost(sueRudderBoost)
                .sueRtlPitchDown(sueRtlPitchDown)
                .build());
    }

    /**
     * Backwards compatible version of SERIAL_UDB_EXTRA F6: format 
     * @param suePitchgain Serial UDB Extra PITCHGAIN Proportional Control 
     * @param suePitchkd Serial UDB Extra Pitch Rate Control 
     * @param sueRudderElevMix Serial UDB Extra Rudder to Elevator Mix 
     * @param sueRollElevMix Serial UDB Extra Roll to Elevator Mix 
     * @param sueElevatorBoost Gain For Boosting Manual Elevator control When Plane Stabilized 
     */
    default void sendSerialUdbExtraF6(float suePitchgain, float suePitchkd, float sueRudderElevMix,
            float sueRollElevMix, float sueElevatorBoost) {
        outgoing().emit(SerialUdbExtraF6.builder()
                .suePitchgain(suePitchgain)
                .suePitchkd(suePitchkd)
                .sueRudderElevMix(sueRudderElevMix)
                .sueRollElevMix(sueRollElevMix)
                .sueElevatorBoost(sueElevatorBoost)
                .build());
    }

    /**
     * Acknowldge sucess or failure of a flexifunction command 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param directoryType 0=inputs, 1=outputs 
     * @param startIndex index of first directory entry to write 
     * @param count count of directory entries to write 
     * @param directoryData Settings data 
     */
    default void sendFlexifunctionDirectory(int targetSystem, int targetComponent,
            int directoryType, int startIndex, int count, List<Integer> directoryData) {
        outgoing().emit(FlexifunctionDirectory.builder()
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .directoryType(directoryType)
                .startIndex(startIndex)
                .count(count)
                .directoryData(directoryData)
                .build());
    }

    /**
     * Backwards compatible version of SERIAL_UDB_EXTRA F19 format 
     * @param sueAileronOutputChannel SUE aileron output channel 
     * @param sueAileronReversed SUE aileron reversed 
     * @param sueElevatorOutputChannel SUE elevator output channel 
     * @param sueElevatorReversed SUE elevator reversed 
     * @param sueThrottleOutputChannel SUE throttle output channel 
     * @param sueThrottleReversed SUE throttle reversed 
     * @param sueRudderOutputChannel SUE rudder output channel 
     * @param sueRudderReversed SUE rudder reversed 
     */
    default void sendSerialUdbExtraF19(int sueAileronOutputChannel, int sueAileronReversed,
            int sueElevatorOutputChannel, int sueElevatorReversed, int sueThrottleOutputChannel,
            int sueThrottleReversed, int sueRudderOutputChannel, int sueRudderReversed) {
        outgoing().emit(SerialUdbExtraF19.builder()
                .sueAileronOutputChannel(sueAileronOutputChannel)
                .sueAileronReversed(sueAileronReversed)
                .sueElevatorOutputChannel(sueElevatorOutputChannel)
                .sueElevatorReversed(sueElevatorReversed)
                .sueThrottleOutputChannel(sueThrottleOutputChannel)
                .sueThrottleReversed(sueThrottleReversed)
                .sueRudderOutputChannel(sueRudderOutputChannel)
                .sueRudderReversed(sueRudderReversed)
                .build());
    }

    /**
     * The altitude measured by sensors and IMU 
     * @param timeBootMs Timestamp (milliseconds since system boot) 
     * @param altGps GPS altitude in meters, expressed as * 1000 (millimeters), above MSL 
     * @param altImu IMU altitude above ground in meters, expressed as * 1000 (millimeters) 
     * @param altBarometric barometeric altitude above ground in meters, expressed as * 1000 (millimeters) 
     * @param altOpticalFlow Optical flow altitude above ground in meters, expressed as * 1000 (millimeters) 
     * @param altRangeFinder Rangefinder Altitude above ground in meters, expressed as * 1000 (millimeters) 
     * @param altExtra Extra altitude above ground in meters, expressed as * 1000 (millimeters) 
     */
    default void sendAltitudes(long timeBootMs, int altGps, int altImu, int altBarometric,
            int altOpticalFlow, int altRangeFinder, int altExtra) {
        outgoing().emit(Altitudes.builder()
                .timeBootMs(timeBootMs)
                .altGps(altGps)
                .altImu(altImu)
                .altBarometric(altBarometric)
                .altOpticalFlow(altOpticalFlow)
                .altRangeFinder(altRangeFinder)
                .altExtra(altExtra)
                .build());
    }

    /**
     * Acknowldge sucess or failure of a flexifunction command 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param commandType Flexifunction command type 
     */
    default void sendFlexifunctionCommand(int targetSystem, int targetComponent, int commandType) {
        outgoing().emit(FlexifunctionCommand.builder()
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .commandType(commandType)
                .build());
    }

    /**
     * Acknowldge sucess or failure of a flexifunction command 
     * @param result result of acknowledge, 0=fail, 1=good 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param directoryType 0=inputs, 1=outputs 
     * @param startIndex index of first directory entry to write 
     * @param count count of directory entries to write 
     */
    default void sendFlexifunctionDirectoryAck(int result, int targetSystem, int targetComponent,
            int directoryType, int startIndex, int count) {
        outgoing().emit(FlexifunctionDirectoryAck.builder()
                .result(result)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .directoryType(directoryType)
                .startIndex(startIndex)
                .count(count)
                .build());
    }

    /**
     * Backwards compatible version of SERIAL_UDB_EXTRA F20 format 
     * @param sueTrimValueInput1 SUE UDB PWM Trim Value on Input 1 
     * @param sueTrimValueInput2 SUE UDB PWM Trim Value on Input 2 
     * @param sueTrimValueInput3 SUE UDB PWM Trim Value on Input 3 
     * @param sueTrimValueInput4 SUE UDB PWM Trim Value on Input 4 
     * @param sueTrimValueInput5 SUE UDB PWM Trim Value on Input 5 
     * @param sueTrimValueInput6 SUE UDB PWM Trim Value on Input 6 
     * @param sueTrimValueInput7 SUE UDB PWM Trim Value on Input 7 
     * @param sueTrimValueInput8 SUE UDB PWM Trim Value on Input 8 
     * @param sueTrimValueInput9 SUE UDB PWM Trim Value on Input 9 
     * @param sueTrimValueInput10 SUE UDB PWM Trim Value on Input 10 
     * @param sueTrimValueInput11 SUE UDB PWM Trim Value on Input 11 
     * @param sueTrimValueInput12 SUE UDB PWM Trim Value on Input 12 
     * @param sueNumberOfInputs SUE Number of Input Channels 
     */
    default void sendSerialUdbExtraF20(int sueTrimValueInput1, int sueTrimValueInput2,
            int sueTrimValueInput3, int sueTrimValueInput4, int sueTrimValueInput5,
            int sueTrimValueInput6, int sueTrimValueInput7, int sueTrimValueInput8,
            int sueTrimValueInput9, int sueTrimValueInput10, int sueTrimValueInput11,
            int sueTrimValueInput12, int sueNumberOfInputs) {
        outgoing().emit(SerialUdbExtraF20.builder()
                .sueTrimValueInput1(sueTrimValueInput1)
                .sueTrimValueInput2(sueTrimValueInput2)
                .sueTrimValueInput3(sueTrimValueInput3)
                .sueTrimValueInput4(sueTrimValueInput4)
                .sueTrimValueInput5(sueTrimValueInput5)
                .sueTrimValueInput6(sueTrimValueInput6)
                .sueTrimValueInput7(sueTrimValueInput7)
                .sueTrimValueInput8(sueTrimValueInput8)
                .sueTrimValueInput9(sueTrimValueInput9)
                .sueTrimValueInput10(sueTrimValueInput10)
                .sueTrimValueInput11(sueTrimValueInput11)
                .sueTrimValueInput12(sueTrimValueInput12)
                .sueNumberOfInputs(sueNumberOfInputs)
                .build());
    }

    /**
     * Flexifunction type and parameters for component at function index from buffer 
     * @param funcIndex Function index 
     * @param result result of acknowledge, 0=fail, 1=good 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     */
    default void sendFlexifunctionBufferFunctionAck(int funcIndex, int result, int targetSystem,
            int targetComponent) {
        outgoing().emit(FlexifunctionBufferFunctionAck.builder()
                .funcIndex(funcIndex)
                .result(result)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .build());
    }

    /**
     * Backwards compatible version of SERIAL_UDB_EXTRA F21 format 
     * @param sueAccelXOffset SUE X accelerometer offset 
     * @param sueAccelYOffset SUE Y accelerometer offset 
     * @param sueAccelZOffset SUE Z accelerometer offset 
     * @param sueGyroXOffset SUE X gyro offset 
     * @param sueGyroYOffset SUE Y gyro offset 
     * @param sueGyroZOffset SUE Z gyro offset 
     */
    default void sendSerialUdbExtraF21(int sueAccelXOffset, int sueAccelYOffset,
            int sueAccelZOffset, int sueGyroXOffset, int sueGyroYOffset, int sueGyroZOffset) {
        outgoing().emit(SerialUdbExtraF21.builder()
                .sueAccelXOffset(sueAccelXOffset)
                .sueAccelYOffset(sueAccelYOffset)
                .sueAccelZOffset(sueAccelZOffset)
                .sueGyroXOffset(sueGyroXOffset)
                .sueGyroYOffset(sueGyroYOffset)
                .sueGyroZOffset(sueGyroZOffset)
                .build());
    }

    /**
     * Acknowldge sucess or failure of a flexifunction command 
     * @param commandType Command acknowledged 
     * @param result result of acknowledge 
     */
    default void sendFlexifunctionCommandAck(int commandType, int result) {
        outgoing().emit(FlexifunctionCommandAck.builder()
                .commandType(commandType)
                .result(result)
                .build());
    }

    final class Impl extends AbstractMavlinkVehicle implements MatrixpilotVehicle {
        Impl(int systemId, EventSource<Object> incoming, EventEmitter<Object> outgoing) {
            super(systemId, incoming, outgoing);
        }
    }
}
