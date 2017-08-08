package com.nowcoder;

import java.util.Scanner;



public class HasDiffStr {
    public static void main(String[] args) {
	Scanner in = new  Scanner(System.in);
	String s1 = in.nextLine();
	String s2 = in.nextLine();
	int maxlen = 0;
	for(int i=0; i<=s2.length()-s1.length(); i++) {
	    int count = 0;
	    for(int j=0; j<s1.length(); j++) {
		if(s1.charAt(j) == s2.charAt(i+j)) {
		    count++;
		}
	    }
	    maxlen = Math.max(maxlen, count);
	}
	System.out.println(s1.length() - maxlen);
    }
}
