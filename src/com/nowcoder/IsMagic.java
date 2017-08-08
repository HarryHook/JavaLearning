package com.nowcoder;

//链接：https://www.nowcoder.com/questionTerminal/99fa7be28d5f4a9d9aa3c98a6a5b559a?toCommentId=533371
//来源：牛客网

import java.util.*;

public class IsMagic {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int begin = in.nextInt();
	int end = in.nextInt();
	if (end < 10) {
	    in.close();
	    return ;
	}
	int count = 0;
	for (int m = begin; m <= end; m++) {
	    int num = m;
	    boolean isMagic = false;
	    ArrayList<Integer> a = new ArrayList<>();
	    while (num != 0) {
		a.add(num % 10);
		num /= 10;
	    }
	    for (int i = 0; i < a.size(); i++) {
		if (a.get(i) == 0) {
		    continue;
		}
		for (int j = 0; j < a.size(); j++) {
		    if (i == j) {
			continue;
		    }
		    int tmp = a.get(i) * 10 + a.get(j);
		    if (isPrime(tmp)) {
			isMagic = true;
			break;
		    }
		}
		if (isMagic) {
		    count++;
		    break;
		}
	    }
	}
	System.out.println(count);
	in.close();
    }

    private static boolean isPrime(int n) {
	int i = 2;
	while (i < n && (n % i) != 0) {
	    i++;
	}
	return i == n;
    }

}