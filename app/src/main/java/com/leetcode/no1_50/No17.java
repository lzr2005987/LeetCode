package com.leetcode.no1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class No17 {
    public List<String> letterCombinations(String digits) {
        HashMap<Integer, String[]> map = new HashMap<>();
        map.put(2, new String[]{"a", "b", "c"});
        map.put(3, new String[]{"d", "e", "f"});
        map.put(4, new String[]{"g", "h", "i"});
        map.put(5, new String[]{"j", "k", "l"});
        map.put(6, new String[]{"m", "n", "o"});
        map.put(7, new String[]{"p", "q", "r", "s"});
        map.put(8, new String[]{"t", "u", "v"});
        map.put(9, new String[]{"w", "x", "y", "z"});
        int len = digits.length();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int flag2 = Integer.parseInt(digits.substring(i, i + 1));
            String[] tmp = map.get(flag2);
            List<String> list_tmp = new ArrayList<>();
            if (i != 0) {
                for (String s : res) {
                    for (String t : tmp) {
                        String f = s + "" + t;
                        list_tmp.add(f);
                    }
                }
                res = list_tmp;
            } else {
                res.addAll(Arrays.asList(tmp));
            }

        }
        return res;
    }

}
