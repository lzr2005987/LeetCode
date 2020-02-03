package com.leetcode.no251_300;

public class No275 {
    public int hIndex(int[] citations) {
        int max = 0;
        for (int i = 0; i < citations.length; i++) {
            int len = citations.length - i;
            if (citations[i] >= len) {
                max = Math.max(max, len);
            } else {
                max = Math.max(max, citations[i]);
            }
        }
        return max;
    }
}
