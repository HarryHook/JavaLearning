package com.nowcoder;

class SimInt {
    int value;

    public SimInt(int i) {
	value = i;
    }
}

public class Test2 {
    public static void change1(SimInt s1) {
	s1 = new SimInt(1);
    }

    public static void change2(SimInt s1) {
	s1.value = 3;
    }
    public static void main(String[] args) {
	SimInt si1=new SimInt(1);
        System.out.println(si1.value);//输出1
        change1(si1);
        System.out.println(si1.value);//输出1
        change2(si1);
        System.out.println(si1.value);//输出1


	Integer var1=new Integer(1);
	Integer var2=var1;
	doSomething(var2);
	System.out.println(var1.intValue());
	System.out.print(var1==var2);

    }
    public static void doSomething(Integer integer){
	integer=new Integer(2);
	}
}
