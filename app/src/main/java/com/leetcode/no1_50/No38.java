package com.leetcode.no1_50;

public class No38 {
    public String countAndSay(int n) {
        String[] res = new String[31];
        res[0] = "1";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int count = 1;
            String tmpS = null;
            for (int j = 0; j < res[i].length(); j++) {
                String substring = res[i].substring(j, j + 1);
                if (tmpS == null) {
                    tmpS = substring;
                    continue;
                }
                if (substring.equals(tmpS)) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(tmpS);
                    tmpS = substring;
                    count = 1;
                }
            }
            if (tmpS != null) {
                sb.append(count);
                sb.append(tmpS);
            }
            res[i + 1] = sb.toString();
            sb = new StringBuilder();
        }
        return res[n - 1];
    }
}
