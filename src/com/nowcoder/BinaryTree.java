package src.com.nowcoder;

import java.util.ArrayList;

public class BinaryTree {

    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return listAll;
        }
        list.add(root.data);

        if (root.left == null && root.right == null)
            listAll.add(new ArrayList<Integer>(list));
        FindPath(root.left);
        FindPath(root.right);
        list.remove(list.size() - 1);
        return listAll;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> binaryTreeNode = new BinaryTreeNode<>();
        binaryTreeNode.insert(5);
        binaryTreeNode.insert(2);
        binaryTreeNode.insert(1);
        binaryTreeNode.insert(4);
        binaryTreeNode.insert(3);
        binaryTreeNode.insert(6);

        BinaryTree tree = new BinaryTree();
        ArrayList<ArrayList<Integer>> result = tree.FindPath(binaryTreeNode);
        System.out.println(result);
        int sum = 0;
        for (int i = 0; i < result.size(); i++) {
            int sum1 = 0;
            for (int j = 0; j < result.get(i).size(); j++) {
                sum1 += result.get(i).get(j);
                if (j != result.get(i).size() - 1) {
                    sum1 *= 10;
                }

            }
            sum += sum1;
        }
        System.out.println(sum);
    }
}

class BinaryTreeNode<T extends Comparable> {

    public T data;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(T data) {
        this.data = data;
    }

    public BinaryTreeNode(T data, BinaryTreeNode<T> right, BinaryTreeNode<T> left) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    public BinaryTreeNode<T> insert(Object o) {

        if (data == null) {
            data = (T) o;
        } else {
            int comparedValue = data.compareTo((T) o);
            if (comparedValue > 0) {
                if (left == null) {
                    left = new BinaryTreeNode((T) o, null, null);
                } else {
                    left = left.insert(o);
                }
            } else {
                if (right == null) {
                    right = new BinaryTreeNode((T) o, null, null);
                } else {
                    right = right.insert(o);
                }
            }
        }
        return this;
    }

}
