package com.leetcode.no301_350;

import java.util.ArrayList;
import java.util.List;

public class No336 {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                addAns(words[i] + words[j], i, j, ans);
                addAns(words[j] + words[i], j, i, ans);
            }
        }
        return ans;
    }

    private void addAns(String s, int i, int j, List<List<Integer>> ans) {
        StringBuilder sb = new StringBuilder(s);
        if (sb.toString().equals(sb.reverse().toString())) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            list.add(j);
            ans.add(list);
        }
    }
}
