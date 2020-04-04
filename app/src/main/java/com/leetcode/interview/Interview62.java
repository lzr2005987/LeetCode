package com.leetcode.interview;

public class Interview62 {
    public int lastRemaining(int n, int m) {
        if (n == 1) {
            return 0;
        } else {
            return (m + lastRemaining(n - 1, m)) % n;
        }
    }
}
