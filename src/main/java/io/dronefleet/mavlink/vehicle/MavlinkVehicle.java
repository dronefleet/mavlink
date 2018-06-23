package io.dronefleet.mavlink.vehicle;

import com.benbarkay.events.EventEmitter;
import com.benbarkay.events.EventSource;

public interface MavlinkVehicle {
    int systemId();
    EventEmitter<Object> outgoing();
    EventSource<Object> incoming();
}
