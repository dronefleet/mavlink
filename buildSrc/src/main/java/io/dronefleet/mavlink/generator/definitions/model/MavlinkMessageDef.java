package io.dronefleet.mavlink.generator.definitions.model;

import java.util.List;

public class MavlinkMessageDef {
    private final int id;
    private final String name;
    private final String description;
    private final List<MavlinkFieldDef> fields;

    public MavlinkMessageDef(
            int id,
            String name,
            String description,
            List<MavlinkFieldDef> fields) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.fields = fields;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<MavlinkFieldDef> getFields() {
        return fields;
    }

    @Override
    public String toString() {
        return "MavlinkMessageDef{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", fields=" + fields +
                '}';
    }
}
