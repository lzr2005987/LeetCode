package com.leetcode.no51_100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class No76 {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> aMap = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        boolean isRight = true;
        String ans = "";
        int left = 0, right = 0;
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        int point = -1;
        while (right < s.length()) {
            if (isRight) {
                char c = s.charAt(right);
                if (tMap.containsKey(c)) {
                    list.add(right);
                    aMap.put(c, aMap.getOrDefault(c, 0) + 1);
                }
            }

            if (isMatched(tMap, aMap)) {
                if (ans.length() == 0 || right - left + 1 < ans.length()) {
                    ans = s.substring(left, right + 1);
                }
                point++;
                char c1 = s.charAt(left);
                if (list.size() <= point) {
                    return ans;
                }
                if (aMap.containsKey(c1) && left != list.get(point)) {
                    aMap.put(c1, aMap.get(c1) - 1);
                }
                left = list.get(point);
                isRight = false;
            } else {
                right++;
                isRight = true;
            }
        }
        return ans;
    }

    private boolean isMatched(HashMap<Character, Integer> tMap, HashMap<Character, Integer> aMap) {
        Set<Character> set = tMap.keySet();
        for (Character c : set) {
            if (!aMap.containsKey(c) || aMap.get(c) < tMap.get(c)) {
                return false;
            }
        }
        return true;
    }
}
