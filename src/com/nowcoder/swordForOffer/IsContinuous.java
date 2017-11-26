package com.nowcoder.swordForOffer;

import java.util.Arrays;

public class IsContinuous {
    public static boolean IsContinuous(int[] numbers) {

        Arrays.sort(numbers);
        int zeroCount = 0;
        int diffCount = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0) {
                zeroCount++;
            } else {
                if (numbers[i] == numbers[i + 1]) {
                    return false;
                } else {
                    diffCount += numbers[i + 1] - numbers[i] - 1;
                }
            }
        }
        return diffCount == zeroCount;
    }

    public static void main(String[] args) {
        int[] numbers = {0, 0, 1, 3, 5};
        System.out.println(IsContinuous(numbers));
    }
}
