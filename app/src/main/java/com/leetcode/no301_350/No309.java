package com.leetcode.no301_350;

public class No309 {
    //我们目前持有一支股票，对应的「累计最大收益」记为 f[0][i]
    //我们目前不持有任何股票，并且处于冷冻期中，对应的「累计最大收益」记为 f[1][i]
    //我们目前不持有任何股票，并且不处于冷冻期中，对应的「累计最大收益」记为 f[2][i]
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[][] ans = new int[3][prices.length];
        int max = 0;
        ans[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            ans[0][i] = Math.max(ans[0][i - 1], ans[2][i - 1] - prices[i]);
            ans[1][i] = ans[0][i - 1] + prices[i];
            ans[2][i] = Math.max(ans[1][i - 1], ans[2][i - 1]);
        }
        max = Math.max(ans[2][prices.length - 1], ans[1][prices.length - 1]);
        return max;
    }
}
