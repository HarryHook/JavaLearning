package com.algorithm.zuoshen;

import java.util.Stack;

public class RecuriveStack {

    public int getLastElement(Stack<Integer> stack) {
        int res = stack.pop();
        if (stack.isEmpty()) {
            return res;
        } else {
            int last = getLastElement(stack);
            stack.push(res);
            return last;
        }
    }
    public void reverse(Stack<Integer> stack) {
        if(stack.isEmpty()) {
            return;
        }
        int i = getLastElement(stack);
        reverse(stack);
        stack.push(i);

    }
    public static void main(String[] args) {
        RecuriveStack  ss = new RecuriveStack();
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.print(stack);

        ss.reverse(stack);
       System.out.print(stack);

    }
}
