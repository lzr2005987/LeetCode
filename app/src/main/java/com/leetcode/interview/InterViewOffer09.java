package com.leetcode.interview;

import java.util.Stack;

public class InterViewOffer09 {
    private Stack<Integer> stackAsc, stackDesc;

    public InterViewOffer09() {
        stackAsc = new Stack<>();
        stackDesc = new Stack<>();
    }

    public void appendTail(int value) {
        stackAsc.push(value);
    }

    public int deleteHead() {
        int ans = -1;
        while (!stackAsc.isEmpty()) {
            stackDesc.push(stackAsc.pop());
        }
        if (!stackDesc.isEmpty()) {
            ans = stackDesc.pop();
        }
        while (!stackDesc.isEmpty()) {
            stackAsc.push(stackDesc.pop());
        }
        return ans;
    }
}
