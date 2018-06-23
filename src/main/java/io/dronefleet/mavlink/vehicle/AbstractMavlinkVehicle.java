package io.dronefleet.mavlink.vehicle;

import com.benbarkay.events.EventEmitter;
import com.benbarkay.events.EventSource;

public abstract class AbstractMavlinkVehicle implements MavlinkVehicle {
    private final int systemId;
    private final EventSource<Object> incoming;
    private final EventEmitter<Object> outgoing;

    public AbstractMavlinkVehicle(
            int systemId,
            EventSource<Object> incoming,
            EventEmitter<Object> outgoing) {
        this.systemId = systemId;
        this.incoming = incoming;
        this.outgoing = outgoing;
    }

    @Override
    public int systemId() {
        return systemId;
    }

    @Override
    public EventSource<Object> incoming() {
        return incoming;
    }

    @Override
    public EventEmitter<Object> outgoing() {
        return outgoing;
    }
}
