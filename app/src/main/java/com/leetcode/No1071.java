package com.leetcode;

public class No1071 {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int len1 = str1.length();
        int len2 = str2.length();
        while (len1 > 0 && len2 > 0) {
            if (len1 >= len2) {
                len1 = len1 % len2;
            } else {
                len2 = len2 % len1;
            }
        }
        int l = Math.max(len1, len2);
        return str2.substring(0, l);
    }
}
