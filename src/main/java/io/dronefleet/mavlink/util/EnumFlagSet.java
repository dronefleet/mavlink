package io.dronefleet.mavlink.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class EnumFlagSet<T extends Enum> {

    public static <T extends Enum> EnumFlagSet<T> of(T ... enabled) {
        EnumFlagSet<T> flagSet = new EnumFlagSet<>();
        Arrays.stream(enabled).forEach(flagSet::enable);
        return flagSet;
    }

    private final Set<T> enabled;

    public EnumFlagSet() {
        this.enabled = new HashSet<>();
    }

    public boolean enabled(T ... flags) {
        return Arrays.stream(flags)
                .map(enabled::contains)
                .filter(b -> !b)
                .findFirst()
                .orElse(true);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EnumFlagSet<?> that = (EnumFlagSet<?>) o;

        return enabled != null ? enabled.equals(that.enabled) : that.enabled == null;
    }

    @Override
    public int hashCode() {
        return enabled != null ? enabled.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "EnumFlagSet{" +
                "enabled=" + enabled +
                '}';
    }
}
