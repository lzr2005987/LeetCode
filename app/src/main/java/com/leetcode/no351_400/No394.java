package com.leetcode.no351_400;

import java.util.Stack;

public class No394 {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            String temps = "";
            String tempd = "";
            int num = 0;
            char c = s.charAt(i);
            if (c != ']') {
                stack.push(s.charAt(i));
            } else {
                while (stack.peek() != '[') {
                    temps = stack.pop() + temps;
                }
                stack.pop();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    tempd = stack.pop() + tempd;
                }
                num = Integer.parseInt(tempd);
                for (int k = 0; k < num; k++) {
                    for (int j = 0; j < temps.length(); j++) {
                        stack.push(temps.charAt(j));
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }
        return ans;
    }
}
