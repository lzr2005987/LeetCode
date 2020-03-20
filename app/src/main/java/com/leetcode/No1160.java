package com.leetcode;

public class No1160 {
    public int countCharacters(String[] words, String chars) {
        int ans = 0;
        for (String s : words) {
            char[] cArray = s.toCharArray();
            ans += s.length();
            String copy = chars;
            for (char c : cArray) {
                if (!copy.contains(String.valueOf(c))) {
                    ans -= s.length();
                    break;
                } else {
                    int pos = copy.indexOf(c);
                    copy = copy.substring(0, pos) + copy.substring(pos + 1, copy.length());
                }
            }
        }
        return ans;
    }
}
