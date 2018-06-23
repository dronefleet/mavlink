package io.dronefleet.mavlink.icarous;

import com.benbarkay.events.EventEmitter;
import com.benbarkay.events.EventSource;
import io.dronefleet.mavlink.MavlinkDialect;
import java.lang.Class;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.util.Collections;
import java.util.Set;

public final class IcarousDialect implements MavlinkDialect<IcarousVehicle> {
    private static final Set<MavlinkDialect> dependencies;

    static {
        dependencies = Collections.emptySet();
    }

    @Override
    public final IcarousVehicle newVehicle(int systemId, EventSource<Object> incoming,
            EventEmitter<Object> outgoing) {
        return new IcarousVehicle.Impl(systemId, incoming, outgoing);
    }

    @Override
    public final boolean supports(int messageId) {
        switch (messageId) {
            case 42000:
            case 42001:
            return true;
        }
        return dependencies.stream()
                .anyMatch(d -> d.supports(messageId));
    }

    @Override
    public final Class resolve(int messageId) {
        switch (messageId) {
            case 42000: return IcarousHeartbeat.class;
            case 42001: return IcarousKinematicBands.class;
        }
        return dependencies.stream()
                .filter(d -> d.supports(messageId))
                .map(d -> d.resolve(messageId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Dialect icarous does not support a message of ID " + messageId));
    }
}
