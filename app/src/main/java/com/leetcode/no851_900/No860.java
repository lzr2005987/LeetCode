package com.leetcode.no851_900;

public class No860 {
    public boolean lemonadeChange(int[] bills) {
        int[] holds = new int[3];
        for (int bill : bills) {
            switch (bill) {
                case 5:
                    holds[0] = holds[0] + 1;
                    break;
                case 10:
                    if (holds[0] <= 0) {
                        return false;
                    }
                    holds[0] = holds[0] - 1;
                    holds[1] = holds[1] + 1;
                    break;
                case 20:
                    if (holds[1] > 0) {
                        holds[1] = holds[1] - 1;
                        holds[0] = holds[0] - 1;
                        holds[2] = holds[2] + 1;
                    } else {
                        holds[0] = holds[0] - 3;
                        holds[2] = holds[2] + 1;
                    }
                    if (holds[0] < 0) {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
}
