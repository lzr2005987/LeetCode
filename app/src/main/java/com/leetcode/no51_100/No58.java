package com.leetcode.no51_100;

public class No58 {
    public int lengthOfLastWord(String s) {
        if (s.contains(" ")) {
            int index = s.lastIndexOf(" ");
            if (s.length() - index - 1 > 0) {
                return s.length() - index - 1;
            } else {
                String substring = s.substring(0, index);
                return lengthOfLastWord(substring);
            }
        } else {
            return s.length();
        }
    }
}
