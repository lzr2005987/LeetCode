package com.leetcode.no1_50;

import java.util.Arrays;

public class No41 {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 0 || nums[0] > 1) {
            return 1;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= 0) {
                continue;
            }
            if (nums[i] > 1 && nums[i - 1] <= 0) {
                return 1;
            }
            if (nums[i] - nums[i - 1] > 1) {
                if (nums[i - 1] + 1 > 0) {
                    return nums[i - 1] + 1;
                } else if (nums[i] > 1) {
                    return 1;
                }
            }
        }
        if (nums[nums.length - 1] + 1 > 0) {
            return nums[nums.length - 1] + 1;
        } else {
            return 1;
        }
    }
}
