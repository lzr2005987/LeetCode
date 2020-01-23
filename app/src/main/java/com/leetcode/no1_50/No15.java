package com.leetcode.no1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int key = -(nums[i] + nums[j]);
                if (map.containsKey(key) && map.get(key) > j) {
                    set.add(Arrays.asList(nums[i], nums[j], key));
                }
            }
        }
        return new ArrayList<>(set);
    }
}
