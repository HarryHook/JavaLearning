package com.nowcoder.swordForOffer;

public class FindFirstChar {

    int[] hashtable = new int[256];
    StringBuilder buffer = new StringBuilder();

    public void insert(char ch) {
        buffer.append(ch);
        if (hashtable[ch] == 0) {
            hashtable[ch] = 1;
        } else {
            hashtable[ch] += 1;
        }
    }

    public char firstApperaingOnce() {
        char[] seq = buffer.toString().toCharArray();
        for (char ch : seq) {
            if(hashtable[ch] == 1) {
                return ch;
            }
        }
        return '#';
    }
}
