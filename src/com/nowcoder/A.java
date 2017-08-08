package com.nowcoder;

public class A {
    int f(int m, int n) {
	return m + n;
    }

    static int g(int n) {

	return n * n;
    }
    public static void main(String[] args) {
   	A base = new B();
   	System.out.println(base.f(10, 8));
   	System.out.println(base.g(3));
       }
}

class B extends A{
    public int f(int m, int n) {
	int x = super.f(m, n);
	return x + m * n;
    }

    static int g(int n) {
	int m = A.g(n);
	return m +n;
    }
   
}