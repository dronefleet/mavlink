package io.dronefleet.mavlink.ardupilotmega;

import com.benbarkay.events.EventEmitter;
import com.benbarkay.events.EventSource;
import io.dronefleet.mavlink.common.CommonVehicle;
import io.dronefleet.mavlink.common.FenceBreach;
import io.dronefleet.mavlink.common.MavMountMode;
import io.dronefleet.mavlink.icarous.IcarousVehicle;
import io.dronefleet.mavlink.uavionix.UavionixVehicle;
import io.dronefleet.mavlink.util.EnumFlagSet;
import io.dronefleet.mavlink.vehicle.AbstractMavlinkVehicle;
import java.lang.Float;
import java.lang.Object;
import java.lang.String;
import java.math.BigInteger;
import java.util.List;

public interface ArdupilotmegaVehicle extends CommonVehicle, UavionixVehicle, IcarousVehicle {
    /**
     * Read registers for a device 
     * @param requestId request ID - copied to reply 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param bustype The bus type 
     * @param bus Bus number 
     * @param address Bus address 
     * @param busname Name of device on bus (for SPI) 
     * @param regstart First register to read 
     * @param count count of registers to read 
     */
    default void sendDeviceOpRead(long requestId, int targetSystem, int targetComponent,
            DeviceOpBustype bustype, int bus, int address, String busname, int regstart,
            int count) {
        outgoing().emit(DeviceOpRead.builder()
                .requestId(requestId)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .bustype(bustype)
                .bus(bus)
                .address(address)
                .busname(busname)
                .regstart(regstart)
                .count(count)
                .build());
    }

    /**
     * Read registers reply 
     * @param requestId request ID - copied from request 
     * @param result 0 for success, anything else is failure code 
     * @param regstart starting register 
     * @param count count of bytes read 
     * @param data reply data 
     */
    default void sendDeviceOpReadReply(long requestId, int result, int regstart, int count,
            byte[] data) {
        outgoing().emit(DeviceOpReadReply.builder()
                .requestId(requestId)
                .result(result)
                .regstart(regstart)
                .count(count)
                .data(data)
                .build());
    }

    /**
     * Message to configure a camera mount, directional antenna, etc. 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param mountMode mount operating mode (see {@link io.dronefleet.mavlink.common.MavMountMode MavMountMode} enum) 
     * @param stabRoll (1 = yes, 0 = no) 
     * @param stabPitch (1 = yes, 0 = no) 
     * @param stabYaw (1 = yes, 0 = no) 
     */
    default void sendMountConfigure(int targetSystem, int targetComponent, MavMountMode mountMode,
            int stabRoll, int stabPitch, int stabYaw) {
        outgoing().emit(MountConfigure.builder()
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .mountMode(mountMode)
                .stabRoll(stabRoll)
                .stabPitch(stabPitch)
                .stabYaw(stabYaw)
                .build());
    }

    /**
     * Data packet, size 96 
     * @param type data type 
     * @param len data length 
     * @param data raw data 
     */
    default void sendData96(int type, int len, byte[] data) {
        outgoing().emit(Data96.builder()
                .type(type)
                .len(len)
                .data(data)
                .build());
    }

    /**
     * Control on-board Camera Control System to take shots. 
     * @param extraValue Correspondent value to given extra_param 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param session 0: stop, 1: start or keep it up //Session control e.g. show/hide lens 
     * @param zoomPos 1 to N //Zoom's absolute position (0 means ignore) 
     * @param zoomStep -100 to 100 //Zooming step value to offset zoom from the current position 
     * @param focusLock 0: unlock focus or keep unlocked, 1: lock focus or keep locked, 3: re-lock focus 
     * @param shot 0: ignore, 1: shot or start filming 
     * @param commandId Command Identity (incremental loop: 0 to 255)//A command sent multiple times will be executed 
     * or pooled just once 
     * @param extraParam Extra parameters enumeration (0 means ignore) 
     */
    default void sendDigicamControl(float extraValue, int targetSystem, int targetComponent,
            int session, int zoomPos, int zoomStep, int focusLock, int shot, int commandId,
            int extraParam) {
        outgoing().emit(DigicamControl.builder()
                .extraValue(extraValue)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .session(session)
                .zoomPos(zoomPos)
                .zoomStep(zoomStep)
                .focusLock(focusLock)
                .shot(shot)
                .commandId(commandId)
                .extraParam(extraParam)
                .build());
    }

    /**
     * Configure on-board Camera Control System. 
     * @param extraValue Correspondent value to given extra_param 
     * @param shutterSpeed Divisor number //e.g. 1000 means 1/1000 (0 means ignore) 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param mode Mode enumeration from 1 to N //P, TV, AV, M, Etc (0 means ignore) 
     * @param aperture F stop number x 10 //e.g. 28 means 2.8 (0 means ignore) 
     * @param iso ISO enumeration from 1 to N //e.g. 80, 100, 200, Etc (0 means ignore) 
     * @param exposureType Exposure type enumeration from 1 to N (0 means ignore) 
     * @param commandId Command Identity (incremental loop: 0 to 255)//A command sent multiple times will be executed 
     * or pooled just once 
     * @param engineCutOff Main engine cut-off time before camera trigger in seconds/10 (0 means no cut-off) 
     * @param extraParam Extra parameters enumeration (0 means ignore) 
     */
    default void sendDigicamConfigure(float extraValue, int shutterSpeed, int targetSystem,
            int targetComponent, int mode, int aperture, int iso, int exposureType, int commandId,
            int engineCutOff, int extraParam) {
        outgoing().emit(DigicamConfigure.builder()
                .extraValue(extraValue)
                .shutterSpeed(shutterSpeed)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .mode(mode)
                .aperture(aperture)
                .iso(iso)
                .exposureType(exposureType)
                .commandId(commandId)
                .engineCutOff(engineCutOff)
                .extraParam(extraParam)
                .build());
    }

