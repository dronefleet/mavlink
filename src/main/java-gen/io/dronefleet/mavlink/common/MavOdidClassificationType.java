package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum MavOdidClassificationType {
    /**
     * The classification type for the UA is undeclared. 
     */
    @MavlinkEntryInfo(0)
    MAV_ODID_CLASSIFICATION_TYPE_UNDECLARED,

    /**
     * The classification type for the UA follows EU (European Union) specifications. 
     */
    @MavlinkEntryInfo(1)
    MAV_ODID_CLASSIFICATION_TYPE_EU
}
