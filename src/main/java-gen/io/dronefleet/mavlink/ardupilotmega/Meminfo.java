package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * State of APM memory. 
 */
@MavlinkMessageInfo(
        id = 152,
        crc = 208,
        description = "State of APM memory."
)
public final class Meminfo {
    private final int brkval;

    private final int freemem;

    private final long freemem32;

    private Meminfo(int brkval, int freemem, long freemem32) {
        this.brkval = brkval;
        this.freemem = freemem;
        this.freemem32 = freemem32;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Heap top. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 2,
            description = "Heap top."
    )
    public final int brkval() {
        return this.brkval;
    }

    /**
     * Free memory. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2,
            description = "Free memory."
    )
    public final int freemem() {
        return this.freemem;
    }

    /**
     * Free memory (32 bit). 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            extension = true,
            description = "Free memory (32 bit)."
    )
    public final long freemem32() {
        return this.freemem32;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        Meminfo other = (Meminfo)o;
        if (!Objects.deepEquals(brkval, other.brkval)) return false;
        if (!Objects.deepEquals(freemem, other.freemem)) return false;
        if (!Objects.deepEquals(freemem32, other.freemem32)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(brkval);
        result = 31 * result + Objects.hashCode(freemem);
        result = 31 * result + Objects.hashCode(freemem32);
        return result;
    }

    @Override
    public String toString() {
        return "Meminfo{brkval=" + brkval
                 + ", freemem=" + freemem
                 + ", freemem32=" + freemem32 + "}";
    }

    public static final class Builder {
        private int brkval;

        private int freemem;

        private long freemem32;

        /**
         * Heap top. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 2,
                description = "Heap top."
        )
        public final Builder brkval(int brkval) {
            this.brkval = brkval;
            return this;
        }

        /**
         * Free memory. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2,
                description = "Free memory."
        )
        public final Builder freemem(int freemem) {
            this.freemem = freemem;
            return this;
        }

        /**
         * Free memory (32 bit). 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                extension = true,
                description = "Free memory (32 bit)."
        )
        public final Builder freemem32(long freemem32) {
            this.freemem32 = freemem32;
            return this;
        }

        public final Meminfo build() {
            return new Meminfo(brkval, freemem, freemem32);
        }
    }
}
