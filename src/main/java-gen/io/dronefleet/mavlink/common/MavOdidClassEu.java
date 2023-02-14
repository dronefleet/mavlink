package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum MavOdidClassEu {
    /**
     * The class for the UA, according to the EU specification, is undeclared. 
     */
    @MavlinkEntryInfo(0)
    MAV_ODID_CLASS_EU_UNDECLARED,

    /**
     * The class for the UA, according to the EU specification, is Class 0. 
     */
    @MavlinkEntryInfo(1)
    MAV_ODID_CLASS_EU_CLASS_0,

    /**
     * The class for the UA, according to the EU specification, is Class 1. 
     */
    @MavlinkEntryInfo(2)
    MAV_ODID_CLASS_EU_CLASS_1,

    /**
     * The class for the UA, according to the EU specification, is Class 2. 
     */
    @MavlinkEntryInfo(3)
    MAV_ODID_CLASS_EU_CLASS_2,

    /**
     * The class for the UA, according to the EU specification, is Class 3. 
     */
    @MavlinkEntryInfo(4)
    MAV_ODID_CLASS_EU_CLASS_3,

    /**
     * The class for the UA, according to the EU specification, is Class 4. 
     */
    @MavlinkEntryInfo(5)
    MAV_ODID_CLASS_EU_CLASS_4,

    /**
     * The class for the UA, according to the EU specification, is Class 5. 
     */
    @MavlinkEntryInfo(6)
    MAV_ODID_CLASS_EU_CLASS_5,

    /**
     * The class for the UA, according to the EU specification, is Class 6. 
     */
    @MavlinkEntryInfo(7)
    MAV_ODID_CLASS_EU_CLASS_6
}
