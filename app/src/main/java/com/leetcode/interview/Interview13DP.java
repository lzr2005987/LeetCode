package com.leetcode.interview;

public class Interview13DP {
    int sum = 0;

    public int movingCount(int m, int n, int k) {
        boolean[][] table = new boolean[m][n];
        if (k >= 0) {
            table[0][0] = true;
            sum++;
        } else {
            table[0][0] = false;
        }
        for (int i = 1; i < m; i++) {
            if (table[i - 1][0] && compare(i) <= k) {
                table[i][0] = true;
                sum++;
            } else {
                break;
            }
        }
        for (int j = 1; j < n; j++) {
            if (table[0][j - 1] && compare(j) <= k) {
                table[0][j] = true;
                sum++;
            } else {
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (compare(i) + compare(j) <= k && (table[i - 1][j] || table[i][j - 1])) {
                    table[i][j] = true;
                    sum++;
                }
            }
        }
        return sum;
    }

    private int compare(int n) {
        int sum = 0;
        while (n > 0) {
            sum = sum + (n % 10);
            n = n / 10;
        }
        return sum;
    }
}
