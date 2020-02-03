package com.leetcode.no251_300;

import java.util.ArrayList;

public class No295 {
    ArrayList<Integer> list;

    /**
     * initialize your data structure here.
     */
    public No295() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        int len = list.size();
        if (len == 0) {
            list.add(num);
        } else {
            for (int i = 0; i < len; i++) {
                if (list.get(i) >= num) {
                    list.add(i, num);
                    break;
                }
            }
            if (len == list.size()) {
                list.add(num);
            }
        }

    }

    public double findMedian() {
        int size = list.size();
        if (size % 2 == 0) {
            return (list.get(size / 2 - 1) + list.get(size / 2)) / 2f;
        } else {
            return list.get(size / 2);
        }
    }
}
