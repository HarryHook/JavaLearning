package com.prepareforbat.pingduoduo;

import java.util.Scanner;

public class TwoBigIntegerMiltiply {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        StringBuffer buffer = new StringBuffer(str1);
        char[] s1 = buffer.toString().toCharArray();
        buffer = new StringBuffer(str2);
        char[] s2 = buffer.toString().toCharArray();

//        // 高低位对调
//        covertdata(s1, len1);
//        covertdata(s2, len2);

        System.out.println("乘数：" + str1);
        System.out.println("乘数：" + str2);
        multiply(s1, s1.length, s2, s2.length);

    }

    public static void covertdata(char data[], int len) {
        //高低位对调
        for (int i = 0; i < len / 2; i++) {
            data[i] += data[len - 1 - i];
            data[len - 1 - i] = (char) (data[i] - data[len - 1 - i]);
            data[i] = (char) (data[i] - data[len - 1 - i]);
        }
    }

    public static void multiply(char a[], int alen, char b[], int blen) {
        // 两数乘积位数不会超过乘数位数和+ 3位
        int csize = alen + blen + 3;
        // 开辟乘积数组
        int[] c = new int[csize];
        // 乘积数组填充0
        for (int ii = 0; ii < csize; ii++) {
            c[ii] = 0;
        }
        // 对齐逐位相乘
        for (int j = 0; j < blen; j++) {
            for (int i = 0; i < alen; i++) {
                c[i + j] += Integer.parseInt(String.valueOf(a[i])) * Integer.parseInt(String.valueOf(b[j]));
            }
        }
        int m = 0;
        // 进位处理
        for (m = 0; m < csize; m++) {
            int carry = c[m] / 10;
            c[m] = c[m] % 10;
            if (carry > 0)
                c[m + 1] += carry;
        }
        // 找到最高位
        for (m = csize - 1; m >= 0; ) {
            if (c[m] > 0)
                break;
            m--;
        }
        // 由最高位开始打印乘积
        System.out.print("乘积：");
        StringBuffer res = new StringBuffer();
        for (int n = m; n >= 0; n--) {
            res.append(c[n]);
        }
        System.out.println(res);
    }
}
