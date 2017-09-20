package com.algorithm.zuoshen;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class RightCorners {
    public static class Node {
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class MyComparator implements Comparator<Node> {

        @Override
        public int compare(Node n1, Node n2) {
            if (n1.x != n2.x) {
                return n1.x - n2.x;
            } else {
                return n1.y - n2.y;
            }
        }
    }

    public static LinkedList<Node> getRightCornerNodes1(int[] x, int[] y) {
        int size = x.length;
        LinkedList<Node> res = new LinkedList<>();
        Node[] nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(x[i], y[i]);
        }
        Arrays.sort(nodes, new MyComparator());
        for (int i = 0; i < size; i++) {
            boolean flag = true;
            for (int j = 0; j < size; j++) {
                if (nodes[i].x < nodes[j].x && nodes[i].y < nodes[j].y) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res.add(nodes[i]);
            }
        }
        return res;
    }

    public static LinkedList<Node> getRightCornerNodes2(int[] x, int[] y) {
        int size = x.length;
        LinkedList<Node> res = new LinkedList<>();
        Node[] nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(x[i], y[i]);
        }
        Arrays.sort(nodes, new MyComparator());
        res.add(nodes[size-1]);
        int rightMaxY = nodes[size-1].y;
        for(int i=size-2; i>=0;i--) {
            if(nodes[i].y >= rightMaxY) {
                res.add(nodes[i]);
            }
            rightMaxY = Math.max(nodes[i].y, rightMaxY);
        }
        return res;
    }

    public static void printLinkedList(LinkedList<Node> list) {
        for (Node node : list) {
            System.out.print("(" + node.x + "," + node.y + ") ");
        }
        System.out.println();
    }

    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
        return arr;
    }

    public static void main(String[] args) {
        int size = 6;
        int[] x = generateRandomArray(size);
        int[] y = generateRandomArray(size);
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i] + " " + y[i]);
        }
        LinkedList<Node> res = getRightCornerNodes2(x, y);
        printLinkedList(res);
    }
}
