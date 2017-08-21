package com.nowcoder.forjob.third;

import java.util.Scanner;

public class Main4 {
    /*
     * 输入一个字符串，判断相邻两个字符相同的次数
     */
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String s = sc.nextLine();
	int cnt = 0;
	for (int i = 1; i < s.length(); i++) {
	    if (s.charAt(i - 1) == s.charAt(i)) {
		cnt++;
		i++;
	    }
	}
	System.out.println(cnt);
	sc.close();
    }
}
