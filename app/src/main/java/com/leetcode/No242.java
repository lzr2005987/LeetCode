package com.leetcode;

import java.util.HashMap;

public class No242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            if (map2.containsKey(cs)) {
                safeRemove(map2, cs);
            } else {
                safeAdd(map1, cs);
            }
            char ct = t.charAt(i);
            if (map1.containsKey(ct)) {
                safeRemove(map1, ct);
            } else {
                safeAdd(map2, ct);
            }
        }
        if (map1.size() > 0 || map2.size() > 0) {
            return false;
        } else {
            return true;
        }
    }

    private void safeRemove(HashMap<Character, Integer> map, char c) {
        int num = map.get(c);
        if (num > 1) {
            map.put(c, num - 1);
        } else {
            map.remove(c);
        }
    }

    private void safeAdd(HashMap<Character, Integer> map, char c) {
        if (map.containsKey(c)) {
            map.put(c, map.get(c) + 1);
        } else {
            map.put(c, 1);
        }
    }
}
