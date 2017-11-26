package com.nowcoder.swordForOffer;

import java.util.Stack;

public class IsPopOrder {
    public boolean isPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, j = 0; i < pushA.length; i++) {
            stack.push(pushA[i++]);
            while (j < popA.length && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        double i = 0.0/0.0;
        System.out.println(i == i);
        double i1 = 1.0/0.0;
        System.out.println(i1 == i1);
        Double i2 = 0.0/0.0;
        System.out.println(i2 == i2);
        Double i3 = 1.0/0.0;
        System.out.println(i3 == i3);
    }
}
