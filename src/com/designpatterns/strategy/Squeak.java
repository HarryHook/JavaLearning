package com.designpatterns.strategy;

public class Squeak implements QuackBehaviors {

    @Override
    public void quack() {
	System.out.println("吱吱叫");

    }

}
