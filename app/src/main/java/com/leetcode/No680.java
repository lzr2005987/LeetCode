package com.leetcode;

public class No680 {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return isValid(s.substring(i + 1, j + 1)) || isValid(s.substring(i, j));
            }
        }
        return true;
    }

    private boolean isValid(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}
