package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Deprecated;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Objects;

/**
 * Vehicle status report that is sent out while orbit execution is in progress (see 
 * MAV_CMD_DO_ORBIT). 
 * @deprecated This message is a work in progress. It may be modified in a non backward-compatible 
 * way in a future release without any warning. This version of the message may not even work with 
 * autopilots that support this message due to discrepancies between dialect versions. Unless 
 * you completely understand the risks of doing so, don't use it. 
 */
@MavlinkMessageInfo(
        id = 360,
        crc = 11,
        description = "Vehicle status report that is sent out while orbit execution is in progress (see MAV_CMD_DO_ORBIT).",
        workInProgress = true
)
@Deprecated
public final class OrbitExecutionStatus {
    private final BigInteger timeUsec;

    private final float radius;

    private final EnumValue<MavFrame> frame;

    private final int x;

    private final int y;

    private final float z;

    private OrbitExecutionStatus(BigInteger timeUsec, float radius, EnumValue<MavFrame> frame,
            int x, int y, float z) {
        this.timeUsec = timeUsec;
        this.radius = radius;
        this.frame = frame;
        this.x = x;
        this.y = y;
        this.z = z;
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
            position = 2,
            unitSize = 8,
            description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number."
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    /**
     * Radius of the orbit circle. Positive values orbit clockwise, negative values orbit 
     * counter-clockwise. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Radius of the orbit circle. Positive values orbit clockwise, negative values orbit counter-clockwise."
    )
    public final float radius() {
        return this.radius;
    }

    /**
     * The coordinate system of the fields: x, y, z. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            enumType = MavFrame.class,
            description = "The coordinate system of the fields: x, y, z."
    )
    public final EnumValue<MavFrame> frame() {
        return this.frame;
    }

    /**
     * X coordinate of center point. Coordinate system depends on frame field: local = x position in 
     * meters * 1e4, global = latitude in degrees * 1e7. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            signed = true,
            description = "X coordinate of center point. Coordinate system depends on frame field: local = x position in meters * 1e4, global = latitude in degrees * 1e7."
    )
    public final int x() {
        return this.x;
    }

    /**
     * Y coordinate of center point. Coordinate system depends on frame field: local = x position in 
     * meters * 1e4, global = latitude in degrees * 1e7. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            signed = true,
            description = "Y coordinate of center point.  Coordinate system depends on frame field: local = x position in meters * 1e4, global = latitude in degrees * 1e7."
    )
    public final int y() {
        return this.y;
    }

    /**
     * Altitude of center point. Coordinate system depends on frame field. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "Altitude of center point. Coordinate system depends on frame field."
    )
    public final float z() {
        return this.z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        OrbitExecutionStatus other = (OrbitExecutionStatus)o;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(radius, other.radius)) return false;
        if (!Objects.deepEquals(frame, other.frame)) return false;
        if (!Objects.deepEquals(x, other.x)) return false;
        if (!Objects.deepEquals(y, other.y)) return false;
        if (!Objects.deepEquals(z, other.z)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeUsec);
        result = 31 * result + Objects.hashCode(radius);
        result = 31 * result + Objects.hashCode(frame);
        result = 31 * result + Objects.hashCode(x);
        result = 31 * result + Objects.hashCode(y);
        result = 31 * result + Objects.hashCode(z);
        return result;
    }

    @Override
    public String toString() {
        return "OrbitExecutionStatus{timeUsec=" + timeUsec
                 + ", radius=" + radius
                 + ", frame=" + frame
                 + ", x=" + x
                 + ", y=" + y
                 + ", z=" + z + "}";
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private float radius;

        private EnumValue<MavFrame> frame;

        private int x;

        private int y;

        private float z;

        /**
         * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp 
         * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 8,
                description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number."
        )
        public final Builder timeUsec(BigInteger timeUsec) {
            this.timeUsec = timeUsec;
            return this;
        }

        /**
         * Radius of the orbit circle. Positive values orbit clockwise, negative values orbit 
         * counter-clockwise. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Radius of the orbit circle. Positive values orbit clockwise, negative values orbit counter-clockwise."
        )
        public final Builder radius(float radius) {
            this.radius = radius;
            return this;
        }

        /**
         * The coordinate system of the fields: x, y, z. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                enumType = MavFrame.class,
                description = "The coordinate system of the fields: x, y, z."
        )
        public final Builder frame(EnumValue<MavFrame> frame) {
            this.frame = frame;
            return this;
        }

        /**
         * The coordinate system of the fields: x, y, z. 
         */
        public final Builder frame(MavFrame entry) {
            return frame(EnumValue.of(entry));
        }

        /**
         * The coordinate system of the fields: x, y, z. 
         */
        public final Builder frame(Enum... flags) {
            return frame(EnumValue.create(flags));
        }

        /**
         * The coordinate system of the fields: x, y, z. 
         */
        public final Builder frame(Collection<Enum> flags) {
            return frame(EnumValue.create(flags));
        }

        /**
         * X coordinate of center point. Coordinate system depends on frame field: local = x position in 
         * meters * 1e4, global = latitude in degrees * 1e7. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                signed = true,
                description = "X coordinate of center point. Coordinate system depends on frame field: local = x position in meters * 1e4, global = latitude in degrees * 1e7."
        )
        public final Builder x(int x) {
            this.x = x;
            return this;
        }

        /**
         * Y coordinate of center point. Coordinate system depends on frame field: local = x position in 
         * meters * 1e4, global = latitude in degrees * 1e7. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                signed = true,
                description = "Y coordinate of center point.  Coordinate system depends on frame field: local = x position in meters * 1e4, global = latitude in degrees * 1e7."
        )
        public final Builder y(int y) {
            this.y = y;
            return this;
        }

        /**
         * Altitude of center point. Coordinate system depends on frame field. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "Altitude of center point. Coordinate system depends on frame field."
        )
        public final Builder z(float z) {
            this.z = z;
            return this;
        }

        public final OrbitExecutionStatus build() {
            return new OrbitExecutionStatus(timeUsec, radius, frame, x, y, z);
        }
    }
}
