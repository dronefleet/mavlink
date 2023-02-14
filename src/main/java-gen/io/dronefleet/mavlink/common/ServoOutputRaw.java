package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Superseded by {@link io.dronefleet.mavlink.common.ActuatorOutputStatus ACTUATOR_OUTPUT_STATUS}. The RAW values of the servo outputs (for RC input from 
 * the remote, use the {@link io.dronefleet.mavlink.common.RcChannels RC_CHANNELS} messages). The standard PPM modulation is as follows: 1000 
 * microseconds: 0%, 2000 microseconds: 100%. 
 */
@MavlinkMessageInfo(
        id = 36,
        crc = 222,
        description = "Superseded by ACTUATOR_OUTPUT_STATUS. The RAW values of the servo outputs (for RC input from the remote, use the RC_CHANNELS messages). The standard PPM modulation is as follows: 1000 microseconds: 0%, 2000 microseconds: 100%."
)
public final class ServoOutputRaw {
    private final long timeUsec;

    private final int port;

    private final int servo1Raw;

    private final int servo2Raw;

    private final int servo3Raw;

    private final int servo4Raw;

    private final int servo5Raw;

    private final int servo6Raw;

    private final int servo7Raw;

    private final int servo8Raw;

    private final int servo9Raw;

    private final int servo10Raw;

    private final int servo11Raw;

    private final int servo12Raw;

    private final int servo13Raw;

    private final int servo14Raw;

    private final int servo15Raw;

    private final int servo16Raw;

    private ServoOutputRaw(long timeUsec, int port, int servo1Raw, int servo2Raw, int servo3Raw,
            int servo4Raw, int servo5Raw, int servo6Raw, int servo7Raw, int servo8Raw,
            int servo9Raw, int servo10Raw, int servo11Raw, int servo12Raw, int servo13Raw,
            int servo14Raw, int servo15Raw, int servo16Raw) {
        this.timeUsec = timeUsec;
        this.port = port;
        this.servo1Raw = servo1Raw;
        this.servo2Raw = servo2Raw;
        this.servo3Raw = servo3Raw;
        this.servo4Raw = servo4Raw;
        this.servo5Raw = servo5Raw;
        this.servo6Raw = servo6Raw;
        this.servo7Raw = servo7Raw;
        this.servo8Raw = servo8Raw;
        this.servo9Raw = servo9Raw;
        this.servo10Raw = servo10Raw;
        this.servo11Raw = servo11Raw;
        this.servo12Raw = servo12Raw;
        this.servo13Raw = servo13Raw;
        this.servo14Raw = servo14Raw;
        this.servo15Raw = servo15Raw;
        this.servo16Raw = servo16Raw;
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
            unitSize = 4,
            description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number."
    )
    public final long timeUsec() {
        return this.timeUsec;
    }

    /**
     * Servo output port (set of 8 outputs = 1 port). Flight stacks running on Pixhawk should use: 0 = 
     * MAIN, 1 = AUX. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Servo output port (set of 8 outputs = 1 port). Flight stacks running on Pixhawk should use: 0 = MAIN, 1 = AUX."
    )
    public final int port() {
        return this.port;
    }

    /**
     * Servo output 1 value 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            description = "Servo output 1 value"
    )
    public final int servo1Raw() {
        return this.servo1Raw;
    }

    /**
     * Servo output 2 value 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            description = "Servo output 2 value"
    )
    public final int servo2Raw() {
        return this.servo2Raw;
    }

    /**
     * Servo output 3 value 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            description = "Servo output 3 value"
    )
    public final int servo3Raw() {
        return this.servo3Raw;
    }

    /**
     * Servo output 4 value 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            description = "Servo output 4 value"
    )
    public final int servo4Raw() {
        return this.servo4Raw;
    }

    /**
     * Servo output 5 value 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2,
            description = "Servo output 5 value"
    )
    public final int servo5Raw() {
        return this.servo5Raw;
    }

    /**
     * Servo output 6 value 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 2,
            description = "Servo output 6 value"
    )
    public final int servo6Raw() {
        return this.servo6Raw;
    }

    /**
     * Servo output 7 value 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 2,
            description = "Servo output 7 value"
    )
    public final int servo7Raw() {
        return this.servo7Raw;
    }

    /**
     * Servo output 8 value 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 2,
            description = "Servo output 8 value"
    )
    public final int servo8Raw() {
        return this.servo8Raw;
    }

    /**
     * Servo output 9 value 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 2,
            extension = true,
            description = "Servo output 9 value"
    )
    public final int servo9Raw() {
        return this.servo9Raw;
    }

    /**
     * Servo output 10 value 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 2,
            extension = true,
            description = "Servo output 10 value"
    )
    public final int servo10Raw() {
        return this.servo10Raw;
    }

    /**
     * Servo output 11 value 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 2,
            extension = true,
            description = "Servo output 11 value"
    )
    public final int servo11Raw() {
        return this.servo11Raw;
    }

    /**
     * Servo output 12 value 
     */
    @MavlinkFieldInfo(
            position = 15,
            unitSize = 2,
            extension = true,
            description = "Servo output 12 value"
    )
    public final int servo12Raw() {
        return this.servo12Raw;
    }

