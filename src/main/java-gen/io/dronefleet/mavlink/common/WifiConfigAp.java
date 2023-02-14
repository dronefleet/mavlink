package io.dronefleet.mavlink.common;

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
 * Configure WiFi AP SSID, password, and mode. This message is re-emitted as an acknowledgement 
 * by the AP. The message may also be explicitly requested using MAV_CMD_REQUEST_MESSAGE 
 */
@MavlinkMessageInfo(
        id = 299,
        crc = 19,
        description = "Configure WiFi AP SSID, password, and mode. This message is re-emitted as an acknowledgement by the AP. The message may also be explicitly requested using MAV_CMD_REQUEST_MESSAGE"
)
public final class WifiConfigAp {
    private final String ssid;

    private final String password;

    private final EnumValue<WifiConfigApMode> mode;

    private final EnumValue<WifiConfigApResponse> response;

    private WifiConfigAp(String ssid, String password, EnumValue<WifiConfigApMode> mode,
            EnumValue<WifiConfigApResponse> response) {
        this.ssid = ssid;
        this.password = password;
        this.mode = mode;
        this.response = response;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Name of Wi-Fi network (SSID). Blank to leave it unchanged when setting. Current SSID when sent 
     * back as a response. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            arraySize = 32,
            description = "Name of Wi-Fi network (SSID). Blank to leave it unchanged when setting. Current SSID when sent back as a response."
    )
    public final String ssid() {
        return this.ssid;
    }

    /**
     * Password. Blank for an open AP. MD5 hash when message is sent back as a response. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            arraySize = 64,
            description = "Password. Blank for an open AP. MD5 hash when message is sent back as a response."
    )
    public final String password() {
        return this.password;
    }

    /**
     * WiFi Mode. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            enumType = WifiConfigApMode.class,
            signed = true,
            extension = true,
            description = "WiFi Mode."
    )
    public final EnumValue<WifiConfigApMode> mode() {
        return this.mode;
    }

    /**
     * Message acceptance response (sent back to GS). 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            enumType = WifiConfigApResponse.class,
            signed = true,
            extension = true,
            description = "Message acceptance response (sent back to GS)."
    )
    public final EnumValue<WifiConfigApResponse> response() {
        return this.response;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        WifiConfigAp other = (WifiConfigAp)o;
        if (!Objects.deepEquals(ssid, other.ssid)) return false;
        if (!Objects.deepEquals(password, other.password)) return false;
        if (!Objects.deepEquals(mode, other.mode)) return false;
        if (!Objects.deepEquals(response, other.response)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(ssid);
        result = 31 * result + Objects.hashCode(password);
        result = 31 * result + Objects.hashCode(mode);
        result = 31 * result + Objects.hashCode(response);
        return result;
    }

    @Override
    public String toString() {
        return "WifiConfigAp{ssid=" + ssid
                 + ", password=" + password
                 + ", mode=" + mode
                 + ", response=" + response + "}";
    }

    public static final class Builder {
        private String ssid;

        private String password;

        private EnumValue<WifiConfigApMode> mode;

        private EnumValue<WifiConfigApResponse> response;

        /**
         * Name of Wi-Fi network (SSID). Blank to leave it unchanged when setting. Current SSID when sent 
         * back as a response. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                arraySize = 32,
                description = "Name of Wi-Fi network (SSID). Blank to leave it unchanged when setting. Current SSID when sent back as a response."
        )
        public final Builder ssid(String ssid) {
            this.ssid = ssid;
            return this;
        }

        /**
         * Password. Blank for an open AP. MD5 hash when message is sent back as a response. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                arraySize = 64,
                description = "Password. Blank for an open AP. MD5 hash when message is sent back as a response."
        )
        public final Builder password(String password) {
            this.password = password;
            return this;
        }

        /**
         * WiFi Mode. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                enumType = WifiConfigApMode.class,
                signed = true,
                extension = true,
                description = "WiFi Mode."
        )
        public final Builder mode(EnumValue<WifiConfigApMode> mode) {
            this.mode = mode;
            return this;
        }

        /**
         * WiFi Mode. 
         */
        public final Builder mode(WifiConfigApMode entry) {
            return mode(EnumValue.of(entry));
        }

        /**
         * WiFi Mode. 
         */
        public final Builder mode(Enum... flags) {
            return mode(EnumValue.create(flags));
        }

        /**
         * WiFi Mode. 
         */
        public final Builder mode(Collection<Enum> flags) {
            return mode(EnumValue.create(flags));
        }

        /**
         * Message acceptance response (sent back to GS). 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                enumType = WifiConfigApResponse.class,
                signed = true,
                extension = true,
                description = "Message acceptance response (sent back to GS)."
        )
        public final Builder response(EnumValue<WifiConfigApResponse> response) {
            this.response = response;
            return this;
        }

        /**
         * Message acceptance response (sent back to GS). 
         */
        public final Builder response(WifiConfigApResponse entry) {
            return response(EnumValue.of(entry));
        }

        /**
         * Message acceptance response (sent back to GS). 
         */
        public final Builder response(Enum... flags) {
            return response(EnumValue.create(flags));
        }

        /**
         * Message acceptance response (sent back to GS). 
         */
        public final Builder response(Collection<Enum> flags) {
            return response(EnumValue.create(flags));
        }

        public final WifiConfigAp build() {
            return new WifiConfigAp(ssid, password, mode, response);
        }
    }
}
