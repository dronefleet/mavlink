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
 * Optical flow from an angular rate flow sensor (e.g. PX4FLOW or mouse sensor) 
 */
@MavlinkMessageInfo(
        id = 106,
        crc = 138,
        description = "Optical flow from an angular rate flow sensor (e.g. PX4FLOW or mouse sensor)"
)
public final class OpticalFlowRad {
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

    private OpticalFlowRad(BigInteger timeUsec, int sensorId, long integrationTimeUs,
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
     * Integration time. Divide integrated_x and integrated_y by the integration time to obtain 
     * average flow. The integration time also indicates the. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Integration time. Divide integrated_x and integrated_y by the integration time to obtain average flow. The integration time also indicates the."
    )
    public final long integrationTimeUs() {
        return this.integrationTimeUs;
    }

    /**
     * Flow around X axis (Sensor RH rotation about the X axis induces a positive flow. Sensor linear 
     * motion along the positive Y axis induces a negative flow.) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Flow around X axis (Sensor RH rotation about the X axis induces a positive flow. Sensor linear motion along the positive Y axis induces a negative flow.)"
    )
    public final float integratedX() {
        return this.integratedX;
    }

    /**
     * Flow around Y axis (Sensor RH rotation about the Y axis induces a positive flow. Sensor linear 
     * motion along the positive X axis induces a positive flow.) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Flow around Y axis (Sensor RH rotation about the Y axis induces a positive flow. Sensor linear motion along the positive X axis induces a positive flow.)"
    )
    public final float integratedY() {
        return this.integratedY;
    }

    /**
     * RH rotation around X axis 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "RH rotation around X axis"
    )
    public final float integratedXgyro() {
        return this.integratedXgyro;
    }

    /**
     * RH rotation around Y axis 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "RH rotation around Y axis"
    )
    public final float integratedYgyro() {
        return this.integratedYgyro;
    }

    /**
     * RH rotation around Z axis 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "RH rotation around Z axis"
    )
    public final float integratedZgyro() {
        return this.integratedZgyro;
    }

    /**
     * Temperature 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 2,
            signed = true,
            description = "Temperature"
    )
    public final int temperature() {
        return this.temperature;
    }

    /**
     * Optical flow quality / confidence. 0: no valid flow, 255: maximum quality 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 1,
            description = "Optical flow quality / confidence. 0: no valid flow, 255: maximum quality"
    )
    public final int quality() {
        return this.quality;
    }

    /**
     * Time since the distance was sampled. 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4,
            description = "Time since the distance was sampled."
    )
    public final long timeDeltaDistanceUs() {
        return this.timeDeltaDistanceUs;
    }

    /**
     * Distance to the center of the flow field. Positive value (including zero): distance known. 
     * Negative value: Unknown distance. 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4,
            description = "Distance to the center of the flow field. Positive value (including zero): distance known. Negative value: Unknown distance."
    )
    public final float distance() {
        return this.distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        OpticalFlowRad other = (OpticalFlowRad)o;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(sensorId, other.sensorId)) return false;
        if (!Objects.deepEquals(integrationTimeUs, other.integrationTimeUs)) return false;
        if (!Objects.deepEquals(integratedX, other.integratedX)) return false;
        if (!Objects.deepEquals(integratedY, other.integratedY)) return false;
        if (!Objects.deepEquals(integratedXgyro, other.integratedXgyro)) return false;
        if (!Objects.deepEquals(integratedYgyro, other.integratedYgyro)) return false;
        if (!Objects.deepEquals(integratedZgyro, other.integratedZgyro)) return false;
        if (!Objects.deepEquals(temperature, other.temperature)) return false;
        if (!Objects.deepEquals(quality, other.quality)) return false;
        if (!Objects.deepEquals(timeDeltaDistanceUs, other.timeDeltaDistanceUs)) return false;
        if (!Objects.deepEquals(distance, other.distance)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeUsec);
        result = 31 * result + Objects.hashCode(sensorId);
        result = 31 * result + Objects.hashCode(integrationTimeUs);
        result = 31 * result + Objects.hashCode(integratedX);
        result = 31 * result + Objects.hashCode(integratedY);
        result = 31 * result + Objects.hashCode(integratedXgyro);
        result = 31 * result + Objects.hashCode(integratedYgyro);
        result = 31 * result + Objects.hashCode(integratedZgyro);
        result = 31 * result + Objects.hashCode(temperature);
        result = 31 * result + Objects.hashCode(quality);
        result = 31 * result + Objects.hashCode(timeDeltaDistanceUs);
        result = 31 * result + Objects.hashCode(distance);
        return result;
    }

    @Override
    public String toString() {
        return "OpticalFlowRad{timeUsec=" + timeUsec
                 + ", sensorId=" + sensorId
                 + ", integrationTimeUs=" + integrationTimeUs
                 + ", integratedX=" + integratedX
                 + ", integratedY=" + integratedY
                 + ", integratedXgyro=" + integratedXgyro
                 + ", integratedYgyro=" + integratedYgyro
                 + ", integratedZgyro=" + integratedZgyro
                 + ", temperature=" + temperature
                 + ", quality=" + quality
                 + ", timeDeltaDistanceUs=" + timeDeltaDistanceUs
                 + ", distance=" + distance + "}";
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
         * Integration time. Divide integrated_x and integrated_y by the integration time to obtain 
         * average flow. The integration time also indicates the. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Integration time. Divide integrated_x and integrated_y by the integration time to obtain average flow. The integration time also indicates the."
        )
        public final Builder integrationTimeUs(long integrationTimeUs) {
            this.integrationTimeUs = integrationTimeUs;
            return this;
        }

        /**
         * Flow around X axis (Sensor RH rotation about the X axis induces a positive flow. Sensor linear 
         * motion along the positive Y axis induces a negative flow.) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "Flow around X axis (Sensor RH rotation about the X axis induces a positive flow. Sensor linear motion along the positive Y axis induces a negative flow.)"
        )
        public final Builder integratedX(float integratedX) {
            this.integratedX = integratedX;
            return this;
        }

        /**
         * Flow around Y axis (Sensor RH rotation about the Y axis induces a positive flow. Sensor linear 
         * motion along the positive X axis induces a positive flow.) 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Flow around Y axis (Sensor RH rotation about the Y axis induces a positive flow. Sensor linear motion along the positive X axis induces a positive flow.)"
        )
        public final Builder integratedY(float integratedY) {
            this.integratedY = integratedY;
            return this;
        }

        /**
         * RH rotation around X axis 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "RH rotation around X axis"
        )
        public final Builder integratedXgyro(float integratedXgyro) {
            this.integratedXgyro = integratedXgyro;
            return this;
        }

        /**
         * RH rotation around Y axis 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "RH rotation around Y axis"
        )
        public final Builder integratedYgyro(float integratedYgyro) {
            this.integratedYgyro = integratedYgyro;
            return this;
        }

        /**
         * RH rotation around Z axis 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "RH rotation around Z axis"
        )
        public final Builder integratedZgyro(float integratedZgyro) {
            this.integratedZgyro = integratedZgyro;
            return this;
        }

        /**
         * Temperature 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 2,
                signed = true,
                description = "Temperature"
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
                unitSize = 1,
                description = "Optical flow quality / confidence. 0: no valid flow, 255: maximum quality"
        )
        public final Builder quality(int quality) {
            this.quality = quality;
            return this;
        }

        /**
         * Time since the distance was sampled. 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4,
                description = "Time since the distance was sampled."
        )
        public final Builder timeDeltaDistanceUs(long timeDeltaDistanceUs) {
            this.timeDeltaDistanceUs = timeDeltaDistanceUs;
            return this;
        }

        /**
         * Distance to the center of the flow field. Positive value (including zero): distance known. 
         * Negative value: Unknown distance. 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 4,
                description = "Distance to the center of the flow field. Positive value (including zero): distance known. Negative value: Unknown distance."
        )
        public final Builder distance(float distance) {
            this.distance = distance;
            return this;
        }

        public final OpticalFlowRad build() {
            return new OpticalFlowRad(timeUsec, sensorId, integrationTimeUs, integratedX, integratedY, integratedXgyro, integratedYgyro, integratedZgyro, temperature, quality, timeDeltaDistanceUs, distance);
        }
    }
}
