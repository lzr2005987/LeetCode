package com.leetcode.no601_650;

public class No643 {
    public double findMaxAverage(int[] nums, int k) {
        int i1 = 0;
        int j1 = k - 1;
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        ans = sum;
        i1++;
        j1++;
        while (j1 < nums.length) {
            sum = sum - nums[i1 - 1] + nums[j1];
            ans = Math.max(ans, sum);
            i1++;
            j1++;
        }
        return ans / (double) k;
    }
}
