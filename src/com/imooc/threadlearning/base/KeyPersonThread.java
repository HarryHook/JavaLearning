package com.imooc.threadlearning.base;

public class KeyPersonThread extends Thread {
    @Override
    public void run() {
	System.out.println(Thread.currentThread().getName() + "开始战斗");
	for(int i=0; i<10; i++) {
	    System.out.println(Thread.currentThread().getName() + " 击杀随军");
	}
	System.out.println("结束战斗");
    }
}
