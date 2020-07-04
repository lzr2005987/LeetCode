package com.leetcode.no201_250;

public class No238 {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        if (nums.length == 0) return ans;
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        right[right.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < ans.length; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }
}
