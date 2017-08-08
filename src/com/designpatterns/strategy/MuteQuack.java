package com.designpatterns.strategy;

public class MuteQuack implements QuackBehaviors{

    @Override
    public void quack() {
	System.out.println("不会叫");
    }

}
