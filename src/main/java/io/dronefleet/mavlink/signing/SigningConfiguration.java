package io.dronefleet.mavlink.signing;

import java.util.Arrays;

/**
 * Configuration for signing Mavlink2 messages.
 */
public class SigningConfiguration {

    /**
     * The timestamp to use when signing.
     */
    private final long timestamp;

    /**
     * The link ID to use when signing.
     */
    private final int linkId;

    /**
     * A 32-byte secret key to use when signing.
     */
    private final byte[] secretKey;

    /**
     * Constructs a new {@code SigningConfiguration} using the specified settings.
     * @param timestamp The timestamp of the last signed packet. This is used in order to
     *                  ensure that signatures will not have a lower timestamp than previous
     *                  signatures. If this is the first sent signed packet with corresponding
     *                  devices, or if guaranteed that current timestamp will be ahead of previous
     *                  signatures, then this value may be set to 0.
     * @param linkId    The link ID to use when signing.
     * @param secretKey The 32-byte secret key to use when signing.
     */
    public SigningConfiguration(long timestamp, int linkId, byte[] secretKey) {
        this.timestamp = timestamp;
        this.linkId = linkId;
        this.secretKey = secretKey;
    }

    /**
     * Returns the timestamp of this signing configuration.
     */
    public long getTimestamp() {
        return timestamp;
    }

    /**
     * Returns the link ID to use when signing.
     */
    public int getLinkId() {
        return linkId;
    }

    /**
     * Returns the secret key to use when signing.
     */
    public byte[] getSecretKey() {
        return secretKey;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SigningConfiguration that = (SigningConfiguration) o;

        if (timestamp != that.timestamp) return false;
        if (linkId != that.linkId) return false;
        return Arrays.equals(secretKey, that.secretKey);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int result = (int) (timestamp ^ (timestamp >>> 32));
        result = 31 * result + linkId;
        result = 31 * result + Arrays.hashCode(secretKey);
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "SigningConfiguration{" +
                "timestamp=" + timestamp +
                ", linkId=" + linkId +
                ", secretKey=" + Arrays.toString(secretKey) +
                '}';
    }
}
