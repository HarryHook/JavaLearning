package com.thinking.in.java.generics;

import java.util.ArrayList;
import java.util.List;

class Food {
}

class Fruit extends Food {
}

class Apple extends Fruit {

}

class RedApple extends Apple {
}

public class Covariant {
    public static void main(String[] args) {
        List<? extends Fruit> array = new ArrayList<Fruit>();

//        array.add(new Apple());  //编译出错
//        array.add(new RedApple());  //编译出错
        array.add(null);
        array.get(0);

        List<? super Fruit> array2 = new ArrayList<Fruit>();
        array2.add(new Apple());

    }
}