package com.leetcode.no1_50;

public class No3 {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int i = 0, j = 1;
        while (i < s.length() && j <= s.length()) {
            String sub = s.substring(i, j);
            String preSub = s.substring(i, j - 1);
            if (preSub.contains(String.valueOf(s.charAt(j - 1)))) {
                while (s.charAt(i) != s.charAt(j - 1)) {
                    i++;
                }
                i++;
            } else {
                j++;
                max = Math.max(max, sub.length());
            }
        }
        return max;
    }
}
