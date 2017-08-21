package com.nowcoder.forjob.sohu;

import java.util.Arrays;
import java.util.Scanner;

public class FindMaxString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(count(s));
        sc.close();
    }

    public static int count(String s) {
        int[] x = new int[5];
        int min = 0;
        int max = 0;
        for(int i=0; i<s.length(); i++) {
            x[0] = s.indexOf("A");
            x[1] = s.indexOf("B");
            x[2] = s.indexOf("C");
            x[3] = s.indexOf("D");
            x[4] = s.indexOf("E");
            Arrays.sort(x);
            if(x[4] == -1) {
                return 0;
            }
            min = x[4];
            char temp = s.charAt(0);
            s = s.substring(1) + temp;
            max = Math.max(max, s.length() - min - 1);
        }
        return max;
    }
}
