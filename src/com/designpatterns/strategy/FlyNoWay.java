package com.designpatterns.strategy;

public class FlyNoWay implements FlyBehaviors {

    @Override
    public void fly() {
	System.out.println("这种鸭子不会飞");
    }

}
