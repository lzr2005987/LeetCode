package com.leetcode;

import java.util.Arrays;

public class No781 {
    public int numRabbits(int[] answers) {
        Arrays.sort(answers);
        int n = 0;
        int sum = 0;
        while (n < answers.length) {
            int i = answers[n];
            n++;
            if (i == 0) {
                continue;
            }
            int num = 1;
            while (n < answers.length && answers[n] == i && num < i + 1) {
                num++;
                n++;
            }
            sum = sum + (i + 1 - num);
        }
        return sum + answers.length;
    }
}
