package io.dronefleet.mavlink;

import io.dronefleet.mavlink.ardupilotmega.ArdupilotmegaDialect;
import io.dronefleet.mavlink.asluav.AsluavDialect;
import io.dronefleet.mavlink.autoquad.AutoquadDialect;
import io.dronefleet.mavlink.common.CommonDialect;
import io.dronefleet.mavlink.icarous.IcarousDialect;
import io.dronefleet.mavlink.matrixpilot.MatrixpilotDialect;
import io.dronefleet.mavlink.paparazzi.PaparazziDialect;
import io.dronefleet.mavlink.slugs.SlugsDialect;
import io.dronefleet.mavlink.standard.StandardDialect;
import io.dronefleet.mavlink.uavionix.UavionixDialect;
import java.lang.Class;
import java.lang.Override;

public enum MavlinkDialects implements MavlinkDialect {
    COMMON(new CommonDialect()),

    UAVIONIX(new UavionixDialect()),

    ICAROUS(new IcarousDialect()),

    ARDUPILOTMEGA(new ArdupilotmegaDialect()),

    PAPARAZZI(new PaparazziDialect()),

    SLUGS(new SlugsDialect()),

    ASLUAV(new AsluavDialect()),

    MATRIXPILOT(new MatrixpilotDialect()),

    STANDARD(new StandardDialect()),

    AUTOQUAD(new AutoquadDialect());

    private final MavlinkDialect delegate;

    MavlinkDialects(MavlinkDialect delegate) {
        this.delegate = delegate;
    }

    @Override
    public final boolean supports(int messageId) {
        return delegate.supports(messageId);
    }

    @Override
    public final Class resolve(int messageId) {
        return delegate.resolve(messageId);
    }
}
