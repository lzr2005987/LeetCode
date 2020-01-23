package com.leetcode.no51_100;

public class No55Greed {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {//无论怎么跳，最远都到不了i的位置
                return false;
            }
            max = Math.max(max, nums[i] + i);
            if (max >= nums.length - 1) {
                return true;
            }
        }
        return true;
    }
}
