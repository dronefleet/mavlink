package io.dronefleet.mavlink.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UnmodifiableMapBuilder<K, V> {
    private final Map<K, V> map;

    public UnmodifiableMapBuilder() {
        this(new HashMap<>());
    }

    public UnmodifiableMapBuilder(Map<K, V> map) {
        this.map = map;
    }

    public UnmodifiableMapBuilder<K, V> put(K key, V value) {
        if (map.containsKey(key)) {
            throw new IllegalStateException("Map already contains key " + key);
        }
        map.put(key, value);
        return this;
    }

    public Map<K, V> build() {
        return Collections.unmodifiableMap(new HashMap<>(map));
    }
}
