package com.algorithm.laozizhu;

public class LowerToUpper {
   public static void main(String[] args) {
       String s1 = "abcdef";
       char[] chars = s1.toCharArray();
       int MSMF = 0XFFDF;
       int [] arr = new int[s1.length()];
       for(int i=0; i<chars.length; i++) {
          arr[i] = chars[i] & MSMF;
           System.out.println((char)arr[i]);

       }
       char c = 'a';

   }
}
