package com.leetcode.no201_250;

public class No204 {
    public int countPrimes(int n) {
        boolean[] b = new boolean[n + 1];
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (!b[i]) {
                ans++;
            }
            int m = 2;
            while (i * m <= n) {
                b[i * m] = true;
                m++;
            }
        }
        return ans;
    }
}
