package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Float;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

/**
 * Large debug/prototyping array. The message uses the maximum available payload for data. The 
 * array_id and name fields are used to discriminate between messages in code and in user 
 * interfaces (respectively). Do not use in production code. 
 */
@MavlinkMessageInfo(
        id = 350,
        crc = 232,
        description = "Large debug/prototyping array. The message uses the maximum available payload for data. The array_id and name fields are used to discriminate between messages in code and in user interfaces (respectively). Do not use in production code."
)
public final class DebugFloatArray {
    private final BigInteger timeUsec;

    private final String name;

    private final int arrayId;

    private final List<Float> data;

    private DebugFloatArray(BigInteger timeUsec, String name, int arrayId, List<Float> data) {
        this.timeUsec = timeUsec;
        this.name = name;
        this.arrayId = arrayId;
        this.data = data;
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
     * Name, for human-friendly display in a Ground Control Station 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            arraySize = 10,
            description = "Name, for human-friendly display in a Ground Control Station"
    )
    public final String name() {
        return this.name;
    }

    /**
     * Unique ID used to discriminate between arrays 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            description = "Unique ID used to discriminate between arrays"
    )
    public final int arrayId() {
        return this.arrayId;
    }

    /**
     * data 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            arraySize = 58,
            extension = true,
            description = "data"
    )
    public final List<Float> data() {
        return this.data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        DebugFloatArray other = (DebugFloatArray)o;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(name, other.name)) return false;
        if (!Objects.deepEquals(arrayId, other.arrayId)) return false;
        if (!Objects.deepEquals(data, other.data)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeUsec);
        result = 31 * result + Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(arrayId);
        result = 31 * result + Objects.hashCode(data);
        return result;
    }

    @Override
    public String toString() {
        return "DebugFloatArray{timeUsec=" + timeUsec
                 + ", name=" + name
                 + ", arrayId=" + arrayId
                 + ", data=" + data + "}";
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private String name;

        private int arrayId;

        private List<Float> data;

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
         * Name, for human-friendly display in a Ground Control Station 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                arraySize = 10,
                description = "Name, for human-friendly display in a Ground Control Station"
        )
        public final Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Unique ID used to discriminate between arrays 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                description = "Unique ID used to discriminate between arrays"
        )
        public final Builder arrayId(int arrayId) {
            this.arrayId = arrayId;
            return this;
        }

        /**
         * data 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                arraySize = 58,
                extension = true,
                description = "data"
        )
        public final Builder data(List<Float> data) {
            this.data = data;
            return this;
        }

        public final DebugFloatArray build() {
            return new DebugFloatArray(timeUsec, name, arrayId, data);
        }
    }
}
