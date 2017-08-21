package com.prepareforbat.lianjia;

import java.util.Scanner;
import java.util.TreeSet;

public class nSimples {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num[] = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        TreeSet<Integer> set = new TreeSet<>();
        for(int value: num) {
            set.add(value);
        }
        System.out.println(set.size());
        int[] x= new int[set.size()];
        for (int i = 0; i < set.size();) {
            for(int j:set) {
                x[i++] = j;
            }
        }
        for (int i = 0; i < set.size() -1 ; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.print(x[set.size()-1]);
    }
}
