package com.leetcode.no1_50;

import java.util.ArrayList;
import java.util.List;

public class No39 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        search(new ArrayList<Integer>(), candidates, 0, 0, target);
        return ans;
    }

    private void search(List<Integer> list, int[] candidates, int total, int pos, int target) {
        for (int i = pos; i < candidates.length; i++) {
            if (total + candidates[i] == target) {
                List<Integer> newList = new ArrayList<>(list);
                newList.add(candidates[i]);
                ans.add(newList);
            } else if (total + candidates[i] < target) {
                List<Integer> newList = new ArrayList<>(list);
                newList.add(candidates[i]);
                search(newList, candidates, total + candidates[i], i, target);
            }
        }
    }
}
