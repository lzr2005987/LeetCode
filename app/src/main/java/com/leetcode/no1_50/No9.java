package com.leetcode.no1_50;

public class No9 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        int len = s.length();
        if (len % 2 == 0 && chars[len / 2 - 1] != chars[len / 2]) {
            return false;
        }
        for (int i = 0; i < len / 2; i++) {
            if (chars[i] != chars[len - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(int x, boolean b) {
        if (x < 0) {
            return false;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        return sb.toString().equals(sb.reverse().toString());
    }
}
