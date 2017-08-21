package com.nowcoder.forjob.third;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main2 {  
    public static void main(String args[]){ 
	Scanner sc = new Scanner(System.in);
        String s = sc.nextLine(); //待测试的字符串
        int count = 0;
        Map<Character, Integer> result = getCharMaps(s);
//        System.out.println(result);//打印出字符串中各字符出现的次数！
        for (Integer value : result.values()) {  
            if(value % 2 == 1) {
        	count++;
            }
        }  
        System.out.println(count);
        sc.close();
        
   } 
    public static Map<Character, Integer> getCharMaps(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            Integer count = map.get(c);
            map.put(c, count == null ? 1 : count + 1);
        }
        return map;
        
    }
   
}