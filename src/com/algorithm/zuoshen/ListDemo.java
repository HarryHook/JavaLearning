package com.algorithm.zuoshen;

public class ListDemo {
    /*
    复制带有随机节点的链表
     */
    public static RandomListNode clone(RandomListNode pHead) {
        if (pHead == null) return null;
        cloneNodes(pHead);
        connectRandomNodes(pHead);
        return reConnectNodes(pHead);
    }

    private static void cloneNodes(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        while (pNode != null) {
            RandomListNode pCloned = new RandomListNode(pNode.label);
            pCloned.next = pNode.next;
            pCloned.random = null;
            pNode.next = pCloned;
            pNode = pCloned.next;
        }
    }

    private static void connectRandomNodes(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        while (pNode != null) {
            System.out.println(pNode.label);
            RandomListNode pCloned = pNode.next;
            if (pNode.random != null) {
                pCloned.random = pNode.random.next;
            }
            pNode = pCloned.next;

        }
    }

    private static RandomListNode reConnectNodes(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        RandomListNode pCloned = null;
        RandomListNode cloneHead = null;

        if (pNode != null) {
            pCloned = cloneHead = pNode.next;
            pNode.next = pCloned.next;
            pNode = pCloned.next;
        }
        while (pNode != null) {
            pCloned.next = pNode.next;
            pCloned = pCloned.next;
            pNode.next = pCloned.next;
            pNode = pNode.next;
        }
        return cloneHead;
    }

    /*
    求链表的中间节点，思路，快慢指针，快指针指到尾节点时，慢指针指向中间节点
     */
    public static ListNode getMiddleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;

        //while (fast != null && fast.next != null ) { //求偶数情况下的后一个节点
        while (fast.next.next != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        return slow;
    }
    /*
    单链表的转置，分别用递归和非递归实现
     */

    public static ListNode reverseByLoop(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode p3 = null;
        while (p2 != null) {
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        head.next = null;
        head = p1;
        return head;
        /*
        ListNode pre = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
         */
    }

    public static ListNode reverseByRecursion(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseByRecursion(head.next);
        head.next.next = head;    //逆置后一个节点
        head.next = null;         //将前后节点断开
        return newHead;

    }

    /*
    O（1）时间复杂度下删除给定的节点
     */
    public static ListNode removeRandomNode(ListNode head, ListNode toBeDeleted) {
        if (head == null || toBeDeleted == null) {
            return null;
        }
        if (toBeDeleted == head) { //头节点
            return head.next;
        } else if (toBeDeleted.next == null) { //尾节点
            ListNode p = head;
            while (p.next.next != null) { //中间节点
                p = p.next;
            }
            p.next = null;
        } else {
            toBeDeleted.val = toBeDeleted.next.val;
            toBeDeleted.next = toBeDeleted.next.next;
        }

        return head;
    }

    /*
    一次遍历删除倒数第n个节点
     */
    public static ListNode removeLastNthNode(ListNode head, int n) {
        if (head == null || n < 0) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        //if remove the first node
        if (fast == null) {
            return head.next;
        }
        //快指针指向尾节点，慢指针指向待删除节点的前一个节点
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    /*
    判断链表是否有环,如果有环找到环的入口
     */
    public static boolean hasCircle(ListNode head, ListNode curNode) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                curNode = slow;
                return true;
            }
        }
        return false;
    }

    /*
    找到环形链表的入口
    头节点到环的入口距离为a， slow到相遇的节点为b， slow走过的路径为a+b
    fast指针走过的路径是slow的2倍，相遇时已经在环内走了K圈
    a+b = n
    a+b + K*L = 2n 推算出 a+b = K*L = n
    所以继续让fast从头一步一步走，slow从相遇点继续一步一步走，slow与fast再次相遇时为环的入口节点
     */
    public static ListNode findLoopPort(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast != slow) return null; //不存在环
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    /*
    判断两个链表是否相交
    思路1：将链表2与尾部相连，判断链表1是循环链表，有环则相交，没有不相交
    思路2：判断两个链表的尾指针是否相等
     */
    public static boolean isIntersect(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) return false;
        ListNode p1 = head1;
        ListNode p2 = head2;
        while (p1.next != null) {
            p1 = p1.next;
        }
        while (p2.next != null) {
            p2 = p2.next;
        }
        if (p1 == p2) return true;
        return false;
    }

    /*
    判断带环的两个链表是否相交
    思路：找到环上相交的元素， 然后判断另一个环内相交元素是否在该环上
     */
    public static boolean isIntersectWithLoop(ListNode head1, ListNode head2) {
        ListNode cirNode1 = null;
        ListNode cirNode2 = null;
        if (!hasCircle(head1, cirNode1)) return false;
        if (!hasCircle(head2, cirNode2)) return false;
        ListNode tmp = cirNode2.next;
        while (tmp != cirNode2) {
            if (tmp == cirNode1) {
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

    /*
    链表相交的第一个公共节点
    思路：1.先判断是否相交
    2.链表1的长度为l1, 链表2的长度为l2,较长的链表先跑|l1-l2|，然后节点相等时即相交节点
     */
    public static ListNode findIntersectNode(ListNode head1, ListNode head2) {
        int length1 = listLength(head1);
        int length2 = listLength(head2);
        ListNode p1 = head1;
        ListNode p2 = head2;
        if (length1 > length1) {
            for (int i = 0; i < length1 - length2; i++)
                p1 = p1.next;
        } else {
            for (int i = 0; i < length2 - length1; i++)
                p2 = p2.next;
        }
        while (p1 != null) {
            if (p1 == p2) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;

    }

    public static int listLength(ListNode head) {
        ListNode p = head;
        int length = 0;
        while (p != null) {
            length++;
            p = p.next;
        }
        return length;
    }

    public static void main(String[] args) {
//        ListNode head = init(4);
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(6);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n2;

        System.out.println(hasCircle(head, new ListNode(-1)));
        System.out.println(findLoopPort(head).val);
        int[] array = new int[10];
        for(int i=1; i<10; i++) {
        }
        // head = removeLastNthNode(head, 5);
        // print(head);
        // head = removeRandomNode(head, n1);
        //print(head);
//        //head = reverseByRecursion(head);
//        print(head);
//        System.out.println();
//        ListNode middleNode = getMiddleNode(head);
//        System.out.println(middleNode.val);
        /*
        RandomListNode n1 = new RandomListNode(1);
        RandomListNode n2 = new RandomListNode(2);
        RandomListNode n3 = new RandomListNode(3);
        RandomListNode n4 = new RandomListNode(4);
        RandomListNode n5 = new RandomListNode(5);
        n1.next = n2;
        n1.random = n3;
        n3.random = n5;
        n4.random = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        clone(n1);
        print(n1);
        */

    }

    public static ListNode init(int num) {
        ListNode node = new ListNode(1, null);
        ListNode cur = null;
        ListNode temp = null;
        for (int i = 2; i <= num; i++) {
            temp = new ListNode(i, null);
            if (i == 2) {
                node.next = temp;
            } else {
                cur.next = temp;
            }
            cur = temp;
        }
        return node;
    }

    public static void print(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }

    public static void print(RandomListNode head) {
        RandomListNode p = head;
        while (p != null) {
            System.out.print(p.label + " ");
            if (p.random != null) {
                System.out.println("Random " + p.random.label + " ");
            }
            p = p.next;
        }
    }
}
