package io.dronefleet.mavlink.util;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class EnumFlagSet<T extends Enum> {
    private final Set<T> enabled;

    public EnumFlagSet() {
        this.enabled = new HashSet<>();
    }

    public boolean enabled(T flag) {
        return enabled.contains(flag);
    }

    public void enable(T flag) {
        enabled.add(flag);
    }

    public void disable(T flag) {
        enabled.remove(flag);
    }

    public Set<T> getEnabled() {
        return Collections.unmodifiableSet(enabled);
    }
}
