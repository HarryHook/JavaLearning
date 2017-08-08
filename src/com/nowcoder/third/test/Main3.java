package com.nowcoder.third.test;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String s = sc.nextLine();
	int cnt = 0, mx = 0;
	for (int i = 0; i < s.length(); i++) {
	    if (s.charAt(i) == 'A' || s.charAt(i) == 'C' || s.charAt(i) == 'G' || s.charAt(i) == 'T') {
		cnt++;
		if (mx < cnt) {
		    mx = cnt;
		}
	    } else {
		cnt = 0;
	    }
	}
	System.out.println(mx);
	sc.close();
    }
}