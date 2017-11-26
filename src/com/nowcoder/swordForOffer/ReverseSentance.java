package com.nowcoder.swordForOffer;

public class ReverseSentance {
    public static String ReverseSentence(String str) {
        if (str == " " || str.length() == 0) return str;
        String[] seq = str.split(" ");
        for (int i = 0; i < seq.length / 2; i++) {
            String temp = seq[i];
            seq[i] = seq[seq.length - i - 1];
            seq[seq.length - i - 1] = temp;
        }
        StringBuilder res = new StringBuilder();
        res.append(seq[0]);
        for (int i = 1; i < seq.length; i++) {
            res.append(" " + seq[i] );
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String str = " ";
        System.out.println(ReverseSentence(str));;

    }
}
