package com.leetcode.no301_350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class No349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (int n : nums1) {
            map.put(n, true);
        }
        for (int n : nums2) {
            if (map.containsKey(n)) {
                ans.add(n);
                map.remove(n);
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}
