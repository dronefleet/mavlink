package io.dronefleet.mavlink.generator;

import com.squareup.javapoet.*;

import javax.lang.model.element.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PackageGenerator {

    private static final ClassName MAVLINK_DIALECT = ClassName.get(
            "io.dronefleet.mavlink",
            "MavlinkDialect");

    private final String xmlName;
    private final String packageName;
    private final List<PackageGenerator> dependencies;
    private final List<EnumGenerator> enums;
    private final List<MessageGenerator> messages;

    public PackageGenerator(
            String xmlName,
            String packageName,
            List<PackageGenerator> dependencies,
            List<EnumGenerator> enums,
            List<MessageGenerator> messages) {
        this.xmlName = xmlName;
        this.packageName = packageName;
        this.dependencies = dependencies;
        this.enums = enums;
        this.messages = messages;
    }

    public String dialectName() {
        return xmlName.substring(0, xmlName.lastIndexOf('.')).toLowerCase();
    }

    public ClassName dialectClassName() {
        return ClassName.get(packageName, toUpperCamelCase(dialectName()) + "Dialect");
    }

    public List<EnumGenerator> getEnumsIncludingDependencies() {
        return Stream.concat(
                enums.stream(),
                dependencies.stream()
                        .map(pg -> pg.enums)
                        .flatMap(List::stream))
                .collect(Collectors.toList());
    }

    public Optional<EnumGenerator> resolveEnum(String name) {
        return getEnumsIncludingDependencies().stream()
                .filter(e -> name.equals(e.getName()))
                .findFirst();
    }

    public List<MessageGenerator> getMessagesIncludingDependencies() {
        return Stream.concat(
                messages.stream(),
                dependencies.stream()
                        .map(pg -> pg.messages)
                        .flatMap(List::stream))
                .collect(Collectors.toList());
    }

    public Optional<MessageGenerator> resolveMessage(String name) {
        return getMessagesIncludingDependencies().stream()
                .filter(m -> name.equals(m.getName()))
                .findFirst();
    }

    public ClassName resolve(String name) {
        return resolveEnum(name)
                .map(EnumGenerator::getClassName)
                .orElseGet(() -> resolveMessage(name)
                        .map(MessageGenerator::getClassName)
                        .orElse(null));
    }

    public ClassName getTypeName(String name) {
        return ClassName.get(packageName, toUpperCamelCase(name));
    }

    public String getFieldName(String name) {
        return toCamelCase(name);
    }

    public void addEnum(EnumGenerator enumGenerator) {
        enums.add(enumGenerator);
    }

    public void addMessage(MessageGenerator messageGenerator) {
        messages.add(messageGenerator);
    }

    public String processJavadoc(String description) {
        if (description == null) {
            description = "";
        }
        Matcher matcher = Pattern.compile("([A-Z_]+)").matcher(
                wordWrap(description, 80));
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            String name = matcher.group(1);
            ClassName className = resolve(name);

            if (className != null) {
                matcher.appendReplacement(sb, String.format(
                        "{@link %s %s}",
                        className.toString(),
                        name));
            }
        }
        matcher.appendTail(sb);
        sb.append("\n");
        return sb.toString();
    }

    public String getXmlName() {
        return xmlName;
    }

    public TypeSpec generateDialect() {
        String messageId = "messageId";
        CodeBlock.Builder supportsCode = CodeBlock.builder()
                .beginControlFlow("switch ($N)", messageId);
        messages.stream()
                .map(MessageGenerator::getId)
                .forEach(id -> supportsCode.add("case $L:\n", id));
        supportsCode.addStatement("$>return true$<");
        supportsCode.endControlFlow();
        supportsCode.addStatement("return false");

        CodeBlock.Builder resolveCode = CodeBlock.builder()
                .beginControlFlow("switch ($N)", messageId);
        messages.forEach(m -> resolveCode.addStatement("case $L: return $T.class",
                m.getId(), m.getClassName()));
        resolveCode.endControlFlow();
        resolveCode.addStatement("throw new $T(getClass().getSimpleName() + $S + $N)",
                IllegalArgumentException.class,
                " does not support message of ID ",
                messageId);

        CodeBlock.Builder dependenciesInitializer = CodeBlock.builder();
        if (dependencies.size() == 0) {
            dependenciesInitializer.add("$T.emptyList()", Collections.class);
        } else {
            dependenciesInitializer.add("$T.asList$>$>", Arrays.class);
            dependenciesInitializer.add(
                    dependencies.stream()
                            .map(pd -> CodeBlock.builder()
                                    .add("new $T()", pd.dialectClassName())
                                    .build())
                            .collect(CodeBlock.joining(",\n", "(\n", ")")));
            dependenciesInitializer.add("$<$<");
        }

        return TypeSpec.classBuilder(dialectClassName())
                .addModifiers(Modifier.FINAL, Modifier.PUBLIC)
                .addSuperinterface(MAVLINK_DIALECT)
                .addField(FieldSpec.builder(
                        ParameterizedTypeName.get(
                                ClassName.get(List.class), MAVLINK_DIALECT),
                        "dependencies",
                        Modifier.PRIVATE, Modifier.FINAL)
                        .addJavadoc("A list of dialects that this dialect depends on.\n")
                        .initializer(dependenciesInitializer.build())
                        .build())
                .addMethod(MethodSpec.methodBuilder("name")
                        .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                        .addJavadoc("{@inheritDoc}\n")
                        .addAnnotation(Override.class)
                        .addStatement("return $S", dialectName())
                        .returns(String.class)
                        .build())
                .addMethod(MethodSpec.methodBuilder("supports")
                        .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                        .addJavadoc("{@inheritDoc}\n")
                        .addAnnotation(Override.class)
                        .addParameter(int.class, messageId)
                        .addCode(supportsCode.build())
                        .returns(boolean.class)
                        .build())
                .addMethod(MethodSpec.methodBuilder("resolve")
                        .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                        .addJavadoc("{@inheritDoc}\n")
                        .addAnnotation(Override.class)
                        .addParameter(int.class, messageId)
                        .addCode(resolveCode.build())
                        .returns(Class.class)
                        .build())
                .build();
    }

    public List<JavaFile> generate() {

        return Stream.concat(
                Stream.concat(
                        messages.stream().map(MessageGenerator::generate),
                        enums.stream().map(EnumGenerator::generate)),
                Stream.of(generateDialect()))
                .map(ts -> JavaFile.builder(packageName, ts)
                        .indent("    ")
                        .build())
                .collect(Collectors.toList());
    }

    private String wordWrap(String text, int max) {
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
}
