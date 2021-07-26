package com.leetcode.no701_750;

import java.util.ArrayList;
import java.util.List;

public class No705 {
    List<Integer> list;

    /**
     * Initialize your data structure here.
     */
    public No705() {
        list = new ArrayList<>();
    }

    public void add(int key) {
        while (list.size() < key + 1) {
            list.add(-1);
        }
        list.set(key, key);
    }

    public void remove(int key) {
        if (key < list.size()) {
            list.set(key, -1);
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        return key < list.size() && list.get(key) == key;
    }
}
