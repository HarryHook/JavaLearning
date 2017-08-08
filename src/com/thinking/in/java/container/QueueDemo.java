package com.thinking.in.java.container;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class QueueDemo {
    public static void printQ(Queue queue) {
	while (queue.peek() != null) {
	    System.out.print(queue.remove() + " ");
	}
	System.out.println();
    }

    public static void main(String[] args) {
	Queue<Integer> queue = new LinkedList<>();
	//peek和 element在不删除元素的情况系返回队首元素
	//peek()在队列为空时返回null, element()在队列为空时抛出异常NoSuchElementException
	System.out.println("peek " + queue.peek());
//	System.out.println("element " + queue.element());
	//poll和remove删除并返回队首元素
	//poll()在队列为空时返回null, remove()在队列为空时抛出异常NoSuchElementException
	System.out.println("poll " + queue.poll());
//	System.out.println("poll " + queue.remove());
	Random random = new Random(47);
	for (int i = 0; i < 10; i++) {
	    queue.offer(random.nextInt(i + 10));  //offer将元素插入队尾
	}
	printQ(queue);
	Queue<Character> qc = new LinkedList<>();
	for(char c: "HelloWorld".toCharArray()) {
	    qc.offer(c);
	}
	printQ(qc);
    }

}
