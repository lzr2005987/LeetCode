package com.leetcode.no51_100;

public class No85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int max = 0;
        int[][] ans = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                if (matrix[i][j] == '0') {
                    ans[i][j] = 0;
                } else if (j == 0) {
                    ans[i][j] = 1;
                } else {
                    ans[i][j] = ans[i][j - 1] + 1;
                }
            }
        }
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                if (ans[i][j] == 0) {
                    continue;
                }
                int k = i;
                while (k < ans.length && ans[k][j] >= ans[i][j]) {
                    k++;
                }
                k--;
                int k1 = i;
                while (k1 >= 0 && ans[k1][j] >= ans[i][j]) {
                    k1--;
                }
                k1++;
                int len = k - k1 + 1;
                int area = ans[i][j] * len;
                max = area > max ? area : max;
            }
        }
        return max;
    }
}
//        ["1","0","1","1","0","1"],
//        ["1","1","1","1","1","1"],
//        ["0","1","1","0","1","1"],
//        ["1","1","1","0","1","0"],
//        ["0","1","1","1","1","1"],
//        ["1","1","0","1","1","1"]