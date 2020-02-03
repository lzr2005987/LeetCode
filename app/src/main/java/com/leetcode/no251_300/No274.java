package com.leetcode.no251_300;

public class No274 {
    public int hIndex(int[] citations) {
        int max = 0;
        for (int i = 0; i < citations.length; i++) {
            if (max < citations[i]) {
                int count = 0;
                for (int j = 0; j < citations.length; j++) {
                    if (citations[j] >= citations[i]) {
                        count++;
                    }
                    if (count >= citations[i]) {
                        max = count;
                        break;
                    }
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
