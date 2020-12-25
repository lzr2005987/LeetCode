package com.leetcode.no351_400;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class No387 {
    public int firstUniqChar(String s) {
        List<Character> whiteList = new ArrayList<>();
        List<Character> blackList = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (whiteList.contains(c)) {
                blackList.add(c);
            } else {
                whiteList.add(c);
            }
        }
        whiteList.removeAll(blackList);
        if (whiteList.isEmpty()) {
            return -1;
        } else {
            Character c = whiteList.get(0);
            return s.indexOf(c);
        }
    }
}
