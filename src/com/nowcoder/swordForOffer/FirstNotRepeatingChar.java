package com.nowcoder.swordForOffer;

import java.util.LinkedHashMap;

public class FirstNotRepeatingChar {
    public static int firstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) return -1;
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        char[] seq = str.toCharArray();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(seq[i])) {
                map.put(seq[i], map.get(seq[i]) + 1);
            } else {
                map.put(seq[i], 1);

            }
        }
        for (int i = 0; i < len; i++) {
            if (map.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "sssAAAb";
        System.out.println("result: " + firstNotRepeatingChar(s));
    }
}
