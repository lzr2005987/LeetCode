package com.leetcode.no51_100;

public class No74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int pos = 0;
        if (matrix.length == 0 || matrix[0].length == 0 || matrix[0][0] > target) {
            return false;
        } else if (matrix.length == 1) {
            pos = 0;
        } else {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][0] == target) {
                    return true;
                } else if (i == matrix.length - 1) {
                    pos = matrix.length - 1;
                } else if (matrix[i][0] <= target && matrix[i + 1][0] > target) {
                    pos = i;
                    break;
                }
            }
        }
        int[] targetLine = matrix[pos];
        return binQuery(targetLine, 0, targetLine.length - 1, target);
    }

    private boolean binQuery(int[] line, int left, int right, int target) {
        int middle = (right - left) / 2 + left;
        if (left < 0 || right > line.length - 1 || left > right) {
            return false;
        } else if (target == line[middle]) {
            return true;
        } else if (target < line[middle]) {
            return binQuery(line, left, middle - 1, target);
        } else {
            return binQuery(line, middle + 1, right, target);
        }
    }
}
