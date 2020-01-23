package com.leetcode.no151_200;

public class No200 {
    int width = 0;
    int height = 0;

    public int numIslands(char[][] grid) {
        int sum = 0;
        if (grid.length == 0) {
            return 0;
        }
        height = grid.length - 1;
        width = grid[0].length - 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    sum++;
                    floodFill(grid, i, j);
                }
            }
        }
        return sum;
    }

    private void floodFill(char[][] map, int i, int j) {
        if (map[i][j] == '1') {
            map[i][j] = '2';
            if (i < height) {
                floodFill(map, i + 1, j);
            }
            if (j < width) {
                floodFill(map, i, j + 1);
            }
            if (i > 0) {
                floodFill(map, i - 1, j);
            }
            if (j > 0) {
                floodFill(map, i, j - 1);
            }
        }
    }
}
