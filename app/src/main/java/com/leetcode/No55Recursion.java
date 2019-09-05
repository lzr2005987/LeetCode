package com.leetcode;

public class No55Recursion {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        } else {
            return jump(nums, nums.length - 1);
        }
    }

    private boolean jump(int[] num, int index) {
        if (index == 0) {
            return true;
        }
        for (int i = index - 1; i >= 0; i--) {
            if (num[i] + i >= index) {
                if (jump(num, i)) {
                    return true;
                }
            }
        }
        return false;
    }
}
