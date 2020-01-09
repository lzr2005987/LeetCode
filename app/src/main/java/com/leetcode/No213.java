package com.leetcode;

public class No213 {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int[] ans1 = new int[nums.length];
        int[] ans2 = new int[nums.length];
        ans1[0] = nums[0];
        ans1[1] = nums[0];
        ans2[0] = 0;
        ans2[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            if (i < nums.length - 1) {
                ans1[i] = Math.max(nums[i] + ans1[i - 2], ans1[i - 1]);
            }
            ans2[i] = Math.max(nums[i] + ans2[i - 2], ans2[i - 1]);
        }
        return Math.max(ans1[ans1.length - 2], ans2[ans2.length - 1]);
    }
}
