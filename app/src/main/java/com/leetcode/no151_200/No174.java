package com.leetcode.no151_200;

public class No174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int height = dungeon.length - 1;
        int width = dungeon[0].length - 1;
        dungeon[dungeon.length - 1][dungeon[0].length - 1] = dungeon[dungeon.length - 1][dungeon[0].length - 1] > 0 ?
                0 : -dungeon[dungeon.length - 1][dungeon[0].length - 1];
        for (int i = height - 1; i >= 0; i--) {
            dungeon[i][width] = dungeon[i + 1][width] - dungeon[i][width];
            if (dungeon[i][width] < 0) {
                dungeon[i][width] = 0;
            }
        }
        for (int i = width - 1; i >= 0; i--) {
            dungeon[height][i] = dungeon[height][i + 1] - dungeon[height][i];
            if (dungeon[height][i] < 0) {
                dungeon[height][i] = 0;
            }
        }
        for (int i = dungeon.length - 2; i >= 0; i--) {
            for (int j = dungeon[0].length - 2; j >= 0; j--) {
                dungeon[i][j] = Math.min(dungeon[i + 1][j], dungeon[i][j + 1]) - dungeon[i][j];
                if (dungeon[i][j] < 0) {
                    dungeon[i][j] = 0;
                }
            }
        }
        return dungeon[0][0] + 1;
    }
}
