package com.leetcode.no51_100;

import java.util.ArrayList;

public class No56 {
    public int[][] merge(int[][] intervals) {
        sort(intervals);
        ArrayList<int[]> list = new ArrayList<>();
        int left = 0, right = 0;
        while (right < intervals.length) {
            right++;
            if (right >= intervals.length) {
                right--;
                if (intervals[left][1] >= intervals[right][0]) {
                    list.add(intervals[left]);
                } else {
                    list.add(intervals[right]);
                }
                break;
            }
            if (intervals[left][1] >= intervals[right][0]) {
                intervals[left][1] = Math.max(intervals[left][1], intervals[right][1]);
            } else {
                list.add(intervals[left]);
                left = right;
            }
        }
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    private void sort(int[][] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i][0] > nums[j][0]) {
                    int[] temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
