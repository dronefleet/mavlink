package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Flags to indicate the type of storage. 
 */
@MavlinkEnum
public enum StorageType {
    /**
     * Storage type is not known. 
     */
    @MavlinkEntryInfo(0)
    STORAGE_TYPE_UNKNOWN,

    /**
     * Storage type is USB device. 
     */
    @MavlinkEntryInfo(1)
    STORAGE_TYPE_USB_STICK,

    /**
     * Storage type is SD card. 
     */
    @MavlinkEntryInfo(2)
    STORAGE_TYPE_SD,

    /**
     * Storage type is microSD card. 
     */
    @MavlinkEntryInfo(3)
    STORAGE_TYPE_MICROSD,

    /**
     * Storage type is CFast. 
     */
    @MavlinkEntryInfo(4)
    STORAGE_TYPE_CF,

    /**
     * Storage type is CFexpress. 
     */
    @MavlinkEntryInfo(5)
    STORAGE_TYPE_CFE,

    /**
     * Storage type is XQD. 
     */
    @MavlinkEntryInfo(6)
    STORAGE_TYPE_XQD,

    /**
     * Storage type is HD mass storage type. 
     */
    @MavlinkEntryInfo(7)
    STORAGE_TYPE_HD,

    /**
     * Storage type is other, not listed type. 
     */
    @MavlinkEntryInfo(254)
    STORAGE_TYPE_OTHER
}
