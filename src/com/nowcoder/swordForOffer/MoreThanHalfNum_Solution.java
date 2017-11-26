package com.nowcoder.swordForOffer;

import com.collection.HashMap;

public class MoreThanHalfNum_Solution {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] array = {1,2,3,2,2,2,5,4,2};
        for(int i=0; i<array.length; i++) {
            if(!map.containsKey(array[i])) {
                map.put(array[i], 1);
            } else {
                map.put(array[i], map.get(array[i]) + 1);
            }
        }
        for(int value: map.values()) {
            if(value > array.length >>1) {
                System.out.println(true);
            } else {
                System.out.println(false);
            }
        }
    }
}
