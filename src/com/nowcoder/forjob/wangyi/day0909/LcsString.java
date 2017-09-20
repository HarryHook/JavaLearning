package com.nowcoder.forjob.wangyi.day0909;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
作者：雨baby
链接：https://www.nowcoder.com/discuss/39219?type=0&order=0&pos=6&page=1
来源：牛客网

因为长度相同,并且也是合法的括号序列,所以正反括号数跟原来一样。
我们考虑在原序列上枚举一个字符,把这个插入到序列的某个位置去,其他序列相对顺序不变,
这样就可以让LCS最大,然后我们判断一下是否合法,丢进set去重就好了。
 */
public class LcsString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            String w = s.substring(0, i) + s.substring(i + 1);
            for (int j = 0; j < s.length() - 1; j++) {
                String u = w.substring(0, j) + s.charAt(i) + w.substring(j);
                int tmp = 0;
                for (int k = 0; k < s.length(); k++) {
                    tmp += (u.charAt(k) == '(' ? 1 : -1);
                    if (tmp < 0) {
                        break;
                    }
                }
                if (tmp >= 0) {
                    set.add(u);
                }
            }
        }
        System.out.println(set.size() - 1);

    }
}
