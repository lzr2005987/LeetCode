package com.leetcode.interview;

public class Interview63 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for (int p : prices) {
            ans = Math.max(ans, p - min);
            min = Math.min(min, p);
        }
        return ans;
    }
}
