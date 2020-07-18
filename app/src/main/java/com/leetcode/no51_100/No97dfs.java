package com.leetcode.no51_100;

public class No97dfs {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() == 0) {
            return s3.equals(s2);
        }
        if (s2.length() == 0) {
            return s3.equals(s1);
        }
        return dfs(s1, 0, s2, 0, s3, 0);
    }

    private boolean dfs(String s1, int p1, String s2, int p2, String s3, int p3) {
        char c1 = s1.charAt(p1);
        char c2 = s2.charAt(p2);
        char c3 = s3.charAt(p3);
        if (c3 != c1 && c3 != c2) {
            return false;
        }
        boolean b1 = false, b2 = false;
        if (c3 == c1) {
            if (p1 == s1.length() - 1) {
                if (p3 == s3.length() - 1) {
                    return false;
                } else if (s3.substring(p3 + 1).equals(s2.substring(p2))) {
                    return true;
                }
            } else {
                b1 = dfs(s1, p1 + 1, s2, p2, s3, p3 + 1);
            }
        }
        if (c3 == c2) {
            if (p2 == s2.length() - 1) {
                if (p3 == s3.length() - 1) {
                    return false;
                } else if (s3.substring(p3 + 1).equals(s1.substring(p1))) {
                    return true;
                }
            } else {
                b2 = dfs(s1, p1, s2, p2 + 1, s3, p3 + 1);
            }
        }
        return b1 || b2;
    }
}
