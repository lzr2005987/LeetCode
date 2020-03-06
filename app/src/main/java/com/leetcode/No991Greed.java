package com.leetcode;

public class No991Greed {
    public int brokenCalc(int X, int Y) {
        int ans = 0;
        while (X < Y) {
            if (Y % 2 == 0) {
                Y = Y / 2;
            } else {
                Y++;
            }
            ans++;
        }
        return ans + X - Y;
    }
}
