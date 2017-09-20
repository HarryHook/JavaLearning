package com.collection;

import java.util.LinkedHashMap;
import java.util.TreeMap;

public class AssociativeArray<K,V> {
    private Object[][] pairs;
    private int index;
    public AssociativeArray(int length) {
        pairs = new Object[length][2]; //键值对
    }
    public void put(K key, V value) {
        if(index >= pairs.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        pairs[index++] = new Object[] {key, value};
    }
    //线性搜索的速度是最慢的
    public V get(K key) {
        for(int i=0; i<index; i++) {
            return (V) pairs[i][1];
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for(int i=0; i<index; i++) {
            buffer.append(pairs[i][0].toString());
            buffer.append(": ");
            buffer.append(pairs[i][1].toString());
            if(i<index-1) {
                buffer.append("\n");
            }
        }
        return buffer.toString();
    }

    public static  void main(String[] args) {
        AssociativeArray<String, String> map = new AssociativeArray<>(6);
        HashMap<String, String> map1 = new HashMap<>();
        TreeMap<String, String> map2 = new TreeMap<>();
        LinkedHashMap<String,String> map3 = new LinkedHashMap<>();

        map.put("SKY", "BLUE");
        map.put("grass", "green");
        map.put("ocean", "dancing");
        map.put("tree", "tall");
        map.put("earth", "brown");
        map.put("sun", "warm");

        map1.put("SKY1", "BLUE1");
        map1.put("grass1", "green1");
        map1.put("ocean1", "dancing1");
        map1.put("tree1", "tall1");
        map1.put("earth1", "brown1");
        map1.put("sun1", "warm1");

        map2.put("SKY2", "BLUE2");
        map2.put("grass2", "green2");
        map2.put("ocean2", "dancing2");
        map2.put("tree2", "tall2");
        map2.put("earth2", "brown2");
        map2.put("sun2", "warm2");

        map3.put("SKY3", "BLUE3");
        map3.put("grass3", "green3");
        map3.put("ocean3", "dancing3");
        map3.put("tree3", "tall3");
        map3.put("earth3", "brown3");
        map3.put("sun3", "warm3");
        try {
            map.put("extra", "object");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Too many objects");

        }

        System.out.println(map);
        System.out.println(map.get("ocean"));
        System.out.println(map1);
        System.out.println(map1.get("ocean1"));
        System.out.println(map2);
        System.out.println(map2.get("ocean2"));
        System.out.println(map3);
        System.out.println(map3.get("ocean3"));

    }
}
