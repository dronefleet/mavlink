package io.dronefleet.mavlink.asluav;

import com.benbarkay.events.EventEmitter;
import com.benbarkay.events.EventSource;
import io.dronefleet.mavlink.common.CommonVehicle;
import io.dronefleet.mavlink.vehicle.AbstractMavlinkVehicle;
import java.lang.Object;
import java.math.BigInteger;

public interface AsluavVehicle extends CommonVehicle {
    /**
     * ASL-fixed-wing controller data 
     * @param timestamp Timestamp 
     * @param h See sourcecode for a description of these values... 
     * @param href null
     * @param hrefT null
     * @param pitchangle Pitch angle 
     * @param pitchangleref Pitch angle reference 
     * @param q null
     * @param qref null
     * @param uelev null
     * @param uthrot null
     * @param uthrot2 null
     * @param nz null
     * @param airspeedref Airspeed reference 
     * @param yawangle Yaw angle 
     * @param yawangleref Yaw angle reference 
     * @param rollangle Roll angle 
     * @param rollangleref Roll angle reference 
     * @param p null
     * @param pref null
     * @param r null
     * @param rref null
     * @param uail null
     * @param urud null
     * @param aslctrlMode ASLCTRL control-mode (manual, stabilized, auto, etc...) 
     * @param spoilersengaged null
     */
    default void sendAslctrlData(BigInteger timestamp, float h, float href, float hrefT,
            float pitchangle, float pitchangleref, float q, float qref, float uelev, float uthrot,
            float uthrot2, float nz, float airspeedref, float yawangle, float yawangleref,
            float rollangle, float rollangleref, float p, float pref, float r, float rref,
            float uail, float urud, int aslctrlMode, int spoilersengaged) {
        outgoing().emit(AslctrlData.builder()
                .timestamp(timestamp)
                .h(h)
                .href(href)
                .hrefT(hrefT)
                .pitchangle(pitchangle)
                .pitchangleref(pitchangleref)
                .q(q)
                .qref(qref)
                .uelev(uelev)
                .uthrot(uthrot)
                .uthrot2(uthrot2)
                .nz(nz)
                .airspeedref(airspeedref)
                .yawangle(yawangle)
                .yawangleref(yawangleref)
                .rollangle(rollangle)
                .rollangleref(rollangleref)
                .p(p)
                .pref(pref)
                .r(r)
                .rref(rref)
                .uail(uail)
                .urud(urud)
                .aslctrlMode(aslctrlMode)
                .spoilersengaged(spoilersengaged)
                .build());
    }

    /**
     * Extended EKF state estimates for ASLUAVs 
     * @param timestamp Time since system start 
     * @param windspeed Magnitude of wind velocity (in lateral inertial plane) 
     * @param winddir Wind heading angle from North 
     * @param windz Z (Down) component of inertial wind velocity 
     * @param airspeed Magnitude of air velocity 
     * @param beta Sideslip angle 
     * @param alpha Angle of attack 
     */
    default void sendEkfExt(BigInteger timestamp, float windspeed, float winddir, float windz,
            float airspeed, float beta, float alpha) {
        outgoing().emit(EkfExt.builder()
                .timestamp(timestamp)
                .windspeed(windspeed)
                .winddir(winddir)
                .windz(windz)
                .airspeed(airspeed)
                .beta(beta)
                .alpha(alpha)
                .build());
    }

    /**
     * Monitoring of sensorpod status 
     * @param timestamp Timestamp in linuxtime (since 1.1.1970) 
     * @param freeSpace Free space available in recordings directory in [Gb] * 1e2 
     * @param visensorRate1 Rate of ROS topic 1 
     * @param visensorRate2 Rate of ROS topic 2 
     * @param visensorRate3 Rate of ROS topic 3 
     * @param visensorRate4 Rate of ROS topic 4 
     * @param recordingNodesCount Number of recording nodes 
     * @param cpuTemp Temperature of sensorpod CPU in 
     */
    default void sendSensorpodStatus(BigInteger timestamp, int freeSpace, int visensorRate1,
            int visensorRate2, int visensorRate3, int visensorRate4, int recordingNodesCount,
            int cpuTemp) {
        outgoing().emit(SensorpodStatus.builder()
                .timestamp(timestamp)
                .freeSpace(freeSpace)
                .visensorRate1(visensorRate1)
                .visensorRate2(visensorRate2)
                .visensorRate3(visensorRate3)
                .visensorRate4(visensorRate4)
                .recordingNodesCount(recordingNodesCount)
                .cpuTemp(cpuTemp)
                .build());
    }

