package io.dronefleet.mavlink.generator.definitions.model;

import java.util.List;

public class MavlinkDef {

    private final List<String> includes;
    private final String name;
    private final int version;
    private final int id;
    private final List<MavlinkEnumDef> enums;
    private final List<MavlinkMessageDef> messages;

    public MavlinkDef(
            List<String> includes,
            String name,
            int version,
            int id,
            List<MavlinkEnumDef> enums,
            List<MavlinkMessageDef> messages) {
        this.includes = includes;
        this.name = name;
        this.version = version;
        this.id = id;
        this.enums = enums;
        this.messages = messages;
    }

    public List<String> getIncludes() {
        return includes;
    }

    public String getName() {
        return name;
    }

    public int getVersion() {
        return version;
    }

    public int getId() {
        return id;
    }

    public List<MavlinkEnumDef> getEnums() {
        return enums;
    }

    public List<MavlinkMessageDef> getMessages() {
        return messages;
    }

    @Override
    public String toString() {
        return "MavlinkDef{" +
                "includes=" + includes +
                ", name='" + name + '\'' +
                ", version=" + version +
                ", id=" + id +
                ", enums=" + enums +
                ", messages=" + messages +
                '}';
    }
}
