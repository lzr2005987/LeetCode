package com.leetcode;

public class No130 {
    private char[][] result;

    public void solve(char[][] board) {
        result = board;
        if (board.length == 0) {
            return;
        }
        for (int i = 0; i < board[0].length; i++) {
            fill(0, i);
            fill(board.length - 1, i);
        }
        for (int i = 1; i < board.length - 1; i++) {
            fill(i, 0);
            fill(i, board[0].length - 1);
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                if (result[i][j] == 'O') {
                    result[i][j] = 'X';
                } else if (result[i][j] == 'Q') {
                    result[i][j] = 'O';
                }
            }
        }
    }

    private void fill(int y, int x) {
        char cur = result[y][x];
        if (cur == 'O') {
            result[y][x] = 'Q';
            if (x + 1 < result[0].length) {
                fill(y, x + 1);
            }
            if (y + 1 < result.length) {
                fill(y + 1, x);
            }
            if (x - 1 > 0) {
                fill(y, x - 1);
            }
            if (y - 1 > 0) {
                fill(y - 1, x);
            }
        }
    }
}
