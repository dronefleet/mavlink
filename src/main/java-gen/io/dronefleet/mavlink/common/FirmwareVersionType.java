package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * These values define the type of firmware release. These values indicate the first version or 
 * release of this type. For example the first alpha release would be 64, the second would be 65. 
 */
@MavlinkEnum
public enum FirmwareVersionType {
    /**
     * development release<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(0)
    FIRMWARE_VERSION_TYPE_DEV,

    /**
     * alpha release<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(64)
    FIRMWARE_VERSION_TYPE_ALPHA,

    /**
     * beta release<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(128)
    FIRMWARE_VERSION_TYPE_BETA,

    /**
     * release candidate<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(192)
    FIRMWARE_VERSION_TYPE_RC,

    /**
     * official stable release<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(255)
    FIRMWARE_VERSION_TYPE_OFFICIAL
}
