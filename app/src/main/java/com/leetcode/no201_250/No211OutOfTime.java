package com.leetcode.no201_250;

import java.util.ArrayList;

public class No211OutOfTime {
    ArrayList<ArrayList<Character>> list;

    /**
     * Initialize your data structure here.
     */
    public No211OutOfTime() {
        list = new ArrayList<>();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        char[] chars = word.toCharArray();
        ArrayList<Character> charList = new ArrayList<>();
        for (char c : chars) {
            charList.add(c);
        }
        list.add(charList);
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        ArrayList<ArrayList<Character>> ansList = new ArrayList<>();
        for (ArrayList<Character> listItem : list) {
            if (listItem.size() == word.length()) {
                ansList.add(listItem);
            }
        }
        if (ansList.isEmpty()) {
            return false;
        }

        for (ArrayList<Character> listItem : ansList) {
            boolean isPair = true;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != '.') {
                    if (listItem.get(i) != chars[i]) {
                        isPair = false;
                        break;
                    }
                }
            }
            if (isPair) {
                return true;
            }
        }

        return false;
    }
}
