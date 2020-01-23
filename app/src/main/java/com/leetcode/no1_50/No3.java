package com.leetcode.no1_50;

import java.util.HashSet;
import java.util.Set;

public class No3 {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int i = 0, j = 0;
        while (i < s.length() && j <= s.length()) {
            String sub = s.substring(i, j);
            if (isRepeat(sub)) {
                i++;
            } else {
                max = Math.max(max, j - i);
                j++;
            }
        }
        return max;
    }

    private boolean isRepeat(String sub) {
        char[] chars = sub.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c : chars) {
            if (set.contains(c)) return true;
            set.add(c);
        }
        return false;
    }
}
