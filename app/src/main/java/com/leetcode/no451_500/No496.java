package com.leetcode.no451_500;

import java.util.HashMap;
import java.util.Stack;

public class No496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<int[]> stack = new Stack<>();
        int[] ans = new int[nums2.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] output = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            int t = nums2[i];
            if (stack.isEmpty() || stack.peek()[0] >= t) {
                int[] item = new int[2];
                item[0] = t;
                item[1] = i;
                stack.push(item);
            } else {
                while (!stack.isEmpty() && stack.peek()[0] < t) {
                    int[] peek = stack.pop();
                    ans[peek[1]] = t;
                    for (int n : nums1) {
                        if (n == peek[0]) {
                            map.put(n, t);
                            break;
                        }
                    }
                }
                int[] item = new int[2];
                item[0] = t;
                item[1] = i;
                stack.push(item);
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            int n = nums1[i];
            if (map.containsKey(n)) {
                output[i] = map.get(n);
            } else {
                output[i] = -1;
            }
        }
        return output;
    }
}
