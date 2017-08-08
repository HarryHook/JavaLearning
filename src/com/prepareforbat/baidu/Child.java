package com.prepareforbat.baidu;

class Person {
    public String name = "person";
    int age;
}

public class Child extends Person {
    public String grade;
    public static void main(String[] args) {
	Child p = new Child();
	System.out.println(p.name);
    }
}