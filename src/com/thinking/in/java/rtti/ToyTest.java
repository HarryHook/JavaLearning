package com.thinking.in.java.rtti;

interface HasBatteried{}
interface Waterproof{}
interface Shoots{}
class Toy {
    Toy(){}
    Toy(int i) {}
}
class FancyToy extends Toy implements HasBatteried, Waterproof, Shoots {
    FancyToy() {
        super(1);
    }
}
public class ToyTest {
    public static void printInfo(Class cc) {
        print("Class name: " + cc.getName() + " is interface? " + "["+ cc.isInterface() + "]");
        print("Simple name: " + cc.getSimpleName());    //不包含包名的類名
        print("Canonical name: " + cc.getCanonicalName());   //包含包名的全限定類
    }
    public static void print(String s) {
        System.out.println(s);
    }
    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("com.thinking.in.java.rtti.FancyToy");
        }catch (ClassNotFoundException e){
            print("Can't find FacnyToy");
            System.exit(1);
        }
        printInfo(c);
        for(Class face: c.getInterfaces()) {
            printInfo(face);
        }
        Class up = c.getSuperclass();
        Object obj = null;
        try{
            obj = up.newInstance();
        }catch(InstantiationException e) {
            print("Can't instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            print("can not access");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
}
