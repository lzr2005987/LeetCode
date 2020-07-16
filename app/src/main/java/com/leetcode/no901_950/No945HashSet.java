package com.leetcode.no901_950;

import java.util.HashSet;

public class No945HashSet {
    public int minIncrementForUnique(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        int ans = 0;
        for (int a : A) {
            if (set.contains(a)) {
                while (set.contains(a)) {
                    a++;
                    ans++;
                }
            }
            set.add(a);
        }
        return ans;
    }
}
