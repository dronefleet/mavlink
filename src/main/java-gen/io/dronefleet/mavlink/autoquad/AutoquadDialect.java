package io.dronefleet.mavlink.autoquad;

import com.benbarkay.events.EventEmitter;
import com.benbarkay.events.EventSource;
import io.dronefleet.mavlink.MavlinkDialect;
import io.dronefleet.mavlink.MavlinkDialects;
import java.lang.Class;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class AutoquadDialect implements MavlinkDialect<AutoquadVehicle> {
    private static final Set<MavlinkDialect> dependencies;

    static {
        dependencies = Stream.of(
                MavlinkDialects.COMMON)
                .collect(Collectors.toSet());
    }

    @Override
    public final AutoquadVehicle newVehicle(int systemId, EventSource<Object> incoming,
            EventEmitter<Object> outgoing) {
        return new AutoquadVehicle.Impl(systemId, incoming, outgoing);
    }

    @Override
    public final boolean supports(int messageId) {
        switch (messageId) {
            case 150:
            case 152:
            return true;
        }
        return dependencies.stream()
                .anyMatch(d -> d.supports(messageId));
    }

    @Override
    public final Class resolve(int messageId) {
        switch (messageId) {
            case 150: return AqTelemetryF.class;
            case 152: return AqEscTelemetry.class;
        }
        return dependencies.stream()
                .filter(d -> d.supports(messageId))
                .map(d -> d.resolve(messageId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Dialect autoquad does not support a message of ID " + messageId));
    }
}
