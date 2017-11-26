package com.nowcoder.swordForOffer;

/*
判断字符串是否表示数值（包括整数和小数）。
例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class IsNumeric {
    /*
    思路：第一位可以为'+','-',数字
          小数点只能出现一次
          e可以出现多次
          e后边可以出现正负号
          e可以在（1,a.length-1)之间
          其余位为数字
     */
    public boolean isNumeric(String s) {
        return s.matches("[+-]?[0-9]*(\\.[0-9]*)?([eE][+-]?[0-9]+)?");
    }

    public boolean isNumeric1(String s) {
        try {
            double b = Double.parseDouble(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
