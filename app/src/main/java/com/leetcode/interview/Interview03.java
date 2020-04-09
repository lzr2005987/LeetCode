package com.leetcode.interview;

import java.util.Arrays;

public class Interview03 {
    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return nums[0];
    }
}
