package com.leetcode.interview;

public class Interview64 {
    public int sumNums(int n) {
        boolean flag = n > 0 && (n = n + sumNums(n - 1)) > 0;
        return n;
    }
}
