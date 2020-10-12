package com.leetcode.no401_450;

import java.util.ArrayList;
import java.util.List;

public class No416OutOfTime {
    boolean ans = false;

    public boolean canPartition(int[] nums) {
        int all = 0;
        for (int n : nums) {
            all += n;
        }
        if (all % 2 == 1) return false;
        permutation(nums, new ArrayList<Integer>(), 0, all);
        return ans;
    }

    private void permutation(int[] nums, List<Integer> done, int sum, int all) {
        if (sum == all / 2) ans = true;
        if (ans) return;
        for (int i = 0; i < nums.length; i++) {
            if (done.contains(i)) continue;
            List<Integer> copy = new ArrayList<>(done);
            copy.add(i);
            permutation(nums, copy, sum + nums[i], all);
        }
    }
}
