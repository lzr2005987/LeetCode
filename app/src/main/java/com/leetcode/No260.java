package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class No260 {
    public int[] singleNumber(int[] nums) {
        HashMap<Boolean, ArrayList<Integer>> map = new HashMap<>();
        map.put(true, new ArrayList<Integer>());
        map.put(false, new ArrayList<Integer>());
        for (int n : nums) {
            ArrayList<Integer> trueList = map.get(true);
            ArrayList<Integer> falseList = map.get(false);
            if (falseList.contains(n)) {
                continue;
            }
            if (trueList.contains(n)) {
                trueList.remove((Integer) n);
                falseList.add(n);
            } else {
                trueList.add(n);
            }
        }
        ArrayList<Integer> resList = map.get(true);
        int[] result = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            result[i] = resList.get(i);
        }
        return result;
    }
}