    /**
     * Monitoring of power board status 
     * @param timestamp Timestamp 
     * @param pwrBrdSystemVolt Power board system voltage 
     * @param pwrBrdServoVolt Power board servo voltage 
     * @param pwrBrdDigitalVolt Power board digital voltage 
     * @param pwrBrdMotLAmp Power board left motor current sensor 
     * @param pwrBrdMotRAmp Power board right motor current sensor 
     * @param pwrBrdAnalogAmp Power board analog current sensor 
     * @param pwrBrdDigitalAmp Power board digital current sensor 
     * @param pwrBrdExtAmp Power board extension current sensor 
     * @param pwrBrdAuxAmp Power board aux current sensor 
     * @param pwrBrdStatus Power board status register 
     * @param pwrBrdLedStatus Power board leds status 
     */
    default void sendSensPowerBoard(BigInteger timestamp, float pwrBrdSystemVolt,
            float pwrBrdServoVolt, float pwrBrdDigitalVolt, float pwrBrdMotLAmp,
            float pwrBrdMotRAmp, float pwrBrdAnalogAmp, float pwrBrdDigitalAmp, float pwrBrdExtAmp,
            float pwrBrdAuxAmp, int pwrBrdStatus, int pwrBrdLedStatus) {
        outgoing().emit(SensPowerBoard.builder()
                .timestamp(timestamp)
                .pwrBrdSystemVolt(pwrBrdSystemVolt)
                .pwrBrdServoVolt(pwrBrdServoVolt)
                .pwrBrdDigitalVolt(pwrBrdDigitalVolt)
                .pwrBrdMotLAmp(pwrBrdMotLAmp)
                .pwrBrdMotRAmp(pwrBrdMotRAmp)
                .pwrBrdAnalogAmp(pwrBrdAnalogAmp)
                .pwrBrdDigitalAmp(pwrBrdDigitalAmp)
                .pwrBrdExtAmp(pwrBrdExtAmp)
                .pwrBrdAuxAmp(pwrBrdAuxAmp)
                .pwrBrdStatus(pwrBrdStatus)
                .pwrBrdLedStatus(pwrBrdLedStatus)
                .build());
    }

    /**
     * Voltage and current sensor data 
     * @param adc121VspbVolt Power board voltage sensor reading 
     * @param adc121CspbAmp Power board current sensor reading 
     * @param adc121Cs1Amp Board current sensor 1 reading 
     * @param adc121Cs2Amp Board current sensor 2 reading 
     */
    default void sendSensPower(float adc121VspbVolt, float adc121CspbAmp, float adc121Cs1Amp,
            float adc121Cs2Amp) {
        outgoing().emit(SensPower.builder()
                .adc121VspbVolt(adc121VspbVolt)
                .adc121CspbAmp(adc121CspbAmp)
                .adc121Cs1Amp(adc121Cs1Amp)
                .adc121Cs2Amp(adc121Cs2Amp)
                .build());
    }

    /**
     * Maximum Power Point Tracker (MPPT) sensor data for solar module power performance tracking 
     * @param mpptTimestamp MPPT last timestamp 
     * @param mppt1Volt MPPT1 voltage 
     * @param mppt1Amp MPPT1 current 
     * @param mppt2Volt MPPT2 voltage 
     * @param mppt2Amp MPPT2 current 
     * @param mppt3Volt MPPT3 voltage 
     * @param mppt3Amp MPPT3 current 
     * @param mppt1Pwm MPPT1 pwm 
     * @param mppt2Pwm MPPT2 pwm 
     * @param mppt3Pwm MPPT3 pwm 
     * @param mppt1Status MPPT1 status 
     * @param mppt2Status MPPT2 status 
     * @param mppt3Status MPPT3 status 
     */
    default void sendSensMppt(BigInteger mpptTimestamp, float mppt1Volt, float mppt1Amp,
            float mppt2Volt, float mppt2Amp, float mppt3Volt, float mppt3Amp, int mppt1Pwm,
            int mppt2Pwm, int mppt3Pwm, int mppt1Status, int mppt2Status, int mppt3Status) {
        outgoing().emit(SensMppt.builder()
                .mpptTimestamp(mpptTimestamp)
                .mppt1Volt(mppt1Volt)
                .mppt1Amp(mppt1Amp)
                .mppt2Volt(mppt2Volt)
                .mppt2Amp(mppt2Amp)
                .mppt3Volt(mppt3Volt)
                .mppt3Amp(mppt3Amp)
                .mppt1Pwm(mppt1Pwm)
                .mppt2Pwm(mppt2Pwm)
                .mppt3Pwm(mppt3Pwm)
                .mppt1Status(mppt1Status)
                .mppt2Status(mppt2Status)
                .mppt3Status(mppt3Status)
                .build());
    }

