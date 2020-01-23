package com.leetcode.no51_100;

import java.util.ArrayList;
import java.util.List;

public class No71 {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            if (i != 0 && s.length() == 0 || s.equals(".")) {
                continue;
            }
            if (s.equals("..")) {
                int a = list.size();
                if (a > 0 && !list.get(a - 1).equals(""))
                    list.remove(a - 1);
            } else {
                list.add(s);
            }
        }
        if (list.isEmpty())
            return "/";
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : list) {
            stringBuilder.append(s).append("/");
        }
        int a = stringBuilder.length();
        return  a > 1 ? stringBuilder.substring(0, a - 1) : stringBuilder.toString();
    }
}
