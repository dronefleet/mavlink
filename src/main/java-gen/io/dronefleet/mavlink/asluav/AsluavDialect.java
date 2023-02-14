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
            .put(223, CommandIntStamped.class)
            .put(224, CommandLongStamped.class)
            .put(8002, SensPower.class)
            .put(8003, SensMppt.class)
            .put(8004, AslctrlData.class)
            .put(8005, AslctrlDebug.class)
            .put(8006, AsluavStatus.class)
            .put(8007, EkfExt.class)
            .put(8008, AslObctrl.class)
            .put(8009, SensAtmos.class)
            .put(8010, SensBatmon.class)
            .put(8011, FwSoaringData.class)
            .put(8012, SensorpodStatus.class)
            .put(8013, SensPowerBoard.class)
            .put(8014, GsmLinkStatus.class)
            .put(8015, SatcomLinkStatus.class)
            .put(8016, SensorAirflowAngles.class)
            .build();

    public AsluavDialect() {
        super("asluav", dependencies, messages);
    }
}
