package com.leetcode.no251_300;

import java.util.HashMap;
import java.util.Set;

public class No290 {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        char[] pats = pattern.toCharArray();
        String[] strs = str.split(" ");
        if (pats.length != strs.length) {
            return false;
        }
        for (int i = 0; i < pats.length; i++) {
            if (!map.containsKey(pats[i])) {
                if (isExist(map, strs[i])) {
                    return false;
                }
                map.put(pats[i], strs[i]);
            } else if (!map.get(pats[i]).equals(strs[i])) {
                return false;
            }
        }
        return true;
    }

    private boolean isExist(HashMap map, String s) {
        Set<Character> set = map.keySet();
        for (char c : set) {
            if (s.equals(map.get(c))) {
                return true;
            }
        }
        return false;
    }
}
