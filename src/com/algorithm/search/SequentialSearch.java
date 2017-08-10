package com.algorithm.search;

public class SequentialSearch<Key, Value> {
    private Node first;

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public Value get(Key key) {
        for (Node node = first; node != null; node = node.next) {
            if (key.equals(node.key)) {
                return node.value;
            }
        }
        return null;
    }

    public void put(Key key, Value value) {
        for (Node node = first; node != null; node = node.next) {
            if (key.equals(node.key)) {
                node.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
    }

    public void show() {
        Node node = first;
        while (node != null) {
            System.out.println(node.key + " : " + node.value);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        SequentialSearch<String, Integer> search = new SequentialSearch<>();
        search.put("S", 0);
        search.put("e", 1);
        search.put("a", 2);
        search.put("r", 3);
        search.put("c", 4);
        search.put("h", 5);
        search.put("e", 6);
        search.put("x", 7);
        search.put("a", 8);
        search.put("m", 9);
        search.put("p", 10);
        search.put("l", 11);
        search.put("e", 12);

        search.show();

    }
}
