package com.leetcode.interview;

public class Interview0106 {
    public String compressString(String S) {
        if ("".equals(S)) {
            return S;
        }
        char[] array = S.toCharArray();
        int start = 0, end = 0;
        char cur = array[0];
        StringBuilder sb = new StringBuilder();
        sb.append(cur);
        for (int i = 1; i < array.length; i++) {
            if (array[i] == cur) {
                end++;
            } else {
                int len = end - start + 1;
                sb.append(len + "");
                start = end;
                sb.append(array[i]);
                cur = array[i];
            }
            if (i == array.length - 1) {
                int finalPos = end - start + 1;
                if (finalPos > 0) {
                    sb.append(finalPos + "");
                }
            }
        }
        return sb.length() < S.length() ? sb.toString() : S;
    }
}
