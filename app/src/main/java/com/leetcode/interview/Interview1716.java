package com.leetcode.interview;

public class Interview1716 {
    public int massage(int[] nums) {
        int[] ans = new int[nums.length];
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            ans[0] = nums[0];
            ans[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < ans.length; i++) {
                ans[i] = Math.max(ans[i - 2] + nums[i], ans[i - 1]);
            }
        }
        return ans[ans.length - 1];
    }
}
