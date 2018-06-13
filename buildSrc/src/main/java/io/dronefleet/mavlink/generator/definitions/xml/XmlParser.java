package io.dronefleet.mavlink.generator.definitions.xml;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class XmlParser {

    private static class Scope {
        private String name;
        private Map<String,String> attributes;
        private String content;
        private List<XmlElement> children = new ArrayList<>();
    }

    public XmlElement parse(XMLStreamReader reader) throws XMLStreamException {
        Stack<Scope> stack = new Stack<>();
        StringBuilder textSb = new StringBuilder();
        Scope rootScope = new Scope();
        Scope current = rootScope;

        while (reader.hasNext()) {
            switch (reader.next()) {
                case XMLStreamReader.START_ELEMENT:
                    stack.push(current);
                    current = new Scope();
                    current.name = reader.getLocalName();
                    current.attributes = IntStream.range(0, reader.getAttributeCount())
                            .boxed()
                            .collect(Collectors.toMap(reader::getAttributeLocalName, reader::getAttributeValue));
                    break;

                case XMLStreamConstants.SPACE:
                case XMLStreamConstants.CDATA:
                case XMLStreamConstants.CHARACTERS:
                    textSb.append(new String(reader.getTextCharacters(), reader.getTextStart(), reader.getTextLength()));
                    break;

                case XMLStreamReader.END_ELEMENT:
                    String text = textSb.toString().trim();
                    if (text.length() > 0) {
                        current.content = text;
                    }
                    textSb.delete(0, textSb.length());
                    Scope parent = stack.pop();
                    parent.children.add(new XmlElement(
                            parent.children.size(),
                            current.name,
                            current.attributes,
                            current.content,
                            current.children));
                    current = parent;
            }
        }

        if (rootScope.children.size() > 1) {
            throw new IllegalStateException("More than a single document element present in XML document");
        } else if (rootScope.children.size() < 1) {
            throw new IllegalStateException("Empty XML document");
        }

        return rootScope.children.get(0);
    }
}
