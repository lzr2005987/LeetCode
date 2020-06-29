package com.leetcode;

import java.util.Stack;

public class No739 {
    public int[] dailyTemperatures(int[] T) {
        Stack<int[]> stack = new Stack<>();
        int[] ans = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            int t = T[i];
            if (stack.isEmpty() || stack.peek()[0] >= t) {
                int[] item = new int[2];
                item[0] = t;
                item[1] = i;
                stack.push(item);
            } else {
                while (!stack.isEmpty() && stack.peek()[0] < t) {
                    int[] peek = stack.pop();
                    ans[peek[1]] = i - peek[1];
                }
                int[] item = new int[2];
                item[0] = t;
                item[1] = i;
                stack.push(item);
            }
        }
        return ans;
    }
}
