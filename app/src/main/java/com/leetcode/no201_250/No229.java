package com.leetcode.no201_250;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class No229 {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        if (nums.length < 3) {
            for (int n : nums) {
                if (!list.contains(n)) list.add(n);
            }
            return list;
        }

        for (int n : nums) {
            if (map.containsKey(n)) {
                int t = map.get(n);
                map.put(n, t + 1);
                if (t + 1 > nums.length / 3 && !list.contains(n)) {
                    list.add(n);
                }
            } else {
                map.put(n, 1);
                if (1 > nums.length / 3 && !list.contains(n)) {
                    list.add(n);
                }
            }
        }
        return list;
    }
}
