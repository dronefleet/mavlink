package io.dronefleet.mavlink.standard;

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

public final class StandardDialect implements MavlinkDialect<StandardVehicle> {
    private static final Set<MavlinkDialect> dependencies;

    static {
        dependencies = Stream.of(
                MavlinkDialects.COMMON)
                .collect(Collectors.toSet());
    }

    @Override
    public final StandardVehicle newVehicle(int systemId, EventSource<Object> incoming,
            EventEmitter<Object> outgoing) {
        return new StandardVehicle.Impl(systemId, incoming, outgoing);
    }

    @Override
    public final boolean supports(int messageId) {
        return dependencies.stream()
                .anyMatch(d -> d.supports(messageId));
    }

    @Override
    public final Class resolve(int messageId) {
        return dependencies.stream()
                .filter(d -> d.supports(messageId))
                .map(d -> d.resolve(messageId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Dialect standard does not support a message of ID " + messageId));
    }
}
