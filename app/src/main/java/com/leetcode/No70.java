package com.leetcode;

public class No70 {
    public int climbStairs(int n) {
        return climb(0, n);
    }

    private int climb(int index, int n) {
        if (index == n) {
            return 1;
        } else if (n - index == 1) {
            return 1;
        } else if (n - index == 2) {
            return 2;
        } else {
            return climb(index + 1, n) + climb(index + 2, n);
        }
    }
}
