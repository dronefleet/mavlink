package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.Objects;

/**
 * The general system state. If the system is following the MAVLink standard, the system state is 
 * mainly defined by three orthogonal states/modes: The system mode, which is either LOCKED 
 * (motors shut down and locked), MANUAL (system under RC control), GUIDED (system with 
 * autonomous position control, position setpoint controlled manually) or AUTO (system guided 
 * by path/waypoint planner). The NAV_MODE defined the current flight state: LIFTOFF (often an 
 * open-loop maneuver), LANDING, WAYPOINTS or VECTOR. This represents the internal navigation 
 * state machine. The system status shows whether the system is currently active or not and if an 
 * emergency occurred. During the CRITICAL and EMERGENCY states the MAV is still considered to be 
 * active, but should start emergency procedures autonomously. After a failure occurred it 
 * should first move from active to critical to allow manual intervention and then move to 
 * emergency after a certain timeout. 
 */
@MavlinkMessageInfo(
        id = 1,
        crc = 124,
        description = "The general system state. If the system is following the MAVLink standard, the system state is mainly defined by three orthogonal states/modes: The system mode, which is either LOCKED (motors shut down and locked), MANUAL (system under RC control), GUIDED (system with autonomous position control, position setpoint controlled manually) or AUTO (system guided by path/waypoint planner). The NAV_MODE defined the current flight state: LIFTOFF (often an open-loop maneuver), LANDING, WAYPOINTS or VECTOR. This represents the internal navigation state machine. The system status shows whether the system is currently active or not and if an emergency occurred. During the CRITICAL and EMERGENCY states the MAV is still considered to be active, but should start emergency procedures autonomously. After a failure occurred it should first move from active to critical to allow manual intervention and then move to emergency after a certain timeout."
)
public final class SysStatus {
    private final EnumValue<MavSysStatusSensor> onboardControlSensorsPresent;

    private final EnumValue<MavSysStatusSensor> onboardControlSensorsEnabled;

    private final EnumValue<MavSysStatusSensor> onboardControlSensorsHealth;

    private final int load;

    private final int voltageBattery;

    private final int currentBattery;

    private final int batteryRemaining;

    private final int dropRateComm;

    private final int errorsComm;

    private final int errorsCount1;

    private final int errorsCount2;

    private final int errorsCount3;

    private final int errorsCount4;

    private SysStatus(EnumValue<MavSysStatusSensor> onboardControlSensorsPresent,
            EnumValue<MavSysStatusSensor> onboardControlSensorsEnabled,
            EnumValue<MavSysStatusSensor> onboardControlSensorsHealth, int load, int voltageBattery,
            int currentBattery, int batteryRemaining, int dropRateComm, int errorsComm,
            int errorsCount1, int errorsCount2, int errorsCount3, int errorsCount4) {
        this.onboardControlSensorsPresent = onboardControlSensorsPresent;
        this.onboardControlSensorsEnabled = onboardControlSensorsEnabled;
        this.onboardControlSensorsHealth = onboardControlSensorsHealth;
        this.load = load;
        this.voltageBattery = voltageBattery;
        this.currentBattery = currentBattery;
        this.batteryRemaining = batteryRemaining;
        this.dropRateComm = dropRateComm;
        this.errorsComm = errorsComm;
        this.errorsCount1 = errorsCount1;
        this.errorsCount2 = errorsCount2;
        this.errorsCount3 = errorsCount3;
        this.errorsCount4 = errorsCount4;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Bitmap showing which onboard controllers and sensors are present. Value of 0: not present. 
     * Value of 1: present. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            enumType = MavSysStatusSensor.class,
            description = "Bitmap showing which onboard controllers and sensors are present. Value of 0: not present. Value of 1: present."
    )
    public final EnumValue<MavSysStatusSensor> onboardControlSensorsPresent() {
        return this.onboardControlSensorsPresent;
    }

