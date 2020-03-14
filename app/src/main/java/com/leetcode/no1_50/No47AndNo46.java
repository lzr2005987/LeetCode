package com.leetcode.no1_50;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class No47AndNo46 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Set set = new HashSet();
        backtrack(nums, new int[nums.length], 0, new Stack<Integer>());
        List<List<Integer>> finalList = new ArrayList();
        set.addAll(ans);
        finalList.addAll(set);
        return finalList;
    }

    private void backtrack(int[] nums, int[] cur, int curPos, Stack<Integer> record) {
        for (int i = 0; i < nums.length; i++) {
            if (record.contains(i)) {
                continue;
            }
            cur[curPos] = nums[i];
            if (curPos == nums.length - 1) {
                ans.add(convert(cur));
            } else {
                record.push(i);
                backtrack(nums, cur, curPos + 1, record);
                record.pop();
            }
        }
    }

    private List<Integer> convert(int[] list) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < list.length; i++) {
            ans.add(list[i]);
        }
        return ans;
    }
}
