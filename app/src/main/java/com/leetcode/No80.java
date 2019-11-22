package com.leetcode;

public class No80 {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 0;
        int delNo = 0;
        while (right < nums.length - delNo) {
            if (left == right || nums[left] == nums[right]) {
                right++;
            } else if (nums[left] != nums[right]) {
                if (right - left - 2 > 0) {
                    delNo += (right - left - 2);
                    del(nums, left, right - left - 2);
                    right -= delNo;
                }
                left = right;
            }
        }
        if (right > left && right - left - 2 > 0) {
            delNo += (right - left - 2);
            del(nums, left, right - left - 2);
        }
        return nums.length - delNo;
    }

    private void del(int[] nums, int left, int no) {
        for (int i = left + no; i < nums.length; i++) {
            nums[i - no] = nums[i];
        }
    }
}
