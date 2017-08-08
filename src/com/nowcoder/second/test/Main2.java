package com.nowcoder.second.test;

import java.util.Scanner;

public class Main2 {
    /*
     * 输入一个字符串，判断相邻两个字符相同的次数
     */
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String s = sc.nextLine();
	int cnt1 = 0;
	int cnt2 = 0;
	for (int i = 0; i < s.length(); i++) {
	    if (i % 2 == 0) {
		if (s.charAt(i) == 'B')
		    cnt1++;
	    } else {
		if (s.charAt(i) == 'W')
		    cnt1++;
	    }
	}
	for (int i = 0; i < s.length(); i++) {
	    if (i % 2 == 1) {
		if (s.charAt(i) == 'B')
		    cnt2++;
	    } else {
		if (s.charAt(i) == 'W')
		    cnt2++;
	    }
	}
	System.out.println(Math.min(cnt1, cnt2));
	sc.close();
    }
}