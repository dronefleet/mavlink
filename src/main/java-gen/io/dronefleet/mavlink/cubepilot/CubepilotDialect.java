package io.dronefleet.mavlink.cubepilot;

import io.dronefleet.mavlink.AbstractMavlinkDialect;
import io.dronefleet.mavlink.MavlinkDialect;
import io.dronefleet.mavlink.common.CommonDialect;
import io.dronefleet.mavlink.util.UnmodifiableMapBuilder;
import java.lang.Class;
import java.lang.Integer;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class CubepilotDialect extends AbstractMavlinkDialect {
    /**
     * A list of all of the dependencies of this dialect.
     */
    private static final List<MavlinkDialect> dependencies = Arrays.asList(
            new CommonDialect());

    /**
     * A list of all message types supported by this dialect.
     */
    private static final Map<Integer, Class> messages = new UnmodifiableMapBuilder<Integer, Class>()
            .put(50001, CubepilotRawRc.class)
            .put(50002, HerelinkVideoStreamInformation.class)
            .put(50003, HerelinkTelem.class)
            .put(50004, CubepilotFirmwareUpdateStart.class)
            .put(50005, CubepilotFirmwareUpdateResp.class)
            .build();

    public CubepilotDialect() {
        super("cubepilot", dependencies, messages);
    }
}
