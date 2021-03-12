package com.leetcode.no651_700;

import java.util.HashMap;

public class No697 {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> startMap = new HashMap<>();
        HashMap<Integer, Integer> endMap = new HashMap<>();
        int degree = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            Integer m = map.get(n);
            if (m == null) {
                map.put(n, 1);
                startMap.put(n, i);
                endMap.put(n, i);
                degree = Math.max(degree, 1);
            } else {
                map.put(n, m + 1);
                endMap.put(n, i);
                degree = Math.max(degree, m + 1);
            }
        }
        for (int n : startMap.keySet()) {
            if (map.get(n) == degree) {
                int len = endMap.get(n) - startMap.get(n) + 1;
                if (ans == 0) {
                    ans = len;
                } else {
                    ans = Math.min(ans, len);
                }
            }
        }
        return ans;
    }
}
