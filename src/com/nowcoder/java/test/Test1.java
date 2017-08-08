package com.nowcoder.java.test;


public class Test1 {

    public static void main(String[] args) {
	Object object = new Object() {
	    public boolean equals(Object obj) {
		return true;
	    }
	};
	System.out.println(object.equals("abc"));
    }

}
