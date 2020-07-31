package com.leetcode.no301_350;

public class No343 {
    public int integerBreak(int n) {
        int max = 0;
        int[] list = new int[n + 1];
        list[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            for (int j = 2; j < i; j++) {
                max = Math.max(max, Math.max(j, list[j]) * Math.max(i - j, list[i - j]));
            }
            list[i] = max;
            max = 0;
        }
        return list[n];
    }
}
