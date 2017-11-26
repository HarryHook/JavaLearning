package com.nowcoder.swordForOffer;

public class PrintMinNum {

    public static String printMinNumber(int[] numbers) {

        StringBuilder results = new StringBuilder();
        int len = numbers.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                String str1 = String.valueOf(numbers[i] + "" + numbers[j]);
                String str2 = String.valueOf(numbers[j] + "" + numbers[i]);
                if (Integer.parseInt(str1) > Integer.parseInt(str2)) {
                    swap(numbers, i, j);
                }
            }
            results.append(numbers[i]);
        }
        return results.toString();
    }

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] num = {3, 5, 1, 4, 2};
        System.out.println(printMinNumber(num));
    }
}