    /**
     * Message with some status from APM to GCS about camera or antenna mount 
     * @param pointingA pitch(deg*100) 
     * @param pointingB roll(deg*100) 
     * @param pointingC yaw(deg*100) 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     */
    default void sendMountStatus(int pointingA, int pointingB, int pointingC, int targetSystem,
            int targetComponent) {
        outgoing().emit(MountStatus.builder()
                .pointingA(pointingA)
                .pointingB(pointingB)
                .pointingC(pointingC)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .build());
    }

    /**
     * Data packet, size 16 
     * @param type data type 
     * @param len data length 
     * @param data raw data 
     */
    default void sendData16(int type, int len, byte[] data) {
        outgoing().emit(Data16.builder()
                .type(type)
                .len(len)
                .data(data)
                .build());
    }

    /**
     * Airspeed auto-calibration 
     * @param vx GPS velocity north m/s 
     * @param vy GPS velocity east m/s 
     * @param vz GPS velocity down m/s 
     * @param diffPressure Differential pressure pascals 
     * @param eas2tas Estimated to true airspeed ratio 
     * @param ratio Airspeed ratio 
     * @param stateX EKF state x 
     * @param stateY EKF state y 
     * @param stateZ EKF state z 
     * @param pax EKF Pax 
     * @param pby EKF Pby 
     * @param pcz EKF Pcz 
     */
    default void sendAirspeedAutocal(float vx, float vy, float vz, float diffPressure,
            float eas2tas, float ratio, float stateX, float stateY, float stateZ, float pax,
            float pby, float pcz) {
        outgoing().emit(AirspeedAutocal.builder()
                .vx(vx)
                .vy(vy)
                .vz(vz)
                .diffPressure(diffPressure)
                .eas2tas(eas2tas)
                .ratio(ratio)
                .stateX(stateX)
                .stateY(stateY)
                .stateZ(stateZ)
                .pax(pax)
                .pby(pby)
                .pcz(pcz)
                .build());
    }

    /**
     * raw ADC output 
     * @param adc1 ADC output 1 
     * @param adc2 ADC output 2 
     * @param adc3 ADC output 3 
     * @param adc4 ADC output 4 
     * @param adc5 ADC output 5 
     * @param adc6 ADC output 6 
     */
    default void sendApAdc(int adc1, int adc2, int adc3, int adc4, int adc5, int adc6) {
        outgoing().emit(ApAdc.builder()
                .adc1(adc1)
                .adc2(adc2)
                .adc3(adc3)
                .adc4(adc4)
                .adc5(adc5)
                .adc6(adc6)
                .build());
    }

    /**
     * A fence point. Used to set a point when from GCS -> MAV. Also used to return a point from MAV -> GCS 
     * @param lat Latitude of point 
     * @param lng Longitude of point 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param idx point index (first point is 1, 0 is for return point) 
     * @param count total number of points (for sanity checking) 
     */
    default void sendFencePoint(float lat, float lng, int targetSystem, int targetComponent,
            int idx, int count) {
        outgoing().emit(FencePoint.builder()
                .lat(lat)
                .lng(lng)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .idx(idx)
                .count(count)
                .build());
    }

    /**
     * Response from a {@link io.dronefleet.mavlink.ardupilotmega.GoproCommand GoproCommand} get request 
     * @param cmdId Command ID 
     * @param status Status 
     * @param value Value 
     */
    default void sendGoproGetResponse(GoproCommand cmdId, GoproRequestStatus status, byte[] value) {
        outgoing().emit(GoproGetResponse.builder()
                .cmdId(cmdId)
                .status(status)
                .value(value)
                .build());
    }

    /**
     * Control vehicle LEDs 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param instance Instance (LED instance to control or 255 for all LEDs) 
     * @param pattern Pattern (see LED_PATTERN_ENUM) 
     * @param customLen Custom Byte Length 
     * @param customBytes Custom Bytes 
     */
    default void sendLedControl(int targetSystem, int targetComponent, int instance, int pattern,
            int customLen, byte[] customBytes) {
        outgoing().emit(LedControl.builder()
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .instance(instance)
                .pattern(pattern)
                .customLen(customLen)
                .customBytes(customBytes)
                .build());
    }

    /**
     * Request a current rally point from MAV. MAV should respond with a {@link io.dronefleet.mavlink.ardupilotmega.RallyPoint RallyPoint} message. MAV 
     * should not respond if the request is invalid. 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param idx point index (first point is 0) 
     */
    default void sendRallyFetchPoint(int targetSystem, int targetComponent, int idx) {
        outgoing().emit(RallyFetchPoint.builder()
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .idx(idx)
                .build());
    }

    /**
     * Response from a {@link io.dronefleet.mavlink.ardupilotmega.GoproCommand GoproCommand} set request 
     * @param cmdId Command ID 
     * @param status Status 
     */
    default void sendGoproSetResponse(GoproCommand cmdId, GoproRequestStatus status) {
        outgoing().emit(GoproSetResponse.builder()
                .cmdId(cmdId)
                .status(status)
                .build());
    }

