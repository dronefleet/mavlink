package io.dronefleet.mavlink;

import com.benbarkay.events.EventEmitter;
import com.benbarkay.events.EventSource;
import io.dronefleet.mavlink.vehicle.MavlinkVehicle;

public interface MavlinkDialect<T extends MavlinkVehicle> {
    T newVehicle(int systemId, EventSource<Object> incoming, EventEmitter<Object> outgoing);
    Class resolve(int messageId);
    boolean supports(int messageId);
}
