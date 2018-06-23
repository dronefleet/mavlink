package io.dronefleet.mavlink.standard;

import com.benbarkay.events.EventEmitter;
import com.benbarkay.events.EventSource;
import io.dronefleet.mavlink.common.CommonVehicle;
import io.dronefleet.mavlink.vehicle.AbstractMavlinkVehicle;
import java.lang.Object;

public interface StandardVehicle extends CommonVehicle {
    final class Impl extends AbstractMavlinkVehicle implements StandardVehicle {
        Impl(int systemId, EventSource<Object> incoming, EventEmitter<Object> outgoing) {
            super(systemId, incoming, outgoing);
        }
    }
}
