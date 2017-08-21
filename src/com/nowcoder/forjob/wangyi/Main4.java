package com.nowcoder.forjob.wangyi;

import java.util.HashSet;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        HashSet<String> hashSet = new HashSet<>();
        for(int i=0; i<s.length(); i++) {
            hashSet.add(s.substring(i, i+1));
        }
        if(hashSet.size() > 2) {
            System.out.print(0);
            System.exit(0);
        }
        System.out.println(hashSet.size());
    }
}
