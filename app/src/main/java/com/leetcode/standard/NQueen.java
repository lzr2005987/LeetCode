package com.leetcode.standard;

public class NQueen {
    private int ans = 0;

    public int totalNQueens(int n) {
        int[][] position = new int[n][2];
        backtrack(position, n, 0);
        return ans;
    }

    /**
     * 回溯放置棋子，计算方案总数
     *
     * @param position
     * @param n
     * @param cur
     */
    private void backtrack(int[][] position, int n, int cur) {
        for (int i = 0; i < n; i++) {
            if (check(position, cur, i, cur)) {//检查当前位置是否能放
                if (cur == n - 1) {//方案数量+1
                    ans++;
                    return;
                }
                //放置棋子
                position[cur][0] = cur;
                position[cur][1] = i;
                //回溯
                backtrack(copy(position, cur), n, cur + 1);
            }
        }
    }

    /**
     * 深拷贝用于回溯的数组
     *
     * @param origin
     * @param cur
     * @return
     */
    private int[][] copy(int[][] origin, int cur) {
        int[][] newArray = new int[origin.length][2];
        System.arraycopy(origin, 0, newArray, 0, cur + 1);
        return newArray;
    }

    /**
     * 检查当前位置是否可以放置
     *
     * @param position
     * @param i
     * @param j
     * @param cur
     * @return
     */
    private boolean check(int[][] position, int i, int j, int cur) {
        for (int k = 0; k < cur; k++) {
            int x = position[k][0];
            int y = position[k][1];
            if (x == i || y == j || Math.abs(x - i) == Math.abs(y - j)) {
                return false;
            }
        }
        return true;
    }
}
