package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * 2nd Battery status 
 */
@MavlinkMessageInfo(
        id = 181,
        crc = 174,
        description = "2nd Battery status"
)
public final class Battery2 {
    private final int voltage;

    private final int currentBattery;

    private Battery2(int voltage, int currentBattery) {
        this.voltage = voltage;
        this.currentBattery = currentBattery;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Voltage. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2,
            description = "Voltage."
    )
    public final int voltage() {
        return this.voltage;
    }

    /**
     * Battery current, -1: autopilot does not measure the current. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            signed = true,
            description = "Battery current, -1: autopilot does not measure the current."
    )
    public final int currentBattery() {
        return this.currentBattery;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        Battery2 other = (Battery2)o;
        if (!Objects.deepEquals(voltage, other.voltage)) return false;
        if (!Objects.deepEquals(currentBattery, other.currentBattery)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(voltage);
        result = 31 * result + Objects.hashCode(currentBattery);
        return result;
    }

    @Override
    public String toString() {
        return "Battery2{voltage=" + voltage
                 + ", currentBattery=" + currentBattery + "}";
    }

    public static final class Builder {
        private int voltage;

        private int currentBattery;

        /**
         * Voltage. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2,
                description = "Voltage."
        )
        public final Builder voltage(int voltage) {
            this.voltage = voltage;
            return this;
        }

        /**
         * Battery current, -1: autopilot does not measure the current. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                signed = true,
                description = "Battery current, -1: autopilot does not measure the current."
        )
        public final Builder currentBattery(int currentBattery) {
            this.currentBattery = currentBattery;
            return this;
        }

        public final Battery2 build() {
            return new Battery2(voltage, currentBattery);
        }
    }
}
