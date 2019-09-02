package com.leetcode;

public class No32a {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];//dp[i]是以s[i]为结尾的最大合法子串,如果合法子串不以第i位结尾，则dp[i]=0
        int max = 0;

        for (int i = 1; i < s.length(); i++) {
            String sub = s.substring(i, i + 1);
            if (sub.equals("(")) {
                continue;
            }
            if (i - dp[i - 1] - 1 >= 0 && s.substring(i - dp[i - 1] - 1, i - dp[i - 1]).equals("(")) {
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
