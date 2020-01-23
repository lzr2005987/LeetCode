package com.leetcode.no51_100;

public class No64 {
    public int minPathSum(int[][] grid) {
        int[][] res = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    res[i][j] = res[i][j - 1] + grid[i][j - 1];
                } else if (j == 0) {
                    res[i][j] = res[i - 1][j] + grid[i - 1][j];
                } else {
                    res[i][j] = Math.min(res[i][j - 1] + grid[i][j - 1], res[i - 1][j] + grid[i - 1][j]);
                }
            }
        }
        return res[res.length - 1][res[0].length - 1] + grid[grid.length - 1][grid[0].length - 1];
    }
}
