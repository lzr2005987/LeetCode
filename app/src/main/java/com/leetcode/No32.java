package com.leetcode;

import java.util.Stack;

public class No32 {
    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        int[] dp = new int[s.length()];//dp[i]是以s[i]为结尾的最大合法子串,如果合法子串不以第i位结尾，则dp[i]=0
        int[] remain = new int[s.length()];
        Stack<String> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (String.valueOf(chars[i]).equals("(")) {
                stack.push(String.valueOf(chars[i]));
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
            remain[i] = stack.size();
        }
        for (int i = 1; i < s.length(); i++) {
            if (String.valueOf(chars[i]).equals("(")) {
                continue;
            }
            if (remain[i - 1] > 0) {
                dp[i] = dp[i - 1] + 2;
                if (i - dp[i] >= 0) {
                    dp[i] = dp[i - dp[i]] + dp[i];
                }
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}
