package com.leetcode.no251_300;

public class No278 {
    private boolean isBadVersion(int n) {
        return n % 2 == 0;
    }

    public int firstBadVersion(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return isBadVersion(1) ? 1 : 2;
        } else {
            return binary(1, n);
        }
    }

    private int binary(int start, int end) {
        int mid = start + (end - start) / 2;
        boolean prev, cur;
        cur = isBadVersion(mid);
        if (mid > 1) {
            prev = isBadVersion(mid - 1);
            if (!prev && cur) {
                return mid;
            } else if (!prev && !cur) {
                return binary(mid + 1, end);
            } else {
                return binary(start, mid - 1);
            }
        } else {
            return isBadVersion(1) ? 1 : 2;
        }
    }
}
