package com.leetcode.no1_50;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class No22 {
    private List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0) return list;
        else if (n == 1) {
            list.add("()");
            return list;
        } else {
            solution(new Stack<String>(), new Stack<String>(), "(", n, n);
            return list;
        }
    }

    private void solution(Stack<String> stack, Stack<String> resultStack, String bracket, int numLeft, int numRight) {
        if ((numLeft == 0 && bracket.equals("(")) || (numRight == 0 && bracket.equals(")"))) {
            return;
        }
        if (stack.isEmpty() && bracket.equals(")")) {
            return;
        }
        if (resultStack.isEmpty()) {
            resultStack.addAll(stack);
        }
        if (bracket.equals("(")) {
            stack.push(bracket);
            resultStack.push(bracket);
            numLeft--;
        }
        if (stack.peek().equals("(") && bracket.equals(")")) {
            resultStack.push(bracket);
            stack.pop();
            numRight--;
        }
        if (numLeft > 0) {
            Stack<String> strings = new Stack<>();
            strings.addAll(stack);
            Stack<String> results = new Stack<>();
            results.addAll(resultStack);
            solution(strings, results, "(", numLeft, numRight);
        }
        if (numRight > 0) {
            Stack<String> strings = new Stack<>();
            strings.addAll(stack);
            Stack<String> results = new Stack<>();
            results.addAll(resultStack);
            solution(strings, results, ")", numLeft, numRight);
        }

        if (numLeft == 0 && numRight == 0) {
            list.add(getString(resultStack));
            resultStack.clear();
        }
    }

    private String getString(Stack<String> stack) {
        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append(s);
        }
        return sb.toString();
    }

}
