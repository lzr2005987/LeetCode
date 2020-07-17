package com.leetcode.no51_100;

import java.util.ArrayList;
import java.util.List;

public class No78 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        for (int i = 0; i < nums.length + 1; i++) {
            List<Integer> cur = new ArrayList<>();
            backTrack(0, nums, cur, i);
        }
        return ans;
    }

    public void backTrack(int first, int[] nums, List<Integer> cur, int size) {
        if (size == 0) {
            ans.add(cur);
            return;
        }
        for (int i = first; i < nums.length; i++) {
            cur.add(nums[i]);
            List<Integer> list = new ArrayList<>(cur);
            backTrack(i + 1, nums, list, size - 1);
            cur.remove(cur.size() - 1);
        }
    }
}
