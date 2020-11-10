package com.leetcode.no901_950;

public class No925 {
    public boolean isLongPressedName(String name, String typed) {
        int t = 0, n = 0;
        while (t < typed.length()) {
            if (n > name.length()) break;
            char cn;
            if (n == name.length()) {
                cn = ' ';
            } else {
                cn = name.charAt(n);
            }
            char ct = typed.charAt(t);
            if (cn == ct) {
                n++;
                t++;
            } else if (t > 0 && ct == typed.charAt(t - 1)) {
                t++;
            } else {
                break;
            }
        }
        return n == name.length() && t == typed.length();
    }
}
