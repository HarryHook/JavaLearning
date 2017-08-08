package com.thinking.in.java.innerclass.controller;

import com.thinking.in.java.innerclass.controller.WithInner.Inner;

class WithInner {
    class Inner {
	
    }
}
public class InheritInner extends Inner {
    public InheritInner(WithInner wi) {
	wi.super();
    }
    public static void main(String[] args) {
	WithInner wi = new WithInner();
	InheritInner ii = new InheritInner(wi);
    }

}
