package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.AbstractMavlinkDialect;
import io.dronefleet.mavlink.MavlinkDialect;
import io.dronefleet.mavlink.common.CommonDialect;
import io.dronefleet.mavlink.icarous.IcarousDialect;
import io.dronefleet.mavlink.uavionix.UavionixDialect;
import io.dronefleet.mavlink.util.UnmodifiableMapBuilder;
import java.lang.Class;
import java.lang.Integer;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class ArdupilotmegaDialect extends AbstractMavlinkDialect {
    /**
     * A list of all of the dependencies of this dialect.
     */
    private static final List<MavlinkDialect> dependencies = Arrays.asList(
            new CommonDialect(),
            new UavionixDialect(),
            new IcarousDialect());

    /**
     * A list of all message types supported by this dialect.
     */
    private static final Map<Integer, Class> messages = new UnmodifiableMapBuilder<Integer, Class>()
            .put(150, SensorOffsets.class)
            .put(151, SetMagOffsets.class)
            .put(152, Meminfo.class)
            .put(153, ApAdc.class)
            .put(154, DigicamConfigure.class)
            .put(155, DigicamControl.class)
            .put(156, MountConfigure.class)
            .put(157, MountControl.class)
            .put(158, MountStatus.class)
            .put(160, FencePoint.class)
            .put(161, FenceFetchPoint.class)
            .put(163, Ahrs.class)
            .put(164, Simstate.class)
            .put(165, Hwstatus.class)
            .put(166, Radio.class)
            .put(167, LimitsStatus.class)
            .put(168, Wind.class)
            .put(169, Data16.class)
            .put(170, Data32.class)
            .put(171, Data64.class)
            .put(172, Data96.class)
            .put(173, Rangefinder.class)
            .put(174, AirspeedAutocal.class)
            .put(175, RallyPoint.class)
            .put(176, RallyFetchPoint.class)
            .put(177, CompassmotStatus.class)
            .put(178, Ahrs2.class)
            .put(179, CameraStatus.class)
            .put(180, CameraFeedback.class)
            .put(181, Battery2.class)
            .put(182, Ahrs3.class)
            .put(183, AutopilotVersionRequest.class)
            .put(184, RemoteLogDataBlock.class)
            .put(185, RemoteLogBlockStatus.class)
            .put(186, LedControl.class)
            .put(191, MagCalProgress.class)
            .put(192, MagCalReport.class)
            .put(193, EkfStatusReport.class)
            .put(194, PidTuning.class)
            .put(195, Deepstall.class)
            .put(200, GimbalReport.class)
            .put(201, GimbalControl.class)
            .put(214, GimbalTorqueCmdReport.class)
            .put(215, GoproHeartbeat.class)
            .put(216, GoproGetRequest.class)
            .put(217, GoproGetResponse.class)
            .put(218, GoproSetRequest.class)
            .put(219, GoproSetResponse.class)
            .put(225, EfiStatus.class)
            .put(226, Rpm.class)
            .put(11000, DeviceOpRead.class)
            .put(11001, DeviceOpReadReply.class)
            .put(11002, DeviceOpWrite.class)
            .put(11003, DeviceOpWriteReply.class)
            .put(11010, AdapTuning.class)
            .put(11011, VisionPositionDelta.class)
            .put(11020, AoaSsa.class)
            .put(11030, EscTelemetry1To4.class)
            .put(11031, EscTelemetry5To8.class)
            .put(11032, EscTelemetry9To12.class)
            .build();

    public ArdupilotmegaDialect() {
        super("ardupilotmega", dependencies, messages);
    }
}
