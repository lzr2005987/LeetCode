package com.leetcode.no1_50;

public class No7 {
    public int reverse(int x) {
        boolean isNegative = false;
        if (Math.abs(x) > Math.pow(2, 31)) {
            return 0;
        }
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        if (s.startsWith("-")) {
            isNegative = true;
        }
        StringBuilder sb = new StringBuilder();
        int start = 0;
        if (isNegative) {
            start = 1;
        }
        for (int i = s.length() - 1; i >= start; i--) {
            sb.append(chars[i]);
        }
        try {
            if (!isNegative) {
                return Integer.valueOf(sb.toString());
            } else {
                return Integer.valueOf((new StringBuilder("-").append(sb)).toString());
            }
        } catch (NumberFormatException e) {
            return 0;
        }

    }
}
