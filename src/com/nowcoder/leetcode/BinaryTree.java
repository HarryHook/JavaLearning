package com.nowcoder.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    static class TreeLinkNode {
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;
        int val;

        public TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return listAll;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!(queue.isEmpty())) {
            ArrayList<Integer> list = new ArrayList<>();
            int currentSize = queue.size();
            int count = 0;
            while (count < currentSize) {
                TreeNode tmp = queue.poll();
                list.add(tmp.val);
                count++;
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
            }
            listAll.add(0, list);
        }

        return listAll;
    }

    public static void connect_1(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode p = root;
        TreeLinkNode q = null;
        while (p.left != null) {
            q = p;
            while (q != null) {
                q.left.next = q.right;
                if (q.next != null) {
                    q.right.next = q.next.left;
                }
                q = q.next;
            }
            p = p.left;
        }

    }

    public static void connect_2(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        while (root != null) {
            TreeLinkNode p = new TreeLinkNode(-1);
            TreeLinkNode q = p;
            while (root != null) {
                if (root.left != null) {
                    q.next = root.left;
                    q = q.next;
                }
                if (root.right != null) {
                    q.next = root.right;
                    q = q.next;
                }
                root = root.next;
            }
            root = p.next;
        }

    }

    public static void main(String[] args) {
        // TreeLinkNode root = new TreeLinkNode(1);
        // root.left = new TreeLinkNode(2);
        // root.right = new TreeLinkNode(3);
        // root.left.left = new TreeLinkNode(4);
        // // root.left.right = new TreeLinkNode(5);
        // // root.right.left = new TreeLinkNode(6);
        // root.right.right = new TreeLinkNode(7);

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        // connect_2(root);
        System.out.println(levelOrderBottom(root));
        // System.out.println(root.val);
        // System.out.println(root.left.val);
        // System.out.println(root.left.next.val);
        // System.out.println(root.left.left.val);
        // System.out.println(root.left.left.next.val);

    }
}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val) {
        this.val = val;
    }
}
