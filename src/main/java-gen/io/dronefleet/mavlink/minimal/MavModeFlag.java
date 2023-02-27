package io.dronefleet.mavlink.minimal;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * These flags encode the MAV mode. 
 */
@MavlinkEnum
public enum MavModeFlag {
    /**
     * 0b10000000 MAV safety set to armed. Motors are enabled / running / can start. Ready to fly. 
     * Additional note: this flag is to be ignore when sent in the command MAV_CMD_DO_SET_MODE and 
     * MAV_CMD_COMPONENT_ARM_DISARM shall be used instead. The flag can still be used to report the 
     * armed state. 
     */
    @MavlinkEntryInfo(128)
    MAV_MODE_FLAG_SAFETY_ARMED,

    /**
     * 0b01000000 remote control input is enabled. 
     */
    @MavlinkEntryInfo(64)
    MAV_MODE_FLAG_MANUAL_INPUT_ENABLED,

    /**
     * 0b00100000 hardware in the loop simulation. All motors / actuators are blocked, but internal 
     * software is full operational. 
     */
    @MavlinkEntryInfo(32)
    MAV_MODE_FLAG_HIL_ENABLED,

    /**
     * 0b00010000 system stabilizes electronically its attitude (and optionally position). It 
     * needs however further control inputs to move around. 
     */
    @MavlinkEntryInfo(16)
    MAV_MODE_FLAG_STABILIZE_ENABLED,

    /**
     * 0b00001000 guided mode enabled, system flies waypoints / mission items. 
     */
    @MavlinkEntryInfo(8)
    MAV_MODE_FLAG_GUIDED_ENABLED,

    /**
     * 0b00000100 autonomous mode enabled, system finds its own goal positions. Guided flag can be 
     * set or not, depends on the actual implementation. 
     */
    @MavlinkEntryInfo(4)
    MAV_MODE_FLAG_AUTO_ENABLED,

    /**
     * 0b00000010 system has a test mode enabled. This flag is intended for temporary system tests and 
     * should not be used for stable implementations. 
     */
    @MavlinkEntryInfo(2)
    MAV_MODE_FLAG_TEST_ENABLED,

    /**
     * 0b00000001 Reserved for future use. 
     */
    @MavlinkEntryInfo(1)
    MAV_MODE_FLAG_CUSTOM_MODE_ENABLED
}
