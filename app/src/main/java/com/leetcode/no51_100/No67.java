package com.leetcode.no51_100;

public class No67 {
    public String addBinary(String a, String b) {
        int lenA = a.length(), lenB = b.length();
        int i = lenA - 1, j = lenB - 1;
        int plus = 0;
        String res = "";
        while (i >= 0 || j >= 0) {
            String ca, cb;
            if (i >= 0 && j >= 0) {
                ca = a.substring(i, i + 1);
                cb = b.substring(j, j + 1);
            } else if (i < 0) {
                ca = "0";
                cb = b.substring(j, j + 1);
            } else {
                ca = a.substring(i, i + 1);
                cb = "0";
            }

            int s = Integer.parseInt(ca) + Integer.parseInt(cb) + plus;
            if (s < 2) {
                res = s + res;
                plus = 0;
            } else {
                res = (s - 2) + res;
                plus = 1;
            }
            i--;
            j--;
        }
        if (plus == 0) {
            return res;
        } else {
            return "1" + res;
        }
    }
}
