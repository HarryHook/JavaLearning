package com.algorithm.zuoshen;

public class MergeLinkedList {
    public static class LinkedNode {
        int val;
        LinkedNode next;

        public LinkedNode(int val) {

            this.val = val;
        }
    }

    public static LinkedNode mergeLinkedList(LinkedNode l1, LinkedNode l2) {
        LinkedNode tmp = new LinkedNode(0);
        LinkedNode pre = tmp;
        tmp.next = l1;
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                pre.next = l2;
                l2 = l2.next;
                if (l2 == null) {
                    pre.next.next = l1;
                }
            } else {
                pre.next = l1;
                l1 = l1.next;
            }

            pre = pre.next;
        }
        if (l2 != null) {
            pre.next = l2;
        }
        return tmp.next;
    }

    public static LinkedNode merge(LinkedNode list1, LinkedNode list2) {
        LinkedNode pre = new LinkedNode(-1);
        pre.next = list1;
        LinkedNode cur = list1;
        while (list2 != null && cur != null) {
            if (cur.val < list2.val) {
                pre = cur;
                cur = cur.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
                pre.next.next = cur;

            }
        }
        if (list2 != null) {
            pre.next = list2;
        }
        return pre.next.val < list1.val ? pre.next : list1;
    }

    public static void main(String[] args) {
        LinkedNode l1 = new LinkedNode(3);
//        l1.next = new LinkedNode(4);
//        l1.next.next = new LinkedNode(5);
        LinkedNode l2 = new LinkedNode(2);
//        l2.next = new LinkedNode(4);
//        l2.next.next = new LinkedNode(5);

        LinkedNode head = merge(l1, l2);
        LinkedNode p = head;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
