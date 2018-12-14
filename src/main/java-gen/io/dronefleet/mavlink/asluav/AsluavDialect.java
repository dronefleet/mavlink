package io.dronefleet.mavlink.asluav;

import io.dronefleet.mavlink.AbstractMavlinkDialect;
import io.dronefleet.mavlink.MavlinkDialect;
import io.dronefleet.mavlink.common.CommonDialect;
import io.dronefleet.mavlink.util.UnmodifiableMapBuilder;
import java.lang.Class;
import java.lang.Integer;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class AsluavDialect extends AbstractMavlinkDialect {
    /**
     * A list of all of the dependencies of this dialect.
     */
    private static final List<MavlinkDialect> dependencies = Arrays.asList(
            new CommonDialect());

    /**
     * A list of all message types supported by this dialect.
     */
    private static final Map<Integer, Class> messages = new UnmodifiableMapBuilder<Integer, Class>()
            .put(78, CommandIntStamped.class)
            .put(79, CommandLongStamped.class)
            .put(201, SensPower.class)
            .put(202, SensMppt.class)
            .put(203, AslctrlData.class)
            .put(204, AslctrlDebug.class)
            .put(205, AsluavStatus.class)
            .put(206, EkfExt.class)
            .put(207, AslObctrl.class)
            .put(208, SensAtmos.class)
            .put(209, SensBatmon.class)
            .put(210, FwSoaringData.class)
            .put(211, SensorpodStatus.class)
            .put(212, SensPowerBoard.class)
            .put(213, GsmLinkStatus.class)
            .build();

    public AsluavDialect() {
        super("asluav", dependencies, messages);
    }
}
