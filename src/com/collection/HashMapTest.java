package com.collection;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap(4);
        map.put("apple",1);
        map.put("banana", 2);
        map.put("orange", 3);
        map.put("peak", 4);

        System.out.println("size(): " + map.size);
        System.out.println(map);
        map.put("polo", 5);
        System.out.println("capacity: " + map.capacity());
        System.out.println(map);

    }
}
