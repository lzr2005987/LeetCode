package com.leetcode.no1_50;

import java.util.Arrays;

public class No16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = nums[0] + nums[1] + nums[2] - target;
        int l, r;
        for (int i = 1; i < nums.length - 1; i++) {
            l = 0;
            r = nums.length - 1;
            while (l < i && r > i) {
                int sum = nums[l] + nums[i] + nums[r] - target;
                if (Math.abs(sum) > Math.abs(min)) {
                    if (sum > 0) {
                        r--;
                    } else {
                        l++;
                    }
                } else {
                    min = sum;
                    if (sum > 0) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }
        return min + target;
    }
}
