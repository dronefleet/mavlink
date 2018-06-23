package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Generalized UAVCAN node mode 
 */
@MavlinkEnum
public enum UavcanNodeMode {
    /**
     * The node is performing its primary functions.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(0)
    UAVCAN_NODE_MODE_OPERATIONAL,

    /**
     * The node is initializing; this mode is entered immediately after startup.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    UAVCAN_NODE_MODE_INITIALIZATION,

    /**
     * The node is under maintenance.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    UAVCAN_NODE_MODE_MAINTENANCE,

    /**
     * The node is in the process of updating its software.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(3)
    UAVCAN_NODE_MODE_SOFTWARE_UPDATE,

    /**
     * The node is no longer available online.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(7)
    UAVCAN_NODE_MODE_OFFLINE
}
