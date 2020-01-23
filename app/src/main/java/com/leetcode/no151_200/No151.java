package com.leetcode.no151_200;

public class No151 {
    public String reverseWords(String s) {
        int j = 0;
        while (j < s.length() && " ".equals(s.substring(j, j + 1))) {
            j++;
        }
        s = s.substring(j);
        if (s.equals("")) {
            return s;
        }
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i].trim());
            if (i > 0 && !words[i].trim().isEmpty()) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
