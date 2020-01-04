package com.leetcode;

import java.util.HashMap;

public class No169 {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int target = nums.length / 2;
        for (int n : nums) {
            if (map.containsKey(n)) {
                int count = map.get(n) + 1;
                if (count > target) {
                    return n;
                }
                map.put(n, count);
            } else {
                map.put(n, 1);
            }
        }
        return nums[0];
    }
}
