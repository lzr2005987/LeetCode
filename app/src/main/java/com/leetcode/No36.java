package com.leetcode;

public class No36 {
    public boolean isValidSudoku(char[][] board) {
        boolean[] validRow = new boolean[10];
        boolean[] validColumn = new boolean[10];
        boolean[] valid = new boolean[10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!String.valueOf(board[i][j]).equals(".")) {
                    int numRow = Integer.parseInt(String.valueOf(board[i][j]));
                    if (validRow[numRow]) {
                        return false;
                    } else {
                        validRow[numRow] = true;
                    }
                }
                if (!String.valueOf(board[j][i]).equals(".")) {
                    int numColumn = Integer.parseInt(String.valueOf(board[j][i]));
                    if (validColumn[numColumn]) {
                        return false;
                    } else {
                        validColumn[numColumn] = true;
                    }
                }
            }
            for (int k = 0; k < 10; k++) {
                validColumn[k] = false;
                validRow[k] = false;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = i * 3; k < i * 3 + 3; k++) {
                    for (int l = j * 3; l < j * 3 + 3; l++) {
                        if (String.valueOf(board[k][l]).equals(".")) {
                            continue;
                        }
                        int num = Integer.parseInt(String.valueOf(board[k][l]));
                        if (valid[num]) {
                            return false;
                        } else {
                            valid[num] = true;
                        }
                    }
                }
                for (int k = 0; k < 10; k++) {
                    valid[k] = false;
                }
            }
        }
        return true;
    }
}