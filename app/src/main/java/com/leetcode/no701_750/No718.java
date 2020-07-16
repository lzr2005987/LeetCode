package com.leetcode.no701_750;

public class No718 {
    public int findLength(int[] A, int[] B) {
        int[][] ans = new int[A.length][B.length];
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == B[0]) {
                ans[i][0] = 1;
                if (max == 0) max = 1;
            } else {
                ans[i][0] = 0;
            }
        }

        for (int i = 1; i < B.length; i++) {
            if (A[0] == B[i]) {
                ans[0][i] = 1;
                if (max == 0) max = 1;
            } else {
                ans[0][i] = 0;
            }
        }

        for (int i = 1; i < A.length; i++) {
            for (int j = 1; j < B.length; j++) {
                if (A[i] == B[j]) {
                    ans[i][j] = ans[i - 1][j - 1] + 1;
                    max = Math.max(max, ans[i][j]);
                } else {
                    ans[i][j] = 0;
                }
            }
        }
        return max;
    }
}
