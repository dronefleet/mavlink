package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.String;

/**
 * Configure AP SSID and Password. 
 */
@MavlinkMessageInfo(
        id = 299,
        crc = 19
)
public final class WifiConfigAp {
    private final String ssid;

    private final String password;

    private WifiConfigAp(String ssid, String password) {
        this.ssid = ssid;
        this.password = password;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Name of Wi-Fi network (SSID). Leave it blank to leave it unchanged. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            arraySize = 32
    )
    public final String ssid() {
        return this.ssid;
    }

    /**
     * Password. Leave it blank for an open AP. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            arraySize = 64
    )
    public final String password() {
        return this.password;
    }

    public static final class Builder {
        private String ssid;

        private String password;

        /**
         * Name of Wi-Fi network (SSID). Leave it blank to leave it unchanged. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                arraySize = 32
        )
        public final Builder ssid(String ssid) {
            this.ssid = ssid;
            return this;
        }

        /**
         * Password. Leave it blank for an open AP. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                arraySize = 64
        )
        public final Builder password(String password) {
            this.password = password;
            return this;
        }

        public final WifiConfigAp build() {
            return new WifiConfigAp(ssid, password);
        }
    }
}
