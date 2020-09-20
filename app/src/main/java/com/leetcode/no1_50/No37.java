package com.leetcode.no1_50;

public class No37 {
    private boolean isDone = false;

    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    private void backtrack(char[][] board, int x, int y) {
        if (isDone || (x == board.length - 1 && y > board.length - 1) || (x == board.length - 1 && y == board.length - 1 && board[x][y] != '.')) {
            isDone = true;
            return;
        }
        if (y > board.length - 1) {
            x++;
            y = 0;
        }
        if (board[x][y] != '.') {
            backtrack(board, x, y + 1);
        } else {
            int[] valid = getValid(board, x, y);
            if (valid[0] == -2) {
                return;
            }
            for (int i = 1; i < valid.length; i++) {
                if (valid[i] == -1) {
                    continue;
                }
                board[x][y] = (char) (valid[i] + '0');
                backtrack(board, x, y + 1);
                if (isDone) {
                    return;
                }
            }
            board[x][y] = '.';
        }
    }

    /**
     * 得到当前位置可以填的数字，如果什么也不能填就设置异常标志，valid[0]=-2
     *
     * @param board
     * @param x
     * @param y
     * @return
     */
    private int[] getValid(char[][] board, int x, int y) {
        int[] valid = new int[10];
        for (int i = 0; i <= 9; i++) {
            valid[i] = i;
        }
        for (int i = 0; i < board.length; i++) {
            if (board[x][i] == '.') {
                continue;
            }
            int p = board[x][i] - '0';
            valid[p] = -1;
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i][y] == '.') {
                continue;
            }
            int p = board[i][y] - '0';
            valid[p] = -1;
        }

        int x1 = x / 3 * 3;
        int y1 = y / 3 * 3;
        for (int i = x1; i <= x1 + 2; i++) {
            for (int j = y1; j <= y1 + 2; j++) {
                if (board[i][j] == '.' || i == x || j == y) {
                    continue;
                }
                int p = board[i][j] - '0';
                valid[p] = -1;
            }
        }
        for (int v : valid) {
            if (v != -1) {
                return valid;
            }
        }
        valid[0] = -2;
        return valid;
    }
}