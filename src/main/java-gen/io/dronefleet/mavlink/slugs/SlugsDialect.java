package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.AbstractMavlinkDialect;
import io.dronefleet.mavlink.MavlinkDialect;
import io.dronefleet.mavlink.common.CommonDialect;
import io.dronefleet.mavlink.util.UnmodifiableMapBuilder;
import java.lang.Class;
import java.lang.Integer;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class SlugsDialect extends AbstractMavlinkDialect {
    /**
     * A list of all of the dependencies of this dialect.
     */
    private static final List<MavlinkDialect> dependencies = Arrays.asList(
            new CommonDialect());

    /**
     * A list of all message types supported by this dialect.
     */
    private static final Map<Integer, Class> messages = new UnmodifiableMapBuilder<Integer, Class>()
            .put(170, CpuLoad.class)
            .put(172, SensorBias.class)
            .put(173, Diagnostic.class)
            .put(176, SlugsNavigation.class)
            .put(177, DataLog.class)
            .put(179, GpsDateTime.class)
            .put(180, MidLvlCmds.class)
            .put(181, CtrlSrfcPt.class)
            .put(184, SlugsCameraOrder.class)
            .put(185, ControlSurface.class)
            .put(186, SlugsMobileLocation.class)
            .put(188, SlugsConfigurationCamera.class)
            .put(189, IsrLocation.class)
            .put(191, VoltSensor.class)
            .put(192, PtzStatus.class)
            .put(193, UavStatus.class)
            .put(194, StatusGps.class)
            .put(195, NovatelDiag.class)
            .put(196, SensorDiag.class)
            .put(197, Boot.class)
            .build();

    public SlugsDialect() {
        super("slugs", dependencies, messages);
    }
}
