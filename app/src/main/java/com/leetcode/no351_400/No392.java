package com.leetcode.no351_400;

public class No392 {
    public boolean isSubsequence(String s, String t) {
        int sp = 0, tp = 0;
        if (s.length() == 0) {
            return true;
        }
        while (sp < s.length() && tp < t.length()) {
            char sc = s.charAt(sp);
            char tc = t.charAt(tp);
            if (sc == tc) {
                if (sp == s.length() - 1) {
                    return true;
                } else {
                    sp++;
                }
            }
            if (tp == t.length() - 1) {
                return false;
            } else {
                tp++;
            }
        }
        return false;
    }
}
