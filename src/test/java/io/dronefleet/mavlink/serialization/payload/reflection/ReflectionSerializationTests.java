package io.dronefleet.mavlink.serialization.payload.reflection;


import io.dronefleet.mavlink.common.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ReflectionSerializationTests {

    @Parameterized.Parameters
    public static Collection<Object[]> parameters() {
        return Arrays.asList(new Object[][]{
                        {
                                CommandLong.builder()
                                        .command(MavCmd.MAV_CMD_COMPONENT_ARM_DISARM)
                                        .param1(1)
                                        .param2(2989.0f)
                                        .targetSystem(1)
                                        .targetComponent(0)
                                        .build()
                        },
                        {
                                LogData.builder()
                                        .id(123)
                                        .ofs(46080)
                                        .count(90)
                                        .data(Arrays.copyOf("Test data".getBytes(StandardCharsets.UTF_8), 90))
                                        .build()
                        },
                        {
                                ActuatorControlTarget.builder()
                                        .timeUsec(new BigInteger(new byte[]{-7, -6, -5, -4, -3, -2, -1, 0}))
                                        .controls(Arrays.asList(.1f, -.2f, .3f, -.4f, .5f, -.6f, .7f, -.8f))
                                        .build()
                        },
                        {
                                BatteryStatus.builder()
                                        .batteryFunction(MavBatteryFunction.MAV_BATTERY_FUNCTION_ALL)
                                        .type(MavBatteryType.MAV_BATTERY_TYPE_LION)
                                        .chargeState(MavBatteryChargeState.MAV_BATTERY_CHARGE_STATE_OK)
                                        .voltages(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
                                        .currentBattery(-5)
                                        .build()
                        }
                }
        );
    }

    private final Object expected;
    private final ReflectionPayloadDeserializer deserializer;
    private final ReflectionPayloadSerializer serializer;

    public ReflectionSerializationTests(Object expected) {
        this.expected = expected;
        deserializer = new ReflectionPayloadDeserializer();
        serializer = new ReflectionPayloadSerializer();
    }

    @Test
    public void test() {
        byte[] bytes = serializer.serialize(expected);
        Object actual = deserializer.deserialize(bytes, expected.getClass());
        assertEquals(expected, actual);
    }

}