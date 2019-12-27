package com.leetcode;

public class No152 {
    public int maxProduct(int[] nums) {
        int iMax, iMin, max;
        iMax = iMin = max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int t = iMax;
                iMax = iMin;
                iMin = t;
            }
            iMax = Math.max(nums[i], nums[i] * iMax);
            iMin = Math.min(nums[i], nums[i] * iMin);
            if (iMax > max) {
                max = iMax;
            }
        }
        return max;
    }
}
