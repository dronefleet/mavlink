package io.dronefleet.mavlink.generator.definitions;

import io.dronefleet.mavlink.generator.definitions.model.*;
import io.dronefleet.mavlink.generator.definitions.xml.XmlElement;
import io.dronefleet.mavlink.generator.definitions.xml.XmlParser;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;
import java.util.Optional;
import java.util.stream.Collectors;

public class MavlinkDefinitionDeserializer {

    public MavlinkDef deserialize(InputStream in, String name) throws XMLStreamException {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        XMLStreamReader reader = inputFactory.createXMLStreamReader(in);
        XmlElement mavlink = new XmlParser().parse(reader);

        if (!"mavlink".equals(mavlink.getName())) {
            throw new IllegalStateException("Not a mavlink definition schema");
        }

        return new MavlinkDef(
                mavlink.elements("include")
                        .stream()
                        .map(XmlElement::getContent)
                        .collect(Collectors.toList()),
                name,
                Integer.parseInt(mavlink.content("version", "-1")),
                Integer.parseInt(mavlink.content("dialect", "-1")),
                mavlink.elements("enums/enum")
                        .stream()
                        .map(enumeration -> new MavlinkEnumDef(
                                enumeration.attr("name"),
                                enumeration.content("description"),
                                enumeration.elements("entry")
                                        .stream()
                                        .map(entry -> new MavlinkEntryDef(
                                                entry.attr("value") != null ? Long.decode(entry.attr("value")).intValue() : null,
                                                entry.attr("name"),
                                                entry.content("description"),
                                                entry.elements("param")
                                                        .stream()
                                                        .map(param -> new MavlinkParamDef(
                                                                Integer.parseInt(param.attr("index")),
                                                                param.getContent()))
                                                        .collect(Collectors.toList()),
                                                entry.elements("deprecated")
                                                        .stream()
                                                        .findFirst()
                                                        .map(this::deserializeDeprecation)
                                                        .orElse(null)))
                                        .collect(Collectors.toList()),
                                enumeration.elements("deprecated")
                                        .stream()
                                        .findFirst()
                                        .map(this::deserializeDeprecation)
                                        .orElse(null)))
                        .collect(Collectors.toList()),
                mavlink.elements("messages/message")
                        .stream()
                        .map(message -> {
                            int extensionsIndex = Optional.ofNullable(message.element("extensions"))
                                    .map(XmlElement::getIndex)
                                    .orElse(Integer.MAX_VALUE);
                            return new MavlinkMessageDef(
                                    Integer.parseInt(message.attr("id")),
                                    message.attr("name"),
                                    message.content("description"),
                                    message.elements("field")
                                            .stream()
                                            .map(field -> new MavlinkFieldDef(
                                                    field.getIndex(),
                                                    MavlinkTypeDef.fromXmlValue(field.attr("type")),
                                                    field.attr("name"),
                                                    field.attr("enum"),
                                                    field.attr("display"),
                                                    field.attr("units"),
                                                    field.attr("print_format"),
                                                    field.getIndex() > extensionsIndex,
                                                    field.getContent()))
                                            .collect(Collectors.toList()),
                                    message.elements("deprecated")
                                            .stream()
                                            .findFirst()
                                            .map(this::deserializeDeprecation)
                                            .orElse(null));
                        })
                        .collect(Collectors.toList()));
    }


    private MavlinkDeprecationDef deserializeDeprecation(XmlElement element) {
        return new MavlinkDeprecationDef(
                element.attr("since", null),
                element.attr("replaced_by", null),
                element.getContent());
    }
}
