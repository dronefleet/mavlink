package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Flags to report status/failure cases for a power generator (used in {@link io.dronefleet.mavlink.common.GeneratorStatus GENERATOR_STATUS}). Note 
 * that FAULTS are conditions that cause the generator to fail. Warnings are conditions that 
 * require attention before the next use (they indicate the system is not operating properly). 
 */
@MavlinkEnum
public enum MavGeneratorStatusFlag {
    /**
     * Generator is off. 
     */
    @MavlinkEntryInfo(1)
    MAV_GENERATOR_STATUS_FLAG_OFF,

    /**
     * Generator is ready to start generating power. 
     */
    @MavlinkEntryInfo(2)
    MAV_GENERATOR_STATUS_FLAG_READY,

    /**
     * Generator is generating power. 
     */
    @MavlinkEntryInfo(4)
    MAV_GENERATOR_STATUS_FLAG_GENERATING,

    /**
     * Generator is charging the batteries (generating enough power to charge and provide the load). 
     */
    @MavlinkEntryInfo(8)
    MAV_GENERATOR_STATUS_FLAG_CHARGING,

    /**
     * Generator is operating at a reduced maximum power. 
     */
    @MavlinkEntryInfo(16)
    MAV_GENERATOR_STATUS_FLAG_REDUCED_POWER,

    /**
     * Generator is providing the maximum output. 
     */
    @MavlinkEntryInfo(32)
    MAV_GENERATOR_STATUS_FLAG_MAXPOWER,

    /**
     * Generator is near the maximum operating temperature, cooling is insufficient. 
     */
    @MavlinkEntryInfo(64)
    MAV_GENERATOR_STATUS_FLAG_OVERTEMP_WARNING,

    /**
     * Generator hit the maximum operating temperature and shutdown. 
     */
    @MavlinkEntryInfo(128)
    MAV_GENERATOR_STATUS_FLAG_OVERTEMP_FAULT,

    /**
     * Power electronics are near the maximum operating temperature, cooling is insufficient. 
     */
    @MavlinkEntryInfo(256)
    MAV_GENERATOR_STATUS_FLAG_ELECTRONICS_OVERTEMP_WARNING,

    /**
     * Power electronics hit the maximum operating temperature and shutdown. 
     */
    @MavlinkEntryInfo(512)
    MAV_GENERATOR_STATUS_FLAG_ELECTRONICS_OVERTEMP_FAULT,

    /**
     * Power electronics experienced a fault and shutdown. 
     */
    @MavlinkEntryInfo(1024)
    MAV_GENERATOR_STATUS_FLAG_ELECTRONICS_FAULT,

    /**
     * The power source supplying the generator failed e.g. mechanical generator stopped, tether is 
     * no longer providing power, solar cell is in shade, hydrogen reaction no longer happening. 
     */
    @MavlinkEntryInfo(2048)
    MAV_GENERATOR_STATUS_FLAG_POWERSOURCE_FAULT,

    /**
     * Generator controller having communication problems. 
     */
    @MavlinkEntryInfo(4096)
    MAV_GENERATOR_STATUS_FLAG_COMMUNICATION_WARNING,

    /**
     * Power electronic or generator cooling system error. 
     */
    @MavlinkEntryInfo(8192)
    MAV_GENERATOR_STATUS_FLAG_COOLING_WARNING,

    /**
     * Generator controller power rail experienced a fault. 
     */
    @MavlinkEntryInfo(16384)
    MAV_GENERATOR_STATUS_FLAG_POWER_RAIL_FAULT,

    /**
     * Generator controller exceeded the overcurrent threshold and shutdown to prevent damage. 
     */
    @MavlinkEntryInfo(32768)
    MAV_GENERATOR_STATUS_FLAG_OVERCURRENT_FAULT,

    /**
     * Generator controller detected a high current going into the batteries and shutdown to prevent 
     * battery damage. 
     */
    @MavlinkEntryInfo(65536)
    MAV_GENERATOR_STATUS_FLAG_BATTERY_OVERCHARGE_CURRENT_FAULT,

    /**
     * Generator controller exceeded it's overvoltage threshold and shutdown to prevent it 
     * exceeding the voltage rating. 
     */
    @MavlinkEntryInfo(131072)
    MAV_GENERATOR_STATUS_FLAG_OVERVOLTAGE_FAULT,

    /**
     * Batteries are under voltage (generator will not start). 
     */
    @MavlinkEntryInfo(262144)
    MAV_GENERATOR_STATUS_FLAG_BATTERY_UNDERVOLT_FAULT,

    /**
     * Generator start is inhibited by e.g. a safety switch. 
     */
    @MavlinkEntryInfo(524288)
    MAV_GENERATOR_STATUS_FLAG_START_INHIBITED,

    /**
     * Generator requires maintenance. 
     */
    @MavlinkEntryInfo(1048576)
    MAV_GENERATOR_STATUS_FLAG_MAINTENANCE_REQUIRED,

    /**
     * Generator is not ready to generate yet. 
     */
    @MavlinkEntryInfo(2097152)
    MAV_GENERATOR_STATUS_FLAG_WARMING_UP,

    /**
     * Generator is idle. 
     */
    @MavlinkEntryInfo(4194304)
    MAV_GENERATOR_STATUS_FLAG_IDLE
}
