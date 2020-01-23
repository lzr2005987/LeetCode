package com.leetcode.no51_100;

public class No70a {
    public int climbStairs(int n) {
        int[] sum = new int[n];
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        sum[0] = 1;
        sum[1] = 2;
        for (int i = 2; i < n; i++) {
            sum[i] = sum[i - 1] + sum[i - 2];
        }
        return sum[n - 1];
    }
}
