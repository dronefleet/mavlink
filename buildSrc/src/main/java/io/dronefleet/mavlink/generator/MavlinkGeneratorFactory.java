package io.dronefleet.mavlink.generator;

import io.dronefleet.mavlink.generator.definitions.MavlinkDefinitionDeserializer;
import io.dronefleet.mavlink.generator.definitions.model.*;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class MavlinkGeneratorFactory {

    private final String basePackage;
    private final List<File> xmlResources;

    public MavlinkGeneratorFactory(String basePackage, List<File> xmlResources) {
        this.basePackage = basePackage;
        this.xmlResources = xmlResources;
    }

    public MavlinkGenerator newGenerator() {
        MavlinkDefinitionDeserializer deserializer = new MavlinkDefinitionDeserializer();
        List<MavlinkDef> mavlinkDefs = xmlResources.stream()
                .map(f -> loadDefinition(f, deserializer))
                .collect(Collectors.toList());
        mavlinkDefs = sortDefinitions(mavlinkDefs);
        List<PackageGenerator> packageGenerators = new ArrayList<>(mavlinkDefs.size());
        mavlinkDefs.stream()
                .map(md -> visitPackage(md, packageGenerators))
                .forEach(packageGenerators::add);
        return new MavlinkGenerator(packageGenerators);
    }

    private PackageGenerator visitPackage(MavlinkDef packageDef, List<PackageGenerator> packageGenerators) {
        String xmlName = packageDef.getName();
        String packageName = basePackage + "." + xmlName.substring(0, xmlName.lastIndexOf('.')).toLowerCase();
        List<PackageGenerator> dependencies = packageGenerators.stream()
                .filter(pg -> packageDef.getIncludes().contains(pg.getXmlName()))
                .collect(Collectors.toList());

        PackageGenerator packageGenerator = new PackageGenerator(
                xmlName,
                packageName,
                dependencies,
                new ArrayList<>(),
                new ArrayList<>());

        packageDef.getEnums()
                .forEach(ed -> visitEnum(ed, packageGenerator));

        packageDef.getMessages()
                .stream()
                .map(md -> visitMessage(md, packageGenerator))
                .forEach(packageGenerator::addMessage);

        return packageGenerator;
    }

    private MessageGenerator visitMessage(MavlinkMessageDef messageDef, PackageGenerator packageGenerator) {
        MessageGenerator messageGenerator = new MessageGenerator(
                packageGenerator,
                messageDef.getId(),
                messageDef.getName(),
                packageGenerator.getTypeName(messageDef.getName()),
                messageDef.getDescription(),
                new ArrayList<>(messageDef.getFields().size()),
                visitDeprecation(messageDef.getDeprecation()),
                messageDef.isWorkInProgress());

        messageDef.getFields()
                .stream()
                .map(fd -> visitMessageField(fd, packageGenerator))
                .forEach(messageGenerator::addField);

        return messageGenerator;
    }

    private FieldGenerator visitMessageField(
            MavlinkFieldDef fieldDef,
            PackageGenerator packageGenerator) {
        return new FieldGenerator(
                packageGenerator,
                fieldDef.getName(),
                packageGenerator.getFieldName(fieldDef.getName()),
                fieldDef.getDescription(),
                fieldDef.getType().getConvertedType(),
                fieldDef.getEnumName(),
                fieldDef.getIndex(),
                fieldDef.getType().getTypeLength(),
                fieldDef.getType().isArray(),
                fieldDef.getType().getArrayLength(),
                fieldDef.isExtension());
    }

    private void visitEnum(MavlinkEnumDef enumDef, PackageGenerator packageGenerator) {
        EnumGenerator enumGenerator = packageGenerator.resolveEnum(enumDef.getName()).orElse(null);

        if (enumGenerator == null) {
            enumGenerator = new EnumGenerator(
                    packageGenerator,
                    enumDef.getName(),
                    packageGenerator.getTypeName(enumDef.getName()),
                    enumDef.getDescription(),
                    new ArrayList<>(enumDef.getEntries().size()),
                    visitDeprecation(enumDef.getDeprecation()));

            packageGenerator.addEnum(enumGenerator);
        }

        final EnumGenerator finalEnumGenerator = enumGenerator;
        enumDef.getEntries()
                .stream()
                .map(ed -> visitEnumEntry(ed, finalEnumGenerator, packageGenerator))
                .forEach(enumGenerator::addConstant);

    }

    private EnumConstantGenerator visitEnumEntry(
            MavlinkEntryDef entryDef,
            EnumGenerator enumGenerator,
            PackageGenerator packageGenerator) {
        int value = entryDef.getValue() == null ?
                enumGenerator.maxValue() + 1 :
                entryDef.getValue();

        EnumConstantGenerator constantGenerator = new EnumConstantGenerator(
                packageGenerator,
                entryDef.getName(),
                value,
                entryDef.getDescription(),
                new ArrayList<>(entryDef.getParams().size()),
                visitDeprecation(entryDef.getDeprecation()));

        entryDef.getParams()
                .stream()
                .map(pd -> visitEnumEntryParam(pd, packageGenerator))
                .forEach(constantGenerator::addParameter);

        return constantGenerator;
    }

    private EnumParameterGenerator visitEnumEntryParam(MavlinkParamDef paramDef, PackageGenerator packageGenerator) {
        return new EnumParameterGenerator(
                packageGenerator,
                paramDef.getIndex(),
                paramDef.getDescription());
    }

    private DeprecationGenerator visitDeprecation(
            MavlinkDeprecationDef deprecationDef) {
        if (deprecationDef == null) {
            return new DeprecationGenerator(false, "", "", "");
        }
        return new DeprecationGenerator(
                true,
                deprecationDef.getSince(),
                deprecationDef.getReplacedBy(),
                deprecationDef.getMessage());
    }


    private List<MavlinkDef> sortDefinitions(List<MavlinkDef> definitions) {
        List<MavlinkDef> sortedDefinitions = new ArrayList<>(definitions.size());
        definitions = new ArrayList<>(definitions);
        while (definitions.size() > 0) {
            MavlinkDef definition = nextDefinitionLeaf(new Stack<>(), definitions, sortedDefinitions, definitions.get(0));
            sortedDefinitions.add(definition);
            definitions.remove(definition);
        }
        return sortedDefinitions;
    }

    private MavlinkDef nextDefinitionLeaf(
            Stack<String> stack,
            List<MavlinkDef> work,
            List<MavlinkDef> sorted,
            MavlinkDef current) {
        if (stack.contains(current.getName())) {
            int lastCall = stack.lastIndexOf(current.getName());
            String cycle = stack.subList(lastCall, stack.size())
                    .stream()
                    .collect(Collectors.joining(" -> ", "", " -> " + current.getName()));
            throw new IllegalStateException(
                    "Cyclic dependencies for " + current.getName() + ", cycle is: \n" + cycle);
        }
        stack.add(current.getName());
        List<String> unmetDependencies = current.getIncludes()
                .stream()
                .filter(s -> sorted.stream()
                        .map(MavlinkDef::getName)
                        .filter(s::equals)
                        .count() == 0)
                .collect(Collectors.toList());
        if (unmetDependencies.size() > 0) {
            String dependencyName = unmetDependencies.get(0);
            MavlinkDef dependency = work.stream()
                    .filter(md -> dependencyName.equals(md.getName()))
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException(
                            current.getName() + " depends on " + dependencyName + " but such dialect does not exist."));
            return nextDefinitionLeaf(stack, work, sorted, dependency);
        }
        return current;
    }

    private MavlinkDef loadDefinition(File file, MavlinkDefinitionDeserializer deserializer) {
        try (InputStream is = new FileInputStream(file)) {
            return deserializer.deserialize(is, new File(file.getPath()).getName());
        } catch (IOException e) {
            throw new IllegalStateException("unable to open stream for URL " + file.toString(), e);
        } catch (XMLStreamException e) {
            throw new IllegalStateException("malformed XML for URL " + file.toString(), e);
        }
    }
}
