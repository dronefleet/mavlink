package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum MavOdidIdType {
    /**
     * No type defined. 
     */
    @MavlinkEntryInfo(0)
    MAV_ODID_ID_TYPE_NONE,

    /**
     * Manufacturer Serial Number (ANSI/CTA-2063 format). 
     */
    @MavlinkEntryInfo(1)
    MAV_ODID_ID_TYPE_SERIAL_NUMBER,

    /**
     * CAA (Civil Aviation Authority) registered ID. Format: [ICAO Country Code].[CAA Assigned 
     * ID]. 
     */
    @MavlinkEntryInfo(2)
    MAV_ODID_ID_TYPE_CAA_REGISTRATION_ID,

    /**
     * UTM (Unmanned Traffic Management) assigned UUID (RFC4122). 
     */
    @MavlinkEntryInfo(3)
    MAV_ODID_ID_TYPE_UTM_ASSIGNED_UUID,

    /**
     * A 20 byte ID for a specific flight/session. The exact ID type is indicated by the first byte of 
     * uas_id and these type values are managed by ICAO. 
     */
    @MavlinkEntryInfo(4)
    MAV_ODID_ID_TYPE_SPECIFIC_SESSION_ID
}
