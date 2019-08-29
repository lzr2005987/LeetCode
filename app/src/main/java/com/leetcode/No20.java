package com.leetcode;

import java.util.Stack;

public class No20 {
    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (stack.isEmpty()) {
                stack.push(aChar);
            } else {
                Character peek = stack.peek();
                if (isPair(peek, aChar)) {
                    stack.pop();
                } else if (isStart(aChar)) {
                    stack.push(aChar);
                } else {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isPair(char peek, char c) {
        if (String.valueOf(peek).equals("(") && String.valueOf(c).equals(")")) {
            return true;
        }
        if (String.valueOf(peek).equals("[") && String.valueOf(c).equals("]")) {
            return true;
        }
        if (String.valueOf(peek).equals("{") && String.valueOf(c).equals("}")) {
            return true;
        }
        return false;
    }

    private boolean isStart(char c) {
        if (String.valueOf(c).equals("(") || String.valueOf(c).equals("[") || String.valueOf(c).equals("{")) {
            return true;
        } else {
            return false;
        }
    }
}
