package com.designpatterns.strategy;

public class MallardDuck extends Duck {
    public MallardDuck() {
	quackBehaviors = new Quack();
	flyBehaviors = new FlyWithWings();
    }
    public void display() {
	System.out.println("我是一只红头鸭");
    }
}
