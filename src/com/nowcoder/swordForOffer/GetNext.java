package com.nowcoder.swordForOffer;

public class GetNext {
    /*
    题意：得到当前节点在中序遍历情况下的下一个节点，没有返回null
     */
    public TreeLinkNode getNext(TreeLinkNode node) {
        if (node == null) {
            return null;
        }
        //当前节点存在右子树，找到右子树的最左节点
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        //当前节点没有右子树， 父节点的左子树是当前节点，返回当前节点的父节点，否则一直找到根节点
        while(node.next != null) {
            if(node.next.left == node) {
                return node.next; //返回根节点
            }
            node = node.next;
        }
        return null;
    }
}
