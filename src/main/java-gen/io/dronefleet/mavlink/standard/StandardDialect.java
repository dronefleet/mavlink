package io.dronefleet.mavlink.standard;

import io.dronefleet.mavlink.AbstractMavlinkDialect;
import io.dronefleet.mavlink.MavlinkDialect;
import io.dronefleet.mavlink.minimal.MinimalDialect;
import java.lang.Class;
import java.lang.Integer;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class StandardDialect extends AbstractMavlinkDialect {
    /**
     * A list of all of the dependencies of this dialect.
     */
    private static final List<MavlinkDialect> dependencies = Arrays.asList(
            new MinimalDialect());

    /**
     * A list of all message types supported by this dialect.
     */
    private static final Map<Integer, Class> messages = Collections.emptyMap();

    public StandardDialect() {
        super("standard", dependencies, messages);
    }
}
