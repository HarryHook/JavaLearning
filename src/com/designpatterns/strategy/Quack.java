package com.designpatterns.strategy;

public class Quack implements QuackBehaviors {

    @Override
    public void quack() {
	System.out.println("呱呱叫");

    }

}
