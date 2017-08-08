package com.nowcoder;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
	val = x;
	next = null;
    }
}

public class LinkedListUtil {
    /*
     * 判断当前链表是否有环存在，不借助额外的数据结构
     */
    public boolean hasCycle(ListNode head) {
	if (head == null) {
	    return false;
	}
	ListNode slow = head;
	ListNode fast = head;
	while (fast != null && fast.next != null) {
	    slow = slow.next;
	    fast = fast.next.next;
	    if (slow == fast) {
		return true;
	    }
	}
	return false;
    }

    /*
     * 实现:检查当前链表是否是有环存在，不是返回null，是返回环开始的节点
     */
    public ListNode detectCycle(ListNode head) {

	if (head == null) {
	    return null;
	}
	ListNode slow = head;
	ListNode fast = head;
	while (fast != null && fast.next != null) {
	    slow = slow.next;
	    fast = fast.next.next;
	    if (slow == fast) { // 快慢指针相遇， 记录下相遇点，并将快指针指向头，并一步一步走
		fast = head;
		while (fast != slow) {
		    fast = fast.next;
		    slow = slow.next;
		}
		return slow;
	    }
	}
	return null;
    }

    /*
     * 实现：1->2->3->4->...n重排序为1->n->2->n-1->3->n-2...
     */
    public void reorderList(ListNode head) {
	if (head == null || head.next == null) {
	    return;
	}
	ListNode p = head;

	int n = 0;
	while (p != null) {
	    p = p.next;
	    n++;
	}
	int i = 0;
	p = head;
	ListNode head2 = null;
	while (i < n / 2) {

	    p = p.next;
	    i++;
	}
	head2 = p.next;
	p.next = null;
	p = head;

	while (head2 != null) {
	    ListNode p2 = head2;
	    ListNode q2 = null;
	    while (p2.next != null) {
		q2 = p2;
		p2 = p2.next;
	    }
	    p2.next = p.next;
	    p.next = p2;
	    p = p2.next;
	    if (q2 != null) {
		q2.next = null;
	    } else {
		head2 = null;
	    }

	}

    }

    public static void main(String[] args) {
	ListNode head = new ListNode(1);
	head.next = new ListNode(2);
	head.next.next = new ListNode(3);
	head.next.next.next = new ListNode(4);
	head.next.next.next.next = new ListNode(5);
	head.next.next.next.next.next = new ListNode(6);
	// head.next.next.next.next.next.next = head;
	head.next.next.next.next.next.next = new ListNode(7);
	LinkedListUtil list = new LinkedListUtil();
	// list.reorderList(head);
	System.out.println(list.hasCycle(head));
	/*
	 * ListNode p = head; int i = 0; while (p != null) {
	 * System.out.println(p.val); p = p.next; i++; }
	 */
    }

}
