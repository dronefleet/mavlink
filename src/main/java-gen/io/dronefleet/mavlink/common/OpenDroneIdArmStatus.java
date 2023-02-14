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
 * Transmitter (remote ID system) is enabled and ready to start sending location and other 
 * required information. This is streamed by transmitter. A flight controller uses it as a 
 * condition to arm. 
 */
@MavlinkMessageInfo(
        id = 12918,
        crc = 139,
        description = "Transmitter (remote ID system) is enabled and ready to start sending location and other required information. This is streamed by transmitter. A flight controller uses it as a condition to arm."
)
public final class OpenDroneIdArmStatus {
    private final EnumValue<MavOdidArmStatus> status;

    private final String error;

    private OpenDroneIdArmStatus(EnumValue<MavOdidArmStatus> status, String error) {
        this.status = status;
        this.error = error;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Status level indicating if arming is allowed. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            enumType = MavOdidArmStatus.class,
            description = "Status level indicating if arming is allowed."
    )
    public final EnumValue<MavOdidArmStatus> status() {
        return this.status;
    }

    /**
     * Text error message, should be empty if status is good to arm. Fill with nulls in unused portion. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            arraySize = 50,
            description = "Text error message, should be empty if status is good to arm. Fill with nulls in unused portion."
    )
    public final String error() {
        return this.error;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        OpenDroneIdArmStatus other = (OpenDroneIdArmStatus)o;
        if (!Objects.deepEquals(status, other.status)) return false;
        if (!Objects.deepEquals(error, other.error)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(status);
        result = 31 * result + Objects.hashCode(error);
        return result;
    }

    @Override
    public String toString() {
        return "OpenDroneIdArmStatus{status=" + status
                 + ", error=" + error + "}";
    }

    public static final class Builder {
        private EnumValue<MavOdidArmStatus> status;

        private String error;

        /**
         * Status level indicating if arming is allowed. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                enumType = MavOdidArmStatus.class,
                description = "Status level indicating if arming is allowed."
        )
        public final Builder status(EnumValue<MavOdidArmStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Status level indicating if arming is allowed. 
         */
        public final Builder status(MavOdidArmStatus entry) {
            return status(EnumValue.of(entry));
        }

        /**
         * Status level indicating if arming is allowed. 
         */
        public final Builder status(Enum... flags) {
            return status(EnumValue.create(flags));
        }

        /**
         * Status level indicating if arming is allowed. 
         */
        public final Builder status(Collection<Enum> flags) {
            return status(EnumValue.create(flags));
        }

        /**
         * Text error message, should be empty if status is good to arm. Fill with nulls in unused portion. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                arraySize = 50,
                description = "Text error message, should be empty if status is good to arm. Fill with nulls in unused portion."
        )
        public final Builder error(String error) {
            this.error = error;
            return this;
        }

        public final OpenDroneIdArmStatus build() {
            return new OpenDroneIdArmStatus(status, error);
        }
    }
}
