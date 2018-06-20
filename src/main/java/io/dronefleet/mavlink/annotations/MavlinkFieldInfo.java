package io.dronefleet.mavlink.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Comparator;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface MavlinkFieldInfo {
    Comparator<MavlinkFieldInfo> WIRE_COMPARATOR = (a, b) -> {
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
    };

    int position();
    int unitSize();
    int arraySize() default 0;
    boolean extension() default false;
}
