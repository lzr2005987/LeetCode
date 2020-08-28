package com.leetcode.no651_700;

public class No657 {
    public boolean judgeCircle(String moves) {
        int up = 0;
        int left = 0;
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            switch (c) {
                case 'U':
                    up++;
                    break;
                case 'D':
                    up--;
                    break;
                case 'L':
                    left++;
                    break;
                case 'R':
                    left--;
                    break;
            }
        }
        return left == 0 && up == 0;
    }
}
