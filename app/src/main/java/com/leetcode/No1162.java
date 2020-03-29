package com.leetcode;

public class No1162 {
    public int maxDistance(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int[][] ans = new int[grid.length][grid[0].length];
        int max = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                ans[i][j] = grid[i][j] == 1 ? 0 : Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    if (i > 0) {
                        ans[i][j] = Math.min(ans[i][j], ans[i - 1][j] == Integer.MAX_VALUE ? ans[i - 1][j] : ans[i - 1][j] + 1);
                    }
                    if (j > 0) {
                        ans[i][j] = Math.min(ans[i][j], ans[i][j - 1] == Integer.MAX_VALUE ? ans[i][j - 1] : ans[i][j - 1] + 1);
                    }
                }
            }
        }

        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[i].length - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    if (i < grid.length - 1) {
                        ans[i][j] = Math.min(ans[i][j], ans[i + 1][j] == Integer.MAX_VALUE ? ans[i + 1][j] : ans[i + 1][j] + 1);
                    }
                    if (j < grid[i].length - 1) {
                        ans[i][j] = Math.min(ans[i][j], ans[i][j + 1] == Integer.MAX_VALUE ? ans[i][j + 1] : ans[i][j + 1] + 1);
                    }
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    max = Math.max(max, ans[i][j]);
                    if (max == Integer.MAX_VALUE) {
                        return -1;
                    }
                }
            }
        }
        return max;
    }
}
