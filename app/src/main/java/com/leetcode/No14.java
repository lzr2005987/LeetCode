package com.leetcode;

public class No14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int len = strs[0].length();
        for (String s : strs) {
            if (s.length() < len) {
                len = s.length();
            }
        }
        for (int i = 0; i < len; i++) {
            char c = strs[0].toCharArray()[i];
            for (String s : strs) {
                if (c != s.toCharArray()[i]) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
