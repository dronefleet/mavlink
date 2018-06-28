package io.dronefleet.mavlink.generator;

import com.squareup.javapoet.*;
import io.dronefleet.mavlink.generator.definitions.model.MavlinkTypeDef;

import javax.lang.model.element.Modifier;
import java.math.BigInteger;
import java.util.List;

public class FieldGenerator implements Comparable<FieldGenerator> {
    private static final ClassName MAVLINK_MESSAGE_FIELD = ClassName.get(
            "io.dronefleet.mavlink.annotations",
            "MavlinkFieldInfo");
    private static final ClassName ENUM_FLAG_SET = ClassName.get(
            "io.dronefleet.mavlink.util",
            "EnumFlagSet");

    private final PackageGenerator parentPackage;
    private final String name;
    private final String nameCamelCase;
    private final String description;
    private final String type;
    private final String enumName;
    private final String display;
    private final int index;
    private final int unitSize;
    private final boolean array;
    private final int arraySize;
    private final boolean extension;

    public FieldGenerator(
            PackageGenerator parentPackage,
            String name,
            String nameCamelCase,
            String description,
            String type,
            String enumName,
            String display,
            int index,
            int unitSize,
            boolean array,
            int arraySize,
            boolean extension) {
        this.parentPackage = parentPackage;
        this.name = name;
        this.nameCamelCase = nameCamelCase;
        this.description = description;
        this.type = type;
        this.enumName = enumName;
        this.display = display;
        this.index = index;
        this.unitSize = unitSize;
        this.array = array;
        this.arraySize = arraySize;
        this.extension = extension;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean isArray() {
        return array;
    }

    public int getArraySize() {
        return arraySize;
    }

    public TypeName javaType() {
        if (enumName != null) {
            return enumType();
        }
        if (array) {
            return arrayType();
        }
        return primitiveType();
    }

    public String getNameCamelCase() {
        return nameCamelCase;
    }

    public String javadoc() {
        return parentPackage.processJavadoc(description);
    }

    public AnnotationSpec annotation() {
        AnnotationSpec.Builder builder = AnnotationSpec.builder(MAVLINK_MESSAGE_FIELD)
                .addMember("position", "$L", index)
                .addMember("unitSize", "$L", unitSize);

        if(array) {
            builder.addMember("arraySize", "$L", arraySize);
        }

        if (signed()) {
            builder.addMember("signed", "$L", true);
        }

        if (extension) {
            builder.addMember("extension", "$L", true);
        }

        return builder.build();
    }

    public FieldSpec generateImmutableMember() {
        return FieldSpec.builder(javaType(), nameCamelCase, Modifier.PRIVATE, Modifier.FINAL).build();
    }

    public FieldSpec generateMutableMember() {
        return FieldSpec.builder(javaType(), nameCamelCase, Modifier.PRIVATE).build();
    }

    public MethodSpec generateGetter() {
        return MethodSpec.methodBuilder(nameCamelCase)
                .addJavadoc(javadoc())
                .addAnnotation(annotation())
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addStatement("return this.$N", nameCamelCase)
                .returns(javaType())
                .build();
    }

    public MethodSpec generateSetter(ClassName className) {
        return MethodSpec.methodBuilder(nameCamelCase)
                .addJavadoc(javadoc())
                .addAnnotation(annotation())
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addParameter(generateParameter())
                .addStatement("this.$1N = $1N", nameCamelCase)
                .addStatement("return this")
                .returns(className)
                .build();
    }

    public ParameterSpec generateParameter() {
        return ParameterSpec.builder(javaType(), nameCamelCase).build();
    }

    private boolean signed() {
        return type.startsWith("int");
    }

    private TypeName enumType() {
        ClassName enumType = parentPackage.resolveEnum(enumName)
                .map(EnumGenerator::getClassName)
                .orElseThrow(() -> new IllegalStateException("unable to find enum " + enumName));

        if (enumType != null) {
            if ("bitmask".equals(display)) {
                return ParameterizedTypeName.get(ENUM_FLAG_SET, enumType);
            } else {
                return enumType;
            }
        } else {
            throw new IllegalStateException("unable to find enum " + enumName);
        }
    }

    private final TypeName arrayType() {
        if ("char".equals(type)) {
            return ClassName.get(String.class);
        }
        if ("uint8_t".equals(type)) {
            return TypeName.get(byte[].class);
        }
        return ParameterizedTypeName.get(ClassName.get(List.class), primitiveType().box());
    }

    private TypeName primitiveType() {
        switch (type) {
            case "uint8_t":
            case "int8_t":
            case "uint16_t":
            case "int16_t":
            case "int32_t":
                return TypeName.INT;

            case "uint32_t":
            case "int64_t":
                return TypeName.LONG;

            case "uint64_t":
                return ClassName.get(BigInteger.class);

            case "float":
                return TypeName.FLOAT;

            case "double":
                return TypeName.DOUBLE;
        }

        return TypeName.INT;
    }

    @Override
    public int compareTo(FieldGenerator other) {
        if (extension && !other.extension) {
            return 1;
        }
        if (!extension && other.extension) {
            return -1;
        }

        if (!this.extension && this.unitSize != other.unitSize) {
            return other.unitSize - unitSize;
        }

        return index - other.index;
    }
}
