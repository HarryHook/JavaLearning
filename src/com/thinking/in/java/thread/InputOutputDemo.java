package com.thinking.in.java.thread;


public class InputOutputDemo {
    public static void main(String[] args) {
        Student stu = new Student();
        Input in = new Input(stu);
        Output out = new Output(stu);
        Thread t1 = new Thread(in);  //存入学生信息的线程
        Thread t2 = new Thread(out); //打印学生信息的线程
        t1.start();
        t2.start();
    }

}

class Input implements Runnable {
    private Student stu;
    private boolean flag = false;

    public Input(Student stu) {
        this.stu = stu;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (stu) {
                if (flag) {
                    stu.set("woman", "lucy");
                    flag = false;
                } else {
                    stu.set("man", "lizhinan");
                    flag = true;
                }
            }
        }
    }
}

class Output implements Runnable {
    private Student stu;

    public Output(Student stu) {
        this.stu = stu;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10000; i++) {
            synchronized (stu) {
                stu.out();
            }
        }
    }
}

class Student {
    private String name;
    private String sex;
    private boolean flag;  //设置标志，默认为false

    public synchronized void set(String sex, String name) {
        if (flag)
            try {
                this.wait();
            } catch (Exception e) {
            }
        ;
        this.name = name;
        this.sex = sex;
        flag = true;
        this.notify();
    }

    public synchronized void out() {
        if (!flag) {
            try {
                this.wait();
            } catch (Exception e) {
            }
            ;
        } else {
            System.out.println(name + "-----" + sex);
            flag = false;
            this.notify();
        }
    }
}