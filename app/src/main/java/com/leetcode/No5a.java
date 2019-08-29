package com.leetcode;

import android.util.Log;

public class No5a {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 0) {
            return "";
        } else if (len == 1) {
            return s;
        }
        int start = 0;
        int max = 1;
        char[] chars = s.toCharArray();
        int[][] result = new int[len][len];//result[i][j]表示从i到j的最大回文长度
        for (int i = 0; i < len; i++) {
            result[i][i] = 1;
            if (i < len - 1 && chars[i + 1] == chars[i]) {
                result[i][i + 1] = 1;
                start = i;
                max = 2;
            }
        }

        for (int l = 3; l <= len; l++) {
            for (int i = 0; i + l - 1 < len; i++) {
                if (chars[i] == chars[i + l - 1] && result[i + 1][i + l - 2] == 1) {
                    result[i][i + l - 1] = 1;
                    if (l > max) {
                        max = l;
                        start = i;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < start + max; i++) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

}
