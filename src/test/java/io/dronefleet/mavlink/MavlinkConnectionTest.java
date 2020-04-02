package io.dronefleet.mavlink;

import io.dronefleet.mavlink.common.Heartbeat;
import io.dronefleet.mavlink.common.MavAutopilot;
import io.dronefleet.mavlink.common.MavState;
import io.dronefleet.mavlink.common.MavType;
import io.dronefleet.mavlink.util.UnmodifiableMapBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class MavlinkConnectionTest {

    private PipedInputStream in;
    private PipedOutputStream out;
    private MavlinkConnection source;


    @Before
    public void setUp() throws IOException {
        in = new PipedInputStream();
        out = new PipedOutputStream();
        source = MavlinkConnection.create(
                new PipedInputStream(out),
                new PipedOutputStream(in));
    }


    @Test(timeout = 500L)
    public void itUsesDefaultDialectByDefault() throws IOException {
        MavlinkDialect dialect = new AbstractMavlinkDialect(
                "testdialect",
                Collections.emptyList(),
                new UnmodifiableMapBuilder<Integer, Class>()
                        .put(0, TestMessage.class)
                        .build());

        MavlinkConnection target = MavlinkConnection.builder(in, out)
                .defaultDialect(dialect)
                .build();

        Object expected = TestMessage.builder()
                .text("Test")
                .build();
        source.send1(0, 0, expected);

        Object actual = target.next().getPayload();

        assertEquals(expected, actual);
    }

    @Test(timeout = 500L)
    public void itUsesCommonDialectAsFallback() throws IOException {
        MavlinkDialect dialect = new AbstractMavlinkDialect(
                "testdialect",
                Collections.emptyList(),
                new UnmodifiableMapBuilder<Integer, Class>()
                        .put(0, TestMessage.class)
                        .build());

        MavlinkConnection target = MavlinkConnection.builder(in, out)
                .defaultDialect(dialect)
                .build();

        Object expected = Heartbeat.builder()
                .autopilot(MavAutopilot.MAV_AUTOPILOT_GENERIC)
                .type(MavType.MAV_TYPE_GENERIC)
                .systemStatus(MavState.MAV_STATE_UNINIT)
                .baseMode()
                .mavlinkVersion(3)
                .build();
        source.send1(0, 0, expected);

        Object actual = target.next().getPayload();

        assertEquals(expected, actual);
    }

    @Test(timeout = 500L)
    public void defaultDialectDoesNotPreventHeartbeatFromConfiguringDialect() throws IOException {
        MavlinkDialect defaultDialect = new AbstractMavlinkDialect(
                "testdialect",
                Collections.emptyList(),
                new UnmodifiableMapBuilder<Integer, Class>()
                        .put(0, TestMessage.class)
                        .build());

        MavlinkDialect expected = new AbstractMavlinkDialect(
                "expecteddialect",
                Collections.emptyList(),
                Collections.emptyMap());

        MavlinkConnection target = MavlinkConnection.builder(in, out)
                .dialect(MavAutopilot.MAV_AUTOPILOT_GENERIC, expected)
                .defaultDialect(defaultDialect)
                .build();

        source.send1(0, 0, Heartbeat.builder()
                .autopilot(MavAutopilot.MAV_AUTOPILOT_GENERIC)
                .type(MavType.MAV_TYPE_GENERIC)
                .systemStatus(MavState.MAV_STATE_UNINIT)
                .baseMode()
                .mavlinkVersion(3)
                .build());

        target.next();
        MavlinkDialect actual = target.getDialect(0);

        assertEquals(expected, actual);
    }

}