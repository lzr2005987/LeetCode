package com.leetcode.no251_300;

public class No279 {
    public int numSquares(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = i;
            for (int j = 1; j * j <= i; j++) {
                ans[i] = Math.min(ans[i], ans[i - j * j] + 1);
            }
        }
        return ans[n];
    }
}
