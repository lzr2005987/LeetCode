package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class No1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();
        int max = 0;
        for (int candie : candies) {
            max = Math.max(max, candie);
        }
        for (int candie : candies) {
            if (candie + extraCandies >= max) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }
}
