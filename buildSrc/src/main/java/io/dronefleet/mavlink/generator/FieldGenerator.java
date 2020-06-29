package io.dronefleet.mavlink.generator;

import com.squareup.javapoet.*;

import javax.lang.model.element.Modifier;
import java.math.BigInteger;
import java.util.*;

public class FieldGenerator implements Comparable<FieldGenerator> {
    private static final ClassName MAVLINK_MESSAGE_FIELD = ClassName.get(
            "io.dronefleet.mavlink.annotations",
            "MavlinkFieldInfo");
    private static final ClassName ENUM_VALUE = ClassName.get(
            "io.dronefleet.mavlink.util",
            "EnumValue");

    private final PackageGenerator parentPackage;
    private final String name;
    private final String nameCamelCase;
    private final String description;
    private final String type;
    private final String enumName;
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

    public boolean isExtension() {
        return extension;
    }

    public TypeName javaType() {
        if (enumName != null) {
            return enumValueType();
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

        if (array) {
            builder.addMember("arraySize", "$L", arraySize);
        }

        if (enumName != null) {
            builder.addMember("enumType", "$T.class", enumType());
        }

        if (signed()) {
            builder.addMember("signed", "$L", true);
        }

        if (extension) {
            builder.addMember("extension", "$L", true);
        }

        if (description != null && !description.trim().isEmpty()) {
            builder.addMember("description", "$S", description);
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

    public List<MethodSpec> generateConvenienceSetters(ClassName className) {
        if (enumName != null) {
            return Arrays.asList(
                    MethodSpec.methodBuilder(nameCamelCase)
                            .addJavadoc(javadoc())
                            .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                            .addParameter(enumType(), "entry")
                            .addStatement("return $1N($2T.of($3N))", nameCamelCase, ENUM_VALUE, "entry")
                            .returns(className)
                            .build(),

                    MethodSpec.methodBuilder(nameCamelCase)
                            .varargs(true)
                            .addJavadoc(javadoc())
                            .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                            .addParameter(Enum[].class, "flags")
                            .addStatement("return $1N($2T.create(flags))", nameCamelCase, ENUM_VALUE)
                            .returns(className)
                            .build(),

                    MethodSpec.methodBuilder(nameCamelCase)
                            .addJavadoc(javadoc())
                            .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                            .addParameter(ParameterizedTypeName.get(Collection.class, Enum.class), "flags")
                            .addStatement("return $1N($2T.create(flags))", nameCamelCase, ENUM_VALUE)
                            .returns(className)
                            .build()
            );
        }
        return Collections.emptyList();
    }

    public ParameterSpec generateParameter() {
        return ParameterSpec.builder(javaType(), nameCamelCase).build();
    }

    public void addEqualsStatement(CodeBlock.Builder codeBuilder, String other) {
        codeBuilder.addStatement("if (!$1T.deepEquals($2N, $3N.$2N)) return false",
                Objects.class,
                getNameCamelCase(),
                other);
    }

    public void addHashCodeStatement(CodeBlock.Builder codeBuilder, String result) {
        codeBuilder.addStatement("$1N = 31 * $1N + $2T.hashCode($3N)",
                result,
                Objects.class,
                getNameCamelCase());
    }

    private boolean signed() {
        return type.startsWith("int");
    }

    private TypeName enumType() {
        return parentPackage.resolveEnum(enumName)
                .map(EnumGenerator::getClassName)
                .orElseThrow(() -> new IllegalStateException("unable to find enum " + enumName
                        + " while generating field " + name));
    }

    private TypeName enumValueType() {
        return ParameterizedTypeName.get(ENUM_VALUE, enumType());
    }

    private final TypeName arrayType() {
        if ("char".equals(type)) {
            return ClassName.get(String.class);
        }
        if ("uint8_t".equals(type) || "int8_t".equals(type)) {
            return TypeName.get(byte[].class);
        }
        if ("uint16_t".equals(type) || "int16_t".equals(type)) {
            return TypeName.get(short[].class);
        }
        if ("uint32_t".equals(type) || "int32_t".equals(type)) {
            return TypeName.get(int[].class);
        }
        if ("uint64_t".equals(type) || "int64_t".equals(type)) {
            return TypeName.get(long[].class);
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
