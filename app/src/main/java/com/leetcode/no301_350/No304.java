package com.leetcode.no301_350;

public class No304 {
    private int[][] sum;

    public No304(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        sum = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 && j == 0) {
                    sum[i][j] = matrix[i][j];
                } else if (j == 0) {
                    sum[i][j] = sum[i - 1][j] + matrix[i][j];
                } else if (i == 0) {
                    sum[i][j] = sum[i][j - 1] + matrix[i][j];
                } else {
                    sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int top = 0;
        int left = 0;
        int sub = 0;
        if (row1 > 0) {
            top = sum[row1 - 1][col2];
        }
        if (col1 > 0) {
            left = sum[row2][col1 - 1];
        }
        if (row1 > 0 && col1 > 0) {
            sub = sum[row1 - 1][col1 - 1];
        }
        return sum[row2][col2] - top - left + sub;
    }
}
