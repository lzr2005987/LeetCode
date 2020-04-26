package com.leetcode.interview;

public class Interview0811 {
    public int waysToChange(int n) {
        int[] coins = {1, 5, 10, 25};
        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < 4; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (j - coins[i] >= 0) {
                    dp[j] = (dp[j] + dp[j - coins[i]]) % 1000000007;
                }

            }
        }
        return dp[n];
    }
}
