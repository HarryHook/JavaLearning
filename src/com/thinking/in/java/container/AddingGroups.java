package com.thinking.in.java.container;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AddingGroups {

    public static void main(String[] args) {
	Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
	Integer[] moreInt = { 6, 7, 8, 9, 10 };
	collection.addAll(Arrays.asList(moreInt));
	for (Integer c : collection) {
	    System.out.print(c + " ");

	}
	System.out.println("");
	Collections.addAll(collection, 11, 12, 13, 14, 15);
	for (Integer c : collection) {
	    System.out.print(c + " ");

	}
	System.out.println("");
	Collections.addAll(collection, moreInt);
	for (Integer c : collection) {
	    System.out.print(c + " ");

	}
	System.out.println("");
	List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
	list.set(1, 99);
	for (Integer c : list) {
	    System.out.print(c + " ");
	}
//	list.add(10);//底层是数组，不能改变大小，调用add()，delete()是会抛出Unsupported Operation异常
    }

}
