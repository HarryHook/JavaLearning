package com.nowcoder;

import java.util.HashMap;
import java.util.Map;


class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
	this.label = x;
    }
}

public class RandomList {
    public RandomListNode copyRandomList(RandomListNode head) {
	RandomListNode newhead = null;
	RandomListNode pre = head;
	RandomListNode temp = null;
	RandomListNode head2 = head;// 遍历指针
	Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
	if (head2 != null) {
	    // 创建头结点
	    temp = new RandomListNode(head2.label);
	    // 给头指针赋值
	    newhead = temp;
	    // 新旧节点建立映射关系
	    map.put(head2, temp);
	    // 给前驱指针赋值
	    pre = temp;
	    // 遍历原链表
	    head2 = head2.next;
	    while (head2 != null) {
		temp = new RandomListNode(head2.label);
		// 新旧节点建立映射关系
		map.put(head2, temp);
		pre.next = temp;
		pre = temp;
		head2 = head2.next;
	    }
	    // 给新建链表的随机指针赋值
	    RandomListNode head3 = newhead;
	    RandomListNode random = null;
	    while (head3 != null) {
		random = map.get(head.random);
		head3.random = random;
		head3 = head3.next;
		head = head.next;
	    }
	}
	return newhead;

    }

    public static void main(String[] args) {
	RandomListNode node1 = new RandomListNode(1);
	RandomListNode node2 = new RandomListNode(2);
	RandomListNode node3 = new RandomListNode(3);
	RandomListNode node4 = new RandomListNode(4);
	node1.next = node2;
	node1.random = node2;
	node2.next = node3;
	node2.random = null;
	node3.next = node4;
	node3.random = node1;
	node4.next = null;
	node4.random = node3;
	RandomList list = new RandomList();
	RandomListNode node = list.copyRandomList(node1);
	System.out.println(node.label);
	RandomListNode pListNode = node;
	while (pListNode != null) {
	    System.out.println(pListNode.label);
	    pListNode = pListNode.next;
	}
    }

}
