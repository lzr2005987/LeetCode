package com.leetcode.no801_850;

import java.util.ArrayList;
import java.util.List;

public class No830 {
    public List<List<Integer>> largeGroupPositions(String s) {
        int start = 0, end = 0;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == 0) {
                continue;
            } else if (c == s.charAt(i - 1)) {
                end = i;
            } else {
                if (end - start >= 2) {
                    List<Integer> solution = new ArrayList<>();
                    solution.add(start);
                    solution.add(end);
                    ans.add(solution);
                }
                start = i;
                end = i;
            }
        }
        if (end - start >= 2) {
            List<Integer> solution = new ArrayList<>();
            solution.add(start);
            solution.add(end);
            ans.add(solution);
        }
        return ans;
    }
}
