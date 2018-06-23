package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Enumeration of distance sensor types 
 */
@MavlinkEnum
public enum MavDistanceSensor {
    /**
     * Laser rangefinder, e.g. LightWare SF02/F or PulsedLight units<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(0)
    MAV_DISTANCE_SENSOR_LASER,

    /**
     * Ultrasound rangefinder, e.g. MaxBotix units<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    MAV_DISTANCE_SENSOR_ULTRASOUND,

    /**
     * Infrared rangefinder, e.g. Sharp units<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    MAV_DISTANCE_SENSOR_INFRARED,

    /**
     * Radar type, e.g. uLanding units<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(3)
    MAV_DISTANCE_SENSOR_RADAR,

    /**
     * Broken or unknown type, e.g. analog units<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(4)
    MAV_DISTANCE_SENSOR_UNKNOWN
}
