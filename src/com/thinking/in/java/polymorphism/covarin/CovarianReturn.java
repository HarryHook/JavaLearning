package com.thinking.in.java.polymorphism.covarin;

class Grain {
    public String toString() {
	return "Grain";
    }
}

class Wheat extends Grain {
    public String toString() {
	return "Wheat";
    }
}

class Mill {
    Grain process() {
	return new Grain();
    }
}

class WheatMill extends Mill {
    Wheat process() {
	return new Wheat();
    }
}

public class CovarianReturn {

    public static void main(String[] args) {
	Mill mill = new Mill();
	Grain g = mill.process();
	System.out.println(g);
	mill = new WheatMill();
	g = mill.process();
	System.out.println(g);
    }

}
