package com.leetcode.no951_1000;

public class No977 {
    public int[] sortedSquares(int[] A) {
        int[] ans = new int[A.length];
        int p = 0, l = 0, r = 0;
        for (int i = 0; i < A.length; i++) {
            l = i - 1;
            r = i;
            if (A[i] >= 0) {
                l = i - 1;
                r = i;
                break;
            }
        }
        while (l >= 0 || r <= A.length - 1) {
            int min = -1;
            if (l >= 0) {
                min = A[l] * A[l];
            }
            if (r <= A.length - 1) {
                if (min > A[r] * A[r] || min == -1) {
                    min = A[r] * A[r];
                    r++;
                } else {
                    l--;
                }
            } else {
                l--;
            }
            ans[p] = min;
            p++;
        }
        return ans;
    }
}
