package io.dronefleet.mavlink.storm32;

import io.dronefleet.mavlink.AbstractMavlinkDialect;
import io.dronefleet.mavlink.MavlinkDialect;
import io.dronefleet.mavlink.ardupilotmega.ArdupilotmegaDialect;
import io.dronefleet.mavlink.util.UnmodifiableMapBuilder;
import java.lang.Class;
import java.lang.Integer;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class Storm32Dialect extends AbstractMavlinkDialect {
    /**
     * A list of all of the dependencies of this dialect.
     */
    private static final List<MavlinkDialect> dependencies = Arrays.asList(
            new ArdupilotmegaDialect());

    /**
     * A list of all message types supported by this dialect.
     */
    private static final Map<Integer, Class> messages = new UnmodifiableMapBuilder<Integer, Class>()
            .put(60010, Storm32GimbalManagerInformation.class)
            .put(60011, Storm32GimbalManagerStatus.class)
            .put(60012, Storm32GimbalManagerControl.class)
            .put(60013, Storm32GimbalManagerControlPitchyaw.class)
            .put(60014, Storm32GimbalManagerCorrectRoll.class)
            .put(60020, QshotStatus.class)
            .put(60045, RadioRcChannels.class)
            .put(60046, RadioLinkStats.class)
            .put(60040, FrskyPassthroughArray.class)
            .put(60041, ParamValueArray.class)
            .build();

    public Storm32Dialect() {
        super("storm32", dependencies, messages);
    }
}
