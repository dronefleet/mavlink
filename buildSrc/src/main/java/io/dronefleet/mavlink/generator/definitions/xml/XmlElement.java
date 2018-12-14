package io.dronefleet.mavlink.generator.definitions.xml;

import java.util.*;
import java.util.stream.Collectors;

public class XmlElement {
    private final int index;
    private final String name;
    private final Map<String, String> attributes;
    private final String content;
    private final List<XmlElement> children;

    public XmlElement(
            int index,
            String name,
            Map<String, String> attributes,
            String content,
            List<XmlElement> children) {
        this.index = index;
        this.name = name;
        this.attributes = attributes;
        this.content = content;
        this.children = children;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public String getContent() {
        return content;
    }

    public List<XmlElement> getChildren() {
        return children;
    }

    public String content(String xpath) {
        return content(xpath, null);
    }

    public String content(String xpath, String defaultValue) {
        return Optional.ofNullable(element(xpath))
                .map(XmlElement::getContent)
                .orElse(defaultValue);
    }

    public String attr(String name) {
        return attr(name, null);
    }

    public String attr(String name, String defaultValue) {
        return attributes.getOrDefault(name, defaultValue);
    }

    public XmlElement element(String xpath) {
        return element(Arrays.asList(xpath.split("/")));
    }

    public List<XmlElement> elements(String xpath) {
        return elements(Arrays.asList(xpath.split("/")));
    }

    private XmlElement element(List<String> path) {
        if (path.size() == 0) {
            return this;
        }
        return children.stream()
                .filter(e -> path.get(0).equals(e.name))
                .findFirst()
                .map(e -> e.element(path.subList(1, path.size())))
                .orElse(null);
    }

    private List<XmlElement> elements(List<String> path) {
        if (path.size() == 0) {
            return Collections.singletonList(this);
        }
        return children(path.get(0)).stream()
                .map(e -> e.elements(path.subList(1, path.size())))
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    private List<XmlElement> children(String name) {
        return children.stream()
                .filter(e -> name.equals(e.name))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "XmlElement{" +
                "index=" + index +
                ", name='" + name + '\'' +
                ", attributes=" + attributes +
                ", content='" + content + '\'' +
                ", children=" + children +
                '}';
    }
}
