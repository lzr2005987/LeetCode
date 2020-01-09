package com.leetcode;

public class No172Better {
    public int trailingZeroes(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n / 5;
            n /= 5;
        }
        return sum;
    }
}
