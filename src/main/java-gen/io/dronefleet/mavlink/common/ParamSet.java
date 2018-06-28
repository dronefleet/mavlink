package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.String;

/**
 * Set a parameter value TEMPORARILY to RAM. It will be reset to default on system reboot. Send the 
 * ACTION MAV_ACTION_STORAGE_WRITE to PERMANENTLY write the RAM contents to EEPROM. 
 * IMPORTANT: The receiving component should acknowledge the new parameter value by sending a 
 * param_value message to all communication partners. This will also ensure that multiple GCS 
 * all have an up-to-date list of all parameters. If the sending GCS did not receive a {@link io.dronefleet.mavlink.common.ParamValue PARAM_VALUE} 
 * message within its timeout time, it should re-send the {@link io.dronefleet.mavlink.common.ParamSet PARAM_SET} message. 
 */
@MavlinkMessageInfo(
        id = 23,
        crc = 168
)
public final class ParamSet {
    private final int targetSystem;

    private final int targetComponent;

    private final String paramId;

    private final float paramValue;

    private final MavParamType paramType;

    private ParamSet(int targetSystem, int targetComponent, String paramId, float paramValue,
            MavParamType paramType) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.paramId = paramId;
        this.paramValue = paramValue;
        this.paramType = paramType;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * System ID 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Component ID 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and 
     * WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to 
     * provide 16+1 bytes storage if the ID is stored as string 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            arraySize = 16
    )
    public final String paramId() {
        return this.paramId;
    }

    /**
     * Onboard parameter value 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float paramValue() {
        return this.paramValue;
    }

    /**
     * Onboard parameter type: see the {@link io.dronefleet.mavlink.common.MavParamType MAV_PARAM_TYPE} enum for supported data types. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1
    )
    public final MavParamType paramType() {
        return this.paramType;
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private String paramId;

        private float paramValue;

        private MavParamType paramType;

        /**
         * System ID 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * Component ID 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and 
         * WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to 
         * provide 16+1 bytes storage if the ID is stored as string 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                arraySize = 16
        )
        public final Builder paramId(String paramId) {
            this.paramId = paramId;
            return this;
        }

        /**
         * Onboard parameter value 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder paramValue(float paramValue) {
            this.paramValue = paramValue;
            return this;
        }

        /**
         * Onboard parameter type: see the {@link io.dronefleet.mavlink.common.MavParamType MAV_PARAM_TYPE} enum for supported data types. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1
        )
        public final Builder paramType(MavParamType paramType) {
            this.paramType = paramType;
            return this;
        }

        public final ParamSet build() {
            return new ParamSet(targetSystem, targetComponent, paramId, paramValue, paramType);
        }
    }
}
