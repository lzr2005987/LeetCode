package com.leetcode.no901_950;

public class No941 {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3 || A[0] >= A[1] || A[A.length - 1] >= A[A.length - 2]) {
            return false;
        }
        int i = 1;
        for (; i < A.length; i++) {
            if (A[i] == A[i - 1]) {
                return false;
            } else if (A[i] < A[i - 1]) {
                break;
            }
        }
        for (; i < A.length; i++) {
            if (A[i] >= A[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
