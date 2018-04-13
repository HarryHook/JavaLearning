package com.nowcoder.leetcode;

import com.nowcoder.swordForOffer.ListNode;

import java.util.ArrayList;

public class MergeKLists {


    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists.size() == 0)
            return null;
        if (lists.size() == 1)
            return lists.get(0);
        if (lists.size() == 2)
            return mergeTwoLists(lists.get(0), lists.get(1));
        ListNode tmp = null;
        tmp = mergeTwoLists(lists.get(0), lists.get(1));
        for (int i = 2; i < lists.size(); i++) {
            tmp = mergeTwoLists(tmp, lists.get(i));
        }
        return tmp;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1 == null ? l2 : l1;
        ListNode head = l1.val < l2.val ? l1 : l2;
        ListNode p1 = l1 == head ? l1 : l2;
        ListNode p2 = l1 == head ? l2 : l1;
        ListNode pre = null;
        while (p2 != null && p1 != null) {
            if (p1.val <= p2.val) {
                pre = p1;
                p1 = p1.next;
            } else {
                pre.next = p2;
                pre = p2;
                p2 = p2.next;
                pre.next = p1;
            }
        }
        pre.next = p1 == null ? p2 : p1;
        return head;
    }

    public static void main(String[] args) {

        ArrayList<ListNode> lists = new ArrayList<ListNode>();
        lists.add(new ListNode(3));
        lists.add(new ListNode(2));
        lists.add(new ListNode(2));
        lists.add(new ListNode(1));
        lists.add(new ListNode(1));
        lists.add(new ListNode(2));
        MergeKLists mergeKLists = new MergeKLists();
        ListNode node = mergeKLists.mergeKLists(lists);
        print(node);
    }

    private static void print(ListNode listNode) {

        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

}
