package com.leetcode.no1001_1050;

import java.util.Stack;

public class No1047 {
    boolean b = true;

    public String removeDuplicates(String S) {
        String ans = S;
        while (b) {
            b = false;
            ans = remove(ans.toCharArray());
        }
        return ans;
    }

    private String remove(char[] chars) {
        String s = "";
        int i = 0;
        while (i < chars.length) {
            if (i == chars.length - 1 || chars[i] != chars[i + 1]) {
                s = s + chars[i];
                i++;
            } else {
                i += 2;
                b = true;
            }
        }
        return s;
    }

    public String removeDuplicates2(String S) {
        Stack<Character> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
                ans.append(c);
            } else {
                stack.pop();
                ans.deleteCharAt(ans.length() - 1);
            }
        }

        return ans.toString();
    }
}
