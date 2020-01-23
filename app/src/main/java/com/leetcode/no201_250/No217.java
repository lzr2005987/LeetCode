package com.leetcode.no201_250;

import java.util.HashMap;

public class No217 {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) {
                return true;
            } else {
                map.put(n, true);
            }
        }
        return false;
    }
}
