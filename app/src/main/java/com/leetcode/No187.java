package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class No187 {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) {
            return new ArrayList<>();
        }
        HashSet<String> ans = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        int i = 0;
        int j = 10;
        while (j <= s.length()) {
            String sub = s.substring(i, j);
            if (ans.contains(sub)) {
                i++;
                j++;
                continue;
            }
            if (map.containsKey(sub)) {
                ans.add(sub);
            } else {
                map.put(sub, 1);
            }
            i++;
            j++;
        }
        return new ArrayList<>(ans);
    }
}
