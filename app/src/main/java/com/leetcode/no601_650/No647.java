package com.leetcode.no601_650;

public class No647 {
    public int countSubstrings(String s) {
        int len = s.length();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len + 1; j++) {
                StringBuilder sub = new StringBuilder(s.substring(i, j));
                if (sub.toString().equals(sub.reverse().toString())) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
