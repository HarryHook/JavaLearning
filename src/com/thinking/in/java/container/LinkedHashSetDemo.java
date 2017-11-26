package com.thinking.in.java.container;

import java.util.LinkedHashSet;

public class LinkedHashSetDemo {
    public static void main(String[] args) {
        LinkedHashSet<String> lhset = new LinkedHashSet<>();
        lhset.add("zhnsgan");
        lhset.add("lisi");
        lhset.add("wangwu");
        System.out.println(lhset.contains("lisi"));
        String[] strings = {"Tom", "cat", "Jim", "Kim"};

    }
}
