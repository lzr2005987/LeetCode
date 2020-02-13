package com.leetcode.no301_350;

import java.util.ArrayList;

public class No303 {
    ArrayList<Integer> arr = new ArrayList<>();

    public No303(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += nums[j];
            }
            arr.add(sum);
        }
    }

    public int sumRange(int i, int j) {
        int sub = i == 0 ? 0 : arr.get(i - 1);
        return arr.get(j) - sub;
    }
}
