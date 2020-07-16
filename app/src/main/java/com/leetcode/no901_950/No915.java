package com.leetcode.no901_950;

public class No915 {
    public int partitionDisjoint(int[] A) {
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        int min = Integer.MAX_VALUE, max = 0;
        for (int i = 0; i < A.length; i++) {
            left[i] = max = Math.max(max, A[i]);
            right[A.length - 1 - i] = min = Math.min(min, A[A.length - 1 - i]);
        }
        for (int i = 0; i < A.length - 1; i++) {
            if (left[i] <= right[i + 1]) {
                return i + 1;
            }
        }
        return A.length;
    }
}
