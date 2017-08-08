package com.thinking.in.java.container;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class SetOfInteger {

    public static void main(String[] args) {
	Random random = new Random(47);
	HashSet<Integer> intset = new HashSet<Integer>();
	for(int i=0; i<1000;i++) {
	    intset.add(random.nextInt(10));
	}
	System.out.println(intset);
    }

}
