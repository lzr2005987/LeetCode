package com.leetcode.no351_400;

import java.util.ArrayList;

public class No384 {
    int[] nums;

    public No384(int[] nums) {
        this.nums = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        ArrayList<Integer> list = new ArrayList<>();
        int[] copy = new int[nums.length];
        for (int n : nums) {
            list.add(n);
        }
        int p = 0;
        while (!list.isEmpty()) {
            int index = (int) (Math.random() * list.size());
            copy[p++] = list.get(index);
            list.remove(index);
        }
        return copy;
    }
}
