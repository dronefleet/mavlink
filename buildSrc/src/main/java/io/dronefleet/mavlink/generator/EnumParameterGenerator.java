package io.dronefleet.mavlink.generator;

public class EnumParameterGenerator {
    private final PackageGenerator parentPackage;
    private final int index;
    private final String description;

    public EnumParameterGenerator(
            PackageGenerator parentPackage,
            int index,
            String description) {
        this.parentPackage = parentPackage;
        this.index = index;
        this.description = description;
    }

    public int getIndex() {
        return index;
    }

    public String getDescription() {
        return description;
    }

    public String javadoc() {
        return parentPackage.processJavadoc(description);
    }
}
