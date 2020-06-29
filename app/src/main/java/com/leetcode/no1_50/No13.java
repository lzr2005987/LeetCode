package com.leetcode.no1_50;

public class No13 {
    public int romanToInt(String s) {
        int len = s.length() - 1;
        char temp = ' ';
        int ans = 0;
        for (int i = len; i >= 0; i--) {
            char c = s.charAt(i);
            int num = getNum(c);
            if (temp != ' ') {
                ans = isMinus(c, temp) ? ans - num : ans + num;
            } else {
                ans = ans + num;
            }
            temp = c;
        }
        return ans;
    }

    private int getNum(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }

    private boolean isMinus(char a, char b) {
        if ((a == 'I' && b == 'V' || a == 'I' && b == 'X') ||
                (a == 'X' && b == 'L' || a == 'X' && b == 'C') ||
                (a == 'C' && b == 'D' || a == 'C' && b == 'M')) {
            return true;
        } else {
            return false;
        }
    }
}
