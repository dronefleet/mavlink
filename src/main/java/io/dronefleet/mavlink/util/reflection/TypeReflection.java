package io.dronefleet.mavlink.util.reflection;

import java.lang.reflect.ParameterizedType;
import java.util.*;
import java.util.stream.Collectors;

public class TypeReflection {
    private final Class type;

    public TypeReflection(Class type) {
        this.type = type;
    }

    public List<Class> getAssignableTypes() {
        List<Class> parentClasses = Optional.ofNullable(type.getSuperclass())
                .map(TypeReflection::new)
                .map(TypeReflection::getAssignableTypes)
                .orElse(Collections.emptyList());

        List<Class> interfaceClasses = Arrays.stream(type.getInterfaces())
                .map(TypeReflection::new)
                .map(TypeReflection::getAssignableTypes)
                .flatMap(List::stream)
                .filter(c -> !parentClasses.contains(c))
                .collect(Collectors.toList());

        List<Class> classes = new ArrayList<>();
        classes.add(type);
        classes.addAll(interfaceClasses);
        classes.addAll(parentClasses);
        return classes;
    }

    public List<Class> getParameters() {
        return Arrays.stream(((ParameterizedType)type.getGenericSuperclass()).getActualTypeArguments())
                .map(Class.class::cast)
                .collect(Collectors.toList());
    }
}
