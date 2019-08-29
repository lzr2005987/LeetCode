package com.leetcode;

public class No6 {
    public String convert(String s, int numRows) {
        int len = s.length();
        char[] chars = s.toCharArray();
        char[][] result = new char[len][len];
        int i = 0, j = 0;
        boolean isReverse = false;
        for (int k = 0; k < chars.length; k++) {
            result[i][j] = chars[k];
            if (!isReverse) {
                i++;
            } else {
                i--;
            }
            if (i == -1) {
                isReverse = false;
                if (numRows < 2) {
                    i++;
                } else {
                    i = i + 2;
                }
                j++;
            } else if (i == numRows) {
                isReverse = true;
                if (numRows < 2) {
                    i--;
                } else {
                    i = i - 2;
                }
                j++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int m = 0; m < result.length; m++) {
            for (int n = 0; n < result[m].length; n++) {
                if (!String.valueOf(result[m][n]).equals("\u0000")) {
                    sb.append(result[m][n]);
                }
            }
        }
        return sb.toString();
    }
}
