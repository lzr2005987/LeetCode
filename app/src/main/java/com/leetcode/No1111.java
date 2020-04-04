package com.leetcode;

public class No1111 {
    public int[] maxDepthAfterSplit(String seq) {
        char[] chars = seq.toCharArray();
        int d = 0;
        int[] ans = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                ans[i] = d % 2;
                d++;
            } else {
                ans[i] = d % 2;
                d--;
            }
        }
        return ans;
    }
}
