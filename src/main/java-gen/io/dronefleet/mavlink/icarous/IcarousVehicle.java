package io.dronefleet.mavlink.icarous;

import com.benbarkay.events.EventEmitter;
import com.benbarkay.events.EventSource;
import io.dronefleet.mavlink.vehicle.AbstractMavlinkVehicle;
import io.dronefleet.mavlink.vehicle.MavlinkVehicle;
import java.lang.Object;

public interface IcarousVehicle extends MavlinkVehicle {
    /**
     * Kinematic multi bands (track) output from Daidalus 
     * @param min1 min angle (degrees) 
     * @param max1 max angle (degrees) 
     * @param min2 min angle (degrees) 
     * @param max2 max angle (degrees) 
     * @param min3 min angle (degrees) 
     * @param max3 max angle (degrees) 
     * @param min4 min angle (degrees) 
     * @param max4 max angle (degrees) 
     * @param min5 min angle (degrees) 
     * @param max5 max angle (degrees) 
     * @param numbands Number of track bands 
     * @param type1 See the TRACK_BAND_TYPES enum. 
     * @param type2 See the TRACK_BAND_TYPES enum. 
     * @param type3 See the TRACK_BAND_TYPES enum. 
     * @param type4 See the TRACK_BAND_TYPES enum. 
     * @param type5 See the TRACK_BAND_TYPES enum. 
     */
    default void sendIcarousKinematicBands(float min1, float max1, float min2, float max2,
            float min3, float max3, float min4, float max4, float min5, float max5, int numbands,
            IcarousTrackBandTypes type1, IcarousTrackBandTypes type2, IcarousTrackBandTypes type3,
            IcarousTrackBandTypes type4, IcarousTrackBandTypes type5) {
        outgoing().emit(IcarousKinematicBands.builder()
                .min1(min1)
                .max1(max1)
                .min2(min2)
                .max2(max2)
                .min3(min3)
                .max3(max3)
                .min4(min4)
                .max4(max4)
                .min5(min5)
                .max5(max5)
                .numbands(numbands)
                .type1(type1)
                .type2(type2)
                .type3(type3)
                .type4(type4)
                .type5(type5)
                .build());
    }

    /**
     * ICAROUS heartbeat 
     * @param status See the FMS_STATE enum. 
     */
    default void sendIcarousHeartbeat(IcarousFmsState status) {
        outgoing().emit(IcarousHeartbeat.builder()
                .status(status)
                .build());
    }

    final class Impl extends AbstractMavlinkVehicle implements IcarousVehicle {
        Impl(int systemId, EventSource<Object> incoming, EventEmitter<Object> outgoing) {
            super(systemId, incoming, outgoing);
        }
    }
}
