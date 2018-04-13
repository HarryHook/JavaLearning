package com.nowcoder.forjob.xiaohui;

import java.util.Arrays;

public class DictionarySort {
    private static int[] findNearestNumber(int[] numbers) {
        int[] numbersCopy = Arrays.copyOf(numbers, numbers.length);
        int index = findTransferPoint(numbersCopy);
        if (index == 0) {
            return null;
        }
        exchangeHead(numbersCopy, index);
        reverse(numbersCopy, index);
        return numbersCopy;
    }


    private static int findTransferPoint(int[] numbers) {
        for (int i = numbers.length - 1; i > 0; i--) {
            if (numbers[i] > numbers[i - 1]) {
                return i;
            }
        }
        return 0;
    }

    private static int[] exchangeHead(int[] numbers, int index) {
        int head = numbers[index - 1];
        for (int i = numbers.length - 1; i > 0; i--) {
            if (head < numbers[i]) {
                numbers[index - 1] = numbers[i];
                numbers[i] = head;
                break;
            }
        }
        return numbers;
    }

    private static int[] reverse(int[] numbers, int index) {
        for (int i = index, j = numbers.length - 1; i < j; i++, j--) {
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
        return numbers;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 5, 4};

        numbers = findNearestNumber(numbers);
        outputNumbers(numbers);
    }

    private static void outputNumbers(int[] numbers) {
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println("");
    }
}
