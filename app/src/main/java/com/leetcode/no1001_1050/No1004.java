package com.leetcode.no1001_1050;

public class No1004 {
    public int longestOnes(int[] A, int K) {
        int left = 0, right = 0;
        int ans = 0;
        int count = 0;
        if (A[0] == 0) {
            count = 1;
        } else {
            ans = 1;
        }
        while (right < A.length) {
            if (count <= K) {
                right++;
                if (right >= A.length) {
                    break;
                }
                if (A[right] == 0) {
                    count++;
                }
                if (count <= K) {
                    ans = Math.max(right - left + 1, ans);
                }
            } else {
                if (A[left] == 0) {
                    count--;
                    left++;
                    if (left >= A.length) {
                        break;
                    }
                    continue;
                }
                while (A[left] == 1) {
                    left++;
                }
            }
        }
        return ans;
    }
}
