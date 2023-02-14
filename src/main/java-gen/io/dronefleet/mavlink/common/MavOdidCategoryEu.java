package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum MavOdidCategoryEu {
    /**
     * The category for the UA, according to the EU specification, is undeclared. 
     */
    @MavlinkEntryInfo(0)
    MAV_ODID_CATEGORY_EU_UNDECLARED,

    /**
     * The category for the UA, according to the EU specification, is the Open category. 
     */
    @MavlinkEntryInfo(1)
    MAV_ODID_CATEGORY_EU_OPEN,

    /**
     * The category for the UA, according to the EU specification, is the Specific category. 
     */
    @MavlinkEntryInfo(2)
    MAV_ODID_CATEGORY_EU_SPECIFIC,

    /**
     * The category for the UA, according to the EU specification, is the Certified category. 
     */
    @MavlinkEntryInfo(3)
    MAV_ODID_CATEGORY_EU_CERTIFIED
}
