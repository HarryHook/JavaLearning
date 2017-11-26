package com.nowcoder.swordForOffer;

public class StrToInt {
    public static  int StrToInt(String str) {
        char[] seq = str.toCharArray();
        int sum = 0;
        int flag = 0;
        if (seq[0] == '-') {
            flag = 1;
        }
        for (int i = flag; i < seq.length; i++) {
            if (seq[i] == '+') continue;
            if (seq[i] < 48 || seq[i] > 57) {
                return 0;
            }
            sum = sum * 10 + (seq[i] - 48);
        }

        return flag == 0 ? sum : sum * (-1);
    }

    public static void main(String[] args) {
       int sum =  StrToInt("-2147483647");
        System.out.println(sum);
    }
}
