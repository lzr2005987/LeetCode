package com.leetcode.no51_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class No56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
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
}
