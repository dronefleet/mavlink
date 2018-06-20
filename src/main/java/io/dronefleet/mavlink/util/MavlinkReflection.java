package io.dronefleet.mavlink.util;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Optional;

public class MavlinkReflection {
    public static Optional<MavlinkEntryInfo> getEnumEntry(Enum entry) {
        return Arrays.stream(entry.getDeclaringClass().getFields())
                .filter(Field::isEnumConstant)
                .filter(f -> f.isAnnotationPresent(MavlinkEntryInfo.class))
                .filter(f -> {
                    try {
                        return entry.equals(f.get(null));
                    } catch (IllegalAccessException e) {
                        return false;
                    }
                })
                .findFirst()
                .map(f -> f.getAnnotation(MavlinkEntryInfo.class));
    }
}
