package com.leetcode.no251_300;

import java.util.ArrayList;
import java.util.Iterator;

public class No284 {

    ArrayList<Integer> list = new ArrayList<>();
    int pos = 0;

    public No284(Iterator<Integer> iterator) {
        // initialize any member here.
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return list.get(pos);
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    public Integer next() {
        return list.get(pos++);
    }

    public boolean hasNext() {
        return pos < list.size();
    }
}
