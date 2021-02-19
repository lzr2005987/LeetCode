package com.leetcode.no551_600;

public class No566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] ans = new int[r][c];
        int i1 = 0, j1 = 0;
        if (nums.length * nums[0].length != r * c) {
            return nums;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (j1 >= c) {
                    j1 = 0;
                    i1++;
                }
                ans[i1][j1] = nums[i][j];
                j1++;
            }
        }
        return ans;
    }
}
