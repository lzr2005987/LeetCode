package com.leetcode;

public class No63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] res = new int[m][n];
        res[0][0] = 1;
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    res[i][j] = 0;
                    continue;
                }
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    res[i][j] = res[i][j - 1];
                } else if (j == 0) {
                    res[i][j] = res[i - 1][j];
                } else {
                    res[i][j] = res[i][j - 1] + res[i - 1][j];
                }
            }
        }
        return res[res.length - 1][res[0].length - 1];
    }
}
