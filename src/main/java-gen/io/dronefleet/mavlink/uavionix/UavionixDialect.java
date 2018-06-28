package io.dronefleet.mavlink.uavionix;

import io.dronefleet.mavlink.MavlinkDialect;
import io.dronefleet.mavlink.common.CommonDialect;
import java.lang.Class;
import java.lang.IllegalArgumentException;
import java.lang.Override;
import java.lang.String;
import java.util.Arrays;
import java.util.List;

public final class UavionixDialect implements MavlinkDialect {
    /**
     * A list of dialects that this dialect depends on.
     */
    private final List<MavlinkDialect> dependencies = Arrays.asList(
            new CommonDialect());

    /**
     * {@inheritDoc}
     */
    @Override
    public final String name() {
        return "uavionix";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final boolean supports(int messageId) {
        switch (messageId) {
            case 10001:
            case 10002:
            case 10003:
                return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final Class resolve(int messageId) {
        switch (messageId) {
            case 10001: return UavionixAdsbOutCfg.class;
            case 10002: return UavionixAdsbOutDynamic.class;
            case 10003: return UavionixAdsbTransceiverHealthReport.class;
        }
        throw new IllegalArgumentException(getClass().getSimpleName() + " does not support message of ID " + messageId);
    }
}
