package io.dronefleet.mavlink.asluav;

import io.dronefleet.mavlink.MavlinkDialect;
import io.dronefleet.mavlink.MavlinkDialects;
import java.lang.Class;
import java.lang.IllegalArgumentException;
import java.lang.Override;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class AsluavDialect implements MavlinkDialect {
    private static final Set<MavlinkDialect> dependencies;

    static {
        dependencies = Stream.of(
                MavlinkDialects.COMMON)
                .collect(Collectors.toSet());
    }

    @Override
    public final boolean supports(int messageId) {
        switch (messageId) {
            case 201:
            case 202:
            case 203:
            case 204:
            case 205:
            case 206:
            case 207:
            case 208:
            case 209:
            case 210:
            case 211:
            case 212:
            return true;
        }
        return dependencies.stream()
                .anyMatch(d -> d.supports(messageId));
    }

    @Override
    public final Class resolve(int messageId) {
        switch (messageId) {
            case 201: return SensPower.class;
            case 202: return SensMppt.class;
            case 203: return AslctrlData.class;
            case 204: return AslctrlDebug.class;
            case 205: return AsluavStatus.class;
            case 206: return EkfExt.class;
            case 207: return AslObctrl.class;
            case 208: return SensAtmos.class;
            case 209: return SensBatmon.class;
            case 210: return FwSoaringData.class;
            case 211: return SensorpodStatus.class;
            case 212: return SensPowerBoard.class;
        }
        return dependencies.stream()
                .filter(d -> d.supports(messageId))
                .map(d -> d.resolve(messageId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Dialect ASLUAV does not support a message of ID " + messageId));
    }
}