    /**
     * Wind estimation 
     * @param direction wind direction that wind is coming from (degrees) 
     * @param speed wind speed in ground plane (m/s) 
     * @param speedZ vertical wind speed (m/s) 
     */
    default void sendWind(float direction, float speed, float speedZ) {
        outgoing().emit(Wind.builder()
                .direction(direction)
                .speed(speed)
                .speedZ(speedZ)
                .build());
    }

    /**
     * Request a {@link io.dronefleet.mavlink.ardupilotmega.GoproCommand GoproCommand} response from the GoPro 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param cmdId Command ID 
     */
    default void sendGoproGetRequest(int targetSystem, int targetComponent, GoproCommand cmdId) {
        outgoing().emit(GoproGetRequest.builder()
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .cmdId(cmdId)
                .build());
    }

    /**
     * Data packet, size 64 
     * @param type data type 
     * @param len data length 
     * @param data raw data 
     */
    default void sendData64(int type, int len, byte[] data) {
        outgoing().emit(Data64.builder()
                .type(type)
                .len(len)
                .data(data)
                .build());
    }

    /**
     * Control message for rate gimbal 
     * @param demandedRateX Demanded angular rate X (rad/s) 
     * @param demandedRateY Demanded angular rate Y (rad/s) 
     * @param demandedRateZ Demanded angular rate Z (rad/s) 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     */
    default void sendGimbalControl(float demandedRateX, float demandedRateY, float demandedRateZ,
            int targetSystem, int targetComponent) {
        outgoing().emit(GimbalControl.builder()
                .demandedRateX(demandedRateX)
                .demandedRateY(demandedRateY)
                .demandedRateZ(demandedRateZ)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .build());
    }

    /**
     * Camera Event 
     * @param timeUsec Image timestamp (microseconds since UNIX epoch, according to camera clock) 
     * @param p1 Parameter 1 (meaning depends on event, see {@link io.dronefleet.mavlink.ardupilotmega.CameraStatusTypes CameraStatusTypes} enum) 
     * @param p2 Parameter 2 (meaning depends on event, see {@link io.dronefleet.mavlink.ardupilotmega.CameraStatusTypes CameraStatusTypes} enum) 
     * @param p3 Parameter 3 (meaning depends on event, see {@link io.dronefleet.mavlink.ardupilotmega.CameraStatusTypes CameraStatusTypes} enum) 
     * @param p4 Parameter 4 (meaning depends on event, see {@link io.dronefleet.mavlink.ardupilotmega.CameraStatusTypes CameraStatusTypes} enum) 
     * @param imgIdx Image index 
     * @param targetSystem System ID 
     * @param camIdx Camera ID 
     * @param eventId See {@link io.dronefleet.mavlink.ardupilotmega.CameraStatusTypes CameraStatusTypes} enum for definition of the bitmask 
     */
    default void sendCameraStatus(BigInteger timeUsec, float p1, float p2, float p3, float p4,
            int imgIdx, int targetSystem, int camIdx, CameraStatusTypes eventId) {
        outgoing().emit(CameraStatus.builder()
                .timeUsec(timeUsec)
                .p1(p1)
                .p2(p2)
                .p3(p3)
                .p4(p4)
                .imgIdx(imgIdx)
                .targetSystem(targetSystem)
                .camIdx(camIdx)
                .eventId(eventId)
                .build());
    }

    /**
     * Reports results of completed compass calibration. Sent until MAG_CAL_ACK received. 
     * @param fitness RMS milligauss residuals 
     * @param ofsX X offset 
     * @param ofsY Y offset 
     * @param ofsZ Z offset 
     * @param diagX X diagonal (matrix 11) 
     * @param diagY Y diagonal (matrix 22) 
     * @param diagZ Z diagonal (matrix 33) 
     * @param offdiagX X off-diagonal (matrix 12 and 21) 
     * @param offdiagY Y off-diagonal (matrix 13 and 31) 
     * @param offdiagZ Z off-diagonal (matrix 32 and 23) 
     * @param compassId Compass being calibrated 
     * @param calMask Bitmask of compasses being calibrated 
     * @param calStatus Status (see {@link io.dronefleet.mavlink.ardupilotmega.MagCalStatus MagCalStatus} enum) 
     * @param autosaved 0=requires a MAV_CMD_DO_ACCEPT_MAG_CAL, 1=saved to parameters 
     */
    default void sendMagCalReport(float fitness, float ofsX, float ofsY, float ofsZ, float diagX,
            float diagY, float diagZ, float offdiagX, float offdiagY, float offdiagZ, int compassId,
            int calMask, MagCalStatus calStatus, int autosaved) {
        outgoing().emit(MagCalReport.builder()
                .fitness(fitness)
                .ofsX(ofsX)
                .ofsY(ofsY)
                .ofsZ(ofsZ)
                .diagX(diagX)
                .diagY(diagY)
                .diagZ(diagZ)
                .offdiagX(offdiagX)
                .offdiagY(offdiagY)
                .offdiagZ(offdiagZ)
                .compassId(compassId)
                .calMask(calMask)
                .calStatus(calStatus)
                .autosaved(autosaved)
                .build());
    }

    /**
     * Status of key hardware 
     * @param vcc board voltage (mV) 
     * @param i2cerr I2C error count 
     */
    default void sendHwstatus(int vcc, int i2cerr) {
        outgoing().emit(Hwstatus.builder()
                .vcc(vcc)
                .i2cerr(i2cerr)
                .build());
    }

