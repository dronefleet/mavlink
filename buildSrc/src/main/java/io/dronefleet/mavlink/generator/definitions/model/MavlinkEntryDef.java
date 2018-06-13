package io.dronefleet.mavlink.generator.definitions.model;

import java.util.List;

public class MavlinkEntryDef {
    private final Integer value;
    private final String name;
    private final String description;
    private final List<MavlinkParamDef> params;

    public MavlinkEntryDef(Integer value, String name, String description, List<MavlinkParamDef> params) {
        this.value = value;
        this.name = name;
        this.description = description;
        this.params = params;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<MavlinkParamDef> getParams() {
        return params;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MavlinkEntryDef entryDef = (MavlinkEntryDef) o;

        if (value != null ? !value.equals(entryDef.value) : entryDef.value != null) return false;
        if (name != null ? !name.equals(entryDef.name) : entryDef.name != null) return false;
        if (description != null ? !description.equals(entryDef.description) : entryDef.description != null)
            return false;
        return params != null ? params.equals(entryDef.params) : entryDef.params == null;
    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (params != null ? params.hashCode() : 0);
        return result;
    }
}
