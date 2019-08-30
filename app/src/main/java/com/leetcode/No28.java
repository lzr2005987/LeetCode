package com.leetcode;

public class No28 {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.equals("")) {
            return 0;
        }
        return haystack.indexOf(needle);
    }
}
