package io.dronefleet.mavlink.generator.definitions.model;

public class MavlinkDeprecationDef {
    private final String since;
    private final String replacedBy;
    private final String message;

    public MavlinkDeprecationDef(String since, String replacedBy, String message) {
        this.since = since;
        this.replacedBy = replacedBy;
        this.message = message;
    }

    public String getSince() {
        return since;
    }

    public String getReplacedBy() {
        return replacedBy;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MavlinkDeprecationDef that = (MavlinkDeprecationDef) o;

        if (since != null ? !since.equals(that.since) : that.since != null) return false;
        if (replacedBy != null ? !replacedBy.equals(that.replacedBy) : that.replacedBy != null) return false;
        return message != null ? message.equals(that.message) : that.message == null;
    }

    @Override
    public int hashCode() {
        int result = since != null ? since.hashCode() : 0;
        result = 31 * result + (replacedBy != null ? replacedBy.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MavlinkDeprecationDef{" +
                "since='" + since + '\'' +
                ", replacedBy='" + replacedBy + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