    /**
     * Battery pack monitoring data for Li-Ion batteries 
     * @param batmonTimestamp Time since system start 
     * @param temperature Battery pack temperature 
     * @param safetystatus Battery monitor safetystatus report bits in Hex 
     * @param operationstatus Battery monitor operation status report bits in Hex 
     * @param voltage Battery pack voltage 
     * @param current Battery pack current 
     * @param batterystatus Battery monitor status report bits in Hex 
     * @param serialnumber Battery monitor serial number in Hex 
     * @param cellvoltage1 Battery pack cell 1 voltage 
     * @param cellvoltage2 Battery pack cell 2 voltage 
     * @param cellvoltage3 Battery pack cell 3 voltage 
     * @param cellvoltage4 Battery pack cell 4 voltage 
     * @param cellvoltage5 Battery pack cell 5 voltage 
     * @param cellvoltage6 Battery pack cell 6 voltage 
     * @param soc Battery pack state-of-charge 
     */
    default void sendSensBatmon(BigInteger batmonTimestamp, float temperature, long safetystatus,
            long operationstatus, int voltage, int current, int batterystatus, int serialnumber,
            int cellvoltage1, int cellvoltage2, int cellvoltage3, int cellvoltage4,
            int cellvoltage5, int cellvoltage6, int soc) {
        outgoing().emit(SensBatmon.builder()
                .batmonTimestamp(batmonTimestamp)
                .temperature(temperature)
                .safetystatus(safetystatus)
                .operationstatus(operationstatus)
                .voltage(voltage)
                .current(current)
                .batterystatus(batterystatus)
                .serialnumber(serialnumber)
                .cellvoltage1(cellvoltage1)
                .cellvoltage2(cellvoltage2)
                .cellvoltage3(cellvoltage3)
                .cellvoltage4(cellvoltage4)
                .cellvoltage5(cellvoltage5)
                .cellvoltage6(cellvoltage6)
                .soc(soc)
                .build());
    }

    /**
     * Extended state information for ASLUAVs 
     * @param motorRpm Motor RPM 
     * @param ledStatus Status of the position-indicator LEDs 
     * @param satcomStatus Status of the IRIDIUM satellite communication system 
     * @param servoStatus Status vector for up to 8 servos 
     */
    default void sendAsluavStatus(float motorRpm, int ledStatus, int satcomStatus,
            byte[] servoStatus) {
        outgoing().emit(AsluavStatus.builder()
                .motorRpm(motorRpm)
                .ledStatus(ledStatus)
                .satcomStatus(satcomStatus)
                .servoStatus(servoStatus)
                .build());
    }

