package com.JavaCoreLearning.collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


public class LinkedListTest {
    public static void main(String[] args) {
	List<String> aList = new LinkedList<>();
	aList.add("zhangsan");
	aList.add("lisi");
	aList.add("wangwu");
	List<String> bList = new LinkedList<>();
	bList.add("Harry");
	bList.add("Eric");
	bList.add("Aaron");
	System.out.println(aList);
	System.out.println(bList);
	ListIterator<String> aIterator = aList.listIterator();
	Iterator<String> bIterator = bList.iterator();
	while(bIterator.hasNext()) {
	    if(aIterator.hasNext()) {
		aIterator.next();
		aIterator.add(bIterator.next());
	    }
	}
	System.out.println(aList);
	bIterator = bList.iterator();
	while(bIterator.hasNext()) {
	    bIterator.next();
	    if(bIterator.hasNext()) {
		bIterator.remove();
	    }
	}
	System.out.println(bList);
	aList.removeAll(bList);
	System.out.println(aList);
    }
}
