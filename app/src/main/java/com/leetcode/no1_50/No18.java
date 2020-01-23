package com.leetcode.no1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>();
        int l, r;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                l = 0;
                r = nums.length - 1;
                while (l < i && r > j && r > i) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        set.add(Arrays.asList(nums[l], nums[i], nums[j], nums[r]));
                        l++;
                        r--;
                    } else if (sum < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
}
