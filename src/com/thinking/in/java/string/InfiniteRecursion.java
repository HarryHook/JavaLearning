package com.thinking.in.java.string;

import java.util.ArrayList;

public class InfiniteRecursion {
    public String toString() {
        return super.toString();
    }
    public static void main(String[] args) {
        ArrayList<InfiniteRecursion> list = new ArrayList<>();
        for(int i=0; i<5; i++) {
            list.add(new InfiniteRecursion());
        }
        System.out.println(list);
    }
}
