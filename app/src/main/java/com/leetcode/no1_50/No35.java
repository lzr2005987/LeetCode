package com.leetcode.no1_50;

public class No35 {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0 || nums[0] > target) {
            return 0;
        } else if (nums[nums.length - 1] < target) {
            return nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            } else if (i < nums.length - 1 && nums[i] < target && nums[i + 1] > target) {
                return i + 1;
            }
        }
        return nums.length;
    }
}
