package io.dronefleet.mavlink.generator.definitions.model;

public class MavlinkFieldDef implements Comparable<MavlinkFieldDef> {
    private final int index;
    private final MavlinkTypeDef type;
    private final String name;
    private final String enumName;
    private final String display;
    private final String units;
    private final String printFormat;
    private final boolean extension;
    private final String description;

    public MavlinkFieldDef(
            int index,
            MavlinkTypeDef type,
            String name,
            String enumName,
            String display,
            String units,
            String printFormat,
            boolean extension,
            String description) {
        this.index = index;
        this.type = type;
        this.name = name;
        this.enumName = enumName;
        this.display = display;
        this.units = units;
        this.printFormat = printFormat;
        this.extension = extension;
        this.description = description;
    }

    public int getIndex() {
        return index;
    }

    public MavlinkTypeDef getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getEnumName() {
        return enumName;
    }

    public String getDisplay() {
        return display;
    }

    public String getUnits() {
        return units;
    }

    public String getPrintFormat() {
        return printFormat;
    }

    public boolean isExtension() {
        return extension;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "MavlinkFieldDef{" +
                "index=" + index +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", enumName='" + enumName + '\'' +
                ", display='" + display + '\'' +
                ", units='" + units + '\'' +
                ", printFormat='" + printFormat + '\'' +
                ", extension=" + extension +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public int compareTo(MavlinkFieldDef other) {
        if (this.isExtension() && !other.isExtension()) {
            return 1;
        }
        if (!this.isExtension() && other.isExtension()) {
            return -1;
        }

        if (!this.isExtension() && this.getType().getTypeLength() != other.getType().getTypeLength()) {
            return other.getType().getTypeLength() - this.getType().getTypeLength();
        }

        return this.getIndex() - other.getIndex();
    }
}
