package com.leetcode.no1001_1050;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class No1002 {
    public List<String> commonChars(String[] A) {
        HashMap<Character, Integer> minMap = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < A[i].length(); j++) {
                char c = A[i].charAt(j);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }
            if (i == 0) {
                minMap = map;
            } else {
                for (Character ch : minMap.keySet()) {
                    if (map.containsKey(ch)) {
                        minMap.put(ch, Math.min(minMap.get(ch), map.get(ch)));
                    } else {
                        minMap.put(ch, 0);
                    }
                }
            }
            if (i == A.length - 1) {
                for (Character ch : minMap.keySet()) {
                    for (int j = 0; j < minMap.get(ch); j++) {
                        ans.add(String.valueOf(ch));
                    }
                }
            }
        }
        return ans;
    }
}
