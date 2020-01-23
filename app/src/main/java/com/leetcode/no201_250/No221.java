package com.leetcode.no201_250;

public class No221 {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        if (matrix.length == 0) {
            return 0;
        }
        int[][] res = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            res[i][0] = Integer.parseInt(String.valueOf(matrix[i][0]));
            if (res[i][0] > max) {
                max = res[i][0];
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            res[0][i] = Integer.parseInt(String.valueOf(matrix[0][i]));
            if (res[0][i] > max) {
                max = res[0][i];
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    res[i][j] = Math.min(Math.min(res[i - 1][j], res[i][j - 1]), res[i - 1][j - 1]) + 1;
                } else {
                    res[i][j] = 0;
                }
                if (res[i][j] > max) {
                    max = res[i][j];
                }
            }
        }
        return max * max;
    }
}
