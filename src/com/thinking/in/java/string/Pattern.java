package com.thinking.in.java.string;

public class Pattern {
    public static void main(String[] args) {
        for (String pattern : new String[]{"Rudolph", "[rR]udolph", "[rR][aeiou][a-z].*", "R.*"}) {
            System.out.println("Rudolph".matches(pattern));
        }
    }
}
