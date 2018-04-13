package com.collection;

public interface MyMap<K, V> {
    public V put(K key, V value);

    public V get(K key, V value);

    public int size();

    public interface Entry<K, V> {
        public K getKey();

        public V getValue();
    }
}
