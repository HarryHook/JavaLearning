package com.nowcoder.swordForOffer;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class PrintBinaryTree {
    public static ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        if (pRoot == null) {
            return new ArrayList<ArrayList<Integer>>();
        }
        TreeNode p = pRoot;
        int layers = 1;
        ArrayList<TreeNode> sup = new ArrayList<TreeNode>();
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        sup.add(p);
        while (!sup.isEmpty()) {
            int count = 0;
            int currentSize = sup.size();
            ArrayList<Integer> array = new ArrayList<Integer>();
            while (count < currentSize) {
                TreeNode temp = sup.remove(0);
                array.add(temp.val);
                count++;
                if (temp.left != null) {
                    sup.add(temp.left);
                }
                if (temp.right != null) {
                    sup.add(temp.right);
                }
            }
            if (layers % 2 == 0) {
                Collections.reverse(array);
            }
            results.add(array);
            layers++;
        }
        return results;
    }


    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(7);

        head.left = n1;
        head.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;

        System.out.println(print(head));
    }
}
