package io.dronefleet.mavlink.paparazzi;

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

public final class PaparazziDialect implements MavlinkDialect<PaparazziVehicle> {
    private static final Set<MavlinkDialect> dependencies;

    static {
        dependencies = Stream.of(
                MavlinkDialects.COMMON)
                .collect(Collectors.toSet());
    }

    @Override
    public final PaparazziVehicle newVehicle(int systemId, EventSource<Object> incoming,
            EventEmitter<Object> outgoing) {
        return new PaparazziVehicle.Impl(systemId, incoming, outgoing);
    }

    @Override
    public final boolean supports(int messageId) {
        switch (messageId) {
            case 180:
            case 181:
            case 182:
            case 183:
            case 184:
            return true;
        }
        return dependencies.stream()
                .anyMatch(d -> d.supports(messageId));
    }

    @Override
    public final Class resolve(int messageId) {
        switch (messageId) {
            case 180: return ScriptItem.class;
            case 181: return ScriptRequest.class;
            case 182: return ScriptRequestList.class;
            case 183: return ScriptCount.class;
            case 184: return ScriptCurrent.class;
        }
        return dependencies.stream()
                .filter(d -> d.supports(messageId))
                .map(d -> d.resolve(messageId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Dialect paparazzi does not support a message of ID " + messageId));
    }
}
