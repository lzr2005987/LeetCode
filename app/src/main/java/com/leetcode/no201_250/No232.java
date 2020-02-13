package com.leetcode.no201_250;

import java.util.Stack;

public class No232 {
    Stack<Integer> stackA = new Stack<>();
    Stack<Integer> stackB = new Stack<>();

    /**
     * Initialize your data structure here.
     */
    public No232() {

    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stackA.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        while (!stackA.isEmpty()) {
            stackB.push(stackA.pop());
        }
        int res = stackB.pop();
        while (!stackB.isEmpty()) {
            stackA.push(stackB.pop());
        }
        return res;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        while (!stackA.isEmpty()) {
            stackB.push(stackA.pop());
        }
        int res = stackB.peek();
        while (!stackB.isEmpty()) {
            stackA.push(stackB.pop());
        }
        return res;
    }
}
