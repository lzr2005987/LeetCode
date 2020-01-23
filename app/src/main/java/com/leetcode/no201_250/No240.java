package com.leetcode.no201_250;

public class No240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int pos = 0;
        if (matrix.length > 1) {
            pos = blurBinaryQuery(matrix, target, 0, matrix.length - 1);
        }
        if ((pos == 0 && matrix[0][0] > target)) {
            return false;
        }
        boolean b = false;
        while (!b && pos >= 0) {
            b = accurateBinaryQuery(matrix[pos], target, 0, matrix[pos].length - 1);
            pos--;
        }
        return b;
    }

    private int blurBinaryQuery(int[][] matrix, int target, int left, int right) {
        int mid = (left + right) / 2;
        if (mid == 0) {
            return matrix[mid + 1][0] <= target ? mid + 1 : mid;
        } else if (mid == matrix.length - 1) {
            return matrix[mid][0] > target ? mid - 1 : mid;
        }
        if (matrix[mid][0] > target && matrix[mid - 1][0] <= target) {
            return mid - 1;
        } else if (matrix[mid][0] <= target && matrix[mid + 1][0] > target) {
            return mid;
        }
        if (matrix[mid][0] > target && matrix[mid - 1][0] > target) {
            return blurBinaryQuery(matrix, target, left, mid - 1);
        } else {
            return blurBinaryQuery(matrix, target, mid + 1, right);
        }
    }

    private boolean accurateBinaryQuery(int[] line, int target, int left, int right) {
        int mid = (left + right) / 2;
        if (line[mid] == target) {
            return true;
        }
        if (left >= right) {
            return false;
        }
        if (line[mid] < target) {
            return accurateBinaryQuery(line, target, mid + 1, right);
        } else {
            return accurateBinaryQuery(line, target, left, mid - 1);
        }
    }
}
