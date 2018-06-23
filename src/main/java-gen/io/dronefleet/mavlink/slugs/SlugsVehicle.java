package io.dronefleet.mavlink.slugs;

import com.benbarkay.events.EventEmitter;
import com.benbarkay.events.EventSource;
import io.dronefleet.mavlink.common.CommonVehicle;
import io.dronefleet.mavlink.util.EnumFlagSet;
import io.dronefleet.mavlink.vehicle.AbstractMavlinkVehicle;
import java.lang.Object;

public interface SlugsVehicle extends CommonVehicle {
    /**
     * Transmits the diagnostics data from the Novatel OEMStar GPS 
     * @param receiverstatus Status Bitfield. See table 69 page 350 Novatel OEMstar Manual 
     * @param possolage Age of the position solution 
     * @param csfails Times the CRC has failed since boot 
     * @param timestatus The Time Status. See Table 8 page 27 Novatel OEMStar Manual 
     * @param solstatus solution Status. See table 44 page 197 
     * @param postype position type. See table 43 page 196 
     * @param veltype velocity type. See table 43 page 196 
     */
    default void sendNovatelDiag(long receiverstatus, float possolage, int csfails, int timestatus,
            int solstatus, int postype, int veltype) {
        outgoing().emit(NovatelDiag.builder()
                .receiverstatus(receiverstatus)
                .possolage(possolage)
                .csfails(csfails)
                .timestatus(timestatus)
                .solstatus(solstatus)
                .postype(postype)
                .veltype(veltype)
                .build());
    }

    /**
     * Configurable diagnostic messages. 
     * @param diagfl1 Diagnostic float 1 
     * @param diagfl2 Diagnostic float 2 
     * @param diagfl3 Diagnostic float 3 
     * @param diagsh1 Diagnostic short 1 
     * @param diagsh2 Diagnostic short 2 
     * @param diagsh3 Diagnostic short 3 
     */
    default void sendDiagnostic(float diagfl1, float diagfl2, float diagfl3, int diagsh1,
            int diagsh2, int diagsh3) {
        outgoing().emit(Diagnostic.builder()
                .diagfl1(diagfl1)
                .diagfl2(diagfl2)
                .diagfl3(diagfl3)
                .diagsh1(diagsh1)
                .diagsh2(diagsh2)
                .diagsh3(diagsh3)
                .build());
    }

    /**
     * Transmits the position of watch 
     * @param latitude ISR Latitude 
     * @param longitude ISR Longitude 
     * @param height ISR Height 
     * @param target The system reporting the action 
     * @param option1 Option 1 
     * @param option2 Option 2 
     * @param option3 Option 3 
     */
    default void sendIsrLocation(float latitude, float longitude, float height, int target,
            int option1, int option2, int option3) {
        outgoing().emit(IsrLocation.builder()
                .latitude(latitude)
                .longitude(longitude)
                .height(height)
                .target(target)
                .option1(option1)
                .option2(option2)
                .option3(option3)
                .build());
    }

    /**
     * Mid Level commands sent from the GS to the autopilot. These are only sent when being operated in 
     * mid-level commands mode from the ground. 
     * @param hcommand Commanded Altitude 
     * @param ucommand Commanded Airspeed 
     * @param rcommand Commanded Turnrate 
     * @param target The system setting the commands 
     */
    default void sendMidLvlCmds(float hcommand, float ucommand, float rcommand, int target) {
        outgoing().emit(MidLvlCmds.builder()
                .hcommand(hcommand)
                .ucommand(ucommand)
                .rcommand(rcommand)
                .target(target)
                .build());
    }

    /**
     * Control for camara. 
     * @param target The system setting the commands 
     * @param idorder ID 0: brightness 1: aperture 2: iris 3: ICR 4: backlight 
     * @param order 1: up/on 2: down/off 3: auto/reset/no action 
     */
    default void sendSlugsConfigurationCamera(int target, int idorder, int order) {
        outgoing().emit(SlugsConfigurationCamera.builder()
                .target(target)
                .idorder(idorder)
                .order(order)
                .build());
    }

    /**
     * Transmits the readings from the voltage and current sensors 
     * @param voltage Voltage in uS of PWM. 0 uS = 0V, 20 uS = 21.5V 
     * @param reading2 Depends on the value of r2Type (0) Current consumption in uS of PWM, 20 uS = 90Amp (1) Distance in 
     * cm (2) Distance in cm (3) Absolute value 
     * @param r2type It is the value of reading 2: 0 - Current, 1 - Foreward Sonar, 2 - Back Sonar, 3 - RPM 
     */
    default void sendVoltSensor(int voltage, int reading2, int r2type) {
        outgoing().emit(VoltSensor.builder()
                .voltage(voltage)
                .reading2(reading2)
                .r2type(r2type)
                .build());
    }

