package com.leetcode;

public class No1103 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int n = 1, p = 0;
        while (candies > 0) {
            if (candies > n) {
                candies -= n;
                ans[p] += n;
            } else {
                ans[p] += candies;
                candies = 0;
            }
            n++;
            if (p < num_people - 1) {
                p++;
            } else {
                p = 0;
            }
        }
        return ans;
    }
}