    /**
     * Status of DCM attitude estimator 
     * @param omegaix X gyro drift estimate rad/s 
     * @param omegaiy Y gyro drift estimate rad/s 
     * @param omegaiz Z gyro drift estimate rad/s 
     * @param accelWeight average accel_weight 
     * @param renormVal average renormalisation value 
     * @param errorRp average error_roll_pitch value 
     * @param errorYaw average error_yaw value 
     */
    default void sendAhrs(float omegaix, float omegaiy, float omegaiz, float accelWeight,
            float renormVal, float errorRp, float errorYaw) {
        outgoing().emit(Ahrs.builder()
                .omegaix(omegaix)
                .omegaiy(omegaiy)
                .omegaiz(omegaiz)
                .accelWeight(accelWeight)
                .renormVal(renormVal)
                .errorRp(errorRp)
                .errorYaw(errorYaw)
                .build());
    }

    /**
     * Deepstall path planning 
     * @param landingLat Landing latitude (deg * 1E7) 
     * @param landingLon Landing longitude (deg * 1E7) 
     * @param pathLat Final heading start point, latitude (deg * 1E7) 
     * @param pathLon Final heading start point, longitude (deg * 1E7) 
     * @param arcEntryLat Arc entry point, latitude (deg * 1E7) 
     * @param arcEntryLon Arc entry point, longitude (deg * 1E7) 
     * @param altitude Altitude (meters) 
     * @param expectedTravelDistance Distance the aircraft expects to travel during the deepstall 
     * @param crossTrackError Deepstall cross track error in meters (only valid when in DEEPSTALL_STAGE_LAND) 
     * @param stage Deepstall stage, see enum MAV_DEEPSTALL_STAGE 
     */
    default void sendDeepstall(int landingLat, int landingLon, int pathLat, int pathLon,
            int arcEntryLat, int arcEntryLon, float altitude, float expectedTravelDistance,
            float crossTrackError, DeepstallStage stage) {
        outgoing().emit(Deepstall.builder()
                .landingLat(landingLat)
                .landingLon(landingLon)
                .pathLat(pathLat)
                .pathLon(pathLon)
                .arcEntryLat(arcEntryLat)
                .arcEntryLon(arcEntryLon)
                .altitude(altitude)
                .expectedTravelDistance(expectedTravelDistance)
                .crossTrackError(crossTrackError)
                .stage(stage)
                .build());
    }

    /**
     * Offsets and calibrations values for hardware sensors. This makes it easier to debug the 
     * calibration process. 
     * @param magDeclination magnetic declination (radians) 
     * @param rawPress raw pressure from barometer 
     * @param rawTemp raw temperature from barometer 
     * @param gyroCalX gyro X calibration 
     * @param gyroCalY gyro Y calibration 
     * @param gyroCalZ gyro Z calibration 
     * @param accelCalX accel X calibration 
     * @param accelCalY accel Y calibration 
     * @param accelCalZ accel Z calibration 
     * @param magOfsX magnetometer X offset 
     * @param magOfsY magnetometer Y offset 
     * @param magOfsZ magnetometer Z offset 
     */
    default void sendSensorOffsets(float magDeclination, int rawPress, int rawTemp, float gyroCalX,
            float gyroCalY, float gyroCalZ, float accelCalX, float accelCalY, float accelCalZ,
            int magOfsX, int magOfsY, int magOfsZ) {
        outgoing().emit(SensorOffsets.builder()
                .magDeclination(magDeclination)
                .rawPress(rawPress)
                .rawTemp(rawTemp)
                .gyroCalX(gyroCalX)
                .gyroCalY(gyroCalY)
                .gyroCalZ(gyroCalZ)
                .accelCalX(accelCalX)
                .accelCalY(accelCalY)
                .accelCalZ(accelCalZ)
                .magOfsX(magOfsX)
                .magOfsY(magOfsY)
                .magOfsZ(magOfsZ)
                .build());
    }

    /**
     * state of APM memory 
     * @param brkval heap top 
     * @param freemem free memory 
     * @param freemem32 free memory (32 bit) 
     */
    default void sendMeminfo(int brkval, int freemem, long freemem32) {
        outgoing().emit(Meminfo.builder()
                .brkval(brkval)
                .freemem(freemem)
                .freemem32(freemem32)
                .build());
    }

    /**
     * Status of third {@link io.dronefleet.mavlink.ardupilotmega.Ahrs Ahrs} filter if available. This is for ANU research group (Ali and Sean) 
     * @param roll Roll angle (rad) 
     * @param pitch Pitch angle (rad) 
     * @param yaw Yaw angle (rad) 
     * @param altitude Altitude (MSL) 
     * @param lat Latitude in degrees * 1E7 
     * @param lng Longitude in degrees * 1E7 
     * @param v1 test variable1 
     * @param v2 test variable2 
     * @param v3 test variable3 
     * @param v4 test variable4 
     */
    default void sendAhrs3(float roll, float pitch, float yaw, float altitude, int lat, int lng,
            float v1, float v2, float v3, float v4) {
        outgoing().emit(Ahrs3.builder()
                .roll(roll)
                .pitch(pitch)
                .yaw(yaw)
                .altitude(altitude)
                .lat(lat)
                .lng(lng)
                .v1(v1)
                .v2(v2)
                .v3(v3)
                .v4(v4)
                .build());
    }

