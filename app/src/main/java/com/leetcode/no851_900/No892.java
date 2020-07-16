package com.leetcode.no851_900;

public class No892 {
    public int surfaceArea(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    res += (grid[i][j] - 2) * 4 + 10;
                }
                if (j > 0) {
                    int m = grid[i][j - 1] > grid[i][j] ? grid[i][j] : grid[i][j - 1];
                    res -= m * 2;
                }
                if (i > 0) {
                    int n = grid[i - 1][j] > grid[i][j] ? grid[i][j] : grid[i - 1][j];
                    res -= n * 2;
                }
            }
        }
        return res;
    }
}
