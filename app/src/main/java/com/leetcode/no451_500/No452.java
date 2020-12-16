package com.leetcode.no451_500;

import java.util.Arrays;
import java.util.Comparator;

//贪心法
public class No452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int ans = 1;
        int a = points[0][1];
        for (int[] cur : points) {
            if (cur[0] > a || cur[1] < a) {
                ans++;
                a = cur[1];
            }
        }
        return ans;
    }
}
