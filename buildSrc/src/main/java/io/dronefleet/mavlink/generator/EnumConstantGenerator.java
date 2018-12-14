package io.dronefleet.mavlink.generator;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.TypeSpec;

import java.util.ArrayList;
import java.util.List;

public class EnumConstantGenerator {

    private static final ClassName MAVLINK_ENUM_ENTRY = ClassName.get(
            "io.dronefleet.mavlink.annotations",
            "MavlinkEntryInfo");

    private final PackageGenerator parentPackage;
    private final String name;
    private final int value;
    private final String description;
    private final List<EnumParameterGenerator> parameters;

    public EnumConstantGenerator(
            PackageGenerator parentPackage,
            String name,
            int value,
            String description,
            List<EnumParameterGenerator> parameters) {
        this.parentPackage = parentPackage;
        this.name = name;
        this.value = value;
        this.description = description;
        this.parameters = parameters;
    }

    public boolean deprecated() {
        return description != null && description.toLowerCase().contains("deprecated");
    }

    public String getName() {
        return name;
    }

    public int value() {
        return value;
    }

    public void addParameter(EnumParameterGenerator parameterGenerator) {
        parameters.add(parameterGenerator);
    }

    public AnnotationSpec annotation() {
        return AnnotationSpec.builder(MAVLINK_ENUM_ENTRY)
                .addMember("value", "$L", value)
                .build();
    }

    public List<AnnotationSpec> annotations() {
        List<AnnotationSpec> annotations = new ArrayList<>();
        annotations.add(annotation());
        if (deprecated()) {
            annotations.add(AnnotationSpec.builder(Deprecated.class).build());
        }
        return annotations;
    }

    public String javadoc() {
        StringBuilder javadoc = new StringBuilder();
        javadoc.append(parentPackage.processJavadoc(description));

        if (parameters.size() > 0) {
            javadoc.append("<dl>\n");
            parameters.stream()
                    .map(p -> String.format("<dt>param%d</dt><dd>%s</dd>\n",
                            p.getIndex(),
                            p.javadoc()))
                    .forEach(javadoc::append);
            javadoc.append("</dl>\n");
        }

        return javadoc.toString();
    }

    public TypeSpec generate() {
        return TypeSpec.anonymousClassBuilder("")
                .addJavadoc(javadoc())
                .addAnnotations(annotations())
                .build();
    }
}
