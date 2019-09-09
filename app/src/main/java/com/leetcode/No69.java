package com.leetcode;

public class No69 {
    public int mySqrt(int x) {
        double dx = x;
        double i = 1;
        if (x == 0) {
            return 0;
        }
        while (true) {
            if (i * i <= dx && (i + 1) * (i + 1) > dx) {
                return (int) i;
            }
            i++;
        }
    }
}
