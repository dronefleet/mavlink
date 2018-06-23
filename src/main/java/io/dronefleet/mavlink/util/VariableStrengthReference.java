package io.dronefleet.mavlink.util;

import java.lang.ref.WeakReference;

public class VariableStrengthReference<T> {

    @SuppressWarnings("unused")
    private T strongRef;
    private final WeakReference<T> weakRef;

    public VariableStrengthReference(T ref) {
        this.strongRef = ref;
        this.weakRef = new WeakReference<>(ref);
    }

    public boolean isGarbageCollected() {
        return weakRef.get() == null;
    }

    public boolean isStrong() {
        return strongRef != null;
    }

    public void setStrong(boolean strong) {
        strongRef = strong? weakRef.get() : null;
    }

    public T value() {
        return weakRef.get();
    }

}
