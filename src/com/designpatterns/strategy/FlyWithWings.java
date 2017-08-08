package com.designpatterns.strategy;

public class FlyWithWings implements FlyBehaviors {

    @Override
    public void fly() {
	System.out.println("鸭子可以飞");
    }

}