    /**
     * Bitmap showing which onboard controllers and sensors are enabled: Value of 0: not enabled. 
     * Value of 1: enabled. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            enumType = MavSysStatusSensor.class,
            description = "Bitmap showing which onboard controllers and sensors are enabled:  Value of 0: not enabled. Value of 1: enabled."
    )
    public final EnumValue<MavSysStatusSensor> onboardControlSensorsEnabled() {
        return this.onboardControlSensorsEnabled;
    }

    /**
     * Bitmap showing which onboard controllers and sensors are operational or have an error: Value 
     * of 0: not enabled. Value of 1: enabled. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            enumType = MavSysStatusSensor.class,
            description = "Bitmap showing which onboard controllers and sensors are operational or have an error:  Value of 0: not enabled. Value of 1: enabled."
    )
    public final EnumValue<MavSysStatusSensor> onboardControlSensorsHealth() {
        return this.onboardControlSensorsHealth;
    }

    /**
     * Maximum usage in percent of the mainloop time. Values: [0-1000] - should always be below 1000 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            description = "Maximum usage in percent of the mainloop time. Values: [0-1000] - should always be below 1000"
    )
    public final int load() {
        return this.load;
    }

    /**
     * Battery voltage 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            description = "Battery voltage"
    )
    public final int voltageBattery() {
        return this.voltageBattery;
    }

    /**
     * Battery current, -1: autopilot does not measure the current 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            signed = true,
            description = "Battery current, -1: autopilot does not measure the current"
    )
    public final int currentBattery() {
        return this.currentBattery;
    }

    /**
     * Remaining battery energy, -1: autopilot estimate the remaining battery 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1,
            signed = true,
            description = "Remaining battery energy, -1: autopilot estimate the remaining battery"
    )
    public final int batteryRemaining() {
        return this.batteryRemaining;
    }

    /**
     * Communication drop rate, (UART, I2C, SPI, CAN), dropped packets on all links (packets that 
     * were corrupted on reception on the MAV) 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 2,
            description = "Communication drop rate, (UART, I2C, SPI, CAN), dropped packets on all links (packets that were corrupted on reception on the MAV)"
    )
    public final int dropRateComm() {
        return this.dropRateComm;
    }

    /**
     * Communication errors (UART, I2C, SPI, CAN), dropped packets on all links (packets that were 
     * corrupted on reception on the MAV) 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 2,
            description = "Communication errors (UART, I2C, SPI, CAN), dropped packets on all links (packets that were corrupted on reception on the MAV)"
    )
    public final int errorsComm() {
        return this.errorsComm;
    }

    /**
     * Autopilot-specific errors 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 2,
            description = "Autopilot-specific errors"
    )
    public final int errorsCount1() {
        return this.errorsCount1;
    }

    /**
     * Autopilot-specific errors 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 2,
            description = "Autopilot-specific errors"
    )
    public final int errorsCount2() {
        return this.errorsCount2;
    }

    /**
     * Autopilot-specific errors 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 2,
            description = "Autopilot-specific errors"
    )
    public final int errorsCount3() {
        return this.errorsCount3;
    }

    /**
     * Autopilot-specific errors 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 2,
            description = "Autopilot-specific errors"
    )
    public final int errorsCount4() {
        return this.errorsCount4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        SysStatus other = (SysStatus)o;
        if (!Objects.deepEquals(onboardControlSensorsPresent, other.onboardControlSensorsPresent)) return false;
        if (!Objects.deepEquals(onboardControlSensorsEnabled, other.onboardControlSensorsEnabled)) return false;
        if (!Objects.deepEquals(onboardControlSensorsHealth, other.onboardControlSensorsHealth)) return false;
        if (!Objects.deepEquals(load, other.load)) return false;
        if (!Objects.deepEquals(voltageBattery, other.voltageBattery)) return false;
        if (!Objects.deepEquals(currentBattery, other.currentBattery)) return false;
        if (!Objects.deepEquals(batteryRemaining, other.batteryRemaining)) return false;
        if (!Objects.deepEquals(dropRateComm, other.dropRateComm)) return false;
        if (!Objects.deepEquals(errorsComm, other.errorsComm)) return false;
        if (!Objects.deepEquals(errorsCount1, other.errorsCount1)) return false;
        if (!Objects.deepEquals(errorsCount2, other.errorsCount2)) return false;
        if (!Objects.deepEquals(errorsCount3, other.errorsCount3)) return false;
        if (!Objects.deepEquals(errorsCount4, other.errorsCount4)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(onboardControlSensorsPresent);
        result = 31 * result + Objects.hashCode(onboardControlSensorsEnabled);
        result = 31 * result + Objects.hashCode(onboardControlSensorsHealth);
        result = 31 * result + Objects.hashCode(load);
        result = 31 * result + Objects.hashCode(voltageBattery);
        result = 31 * result + Objects.hashCode(currentBattery);
        result = 31 * result + Objects.hashCode(batteryRemaining);
        result = 31 * result + Objects.hashCode(dropRateComm);
        result = 31 * result + Objects.hashCode(errorsComm);
        result = 31 * result + Objects.hashCode(errorsCount1);
        result = 31 * result + Objects.hashCode(errorsCount2);
        result = 31 * result + Objects.hashCode(errorsCount3);
        result = 31 * result + Objects.hashCode(errorsCount4);
        return result;
    }

    @Override
    public String toString() {
        return "SysStatus{onboardControlSensorsPresent=" + onboardControlSensorsPresent
                 + ", onboardControlSensorsEnabled=" + onboardControlSensorsEnabled
                 + ", onboardControlSensorsHealth=" + onboardControlSensorsHealth
                 + ", load=" + load
                 + ", voltageBattery=" + voltageBattery
                 + ", currentBattery=" + currentBattery
                 + ", batteryRemaining=" + batteryRemaining
                 + ", dropRateComm=" + dropRateComm
                 + ", errorsComm=" + errorsComm
                 + ", errorsCount1=" + errorsCount1
                 + ", errorsCount2=" + errorsCount2
                 + ", errorsCount3=" + errorsCount3
                 + ", errorsCount4=" + errorsCount4 + "}";
    }

    public static final class Builder {
        private EnumValue<MavSysStatusSensor> onboardControlSensorsPresent;

        private EnumValue<MavSysStatusSensor> onboardControlSensorsEnabled;

        private EnumValue<MavSysStatusSensor> onboardControlSensorsHealth;

        private int load;

        private int voltageBattery;

        private int currentBattery;

        private int batteryRemaining;

        private int dropRateComm;

        private int errorsComm;

        private int errorsCount1;

        private int errorsCount2;

        private int errorsCount3;

        private int errorsCount4;

        /**
         * Bitmap showing which onboard controllers and sensors are present. Value of 0: not present. 
         * Value of 1: present. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                enumType = MavSysStatusSensor.class,
                description = "Bitmap showing which onboard controllers and sensors are present. Value of 0: not present. Value of 1: present."
        )
        public final Builder onboardControlSensorsPresent(
                EnumValue<MavSysStatusSensor> onboardControlSensorsPresent) {
            this.onboardControlSensorsPresent = onboardControlSensorsPresent;
            return this;
        }

        /**
         * Bitmap showing which onboard controllers and sensors are present. Value of 0: not present. 
         * Value of 1: present. 
         */
        public final Builder onboardControlSensorsPresent(MavSysStatusSensor entry) {
            return onboardControlSensorsPresent(EnumValue.of(entry));
        }

