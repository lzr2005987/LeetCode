package com.leetcode;

public class No189 {
    public void rotate(int[] nums, int k) {
        int[] ans = new int[nums.length];
        int j;
        for (int i = 0; i < nums.length; i++) {
            j = i + k;
            while (j > nums.length - 1) {
                j -= nums.length;
            }
            ans[j] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = ans[i];
        }
    }
}
