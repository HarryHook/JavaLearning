package com.nowcoder.forjob.jingdong;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int size = s.length();
        int res = 1;
        int cnt = 0;
        for (int i = 0; i < size; i++) {
            if (s.charAt(i) == '(') {
                cnt++;
            } else {
                res *= cnt;
                cnt--;
            }
        }
        System.out.println(res);
    }

}

