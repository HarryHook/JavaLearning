package com.nowcoder.forjob.didi;

import java.util.ArrayList;
import java.util.Scanner;

public class PrintDidi {

    public static void printStr(char[] a, int l, int r, int n, int index) {
        if (l > n || r < 0 || l < r) return;
        if (l == n && r == n) {
            System.out.println(a);
        } else {
            if (l < n) {
                a[index] = '(';
                printStr(a, l + 1, r, n, index + 1);
            }
            if (l > r) {
                a[index] = ')';
                printStr(a, l, r + 1, n, index + 1);
            }
        }
    }

    public static void generate(String s, int l, int r, ArrayList<String> ans) {
        if (l == 0 && r == 0) {
            ans.add(s);
        }
        if (l > 0) {
            generate(s + "(", l - 1, r, ans);
        }
        if (r > 0 && l < r) {
            generate(s + ")", l, r - 1, ans);
        }
    }
    static  ArrayList<String> ans = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        generate("(", 3,0,ans);
//        System.out.println(ans);
        char[] c = new char[2 * n];
        printStr(c, 0, 0, n, 0);
    }
}
