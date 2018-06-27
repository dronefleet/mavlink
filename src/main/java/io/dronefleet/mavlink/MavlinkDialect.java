package io.dronefleet.mavlink;

public interface MavlinkDialect {
    Class resolve(int messageId);
    boolean supports(int messageId);
}
