package com.leetcode.no51_100;

import java.util.ArrayList;
import java.util.List;

public class No60OutOfTime {
    private int curPos = 0;
    private List<Integer> res;

    public String getPermutation(int n, int k) {
        List<Integer> next = new ArrayList<>();
        backTrack(next, n, k);
        StringBuilder sb = new StringBuilder();
        for (int i : res) {
            sb.append(i);
        }
        return sb.toString();
    }

    private void backTrack(List<Integer> cur, int n, int k) {
        if (curPos == k) {
            return;
        }
        if (n == cur.size()) {
            curPos++;
            if (curPos == k) {
                res = new ArrayList<>(cur);
            }
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!cur.contains(i)) {
                List<Integer> next = new ArrayList<>(cur);
                next.add(i);
                backTrack(next, n, k);
            }
        }
    }
}