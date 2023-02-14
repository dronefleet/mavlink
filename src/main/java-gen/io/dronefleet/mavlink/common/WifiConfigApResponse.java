package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Possible responses from a {@link io.dronefleet.mavlink.common.WifiConfigAp WIFI_CONFIG_AP} message. 
 */
@MavlinkEnum
public enum WifiConfigApResponse {
    /**
     * Undefined response. Likely an indicative of a system that doesn't support this request. 
     */
    @MavlinkEntryInfo(0)
    WIFI_CONFIG_AP_RESPONSE_UNDEFINED,

    /**
     * Changes accepted. 
     */
    @MavlinkEntryInfo(1)
    WIFI_CONFIG_AP_RESPONSE_ACCEPTED,

    /**
     * Changes rejected. 
     */
    @MavlinkEntryInfo(2)
    WIFI_CONFIG_AP_RESPONSE_REJECTED,

    /**
     * Invalid Mode. 
     */
    @MavlinkEntryInfo(3)
    WIFI_CONFIG_AP_RESPONSE_MODE_ERROR,

    /**
     * Invalid SSID. 
     */
    @MavlinkEntryInfo(4)
    WIFI_CONFIG_AP_RESPONSE_SSID_ERROR,

    /**
     * Invalid Password. 
     */
    @MavlinkEntryInfo(5)
    WIFI_CONFIG_AP_RESPONSE_PASSWORD_ERROR
}
