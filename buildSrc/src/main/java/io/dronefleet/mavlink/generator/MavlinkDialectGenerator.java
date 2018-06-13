package io.dronefleet.mavlink.generator;

import com.squareup.javapoet.*;
import io.dronefleet.mavlink.generator.definitions.MavlinkDefinitionDeserializer;
import io.dronefleet.mavlink.generator.definitions.model.*;

import javax.lang.model.element.Modifier;
import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MavlinkDialectGenerator {

    private static final ClassName ENUM_FLAG_SET = ClassName.get("io.dronefleet.mavlink.util", "EnumFlagSet");
    private static final ClassName MAVLINK_ENUM = ClassName.get("io.dronefleet.mavlink.annotations", "MavlinkEnum");
    private static final ClassName MAVLINK_ENUM_ENTRY = ClassName.get("io.dronefleet.mavlink.annotations", "MavlinkEnumEntry");
    private static final ClassName MAVLINK_MESSAGE = ClassName.get("io.dronefleet.mavlink.annotations", "MavlinkMessage");
    private static final ClassName MAVLINK_MESSAGE_FIELD = ClassName.get("io.dronefleet.mavlink.annotations", "MavlinkMessageField");

    private class PackageSources {
        private final List<PackageSources> dependencies;
        private final String packageName;
        private final Map<String, EnumSource> enumSources;
        private final Map<String, MessageSource> messageSources;

        public PackageSources(List<PackageSources> dependencies, String packageName) {
            this.dependencies = dependencies;
            this.packageName = packageName;
            enumSources = new HashMap<>();
            messageSources = new HashMap<>();
        }

        public EnumSource resolveEnum(String name) {
            if (enumSources.containsKey(name)) {
                return enumSources.get(name);
            }
            return dependencies.stream()
                    .map(ps -> ps.resolveEnum(name))
                    .filter(Objects::nonNull)
                    .findFirst()
                    .orElse(null);
        }

        public MessageSource resolveMessage(String name) {
            if (messageSources.containsKey(name)) {
                return messageSources.get(name);
            }
            return dependencies.stream()
                    .map(ps -> ps.resolveMessage(name))
                    .filter(Objects::nonNull)
                    .findFirst()
                    .orElse(null);
        }

        public List<JavaFile> generate() {
            return Stream.concat(enumSources.values().stream()
                            .map(EnumSource::getBuilder)
                            .map(TypeSpec.Builder::build),
                    messageSources.values().stream()
                        .map(MessageSource::getTypeSpec))
                    .map(ts -> JavaFile.builder(packageName, ts)
                            .build())
                    .collect(Collectors.toList());
        }
    }

    private class EnumSource {
        private final ClassName className;
        private final TypeSpec.Builder builder;
        private int maxValue;

        public EnumSource(ClassName className, TypeSpec.Builder builder) {
            this.className = className;
            this.builder = builder;
        }

        public void addEntry(MavlinkEntryDef entry) {
            addEntry(entry, null);
        }

        public void addEntry(MavlinkEntryDef entry, String dependentPackage) {
            int value = entry.getValue() == null ? maxValue + 1 : entry.getValue();
            builder.addEnumConstant(
                    entry.getName(),
                    TypeSpec.anonymousClassBuilder("")
                            .addJavadoc(describeEntry(entry)
                                    + (dependentPackage != null
                                    ? "<b>added by " + dependentPackage + " package</b>\n" : ""))
                            .addAnnotation(AnnotationSpec.builder(MAVLINK_ENUM_ENTRY)
                                    .addMember("value", "$L", value)
                                    .build())
                            .build());
            maxValue = Math.max(maxValue, value);
        }

        public TypeSpec.Builder getBuilder() {
            return builder;
        }
    }

    private class MessageSource {
        private final ClassName className;
        private final TypeSpec typeSpec;

        private MessageSource(ClassName className, TypeSpec typeSpec) {
            this.className = className;
            this.typeSpec = typeSpec;
        }
        public ClassName getClassName() {
            return className;
        }
        public TypeSpec getTypeSpec() {
            return typeSpec;
        }
    }

    private final String basePackage;
    private final List<File> xmlResources;

    public MavlinkDialectGenerator(
            String basePackage,
            List<File> xmlResources) {
        this.basePackage = basePackage;
        this.xmlResources = xmlResources;
    }

    public List<JavaFile> generate() {
        MavlinkDefinitionDeserializer deserializer = new MavlinkDefinitionDeserializer();
        Map<String, PackageSources> packageSources = new HashMap<>();
        Map<String, MavlinkDef> packages = xmlResources.stream()
                .map(file -> {
                    try (InputStream is = new FileInputStream(file)) {
                        return deserializer.deserialize(is, new File(file.getPath()).getName());
                    } catch (IOException e) {
                        throw new IllegalStateException("unable to open stream for URL " + file.toString(), e);
                    } catch (XMLStreamException e) {
                        throw new IllegalStateException("malformed XML for URL " + file.toString(), e);
                    }
                })
                .collect(Collectors.toMap(MavlinkDef::getName, Function.identity()));

        while (packages.size() > 0) {
            MavlinkDef def = getNext(
                    packages.values().iterator().next(),
                    packages,
                    packageSources::containsKey);

            packageSources.put(def.getName(), generate(def, def.getIncludes().stream()
                    .map(packageSources::get)
                    .collect(Collectors.toList())));

            packages.remove(def.getName());
        }

        return packageSources.values()
                .stream()
                .map(PackageSources::generate)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    private MavlinkDef getNext(MavlinkDef def, Map<String, MavlinkDef> allDefs, Predicate<String> computed) {
        for (String included : def.getIncludes()) {
            if (!computed.test(included)) {
                return getNext(allDefs.get(included), allDefs, computed);
            }
        }
        return def;
    }

    public PackageSources generate(MavlinkDef def, List<PackageSources> dependencies) {
        PackageSources sources = new PackageSources(
                dependencies,
                basePackage + "." + def.getName().substring(0, def.getName().lastIndexOf('.')).toLowerCase());

        def.getEnums().forEach(enumDef -> generateEnum(
                enumDef,
                sources));

        def.getMessages().forEach(messageDef -> generateMessage(
                messageDef,
                sources));

        return sources;
    }

    public void generateEnum(MavlinkEnumDef enumDef, PackageSources sources) {
        EnumSource enumSource = sources.resolveEnum(enumDef.getName());

        if (enumSource == null) {
            ClassName className = ClassName.get(sources.packageName, toUpperCamelCase(enumDef.getName()));
            enumSource = new EnumSource(className, TypeSpec.enumBuilder(className)
                    .addJavadoc(processJavadoc(wordWrap(enumDef.getDescription()), sources) + "\n")
                    .addModifiers(Modifier.PUBLIC)
                    .addAnnotation(MAVLINK_ENUM));

            sources.enumSources.put(enumDef.getName(), enumSource);
            enumDef.getEntries().forEach(enumSource::addEntry);
        } else {
            final EnumSource finalEnumSource = enumSource;
            enumDef.getEntries().forEach(e -> finalEnumSource.addEntry(e, sources.packageName));
        }
    }

    public void generateMessage(MavlinkMessageDef messageDef, PackageSources sources) {
        ClassName messageClassName = ClassName.get(
                sources.packageName,
                toUpperCamelCase(messageDef.getName()));

        ClassName builderClassName = ClassName.get(
                messageClassName.packageName(),
                messageClassName.simpleName(),
                "Builder");

        TypeSpec.Builder builder = TypeSpec.classBuilder(builderClassName)
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .addMethod(MethodSpec.constructorBuilder()
                        .addModifiers(Modifier.PRIVATE)
                        .build());

        MethodSpec.Builder ctor = MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PRIVATE);

        List<FieldSpec> messageFields = new ArrayList<>();
        List<MethodSpec> messageGetters = new ArrayList<>();

        CrcX25 crc = new CrcX25();
        crc.accumulate(messageDef.getName() + " ");
        messageDef.getFields()
                .stream()
                .sorted()
                .peek(fd -> {
                    if (!fd.isExtension()) {
                        crc.accumulate(fd.getType().getConvertedType() + " ");
                        crc.accumulate(fd.getName() + " ");
                        if (fd.getType().isArray()) {
                            crc.accumulate(fd.getType().getArrayLength());
                        }
                    }
                })
                .sorted(Comparator.comparing(MavlinkFieldDef::getIndex))
                .forEach(fd -> {
                    TypeName fieldType = getFieldType(fd, sources);
                    String fieldName = toCamelCase(fd.getName());
                    String fieldDescription = processJavadoc(wordWrap(fd.getDescription()), sources) + "\n";
                    AnnotationSpec fieldAnnotation = generateFieldAnnotation(fd);

                    builder.addField(fieldType, fieldName, Modifier.PRIVATE);
                    builder.addMethod(MethodSpec.methodBuilder(fieldName)
                            .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                            .addJavadoc(fieldDescription)
                            .addAnnotation(fieldAnnotation)
                            .addParameter(fieldType, fieldName)
                            .addStatement("this.$L = $L", fieldName, fieldName)
                            .addStatement("return this")
                            .returns(builderClassName)
                            .build());

                    ctor.addParameter(fieldType, fieldName);
                    ctor.addStatement("this.$L = $L", fieldName, fieldName);

                    messageFields.add(FieldSpec.builder(fieldType, fieldName, Modifier.PRIVATE, Modifier.FINAL)
                            .addJavadoc(fieldDescription)
                            .build());

                    messageGetters.add(MethodSpec.methodBuilder(fieldName)
                            .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                            .addJavadoc(fieldDescription)
                            .addAnnotation(fieldAnnotation)
                            .addStatement("return $L", fieldName)
                            .returns(fieldType)
                            .build());
                });

        builder.addMethod(MethodSpec.methodBuilder("build")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addStatement("return new $T($L)", messageClassName, messageDef.getFields().stream()
                        .map(MavlinkFieldDef::getName)
                        .map(this::toCamelCase)
                        .collect(Collectors.joining(", ")))
                .returns(messageClassName)
                .build());

        TypeSpec.Builder message = TypeSpec.classBuilder(messageClassName)
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addJavadoc(processJavadoc(wordWrap(messageDef.getDescription()) + "\n", sources))
                .addAnnotation(AnnotationSpec.builder(MAVLINK_MESSAGE)
                        .addMember("id", "$L", messageDef.getId())
                        .addMember("crc", "$L", crc.get() & 0xff)
                        .build())
                .addMethod(MethodSpec.methodBuilder("builder")
                        .addModifiers(Modifier.STATIC, Modifier.PUBLIC)
                        .addStatement("return new $T()", builderClassName)
                        .returns(builderClassName)
                        .build())
                .addType(builder.build());

        messageFields.forEach(message::addField);
        message.addMethod(ctor.build());
        messageGetters.forEach(message::addMethod);

        sources.messageSources.put(messageDef.getName(), new MessageSource(messageClassName, message.build()));
    }

    private AnnotationSpec generateFieldAnnotation(MavlinkFieldDef fieldDef) {
        AnnotationSpec.Builder builder = AnnotationSpec.builder(MAVLINK_MESSAGE_FIELD)
                .addMember("position", "$L", fieldDef.getIndex())
                .addMember("length", "$L", fieldDef.getType().getTypeLength());

        if (fieldDef.getType().isArray()) {
            builder.addMember("arraySize", "$L", fieldDef.getType().getArrayLength());
        }

        if (fieldDef.isExtension()) {
            builder.addMember("extension", "$L", true);
        }

        return builder.build();
    }

    private TypeName getFieldType(MavlinkFieldDef fieldDef, PackageSources sources) {
        if (fieldDef.getEnumName() != null) {
            ClassName enumType = Optional.ofNullable(sources.resolveEnum(fieldDef.getEnumName()))
                    .map(e -> e.className)
                    .orElseThrow(() -> new IllegalStateException("unable to find enum " + fieldDef.getEnumName()));
            if (enumType != null) {
                if ("bitmask".equals(fieldDef.getDisplay())) {
                    return ParameterizedTypeName.get(ENUM_FLAG_SET, enumType);
                } else {
                    return enumType;
                }
            } else {
                throw new IllegalStateException("unable to find enum " + fieldDef.getEnumName());
            }
        }

        MavlinkTypeDef typeDef = fieldDef.getType();
        if (typeDef.isArray()) {
            if ("char".equals(typeDef.getConvertedType())) {
                return ClassName.get(String.class);
            }
            return ParameterizedTypeName.get(ClassName.get(List.class), getPrimitiveType(typeDef.getConvertedType()).box());
        }
        return getPrimitiveType(typeDef.getConvertedType());
    }

    private TypeName getPrimitiveType(String type) {
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

    public String describeEntry(MavlinkEntryDef entryDef) {
        return entryDef.getDescription()
                + (entryDef.getParams().size() > 0 ? "\n" : "")
                + entryDef.getParams().stream()
                .map(p -> "param[" + p.getIndex() + "]: " + p.getDescription())
                .collect(Collectors.joining("\n", "", "\n"));
    }

    private String toUpperCamelCase(String upperUnderscore) {
        return Arrays.stream(upperUnderscore.split("_"))
                .map(String::toLowerCase)
                .map(s -> Character.toUpperCase(s.charAt(0)) + s.substring(1))
                .collect(Collectors.joining(""));

    }

    private String toCamelCase(String underscored) {
        String upperCamelCase = toUpperCamelCase(underscored);
        return Character.toLowerCase(upperCamelCase.charAt(0)) + upperCamelCase.substring(1);
    }

    public String processJavadoc(String text, PackageSources sources) {
        if (text == null) {
            return null;
        }
        Matcher matcher = Pattern.compile("([A-Z_]+)").matcher(text);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            ClassName cn = Optional.ofNullable(sources.resolveEnum(matcher.group(1)))
                    .map(es -> es.className)
                    .orElse(Optional.ofNullable(sources.resolveMessage(matcher.group(1)))
                            .map(ms -> ms.className)
                            .orElse(null));

            if (cn != null) {
                matcher.appendReplacement(sb, String.format(
                        "{@link %s %s}",
                        cn.toString(),
                        cn.simpleName()));
            }
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public String wordWrap(String text) {
        return wordWrap(text, 80);
    }

    private String wordWrap(String text, int max) {
        if (text == null) return null;
        AtomicInteger line = new AtomicInteger(0);
        StringBuilder sb = new StringBuilder();
        Arrays.stream(text.split("\\s+"))
                .forEach(word -> {
                    int next = line.get() + word.length();
                    if (next > max) {
                        sb.append("\n");
                        line.set(word.length());
                    } else {
                        line.set(next);
                    }
                    sb.append(word + " ");
                });
        return sb.toString();
    }
}
