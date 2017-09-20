package com.nowcoder.forjob.mi;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine().trim();
            System.out.println(matchString(s));
        }
    }

    private static String matchString(String s) {
        int len = s.length();
        char[] cs = s.toCharArray();
        StringBuffer res = new StringBuffer("_" + Character.toUpperCase(cs[0]));
        for (int i = 1; i < len; i++) {
            if (cs[i] == '.') {
                continue;
            }
            if (cs[i - 1] == '.') {
                res.append("_" + Character.toUpperCase(cs[i]));
                continue;
            }
            if (Character.isUpperCase(cs[i])) {
                if (Character.isLowerCase(cs[i - 1]) || Character.isDigit(cs[i - 1]) || (i + 1 < len && Character.isLowerCase(cs[i + 1]))) {
                    res.append("_" + cs[i]);
                } else {
                    res.append(cs[i]);
                }
            } else if (Character.isLowerCase(cs[i])) {
                if (Character.isDigit(cs[i - 1])) {
                    res.append("_" + Character.toUpperCase(cs[i]));
                } else {
                    res.append(Character.toUpperCase(cs[i]));
                }
            } else if (Character.isDigit(cs[i])) {
                if (!Character.isDigit(cs[i - 1])) {
                    res.append("_" + cs[i]);
                } else {
                    res.append(cs[i]);
                }
            } else {
                throw new RuntimeException("IllegalElements!");
            }
        }
        res.append("_");
        return res.toString();
    }
}
