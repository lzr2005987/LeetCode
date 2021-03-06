package com.leetcode.no51_100;

import java.util.ArrayList;
import java.util.List;

public class No51 {
    private List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        int[][] position = new int[n][2];
        backtrack(position, n, 0);
        return ans;
    }

    private void backtrack(int[][] position, int n, int cur) {
        for (int i = 0; i < n; i++) {
            if (check(position, cur, i, cur)) {
                position[cur][0] = cur;
                position[cur][1] = i;
                if (cur == n - 1) {
                    List<String> solution = new ArrayList<>();
                    for (int j = 0; j < n; j++) {
                        String s = "";
                        for (int k = 0; k < n; k++) {
                            if (k == position[j][1]) {
                                s = s + "Q";
                            } else {
                                s = s + ".";
                            }
                        }
                        solution.add(s);
                    }
                    ans.add(solution);
                    return;
                }
                backtrack(copy(position, cur), n, cur + 1);
            }
        }
    }

    private int[][] copy(int[][] origin, int cur) {
        int[][] newArray = new int[origin.length][2];
        for (int i = 0; i <= cur; i++) {
            newArray[i][0] = origin[i][0];
            newArray[i][1] = origin[i][1];
        }
        return newArray;
    }

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
