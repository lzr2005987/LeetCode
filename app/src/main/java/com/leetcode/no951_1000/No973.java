package com.leetcode.no951_1000;

import java.util.Arrays;
import java.util.Comparator;

public class No973 {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] * o1[0] + o1[1] * o1[1]) - (o2[0] * o2[0] + o2[1] * o2[1]);
            }
        });
        int[][] ans = new int[K][2];
        if (K >= 0) System.arraycopy(points, 0, ans, 0, K);
        return ans;
    }
}
