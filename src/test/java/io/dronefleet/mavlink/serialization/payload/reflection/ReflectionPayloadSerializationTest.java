package io.dronefleet.mavlink.serialization.payload.reflection;


import io.dronefleet.mavlink.common.CommandLong;
import io.dronefleet.mavlink.common.MavCmd;
import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.assertEquals;

public class ReflectionPayloadSerializationTest {
    ReflectionPayloadDeserializer deserializer = new ReflectionPayloadDeserializer();
    ReflectionPayloadSerializer serializer = new ReflectionPayloadSerializer();

    @Test
    public void test() throws InterruptedException {
        CommandLong expected = CommandLong.builder()
                .command(MavCmd.MAV_CMD_COMPONENT_ARM_DISARM)
                .param1(1)
                .param2(2989.0f)
                .targetSystem(1)
                .targetComponent(0)
                .build();

        byte[] bytes = serializer.serialize(expected);
        CommandLong actual = deserializer.deserialize(bytes, CommandLong.class);
        assertEquals(expected, actual);
    }
}