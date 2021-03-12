package com.leetcode.no801_850;

public class No832 {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int[] line = A[i];
            int len = line.length;
            for (int j = 0; j < len / 2; j++) {
                if (line[j] == line[len - 1 - j]) {
                    if (line[j] == 0) {
                        line[j] = 1;
                        line[len - 1 - j] = 1;
                    } else {
                        line[j] = 0;
                        line[len - 1 - j] = 0;
                    }
                }
            }
            if (len % 2 == 1) {
                if (line[len / 2] == 0) {
                    line[len / 2] = 1;
                } else {
                    line[len / 2] = 0;
                }
            }
        }
        return A;
    }
}
