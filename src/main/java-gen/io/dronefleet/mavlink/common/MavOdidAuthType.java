package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum MavOdidAuthType {
    /**
     * No authentication type is specified. 
     */
    @MavlinkEntryInfo(0)
    MAV_ODID_AUTH_TYPE_NONE,

    /**
     * Signature for the UAS (Unmanned Aircraft System) ID. 
     */
    @MavlinkEntryInfo(1)
    MAV_ODID_AUTH_TYPE_UAS_ID_SIGNATURE,

    /**
     * Signature for the Operator ID. 
     */
    @MavlinkEntryInfo(2)
    MAV_ODID_AUTH_TYPE_OPERATOR_ID_SIGNATURE,

    /**
     * Signature for the entire message set. 
     */
    @MavlinkEntryInfo(3)
    MAV_ODID_AUTH_TYPE_MESSAGE_SET_SIGNATURE,

    /**
     * Authentication is provided by Network Remote ID. 
     */
    @MavlinkEntryInfo(4)
    MAV_ODID_AUTH_TYPE_NETWORK_REMOTE_ID,

    /**
     * The exact authentication type is indicated by the first byte of authentication_data and these 
     * type values are managed by ICAO. 
     */
    @MavlinkEntryInfo(5)
    MAV_ODID_AUTH_TYPE_SPECIFIC_AUTHENTICATION
}
