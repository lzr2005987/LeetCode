package com.leetcode.no1001_1050;

public class No1014 {
    public int maxScoreSightseeingPair(int[] A) {
        int ans = 0, mx = A[0] + 0;
        for (int j = 1; j < A.length; ++j) {
            ans = Math.max(ans, mx + A[j] - j);
            mx = Math.max(mx, A[j] + j);
        }
        return ans;
    }
}
