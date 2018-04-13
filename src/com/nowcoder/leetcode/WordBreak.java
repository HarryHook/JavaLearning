package com.nowcoder.leetcode;

import com.nowcoder.forjob.lianjia.S;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    private static ArrayList<String> results = new ArrayList<String>();

    public static List<String> wordBreak(String s, Set<String> dict) {

        if (hasResult(s, dict)) {
            dfs(s, dict, "");
        }
        return results;
    }


    /*
    判断字符串 s 是否可以由 dict 中的元素组成
    举例 leetcode 可以由 dict = ["leet", "code"]组成
    arrays[0, 4, 8] = true;
     */
    private static boolean hasResult(String s, Set<String> dict) {
        int len = s.length();
        boolean[] arrays = new boolean[len + 1];
        arrays[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (arrays[j] && dict.contains(s.substring(j, i))) {
                    arrays[i] = true;
                    break;
                }
            }
        }
        return arrays[len];
    }

    /*
    s = "catsanddog",
    dict = ["cat", "cats", "and", "sand", "dog"].
    当检测到cat是属于dict中的话，剩下的子串, "sanddog" 可能可以组成一个解。
    把“cat”加入到一个解字符串(currentStr = "" )中，
    再去递归 "sanddog"这个字符串，当递归调用的字符串 s="" （即length == 0）递归结束时，
    证明这个解是成立的把 currentStr加入到 result中
     */
    private static void dfs(String subStr, Set<String> dict, String curStr) {
         /*递归结束的条件（解成立的条件）*/
        if (subStr.length() == 0) {
            results.add(curStr);
        }
        for (int i = 0; i <= subStr.length(); i++) {
            String sub = subStr.substring(0, i);
            /*包含这个子串的话，这个子串和剩余的子串有可能构成一组的解*/
            if (dict.contains(sub)) {
                //这个值是为了等下递归结束可以恢复currentStr的值
                int subLen = curStr.length();
                //如果不是解中的第一个单词，那么要在前加上一个空格 " "
                if (!curStr.equals("")){
                    curStr += " ";
                }
                //加入到一个解的字符串中
                curStr += sub;
                //递归
                dfs(subStr.substring(i),dict,curStr);
                //恢复currentStr，继续下一个解的求解
                curStr = curStr.substring(0,subLen);
            }
        }
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
//        set.add("cat");
//        set.add("cats");
//        set.add("and");
//        set.add("sand");
//        set.add("dog");
        set.add("b");
        System.out.println(wordBreak("a", set));
    }
}
