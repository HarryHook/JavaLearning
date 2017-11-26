package com.nowcoder.swordForOffer;

public class Multiply {
    /*
    A[0...n-1]
    B[0...n-1]
    B[i]=A[0]*A[1]...A[i-1]*A[i+1]...A[n-1]
     */

    public int[] multiply(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        B[0] = 1;
        //上三角
        for (int i = 1; i < length; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        int temp = 1;
        //下三角
        for (int j = length - 2; j >= 0; j--) {
            temp *= A[j + 1];
            B[j] *= temp;
        }
        return B;
    }
}
