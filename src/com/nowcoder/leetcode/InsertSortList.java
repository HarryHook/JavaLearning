package com.nowcoder.leetcode;


import com.nowcoder.swordForOffer.ListNode;

import java.util.List;

public class InsertSortList {
    public static ListNode insertSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode q;
        ListNode r;
        while (p != null && p.next != null) {
            if (p.val <= p.next.val) {
                p = p.next;
            } else {
                q = p.next;
                p.next = q.next;
                r = root;

                while (r.next.val <= q.val) {
                    r = r.next;
                }
                q.next = r.next;
                r.next = q;
            }
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(7);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode newList = insertSortList(head);
        print(newList);
    }

    public static void print(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }

    }
}
