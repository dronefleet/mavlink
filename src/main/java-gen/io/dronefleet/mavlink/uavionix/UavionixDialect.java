package io.dronefleet.mavlink.uavionix;

import io.dronefleet.mavlink.AbstractMavlinkDialect;
import io.dronefleet.mavlink.MavlinkDialect;
import io.dronefleet.mavlink.common.CommonDialect;
import io.dronefleet.mavlink.util.UnmodifiableMapBuilder;
import java.lang.Class;
import java.lang.Integer;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class UavionixDialect extends AbstractMavlinkDialect {
    /**
     * A list of all of the dependencies of this dialect.
     */
    private static final List<MavlinkDialect> dependencies = Arrays.asList(
            new CommonDialect());

    /**
     * A list of all message types supported by this dialect.
     */
    private static final Map<Integer, Class> messages = new UnmodifiableMapBuilder<Integer, Class>()
            .put(10001, UavionixAdsbOutCfg.class)
            .put(10002, UavionixAdsbOutDynamic.class)
            .put(10003, UavionixAdsbTransceiverHealthReport.class)
            .build();

    public UavionixDialect() {
        super("uavionix", dependencies, messages);
    }
}
