package com.leetcode.standard;

public class NQueen {
    private int ans = 0;

    public int totalNQueens(int n) {
        int[][] position = new int[n][2];
        backtrack(position, n, 0);
        return ans;
    }

    private void backtrack(int[][] position, int n, int cur) {
        for (int i = 0; i < n; i++) {
            if (check(position, cur, i, cur)) {
                if (cur == n - 1) {
                    ans++;
                    return;
                }
                position[cur][0] = cur;
                position[cur][1] = i;
                backtrack(copy(position, cur), n, cur + 1);
            }
        }
    }

    private int[][] copy(int[][] origin, int cur) {
        int[][] newArray = new int[origin.length][2];
        System.arraycopy(origin, 0, newArray, 0, cur + 1);
        return newArray;
    }

    private boolean check(int[][] position, int i, int j, int cur) {
        for (int k = 0; k < cur; k++) {
            int x = position[k][0];
            int y = position[k][1];
            if (x == i || y == j || Math.abs(x - i) == Math.abs(y - j)) {
                return false;
            }
        }
        return true;
    }
}
