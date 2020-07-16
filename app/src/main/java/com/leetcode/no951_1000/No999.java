package com.leetcode.no951_1000;

public class No999 {
    public int numRookCaptures(char[][] board) {
        int posI = 0, posJ = 0;
        int ans = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    posI = i;
                    posJ = j;
                    break;
                }
            }
        }
        for (int i = posI - 1; i >= 0; i--) {
            if (getType(board[i][posJ]) == 1) {
                ans++;
                break;
            } else if (getType(board[i][posJ]) == 2) {
                break;
            }
        }
        for (int i = posI + 1; i < board.length; i++) {
            if (getType(board[i][posJ]) == 1) {
                ans++;
                break;
            } else if (getType(board[i][posJ]) == 2) {
                break;
            }
        }
        for (int j = posJ - 1; j >= 0; j--) {
            if (getType(board[posI][j]) == 1) {
                ans++;
                break;
            } else if (getType(board[posI][j]) == 2) {
                break;
            }
        }
        for (int j = posJ + 1; j < board[0].length; j++) {
            if (getType(board[posI][j]) == 1) {
                ans++;
                break;
            } else if (getType(board[posI][j]) == 2) {
                break;
            }
        }
        return ans;
    }

    private int getType(char c) {
        if (c == '.') {
            return 0;
        } else if (c == 'p') {
            return 1;
        } else {
            return 2;
        }
    }
}
