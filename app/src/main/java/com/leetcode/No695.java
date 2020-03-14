package com.leetcode;

public class No695 {
    int area = 0, max = 0;

    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    area = 0;
                    search(grid, i, j);
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }

    private void search(int[][] grid, int i, int j) {
        grid[i][j] = 2;
        area++;
        if (i > 0 && grid[i - 1][j] == 1) {
            search(grid, i - 1, j);
        }
        if (j > 0 && grid[i][j - 1] == 1) {
            search(grid, i, j - 1);
        }
        if (i < grid.length - 1 && grid[i + 1][j] == 1) {
            search(grid, i + 1, j);
        }
        if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
            search(grid, i, j + 1);
        }
    }
}
