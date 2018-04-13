package com.nowcoder.forjob.lianjia;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        int count = 0;
        for (int i = 0; i < ch1.length; i++) {
            int asic = ch1[i] ;
            if (asic >= 48 && asic <= 57 || asic >= 65 && asic <= 90 || asic >= 97 && asic <= 122) {
                ch1[i] = '1';
            } else {
                ch1[i] = '0';
            }
            if (ch1[i] == ch2[i]) count++;
        }
        System.out.printf("%.2f%%",(float)count / ch1.length*100);
    }
}