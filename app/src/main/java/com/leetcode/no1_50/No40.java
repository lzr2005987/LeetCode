package com.leetcode.no1_50;

import java.util.ArrayList;
import java.util.List;

public class No40 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        search(new ArrayList<Integer>(), candidates, 0, -1, target);
        return ans;
    }

    private void search(List<Integer> list, int[] candidates, int total, int pos, int target) {
        for (int i = pos + 1; i < candidates.length; i++) {
            if (total + candidates[i] == target) {
                List<Integer> newList = new ArrayList<>(list);
                newList.add(candidates[i]);
                boolean isSame = false;
                for (int j = 0; j < ans.size(); j++) {
                    if (checkDifferent(ans.get(j), newList)) {
                        isSame = true;
                    }
                }
                if (!isSame) {
                    ans.add(newList);
                }
            } else if (total + candidates[i] < target) {
                List<Integer> newList = new ArrayList<>(list);
                newList.add(candidates[i]);
                search(newList, candidates, total + candidates[i], i, target);
            }
        }
    }

    private boolean checkDifferent(List<Integer> list, List<Integer> list1) {
        if (list.size() != list1.size()) {
            return false;
        }
        List<Integer> newList = new ArrayList<>(list1);
        for (Integer str : list) {
            if (!newList.contains(str)) {
                return false;
            } else {
                newList.remove(str);
            }
        }
        return true;
    }
}
