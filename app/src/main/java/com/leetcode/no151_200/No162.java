package com.leetcode.no151_200;

public class No162 {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        } else if (nums.length == 2) {
            return nums[0] > nums[1] ? 0 : 1;
        } else {
            return findAns(nums, 0, nums.length - 1);
        }
    }

    private int findAns(int[] nums, int left, int right) {
        if (right - left == 1) {
            return nums[right] > nums[left] ? right : left;
        }
        int mid = (right - left) / 2 + left;
        if (mid == 0) {
            return 0;
        } else if (mid == nums.length - 1) {
            return nums.length - 1;
        } else if (nums[mid - 1] > nums[mid] && nums[mid] > nums[mid + 1]) {
            return findAns(nums, left, mid);
        } else if (nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1]) {
            return findAns(nums, mid, right);
        } else if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
            return mid;
        } else {
            return findAns(nums, mid, right);
        }
    }
}
