package com.leetcode.no151_200;

public class No153And154 {
    public int findMin(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                return nums[i + 1];
            }
        }
        return nums[0];
    }

    private int ans;

    public int findMin2(int[] nums) {
        if (nums[nums.length - 1] > nums[0]) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.min(nums[0], nums[1]);
        } else if (nums.length == 1) {
            return nums[0];
        }
        ans = nums[0];
        binary(nums, 0, nums.length - 1);
        return ans;
    }

    private void binary(int[] nums, int left, int right) {
        if (ans != nums[0]) {
            return;
        }
        int middle = (left + right) / 2;
        if (middle == 0) {
            if (nums[middle] > nums[middle + 1]) {
                ans = nums[middle + 1];
                return;
            }
        } else if (nums[middle] < nums[middle - 1]) {
            ans = nums[middle];
            return;
        }
        if (nums[middle] > nums[nums.length - 1]) {
            binary(nums, middle + 1, right);
        } else {
            binary(nums, left, middle - 1);
        }
    }
}
