package com.designpatterns.strategy;

public abstract class Duck {

    FlyBehaviors flyBehaviors;
    QuackBehaviors quackBehaviors;

    public void performQuack() {
	quackBehaviors.quack();
    }

    public void performFly() {
	flyBehaviors.fly();
    }
    public void setFlyBehavior(FlyBehaviors flyBehaviors) {
	this.flyBehaviors = flyBehaviors;
    }
    public void setQuackBehavior(QuackBehaviors quackBehaviors) {
	this.quackBehaviors = quackBehaviors;
    }
    public abstract void display();

    public void swim() {
	System.out.println("所有鸭子都会游泳！");
    }
}
