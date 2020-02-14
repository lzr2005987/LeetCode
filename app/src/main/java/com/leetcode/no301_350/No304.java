package com.leetcode.no301_350;

public class No304 {
    int[][] dp = null;

    public No304(int[][] matrix) {
        if (matrix.length > 0) {
            dp = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    for (int k = 0; k <= i; k++) {
                        for (int l = 0; l <= j; l++) {
                            dp[i][j] += matrix[k][l];
                        }
                    }
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (dp == null) {
            return 0;
        } else {
            int ans = dp[row2][col2];
            if (row1 > 0 && col1 > 0) {
                ans = ans - dp[row1 - 1][col2] - dp[row2][col1 - 1] + dp[row1 - 1][col1 - 1];
            } else if (row1 > 0) {
                ans -= dp[row1 - 1][col2];
            } else if (col1 > 0) {
                ans -= dp[row2][col1 - 1];
            }
            return ans;
        }
    }
}
