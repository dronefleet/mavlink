package io.dronefleet.mavlink.python_array_test;

import io.dronefleet.mavlink.AbstractMavlinkDialect;
import io.dronefleet.mavlink.MavlinkDialect;
import io.dronefleet.mavlink.common.CommonDialect;
import io.dronefleet.mavlink.util.UnmodifiableMapBuilder;
import java.lang.Class;
import java.lang.Integer;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class PythonArrayTestDialect extends AbstractMavlinkDialect {
    /**
     * A list of all of the dependencies of this dialect.
     */
    private static final List<MavlinkDialect> dependencies = Arrays.asList(
            new CommonDialect());

    /**
     * A list of all message types supported by this dialect.
     */
    private static final Map<Integer, Class> messages = new UnmodifiableMapBuilder<Integer, Class>()
            .put(150, ArrayTest0.class)
            .put(151, ArrayTest1.class)
            .put(153, ArrayTest3.class)
            .put(154, ArrayTest4.class)
            .put(155, ArrayTest5.class)
            .put(156, ArrayTest6.class)
            .put(157, ArrayTest7.class)
            .put(158, ArrayTest8.class)
            .build();

    public PythonArrayTestDialect() {
        super("python_array_test", dependencies, messages);
    }
}
