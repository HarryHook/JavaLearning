package com.JavaCoreLearning;

public class Student extends Person {

    public Student(String n, String m) {
	super(n);
	major = m;
    }

    @Override
    public String getDiscription() {
	return "a student majoring in " + major;
    }
    private String major;

}