    /**
     * Servo output 13 value 
     */
    @MavlinkFieldInfo(
            position = 16,
            unitSize = 2,
            extension = true,
            description = "Servo output 13 value"
    )
    public final int servo13Raw() {
        return this.servo13Raw;
    }

    /**
     * Servo output 14 value 
     */
    @MavlinkFieldInfo(
            position = 17,
            unitSize = 2,
            extension = true,
            description = "Servo output 14 value"
    )
    public final int servo14Raw() {
        return this.servo14Raw;
    }

    /**
     * Servo output 15 value 
     */
    @MavlinkFieldInfo(
            position = 18,
            unitSize = 2,
            extension = true,
            description = "Servo output 15 value"
    )
    public final int servo15Raw() {
        return this.servo15Raw;
    }

    /**
     * Servo output 16 value 
     */
    @MavlinkFieldInfo(
            position = 19,
            unitSize = 2,
            extension = true,
            description = "Servo output 16 value"
    )
    public final int servo16Raw() {
        return this.servo16Raw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        ServoOutputRaw other = (ServoOutputRaw)o;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(port, other.port)) return false;
        if (!Objects.deepEquals(servo1Raw, other.servo1Raw)) return false;
        if (!Objects.deepEquals(servo2Raw, other.servo2Raw)) return false;
        if (!Objects.deepEquals(servo3Raw, other.servo3Raw)) return false;
        if (!Objects.deepEquals(servo4Raw, other.servo4Raw)) return false;
        if (!Objects.deepEquals(servo5Raw, other.servo5Raw)) return false;
        if (!Objects.deepEquals(servo6Raw, other.servo6Raw)) return false;
        if (!Objects.deepEquals(servo7Raw, other.servo7Raw)) return false;
        if (!Objects.deepEquals(servo8Raw, other.servo8Raw)) return false;
        if (!Objects.deepEquals(servo9Raw, other.servo9Raw)) return false;
        if (!Objects.deepEquals(servo10Raw, other.servo10Raw)) return false;
        if (!Objects.deepEquals(servo11Raw, other.servo11Raw)) return false;
        if (!Objects.deepEquals(servo12Raw, other.servo12Raw)) return false;
        if (!Objects.deepEquals(servo13Raw, other.servo13Raw)) return false;
        if (!Objects.deepEquals(servo14Raw, other.servo14Raw)) return false;
        if (!Objects.deepEquals(servo15Raw, other.servo15Raw)) return false;
        if (!Objects.deepEquals(servo16Raw, other.servo16Raw)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeUsec);
        result = 31 * result + Objects.hashCode(port);
        result = 31 * result + Objects.hashCode(servo1Raw);
        result = 31 * result + Objects.hashCode(servo2Raw);
        result = 31 * result + Objects.hashCode(servo3Raw);
        result = 31 * result + Objects.hashCode(servo4Raw);
        result = 31 * result + Objects.hashCode(servo5Raw);
        result = 31 * result + Objects.hashCode(servo6Raw);
        result = 31 * result + Objects.hashCode(servo7Raw);
        result = 31 * result + Objects.hashCode(servo8Raw);
        result = 31 * result + Objects.hashCode(servo9Raw);
        result = 31 * result + Objects.hashCode(servo10Raw);
        result = 31 * result + Objects.hashCode(servo11Raw);
        result = 31 * result + Objects.hashCode(servo12Raw);
        result = 31 * result + Objects.hashCode(servo13Raw);
        result = 31 * result + Objects.hashCode(servo14Raw);
        result = 31 * result + Objects.hashCode(servo15Raw);
        result = 31 * result + Objects.hashCode(servo16Raw);
        return result;
    }

    @Override
    public String toString() {
        return "ServoOutputRaw{timeUsec=" + timeUsec
                 + ", port=" + port
                 + ", servo1Raw=" + servo1Raw
                 + ", servo2Raw=" + servo2Raw
                 + ", servo3Raw=" + servo3Raw
                 + ", servo4Raw=" + servo4Raw
                 + ", servo5Raw=" + servo5Raw
                 + ", servo6Raw=" + servo6Raw
                 + ", servo7Raw=" + servo7Raw
                 + ", servo8Raw=" + servo8Raw
                 + ", servo9Raw=" + servo9Raw
                 + ", servo10Raw=" + servo10Raw
                 + ", servo11Raw=" + servo11Raw
                 + ", servo12Raw=" + servo12Raw
                 + ", servo13Raw=" + servo13Raw
                 + ", servo14Raw=" + servo14Raw
                 + ", servo15Raw=" + servo15Raw
                 + ", servo16Raw=" + servo16Raw + "}";
    }

    public static final class Builder {
        private long timeUsec;

        private int port;

        private int servo1Raw;

        private int servo2Raw;

        private int servo3Raw;

        private int servo4Raw;

        private int servo5Raw;

        private int servo6Raw;

        private int servo7Raw;

        private int servo8Raw;

        private int servo9Raw;

        private int servo10Raw;

        private int servo11Raw;

        private int servo12Raw;

        private int servo13Raw;

        private int servo14Raw;

        private int servo15Raw;

        private int servo16Raw;

        /**
         * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp 
         * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number."
        )
        public final Builder timeUsec(long timeUsec) {
            this.timeUsec = timeUsec;
            return this;
        }

        /**
         * Servo output port (set of 8 outputs = 1 port). Flight stacks running on Pixhawk should use: 0 = 
         * MAIN, 1 = AUX. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Servo output port (set of 8 outputs = 1 port). Flight stacks running on Pixhawk should use: 0 = MAIN, 1 = AUX."
        )
        public final Builder port(int port) {
            this.port = port;
            return this;
        }

        /**
         * Servo output 1 value 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                description = "Servo output 1 value"
        )
        public final Builder servo1Raw(int servo1Raw) {
            this.servo1Raw = servo1Raw;
            return this;
        }

        /**
         * Servo output 2 value 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                description = "Servo output 2 value"
        )
        public final Builder servo2Raw(int servo2Raw) {
            this.servo2Raw = servo2Raw;
            return this;
        }

        /**
         * Servo output 3 value 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                description = "Servo output 3 value"
        )
        public final Builder servo3Raw(int servo3Raw) {
            this.servo3Raw = servo3Raw;
            return this;
        }

        /**
         * Servo output 4 value 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                description = "Servo output 4 value"
        )
        public final Builder servo4Raw(int servo4Raw) {
            this.servo4Raw = servo4Raw;
            return this;
        }

        /**
         * Servo output 5 value 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2,
                description = "Servo output 5 value"
        )
        public final Builder servo5Raw(int servo5Raw) {
            this.servo5Raw = servo5Raw;
            return this;
        }

        /**
         * Servo output 6 value 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 2,
                description = "Servo output 6 value"
        )
        public final Builder servo6Raw(int servo6Raw) {
            this.servo6Raw = servo6Raw;
            return this;
        }

        /**
         * Servo output 7 value 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 2,
                description = "Servo output 7 value"
        )
        public final Builder servo7Raw(int servo7Raw) {
            this.servo7Raw = servo7Raw;
            return this;
        }

        /**
         * Servo output 8 value 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 2,
                description = "Servo output 8 value"
        )
        public final Builder servo8Raw(int servo8Raw) {
            this.servo8Raw = servo8Raw;
            return this;
        }

        /**
         * Servo output 9 value 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 2,
                extension = true,
                description = "Servo output 9 value"
        )
        public final Builder servo9Raw(int servo9Raw) {
            this.servo9Raw = servo9Raw;
            return this;
        }

        /**
         * Servo output 10 value 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 2,
                extension = true,
                description = "Servo output 10 value"
        )
        public final Builder servo10Raw(int servo10Raw) {
            this.servo10Raw = servo10Raw;
            return this;
        }

        /**
         * Servo output 11 value 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 2,
                extension = true,
                description = "Servo output 11 value"
        )
        public final Builder servo11Raw(int servo11Raw) {
            this.servo11Raw = servo11Raw;
            return this;
        }

        /**
         * Servo output 12 value 
         */
        @MavlinkFieldInfo(
                position = 15,
                unitSize = 2,
                extension = true,
                description = "Servo output 12 value"
        )
        public final Builder servo12Raw(int servo12Raw) {
            this.servo12Raw = servo12Raw;
            return this;
        }

        /**
         * Servo output 13 value 
         */
        @MavlinkFieldInfo(
                position = 16,
                unitSize = 2,
                extension = true,
                description = "Servo output 13 value"
        )
        public final Builder servo13Raw(int servo13Raw) {
            this.servo13Raw = servo13Raw;
            return this;
        }

        /**
         * Servo output 14 value 
         */
        @MavlinkFieldInfo(
                position = 17,
                unitSize = 2,
                extension = true,
                description = "Servo output 14 value"
        )
        public final Builder servo14Raw(int servo14Raw) {
            this.servo14Raw = servo14Raw;
            return this;
        }

        /**
         * Servo output 15 value 
         */
        @MavlinkFieldInfo(
                position = 18,
                unitSize = 2,
                extension = true,
                description = "Servo output 15 value"
        )
        public final Builder servo15Raw(int servo15Raw) {
            this.servo15Raw = servo15Raw;
            return this;
        }

        /**
         * Servo output 16 value 
         */
        @MavlinkFieldInfo(
                position = 19,
                unitSize = 2,
                extension = true,
                description = "Servo output 16 value"
        )
        public final Builder servo16Raw(int servo16Raw) {
            this.servo16Raw = servo16Raw;
            return this;
        }

        public final ServoOutputRaw build() {
            return new ServoOutputRaw(timeUsec, port, servo1Raw, servo2Raw, servo3Raw, servo4Raw, servo5Raw, servo6Raw, servo7Raw, servo8Raw, servo9Raw, servo10Raw, servo11Raw, servo12Raw, servo13Raw, servo14Raw, servo15Raw, servo16Raw);
        }
    }
}
