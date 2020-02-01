package com.leetcode.no151_200;

import java.util.ArrayList;
import java.util.Stack;

public class No155 {
    ArrayList<Integer> list;
    Stack<Integer> stack;

    /**
     * initialize your data structure here.
     */
    public No155() {
        list = new ArrayList<>();
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (list.size() == 0) {
            list.add(x);
        } else {
            int min = list.get(list.size() - 1);
            min = x < min ? x : min;
            list.add(min);
        }
    }

    public void pop() {
        stack.pop();
        list.remove(list.size() - 1);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return list.get(list.size() - 1);
    }
}
