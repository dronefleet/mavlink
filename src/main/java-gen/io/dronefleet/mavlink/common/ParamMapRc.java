package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Bind a RC channel to a parameter. The parameter should change accoding to the RC channel value. 
 */
@MavlinkMessageInfo(
        id = 50,
        crc = 78
)
public final class ParamMapRc {
    private final int targetSystem;

    private final int targetComponent;

    private final String paramId;

    private final int paramIndex;

    private final int parameterRcChannelIndex;

    private final float paramValue0;

    private final float scale;

    private final float paramValueMin;

    private final float paramValueMax;

    private ParamMapRc(int targetSystem, int targetComponent, String paramId, int paramIndex,
            int parameterRcChannelIndex, float paramValue0, float scale, float paramValueMin,
            float paramValueMax) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.paramId = paramId;
        this.paramIndex = paramIndex;
        this.parameterRcChannelIndex = parameterRcChannelIndex;
        this.paramValue0 = paramValue0;
        this.scale = scale;
        this.paramValueMin = paramValueMin;
        this.paramValueMax = paramValueMax;
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
     * Parameter index. Send -1 to use the param ID field as identifier (else the param id will be 
     * ignored), send -2 to disable any existing map for this rc_channel_index. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            signed = true
    )
    public final int paramIndex() {
        return this.paramIndex;
    }

    /**
     * Index of parameter RC channel. Not equal to the RC channel id. Typically correpsonds to a 
     * potentiometer-knob on the RC. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1
    )
    public final int parameterRcChannelIndex() {
        return this.parameterRcChannelIndex;
    }

    /**
     * Initial parameter value 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float paramValue0() {
        return this.paramValue0;
    }

    /**
     * Scale, maps the RC range [-1, 1] to a parameter value 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4
    )
    public final float scale() {
        return this.scale;
    }

    /**
     * Minimum param value. The protocol does not define if this overwrites an onboard minimum value. 
     * (Depends on implementation) 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4
    )
    public final float paramValueMin() {
        return this.paramValueMin;
    }

    /**
     * Maximum param value. The protocol does not define if this overwrites an onboard maximum value. 
     * (Depends on implementation) 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4
    )
    public final float paramValueMax() {
        return this.paramValueMax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        ParamMapRc other = (ParamMapRc)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(paramId, other.paramId)) return false;
        if (!Objects.deepEquals(paramIndex, other.paramIndex)) return false;
        if (!Objects.deepEquals(parameterRcChannelIndex, other.parameterRcChannelIndex)) return false;
        if (!Objects.deepEquals(paramValue0, other.paramValue0)) return false;
        if (!Objects.deepEquals(scale, other.scale)) return false;
        if (!Objects.deepEquals(paramValueMin, other.paramValueMin)) return false;
        if (!Objects.deepEquals(paramValueMax, other.paramValueMax)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(paramId);
        result = 31 * result + Objects.hashCode(paramIndex);
        result = 31 * result + Objects.hashCode(parameterRcChannelIndex);
        result = 31 * result + Objects.hashCode(paramValue0);
        result = 31 * result + Objects.hashCode(scale);
        result = 31 * result + Objects.hashCode(paramValueMin);
        result = 31 * result + Objects.hashCode(paramValueMax);
        return result;
    }

    @Override
    public String toString() {
        return "ParamMapRc{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", paramId=" + paramId
                 + ", paramIndex=" + paramIndex
                 + ", parameterRcChannelIndex=" + parameterRcChannelIndex
                 + ", paramValue0=" + paramValue0
                 + ", scale=" + scale
                 + ", paramValueMin=" + paramValueMin
                 + ", paramValueMax=" + paramValueMax + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private String paramId;

        private int paramIndex;

        private int parameterRcChannelIndex;

        private float paramValue0;

        private float scale;

        private float paramValueMin;

        private float paramValueMax;

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
         * Parameter index. Send -1 to use the param ID field as identifier (else the param id will be 
         * ignored), send -2 to disable any existing map for this rc_channel_index. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                signed = true
        )
        public final Builder paramIndex(int paramIndex) {
            this.paramIndex = paramIndex;
            return this;
        }

        /**
         * Index of parameter RC channel. Not equal to the RC channel id. Typically correpsonds to a 
         * potentiometer-knob on the RC. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1
        )
        public final Builder parameterRcChannelIndex(int parameterRcChannelIndex) {
            this.parameterRcChannelIndex = parameterRcChannelIndex;
            return this;
        }

        /**
         * Initial parameter value 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4
        )
        public final Builder paramValue0(float paramValue0) {
            this.paramValue0 = paramValue0;
            return this;
        }

        /**
         * Scale, maps the RC range [-1, 1] to a parameter value 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4
        )
        public final Builder scale(float scale) {
            this.scale = scale;
            return this;
        }

        /**
         * Minimum param value. The protocol does not define if this overwrites an onboard minimum value. 
         * (Depends on implementation) 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4
        )
        public final Builder paramValueMin(float paramValueMin) {
            this.paramValueMin = paramValueMin;
            return this;
        }

        /**
         * Maximum param value. The protocol does not define if this overwrites an onboard maximum value. 
         * (Depends on implementation) 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4
        )
        public final Builder paramValueMax(float paramValueMax) {
            this.paramValueMax = paramValueMax;
            return this;
        }

        public final ParamMapRc build() {
            return new ParamMapRc(targetSystem, targetComponent, paramId, paramIndex, parameterRcChannelIndex, paramValue0, scale, paramValueMin, paramValueMax);
        }
    }
}
