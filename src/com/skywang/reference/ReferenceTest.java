package com.skywang.reference;


import java.util.Date;

//对java.util.Date类进行了扩展，并重写了finalize()和toString()方法
class MyDate extends Date {
    public MyDate() {
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("obj [Date: " + this.getTime() + "] is gc");
    }

    @Override
    public String toString() {
        return "Date: " + this.getTime();
    }
}

//定义一个方法drainMemory()：消耗大量内存，以此来引发JVM回收内存
public class ReferenceTest {
    public ReferenceTest() {
    }

    public static void drainMemory() {
        String[] array = new String[1024 * 10];
        for (int i = 0; i < 1024 * 10; i++) {
            for (int j = 'a'; j < 'z'; j++) {
                array[i] += (char) j;
            }
        }
    }

    public static void main(String[] args) {
        /*1.清除对象
        MyDate date = new MyDate();
        date = null;
        <无任何输出> date虽然设为null，但由于JVM没有执行垃圾回收操作，MyDate的finalize()方法没有被运行。
        */
        /*2.显示调用垃圾回收
        MyDate date = new MyDate();
        date = null;
        System.gc();
        输出:obj [Date: 1510111085464] is gc,
        调用了System.gc()，使JVM运行垃圾回收，MyDate的finalize()方法被运行。
        */
        /*3.隐式调用垃圾回收
        MyDate date = new MyDate();
        date = null;
        ReferenceTest.drainMemory();
        输出:obj [Date: 1510111150136] is gc
        虽然没有显式调用垃圾回收方法System.gc()，但是由于运行了耗费大量内存的方法，触发JVM进行垃圾回收。
         */
        /*4.强引用
         MyDate date = new MyDate();
         System.gc();
         <无任何输出> 即使显式调用了垃圾回收，但是用于date是强引用，date没有被回收
         */
        /*5.软引用
        SoftReference ref = new SoftReference(new MyDate());
        ReferenceTest.drainMemory();
        <无任何输出>
        虽然ReferenceTest.drainMemory()占用了一些内存，但还没有让JVM觉得内存不够用的程度，所以软引用关联的对象不会被回收，
        如果在运行时设置JVM参数 -Xmx，限制最大堆内存，就能达到效果。
         */
        /*6.弱引用
        WeakReference ref = new WeakReference(new MyDate());
        System.gc();
        obj [Date: 1510111350596] is gc ,JVM垃圾回收运行时，弱引用被终止.
        等价于
        MyDate date = new MyDate();
        // 垃圾回收
        If(JVM.内存不足()) {
            date = null;
            System.gc();
        }
         */
        /*7.虚引用
        ReferenceQueue queue = new ReferenceQueue();
        PhantomReference ref = new PhantomReference(new MyDate(), queue);
        System.gc();
        obj [Date: 1510111460392] is gc，虚引用，在实例化后，就被终止了。
        */
    }
}


