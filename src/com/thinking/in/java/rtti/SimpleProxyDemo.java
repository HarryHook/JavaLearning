package com.thinking.in.java.rtti;

interface  Interface {
    void doSomething();
    void somethingElse(String args);
}
class RealObject implements  Interface {

    @Override
    public void doSomething() {
        System.out.println("doSomething in realObject");
    }

    @Override
    public void somethingElse(String args) {
        System.out.println("somethingElse in realObject " + args);
    }
}

class SimpleProxy implements Interface {
    private Interface proxied;
    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        System.out.println("doSomething in SimpleProxy");
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String args) {
        System.out.println("somethingElse in SimpleProxy " + args);
        proxied.somethingElse(args);
    }
}
public class SimpleProxyDemo {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }
    public static void main(String[] args) {
        consumer((new RealObject()));
        consumer(new SimpleProxy(new RealObject()));
    }
}
