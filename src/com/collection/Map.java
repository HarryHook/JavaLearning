package com.collection;

import java.util.Set;
import java.util.Collection;

public interface Map<K, V> {
    abstract void clear();

    abstract boolean containsKey(Object key);

    abstract boolean containsValue(Object value);

    abstract Set<Entry<K, V>> entrySet();

    abstract V get(Object key);

    abstract boolean isEmpty();

    abstract Set<K> keySet();

    abstract V put(K key, V value);

    abstract void putAll(Map<? extends K, ? extends V> map);

    abstract V remove(Object key);

    abstract int size();

    abstract Collection<V> values();

    interface Entry<K, V> {
        K getKey();

        V getValue();

        V setValue(V value);

        boolean equals(Object o);

        int hashCode();
    }

    abstract int hashCode();

    abstract boolean equals(Object obj);
}
