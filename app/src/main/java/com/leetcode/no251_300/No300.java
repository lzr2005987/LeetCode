package com.leetcode.no251_300;

public class No300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        }
        int[] dp = new int[nums.length];
        int ans = 0;
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            int k = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && max < dp[j]) {
                    max = dp[j];
                    k = dp[j] + 1;
                }
            }
            dp[i] = k;
            ans = ans < k ? k : ans;
        }
        return ans;
    }
}
