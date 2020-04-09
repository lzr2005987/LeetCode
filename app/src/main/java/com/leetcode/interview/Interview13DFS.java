package com.leetcode.interview;

import java.util.ArrayList;
import java.util.HashMap;

public class Interview13DFS {
    int sum = 0;
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

    public int movingCount(int m, int n, int k) {
        dfs(0, 0, m, n, k);
        return sum;
    }

    private void dfs(int i, int j, int m, int n, int k) {
        if (map.containsKey(i) && map.get(i).contains(j)) {
            return;
        }
        if (compare(i) + compare(j) <= k) {
            sum++;
            if (!map.containsKey(i)) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(j);
                map.put(i, list);
            } else {
                ArrayList<Integer> list = map.get(i);
                list.add(j);
                map.put(i, list);
            }
            //不需要向上或向左
//            if (i > 0) {
//                dfs(i - 1, j, m, n, k);
//            }
//            if (j > 0) {
//                dfs(i, j - 1, m, n, k);
//            }
            if (i < m - 1) {
                dfs(i + 1, j, m, n, k);
            }
            if (j < n - 1) {
                dfs(i, j + 1, m, n, k);
            }
        }
    }

    private int compare(int n) {
        int sum = 0;
        while (n > 0) {
            sum = sum + (n % 10);
            n = n / 10;
        }
        return sum;
    }
}
