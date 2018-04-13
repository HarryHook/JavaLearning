package com.nowcoder.forjob.lianjia;

public class BigNumberMultiply {
    /*
      AB
      CD
     -----
     AD BD
  AC BC
  ---------
  AC(AD+BC)BD
     */
    public int[] bigNumberMultiply(int[] num1, int[] num2) {
        int[] res = new int[num1.length + num2.length];
        for (int i = 0; i < num1.length; i++) {
            for (int j = 0; j < num2.length; j++) {
                res[i + j + 1] += num1[i] * num2[j];   //防止最后一位进位，留出一个空位
            }
        }
        for (int k = res.length - 1; k > 0; k--) {
            if (res[k] > 10) {
                res[k - 1] += res[k] / 10;
                res[k] %= 10;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        BigNumberMultiply bnm = new BigNumberMultiply();
        int[] num1 = {0};
        int[] num2 = {0};

        int[] res = bnm.bigNumberMultiply(num1, num2);
        for (int i = res[0] == 0 ? 1 : 0; i < res.length; i++) {
            System.out.print(res[i]);
        }
    }
}
