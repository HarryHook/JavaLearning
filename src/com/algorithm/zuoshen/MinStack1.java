package com.algorithm.zuoshen;

import java.util.Stack;

public class MinStack1 {
    Stack<Integer> stackOfData;
    Stack<Integer> stackOfMin;

    public MinStack1() {
        stackOfData = new Stack<>();
        stackOfMin = new Stack<>();
    }

    public void push(int num) {
        if (stackOfMin.isEmpty()) {
            stackOfMin.push(num);
        } else if (num < stackOfMin.peek()) {
            stackOfMin.push(num);
        }
        stackOfData.push(num);
    }

    public int pop() {
        if (stackOfData.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        int val = stackOfData.pop();
        if (val == stackOfMin.peek()) {
            stackOfMin.pop();
        }
        return val;
    }
}