        /**
         * Bitmap showing which onboard controllers and sensors are present. Value of 0: not present. 
         * Value of 1: present. 
         */
        public final Builder onboardControlSensorsPresent(Enum... flags) {
            return onboardControlSensorsPresent(EnumValue.create(flags));
        }

        /**
         * Bitmap showing which onboard controllers and sensors are present. Value of 0: not present. 
         * Value of 1: present. 
         */
        public final Builder onboardControlSensorsPresent(Collection<Enum> flags) {
            return onboardControlSensorsPresent(EnumValue.create(flags));
        }

        /**
         * Bitmap showing which onboard controllers and sensors are enabled: Value of 0: not enabled. 
         * Value of 1: enabled. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                enumType = MavSysStatusSensor.class,
                description = "Bitmap showing which onboard controllers and sensors are enabled:  Value of 0: not enabled. Value of 1: enabled."
        )
        public final Builder onboardControlSensorsEnabled(
                EnumValue<MavSysStatusSensor> onboardControlSensorsEnabled) {
            this.onboardControlSensorsEnabled = onboardControlSensorsEnabled;
            return this;
        }

        /**
         * Bitmap showing which onboard controllers and sensors are enabled: Value of 0: not enabled. 
         * Value of 1: enabled. 
         */
        public final Builder onboardControlSensorsEnabled(MavSysStatusSensor entry) {
            return onboardControlSensorsEnabled(EnumValue.of(entry));
        }

        /**
         * Bitmap showing which onboard controllers and sensors are enabled: Value of 0: not enabled. 
         * Value of 1: enabled. 
         */
        public final Builder onboardControlSensorsEnabled(Enum... flags) {
            return onboardControlSensorsEnabled(EnumValue.create(flags));
        }

        /**
         * Bitmap showing which onboard controllers and sensors are enabled: Value of 0: not enabled. 
         * Value of 1: enabled. 
         */
        public final Builder onboardControlSensorsEnabled(Collection<Enum> flags) {
            return onboardControlSensorsEnabled(EnumValue.create(flags));
        }