    /**
     * Status of secondary {@link io.dronefleet.mavlink.ardupilotmega.Ahrs Ahrs} filter if available 
     * @param roll Roll angle (rad) 
     * @param pitch Pitch angle (rad) 
     * @param yaw Yaw angle (rad) 
     * @param altitude Altitude (MSL) 
     * @param lat Latitude in degrees * 1E7 
     * @param lng Longitude in degrees * 1E7 
     */
    default void sendAhrs2(float roll, float pitch, float yaw, float altitude, int lat, int lng) {
        outgoing().emit(Ahrs2.builder()
                .roll(roll)
                .pitch(pitch)
                .yaw(yaw)
                .altitude(altitude)
                .lat(lat)
                .lng(lng)
                .build());
    }

    /**
     * Send Status of each log block that autopilot board might have sent 
     * @param seqno log data block sequence number 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param status log data block status 
     */
    default void sendRemoteLogBlockStatus(long seqno, int targetSystem, int targetComponent,
            MavRemoteLogDataBlockStatuses status) {
        outgoing().emit(RemoteLogBlockStatus.builder()
                .seqno(seqno)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .status(status)
                .build());
    }

    /**
     * Request the autopilot version from the system/component. 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     */
    default void sendAutopilotVersionRequest(int targetSystem, int targetComponent) {
        outgoing().emit(AutopilotVersionRequest.builder()
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .build());
    }

    /**
     * Heartbeat from a HeroBus attached GoPro 
     * @param status Status 
     * @param captureMode Current capture mode 
     * @param flags additional status bits 
     */
    default void sendGoproHeartbeat(GoproHeartbeatStatus status, GoproCaptureMode captureMode,
            EnumFlagSet<GoproHeartbeatFlags> flags) {
        outgoing().emit(GoproHeartbeat.builder()
                .status(status)
                .captureMode(captureMode)
                .flags(flags)
                .build());
    }

    /**
     * camera vision based attitude and position deltas 
     * @param timeUsec Timestamp (microseconds, synced to UNIX time or since system boot) 
     * @param timeDeltaUsec Time in microseconds since the last reported camera frame 
     * @param angleDelta Defines a rotation vector in body frame that rotates the vehicle from the previous to the 
     * current orientation 
     * @param positionDelta Change in position in meters from previous to current frame rotated into body frame 
     * (0=forward, 1=right, 2=down) 
     * @param confidence normalised confidence value from 0 to 100 
     */
    default void sendVisionPositionDelta(BigInteger timeUsec, BigInteger timeDeltaUsec,
            List<Float> angleDelta, List<Float> positionDelta, float confidence) {
        outgoing().emit(VisionPositionDelta.builder()
                .timeUsec(timeUsec)
                .timeDeltaUsec(timeDeltaUsec)
                .angleDelta(angleDelta)
                .positionDelta(positionDelta)
                .confidence(confidence)
                .build());
    }

    /**
     * EKF Status message including flags and variances 
     * @param velocityVariance Velocity variance 
     * @param posHorizVariance Horizontal Position variance 
     * @param posVertVariance Vertical Position variance 
     * @param compassVariance Compass variance 
     * @param terrainAltVariance Terrain Altitude variance 
     * @param flags Flags 
     * @param airspeedVariance Airspeed variance 
     */
    default void sendEkfStatusReport(float velocityVariance, float posHorizVariance,
            float posVertVariance, float compassVariance, float terrainAltVariance,
            EkfStatusFlags flags, float airspeedVariance) {
        outgoing().emit(EkfStatusReport.builder()
                .velocityVariance(velocityVariance)
                .posHorizVariance(posHorizVariance)
                .posVertVariance(posVertVariance)
                .compassVariance(compassVariance)
                .terrainAltVariance(terrainAltVariance)
                .flags(flags)
                .airspeedVariance(airspeedVariance)
                .build());
    }

    /**
     * Data packet, size 32 
     * @param type data type 
     * @param len data length 
     * @param data raw data 
     */
    default void sendData32(int type, int len, byte[] data) {
        outgoing().emit(Data32.builder()
                .type(type)
                .len(len)
                .data(data)
                .build());
    }

    /**
     * Send a block of log data to remote location 
     * @param seqno log data block sequence number 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param data log data block 
     */
    default void sendRemoteLogDataBlock(MavRemoteLogDataBlockCommands seqno, int targetSystem,
            int targetComponent, byte[] data) {
        outgoing().emit(RemoteLogDataBlock.builder()
                .seqno(seqno)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .data(data)
                .build());
    }

    /**
     * RPM sensor output 
     * @param rpm1 RPM Sensor1 
     * @param rpm2 RPM Sensor2 
     */
    default void sendRpm(float rpm1, float rpm2) {
        outgoing().emit(Rpm.builder()
                .rpm1(rpm1)
                .rpm2(rpm2)
                .build());
    }

    /**
     * Camera Capture Feedback 
     * @param timeUsec Image timestamp (microseconds since UNIX epoch), as passed in by {@link io.dronefleet.mavlink.ardupilotmega.CameraStatus CameraStatus} message (or 
     * autopilot if no CCB) 
     * @param lat Latitude in (deg * 1E7) 
     * @param lng Longitude in (deg * 1E7) 
     * @param altMsl Altitude Absolute (meters AMSL) 
     * @param altRel Altitude Relative (meters above HOME location) 
     * @param roll Camera Roll angle (earth frame, degrees, +-180) 
     * @param pitch Camera Pitch angle (earth frame, degrees, +-180) 
     * @param yaw Camera Yaw (earth frame, degrees, 0-360, true) 
     * @param focLen Focal Length (mm) 
     * @param imgIdx Image index 
     * @param targetSystem System ID 
     * @param camIdx Camera ID 
     * @param flags See {@link io.dronefleet.mavlink.ardupilotmega.CameraFeedbackFlags CameraFeedbackFlags} enum for definition of the bitmask 
     * @param completedCaptures Completed image captures 
     */
    default void sendCameraFeedback(BigInteger timeUsec, int lat, int lng, float altMsl,
            float altRel, float roll, float pitch, float yaw, float focLen, int imgIdx,
            int targetSystem, int camIdx, CameraFeedbackFlags flags, int completedCaptures) {
        outgoing().emit(CameraFeedback.builder()
                .timeUsec(timeUsec)
                .lat(lat)
                .lng(lng)
                .altMsl(altMsl)
                .altRel(altRel)
                .roll(roll)
                .pitch(pitch)
                .yaw(yaw)
                .focLen(focLen)
                .imgIdx(imgIdx)
                .targetSystem(targetSystem)
                .camIdx(camIdx)
                .flags(flags)
                .completedCaptures(completedCaptures)
                .build());
    }

