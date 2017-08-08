package com.designpatterns.strategy;

public class FlyRocketPowered implements FlyBehaviors {

    @Override
    public void fly() {
	System.out.println("我可以上天！");
    }

}
