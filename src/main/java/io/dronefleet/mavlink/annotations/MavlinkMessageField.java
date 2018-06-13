package io.dronefleet.mavlink.annotations;

public @interface MavlinkMessageField {
    int position();
    int length();
    int arraySize() default 0;
    boolean extension() default false;
}
