package com.leetcode;

import java.util.HashMap;

public class No205 {
    public boolean isIsomorphic(String s, String t) {
        if (s != t && (s == null || t == null || s.length() != t.length())) {
            return false;
        }
        return check(s, t) && check(t, s);
    }

    private boolean check(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if (!map.containsKey(cs)) {
                map.put(cs, ct);
            } else if (map.get(cs) != ct) {
                return false;
            }
        }
        return true;
    }
}
