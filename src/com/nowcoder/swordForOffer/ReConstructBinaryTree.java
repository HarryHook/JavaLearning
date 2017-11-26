package com.nowcoder.swordForOffer;

public class ReConstructBinaryTree {
    public BinaryTreeNode reConstructBinaryTree(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null || preOrder.length < 0 || inOrder.length < 0) {
            return null;
        }
        return construct(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    public BinaryTreeNode construct(int[] preOrder, int ps, int pe, int[] inOrder, int is, int ie) {
        // 开始位置大于结束位置说明已经没有需要处理的元素了
        if (ps > pe) {
            return null;
        }
        int value = preOrder[ps];
        int index = is;
        while (index <= ie && value != inOrder[index]) {
            index++;
        }
        BinaryTreeNode node = new BinaryTreeNode();
        node.value = value;
        node.left = construct(preOrder, ps + 1, ps + index - is, inOrder, is, index - 1);
        node.right = construct(preOrder, ps + index - is + 1, pe, inOrder, index + 1, ie);
        return node;
    }

    public static void PostorderPrint(BinaryTreeNode node) {
        if (node != null) {
            PostorderPrint(node.left);
            PostorderPrint(node.right);
            System.out.println(node.value);
        }
    }

    public static void main(String[] args) {

        int[] preOrder = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        ReConstructBinaryTree ex = new ReConstructBinaryTree();
        BinaryTreeNode root1 = ex.reConstructBinaryTree(preOrder, inOrder);
        PostorderPrint(root1);
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode n1 = new BinaryTreeNode(2);
        root.left = n1;
        BinaryTreeNode n2 = new BinaryTreeNode(3);
        root.right = n2;
        BinaryTreeNode n3 = new BinaryTreeNode(4);
        n1.left = n3;
        BinaryTreeNode n4 = new BinaryTreeNode(5);
        n2.left = n4;
        BinaryTreeNode n5 = new BinaryTreeNode(6);
        n2.right = n5;
        BinaryTreeNode n6 = new BinaryTreeNode(7);
        n3.right = n6;
        BinaryTreeNode n7 = new BinaryTreeNode(8);
        n5.left = n7;

    }
}