    /**
     * Deprecated. Use MAV_CMD_PREFLIGHT_SET_SENSOR_OFFSETS instead. Set the magnetometer 
     * offsets 
     * @param magOfsX magnetometer X offset 
     * @param magOfsY magnetometer Y offset 
     * @param magOfsZ magnetometer Z offset 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     */
    default void sendSetMagOffsets(int magOfsX, int magOfsY, int magOfsZ, int targetSystem,
            int targetComponent) {
        outgoing().emit(SetMagOffsets.builder()
                .magOfsX(magOfsX)
                .magOfsY(magOfsY)
                .magOfsZ(magOfsZ)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .build());
    }

    /**
     * Request a current fence point from MAV 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param idx point index (first point is 1, 0 is for return point) 
     */
    default void sendFenceFetchPoint(int targetSystem, int targetComponent, int idx) {
        outgoing().emit(FenceFetchPoint.builder()
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .idx(idx)
                .build());
    }

    /**
     * Status of simulation environment, if used 
     * @param roll Roll angle (rad) 
     * @param pitch Pitch angle (rad) 
     * @param yaw Yaw angle (rad) 
     * @param xacc X acceleration m/s/s 
     * @param yacc Y acceleration m/s/s 
     * @param zacc Z acceleration m/s/s 
     * @param xgyro Angular speed around X axis rad/s 
     * @param ygyro Angular speed around Y axis rad/s 
     * @param zgyro Angular speed around Z axis rad/s 
     * @param lat Latitude in degrees * 1E7 
     * @param lng Longitude in degrees * 1E7 
     */
    default void sendSimstate(float roll, float pitch, float yaw, float xacc, float yacc,
            float zacc, float xgyro, float ygyro, float zgyro, int lat, int lng) {
        outgoing().emit(Simstate.builder()
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
                .lng(lng)
                .build());
    }

    /**
     * Rangefinder reporting 
     * @param distance distance in meters 
     * @param voltage raw voltage if available, zero otherwise 
     */
    default void sendRangefinder(float distance, float voltage) {
        outgoing().emit(Rangefinder.builder()
                .distance(distance)
                .voltage(voltage)
                .build());
    }

    /**
     * Reports progress of compass calibration. 
     * @param directionX Body frame direction vector for display 
     * @param directionY Body frame direction vector for display 
     * @param directionZ Body frame direction vector for display 
     * @param compassId Compass being calibrated 
     * @param calMask Bitmask of compasses being calibrated 
     * @param calStatus Status (see {@link io.dronefleet.mavlink.ardupilotmega.MagCalStatus MagCalStatus} enum) 
     * @param attempt Attempt number 
     * @param completionPct Completion percentage 
     * @param completionMask Bitmask of sphere sections (see http://en.wikipedia.org/wiki/Geodesic_grid) 
     */
    default void sendMagCalProgress(float directionX, float directionY, float directionZ,
            int compassId, int calMask, MagCalStatus calStatus, int attempt, int completionPct,
            byte[] completionMask) {
        outgoing().emit(MagCalProgress.builder()
                .directionX(directionX)
                .directionY(directionY)
                .directionZ(directionZ)
                .compassId(compassId)
                .calMask(calMask)
                .calStatus(calStatus)
                .attempt(attempt)
                .completionPct(completionPct)
                .completionMask(completionMask)
                .build());
    }

    /**
     * 100 Hz gimbal torque command telemetry 
     * @param rlTorqueCmd Roll Torque Command 
     * @param elTorqueCmd Elevation Torque Command 
     * @param azTorqueCmd Azimuth Torque Command 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     */
    default void sendGimbalTorqueCmdReport(int rlTorqueCmd, int elTorqueCmd, int azTorqueCmd,
            int targetSystem, int targetComponent) {
        outgoing().emit(GimbalTorqueCmdReport.builder()
                .rlTorqueCmd(rlTorqueCmd)
                .elTorqueCmd(elTorqueCmd)
                .azTorqueCmd(azTorqueCmd)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .build());
    }

    /**
     * Status of geo-fencing. Sent in extended status stream when fencing enabled 
     * @param breachTime time of last breach in milliseconds since boot 
     * @param breachCount number of fence breaches 
     * @param breachStatus 0 if currently inside fence, 1 if outside 
     * @param breachType last breach type (see FENCE_BREACH_* enum) 
     */
    default void sendFenceStatus(long breachTime, int breachCount, int breachStatus,
            FenceBreach breachType) {
        outgoing().emit(FenceStatus.builder()
                .breachTime(breachTime)
                .breachCount(breachCount)
                .breachStatus(breachStatus)
                .breachType(breachType)
                .build());
    }

