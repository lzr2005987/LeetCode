package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No15a {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        int l, r;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            l = 0;
            r = nums.length - 1;
            while (l < i && r > i) {
                int sum = nums[l] + nums[i] + nums[r];
                if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    set.add(Arrays.asList(nums[l], nums[i], nums[r]));
                    r--;
                    l++;
                }
            }

        }
        return new ArrayList<>(set);
    }
}
