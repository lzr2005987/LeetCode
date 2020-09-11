package com.leetcode.no201_250;

import java.util.ArrayList;
import java.util.List;

public class No216 {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(new ArrayList<Integer>(), k, n, 0, 1);
        return ans;
    }

    private void backtrack(List<Integer> curList, int k, int n, int sum, int start) {
        if (sum > n) {
            return;
        }
        if (curList.size() == k - 1) {
            int rest = n - sum;
            if (rest > curList.get(curList.size() - 1) && rest <= 9) {
                curList.add(rest);
                ans.add(curList);
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            List<Integer> nextList = new ArrayList<>(curList);
            if (!nextList.contains(i)) {
                nextList.add(i);
                backtrack(nextList, k, n, sum + i, i + 1);
            }
        }
    }
}
