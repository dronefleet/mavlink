package io.dronefleet.mavlink.icarous;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.Objects;

/**
 * Kinematic multi bands (track) output from Daidalus 
 */
@MavlinkMessageInfo(
        id = 42001,
        crc = 239,
        description = "Kinematic multi bands (track) output from Daidalus"
)
public final class IcarousKinematicBands {
    private final int numbands;

    private final EnumValue<IcarousTrackBandTypes> type1;

    private final float min1;

    private final float max1;

    private final EnumValue<IcarousTrackBandTypes> type2;

    private final float min2;

    private final float max2;

    private final EnumValue<IcarousTrackBandTypes> type3;

    private final float min3;

    private final float max3;

    private final EnumValue<IcarousTrackBandTypes> type4;

    private final float min4;

    private final float max4;

    private final EnumValue<IcarousTrackBandTypes> type5;

    private final float min5;

    private final float max5;

    private IcarousKinematicBands(int numbands, EnumValue<IcarousTrackBandTypes> type1, float min1,
            float max1, EnumValue<IcarousTrackBandTypes> type2, float min2, float max2,
            EnumValue<IcarousTrackBandTypes> type3, float min3, float max3,
            EnumValue<IcarousTrackBandTypes> type4, float min4, float max4,
            EnumValue<IcarousTrackBandTypes> type5, float min5, float max5) {
        this.numbands = numbands;
        this.type1 = type1;
        this.min1 = min1;
        this.max1 = max1;
        this.type2 = type2;
        this.min2 = min2;
        this.max2 = max2;
        this.type3 = type3;
        this.min3 = min3;
        this.max3 = max3;
        this.type4 = type4;
        this.min4 = min4;
        this.max4 = max4;
        this.type5 = type5;
        this.min5 = min5;
        this.max5 = max5;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Number of track bands 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            signed = true,
            description = "Number of track bands"
    )
    public final int numbands() {
        return this.numbands;
    }

    /**
     * See the TRACK_BAND_TYPES enum. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            enumType = IcarousTrackBandTypes.class,
            description = "See the TRACK_BAND_TYPES enum."
    )
    public final EnumValue<IcarousTrackBandTypes> type1() {
        return this.type1;
    }

    /**
     * min angle (degrees) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "min angle (degrees)"
    )
    public final float min1() {
        return this.min1;
    }

    /**
     * max angle (degrees) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "max angle (degrees)"
    )
    public final float max1() {
        return this.max1;
    }

    /**
     * See the TRACK_BAND_TYPES enum. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            enumType = IcarousTrackBandTypes.class,
            description = "See the TRACK_BAND_TYPES enum."
    )
    public final EnumValue<IcarousTrackBandTypes> type2() {
        return this.type2;
    }

    /**
     * min angle (degrees) 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "min angle (degrees)"
    )
    public final float min2() {
        return this.min2;
    }

    /**
     * max angle (degrees) 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "max angle (degrees)"
    )
    public final float max2() {
        return this.max2;
    }

    /**
     * See the TRACK_BAND_TYPES enum. 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 1,
            enumType = IcarousTrackBandTypes.class,
            description = "See the TRACK_BAND_TYPES enum."
    )
    public final EnumValue<IcarousTrackBandTypes> type3() {
        return this.type3;
    }

    /**
     * min angle (degrees) 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            description = "min angle (degrees)"
    )
    public final float min3() {
        return this.min3;
    }

    /**
     * max angle (degrees) 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            description = "max angle (degrees)"
    )
    public final float max3() {
        return this.max3;
    }

    /**
     * See the TRACK_BAND_TYPES enum. 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 1,
            enumType = IcarousTrackBandTypes.class,
            description = "See the TRACK_BAND_TYPES enum."
    )
    public final EnumValue<IcarousTrackBandTypes> type4() {
        return this.type4;
    }

    /**
     * min angle (degrees) 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4,
            description = "min angle (degrees)"
    )
    public final float min4() {
        return this.min4;
    }

    /**
     * max angle (degrees) 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 4,
            description = "max angle (degrees)"
    )
    public final float max4() {
        return this.max4;
    }

    /**
     * See the TRACK_BAND_TYPES enum. 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 1,
            enumType = IcarousTrackBandTypes.class,
            description = "See the TRACK_BAND_TYPES enum."
    )
    public final EnumValue<IcarousTrackBandTypes> type5() {
        return this.type5;
    }

    /**
     * min angle (degrees) 
     */
    @MavlinkFieldInfo(
            position = 15,
            unitSize = 4,
            description = "min angle (degrees)"
    )
    public final float min5() {
        return this.min5;
    }

