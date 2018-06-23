package io.dronefleet.mavlink.util;

import io.dronefleet.mavlink.util.reflection.TypeReflection;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class ErrorHandler {
    private final Map<Class<? extends Throwable>, Consumer<Throwable>> errorConsumers;
    private final ErrorHandler parent;
    private final Consumer<Throwable> defaultHandler;

    public ErrorHandler(Consumer<Throwable> defaultConsumer) {
        this(null, defaultConsumer);
    }

    private ErrorHandler(ErrorHandler parent) {
        this(parent, null);
    }

    private ErrorHandler(ErrorHandler parent, Consumer<Throwable> defaultHandler) {
        this.errorConsumers = new HashMap<>();
        this.parent = parent;
        this.defaultHandler = defaultHandler;
    }

    public ErrorHandler forkChild() {
        return new ErrorHandler(this);
    }

    public void error(Throwable t) {
        Consumer<Throwable> consumer = new TypeReflection(t.getClass())
                .getAssignableTypes()
                .stream()
                .filter(errorConsumers::containsKey)
                .map(errorConsumers::get)
                .findFirst()
                .orElse(defaultHandler);

        if (consumer != null) {
            consumer.accept(t);
        } else if (parent != null) {
            parent.error(new RuntimeException("Uncaught exception", t));
        } else {
            throw new IllegalStateException("Error handler has no default consumer", t);
        }
    }

    public <T extends Throwable> void error(Class<T> type, Consumer<T> consumer) {
        //noinspection unchecked
        errorConsumers.put(type, (Consumer<Throwable>)consumer);
    }
}
