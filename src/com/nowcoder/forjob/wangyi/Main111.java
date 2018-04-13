package com.nowcoder.forjob.wangyi;

public class Main111 {
    public static void main(String[] args) {
        String s = "join" + 3;

        System.out.println(compute(20, 20));
        }

    private static int compute(int i, int j) {
        if(i<=0 || j<=0) return 1;
        return 3*compute(i-3, j/3);
    }
}
