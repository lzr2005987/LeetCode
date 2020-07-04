package com.leetcode.interview;

import java.util.ArrayList;

public class Interview56I {
    public int[] singleNumbers(int[] nums) {
        int temp = 0;
        for (int n : nums) {
            temp = temp ^ n;
        }
        int pos = 1;
        int posN = 0;
        while (posN == 0) {
            posN = pos & temp;
            pos = pos << 1;
        }
        pos = pos >> 1;
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        for (int n : nums) {
            if ((n & pos) == 0) {
                left.add(n);
            } else {
                right.add(n);
            }
        }
        int[] ans = new int[2];
        int lAns = 0, rAns = 0;
        for (int l : left) {
            lAns = lAns ^ l;
        }
        for (int r : right) {
            rAns = rAns ^ r;
        }
        ans[0] = lAns;
        ans[1] = rAns;
        return ans;
    }
}
