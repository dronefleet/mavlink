package io.dronefleet.mavlink.asluav;

import io.dronefleet.mavlink.MavlinkDialect;
import io.dronefleet.mavlink.common.CommonDialect;
import java.lang.Class;
import java.lang.IllegalArgumentException;
import java.lang.Override;
import java.lang.String;
import java.util.Arrays;
import java.util.List;

public final class AsluavDialect implements MavlinkDialect {
    /**
     * A list of dialects that this dialect depends on.
     */
    private final List<MavlinkDialect> dependencies = Arrays.asList(
            new CommonDialect());

    /**
     * {@inheritDoc}
     */
    @Override
    public final String name() {
        return "asluav";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final boolean supports(int messageId) {
        switch (messageId) {
            case 201:
            case 202:
            case 203:
            case 204:
            case 205:
            case 206:
            case 207:
            case 208:
            case 209:
            case 210:
            case 211:
            case 212:
                return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final Class resolve(int messageId) {
        switch (messageId) {
            case 201: return SensPower.class;
            case 202: return SensMppt.class;
            case 203: return AslctrlData.class;
            case 204: return AslctrlDebug.class;
            case 205: return AsluavStatus.class;
            case 206: return EkfExt.class;
            case 207: return AslObctrl.class;
            case 208: return SensAtmos.class;
            case 209: return SensBatmon.class;
            case 210: return FwSoaringData.class;
            case 211: return SensorpodStatus.class;
            case 212: return SensPowerBoard.class;
        }
        throw new IllegalArgumentException(getClass().getSimpleName() + " does not support message of ID " + messageId);
    }
}
