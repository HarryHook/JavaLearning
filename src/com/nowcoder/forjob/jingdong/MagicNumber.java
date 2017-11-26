package com.nowcoder.forjob.jingdong;

import java.util.Scanner;

public class MagicNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            System.out.println("v1 " + isMagic_v1(num));
            System.out.println("v2 " + isMagic_v2(num));
        }
    }

    public static boolean isMagic_v1(int number) {
        int sum = 0;
        int tmp = number;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        sum = sum / 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        int cur = 0;
        while (tmp != 0) {
            cur = tmp % 10;
            for (int i = sum; i >= 0; i--) {
                dp[i] = dp[i] || (i - cur >= 0 ? dp[i - cur] : false);
            }
            if (dp[sum]) {
                return true;
            }
            tmp /= 10;
        }
        return false;
    }

    public static boolean isMagic_v2(int number) {
        int sum = 0;
        int tmp = number;
        int cur;
        int row = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
            row++;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        sum = sum / 2;
        boolean[][] dp = new boolean[row][sum + 1];
        for (int i = 0; i < row; i++) {
            dp[i][0] = true;
        }
        while (tmp != 0) {
            cur = tmp % 10;
            for (int i = 0; i < row; i++) {
                for (int j = 1; j <= sum; j++) {
                    if (j - cur == 0) {
                        dp[i][j] = true;
                    } else if ((i > 0 && j - cur > 0) && (dp[i - 1][j] || dp[i - 1][j - cur] == true)) {
                        dp[i][j] = true;
                    }
                }
                if (dp[i][sum] == true) {
                    return true;
                }
            }

            tmp /= 10;
        }

        return false;
    }
}
