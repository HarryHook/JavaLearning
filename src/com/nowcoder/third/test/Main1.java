package com.nowcoder.third.test;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String s = sc.nextLine();
	
	String sub = "";
	for (int i = 1; i < s.length(); i++) {
	    sub = s.substring(0, s.length() - i);
	    if (isOddString(sub)) {
		System.out.println(s.length() - i);
		break;
	    }
	}
	sc.close();
    }

    public static boolean isOddString(String s) {
	if (s == "" || s == null || s.length() % 2 != 0) {
	    return false;
	}
	String s1 = s.substring(0, s.length() / 2);
	String s2 = s.substring(s.length() / 2, s.length());
	if (s1.equals(s2)) {
	    return true;
	}
	return false;
    }
}
