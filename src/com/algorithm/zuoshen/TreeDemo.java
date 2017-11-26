package com.algorithm.zuoshen;

import com.nowcoder.swordForOffer.TreeNode;

import java.util.Stack;

public class TreeDemo {

    public static  TreeNode convert(TreeNode root) {
        if (root == null) return null;
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        boolean isFirst = true;
        TreeNode pre = null;// 用于保存中序遍历序列的上一节点
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if(isFirst) {
                root = p;
                pre = root;
                isFirst = false;
            } else {
                pre.right = p;
                p.left = pre;
                pre = p;
            }
            p = p.right;
        }
        return  root;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(8);
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(10);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(9);
        head.left = n1;
        head.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        TreeNode p =  convert(head);
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.right;
        }

    }
}
