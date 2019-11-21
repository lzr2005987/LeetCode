package com.leetcode;

public class No79 {
    private String wordCopy;

    public boolean exist(char[][] board, String word) {
        wordCopy = word;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (find(copy(board), i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean find(char[][] board, int a, int b, int index) {
        if (index >= wordCopy.length()) {
            return true;
        }
        char cur = board[a][b];
        if (cur == wordCopy.charAt(index)) {
            if (index == wordCopy.length() - 1) {
                return true;
            }
            board[a][b] = ' ';
            boolean right = false;
            boolean left = false;
            boolean down = false;
            boolean up = false;
            if (a + 1 < board.length) {
                down = find(copy(board),a + 1, b, index + 1);
                if (down) return true;
            }
            if (b + 1 < board[0].length) {
                right = find(copy(board), a, b + 1, index + 1);
                if (right) return true;
            }
            if (b - 1 >= 0) {
                left = find(copy(board), a, b - 1, index + 1);
                if (left) return true;
            }
            if (a - 1 >= 0) {
                up = find(copy(board), a - 1, b, index + 1);
                if (up) return true;
            }
            return false;
        } else {
            return false;
        }
    }

    private char[][] copy(char[][] ori) {
        char[][] res = new char[ori.length][ori[0].length];
        for (int i = 0; i < ori.length; i++) {
            for (int j = 0; j < ori[0].length; j++) {
                res[i][j] = ori[i][j];
            }
        }
        return res;
    }
}
