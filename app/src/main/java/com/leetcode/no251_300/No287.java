package com.leetcode.no251_300;

import java.util.HashMap;

public class No287 {
    public int findDuplicate(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                return i;
            } else {
                map.put(i, true);
            }
        }
        return 1;
    }
}
