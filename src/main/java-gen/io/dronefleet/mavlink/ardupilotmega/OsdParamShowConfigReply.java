package io.dronefleet.mavlink.ardupilotmega;

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
 * Read configured OSD parameter reply. 
 */
@MavlinkMessageInfo(
        id = 11036,
        crc = 177,
        description = "Read configured OSD parameter reply."
)
public final class OsdParamShowConfigReply {
    private final long requestId;

    private final EnumValue<OsdParamConfigError> result;

    private final String paramId;

    private final EnumValue<OsdParamConfigType> configType;

    private final float minValue;

    private final float maxValue;

    private final float increment;

    private OsdParamShowConfigReply(long requestId, EnumValue<OsdParamConfigError> result,
            String paramId, EnumValue<OsdParamConfigType> configType, float minValue,
            float maxValue, float increment) {
        this.requestId = requestId;
        this.result = result;
        this.paramId = paramId;
        this.configType = configType;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.increment = increment;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Request ID - copied from request. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            description = "Request ID - copied from request."
    )
    public final long requestId() {
        return this.requestId;
    }

    /**
     * Config error type. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            enumType = OsdParamConfigError.class,
            description = "Config error type."
    )
    public final EnumValue<OsdParamConfigError> result() {
        return this.result;
    }

    /**
     * Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and 
     * WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to 
     * provide 16+1 bytes storage if the ID is stored as string 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            arraySize = 16,
            description = "Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 16+1 bytes storage if the ID is stored as string"
    )
    public final String paramId() {
        return this.paramId;
    }

    /**
     * Config type. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            enumType = OsdParamConfigType.class,
            description = "Config type."
    )
    public final EnumValue<OsdParamConfigType> configType() {
        return this.configType;
    }

    /**
     * OSD parameter minimum value. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "OSD parameter minimum value."
    )
    public final float minValue() {
        return this.minValue;
    }

    /**
     * OSD parameter maximum value. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "OSD parameter maximum value."
    )
    public final float maxValue() {
        return this.maxValue;
    }

    /**
     * OSD parameter increment. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "OSD parameter increment."
    )
    public final float increment() {
        return this.increment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        OsdParamShowConfigReply other = (OsdParamShowConfigReply)o;
        if (!Objects.deepEquals(requestId, other.requestId)) return false;
        if (!Objects.deepEquals(result, other.result)) return false;
        if (!Objects.deepEquals(paramId, other.paramId)) return false;
        if (!Objects.deepEquals(configType, other.configType)) return false;
        if (!Objects.deepEquals(minValue, other.minValue)) return false;
        if (!Objects.deepEquals(maxValue, other.maxValue)) return false;
        if (!Objects.deepEquals(increment, other.increment)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(requestId);
        result = 31 * result + Objects.hashCode(result);
        result = 31 * result + Objects.hashCode(paramId);
        result = 31 * result + Objects.hashCode(configType);
        result = 31 * result + Objects.hashCode(minValue);
        result = 31 * result + Objects.hashCode(maxValue);
        result = 31 * result + Objects.hashCode(increment);
        return result;
    }

    @Override
    public String toString() {
        return "OsdParamShowConfigReply{requestId=" + requestId
                 + ", result=" + result
                 + ", paramId=" + paramId
                 + ", configType=" + configType
                 + ", minValue=" + minValue
                 + ", maxValue=" + maxValue
                 + ", increment=" + increment + "}";
    }

    public static final class Builder {
        private long requestId;

        private EnumValue<OsdParamConfigError> result;

        private String paramId;

        private EnumValue<OsdParamConfigType> configType;

        private float minValue;

        private float maxValue;

        private float increment;

        /**
         * Request ID - copied from request. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                description = "Request ID - copied from request."
        )
        public final Builder requestId(long requestId) {
            this.requestId = requestId;
            return this;
        }

        /**
         * Config error type. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                enumType = OsdParamConfigError.class,
                description = "Config error type."
        )
        public final Builder result(EnumValue<OsdParamConfigError> result) {
            this.result = result;
            return this;
        }

        /**
         * Config error type. 
         */
        public final Builder result(OsdParamConfigError entry) {
            return result(EnumValue.of(entry));
        }

        /**
         * Config error type. 
         */
        public final Builder result(Enum... flags) {
            return result(EnumValue.create(flags));
        }

        /**
         * Config error type. 
         */
        public final Builder result(Collection<Enum> flags) {
            return result(EnumValue.create(flags));
        }

        /**
         * Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and 
         * WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to 
         * provide 16+1 bytes storage if the ID is stored as string 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                arraySize = 16,
                description = "Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 16+1 bytes storage if the ID is stored as string"
        )
        public final Builder paramId(String paramId) {
            this.paramId = paramId;
            return this;
        }

        /**
         * Config type. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                enumType = OsdParamConfigType.class,
                description = "Config type."
        )
        public final Builder configType(EnumValue<OsdParamConfigType> configType) {
            this.configType = configType;
            return this;
        }

        /**
         * Config type. 
         */
        public final Builder configType(OsdParamConfigType entry) {
            return configType(EnumValue.of(entry));
        }

        /**
         * Config type. 
         */
        public final Builder configType(Enum... flags) {
            return configType(EnumValue.create(flags));
        }

        /**
         * Config type. 
         */
        public final Builder configType(Collection<Enum> flags) {
            return configType(EnumValue.create(flags));
        }

        /**
         * OSD parameter minimum value. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "OSD parameter minimum value."
        )
        public final Builder minValue(float minValue) {
            this.minValue = minValue;
            return this;
        }

        /**
         * OSD parameter maximum value. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "OSD parameter maximum value."
        )
        public final Builder maxValue(float maxValue) {
            this.maxValue = maxValue;
            return this;
        }

        /**
         * OSD parameter increment. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "OSD parameter increment."
        )
        public final Builder increment(float increment) {
            this.increment = increment;
            return this;
        }

        public final OsdParamShowConfigReply build() {
            return new OsdParamShowConfigReply(requestId, result, paramId, configType, minValue, maxValue, increment);
        }
    }
}
