package com.nowcoder;

/*
 * 
new B()
执行B的构造函数，第一行是super(5);
此时执行的是A的构造函数，A的构造函数调用的是setValue()方法，由于B重写了A的这个方法，
所以！！！执行的是B的 setValue()方法。
即传入的参数是2*5=10
此时，因为super，所以调用的是父类的 setValue()方法，即value=10
第一行执行完毕。
第二行是 setValue(getValue()-3);
B没有getValue()方法，故执行父类的此方法，
try返回的是value=10+1=11，保存在临时栈中
finally中调用this的方法，这个this指的是B的对象，又重写，故就是B的 setValue()方法
value=2*11=22，第一个打印到屏幕上的数字
接下来参数 getValue()-3=11-3=8
传入B的 setValue()方法
此时value=2*8=16
至此，new B()执行结束
②
new B(). getValue()
B没有 getValue()，故执行A的 getValue()
try返回16+1=17，保存到临时栈中
finally调用B的 setValue()方法
value=17*2=34，第二个打印到屏幕上面的数字
最后主函数打印返回值，也就是try保存到临时栈的17
1
答案就是：22,34,17
 */
public class Test1 {

    public static void main(String[] args) {
	System.out.println(new B().getValue());
    }

    static class A {
	protected int value;

	public A() {

	}

	public A(int v) {
	    setValue(v);
	}

	public void setValue(int value) {
	    this.value = value;
	}

	public int getValue() {
	    try {
		value++;
		return value;
	    } finally {
		this.setValue(value);
		System.out.println(value);
	    }
	}
    }

    static class B extends A {
	public B() {
	    super(5);
	    setValue(getValue() - 3);
	}

	public void setValue(int value) {
	    super.setValue(value * 2);
	}
    }
}
