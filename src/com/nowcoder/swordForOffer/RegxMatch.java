package com.nowcoder.swordForOffer;

public class RegxMatch {
    //.代表任意字符， *代表出现任意次，包含零次，比如 b* 可以等价于 " ", 或者 "bb"
    //字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
    public static boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) return false;
        int strIndex = 0;
        int patternIndex = 0;

        return matchCore(str, strIndex, pattern, patternIndex);
    }

    private static boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        //同时结束，完全匹配
        if (str.length == strIndex && pattern.length == patternIndex) {
            return true;
        }
        //pattern结尾，但字符串还到尾部
        if (str.length != strIndex && pattern.length == patternIndex) {
            return false;
        }

        //模式的第二个字符为 '*' ,如果字符串与模式的第一个字符相等，有三种情况
        //                      如果字符串与模式的第一个字符不相等,返回false
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex])
                    || (pattern[patternIndex] == '.' && strIndex != str.length)) {
                return matchCore(str, strIndex, pattern, patternIndex + 2)
                        || matchCore(str, strIndex + 1, pattern, patternIndex + 2)
                        || matchCore(str, strIndex + 1, pattern, patternIndex);
            } else {
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }
        //模式的第二个字符不是 '*'
        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex])
                || (pattern[patternIndex] == '.' && strIndex != str.length)) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        char[] str = "aaa".toCharArray();
        char[] pattern = "ab*a*c*a".toCharArray();

        System.out.println(match(str, pattern));
    }

}
