package com.thinking.in.java.generics;

interface Generator<T> {
    T next();
}

public class Coffee {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}

class Latte extends Coffee {
}

class Moncha extends Coffee {
}

class Cappuccino extends Coffee {
}

class Americano extends Coffee {
}

class Breve extends Coffee {
}
