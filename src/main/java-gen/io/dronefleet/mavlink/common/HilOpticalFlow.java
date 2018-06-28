package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.math.BigInteger;

/**
 * Simulated optical flow from a flow sensor (e.g. PX4FLOW or optical mouse sensor) 
 */
@MavlinkMessageInfo(
        id = 114,
        crc = 237
)
public final class HilOpticalFlow {
    private final BigInteger timeUsec;

    private final int sensorId;

    private final long integrationTimeUs;

    private final float integratedX;

    private final float integratedY;

    private final float integratedXgyro;

    private final float integratedYgyro;

    private final float integratedZgyro;

    private final int temperature;

    private final int quality;

    private final long timeDeltaDistanceUs;

    private final float distance;

    private HilOpticalFlow(BigInteger timeUsec, int sensorId, long integrationTimeUs,
            float integratedX, float integratedY, float integratedXgyro, float integratedYgyro,
            float integratedZgyro, int temperature, int quality, long timeDeltaDistanceUs,
            float distance) {
        this.timeUsec = timeUsec;
        this.sensorId = sensorId;
        this.integrationTimeUs = integrationTimeUs;
        this.integratedX = integratedX;
        this.integratedY = integratedY;
        this.integratedXgyro = integratedXgyro;
        this.integratedYgyro = integratedYgyro;
        this.integratedZgyro = integratedZgyro;
        this.temperature = temperature;
        this.quality = quality;
        this.timeDeltaDistanceUs = timeDeltaDistanceUs;
        this.distance = distance;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (microseconds, synced to UNIX time or since system boot) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    /**
     * Sensor ID 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int sensorId() {
        return this.sensorId;
    }

    /**
     * Integration time in microseconds. Divide integrated_x and integrated_y by the integration 
     * time to obtain average flow. The integration time also indicates the. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final long integrationTimeUs() {
        return this.integrationTimeUs;
    }

    /**
     * Flow in radians around X axis (Sensor RH rotation about the X axis induces a positive flow. 
     * Sensor linear motion along the positive Y axis induces a negative flow.) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float integratedX() {
        return this.integratedX;
    }

    /**
     * Flow in radians around Y axis (Sensor RH rotation about the Y axis induces a positive flow. 
     * Sensor linear motion along the positive X axis induces a positive flow.) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float integratedY() {
        return this.integratedY;
    }

    /**
     * RH rotation around X axis (rad) 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float integratedXgyro() {
        return this.integratedXgyro;
    }

    /**
     * RH rotation around Y axis (rad) 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4
    )
    public final float integratedYgyro() {
        return this.integratedYgyro;
    }

    /**
     * RH rotation around Z axis (rad) 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4
    )
    public final float integratedZgyro() {
        return this.integratedZgyro;
    }

    /**
     * Temperature * 100 in centi-degrees Celsius 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 2,
            signed = true
    )
    public final int temperature() {
        return this.temperature;
    }

    /**
     * Optical flow quality / confidence. 0: no valid flow, 255: maximum quality 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 1
    )
    public final int quality() {
        return this.quality;
    }

    /**
     * Time in microseconds since the distance was sampled. 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4
    )
    public final long timeDeltaDistanceUs() {
        return this.timeDeltaDistanceUs;
    }

    /**
     * Distance to the center of the flow field in meters. Positive value (including zero): distance 
     * known. Negative value: Unknown distance. 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4
    )
    public final float distance() {
        return this.distance;
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private int sensorId;

        private long integrationTimeUs;

        private float integratedX;

        private float integratedY;

        private float integratedXgyro;

        private float integratedYgyro;

        private float integratedZgyro;

        private int temperature;

        private int quality;

        private long timeDeltaDistanceUs;

        private float distance;

        /**
         * Timestamp (microseconds, synced to UNIX time or since system boot) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8
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
                unitSize = 1
        )
        public final Builder sensorId(int sensorId) {
            this.sensorId = sensorId;
            return this;
        }

        /**
         * Integration time in microseconds. Divide integrated_x and integrated_y by the integration 
         * time to obtain average flow. The integration time also indicates the. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder integrationTimeUs(long integrationTimeUs) {
            this.integrationTimeUs = integrationTimeUs;
            return this;
        }

        /**
         * Flow in radians around X axis (Sensor RH rotation about the X axis induces a positive flow. 
         * Sensor linear motion along the positive Y axis induces a negative flow.) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder integratedX(float integratedX) {
            this.integratedX = integratedX;
            return this;
        }

        /**
         * Flow in radians around Y axis (Sensor RH rotation about the Y axis induces a positive flow. 
         * Sensor linear motion along the positive X axis induces a positive flow.) 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4
        )
        public final Builder integratedY(float integratedY) {
            this.integratedY = integratedY;
            return this;
        }

        /**
         * RH rotation around X axis (rad) 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4
        )
        public final Builder integratedXgyro(float integratedXgyro) {
            this.integratedXgyro = integratedXgyro;
            return this;
        }

        /**
         * RH rotation around Y axis (rad) 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4
        )
        public final Builder integratedYgyro(float integratedYgyro) {
            this.integratedYgyro = integratedYgyro;
            return this;
        }

        /**
         * RH rotation around Z axis (rad) 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4
        )
        public final Builder integratedZgyro(float integratedZgyro) {
            this.integratedZgyro = integratedZgyro;
            return this;
        }

        /**
         * Temperature * 100 in centi-degrees Celsius 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 2,
                signed = true
        )
        public final Builder temperature(int temperature) {
            this.temperature = temperature;
            return this;
        }

        /**
         * Optical flow quality / confidence. 0: no valid flow, 255: maximum quality 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 1
        )
        public final Builder quality(int quality) {
            this.quality = quality;
            return this;
        }

        /**
         * Time in microseconds since the distance was sampled. 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4
        )
        public final Builder timeDeltaDistanceUs(long timeDeltaDistanceUs) {
            this.timeDeltaDistanceUs = timeDeltaDistanceUs;
            return this;
        }

        /**
         * Distance to the center of the flow field in meters. Positive value (including zero): distance 
         * known. Negative value: Unknown distance. 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 4
        )
        public final Builder distance(float distance) {
            this.distance = distance;
            return this;
        }

        public final HilOpticalFlow build() {
            return new HilOpticalFlow(timeUsec, sensorId, integrationTimeUs, integratedX, integratedY, integratedXgyro, integratedYgyro, integratedZgyro, temperature, quality, timeDeltaDistanceUs, distance);
        }
    }
}
