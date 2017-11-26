package com.nowcoder.swordForOffer;

import java.util.Stack;

public class MirrorTree {
    public void mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode p = s.pop();
            if (p.left != null || p.right != null) {
                TreeNode tmp = p.left;
                p.left = p.right;
                p.right = tmp;
            }
            if (p.right != null) {
                s.push(p.right);
            }
            if (p.left != null) {
                s.push(p.left);
            }
        }
    }
}
