package com.nowcoder.forjob.jingdong;

import java.util.Scanner;

public class TheNumOfN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(getNumber(num));
    }

    public static int getNumber(long n) {
        return (int) Math.ceil((Math.sqrt(1 + 8 * ((double) n)) - 1) / 2);
    }
}
