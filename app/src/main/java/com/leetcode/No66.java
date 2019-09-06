package com.leetcode;

public class No66 {
    public int[] plusOne(int[] digits) {
        digits[digits.length - 1]++;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i > 0 && digits[i] >= 10) {
                digits[i - 1] += digits[i] / 10;
                digits[i] = digits[i] % 10;
            }
        }
        if (digits[0] >= 10) {
            int[] copy = new int[digits.length + 1];
            copy[0] = digits[0] / 10;
            copy[1] = digits[0] % 10;
            for (int i = 2; i <= digits.length; i++) {
                copy[i] = digits[i - 1];
            }
            return copy;
        }
        return digits;
    }
}
