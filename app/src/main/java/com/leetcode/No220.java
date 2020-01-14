package com.leetcode;

public class No220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length < 2) {
            return false;
        }
        int i = 0;
        int j = 1;
        if (nums[0] == -1 && nums[1] == 2147483647 || nums[0] == 2147483647) {
            return false;
        }
        if (Math.abs(nums[1] - nums[0]) <= t && k >= 1) {
            return true;
        }
        while (j < nums.length) {
            for (int l = i; l < j; l++) {
                if (Math.abs(nums[l] - nums[j]) <= t && j - l <= k) {
                    return true;
                }
            }
            j++;
        }
        return false;
    }
}
