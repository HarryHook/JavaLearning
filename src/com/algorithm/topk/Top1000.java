package com.algorithm.topk;

import java.util.Random;

public class Top1000 {
    static Random random = new Random();

    static class Node {
        int val;
        Node pre;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    static class Result {
        Node head;
        Node tail;
        int length;

        Result(int length) {
            this.length = length;
            this.head = new Node(Integer.MAX_VALUE);
            this.tail = new Node(Integer.MAX_VALUE);
            Node tmp = head;
            for (; this.length > 2; this.length--) {
                Node t = new Node(Integer.MAX_VALUE);
                tmp.next = t;
                t.pre = tmp;
                tmp = t;
            }
            tmp.next = tail;
            tail.pre = tmp;
        }
    }

    /*
    头到尾，依次从小到大
     */
    public static void main(String[] args) {
        Result result = new Result(100);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            int tmp = random.nextInt(Integer.MAX_VALUE);
            /*
                1.如果当前值比头结点小，替换头结点
                2.比尾节点小，需要遍历链表找出比当前节点大的位置
             */
            if (tmp < result.head.val) {
                Node tmpNode = new Node(tmp);
                tmpNode.next = result.head;
                result.head.pre = tmpNode;
                result.head = tmpNode;
                result.tail = result.tail.pre;
                result.tail.next = null;
            } else if (tmp < result.tail.val) {
                Node curNode = result.tail;
                while (curNode != null) {
                    if (curNode.val == tmp) {  //如果和某个节点相等，无需操作
                        break;
                    } else if (curNode.val < tmp) {
                        Node tmpNode = new Node(tmp);
                        Node nextNode = curNode.next;
                        curNode.next = tmpNode;
                        tmpNode.next = nextNode;
                        tmpNode.pre = curNode;
                        nextNode.pre = tmpNode;
                        result.tail = result.tail.pre;
                        result.tail.next = null;
                        break;
                    }
                    curNode = curNode.pre; // 不停向前遍历节点
                }
            }
        }
        long end = System.currentTimeMillis();
        Node node = result.head;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println("耗时： " + (end - start) + "ms");
    }
}
