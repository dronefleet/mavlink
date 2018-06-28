package io.dronefleet.mavlink.paparazzi;

import io.dronefleet.mavlink.MavlinkDialect;
import io.dronefleet.mavlink.common.CommonDialect;
import java.lang.Class;
import java.lang.IllegalArgumentException;
import java.lang.Override;
import java.lang.String;
import java.util.Arrays;
import java.util.List;

public final class PaparazziDialect implements MavlinkDialect {
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
        return "paparazzi";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final boolean supports(int messageId) {
        switch (messageId) {
            case 180:
            case 181:
            case 182:
            case 183:
            case 184:
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
            case 180: return ScriptItem.class;
            case 181: return ScriptRequest.class;
            case 182: return ScriptRequestList.class;
            case 183: return ScriptCount.class;
            case 184: return ScriptCurrent.class;
        }
        throw new IllegalArgumentException(getClass().getSimpleName() + " does not support message of ID " + messageId);
    }
}
