package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.util.Objects;

/**
 * Configurable diagnostic messages. 
 */
@MavlinkMessageInfo(
        id = 173,
        crc = 2
)
public final class Diagnostic {
    private final float diagfl1;

    private final float diagfl2;

    private final float diagfl3;

    private final int diagsh1;

    private final int diagsh2;

    private final int diagsh3;

    private Diagnostic(float diagfl1, float diagfl2, float diagfl3, int diagsh1, int diagsh2,
            int diagsh3) {
        this.diagfl1 = diagfl1;
        this.diagfl2 = diagfl2;
        this.diagfl3 = diagfl3;
        this.diagsh1 = diagsh1;
        this.diagsh2 = diagsh2;
        this.diagsh3 = diagsh3;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Diagnostic float 1 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4
    )
    public final float diagfl1() {
        return this.diagfl1;
    }

    /**
     * Diagnostic float 2 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float diagfl2() {
        return this.diagfl2;
    }

    /**
     * Diagnostic float 3 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float diagfl3() {
        return this.diagfl3;
    }

    /**
     * Diagnostic short 1 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            signed = true
    )
    public final int diagsh1() {
        return this.diagsh1;
    }

    /**
     * Diagnostic short 2 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            signed = true
    )
    public final int diagsh2() {
        return this.diagsh2;
    }

    /**
     * Diagnostic short 3 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            signed = true
    )
    public final int diagsh3() {
        return this.diagsh3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        Diagnostic other = (Diagnostic)o;
        if (!Objects.deepEquals(diagfl1, other.diagfl1)) return false;
        if (!Objects.deepEquals(diagfl2, other.diagfl2)) return false;
        if (!Objects.deepEquals(diagfl3, other.diagfl3)) return false;
        if (!Objects.deepEquals(diagsh1, other.diagsh1)) return false;
        if (!Objects.deepEquals(diagsh2, other.diagsh2)) return false;
        if (!Objects.deepEquals(diagsh3, other.diagsh3)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(diagfl1);
        result = 31 * result + Objects.hashCode(diagfl2);
        result = 31 * result + Objects.hashCode(diagfl3);
        result = 31 * result + Objects.hashCode(diagsh1);
        result = 31 * result + Objects.hashCode(diagsh2);
        result = 31 * result + Objects.hashCode(diagsh3);
        return result;
    }

    public static final class Builder {
        private float diagfl1;

        private float diagfl2;

        private float diagfl3;

        private int diagsh1;

        private int diagsh2;

        private int diagsh3;

        /**
         * Diagnostic float 1 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4
        )
        public final Builder diagfl1(float diagfl1) {
            this.diagfl1 = diagfl1;
            return this;
        }

        /**
         * Diagnostic float 2 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder diagfl2(float diagfl2) {
            this.diagfl2 = diagfl2;
            return this;
        }

        /**
         * Diagnostic float 3 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder diagfl3(float diagfl3) {
            this.diagfl3 = diagfl3;
            return this;
        }

        /**
         * Diagnostic short 1 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                signed = true
        )
        public final Builder diagsh1(int diagsh1) {
            this.diagsh1 = diagsh1;
            return this;
        }

        /**
         * Diagnostic short 2 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                signed = true
        )
        public final Builder diagsh2(int diagsh2) {
            this.diagsh2 = diagsh2;
            return this;
        }

        /**
         * Diagnostic short 3 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                signed = true
        )
        public final Builder diagsh3(int diagsh3) {
            this.diagsh3 = diagsh3;
            return this;
        }

        public final Diagnostic build() {
            return new Diagnostic(diagfl1, diagfl2, diagfl3, diagsh1, diagsh2, diagsh3);
        }
    }
}
