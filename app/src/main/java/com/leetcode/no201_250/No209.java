package com.leetcode.no201_250;

public class No209 {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            if (s == nums[0]) {
                return 1;
            } else {
                return 0;
            }
        }
        int i = 0;
        int j = 0;
        int sum = nums[0];
        int min = nums.length + 1;

        while (j < nums.length) {
            if (sum >= s) {
                min = min > j - i + 1 ? j - i + 1 : min;
                sum -= nums[i++];
                if (i > j) {
                    j++;
                    if (j < nums.length) {
                        sum = nums[j];
                    } else {
                        break;
                    }
                }
            } else {
                j++;
                if (j < nums.length) {
                    sum += nums[j];
                } else {
                    break;
                }
            }
        }
        if (min == nums.length + 1) {
            return 0;
        } else {
            return min;
        }
    }
}
