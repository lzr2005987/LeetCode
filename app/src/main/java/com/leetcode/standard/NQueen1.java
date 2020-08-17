package com.leetcode.standard;

public class NQueen1 {
    private int ans = 0;

    public int totalNQueens(int n) {
        int[][] chessboard = new int[n][n];
        backtrack(chessboard, n, 0);
        return ans;
    }

    private void backtrack(int[][] chessboard, int n, int cur) {
        for (int i = 0; i < n; i++) {
            if (check(chessboard, cur, i)) {//判断当前位置能不能放
                if (cur == n - 1) {
                    ans++;
                    return;
                }
                chessboard[cur][i] = 1;//放置皇后
                backtrack(copy(chessboard), n, cur + 1);//深拷贝，递归
                chessboard[cur][i] = 0;//回溯
            }
        }
    }

    private int[][] copy(int[][] origin) {
        int len = origin.length;
        int[][] newArray = new int[len][len];
        System.arraycopy(origin, 0, newArray, 0, len);
        return newArray;
    }

    private boolean check(int[][] chessboard, int i, int j) {
        int len = chessboard.length;
        for (int k = 0; k < len; k++) {
            if (chessboard[i][k] == 1 || chessboard[k][j] == 1) return false;
        }
        int x = i, y = j;
        while (x >= 0 && y >= 0) {
            if (chessboard[x][y] == 1) return false;
            x--;
            y--;
        }
        x = i;
        y = j;
        while (x < len && y < len) {
            if (chessboard[x][y] == 1) return false;
            x++;
            y++;
        }
        x = i;
        y = j;
        while (x < len && y >= 0) {
            if (chessboard[x][y] == 1) return false;
            x++;
            y--;
        }
        x = i;
        y = j;
        while (x >= 0 && y < len) {
            if (chessboard[x][y] == 1) return false;
            x--;
            y++;
        }
        return true;
    }
}
