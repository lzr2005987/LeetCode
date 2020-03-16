package com.leetcode;

public class No1013 {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        if (sum % 3 != 0) {
            return false;
        }
        sum = sum / 3;
        int sum1 = 0;
        int pos = 0;
        for (int i = 0; i < A.length; i++) {
            sum1 += A[i];
            pos = i;
            if (sum1 == sum) {
                break;
            }
        }
        if (sum1 != sum) {
            return false;
        }
        int sum2 = 0;
        for (int i = pos + 1; i < A.length - 1; i++) {
            sum2 += A[i];
            if (sum2 == sum) {
                return true;
            }
        }
        return false;
    }
}
