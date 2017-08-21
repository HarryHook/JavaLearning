package com.nowcoder.forjob.wangyi;

        import java.util.Arrays;
        import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            Arrays.sort(nums);
            int min = nums[0]; // 上一次加入疯狂队列的那个最小值
            int max = nums[n - 1]; // 上一次加入疯狂队列的那个最大值
            int diff = max - min;
            int minIndex = 1; // 未加入疯狂队列的最小值索引
            int maxIndex = n - 2; // 未加入疯狂队列的最大值索引
            while (minIndex < maxIndex) {
                diff += max - nums[minIndex];
                diff += nums[maxIndex] - min;
                min = nums[minIndex++];
                max = nums[maxIndex--];
        }
            // 原数列中最后一个数 minIndex == maxIndex，将它放到合适的位置上
            diff += Math.max(nums[maxIndex] - min, max - nums[minIndex]);
            System.out.println(diff);
        }
    }
}