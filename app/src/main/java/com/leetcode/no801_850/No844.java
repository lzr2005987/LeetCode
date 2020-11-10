package com.leetcode.no801_850;

import java.util.Stack;

public class No844 {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '#') {
                if (!stackS.isEmpty()) {
                    stackS.pop();
                }
            } else {
                stackS.push(c);
            }
        }
        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            if (c == '#') {
                if (!stackT.isEmpty()) {
                    stackT.pop();
                }
            } else {
                stackT.push(c);
            }
        }
        if (stackS.size() != stackT.size()) {
            return false;
        } else {
            while (!stackS.isEmpty()) {
                if (stackS.peek() == stackT.peek()) {
                    stackT.pop();
                    stackS.pop();
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
