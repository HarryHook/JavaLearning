package com.collection;

public class MyHashMap<K, V> implements MyMap<K, V> {
    private static int capacity = 16;
    private static double loadFactory = 0.75;
    private Entry<K, V>[] table = null;
    private int size = 0;

    public MyHashMap(int length, double loader) {
        capacity = length;
        loadFactory = loader;

        table = new Entry[capacity];
    }

    public MyHashMap() {
        this(capacity, loadFactory);
    }
    private int getIndex(K key) {
        return key.hashCode() & (capacity - 1);
    }

    public V put(K key, V value) {
        //先判断是否需要扩容
        if (size >= capacity * loadFactory) {
            up2Size();
        }
        int index = getIndex(key);
        Entry<K, V> entry = table[index];
        if (entry == null) {
            table[index] = newEntry(key, value, null);
            size++;
        } else {
            table[index] = newEntry(key, value, entry);
        }
        return table[index].getValue();
    }

    private void up2Size() {
        Entry<K, V>[] newTable = new Entry[2 * capacity];
        capacity = 2*capacity;
        reHash(newTable);
    }

    private void reHash(Entry<K, V>[] newTable) {
        for (int i = 0; i < newTable.length; i++) {
            if (newTable[i] != null) {
                Entry<K, V> e = newTable[i];
                if (e != null) {
                    newTable[i] = null;
                    do {
                        Entry<K, V> next = e.next;
                        int index = getIndex(e.getKey());
                        e.next = newTable[index];
                        newTable[index] = e;
                        e = next;
                    } while (e != null);
                }
            }
        }
    }

    private Entry<K, V> newEntry(K key, V value, Entry<K, V> next) {
        return new Entry(key, value, next);
    }

    public V get(K key, V value) {
        int index = getIndex(key);
        if (table[index] == null) {
            return null;
        }
        return findValueByEqualKey(key, table[index]);
    }

    private V findValueByEqualKey(K key, Entry<K, V> entry) {
        if(key == entry.getKey() || key.equals(entry.getKey())) {
            return entry.getValue();
        }else {
            if(entry.next != null) {
                return findValueByEqualKey(key, entry.next);
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    public class Entry<K, V> implements MyMap.Entry<K, V> {

        private K key;
        private V value;
        private Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }
    }


}
