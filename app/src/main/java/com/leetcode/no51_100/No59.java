package com.leetcode.no51_100;

public class No59 {
    public int[][] generateMatrix(int n) {
        int c = 0, r = -1, i = 1;
        int[][] ans = new int[n][n];
        int[] info = new int[3];
        info[0] = c;
        info[1] = r;
        info[2] = i;
        while (i <= n * n) {
            info = right(ans, info[0], info[1] + 1, info[2]);
            info = down(ans, info[0] + 1, info[1], info[2]);
            info = left(ans, info[0], info[1] - 1, info[2]);
            info = up(ans, info[0] - 1, info[1], info[2]);
            i = info[2];
        }
        return ans;
    }

    private int[] right(int[][] m, int c, int r, int i) {
        int[] ret = new int[3];
        while (r < m[0].length && m[c][r] == 0) {
            m[c][r] = i;
            i++;
            r++;
        }
        ret[0] = c;
        ret[1] = r - 1;
        ret[2] = i;
        return ret;
    }

    private int[] down(int[][] m, int c, int r, int i) {
        int[] ret = new int[3];
        while (c < m.length && m[c][r] == 0) {
            m[c][r] = i;
            i++;
            c++;
        }
        ret[0] = c - 1;
        ret[1] = r;
        ret[2] = i;
        return ret;
    }

    private int[] left(int[][] m, int c, int r, int i) {
        int[] ret = new int[3];
        while (r >= 0 && m[c][r] == 0) {
            m[c][r] = i;
            i++;
            r--;
        }
        ret[0] = c;
        ret[1] = r + 1;
        ret[2] = i;
        return ret;
    }

    private int[] up(int[][] m, int c, int r, int i) {
        int[] ret = new int[3];
        while (c >= 0 && m[c][r] == 0) {
            m[c][r] = i;
            i++;
            c--;
        }
        ret[0] = c + 1;
        ret[1] = r;
        ret[2] = i;
        return ret;
    }
}
