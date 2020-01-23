package com.leetcode.no151_200;

public class No172 {
    public int trailingZeroes(int n) {
        int sum = 0;
        if (n < 5) {
            return 0;
        }
        for (int i = 5; i <= n; i = i + 5) {
            sum += calculate(i);
        }
        return sum;
    }

    private int calculate(int n) {
        int num = 0;
        while (n >= 5) {
            if (n % 5 == 0) {
                num++;
                n = n / 5;
            } else {
                return num;
            }
        }
        return num;
    }
}
