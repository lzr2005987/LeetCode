package com.leetcode.no1_50;

public class No5 {
    public String longestPalindrome(String s) {
        int max = 0;
        String ans = "";
        int len = s.length();
        for (int i = 0; i <= len - 1; i++) {
            for (int j = i + 1; j <= len; j++) {
                String substring = s.substring(i, j);
                if (isPalindromic(substring) && substring.length() > max) {
                    max = substring.length();
                    ans = substring;
                }
            }
        }
        return ans;
    }

    private boolean isPalindromic(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int i = 0, j = len - 1;
        int mid = (len - 1) / 2;
        while (i <= mid) {
            if (chars[i] != chars[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
