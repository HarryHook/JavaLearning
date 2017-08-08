package com.JavaCoreLearning;
import java.util.*;
public class ExceptionalTest {

    public static void main(String[] args) {
	
	int ntry = 100000;
	Stack s = new Stack();
	long s1;
	long s2;
	
	
	System.out.println("Catching for empty stack");
	s1 = new Date().getTime();
	for(int i=0; i<ntry; i++) {
	   try { 
	       s.pop();
	   } catch(EmptyStackException e) {
	       e.printStackTrace();
	   }
	}
	s2 = new Date().getTime();
	System.out.println((s2 - s1) + " milliseconds");
	
	System.out.println("Testing for empty stack");
	s1 = new Date().getTime();
	for(int i=0; i<ntry; i++) {
	    if(!s.isEmpty()) s.pop();
	}
	s2 = new Date().getTime();
	System.out.println((s2 - s1) + "milliseconds");
    }

}
