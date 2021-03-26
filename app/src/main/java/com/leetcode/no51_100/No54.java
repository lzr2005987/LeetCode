package com.leetcode.no51_100;

import java.util.ArrayList;
import java.util.List;

public class No54 {
    private List<Integer> ans = new ArrayList<>();
    private int[][] m;

    public List<Integer> spiralOrder(int[][] matrix) {
        int i = 0, j = -1;
        m = matrix;
        while (ans.size() < m.length * m[0].length) {
            int[] cur;
            cur = right(i, j);
            i = cur[0];
            j = cur[1];
            cur = down(i, j);
            i = cur[0];
            j = cur[1];
            cur = left(i, j);
            i = cur[0];
            j = cur[1];
            cur = up(i, j);
            i = cur[0];
            j = cur[1];
        }
        return ans;
    }

    private int[] right(int i, int j) {
        int[] ret = new int[2];
        j++;
        while (j < m[0].length && m[i][j] != -101) {
            ans.add(m[i][j]);
            m[i][j] = -101;
            j++;
        }
        ret[0] = i;
        ret[1] = j - 1;
        return ret;
    }

    private int[] down(int i, int j) {
        int[] ret = new int[2];
        i++;
        while (i < m.length && m[i][j] != -101) {
            ans.add(m[i][j]);
            m[i][j] = -101;
            i++;
        }
        ret[0] = i - 1;
        ret[1] = j;
        return ret;
    }

    private int[] left(int i, int j) {
        int[] ret = new int[2];
        j--;
        while (j >= 0 && m[i][j] != -101) {
            ans.add(m[i][j]);
            m[i][j] = -101;
            j--;
        }
        ret[0] = i;
        ret[1] = j + 1;
        return ret;
    }

    private int[] up(int i, int j) {
        int[] ret = new int[2];
        i--;
        while (i >= 0 && m[i][j] != -101) {
            ans.add(m[i][j]);
            m[i][j] = -101;
            i--;
        }
        ret[0] = i + 1;
        ret[1] = j;
        return ret;
    }
}
