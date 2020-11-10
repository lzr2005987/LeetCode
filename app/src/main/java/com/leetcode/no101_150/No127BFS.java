package com.leetcode.no101_150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class No127BFS {
    int ans = 0;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 0;
        }
        HashMap<String, List<String>> map = new HashMap<>();
        wordList.remove(beginWord);
        map.put(beginWord, wordList);
        getSteps(map, endWord, 1);
        return ans;
    }

    private void getSteps(HashMap<String, List<String>> map, String endWord, int step) {
        if (ans > 0) return;
        HashMap<String, List<String>> newMap = new HashMap<>();
        for (String beginWord : map.keySet()) {
            List<String> wordList = map.get(beginWord);
            for (String word : wordList) {
                if (isSimilar(word, beginWord)) {
                    if (word.equals(endWord)) {
                        ans = step + 1;
                        return;
                    }
                    List<String> newWordList = new ArrayList<>(wordList);
                    newWordList.remove(word);
                    newMap.put(word, newWordList);
                    newMap.remove(beginWord);
                }
            }
        }
        if (!newMap.isEmpty()) {
            getSteps(newMap, endWord, step + 1);
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
