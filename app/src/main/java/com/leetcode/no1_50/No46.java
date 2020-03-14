package com.leetcode.no1_50;

import java.util.ArrayList;
import java.util.List;

public class No46 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new int[nums.length], 0);
        return ans;
    }

    private void backtrack(int[] nums, int[] cur, int curPos) {
        for (int i = 0; i < nums.length; i++) {
            boolean b = false;
            if (curPos > 0) {
                for (int j = 0; j < curPos; j++) {
                    if (cur[j] == nums[i]) {
                        b = true;
                        break;
                    }
                }
            }
            if (b) {
                continue;
            }
            cur[curPos] = nums[i];
            if (curPos == nums.length - 1) {
                ans.add(convert(cur));
            } else {
                backtrack(nums, cur, curPos + 1);
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
