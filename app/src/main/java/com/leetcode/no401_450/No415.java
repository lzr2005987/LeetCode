package com.leetcode.no401_450;

public class No415 {
    public String addStrings(String num1, String num2) {
        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;
        int t = 0;
        String ans = "";
        while (l1 >= 0 || l2 >= 0) {
            int n1 = 0, n2 = 0, n3 = 0;
            if (l1 >= 0) {
                n1 = Integer.parseInt(num1.substring(l1, l1 + 1));
                l1--;
            }
            if (l2 >= 0) {
                n2 = Integer.parseInt(num2.substring(l2, l2 + 1));
                l2--;
            }
            n3 = (n1 + n2 + t) % 10;
            t = (n1 + n2 + t) / 10;
            ans = n3 + ans;
        }
        if (t > 0) {
            ans = t + ans;
        }
        return ans;
    }
}
