package io.dronefleet.mavlink;

/**
 * Serves as an index of a Mavlink dialect.
 */
public interface MavlinkDialect {

    /**
     * Resolves the class of a message by its ID.
     * @param messageId The ID of the message to resolve.
     * @return  The class of the message of the specified ID.
     */
    Class resolve(int messageId);

    /**
     * Checks whether this dialect supports the message of the specified ID.
     * @param messageId The ID of the message to check support for.
     * @return  {@code true} if this dialect supports the message of the specified ID,
     *          or {@code false} otherwise.
     */
    boolean supports(int messageId);
}
