package com.leetcode.no201_250;

import java.util.Stack;

public class No227 {
    Stack<Integer> stackP = new Stack<>();
    Stack<Integer> stackM = new Stack<>();

    public int calculate(String s) {
        int i;
        int ans = 0;
        i = getNumber(s, 0, false, false);
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                i = getNumber(s, i + 1, false, false);
            } else if (s.charAt(i) == '-') {
                i = getNumber(s, i + 1, false, true);
            } else if (s.charAt(i) == '*') {
                stackM.push(stackP.pop());
                i = getNumber(s, i + 1, true, false);
            } else if (s.charAt(i) == '/') {
                stackM.push(stackP.pop());
                i = getNumber(s, i + 1, true, true);
            }
        }
        for (int n : stackP) {
            ans += n;
        }
        return ans;
    }

    private int getNumber(String s, int i, boolean isMultiple, boolean isMinus) {
        StringBuilder sb = new StringBuilder();
        for (int j = i; j < s.length(); j++) {
            if (s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                sb.append(s.charAt(j));
            } else if (s.charAt(j) != ' ') {
                addNumber(sb.toString(), isMultiple, isMinus);
                if (j < s.length() - 1) {
                    return j;
                }
            }
        }
        addNumber(sb.toString(), isMultiple, isMinus);
        return s.length();
    }

    private void addNumber(String s, boolean isMultiple, boolean isMinus) {
        int num = Integer.parseInt(s);
        if (isMultiple) {
            if (!stackM.isEmpty()) {
                int m = stackM.pop();
                if (isMinus) {
                    num = m / num;
                } else {
                    num = m * num;
                }
            }
        } else {
            if (isMinus) {
                num = -num;
            }
        }
        stackP.push(num);
    }
}
