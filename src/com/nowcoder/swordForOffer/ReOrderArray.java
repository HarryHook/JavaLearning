package com.nowcoder.swordForOffer;

public class ReOrderArray {
    public static void reOrderArray(int[] array) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                int tmp = array[i];

                while (i > 0 && array[i - 1] % 2 == 0) {
                    array[i] = array[i - 1];
                    i--;
                }
                array[i] = tmp;
            }

        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1};
        reOrderArray(a);
        for (int num : a) {
            System.out.print(num + " ");
        }
    }
}
