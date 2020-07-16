package com.leetcode.no951_1000;

import java.util.LinkedList;
import java.util.Queue;

public class No994 {
    int n = 0;

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        rotting(queue, grid);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return n;
    }

    private void rotting(Queue<int[]> queue, int[][] grid) {
        if (queue.isEmpty()) {
            return;
        }
        boolean isRotting = false;
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int[] pair = queue.poll();
            int x = pair[0];
            int y = pair[1];
            if (x > 0 && grid[x - 1][y] == 1) {
                grid[x - 1][y] = 2;
                queue.offer(new int[]{x - 1, y});
                isRotting = true;
            }
            if (y > 0 && grid[x][y - 1] == 1) {
                grid[x][y - 1] = 2;
                queue.offer(new int[]{x, y - 1});
                isRotting = true;
            }
            if (x < grid.length-1 && grid[x + 1][y] == 1) {
                grid[x + 1][y] = 2;
                queue.offer(new int[]{x + 1, y});
                isRotting = true;
            }
            if (y < grid[0].length-1 && grid[x][y + 1] == 1) {
                grid[x][y+1] = 2;
                queue.offer(new int[]{x, y + 1});
                isRotting = true;
            }
        }
        if (isRotting) {
            n++;
        }
        rotting(queue, grid);
    }
}
