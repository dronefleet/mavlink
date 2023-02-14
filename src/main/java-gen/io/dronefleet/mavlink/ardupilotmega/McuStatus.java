package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * The MCU status, giving MCU temperature and voltage. The min and max voltages are to allow for 
 * detecting power supply instability. 
 */
@MavlinkMessageInfo(
        id = 11039,
        crc = 142,
        description = "The MCU status, giving MCU temperature and voltage. The min and max voltages are to allow for detecting power supply instability."
)
public final class McuStatus {
    private final int id;

    private final int mcuTemperature;

    private final int mcuVoltage;

    private final int mcuVoltageMin;

    private final int mcuVoltageMax;

    private McuStatus(int id, int mcuTemperature, int mcuVoltage, int mcuVoltageMin,
            int mcuVoltageMax) {
        this.id = id;
        this.mcuTemperature = mcuTemperature;
        this.mcuVoltage = mcuVoltage;
        this.mcuVoltageMin = mcuVoltageMin;
        this.mcuVoltageMax = mcuVoltageMax;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * MCU instance 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "MCU instance"
    )
    public final int id() {
        return this.id;
    }

    /**
     * MCU Internal temperature 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2,
            signed = true,
            description = "MCU Internal temperature"
    )
    public final int mcuTemperature() {
        return this.mcuTemperature;
    }

    /**
     * MCU voltage 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            description = "MCU voltage"
    )
    public final int mcuVoltage() {
        return this.mcuVoltage;
    }

    /**
     * MCU voltage minimum 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            description = "MCU voltage minimum"
    )
    public final int mcuVoltageMin() {
        return this.mcuVoltageMin;
    }

    /**
     * MCU voltage maximum 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            description = "MCU voltage maximum"
    )
    public final int mcuVoltageMax() {
        return this.mcuVoltageMax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        McuStatus other = (McuStatus)o;
        if (!Objects.deepEquals(id, other.id)) return false;
        if (!Objects.deepEquals(mcuTemperature, other.mcuTemperature)) return false;
        if (!Objects.deepEquals(mcuVoltage, other.mcuVoltage)) return false;
        if (!Objects.deepEquals(mcuVoltageMin, other.mcuVoltageMin)) return false;
        if (!Objects.deepEquals(mcuVoltageMax, other.mcuVoltageMax)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(mcuTemperature);
        result = 31 * result + Objects.hashCode(mcuVoltage);
        result = 31 * result + Objects.hashCode(mcuVoltageMin);
        result = 31 * result + Objects.hashCode(mcuVoltageMax);
        return result;
    }

    @Override
    public String toString() {
        return "McuStatus{id=" + id
                 + ", mcuTemperature=" + mcuTemperature
                 + ", mcuVoltage=" + mcuVoltage
                 + ", mcuVoltageMin=" + mcuVoltageMin
                 + ", mcuVoltageMax=" + mcuVoltageMax + "}";
    }

    public static final class Builder {
        private int id;

        private int mcuTemperature;

        private int mcuVoltage;

        private int mcuVoltageMin;

        private int mcuVoltageMax;

        /**
         * MCU instance 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "MCU instance"
        )
        public final Builder id(int id) {
            this.id = id;
            return this;
        }

        /**
         * MCU Internal temperature 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2,
                signed = true,
                description = "MCU Internal temperature"
        )
        public final Builder mcuTemperature(int mcuTemperature) {
            this.mcuTemperature = mcuTemperature;
            return this;
        }

        /**
         * MCU voltage 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                description = "MCU voltage"
        )
        public final Builder mcuVoltage(int mcuVoltage) {
            this.mcuVoltage = mcuVoltage;
            return this;
        }

        /**
         * MCU voltage minimum 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                description = "MCU voltage minimum"
        )
        public final Builder mcuVoltageMin(int mcuVoltageMin) {
            this.mcuVoltageMin = mcuVoltageMin;
            return this;
        }

        /**
         * MCU voltage maximum 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                description = "MCU voltage maximum"
        )
        public final Builder mcuVoltageMax(int mcuVoltageMax) {
            this.mcuVoltageMax = mcuVoltageMax;
            return this;
        }

        public final McuStatus build() {
            return new McuStatus(id, mcuTemperature, mcuVoltage, mcuVoltageMin, mcuVoltageMax);
        }
    }
}
