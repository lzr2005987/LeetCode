package com.leetcode.contest.paypal;

public class CountGoodTriplets {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int len = arr.length;
        int ans = 0;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    int s1 = Math.abs(arr[j] - arr[i]);
                    int s2 = Math.abs(arr[k] - arr[j]);
                    int s3 = Math.abs(arr[i] - arr[k]);
                    if (s1 <= a && s2 <= b && s3 <= c) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