    /**
     * The boot message indicates that a system is starting. The onboard software version allows to 
     * keep track of onboard soft/firmware revisions. This message allows the sensor and control 
     * MCUs to communicate version numbers on startup. 
     * @param version The onboard software version 
     */
    default void sendBoot(long version) {
        outgoing().emit(Boot.builder()
                .version(version)
                .build());
    }

    /**
     * Pilot console PWM messges. 
     * @param year Year reported by Gps 
     * @param month Month reported by Gps 
     * @param day Day reported by Gps 
     * @param hour Hour reported by Gps 
     * @param min Min reported by Gps 
     * @param sec Sec reported by Gps 
     * @param clockstat Clock Status. See table 47 page 211 OEMStar Manual 
     * @param vissat Visible satellites reported by Gps 
     * @param usesat Used satellites in Solution 
     * @param gppgl GPS+GLONASS satellites in Solution 
     * @param sigusedmask GPS and GLONASS usage mask (bit 0 GPS_used? bit_4 GLONASS_used?) 
     * @param percentused Percent used GPS 
     */
    default void sendGpsDateTime(int year, int month, int day, int hour, int min, int sec,
            int clockstat, int vissat, int usesat, int gppgl, int sigusedmask, int percentused) {
        outgoing().emit(GpsDateTime.builder()
                .year(year)
                .month(month)
                .day(day)
                .hour(hour)
                .min(min)
                .sec(sec)
                .clockstat(clockstat)
                .vissat(vissat)
                .usesat(usesat)
                .gppgl(gppgl)
                .sigusedmask(sigusedmask)
                .percentused(percentused)
                .build());
    }

    /**
     * This message sets the control surfaces for selective passthrough mode. 
     * @param bitfieldpt Bitfield containing the passthrough configuration, see {@link io.dronefleet.mavlink.slugs.ControlSurfaceFlag ControlSurfaceFlag} ENUM. 
     * @param target The system setting the commands 
     */
    default void sendCtrlSrfcPt(EnumFlagSet<ControlSurfaceFlag> bitfieldpt, int target) {
        outgoing().emit(CtrlSrfcPt.builder()
                .bitfieldpt(bitfieldpt)
                .target(target)
                .build());
    }

    /**
     * Transmits the last known position of the mobile GS to the UAV. Very relevant when Track Mobile is 
     * enabled 
     * @param latitude Mobile Latitude 
     * @param longitude Mobile Longitude 
     * @param target The system reporting the action 
     */
    default void sendSlugsMobileLocation(float latitude, float longitude, int target) {
        outgoing().emit(SlugsMobileLocation.builder()
                .latitude(latitude)
                .longitude(longitude)
                .target(target)
                .build());
    }

    /**
     * Diagnostic data Sensor MCU 
     * @param float1 Float field 1 
     * @param float2 Float field 2 
     * @param int1 Int 16 field 1 
     * @param char1 Int 8 field 1 
     */
    default void sendSensorDiag(float float1, float float2, int int1, int char1) {
        outgoing().emit(SensorDiag.builder()
                .float1(float1)
                .float2(float2)
                .int1(int1)
                .char1(char1)
                .build());
    }

    /**
     * Configurable data log probes to be used inside Simulink 
     * @param fl1 Log value 1 
     * @param fl2 Log value 2 
     * @param fl3 Log value 3 
     * @param fl4 Log value 4 
     * @param fl5 Log value 5 
     * @param fl6 Log value 6 
     */
    default void sendDataLog(float fl1, float fl2, float fl3, float fl4, float fl5, float fl6) {
        outgoing().emit(DataLog.builder()
                .fl1(fl1)
                .fl2(fl2)
                .fl3(fl3)
                .fl4(fl4)
                .fl5(fl5)
                .fl6(fl6)
                .build());
    }

    /**
     * Sensor and DSC control loads. 
     * @param batvolt Battery Voltage 
     * @param sensload Sensor DSC Load 
     * @param ctrlload Control DSC Load 
     */
    default void sendCpuLoad(int batvolt, int sensload, int ctrlload) {
        outgoing().emit(CpuLoad.builder()
                .batvolt(batvolt)
                .sensload(sensload)
                .ctrlload(ctrlload)
                .build());
    }

    /**
     * This contains the status of the GPS readings 
     * @param magvar Magnetic variation 
     * @param csfails Number of times checksum has failed 
     * @param gpsquality The quality indicator, 0=fix not available or invalid, 1=GPS fix, 2=C/A differential GPS, 
     * 6=Dead reckoning mode, 7=Manual input mode (fixed position), 8=Simulator mode, 9= WAAS a 
     * @param msgstype Indicates if GN, GL or GP messages are being received 
     * @param posstatus A = data valid, V = data invalid 
     * @param magdir Magnetic variation direction E/W. Easterly variation (E) subtracts from True course and 
     * Westerly variation (W) adds to True course 
     * @param modeind Positioning system mode indicator. A - Autonomous;D-Differential; E-Estimated (dead 
     * reckoning) mode;M-Manual input; N-Data not valid 
     */
    default void sendStatusGps(float magvar, int csfails, int gpsquality, int msgstype,
            int posstatus, int magdir, int modeind) {
        outgoing().emit(StatusGps.builder()
                .magvar(magvar)
                .csfails(csfails)
                .gpsquality(gpsquality)
                .msgstype(msgstype)
                .posstatus(posstatus)
                .magdir(magdir)
                .modeind(modeind)
                .build());
    }

