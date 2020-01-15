package com.leetcode;

import java.util.HashMap;

public class No128 {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                continue;
            }
            if (map.containsKey(num - 1) && !map.containsKey(num + 1)) {
                int length = map.get(num - 1) + 1;
                map.put(num, length);
                map.put(num - map.get(num - 1), length);
                max = Math.max(max, length);
            } else if (!map.containsKey(num - 1) && map.containsKey(num + 1)) {
                int length = map.get(num + 1) + 1;
                map.put(num, length);
                map.put(num + map.get(num + 1), length);
                max = Math.max(max, length);
            } else if (map.containsKey(num - 1) && map.containsKey(num + 1)) {
                int length = map.get(num + 1) + 1 + map.get(num - 1);
                map.put(num, length);
                map.put(num - map.get(num - 1), length);
                map.put(num + map.get(num + 1), length);
                max = Math.max(max, length);
            } else {
                map.put(num, 1);
                max = Math.max(max, 1);
            }
        }
        return max;
    }
}
