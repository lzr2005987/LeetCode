package com.leetcode.no101_150;

import java.util.ArrayList;
import java.util.List;

public class No127DFS {
    int min = Integer.MAX_VALUE;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        getSteps(beginWord, endWord, wordList, 1);
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    private void getSteps(String beginWord, String endWord, List<String> wordList, int step) {
        for (String word : wordList) {
            if (isSimilar(beginWord, word)) {
                int newStep = step;
                if (!beginWord.equals(word)) {
                    newStep++;
                }
                if (word.equals(endWord)) {
                    min = Math.min(min, newStep);
                    break;
                } else {
                    List<String> newList = new ArrayList<>(wordList);
                    newList.remove(word);
                    getSteps(word, endWord, newList, newStep);
                }
            }
        }
    }

    private boolean isSimilar(String s1, String s2) {
        boolean b = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (!b) {
                    b = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
