package com.leetcode;

public class No125 {
    public boolean isPalindrome(String s) {
        s = s.trim();
        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (right > left) {
            try {
                while ((chars[left] < 'a') && (chars[left] > '9') || chars[left] > 'z' || chars[left] < '0') {
                    left++;
                }
                while ((chars[right] < 'a') && (chars[right] > '9') || chars[right] > 'z' || chars[right] < '0') {
                    right--;
                }
                if (chars[left] == chars[right]) {
                    left++;
                    right--;
                } else {
                    return false;
                }
            } catch (Exception e) {

            }
        }
        return true;
    }
}
