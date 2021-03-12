package com.leetcode;

public class No1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int max = 0;
        int left = 0;
        int cur = 0;
        int ans = 0;
        for (int i = 0; i < X; i++) {
            if (grumpy[i] == 1) {
                max += customers[i];
            }
        }
        cur = max;
        for (int i = 1; i < grumpy.length - X + 1; i++) {
            if (grumpy[i - 1] == 1) {
                cur -= customers[i - 1];
            }
            if (grumpy[i + X - 1] == 1) {
                cur += customers[i + X - 1];
            }
            if (cur > max) {
                max = cur;
                left = i;
            }
        }
        for (int i = 0; i < grumpy.length; i++) {
            if (grumpy[i] == 0 || (i >= left) && (i <= left + X - 1)) {
                ans += customers[i];
            }
        }
        return ans;
    }
}
