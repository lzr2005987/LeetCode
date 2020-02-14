package com.leetcode.no301_350;

public class No345 {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        char t;
        while (i < j) {
            while (!isVowel(chars[i]) && i < j) {
                i++;
            }
            while (!isVowel(chars[j]) && i < j) {
                j--;
            }
            if (i < j) {
                t = chars[i];
                chars[i] = chars[j];
                chars[j] = t;
            }
            i++;
            j--;
        }
        return new String(chars);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