    /**
     * Status of compassmot calibration 
     * @param current current (Ampere) 
     * @param compensationx Motor Compensation X 
     * @param compensationy Motor Compensation Y 
     * @param compensationz Motor Compensation Z 
     * @param throttle throttle (percent*10) 
     * @param interference interference (percent) 
     */
    default void sendCompassmotStatus(float current, float compensationx, float compensationy,
            float compensationz, int throttle, int interference) {
        outgoing().emit(CompassmotStatus.builder()
                .current(current)
                .compensationx(compensationx)
                .compensationy(compensationy)
                .compensationz(compensationz)
                .throttle(throttle)
                .interference(interference)
                .build());
    }

    /**
     * Message to control a camera mount, directional antenna, etc. 
     * @param inputA pitch(deg*100) or lat, depending on mount mode 
     * @param inputB roll(deg*100) or lon depending on mount mode 
     * @param inputC yaw(deg*100) or alt (in cm) depending on mount mode 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param savePosition if "1" it will save current trimmed position on EEPROM (just valid for NEUTRAL and LANDING) 
     */
    default void sendMountControl(int inputA, int inputB, int inputC, int targetSystem,
            int targetComponent, int savePosition) {
        outgoing().emit(MountControl.builder()
                .inputA(inputA)
                .inputB(inputB)
                .inputC(inputC)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .savePosition(savePosition)
                .build());
    }

    /**
     * PID tuning information 
     * @param desired desired rate (degrees/s) 
     * @param achieved achieved rate (degrees/s) 
     * @param ff FF component 
     * @param p P component 
     * @param i I component 
     * @param d D component 
     * @param axis axis 
     */
    default void sendPidTuning(float desired, float achieved, float ff, float p, float i, float d,
            PidTuningAxis axis) {
        outgoing().emit(PidTuning.builder()
                .desired(desired)
                .achieved(achieved)
                .ff(ff)
                .p(p)
                .i(i)
                .d(d)
                .axis(axis)
                .build());
    }

    /**
     * Write registers for a device 
     * @param requestId request ID - copied to reply 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param bustype The bus type 
     * @param bus Bus number 
     * @param address Bus address 
     * @param busname Name of device on bus (for SPI) 
     * @param regstart First register to write 
     * @param count count of registers to write 
     * @param data write data 
     */
    default void sendDeviceOpWrite(long requestId, int targetSystem, int targetComponent,
            DeviceOpBustype bustype, int bus, int address, String busname, int regstart, int count,
            byte[] data) {
        outgoing().emit(DeviceOpWrite.builder()
                .requestId(requestId)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .bustype(bustype)
                .bus(bus)
                .address(address)
                .busname(busname)
                .regstart(regstart)
                .count(count)
                .data(data)
                .build());
    }

    /**
     * Adaptive Controller tuning information 
     * @param desired desired rate (degrees/s) 
     * @param achieved achieved rate (degrees/s) 
     * @param error error between model and vehicle 
     * @param theta theta estimated state predictor 
     * @param omega omega estimated state predictor 
     * @param sigma sigma estimated state predictor 
     * @param thetaDot theta derivative 
     * @param omegaDot omega derivative 
     * @param sigmaDot sigma derivative 
     * @param f projection operator value 
     * @param fDot projection operator derivative 
     * @param u u adaptive controlled output command 
     * @param axis axis 
     */
    default void sendAdapTuning(float desired, float achieved, float error, float theta,
            float omega, float sigma, float thetaDot, float omegaDot, float sigmaDot, float f,
            float fDot, float u, PidTuningAxis axis) {
        outgoing().emit(AdapTuning.builder()
                .desired(desired)
                .achieved(achieved)
                .error(error)
                .theta(theta)
                .omega(omega)
                .sigma(sigma)
                .thetaDot(thetaDot)
                .omegaDot(omegaDot)
                .sigmaDot(sigmaDot)
                .f(f)
                .fDot(fDot)
                .u(u)
                .axis(axis)
                .build());
    }

    /**
     * 3 axis gimbal mesuraments 
     * @param deltaTime Time since last update (seconds) 
     * @param deltaAngleX Delta angle X (radians) 
     * @param deltaAngleY Delta angle Y (radians) 
     * @param deltaAngleZ Delta angle X (radians) 
     * @param deltaVelocityX Delta velocity X (m/s) 
     * @param deltaVelocityY Delta velocity Y (m/s) 
     * @param deltaVelocityZ Delta velocity Z (m/s) 
     * @param jointRoll Joint ROLL (radians) 
     * @param jointEl Joint EL (radians) 
     * @param jointAz Joint AZ (radians) 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     */
    default void sendGimbalReport(float deltaTime, float deltaAngleX, float deltaAngleY,
            float deltaAngleZ, float deltaVelocityX, float deltaVelocityY, float deltaVelocityZ,
            float jointRoll, float jointEl, float jointAz, int targetSystem, int targetComponent) {
        outgoing().emit(GimbalReport.builder()
                .deltaTime(deltaTime)
                .deltaAngleX(deltaAngleX)
                .deltaAngleY(deltaAngleY)
                .deltaAngleZ(deltaAngleZ)
                .deltaVelocityX(deltaVelocityX)
                .deltaVelocityY(deltaVelocityY)
                .deltaVelocityZ(deltaVelocityZ)
                .jointRoll(jointRoll)
                .jointEl(jointEl)
                .jointAz(jointAz)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .build());
    }

