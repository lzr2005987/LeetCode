package com.leetcode.no1_50;

public class No34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int pos = searchPos(nums, target, 0, nums.length - 1);
        if (pos == -1) {
            return new int[]{-1, -1};
        }
        int l = 0, r = nums.length - 1;
        for (int i = pos; i >= 0; i--) {
            if (nums[i] != nums[pos]) {
                l = i + 1;
                break;
            }
        }
        for (int i = pos; i < nums.length; i++) {
            if (nums[i] != nums[pos]) {
                r = i - 1;
                break;
            }
        }
        return new int[]{l, r};
    }

    private int searchPos(int[] nums, int target, int start, int end) {
        if (end - start <= 1) {
            if (nums[end] == target) {
                return end;
            } else if (nums[start] == target) {
                return start;
            } else {
                return -1;
            }
        }
        int pos = (end - start) / 2 + start;
        if (nums[pos] < target) {
            return searchPos(nums, target, pos, end);
        } else if (nums[pos] > target) {
            return searchPos(nums, target, start, pos);
        } else {
            return pos;
        }
    }
}
