package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Control vehicle LEDs. 
 */
@MavlinkMessageInfo(
        id = 186,
        crc = 72,
        description = "Control vehicle LEDs."
)
public final class LedControl {
    private final int targetSystem;

    private final int targetComponent;

    private final int instance;

    private final int pattern;

    private final int customLen;

    private final byte[] customBytes;

    private LedControl(int targetSystem, int targetComponent, int instance, int pattern,
            int customLen, byte[] customBytes) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.instance = instance;
        this.pattern = pattern;
        this.customLen = customLen;
        this.customBytes = customBytes;
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
     * Instance (LED instance to control or 255 for all LEDs). 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "Instance (LED instance to control or 255 for all LEDs)."
    )
    public final int instance() {
        return this.instance;
    }

    /**
     * Pattern (see LED_PATTERN_ENUM). 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            description = "Pattern (see LED_PATTERN_ENUM)."
    )
    public final int pattern() {
        return this.pattern;
    }

    /**
     * Custom Byte Length. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            description = "Custom Byte Length."
    )
    public final int customLen() {
        return this.customLen;
    }

    /**
     * Custom Bytes. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            arraySize = 24,
            description = "Custom Bytes."
    )
    public final byte[] customBytes() {
        return this.customBytes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        LedControl other = (LedControl)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(instance, other.instance)) return false;
        if (!Objects.deepEquals(pattern, other.pattern)) return false;
        if (!Objects.deepEquals(customLen, other.customLen)) return false;
        if (!Objects.deepEquals(customBytes, other.customBytes)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(instance);
        result = 31 * result + Objects.hashCode(pattern);
        result = 31 * result + Objects.hashCode(customLen);
        result = 31 * result + Objects.hashCode(customBytes);
        return result;
    }

    @Override
    public String toString() {
        return "LedControl{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", instance=" + instance
                 + ", pattern=" + pattern
                 + ", customLen=" + customLen
                 + ", customBytes=" + customBytes + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int instance;

        private int pattern;

        private int customLen;

        private byte[] customBytes;

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
         * Instance (LED instance to control or 255 for all LEDs). 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                description = "Instance (LED instance to control or 255 for all LEDs)."
        )
        public final Builder instance(int instance) {
            this.instance = instance;
            return this;
        }

        /**
         * Pattern (see LED_PATTERN_ENUM). 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                description = "Pattern (see LED_PATTERN_ENUM)."
        )
        public final Builder pattern(int pattern) {
            this.pattern = pattern;
            return this;
        }

        /**
         * Custom Byte Length. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                description = "Custom Byte Length."
        )
        public final Builder customLen(int customLen) {
            this.customLen = customLen;
            return this;
        }

        /**
         * Custom Bytes. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                arraySize = 24,
                description = "Custom Bytes."
        )
        public final Builder customBytes(byte[] customBytes) {
            this.customBytes = customBytes;
            return this;
        }

        public final LedControl build() {
            return new LedControl(targetSystem, targetComponent, instance, pattern, customLen, customBytes);
        }
    }
}
