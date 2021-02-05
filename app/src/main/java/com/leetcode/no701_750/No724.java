package com.leetcode.no701_750;

public class No724 {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        int half = 0;
        for (int n : nums) {
            sum += n;
        }
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (half == (sum - n) / 2 && (sum - n) % 2 == 0) {
                return i;
            }
            half += n;
        }
        return -1;
    }
}