    /**
     * max angle (degrees) 
     */
    @MavlinkFieldInfo(
            position = 16,
            unitSize = 4,
            description = "max angle (degrees)"
    )
    public final float max5() {
        return this.max5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        IcarousKinematicBands other = (IcarousKinematicBands)o;
        if (!Objects.deepEquals(numbands, other.numbands)) return false;
        if (!Objects.deepEquals(type1, other.type1)) return false;
        if (!Objects.deepEquals(min1, other.min1)) return false;
        if (!Objects.deepEquals(max1, other.max1)) return false;
        if (!Objects.deepEquals(type2, other.type2)) return false;
        if (!Objects.deepEquals(min2, other.min2)) return false;
        if (!Objects.deepEquals(max2, other.max2)) return false;
        if (!Objects.deepEquals(type3, other.type3)) return false;
        if (!Objects.deepEquals(min3, other.min3)) return false;
        if (!Objects.deepEquals(max3, other.max3)) return false;
        if (!Objects.deepEquals(type4, other.type4)) return false;
        if (!Objects.deepEquals(min4, other.min4)) return false;
        if (!Objects.deepEquals(max4, other.max4)) return false;
        if (!Objects.deepEquals(type5, other.type5)) return false;
        if (!Objects.deepEquals(min5, other.min5)) return false;
        if (!Objects.deepEquals(max5, other.max5)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(numbands);
        result = 31 * result + Objects.hashCode(type1);
        result = 31 * result + Objects.hashCode(min1);
        result = 31 * result + Objects.hashCode(max1);
        result = 31 * result + Objects.hashCode(type2);
        result = 31 * result + Objects.hashCode(min2);
        result = 31 * result + Objects.hashCode(max2);
        result = 31 * result + Objects.hashCode(type3);
        result = 31 * result + Objects.hashCode(min3);
        result = 31 * result + Objects.hashCode(max3);
        result = 31 * result + Objects.hashCode(type4);
        result = 31 * result + Objects.hashCode(min4);
        result = 31 * result + Objects.hashCode(max4);
        result = 31 * result + Objects.hashCode(type5);
        result = 31 * result + Objects.hashCode(min5);
        result = 31 * result + Objects.hashCode(max5);
        return result;
    }

    @Override
    public String toString() {
        return "IcarousKinematicBands{numbands=" + numbands
                 + ", type1=" + type1
                 + ", min1=" + min1
                 + ", max1=" + max1
                 + ", type2=" + type2
                 + ", min2=" + min2
                 + ", max2=" + max2
                 + ", type3=" + type3
                 + ", min3=" + min3
                 + ", max3=" + max3
                 + ", type4=" + type4
                 + ", min4=" + min4
                 + ", max4=" + max4
                 + ", type5=" + type5
                 + ", min5=" + min5
                 + ", max5=" + max5 + "}";
    }

    public static final class Builder {
        private int numbands;

        private EnumValue<IcarousTrackBandTypes> type1;

        private float min1;

        private float max1;

        private EnumValue<IcarousTrackBandTypes> type2;

        private float min2;

        private float max2;

        private EnumValue<IcarousTrackBandTypes> type3;

        private float min3;

        private float max3;

        private EnumValue<IcarousTrackBandTypes> type4;

        private float min4;

        private float max4;

        private EnumValue<IcarousTrackBandTypes> type5;

        private float min5;

        private float max5;

        /**
         * Number of track bands 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                signed = true,
                description = "Number of track bands"
        )
        public final Builder numbands(int numbands) {
            this.numbands = numbands;
            return this;
        }

        /**
         * See the TRACK_BAND_TYPES enum. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                enumType = IcarousTrackBandTypes.class,
                description = "See the TRACK_BAND_TYPES enum."
        )
        public final Builder type1(EnumValue<IcarousTrackBandTypes> type1) {
            this.type1 = type1;
            return this;
        }

        /**
         * See the TRACK_BAND_TYPES enum. 
         */
        public final Builder type1(IcarousTrackBandTypes entry) {
            return type1(EnumValue.of(entry));
        }

        /**
         * See the TRACK_BAND_TYPES enum. 
         */
        public final Builder type1(Enum... flags) {
            return type1(EnumValue.create(flags));
        }

        /**
         * See the TRACK_BAND_TYPES enum. 
         */
        public final Builder type1(Collection<Enum> flags) {
            return type1(EnumValue.create(flags));
        }

        /**
         * min angle (degrees) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "min angle (degrees)"
        )
        public final Builder min1(float min1) {
            this.min1 = min1;
            return this;
        }

        /**
         * max angle (degrees) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "max angle (degrees)"
        )
        public final Builder max1(float max1) {
            this.max1 = max1;
            return this;
        }

        /**
         * See the TRACK_BAND_TYPES enum. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                enumType = IcarousTrackBandTypes.class,
                description = "See the TRACK_BAND_TYPES enum."
        )
        public final Builder type2(EnumValue<IcarousTrackBandTypes> type2) {
            this.type2 = type2;
            return this;
        }

        /**
         * See the TRACK_BAND_TYPES enum. 
         */
        public final Builder type2(IcarousTrackBandTypes entry) {
            return type2(EnumValue.of(entry));
        }

        /**
         * See the TRACK_BAND_TYPES enum. 
         */
        public final Builder type2(Enum... flags) {
            return type2(EnumValue.create(flags));
        }

        /**
         * See the TRACK_BAND_TYPES enum. 
         */
        public final Builder type2(Collection<Enum> flags) {
            return type2(EnumValue.create(flags));
        }

        /**
         * min angle (degrees) 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "min angle (degrees)"
        )
        public final Builder min2(float min2) {
            this.min2 = min2;
            return this;
        }

        /**
         * max angle (degrees) 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "max angle (degrees)"
        )
        public final Builder max2(float max2) {
            this.max2 = max2;
            return this;
        }

        /**
         * See the TRACK_BAND_TYPES enum. 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 1,
                enumType = IcarousTrackBandTypes.class,
                description = "See the TRACK_BAND_TYPES enum."
        )
        public final Builder type3(EnumValue<IcarousTrackBandTypes> type3) {
            this.type3 = type3;
            return this;
        }

        /**
         * See the TRACK_BAND_TYPES enum. 
         */
        public final Builder type3(IcarousTrackBandTypes entry) {
            return type3(EnumValue.of(entry));
        }

        /**
         * See the TRACK_BAND_TYPES enum. 
         */
        public final Builder type3(Enum... flags) {
            return type3(EnumValue.create(flags));
        }

        /**
         * See the TRACK_BAND_TYPES enum. 
         */
        public final Builder type3(Collection<Enum> flags) {
            return type3(EnumValue.create(flags));
        }

        /**
         * min angle (degrees) 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                description = "min angle (degrees)"
        )
        public final Builder min3(float min3) {
            this.min3 = min3;
            return this;
        }

        /**
         * max angle (degrees) 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                description = "max angle (degrees)"
        )
        public final Builder max3(float max3) {
            this.max3 = max3;
            return this;
        }

        /**
         * See the TRACK_BAND_TYPES enum. 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 1,
                enumType = IcarousTrackBandTypes.class,
                description = "See the TRACK_BAND_TYPES enum."
        )
        public final Builder type4(EnumValue<IcarousTrackBandTypes> type4) {
            this.type4 = type4;
            return this;
        }

        /**
         * See the TRACK_BAND_TYPES enum. 
         */
        public final Builder type4(IcarousTrackBandTypes entry) {
            return type4(EnumValue.of(entry));
        }

        /**
         * See the TRACK_BAND_TYPES enum. 
         */
        public final Builder type4(Enum... flags) {
            return type4(EnumValue.create(flags));
        }

        /**
         * See the TRACK_BAND_TYPES enum. 
         */
        public final Builder type4(Collection<Enum> flags) {
            return type4(EnumValue.create(flags));
        }

        /**
         * min angle (degrees) 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 4,
                description = "min angle (degrees)"
        )
        public final Builder min4(float min4) {
            this.min4 = min4;
            return this;
        }

        /**
         * max angle (degrees) 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 4,
                description = "max angle (degrees)"
        )
        public final Builder max4(float max4) {
            this.max4 = max4;
            return this;
        }

        /**
         * See the TRACK_BAND_TYPES enum. 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 1,
                enumType = IcarousTrackBandTypes.class,
                description = "See the TRACK_BAND_TYPES enum."
        )
        public final Builder type5(EnumValue<IcarousTrackBandTypes> type5) {
            this.type5 = type5;
            return this;
        }

        /**
         * See the TRACK_BAND_TYPES enum. 
         */
        public final Builder type5(IcarousTrackBandTypes entry) {
            return type5(EnumValue.of(entry));
        }

        /**
         * See the TRACK_BAND_TYPES enum. 
         */
        public final Builder type5(Enum... flags) {
            return type5(EnumValue.create(flags));
        }

        /**
         * See the TRACK_BAND_TYPES enum. 
         */
        public final Builder type5(Collection<Enum> flags) {
            return type5(EnumValue.create(flags));
        }

        /**
         * min angle (degrees) 
         */
        @MavlinkFieldInfo(
                position = 15,
                unitSize = 4,
                description = "min angle (degrees)"
        )
        public final Builder min5(float min5) {
            this.min5 = min5;
            return this;
        }

        /**
         * max angle (degrees) 
         */
        @MavlinkFieldInfo(
                position = 16,
                unitSize = 4,
                description = "max angle (degrees)"
        )
        public final Builder max5(float max5) {
            this.max5 = max5;
            return this;
        }

        public final IcarousKinematicBands build() {
            return new IcarousKinematicBands(numbands, type1, min1, max1, type2, min2, max2, type3, min3, max3, type4, min4, max4, type5, min5, max5);
        }
    }
}
