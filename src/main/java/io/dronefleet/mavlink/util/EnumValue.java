package io.dronefleet.mavlink.util;

import io.dronefleet.mavlink.util.reflection.MavlinkReflection;

import java.util.Arrays;
import java.util.Optional;

public class EnumValue<T extends Enum> {

    public static <T extends Enum> EnumValue<T> of(T entry) {
        int value = MavlinkReflection.getEnumValue(entry);
        return new EnumValue<>(value, entry);
    }

    public static <T extends Enum> EnumValue<T> create(Enum... flags) {
        return create(
                Arrays.stream(flags)
                        .mapToInt(MavlinkReflection::getEnumValue)
                        .reduce((bitmask, value) -> bitmask | value)
                        .orElse(0));
    }

    public static <T extends Enum> EnumValue<T> create(int value) {
        return new EnumValue<>(value, null);
    }

    public static <T extends Enum> EnumValue<T> create(Class<T> enumType, int value) {
        return new EnumValue<>(
                value,
                MavlinkReflection.getEntryByValue(enumType, value)
                        .orElse(null));
    }

    private final int value;
    private final T entry;

    private EnumValue(int value, T entry) {
        this.value = value;
        this.entry = entry;
    }

    public int value() {
        return value;
    }

    public Optional<T> entry() {
        return Optional.ofNullable(entry);
    }

    public boolean flagsEnabled(Enum... flags) {
        return flagsEnabled(Arrays.stream(flags)
                .map(MavlinkReflection::getEnumValue)
                .mapToInt(Integer::intValue)
                .toArray());
    }

    public boolean flagsEnabled(int... flags) {
        return Arrays.stream(flags)
                .filter(flag -> flag != (value & flag))
                .mapToObj(flag -> false)
                .findFirst()
                .orElse(true);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EnumValue<?> enumValue = (EnumValue<?>) o;

        if (value != enumValue.value) return false;
        return entry != null ? entry.equals(enumValue.entry) : enumValue.entry == null;
    }

    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + (entry != null ? entry.hashCode() : 0);
        return result;
    }
}
