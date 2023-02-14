package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.Objects;

/**
 * Optical flow from a flow sensor (e.g. optical mouse sensor) 
 */
@MavlinkMessageInfo(
        id = 100,
        crc = 175,
        description = "Optical flow from a flow sensor (e.g. optical mouse sensor)"
)
public final class OpticalFlow {
    private final BigInteger timeUsec;

    private final int sensorId;

    private final int flowX;

    private final int flowY;

    private final float flowCompMX;

    private final float flowCompMY;

    private final int quality;

    private final float groundDistance;

    private final float flowRateX;

    private final float flowRateY;

    private OpticalFlow(BigInteger timeUsec, int sensorId, int flowX, int flowY, float flowCompMX,
            float flowCompMY, int quality, float groundDistance, float flowRateX, float flowRateY) {
        this.timeUsec = timeUsec;
        this.sensorId = sensorId;
        this.flowX = flowX;
        this.flowY = flowY;
        this.flowCompMX = flowCompMX;
        this.flowCompMY = flowCompMY;
        this.quality = quality;
        this.groundDistance = groundDistance;
        this.flowRateX = flowRateX;
        this.flowRateY = flowRateY;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp 
     * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8,
            description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number."
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    /**
     * Sensor ID 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Sensor ID"
    )
    public final int sensorId() {
        return this.sensorId;
    }

    /**
     * Flow in x-sensor direction 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            signed = true,
            description = "Flow in x-sensor direction"
    )
    public final int flowX() {
        return this.flowX;
    }

    /**
     * Flow in y-sensor direction 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            signed = true,
            description = "Flow in y-sensor direction"
    )
    public final int flowY() {
        return this.flowY;
    }

    /**
     * Flow in x-sensor direction, angular-speed compensated 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Flow in x-sensor direction, angular-speed compensated"
    )
    public final float flowCompMX() {
        return this.flowCompMX;
    }

    /**
     * Flow in y-sensor direction, angular-speed compensated 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Flow in y-sensor direction, angular-speed compensated"
    )
    public final float flowCompMY() {
        return this.flowCompMY;
    }

    /**
     * Optical flow quality / confidence. 0: bad, 255: maximum quality 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1,
            description = "Optical flow quality / confidence. 0: bad, 255: maximum quality"
    )
    public final int quality() {
        return this.quality;
    }

    /**
     * Ground distance. Positive value: distance known. Negative value: Unknown distance 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "Ground distance. Positive value: distance known. Negative value: Unknown distance"
    )
    public final float groundDistance() {
        return this.groundDistance;
    }

    /**
     * Flow rate about X axis 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            extension = true,
            description = "Flow rate about X axis"
    )
    public final float flowRateX() {
        return this.flowRateX;
    }

    /**
     * Flow rate about Y axis 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4,
            extension = true,
            description = "Flow rate about Y axis"
    )
    public final float flowRateY() {
        return this.flowRateY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        OpticalFlow other = (OpticalFlow)o;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(sensorId, other.sensorId)) return false;
        if (!Objects.deepEquals(flowX, other.flowX)) return false;
        if (!Objects.deepEquals(flowY, other.flowY)) return false;
        if (!Objects.deepEquals(flowCompMX, other.flowCompMX)) return false;
        if (!Objects.deepEquals(flowCompMY, other.flowCompMY)) return false;
        if (!Objects.deepEquals(quality, other.quality)) return false;
        if (!Objects.deepEquals(groundDistance, other.groundDistance)) return false;
        if (!Objects.deepEquals(flowRateX, other.flowRateX)) return false;
        if (!Objects.deepEquals(flowRateY, other.flowRateY)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeUsec);
        result = 31 * result + Objects.hashCode(sensorId);
        result = 31 * result + Objects.hashCode(flowX);
        result = 31 * result + Objects.hashCode(flowY);
        result = 31 * result + Objects.hashCode(flowCompMX);
        result = 31 * result + Objects.hashCode(flowCompMY);
        result = 31 * result + Objects.hashCode(quality);
        result = 31 * result + Objects.hashCode(groundDistance);
        result = 31 * result + Objects.hashCode(flowRateX);
        result = 31 * result + Objects.hashCode(flowRateY);
        return result;
    }

    @Override
    public String toString() {
        return "OpticalFlow{timeUsec=" + timeUsec
                 + ", sensorId=" + sensorId
                 + ", flowX=" + flowX
                 + ", flowY=" + flowY
                 + ", flowCompMX=" + flowCompMX
                 + ", flowCompMY=" + flowCompMY
                 + ", quality=" + quality
                 + ", groundDistance=" + groundDistance
                 + ", flowRateX=" + flowRateX
                 + ", flowRateY=" + flowRateY + "}";
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private int sensorId;

        private int flowX;

        private int flowY;

        private float flowCompMX;

        private float flowCompMY;

        private int quality;

        private float groundDistance;

        private float flowRateX;

        private float flowRateY;

        /**
         * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp 
         * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8,
                description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number."
        )
        public final Builder timeUsec(BigInteger timeUsec) {
            this.timeUsec = timeUsec;
            return this;
        }

        /**
         * Sensor ID 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Sensor ID"
        )
        public final Builder sensorId(int sensorId) {
            this.sensorId = sensorId;
            return this;
        }

        /**
         * Flow in x-sensor direction 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                signed = true,
                description = "Flow in x-sensor direction"
        )
        public final Builder flowX(int flowX) {
            this.flowX = flowX;
            return this;
        }

        /**
         * Flow in y-sensor direction 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                signed = true,
                description = "Flow in y-sensor direction"
        )
        public final Builder flowY(int flowY) {
            this.flowY = flowY;
            return this;
        }

        /**
         * Flow in x-sensor direction, angular-speed compensated 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Flow in x-sensor direction, angular-speed compensated"
        )
        public final Builder flowCompMX(float flowCompMX) {
            this.flowCompMX = flowCompMX;
            return this;
        }

        /**
         * Flow in y-sensor direction, angular-speed compensated 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "Flow in y-sensor direction, angular-speed compensated"
        )
        public final Builder flowCompMY(float flowCompMY) {
            this.flowCompMY = flowCompMY;
            return this;
        }

        /**
         * Optical flow quality / confidence. 0: bad, 255: maximum quality 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 1,
                description = "Optical flow quality / confidence. 0: bad, 255: maximum quality"
        )
        public final Builder quality(int quality) {
            this.quality = quality;
            return this;
        }

        /**
         * Ground distance. Positive value: distance known. Negative value: Unknown distance 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "Ground distance. Positive value: distance known. Negative value: Unknown distance"
        )
        public final Builder groundDistance(float groundDistance) {
            this.groundDistance = groundDistance;
            return this;
        }

        /**
         * Flow rate about X axis 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                extension = true,
                description = "Flow rate about X axis"
        )
        public final Builder flowRateX(float flowRateX) {
            this.flowRateX = flowRateX;
            return this;
        }

        /**
         * Flow rate about Y axis 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4,
                extension = true,
                description = "Flow rate about Y axis"
        )
        public final Builder flowRateY(float flowRateY) {
            this.flowRateY = flowRateY;
            return this;
        }

        public final OpticalFlow build() {
            return new OpticalFlow(timeUsec, sensorId, flowX, flowY, flowCompMX, flowCompMY, quality, groundDistance, flowRateX, flowRateY);
        }
    }
}
