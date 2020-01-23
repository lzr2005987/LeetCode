package com.leetcode.no151_200;

public class No179 {
    public String largestNumber(int[] nums) {
        int t = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i; j < nums.length; j++) {
                if (!isLarger(String.valueOf(nums[i]), String.valueOf(nums[j]))) {
                    t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int n : nums) {
            if (sb.length() > 0 || n > 0) {
                sb.append(n);
            }
        }
        if (sb.length() == 0) {
            return "0";
        } else {
            return sb.toString();
        }
    }

    private boolean isLarger(String a, String b) {
        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();
        int len = charA.length >= charB.length ? charA.length : charB.length;
        for (int i = 0; i < len; i++) {
            if (i < charA.length && i < charB.length && charA[i] != charB[i]) {
                return charA[i] > charB[i];
            } else if (i >= charA.length) {
                for (char c : charA) {
                    if (c != charB[i]) {
                        return c > charB[i];
                    }
                }
            } else if (i >= charB.length) {
                for (char c : charB) {
                    if (c != charA[i]) {
                        return c < charA[i];
                    }
                }
            }
        }
        return true;
    }
}
