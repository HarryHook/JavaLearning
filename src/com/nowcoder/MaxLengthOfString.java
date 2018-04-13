package com.nowcoder;

import java.util.Scanner;

public class MaxLengthOfString {

    public static void main(String[] args) {

	String s1 = new String("abcdafgh");
	String s2 = new String("abcafgh");
	int count = findLongest(s1, s2);
	count = longestCommonSubstring(s1, s2);
	System.out.println("LCS: " + count);
    }

    public static void getLCSString_v1() {
	Scanner sc = new Scanner(System.in);
	String s1 = sc.nextLine(); // Sit it out G
	String s2 = sc.nextLine(); // Sit down and shut up
	if (s1.length() < s2.length()) {
	    s1 = s1 + s2;

	    s2 = s1.substring(0, s1.length() - s2.length());
	    s1 = s1.substring(s2.length());
	}
	int maxLength = 0;
	for (int i = 0; i <= s1.length() - s2.length(); i++) {
	    int count = 0;
	    for (int j = 0; j < s2.length(); j++) {
		if (s1.charAt(i + j) == s2.charAt(j)) {
		    count++;
		} else {
		    count = 0;
		}
		maxLength = Math.max(maxLength, count);
	    }

	}
	System.out.println("MaxLength of two string:" + maxLength);
	sc.close();
    }

    public static int findLongest(String A, String B) {
	char[] arrA = A.toCharArray();
	char[] arrB = B.toCharArray();
	int n = A.length();
	int m = B.length();
	int[][] dp = new int[n][m];
	int max = 0;
	for (int i = 0; i < n; i++) {
	    if (arrA[i] == arrB[0])
		dp[i][0] = 1;
	}
	for (int j = 1; j < m; j++) {
	    if (arrB[j] == arrA[0])
		dp[0][j] = 1;
	}
	for (int i = 1; i < n; i++) {
	    for (int j = 1; j < m; j++) {
		if (arrA[i] == arrB[j])
		    max = Math.max(dp[i][j] = dp[i - 1][j - 1] + 1, max);
	    }
	}
	return max;
    }

    public static int compute(char[] str1, char[] str2) {
	int size1 = str1.length;
	int size2 = str2.length;
	if (size1 == 0 || size2 == 0)
	    return 0;

	// the start position of substring in original string
	int start1 = -1;
	int start2 = -1;
	// the longest length of common substring
	int longest = 0;

	// record how many comparisons the solution did;
	// it can be used to know which algorithm is better
	int comparisons = 0;

	for (int i = 0; i < size1; ++i) {
	    int m = i;
	    int n = 0;
	    int length = 0;
	    while (m < size1 && n < size2) {
		++comparisons;
		if (str1[m] != str2[n]) {
		    length = 0;
		} else {
		    ++length;
		    if (longest < length) {
			longest = length;
			start1 = m - longest + 1;
			start2 = n - longest + 1;
		    }
		}

		++m;
		++n;
	    }
	}

	// shift string2 to find the longest common substring
	for (int j = 1; j < size2; ++j) {
	    int m = 0;
	    int n = j;
	    int length = 0;
	    while (m < size1 && n < size2) {
		++comparisons;
		if (str1[m] != str2[n]) {
		    length = 0;
		} else {
		    ++length;
		    if (longest < length) {
			longest = length;
			start1 = m - longest + 1;
			start2 = n - longest + 1;
		    }
		}

		++m;
		++n;
	    }
	}
	 System.out.printf("from %d of str1 and %d of str2, compared for %dtimes\n", start1, start2, comparisons);
	return longest;
    }

    public static  int longestCommonSubstring(String str1, String str2) {
	
	return compute(str1.toCharArray(), str2.toCharArray());
    }

}
