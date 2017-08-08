package com.JavaCoreLearning;

abstract public class Person {
    public Person(String n) {
	name = n;
    }
    public abstract String getDiscription();
    public String getName() {
	return name;
    }
    private String name;
}
