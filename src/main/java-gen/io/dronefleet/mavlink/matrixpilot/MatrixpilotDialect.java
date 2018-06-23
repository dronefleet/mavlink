package io.dronefleet.mavlink.matrixpilot;

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

public final class MatrixpilotDialect implements MavlinkDialect<MatrixpilotVehicle> {
    private static final Set<MavlinkDialect> dependencies;

    static {
        dependencies = Stream.of(
                MavlinkDialects.COMMON)
                .collect(Collectors.toSet());
    }

    @Override
    public final MatrixpilotVehicle newVehicle(int systemId, EventSource<Object> incoming,
            EventEmitter<Object> outgoing) {
        return new MatrixpilotVehicle.Impl(systemId, incoming, outgoing);
    }

    @Override
    public final boolean supports(int messageId) {
        switch (messageId) {
            case 150:
            case 151:
            case 152:
            case 153:
            case 155:
            case 156:
            case 157:
            case 158:
            case 170:
            case 171:
            case 172:
            case 173:
            case 174:
            case 175:
            case 176:
            case 177:
            case 178:
            case 179:
            case 180:
            case 181:
            case 182:
            case 183:
            case 184:
            case 185:
            case 186:
            case 187:
            case 188:
            return true;
        }
        return dependencies.stream()
                .anyMatch(d -> d.supports(messageId));
    }

    @Override
    public final Class resolve(int messageId) {
        switch (messageId) {
            case 150: return FlexifunctionSet.class;
            case 151: return FlexifunctionReadReq.class;
            case 152: return FlexifunctionBufferFunction.class;
            case 153: return FlexifunctionBufferFunctionAck.class;
            case 155: return FlexifunctionDirectory.class;
            case 156: return FlexifunctionDirectoryAck.class;
            case 157: return FlexifunctionCommand.class;
            case 158: return FlexifunctionCommandAck.class;
            case 170: return SerialUdbExtraF2A.class;
            case 171: return SerialUdbExtraF2B.class;
            case 172: return SerialUdbExtraF4.class;
            case 173: return SerialUdbExtraF5.class;
            case 174: return SerialUdbExtraF6.class;
            case 175: return SerialUdbExtraF7.class;
            case 176: return SerialUdbExtraF8.class;
            case 177: return SerialUdbExtraF13.class;
            case 178: return SerialUdbExtraF14.class;
            case 179: return SerialUdbExtraF15.class;
            case 180: return SerialUdbExtraF16.class;
            case 181: return Altitudes.class;
            case 182: return Airspeeds.class;
            case 183: return SerialUdbExtraF17.class;
            case 184: return SerialUdbExtraF18.class;
            case 185: return SerialUdbExtraF19.class;
            case 186: return SerialUdbExtraF20.class;
            case 187: return SerialUdbExtraF21.class;
            case 188: return SerialUdbExtraF22.class;
        }
        return dependencies.stream()
                .filter(d -> d.supports(messageId))
                .map(d -> d.resolve(messageId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Dialect matrixpilot does not support a message of ID " + messageId));
    }
}
