package com.leetcode.no501_550;

import java.util.Arrays;
import java.util.Stack;

public class No503 {
    private Stack<Integer> stack = new Stack<>();
    private int[] ans;

    public int[] nextGreaterElements(int[] nums) {
        ans = new int[nums.length];
        Arrays.fill(ans, -1);
        calculate(nums);
        calculate(nums);
        return ans;
    }

    private void calculate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                ans[stack.peek()] = nums[i];
                stack.pop();
            }
            stack.push(i);
        }
    }
}