    /**
     * Fixed-wing soaring (i.e. thermal seeking) data 
     * @param timestamp Timestamp 
     * @param timestampmodechanged Timestamp since last mode change 
     * @param xw Thermal core updraft strength 
     * @param xr Thermal radius 
     * @param xlat Thermal center latitude 
     * @param xlon Thermal center longitude 
     * @param varw Variance W 
     * @param varr Variance R 
     * @param varlat Variance Lat 
     * @param varlon Variance Lon 
     * @param loiterradius Suggested loiter radius 
     * @param loiterdirection Suggested loiter direction 
     * @param disttosoarpoint Distance to soar point 
     * @param vsinkexp Expected sink rate at current airspeed, roll and throttle 
     * @param z1Localupdraftspeed Measurement / updraft speed at current/local airplane position 
     * @param z2Deltaroll Measurement / roll angle tracking error 
     * @param z1Exp Expected measurement 1 
     * @param z2Exp Expected measurement 2 
     * @param thermalgsnorth Thermal drift (from estimator prediction step only) 
     * @param thermalgseast Thermal drift (from estimator prediction step only) 
     * @param tseDot Total specific energy change (filtered) 
     * @param debugvar1 Debug variable 1 
     * @param debugvar2 Debug variable 2 
     * @param controlmode Control Mode [-] 
     * @param valid Data valid [-] 
     */
    default void sendFwSoaringData(BigInteger timestamp, BigInteger timestampmodechanged, float xw,
            float xr, float xlat, float xlon, float varw, float varr, float varlat, float varlon,
            float loiterradius, float loiterdirection, float disttosoarpoint, float vsinkexp,
            float z1Localupdraftspeed, float z2Deltaroll, float z1Exp, float z2Exp,
            float thermalgsnorth, float thermalgseast, float tseDot, float debugvar1,
            float debugvar2, int controlmode, int valid) {
        outgoing().emit(FwSoaringData.builder()
                .timestamp(timestamp)
                .timestampmodechanged(timestampmodechanged)
                .xw(xw)
                .xr(xr)
                .xlat(xlat)
                .xlon(xlon)
                .varw(varw)
                .varr(varr)
                .varlat(varlat)
                .varlon(varlon)
                .loiterradius(loiterradius)
                .loiterdirection(loiterdirection)
                .disttosoarpoint(disttosoarpoint)
                .vsinkexp(vsinkexp)
                .z1Localupdraftspeed(z1Localupdraftspeed)
                .z2Deltaroll(z2Deltaroll)
                .z1Exp(z1Exp)
                .z2Exp(z2Exp)
                .thermalgsnorth(thermalgsnorth)
                .thermalgseast(thermalgseast)
                .tseDot(tseDot)
                .debugvar1(debugvar1)
                .debugvar2(debugvar2)
                .controlmode(controlmode)
                .valid(valid)
                .build());
    }

    /**
     * Off-board controls/commands for ASLUAVs 
     * @param timestamp Time since system start 
     * @param uelev Elevator command [~] 
     * @param uthrot Throttle command [~] 
     * @param uthrot2 Throttle 2 command [~] 
     * @param uaill Left aileron command [~] 
     * @param uailr Right aileron command [~] 
     * @param urud Rudder command [~] 
     * @param obctrlStatus Off-board computer status 
     */
    default void sendAslObctrl(BigInteger timestamp, float uelev, float uthrot, float uthrot2,
            float uaill, float uailr, float urud, int obctrlStatus) {
        outgoing().emit(AslObctrl.builder()
                .timestamp(timestamp)
                .uelev(uelev)
                .uthrot(uthrot)
                .uthrot2(uthrot2)
                .uaill(uaill)
                .uailr(uailr)
                .urud(urud)
                .obctrlStatus(obctrlStatus)
                .build());
    }

    /**
     * Atmospheric sensors (temperature, humidity, ...) 
     * @param tempambient Ambient temperature 
     * @param humidity Relative humidity 
     */
    default void sendSensAtmos(float tempambient, float humidity) {
        outgoing().emit(SensAtmos.builder()
                .tempambient(tempambient)
                .humidity(humidity)
                .build());
    }

    /**
     * ASL-fixed-wing controller debug data 
     * @param i321 Debug data 
     * @param f1 Debug data 
     * @param f2 Debug data 
     * @param f3 Debug data 
     * @param f4 Debug data 
     * @param f5 Debug data 
     * @param f6 Debug data 
     * @param f7 Debug data 
     * @param f8 Debug data 
     * @param i81 Debug data 
     * @param i82 Debug data 
     */
    default void sendAslctrlDebug(long i321, float f1, float f2, float f3, float f4, float f5,
            float f6, float f7, float f8, int i81, int i82) {
        outgoing().emit(AslctrlDebug.builder()
                .i321(i321)
                .f1(f1)
                .f2(f2)
                .f3(f3)
                .f4(f4)
                .f5(f5)
                .f6(f6)
                .f7(f7)
                .f8(f8)
                .i81(i81)
                .i82(i82)
                .build());
    }

    final class Impl extends AbstractMavlinkVehicle implements AsluavVehicle {
        Impl(int systemId, EventSource<Object> incoming, EventEmitter<Object> outgoing) {
            super(systemId, incoming, outgoing);
        }
    }
}
