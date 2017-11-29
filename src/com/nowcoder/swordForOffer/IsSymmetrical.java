package com.nowcoder.swordForOffer;

/*
    判断一棵树是否是镜像二叉树
    判断当前节点的左子树和右子树是否对称
    左子树的左节点和右子树的右节点进行比较
    左子树的右节点和右子树的做节点进行比较
    一次递归，知道左右子树的节点同时为空时返回
 */
public class IsSymmetrical {
    boolean isSymmetrical(TreeNode pRoot){
        if(pRoot == null) return true;
        return compare(pRoot.left, pRoot.right);
    }
    public boolean compare(TreeNode pLeft, TreeNode pRight) {
        if(pLeft == null) return pRight == null;
        if(pRight == null) return false;
        if(pLeft.val != pRight.val) return false;
        return compare(pLeft.left, pRight.right) && compare(pLeft.right, pRight.left);
    }
}
