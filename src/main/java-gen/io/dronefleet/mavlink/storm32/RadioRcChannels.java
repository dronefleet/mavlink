package io.dronefleet.mavlink.storm32;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Radio channels. Supports up to 24 channels. Channel values are in centerd 13 bit format. Range 
 * is [-4096,4096], center is 0. Conversion to PWM is x * 5/32 + 1500. Should be emitted only by 
 * components with component id MAV_COMP_ID_TELEMETRY_RADIO. 
 */
@MavlinkMessageInfo(
        id = 60045,
        crc = 89,
        description = "Radio channels. Supports up to 24 channels. Channel values are in centerd 13 bit format. Range is [-4096,4096], center is 0. Conversion to PWM is x * 5/32 + 1500. Should be emitted only by components with component id MAV_COMP_ID_TELEMETRY_RADIO."
)
public final class RadioRcChannels {
    private final int count;

    private final EnumValue<RadioRcChannelsFlags> flags;

    private final List<Integer> channels;

    private RadioRcChannels(int count, EnumValue<RadioRcChannelsFlags> flags,
            List<Integer> channels) {
        this.count = count;
        this.flags = flags;
        this.channels = channels;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Total number of RC channels being received. This can be larger than 24, indicating that more 
     * channels are available but not given in this message. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "Total number of RC channels being received. This can be larger than 24, indicating that more channels are available but not given in this message."
    )
    public final int count() {
        return this.count;
    }

    /**
     * Radio channels status flags. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            enumType = RadioRcChannelsFlags.class,
            description = "Radio channels status flags."
    )
    public final EnumValue<RadioRcChannelsFlags> flags() {
        return this.flags;
    }

    /**
     * RC channels. Channels above count should be set to 0, to benefit from MAVLink's zero padding. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            arraySize = 24,
            signed = true,
            extension = true,
            description = "RC channels. Channels above count should be set to 0, to benefit from MAVLink's zero padding."
    )
    public final List<Integer> channels() {
        return this.channels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        RadioRcChannels other = (RadioRcChannels)o;
        if (!Objects.deepEquals(count, other.count)) return false;
        if (!Objects.deepEquals(flags, other.flags)) return false;
        if (!Objects.deepEquals(channels, other.channels)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(count);
        result = 31 * result + Objects.hashCode(flags);
        result = 31 * result + Objects.hashCode(channels);
        return result;
    }

    @Override
    public String toString() {
        return "RadioRcChannels{count=" + count
                 + ", flags=" + flags
                 + ", channels=" + channels + "}";
    }

    public static final class Builder {
        private int count;

        private EnumValue<RadioRcChannelsFlags> flags;

        private List<Integer> channels;

        /**
         * Total number of RC channels being received. This can be larger than 24, indicating that more 
         * channels are available but not given in this message. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "Total number of RC channels being received. This can be larger than 24, indicating that more channels are available but not given in this message."
        )
        public final Builder count(int count) {
            this.count = count;
            return this;
        }

        /**
         * Radio channels status flags. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                enumType = RadioRcChannelsFlags.class,
                description = "Radio channels status flags."
        )
        public final Builder flags(EnumValue<RadioRcChannelsFlags> flags) {
            this.flags = flags;
            return this;
        }

        /**
         * Radio channels status flags. 
         */
        public final Builder flags(RadioRcChannelsFlags entry) {
            return flags(EnumValue.of(entry));
        }

        /**
         * Radio channels status flags. 
         */
        public final Builder flags(Enum... flags) {
            return flags(EnumValue.create(flags));
        }

        /**
         * Radio channels status flags. 
         */
        public final Builder flags(Collection<Enum> flags) {
            return flags(EnumValue.create(flags));
        }

        /**
         * RC channels. Channels above count should be set to 0, to benefit from MAVLink's zero padding. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                arraySize = 24,
                signed = true,
                extension = true,
                description = "RC channels. Channels above count should be set to 0, to benefit from MAVLink's zero padding."
        )
        public final Builder channels(List<Integer> channels) {
            this.channels = channels;
            return this;
        }

        public final RadioRcChannels build() {
            return new RadioRcChannels(count, flags, channels);
        }
    }
}
