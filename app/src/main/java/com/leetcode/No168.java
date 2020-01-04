package com.leetcode;

public class No168 {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            char c = (char) (n % 26);
            if (c == 0) {
                c = 26;
                n--;
            }
            c = (char) ('A' + c - 1);
            n = n / 26;
            sb.insert(0, c);
        }
        return sb.toString();
    }
}
