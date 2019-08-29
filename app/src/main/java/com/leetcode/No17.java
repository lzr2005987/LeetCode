package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class No17 {
    List<char[]> list = new ArrayList<>();
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        HashMap<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");

        char[] chars = digits.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(String.valueOf(chars[i]))) {
                list.add((map.get(String.valueOf(chars[i]))).toCharArray());
            }
        }
        allNumber(list.size() - 1);
        return result;
    }

    private void allNumber(int index) {
        if (index < 0) return;
        for (int i = 0; i < index; i++) {
            sb.append(list.get(i)[0]);
        }

        for (int j = index; j < list.size(); j++) {
            for (int k = 0; k < 4; k++) {

            }
        }

        allNumber(index - 1);
    }
}
