package com.thinking.in.java.rtti;

public class Pet {
    private String name;

    public Pet(String name) {
        this.name = name;
    }

    public Pet() {
    }
}

class Dog extends Pet {
    Dog(String name) {
        super(name);
    }

    Dog() {
        super();
    }
}

class Mutt extends Dog {
    Mutt(String name) {
        super(name);
    }

    Mutt() {
        super();
    }
}

class Pug extends Dog {
    Pug(String name) {
        super(name);
    }

    Pug() {
        super();
    }
}

class Cat extends Pet {
    Cat(String name) {
        super(name);
    }

    Cat() {
        super();
    }
}

class Manx extends Cat {
    Manx(String name) {
        super(name);
    }

    Manx() {
        super();
    }
}

class Cymric extends Manx {
    Cymric(String name) {
        super(name);
    }

    Cymric() {
        super();
    }
}