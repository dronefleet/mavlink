package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Supported component metadata types. These are used in the "general" metadata file returned by 
 * {@link io.dronefleet.mavlink.common.ComponentMetadata COMPONENT_METADATA} to provide information about supported metadata types. The types are not 
 * used directly in MAVLink messages. 
 */
@MavlinkEnum
public enum CompMetadataType {
    /**
     * General information about the component. General metadata includes information about other 
     * metadata types supported by the component. Files of this type must be supported, and must be 
     * downloadable from vehicle using a MAVLink FTP URI. 
     */
    @MavlinkEntryInfo(0)
    COMP_METADATA_TYPE_GENERAL,

    /**
     * Parameter meta data. 
     */
    @MavlinkEntryInfo(1)
    COMP_METADATA_TYPE_PARAMETER,

    /**
     * Meta data that specifies which commands and command parameters the vehicle supports. (WIP) 
     */
    @MavlinkEntryInfo(2)
    COMP_METADATA_TYPE_COMMANDS,

    /**
     * Meta data that specifies external non-MAVLink peripherals. 
     */
    @MavlinkEntryInfo(3)
    COMP_METADATA_TYPE_PERIPHERALS,

    /**
     * Meta data for the events interface. 
     */
    @MavlinkEntryInfo(4)
    COMP_METADATA_TYPE_EVENTS,

    /**
     * Meta data for actuator configuration (motors, servos and vehicle geometry) and testing. 
     */
    @MavlinkEntryInfo(5)
    COMP_METADATA_TYPE_ACTUATORS
}
