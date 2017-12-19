package com.nowcoder.swordForOffer;

import java.util.Scanner;

public class StringAdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            StringBuilder res = new StringBuilder();
            char[] c1 = s1.toCharArray();
            char[] c2 = s2.toCharArray();

            int adv = 0;

            int index1 = c1.length - 1;
            int index2 = c2.length - 1;
            while (index1 >= 0 && index2 >= 0) {
                int temp = (c1[index1--] - 48 + c2[index2--] - 48 + adv);
                adv = temp / 10;
                res.append(temp % 10);
            }

            while (index1 >= 0) {
                int temp = (c1[index1--] - 48 + adv);
                adv = temp / 10;
                res.append(temp % 10);
            }
            while (index2 >= 0) {
                int temp = (c2[index2--] - 48 + adv);
                adv = temp / 10;
                res.append(temp % 10);
            }
            if (adv > 0) {
                res.append(adv);
            }
            System.out.println(res.reverse().toString());
        }
    }
}
