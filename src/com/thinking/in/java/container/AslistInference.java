package com.thinking.in.java.container;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Snow {
}

class Crusty extends Snow {
}

class Slush extends Snow {
}

class Power extends Snow {
}

class Heavy extends Power {
}

class Light extends Power {
}

public class AslistInference {

    public static void main(String[] args) {
	List<Snow> snow1 = Arrays.asList(new Crusty(), new Power(), new Slush());
	List<Snow> snow2 = Arrays.asList(new Light(), new Heavy());
	List<Snow> snow3 = new ArrayList<>();
	Collections.addAll(snow3, new Light(), new Heavy());
	List<Snow> snow4 = Arrays.<Snow>asList(new Light(), new Heavy());
    }

}
