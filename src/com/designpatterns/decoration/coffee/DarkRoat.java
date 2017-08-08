package com.designpatterns.decoration.coffee;

public class DarkRoat extends Beverage {

    public DarkRoat() {
	description = "DarkRoat";
    }

    @Override
    public double cost() {
	
	return 0.99;
    }

}
