package com.leetcode.no401_450;

import java.util.HashMap;
import java.util.Set;

public class No409 {
    public int longestPalindrome(String s) {
        int ans = 0;
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        Set<Character> keys = map.keySet();
        for (Character c : keys) {
            if (map.get(c) % 2 != 0) {
                count++;
            }
            ans += map.get(c);
        }
        return count == 0 ? ans : ans - count + 1;
    }
}
