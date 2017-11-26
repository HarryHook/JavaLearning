package com.nowcoder.forjob.zuoyebang;

import java.util.Random;

public class TopK {
    //找到第一个数在数组中所在的位置并返回
    public static int getMiddle(int[] a, int low, int high) {

        int tmp = a[low];
        while (low < high) {
            //从高位找到比tmp小的元素
            while (low < high && a[high] > tmp) {
                high--;
            }
            a[low] = a[high];
            //从低位找到比tmp大的元素
            while (low < high && a[low] < tmp) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = tmp;

        return low; //返回当前元素应该在数组中的位置
    }

    //对整个数组进行排序
    public static void quickSort(int[] nums, int low, int high) {

        if (low < high) {
            int middle = getMiddle(nums, low, high);
            quickSort(nums, low, middle - 1);
            quickSort(nums, middle + 1, high);
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] nums = generateArray(1000000);
        int[] res = getMin(nums, 1000);
        // quickSort(nums, 0, nums.length - 1);
        for (int num : res) {
            System.out.print(num + " ");
        }
        System.out.println();
        long end = System.currentTimeMillis();
        System.out.println("耗时： " + (end - start) + "ms");
    }

    public static int[] getMin(int[] nums, int n) {
        int low = 0;
        int high = nums.length - 1;
        int middle = getMiddle(nums, low, high);

        if (middle > n) {
            int[] result = new int[middle];
            for (int i = 0; i < middle - 1; i++) {
                result[i] = nums[i];
            }
            return getMin(nums, n);

        } else {
            int[] result = new int[n];

            quickSort(nums, 0, nums.length - 1);

            for (int i = 0; i < n - 1; i++) {

                result[i] = nums[i];
            }

            return result;
        }
    }

    private static int[] generateArray(int n) {
        Random random = new Random();
        long start = System.currentTimeMillis();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = random.nextInt(Integer.MAX_VALUE);
        }
        long end = System.currentTimeMillis();
        System.out.println("生成数组耗时：" + (end - start) + "ms");
        return nums;
    }
}
