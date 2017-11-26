package com.nowcoder.swordForOffer;

public class FindNumsAppearOnce {
    public void findNumsAppearOnce(int[] array, int[] num1, int[] num2) {
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            temp ^= array[i];
        }
        int indexOf1 = findFirstOneBit1(temp);
        for (int i = 0; i < array.length; i++) {
            if (isBit(array[i], indexOf1)) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }

    }

    private int findFirstOneBit1(int num) {
        int indexOfBit = 0;
        while ((num & 1) == 0 && indexOfBit < 32) {
            indexOfBit++;
            num >>= 1;
        }
        return indexOfBit;
    }

    private boolean isBit(int num, int indexOfBit) {
        num = num >> indexOfBit;
        return (num & 1) == 1;
    }

    public static void main(String[] args) {
        FindNumsAppearOnce test = new FindNumsAppearOnce();
        int[] array = {1, 2, 3, 4, 5, 6, 4, 3, 2, 1};
        int[] num1 = new int[1];
        int[] num2 = new int[1];

        test.findNumsAppearOnce(array, num1, num2);
        System.out.println(num1[0] + ": " + num2[0]);
    }
}
