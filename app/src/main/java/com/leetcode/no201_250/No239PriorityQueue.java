package com.leetcode.no201_250;

import java.util.Comparator;
import java.util.PriorityQueue;

public class No239PriorityQueue {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                return t2 - t1;
            }
        });
        int[] ans = new int[nums.length - k + 1];
        int i = 0, j = k;
        for (int m = i; m < j; m++) {
            heap.offer(nums[m]);
        }
        while (j <= nums.length) {
            ans[i] = heap.peek();
            if (j < nums.length) {
                heap.remove(nums[i]);
                heap.offer(nums[j]);
            }
            i++;
            j++;
        }
        return ans;
    }
}
