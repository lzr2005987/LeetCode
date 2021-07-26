package com.leetcode.no701_750;

import java.util.ArrayList;
import java.util.List;

public class No706 {
    List<Integer> list;

    /**
     * Initialize your data structure here.
     */
    public No706() {
        list = new ArrayList<>();
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        while (list.size() <= key) {
            list.add(-1);
        }
        list.set(key, value);
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        if (key < list.size()) {
            return list.get(key);
        } else {
            return -1;
        }
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        if (key < list.size()) {
            list.set(key, -1);
        }
    }
}
