package com.leetcode.no451_500;

import java.util.Arrays;

public class No455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, ans = 0;
        for (int si : s) {
            if (i >= g.length) {
                break;
            }
            if (g[i] <= si) {
                i++;
                ans++;
            }
        }

        return ans;
    }
}
