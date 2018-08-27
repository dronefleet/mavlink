package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Sensor and DSC control loads. 
 */
@MavlinkMessageInfo(
        id = 170,
        crc = 75
)
public final class CpuLoad {
    private final int sensload;

    private final int ctrlload;

    private final int batvolt;

    private CpuLoad(int sensload, int ctrlload, int batvolt) {
        this.sensload = sensload;
        this.ctrlload = ctrlload;
        this.batvolt = batvolt;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Sensor DSC Load 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int sensload() {
        return this.sensload;
    }

    /**
     * Control DSC Load 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int ctrlload() {
        return this.ctrlload;
    }

    /**
     * Battery Voltage 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2
    )
    public final int batvolt() {
        return this.batvolt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        CpuLoad other = (CpuLoad)o;
        if (!Objects.deepEquals(sensload, other.sensload)) return false;
        if (!Objects.deepEquals(ctrlload, other.ctrlload)) return false;
        if (!Objects.deepEquals(batvolt, other.batvolt)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(sensload);
        result = 31 * result + Objects.hashCode(ctrlload);
        result = 31 * result + Objects.hashCode(batvolt);
        return result;
    }

    @Override
    public String toString() {
        return "CpuLoad{sensload=" + sensload
                 + ", ctrlload=" + ctrlload
                 + ", batvolt=" + batvolt + "}";
    }

    public static final class Builder {
        private int sensload;

        private int ctrlload;

        private int batvolt;

        /**
         * Sensor DSC Load 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1
        )
        public final Builder sensload(int sensload) {
            this.sensload = sensload;
            return this;
        }

        /**
         * Control DSC Load 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder ctrlload(int ctrlload) {
            this.ctrlload = ctrlload;
            return this;
        }

        /**
         * Battery Voltage 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2
        )
        public final Builder batvolt(int batvolt) {
            this.batvolt = batvolt;
            return this;
        }

        public final CpuLoad build() {
            return new CpuLoad(sensload, ctrlload, batvolt);
        }
    }
}