        /**
         * Bitmap showing which onboard controllers and sensors are operational or have an error: Value 
         * of 0: not enabled. Value of 1: enabled. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                enumType = MavSysStatusSensor.class,
                description = "Bitmap showing which onboard controllers and sensors are operational or have an error:  Value of 0: not enabled. Value of 1: enabled."
        )
        public final Builder onboardControlSensorsHealth(
                EnumValue<MavSysStatusSensor> onboardControlSensorsHealth) {
            this.onboardControlSensorsHealth = onboardControlSensorsHealth;
            return this;
        }

        /**
         * Bitmap showing which onboard controllers and sensors are operational or have an error: Value 
         * of 0: not enabled. Value of 1: enabled. 
         */
        public final Builder onboardControlSensorsHealth(MavSysStatusSensor entry) {
            return onboardControlSensorsHealth(EnumValue.of(entry));
        }

        /**
         * Bitmap showing which onboard controllers and sensors are operational or have an error: Value 
         * of 0: not enabled. Value of 1: enabled. 
         */
        public final Builder onboardControlSensorsHealth(Enum... flags) {
            return onboardControlSensorsHealth(EnumValue.create(flags));
        }

        /**
         * Bitmap showing which onboard controllers and sensors are operational or have an error: Value 
         * of 0: not enabled. Value of 1: enabled. 
         */
        public final Builder onboardControlSensorsHealth(Collection<Enum> flags) {
            return onboardControlSensorsHealth(EnumValue.create(flags));
        }

        /**
         * Maximum usage in percent of the mainloop time. Values: [0-1000] - should always be below 1000 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                description = "Maximum usage in percent of the mainloop time. Values: [0-1000] - should always be below 1000"
        )
        public final Builder load(int load) {
            this.load = load;
            return this;
        }

        /**
         * Battery voltage 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                description = "Battery voltage"
        )
        public final Builder voltageBattery(int voltageBattery) {
            this.voltageBattery = voltageBattery;
            return this;
        }

        /**
         * Battery current, -1: autopilot does not measure the current 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                signed = true,
                description = "Battery current, -1: autopilot does not measure the current"
        )
        public final Builder currentBattery(int currentBattery) {
            this.currentBattery = currentBattery;
            return this;
        }

        /**
         * Remaining battery energy, -1: autopilot estimate the remaining battery 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 1,
                signed = true,
                description = "Remaining battery energy, -1: autopilot estimate the remaining battery"
        )
        public final Builder batteryRemaining(int batteryRemaining) {
            this.batteryRemaining = batteryRemaining;
            return this;
        }

        /**
         * Communication drop rate, (UART, I2C, SPI, CAN), dropped packets on all links (packets that 
         * were corrupted on reception on the MAV) 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 2,
                description = "Communication drop rate, (UART, I2C, SPI, CAN), dropped packets on all links (packets that were corrupted on reception on the MAV)"
        )
        public final Builder dropRateComm(int dropRateComm) {
            this.dropRateComm = dropRateComm;
            return this;
        }

        /**
         * Communication errors (UART, I2C, SPI, CAN), dropped packets on all links (packets that were 
         * corrupted on reception on the MAV) 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 2,
                description = "Communication errors (UART, I2C, SPI, CAN), dropped packets on all links (packets that were corrupted on reception on the MAV)"
        )
        public final Builder errorsComm(int errorsComm) {
            this.errorsComm = errorsComm;
            return this;
        }

        /**
         * Autopilot-specific errors 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 2,
                description = "Autopilot-specific errors"
        )
        public final Builder errorsCount1(int errorsCount1) {
            this.errorsCount1 = errorsCount1;
            return this;
        }

        /**
         * Autopilot-specific errors 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 2,
                description = "Autopilot-specific errors"
        )
        public final Builder errorsCount2(int errorsCount2) {
            this.errorsCount2 = errorsCount2;
            return this;
        }

        /**
         * Autopilot-specific errors 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 2,
                description = "Autopilot-specific errors"
        )
        public final Builder errorsCount3(int errorsCount3) {
            this.errorsCount3 = errorsCount3;
            return this;
        }

        /**
         * Autopilot-specific errors 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 2,
                description = "Autopilot-specific errors"
        )
        public final Builder errorsCount4(int errorsCount4) {
            this.errorsCount4 = errorsCount4;
            return this;
        }

        public final SysStatus build() {
            return new SysStatus(onboardControlSensorsPresent, onboardControlSensorsEnabled, onboardControlSensorsHealth, load, voltageBattery, currentBattery, batteryRemaining, dropRateComm, errorsComm, errorsCount1, errorsCount2, errorsCount3, errorsCount4);
        }
    }
}
