package com.leetcode.contest.paypal;

public class GetWinner {
    public int getWinner(int[] arr, int k) {
        int max = 0, maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        if (k >= arr.length) {
            return max;
        }
        for (int i = 0; i < maxIndex; i++) {
            int num;
            num = i == 0 ? 0 : 1;
            for (int j = i + 1; j < maxIndex + 1; j++) {
                if (arr[j] < arr[i]) {
                    num++;
                    if (num == k) {
                        return arr[i];
                    }
                } else {
                    if (num == k) {
                        return arr[i];
                    }
                    break;
                }
            }
        }
        return arr[maxIndex];
    }
}
