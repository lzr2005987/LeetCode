package com.leetcode.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Interview59II {
    Queue<Integer> queue;
    ArrayList<Integer> list;

    public Interview59II() {
        queue = new LinkedList<>();
        list = new ArrayList<>();
    }

    public int max_value() {
        return list.isEmpty() ? -1 : list.get(0);
    }

    public void push_back(int value) {
        queue.offer(value);
        list.add(value);
        if (list.size() <= 1) {
            return;
        }
        int i = list.size() - 2;
        while (i >= 0 && list.get(i) < value) {
            list.remove(i);
            list.add(i, value);
            i--;
        }
    }

    public int pop_front() {
        if (list.isEmpty()) {
            return -1;
        }
        list.remove(0);
        return queue.poll();
    }
}
