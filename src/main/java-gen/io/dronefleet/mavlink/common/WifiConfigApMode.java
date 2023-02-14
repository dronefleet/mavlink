package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * WiFi Mode. 
 */
@MavlinkEnum
public enum WifiConfigApMode {
    /**
     * WiFi mode is undefined. 
     */
    @MavlinkEntryInfo(0)
    WIFI_CONFIG_AP_MODE_UNDEFINED,

    /**
     * WiFi configured as an access point. 
     */
    @MavlinkEntryInfo(1)
    WIFI_CONFIG_AP_MODE_AP,

    /**
     * WiFi configured as a station connected to an existing local WiFi network. 
     */
    @MavlinkEntryInfo(2)
    WIFI_CONFIG_AP_MODE_STATION,

    /**
     * WiFi disabled. 
     */
    @MavlinkEntryInfo(3)
    WIFI_CONFIG_AP_MODE_DISABLED
}
