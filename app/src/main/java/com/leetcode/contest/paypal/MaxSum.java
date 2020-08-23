package com.leetcode.contest.paypal;

public class MaxSum {
    private int max = 0;

    public int maxSum(int[] nums1, int[] nums2) {
        calculate(nums1, nums2, 0, 0, 0, true);
        calculate(nums1, nums2, 0, 0, 0, false);
        return max % 1000000007;
    }

    private void calculate(int[] nums1, int[] nums2, int cur, int p1, int p2, boolean isP1) {
        if ((p1 >= nums1.length && isP1) || (p2 >= nums2.length && !isP1)) {
            return;
        }
        if (isP1) {
            cur = cur + nums1[p1];
        } else {
            cur = cur + nums2[p2];
        }
        max = Math.max(max, cur);
        if (isP1) {
            calculate(nums1, nums2, cur, p1 + 1, p2, true);
            while (p2 < nums2.length && nums1[p1] > nums2[p2]) {
                p2++;
            }
            if (p2 < nums2.length && nums1[p1] == nums2[p2]) {
                cur = cur - nums1[p1];
                calculate(nums1, nums2, cur, p1 + 1, p2, false);
            }
        } else {
            calculate(nums1, nums2, cur, p1, p2 + 1, false);
            while (p1 < nums1.length && nums1[p1] < nums2[p2]) {
                p1++;
            }
            if (p1 < nums1.length && nums1[p1] == nums2[p2]) {
                cur = cur - nums2[p2];
                calculate(nums1, nums2, cur, p1, p2 + 1, true);
            }
        }
    }
}
