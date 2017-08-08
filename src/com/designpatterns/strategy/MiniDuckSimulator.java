package com.designpatterns.strategy;

public class MiniDuckSimulator {

    public static void main(String[] args) {
	Duck mallord = new MallardDuck();
	mallord.performQuack();
	mallord.performFly();
	mallord.setFlyBehavior(new FlyRocketPowered());
	mallord.performFly();
	mallord.display();
	mallord.swim();
    }

}
