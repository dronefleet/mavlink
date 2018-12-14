package io.dronefleet.mavlink.generator;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import java.util.ArrayList;
import java.util.List;

public class EnumGenerator {

    private static final ClassName MAVLINK_ENUM = ClassName.get(
            "io.dronefleet.mavlink.annotations",
            "MavlinkEnum");

    private final PackageGenerator parentPackage;
    private final String name;
    private final ClassName className;
    private final String description;
    private final List<EnumConstantGenerator> constants;
    private final DeprecationGenerator deprecation;

    public EnumGenerator(
            PackageGenerator parentPackage,
            String name,
            ClassName className,
            String description,
            List<EnumConstantGenerator> constants,
            DeprecationGenerator deprecation) {
        this.parentPackage = parentPackage;
        this.name = name;
        this.className = className;
        this.description = description;
        this.constants = constants;
        this.deprecation = deprecation;
    }

    public PackageGenerator getParentPackage() {
        return parentPackage;
    }

    public String getName() {
        return name;
    }

    public ClassName getClassName() {
        return className;
    }

    public String getDescription() {
        return description;
    }

    public String javadoc() {
        String javadoc = parentPackage.processJavadoc(getDescription());

        if (deprecation.deprecated()) {
            javadoc += parentPackage.processJavadoc(deprecation.javadoc());
        }
        return javadoc;
    }

    public void addConstant(EnumConstantGenerator generator) {
        constants.add(generator);
    }

    public int maxValue() {
        return constants.stream()
                .mapToInt(EnumConstantGenerator::value)
                .max()
                .orElse(0);
    }

    public List<AnnotationSpec> annotations() {
        List<AnnotationSpec> annotations = new ArrayList<>();
        annotations.add(AnnotationSpec.builder(MAVLINK_ENUM).build());
        if (deprecation.deprecated()) {
            annotations.add(deprecation.annotation());
        }
        return annotations;
    }

    public TypeSpec generate() {
        TypeSpec.Builder builder = TypeSpec.enumBuilder(className)
                .addModifiers(Modifier.PUBLIC)
                .addJavadoc(javadoc())
                .addAnnotations(annotations());
        constants.forEach(c -> builder.addEnumConstant(c.getName(), c.generate()));
        return builder.build();
    }
}
