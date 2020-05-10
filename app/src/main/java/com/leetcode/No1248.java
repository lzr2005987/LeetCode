package com.leetcode;

/**
 * 标准答案
 */
public class No1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) return 0;
        int left = 0, right = 0;
        int count = 0;
        int res = 0;
        int preEven = 0;
        while (right < nums.length) {
            if (count < k) {
                if (nums[right] % 2 != 0) count++;
                right++;
            }
            if (count == k) {
                preEven = 0;
                while (count == k) {
                    res++;
                    if (nums[left] % 2 != 0) count--;
                    left++;
                    preEven++;
                }
            } else {
                res += preEven;
            }
        }
        return res;
    }
}
