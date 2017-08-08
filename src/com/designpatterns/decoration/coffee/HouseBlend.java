
package com.designpatterns.decoration.coffee;

/**
 * @author Harry
 *
 */
public class HouseBlend extends Beverage {
    public HouseBlend() {
	description = "HouseBlend";
    }

    @Override
    public double cost() {

	return 0.89;
    }

}
