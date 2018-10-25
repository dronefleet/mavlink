package io.dronefleet.mavlink.util;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;

import java.util.Comparator;

public class WireFieldInfoComparator implements Comparator<MavlinkFieldInfo> {
    @Override
    public int compare(MavlinkFieldInfo a, MavlinkFieldInfo b) {
        if (a.extension() && !b.extension()) {
            return 1;
        }
        if (!a.extension() && b.extension()) {
            return -1;
        }

        if (!a.extension() && a.unitSize() != b.unitSize()) {
            return b.unitSize() - a.unitSize();
        }

        return a.position() - b.position();
    }
}
