package com.leetcode;

public class No45OutOfTime {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int[] ans = new int[nums.length];
        ans[0] = 0;
        ans[1] = 1;
        for (int i = 2; i < nums.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (nums[j] >= i - j && ans[j] < min) {
                    min = ans[j];
                }
            }
            if (min == Integer.MAX_VALUE) {
                ans[i] = min;
            } else {
                ans[i] = min + 1;
            }
        }
        return ans[ans.length - 1];
    }
}
