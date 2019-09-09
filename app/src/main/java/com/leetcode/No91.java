package com.leetcode;

public class No91 {
    public int numDecodings(String s) {
        if (s.startsWith("0") || s.contains("00")) {
            return 0;
        }
        int[] res = new int[s.length()];
        res[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            String twoNum = s.substring(i - 1, i + 1);
            String currentNum = s.substring(i, i + 1);
            String lastNum = s.substring(i - 1, i);
            if (Integer.parseInt(twoNum) <= 26) {
                if (Integer.parseInt(lastNum) > 0 && Integer.parseInt(currentNum) > 0) {
                    if (i >= 2) {
                        res[i] = res[i - 2] + res[i - 1];
                    } else {
                        res[i] = 2;
                    }
                } else if (Integer.parseInt(currentNum) > 0) {
                    res[i] = res[i - 1];
                } else {
                    if (i >= 2) {
                        res[i] = res[i - 2];
                    } else {
                        res[i] = 1;
                    }
                }
            } else {
                if (Integer.parseInt(currentNum) == 0) {
                    return 0;
                } else if (Integer.parseInt(currentNum) > 0) {
                    res[i] = res[i - 1];
                }
            }
        }
        return res[res.length - 1];
    }
}
