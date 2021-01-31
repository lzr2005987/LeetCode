package com.leetcode.no51_100;

public class No75 {
    public void sortColors(int[] nums) {
        int head = 0;
        for (int n : nums) {
            if (n == 0) {
                head++;
            } else {
                break;
            }
        }
        int secondHead = sort(nums, head, 0);
        sort(nums, secondHead, 1);
    }

    private int sort(int[] nums, int head, int n) {
        int copy = head;
        for (int i = copy; i < nums.length; i++) {
            if (nums[i] == n) {
                int t = nums[i];
                nums[i] = nums[head];
                nums[head] = t;
                head++;
            }
        }
        return head;
    }
}
