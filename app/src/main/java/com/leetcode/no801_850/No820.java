package com.leetcode.no801_850;

import java.util.Arrays;
import java.util.Comparator;

public class No820 {
    public int minimumLengthEncoding(String[] words) {
        int len = 0;
        if (words.length == 0) {
            return 0;
        }
        for (String s : words) {
            len += s.length();
            len++;
        }
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return t1.length() - s.length();
            }
        });
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (" ".equals(words[i]) || " ".equals(words[j])) {
                    continue;
                }
                if (words[i].endsWith(words[j])) {
                    len -= words[j].length();
                    len--;
                    words[j] = " ";
                }
            }
        }
        return len;
    }
}
