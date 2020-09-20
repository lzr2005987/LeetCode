package com.leetcode.no551_600;

public class No557 {
    public String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for (String word : split) {
            StringBuilder sb = new StringBuilder(word);
            ans.append(sb.reverse());
            ans.append(" ");
        }
        String fin = ans.toString();
        return fin.substring(0, fin.length() - 1);
    }
}
