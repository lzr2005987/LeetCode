package com.leetcode.no1_50;

import java.util.ArrayList;

public class No4 {
    public double test() {
        int[] nums1 = {2, 3, 4, 5};
        int[] nums2 = {1, 3, 4, 6};
        return findMedianSortedArrays(nums1, nums2);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> nums = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                nums.add(nums1[i]);
                i++;
            } else {
                nums.add(nums2[j]);
                j++;
            }
        }
        if (i >= nums1.length) {
            for (int k = j; k < nums2.length; k++) {
                nums.add(nums2[k]);
            }
        }
        if (j >= nums2.length) {
            for (int k = i; k < nums1.length; k++) {
                nums.add(nums1[k]);
            }
        }
        int size = nums.size();
        if (size % 2 == 0) {
            double res = (nums.get(size / 2) + nums.get(size / 2 - 1)) / 2f;
            return res;
        } else {
            return nums.get(size / 2);
        }
    }
}
