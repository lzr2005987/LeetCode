package com.leetcode.no1_50;

public class No8 {
    public int myAtoi(String str) {
        if (str == null || str.trim().length() == 0) {
            return 0;
        }
        String num = "0123456789";
        String symbol = "+-";
        int result = 0;
        boolean isNegtive = false;
        int start = 0;
        StringBuilder sb = new StringBuilder();
        char[] chars = str.trim().toCharArray();
        if (!num.contains(String.valueOf(chars[0])) && !symbol.contains(String.valueOf(chars[0]))) {
            return 0;
        }
        if (str.trim().startsWith("-")) {
            isNegtive = true;
        }
        if (symbol.contains(String.valueOf(chars[0]))) {
            start = 1;
        }
        for (int i = start; i < chars.length; i++) {
            if (num.contains(String.valueOf(chars[i]))) {
                sb.append(chars[i]);
            } else {
                break;
            }
        }
        try {
            //"+"
            if (sb.toString().length()==0){
                return 0;
            }
            result = Integer.valueOf(sb.toString());
            if (isNegtive) {
                return -result;
            } else {
                return result;
            }
        } catch (NumberFormatException e) {
            if (isNegtive) {
                return -2147483648;
            } else {
                return 2147483647;
            }
        }
    }

}
