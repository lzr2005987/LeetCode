package com.leetcode;

public class No53 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int tmp = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i];
        }
        max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= 0) {
                if (nums[i] <= dp[i - 1]) {
                    dp[i] = dp[i - 1];
                } else {
                    dp[i] = nums[i];
                }
                max = dp[i];
                continue;
            }

            max = dp[i - 1];
            for (int j = i; j >= 0; j--) {
                tmp += nums[j];
                if (tmp > max) {
                    max = tmp;
                }
            }
            dp[i] = max;
            tmp = 0;
        }
        return max;
    }
}
