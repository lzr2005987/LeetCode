package com.leetcode.standard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BackTrack {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permutation(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        backTrack(list, n, 0);
        return ans;
    }

    private void backTrack(List<Integer> list, int n) {
        if (list.size() == n) {
            ans.add(list);
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!list.contains(i)) {
                list.add(i);
                List<Integer> cur = new ArrayList<>(list);
                backTrack(cur, n);
                list.remove(cur.size() - 1);
            }
        }
    }

    private void backTrack(List<Integer> list, int n, int start) {
        ans.add(list);
        for (int i = start + 1; i < n; i++) {
            List<Integer> cur = new ArrayList<>(list);
            Collections.swap(cur, start, i);
            backTrack(cur, n, start + 1);
        }
    }

    public int timeCount(int n) {
        int sum = 0;
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= k; i++) {
                int a = 1;
                int b = 1;
                int c = 1;
                for (int j = 1; j <= n; j++) {
                    a = a * j;
                }
                for (int j = 1; j <= k; j++) {
                    b = b * j;
                }
                for (int j = 1; j <= n - k; j++) {
                    c = c * j;
                }
                sum = sum + (a / (b * c));
            }
        }
        return sum;
    }

}
