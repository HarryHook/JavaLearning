package com.nowcoder;

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
	Stack<Integer> num = new Stack<>();

	for (int i = 0; i < tokens.length; i++) {

	    if (tokens[i] == "+" || tokens[i] == "-" || tokens[i] == "*" || tokens[i] == "/") {
		int num2 = num.pop();
		int num1 = num.pop();
		num.push(calculate(tokens[i], num1, num2));
	    } else {
		num.push(Integer.parseInt(tokens[i]));
	    }
	}

	return num.pop();
    }

    public boolean isNumber(String s) {

	for (int i = 0; i < s.length(); i++) {
	    if (s.charAt(0) == '-')
		i++;
	    if (!Character.isDigit(s.charAt(i))) {
		return false;
	    }
	}
	return true;

    }

    private int calculate(String op, int f1, int f2) {
	if (op.equals("+")) {
	    return f1 + f2;
	}
	if (op.equals("-")) {
	    return f1 - f2;
	}
	if (op.equals("*")) {
	    return f1 * f2;
	}
	if (op.equals("/")) {
	    return f1 / f2;
	}
	throw new RuntimeException(op + " is not supported");
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	String[] str = { "0", "3", "/" };
	System.out.println(s.evalRPN(str));

    }

}