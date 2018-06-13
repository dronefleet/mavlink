package io.dronefleet.mavlink.generator.definitions.model;

import java.util.List;

public class MavlinkEnumDef {
    private final String name;
    private final String description;
    private final List<MavlinkEntryDef> entries;

    public MavlinkEnumDef(String name, String description, List<MavlinkEntryDef> entries) {
        this.name = name;
        this.description = description;
        this.entries = entries;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<MavlinkEntryDef> getEntries() {
        return entries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MavlinkEnumDef that = (MavlinkEnumDef) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        return entries != null ? entries.equals(that.entries) : that.entries == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (entries != null ? entries.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MavlinkEnumDef{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", entries=" + entries +
                '}';
    }
}
