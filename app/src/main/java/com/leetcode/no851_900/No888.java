package com.leetcode.no851_900;

import java.util.Arrays;

public class No888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int sumA = 0, sumB = 0;
        int i = 0, j = 0;
        for (int a : A) {
            sumA += a;
        }
        for (int b : B) {
            sumB += b;
        }
        while (i < A.length && j < B.length) {
            if (sumA - A[i] + B[j] == sumB - B[j] + A[i]) {
                int[] ans = new int[2];
                ans[0] = A[i];
                ans[1] = B[j];
                return ans;
            } else if (sumA - A[i] + B[j] < sumB - B[j] + A[i]) {
                j++;
            } else {
                i++;
            }
        }
        return null;
    }
}
