package com.leetcode.no51_100;

public class No88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                nums[k] = nums1[i];
                i++;
            } else {
                nums[k] = nums2[j];
                j++;
            }
            k++;
        }
        if (i < m) {
            for (int t = i; t < m; t++) {
                nums[k] = nums1[t];
                k++;
            }
        } else if (j < n) {
            for (int t = j; t < n; t++) {
                nums[k] = nums2[t];
                k++;
            }
        }
        for (int t = 0; t < m + n; t++) {
            nums1[t] = nums[t];
        }
    }
}
