package com.leetcode.no51_100;

import java.util.ArrayList;
import java.util.List;

public class No77 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        backTrack(new ArrayList<Integer>(), list, 0, n, k);
        return ans;
    }

    private void backTrack(List<Integer> list, List<Integer> restList, int p, int n, int k) {
        if (list.size() == k) {
            ans.add(list);
            return;
        }
        for (int i = p; i < restList.size(); i++) {
            list.add(restList.get(i));
            List<Integer> newRestList = new ArrayList<>();
            newRestList.addAll(restList);
            newRestList.remove(i);
            List<Integer> newList = new ArrayList<>();
            newList.addAll(list);
            backTrack(newList, newRestList, i, n, k);
            list.remove(list.size() - 1);
        }
    }
}
