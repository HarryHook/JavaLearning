package com.nowcoder.forjob.meituan;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }
        boolean flag = true;
        int count = 0;
/**
  * 当时想的是最快全灭的点法是每次都点最左边第一个亮的。。
  * 先找第一个1，再找0， 再找1。
  * 一次就AC了= =  如果不对  大家指出来啊
  */

        for (int i = 0; i < num; i++) {
            if (flag && arr[i] == 1) {
                flag = false;
                count++;
            }
            if (!flag && arr[i] == 0) {
                flag = true;
                count++;
            }
        }

        if (count % 2 == 1) {
            System.out.println("Alice");
        } else {
            System.out.println("Bob");
        }
    }
}
