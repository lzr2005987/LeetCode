package com.leetcode.no301_350;

import java.util.HashMap;
import java.util.Set;

public class No347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[k];
        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }
        Set<Integer> keys = map.keySet();
        for (int i = 0; i < k; i++) {
            int max = 0;
            int maxKey = 0;
            for (int key : keys) {
                if (max < map.get(key)) {
                    max = map.get(key);
                    maxKey = key;
                }
            }
            ans[i] = maxKey;
            map.remove(maxKey);
        }
        return ans;
    }
}
