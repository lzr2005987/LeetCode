package com.leetcode.no701_750;

public class No746 {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        if (cost.length == 2) {
            return Math.max(cost[0], cost[1]);
        } else if (cost.length == 1) {
            return cost[0];
        } else if (cost.length == 0) {
            return 0;
        }
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[dp.length - 1];
    }
}
