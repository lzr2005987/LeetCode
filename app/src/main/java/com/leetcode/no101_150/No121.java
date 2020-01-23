package com.leetcode.no101_150;

public class No121 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int max = 0;
        int minPrice = prices[0];
        if (prices[0] < prices[1]) {
            max = prices[1] - prices[0];
        } else {
            minPrice = prices[1];
        }
        for (int i = 2; i < prices.length; i++) {
            if (prices[i] > minPrice) {
                max = Math.max(max, prices[i] - minPrice);
            } else {
                minPrice = prices[i];
            }
        }
        return max;
    }
}
