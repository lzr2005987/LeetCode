package com.leetcode.no251_300;

public class No283 {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while (i < nums.length - 1) {
            while (nums[i] != 0) {
                i++;
                if (i >= nums.length) return;
            }
            j = i;
            while (nums[j] == 0) {
                j++;
                if (j >= nums.length) return;
            }
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }
}
