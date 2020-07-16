package com.leetcode.no901_950;

public class No945Array {
    public int minIncrementForUnique(int[] A) {
        boolean[] list = new boolean[80000];
        int ans = 0;
        for (int a : A) {
            if (!list[a]) {
                list[a] = true;
            } else {
                for (int i = a + 1; i < 80000; i++) {
                    if (!list[i]) {
                        list[i] = true;
                        ans = ans + i - a;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
