package com.nowcoder.third.test;

import java.util.Scanner;

public class Main5 {

    public static void main(String[] args) {
	int maxn = 1000005;
	int mod = 1000000007;
	int vis[] = new int[maxn];
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	long ans = 1;
	for (int i = 2; i <= n; i++) {
	    if (vis[i] == 0)
		continue;
	    for (int j = i + i; j <= n; j += i)
		vis[j] = 1;
	    int tmp = n, cnt = 0;
	    while (tmp >= i) {
		tmp /= i;
		cnt++;

	    }
	    ans = ans * (cnt + 1) % mod;
	}
	System.out.println(ans);
	sc.close();
    }

}
