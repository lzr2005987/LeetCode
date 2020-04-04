package com.leetcode.no251_300;

public class No289 {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                change(board, i, j);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 3) {
                    board[i][j] = 0;
                } else if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private void change(int[][] board, int i, int j) {
        int alive = 0;
        int endI = board.length - 1;
        int endJ = board[0].length - 1;
        if (i > 0) {
            if (board[i - 1][j] == 1 || board[i - 1][j] == 3) {
                alive++;
            }
        }
        if (i > 0 && j < endJ) {
            if (board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == 3) {
                alive++;
            }
        }
        if (j < endJ) {
            if (board[i][j + 1] == 1 || board[i][j + 1] == 3) {
                alive++;
            }
        }
        if (i < endI && j < endJ) {
            if (board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == 3) {
                alive++;
            }
        }
        if (i < endI) {
            if (board[i + 1][j] == 1 || board[i + 1][j] == 3) {
                alive++;
            }
        }
        if (i < endI && j > 0) {
            if (board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == 3) {
                alive++;
            }
        }
        if (j > 0) {
            if (board[i][j - 1] == 1 || board[i][j - 1] == 3) {
                alive++;
            }
        }
        if (i > 0 && j > 0) {
            if (board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == 3) {
                alive++;
            }
        }
        if (board[i][j] == 1 || board[i][j] == 3) {
            if (alive < 2 || alive > 3) {
                board[i][j] = 3;
            }
        } else {
            if (alive == 3) {
                board[i][j] = 2;
            }
        }
    }
}
