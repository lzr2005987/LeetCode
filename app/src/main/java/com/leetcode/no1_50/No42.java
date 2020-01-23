package com.leetcode.no1_50;

import java.util.Stack;

public class No42 {
    public class Bar {
        public int pos;
        public int value;

        public Bar(int pos, int value) {
            this.pos = pos;
            this.value = value;
        }
    }

    public int trap(int[] height) {
        Stack<Bar> stack = new Stack<>();
        int nowLevel = 0, sum = 0;
        for (int i = 0; i < height.length; i++) {
            if (stack.isEmpty()) {
                stack.push(new Bar(i, height[i]));
                nowLevel = 0;
            } else {
                Bar peek = stack.peek();
                if (peek.value > height[i]) {
                    stack.push(new Bar(i, height[i]));
                    continue;
                }
                while (!stack.isEmpty()) {
                    if (peek.value > height[i]) {
                        sum += (height[i] - nowLevel) * (i - peek.pos - 1);
                        nowLevel = height[i];
                        stack.push(new Bar(i, height[i]));
                        break;
                    } else {
                        sum += (peek.value - nowLevel) * (i - peek.pos - 1);
                        nowLevel = peek.value;
                        stack.pop();
                        if (!stack.isEmpty()) {
                            peek = stack.peek();
                        } else {
                            stack.push(new Bar(i, height[i]));
                            nowLevel = 0;
                            break;
                        }
                    }
                }
            }
        }
        return sum;
    }
}
