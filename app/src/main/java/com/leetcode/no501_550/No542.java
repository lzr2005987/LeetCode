package com.leetcode.no501_550;

public class No542 {
    public int[][] updateMatrix(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Integer.MAX_VALUE / 2;//防止+1以后越界
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i > 0) {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j]);
                }
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j - 1] + 1, dp[i][j]);
                }
            }
        }
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[i].length - 1; j >= 0; j--) {
                if (i < matrix.length - 1) {
                    dp[i][j] = Math.min(dp[i + 1][j] + 1, dp[i][j]);
                }
                if (j < matrix[i].length - 1) {
                    dp[i][j] = Math.min(dp[i][j + 1] + 1, dp[i][j]);
                }
            }
        }
        return dp;
    }
}
