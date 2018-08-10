package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.util.Objects;

/**
 * state of APM memory 
 */
@MavlinkMessageInfo(
        id = 152,
        crc = 208
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
     * heap top 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 2
    )
    public final int brkval() {
        return this.brkval;
    }

    /**
     * free memory 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2
    )
    public final int freemem() {
        return this.freemem;
    }

    /**
     * free memory (32 bit) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            extension = true
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

    public static final class Builder {
        private int brkval;

        private int freemem;

        private long freemem32;

        /**
         * heap top 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 2
        )
        public final Builder brkval(int brkval) {
            this.brkval = brkval;
            return this;
        }

        /**
         * free memory 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2
        )
        public final Builder freemem(int freemem) {
            this.freemem = freemem;
            return this;
        }

        /**
         * free memory (32 bit) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                extension = true
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
