package com.nowcoder.swordForOffer;

import java.util.ArrayList;
import java.util.Stack;

public class PrintListFromTailToHead {
    ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead_v1(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead_v1(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }

    public ArrayList<Integer> printListFromTailToHead_v2(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ListNode p = listNode;
        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        head.next = n1;
        ListNode n2 = new ListNode(3);
        n1.next = n2;
        ListNode n3 = new ListNode(4);
        n2.next = n3;
        ListNode n4 = new ListNode(5);
        n3.next = n4;
        ListNode n5 = new ListNode(6);
        n4.next = n5;

        PrintListFromTailToHead printLinkedList = new PrintListFromTailToHead();
        ArrayList<Integer> arrayList = printLinkedList.printListFromTailToHead_v2(head);

        for (int num : arrayList) {
            System.out.print(num + " ");
        }

    }
}
