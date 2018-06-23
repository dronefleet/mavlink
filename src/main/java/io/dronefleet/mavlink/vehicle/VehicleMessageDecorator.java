package io.dronefleet.mavlink.vehicle;

import io.dronefleet.mavlink.MavlinkDialect;
import io.dronefleet.mavlink.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.reflection.MavlinkReflection;

import java.util.function.Function;

public class VehicleMessageDecorator implements Function<Object, MavlinkMessage> {

    private final int systemId;
    private final MavlinkDialect dialect;

    public VehicleMessageDecorator(int systemId, MavlinkDialect dialect) {
        this.systemId = systemId;
        this.dialect = dialect;
    }

    @Override
    public MavlinkMessage apply(Object payload) {
        MavlinkMessageInfo messageInfo = MavlinkReflection.getMessageInfo(payload)
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("Class %s is not annotated with @MavlinkMessageInfo",
                                payload.getClass().getName() )));

        if (!dialect.supports(messageInfo.id())) {
            throw new IllegalArgumentException(String.format(
                    "%s does not support message %s",
                    dialect.getClass().getSimpleName(),
                    payload.getClass().getName()));
        }
        return new MavlinkMessage<>(
                systemId, 0, payload);
    }
}
