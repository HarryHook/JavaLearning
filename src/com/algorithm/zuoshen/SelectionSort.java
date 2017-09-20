package com.algorithm.zuoshen;


public class SelectionSort {
    public static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static Node selectionSort(Node head) {
        Node tail = null;   //排序部分尾部
        Node cur = head;    //未排序部分头部
        Node smallPre = null;   //最近小节点的前一个节点
        Node small = null;  //最小节点
        while (cur != null) {
            small = cur;
            smallPre = getSmallPreNode(cur);
            if (smallPre != null) { //在未排序链表中删除最小节点
                small = smallPre.next;
                smallPre.next = small.next;
            }
            if (cur == small) {
                cur = cur.next;
            }
            if (tail == null) { //第一次将head指向链表最小节点
                head = small;
            } else {
                tail.next = small;  //之后将链表最小节点插入新的链表
            }
            tail = small;   //最小节点插入尾节点
        }
        return head;
    }

    public static Node getSmallPreNode(Node head) {
        Node smallPre = null;
        Node small = head;
        Node pre = head;
        Node cur = head.next;
        while (cur != null) {
            if (cur.val < small.val) {
                smallPre = pre;
                small = cur;
            }
            pre = cur;
            cur = cur.next;
        }
        return smallPre;
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(5);
        head.next.next = new Node(3);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(1);

        head = selectionSort(head);

        Node p = head;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }

    }
}