    /**
     * Transmits the actual Pan, Tilt and Zoom values of the camera unit 
     * @param pan The Pan value in 10ths of degree 
     * @param tilt The Tilt value in 10ths of degree 
     * @param zoom The actual Zoom Value 
     */
    default void sendPtzStatus(int pan, int tilt, int zoom) {
        outgoing().emit(PtzStatus.builder()
                .pan(pan)
                .tilt(tilt)
                .zoom(zoom)
                .build());
    }

    /**
     * Data used in the navigation algorithm. 
     * @param uM Measured Airspeed prior to the nav filter 
     * @param phiC Commanded Roll 
     * @param thetaC Commanded Pitch 
     * @param psidotC Commanded Turn rate 
     * @param ayBody Y component of the body acceleration 
     * @param totaldist Total Distance to Run on this leg of Navigation 
     * @param dist2go Remaining distance to Run on this leg of Navigation 
     * @param hC Commanded altitude 
     * @param fromwp Origin WP 
     * @param towp Destination WP 
     */
    default void sendSlugsNavigation(float uM, float phiC, float thetaC, float psidotC,
            float ayBody, float totaldist, float dist2go, int hC, int fromwp, int towp) {
        outgoing().emit(SlugsNavigation.builder()
                .uM(uM)
                .phiC(phiC)
                .thetaC(thetaC)
                .psidotC(psidotC)
                .ayBody(ayBody)
                .totaldist(totaldist)
                .dist2go(dist2go)
                .hC(hC)
                .fromwp(fromwp)
                .towp(towp)
                .build());
    }

    /**
     * Accelerometer and gyro biases. 
     * @param axbias Accelerometer X bias 
     * @param aybias Accelerometer Y bias 
     * @param azbias Accelerometer Z bias 
     * @param gxbias Gyro X bias 
     * @param gybias Gyro Y bias 
     * @param gzbias Gyro Z bias 
     */
    default void sendSensorBias(float axbias, float aybias, float azbias, float gxbias,
            float gybias, float gzbias) {
        outgoing().emit(SensorBias.builder()
                .axbias(axbias)
                .aybias(aybias)
                .azbias(azbias)
                .gxbias(gxbias)
                .gybias(gybias)
                .gzbias(gzbias)
                .build());
    }

    /**
     * Orders generated to the SLUGS camera mount. 
     * @param target The system reporting the action 
     * @param pan Order the mount to pan: -1 left, 0 No pan motion, +1 right 
     * @param tilt Order the mount to tilt: -1 down, 0 No tilt motion, +1 up 
     * @param zoom Order the zoom values 0 to 10 
     * @param movehome Orders the camera mount to move home. The other fields are ignored when this field is set. 1: move 
     * home, 0 ignored 
     */
    default void sendSlugsCameraOrder(int target, int pan, int tilt, int zoom, int movehome) {
        outgoing().emit(SlugsCameraOrder.builder()
                .target(target)
                .pan(pan)
                .tilt(tilt)
                .zoom(zoom)
                .movehome(movehome)
                .build());
    }

    /**
     * Control for surface; pending and order to origin. 
     * @param mcontrol Pending 
     * @param bcontrol Order to origin 
     * @param target The system setting the commands 
     * @param idsurface ID control surface send 0: throttle 1: aileron 2: elevator 3: rudder 
     */
    default void sendControlSurface(float mcontrol, float bcontrol, int target, int idsurface) {
        outgoing().emit(ControlSurface.builder()
                .mcontrol(mcontrol)
                .bcontrol(bcontrol)
                .target(target)
                .idsurface(idsurface)
                .build());
    }

    /**
     * Transmits the actual status values UAV in flight 
     * @param latitude Latitude UAV 
     * @param longitude Longitude UAV 
     * @param altitude Altitude UAV 
     * @param speed Speed UAV 
     * @param course Course UAV 
     * @param target The ID system reporting the action 
     */
    default void sendUavStatus(float latitude, float longitude, float altitude, float speed,
            float course, int target) {
        outgoing().emit(UavStatus.builder()
                .latitude(latitude)
                .longitude(longitude)
                .altitude(altitude)
                .speed(speed)
                .course(course)
                .target(target)
                .build());
    }

    final class Impl extends AbstractMavlinkVehicle implements SlugsVehicle {
        Impl(int systemId, EventSource<Object> incoming, EventEmitter<Object> outgoing) {
            super(systemId, incoming, outgoing);
        }
    }
}