    /**
     * Angle of Attack and Side Slip Angle 
     * @param timeUsec Timestamp (micros since boot or Unix epoch) 
     * @param aoa Angle of Attack (degrees) 
     * @param ssa Side Slip Angle (degrees) 
     */
    default void sendAoaSsa(BigInteger timeUsec, float aoa, float ssa) {
        outgoing().emit(AoaSsa.builder()
                .timeUsec(timeUsec)
                .aoa(aoa)
                .ssa(ssa)
                .build());
    }

    /**
     * Status of AP_Limits. Sent in extended status stream when AP_Limits is enabled 
     * @param lastTrigger time of last breach in milliseconds since boot 
     * @param lastAction time of last recovery action in milliseconds since boot 
     * @param lastRecovery time of last successful recovery in milliseconds since boot 
     * @param lastClear time of last all-clear in milliseconds since boot 
     * @param breachCount number of fence breaches 
     * @param limitsState state of AP_Limits, (see enum LimitState, {@link io.dronefleet.mavlink.ardupilotmega.LimitsState LimitsState}) 
     * @param modsEnabled AP_Limit_Module bitfield of enabled modules, (see enum moduleid or {@link io.dronefleet.mavlink.ardupilotmega.LimitModule LimitModule}) 
     * @param modsRequired AP_Limit_Module bitfield of required modules, (see enum moduleid or {@link io.dronefleet.mavlink.ardupilotmega.LimitModule LimitModule}) 
     * @param modsTriggered AP_Limit_Module bitfield of triggered modules, (see enum moduleid or {@link io.dronefleet.mavlink.ardupilotmega.LimitModule LimitModule}) 
     */
    default void sendLimitsStatus(long lastTrigger, long lastAction, long lastRecovery,
            long lastClear, int breachCount, LimitsState limitsState,
            EnumFlagSet<LimitModule> modsEnabled, EnumFlagSet<LimitModule> modsRequired,
            EnumFlagSet<LimitModule> modsTriggered) {
        outgoing().emit(LimitsStatus.builder()
                .lastTrigger(lastTrigger)
                .lastAction(lastAction)
                .lastRecovery(lastRecovery)
                .lastClear(lastClear)
                .breachCount(breachCount)
                .limitsState(limitsState)
                .modsEnabled(modsEnabled)
                .modsRequired(modsRequired)
                .modsTriggered(modsTriggered)
                .build());
    }

    /**
     * Status generated by radio 
     * @param rxerrors receive errors 
     * @param fixed count of error corrected packets 
     * @param rssi local signal strength 
     * @param remrssi remote signal strength 
     * @param txbuf how full the tx buffer is as a percentage 
     * @param noise background noise level 
     * @param remnoise remote background noise level 
     */
    default void sendRadio(int rxerrors, int fixed, int rssi, int remrssi, int txbuf, int noise,
            int remnoise) {
        outgoing().emit(Radio.builder()
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
     * Write registers reply 
     * @param requestId request ID - copied from request 
     * @param result 0 for success, anything else is failure code 
     */
    default void sendDeviceOpWriteReply(long requestId, int result) {
        outgoing().emit(DeviceOpWriteReply.builder()
                .requestId(requestId)
                .result(result)
                .build());
    }

    /**
     * A rally point. Used to set a point when from GCS -> MAV. Also used to return a point from MAV -> GCS 
     * @param lat Latitude of point in degrees * 1E7 
     * @param lng Longitude of point in degrees * 1E7 
     * @param alt Transit / loiter altitude in meters relative to home 
     * @param breakAlt Break altitude in meters relative to home 
     * @param landDir Heading to aim for when landing. In centi-degrees. 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param idx point index (first point is 0) 
     * @param count total number of points (for sanity checking) 
     * @param flags See {@link io.dronefleet.mavlink.ardupilotmega.RallyFlags RallyFlags} enum for definition of the bitmask. 
     */
    default void sendRallyPoint(int lat, int lng, int alt, int breakAlt, int landDir,
            int targetSystem, int targetComponent, int idx, int count,
            EnumFlagSet<RallyFlags> flags) {
        outgoing().emit(RallyPoint.builder()
                .lat(lat)
                .lng(lng)
                .alt(alt)
                .breakAlt(breakAlt)
                .landDir(landDir)
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .idx(idx)
                .count(count)
                .flags(flags)
                .build());
    }

    /**
     * Deprecated. Use {@link io.dronefleet.mavlink.common.BatteryStatus BatteryStatus} instead. 2nd Battery status 
     * @param voltage voltage in millivolts 
     * @param currentBattery Battery current, in centiamperes (1 = 10 milliampere), -1: autopilot does not measure the 
     * current 
     */
    default void sendBattery2(int voltage, int currentBattery) {
        outgoing().emit(Battery2.builder()
                .voltage(voltage)
                .currentBattery(currentBattery)
                .build());
    }

    /**
     * Request to set a {@link io.dronefleet.mavlink.ardupilotmega.GoproCommand GoproCommand} with a desired 
     * @param targetSystem System ID 
     * @param targetComponent Component ID 
     * @param cmdId Command ID 
     * @param value Value 
     */
    default void sendGoproSetRequest(int targetSystem, int targetComponent, GoproCommand cmdId,
            byte[] value) {
        outgoing().emit(GoproSetRequest.builder()
                .targetSystem(targetSystem)
                .targetComponent(targetComponent)
                .cmdId(cmdId)
                .value(value)
                .build());
    }

    final class Impl extends AbstractMavlinkVehicle implements ArdupilotmegaVehicle {
        Impl(int systemId, EventSource<Object> incoming, EventEmitter<Object> outgoing) {
            super(systemId, incoming, outgoing);
        }
    }
}
