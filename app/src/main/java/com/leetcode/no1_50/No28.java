package com.leetcode.no1_50;

public class No28 {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.equals("")) {
            return 0;
        }
        return haystack.indexOf(needle);
    }
}
