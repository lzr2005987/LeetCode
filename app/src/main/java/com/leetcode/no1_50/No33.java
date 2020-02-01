package com.leetcode.no1_50;

public class No33 {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        } else if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        } else {
            int pivot = findPivot(nums, 0, nums.length - 1);
            if (nums[pivot] > target) {
                return -1;
            } else if (nums[pivot] == target) {
                return pivot;
            } else if (nums[nums.length - 1] == target) {
                return nums.length - 1;
            } else if (nums[nums.length - 1] > target) {
                return findTarget(nums, pivot + 1, nums.length - 2, target);
            } else {
                return findTarget(nums, 0, pivot - 1, target);
            }
        }
    }

    private int findTarget(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return findTarget(nums, left, mid - 1, target);
        } else {
            return findTarget(nums, mid + 1, right, target);
        }
    }

    private int findPivot(int[] nums, int left, int right) {
        int mid = (left + right) / 2;
        if (mid == 0) {
            return nums[1] < nums[0] ? 1 : 0;
        } else if (mid == nums.length - 1) {
            return nums[mid] < nums[mid - 1] ? mid : 0;
        } else if (nums[mid - 1] > nums[mid] && nums[mid + 1] > nums[mid]) {
            return mid;
        } else if (nums[0] > nums[mid] && nums[nums.length - 1] > nums[mid]) {
            return findPivot(nums, left, mid - 1);
        } else if (nums[0] < nums[mid] && nums[nums.length - 1] < nums[mid]) {
            return findPivot(nums, mid + 1, right);
        }
        return 0;
    }
}
