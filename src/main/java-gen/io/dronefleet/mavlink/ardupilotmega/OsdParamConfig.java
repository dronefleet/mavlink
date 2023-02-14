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
 * Configure an OSD parameter slot. 
 */
@MavlinkMessageInfo(
        id = 11033,
        crc = 195,
        description = "Configure an OSD parameter slot."
)
public final class OsdParamConfig {
    private final int targetSystem;

    private final int targetComponent;

    private final long requestId;

    private final int osdScreen;

    private final int osdIndex;

    private final String paramId;

    private final EnumValue<OsdParamConfigType> configType;

    private final float minValue;

    private final float maxValue;

    private final float increment;

    private OsdParamConfig(int targetSystem, int targetComponent, long requestId, int osdScreen,
            int osdIndex, String paramId, EnumValue<OsdParamConfigType> configType, float minValue,
            float maxValue, float increment) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.requestId = requestId;
        this.osdScreen = osdScreen;
        this.osdIndex = osdIndex;
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
     * System ID. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "System ID."
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Component ID. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Component ID."
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * Request ID - copied to reply. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Request ID - copied to reply."
    )
    public final long requestId() {
        return this.requestId;
    }

    /**
     * OSD parameter screen index. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            description = "OSD parameter screen index."
    )
    public final int osdScreen() {
        return this.osdScreen;
    }

    /**
     * OSD parameter display index. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            description = "OSD parameter display index."
    )
    public final int osdIndex() {
        return this.osdIndex;
    }

    /**
     * Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and 
     * WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to 
     * provide 16+1 bytes storage if the ID is stored as string 
     */
    @MavlinkFieldInfo(
            position = 6,
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
            position = 7,
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
            position = 8,
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
            position = 9,
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
            position = 10,
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
        OsdParamConfig other = (OsdParamConfig)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(requestId, other.requestId)) return false;
        if (!Objects.deepEquals(osdScreen, other.osdScreen)) return false;
        if (!Objects.deepEquals(osdIndex, other.osdIndex)) return false;
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
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(requestId);
        result = 31 * result + Objects.hashCode(osdScreen);
        result = 31 * result + Objects.hashCode(osdIndex);
        result = 31 * result + Objects.hashCode(paramId);
        result = 31 * result + Objects.hashCode(configType);
        result = 31 * result + Objects.hashCode(minValue);
        result = 31 * result + Objects.hashCode(maxValue);
        result = 31 * result + Objects.hashCode(increment);
        return result;
    }

    @Override
    public String toString() {
        return "OsdParamConfig{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", requestId=" + requestId
                 + ", osdScreen=" + osdScreen
                 + ", osdIndex=" + osdIndex
                 + ", paramId=" + paramId
                 + ", configType=" + configType
                 + ", minValue=" + minValue
                 + ", maxValue=" + maxValue
                 + ", increment=" + increment + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private long requestId;

        private int osdScreen;

        private int osdIndex;

        private String paramId;

        private EnumValue<OsdParamConfigType> configType;

        private float minValue;

        private float maxValue;

        private float increment;

        /**
         * System ID. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "System ID."
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * Component ID. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Component ID."
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * Request ID - copied to reply. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Request ID - copied to reply."
        )
        public final Builder requestId(long requestId) {
            this.requestId = requestId;
            return this;
        }

        /**
         * OSD parameter screen index. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                description = "OSD parameter screen index."
        )
        public final Builder osdScreen(int osdScreen) {
            this.osdScreen = osdScreen;
            return this;
        }

        /**
         * OSD parameter display index. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                description = "OSD parameter display index."
        )
        public final Builder osdIndex(int osdIndex) {
            this.osdIndex = osdIndex;
            return this;
        }

        /**
         * Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and 
         * WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to 
         * provide 16+1 bytes storage if the ID is stored as string 
         */
        @MavlinkFieldInfo(
                position = 6,
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
                position = 7,
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
                position = 8,
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
                position = 9,
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
                position = 10,
                unitSize = 4,
                description = "OSD parameter increment."
        )
        public final Builder increment(float increment) {
            this.increment = increment;
            return this;
        }

        public final OsdParamConfig build() {
            return new OsdParamConfig(targetSystem, targetComponent, requestId, osdScreen, osdIndex, paramId, configType, minValue, maxValue, increment);
        }
    }
}
