package com.leetcode.no201_250;

public class No239 {
    int pos0 = 0;

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int[] copy = new int[k];
        for (int l = 0; l < k; l++) {
            copy[l] = nums[l];
        }
        int i = 0, j = k - 1;
        while (j < nums.length) {
            for (int m = 0; m < k; m++) {
                if (copy[m] == nums[i]) {
                    pos0 = m;
                    break;
                }
            }
            buildHeap(copy, copy.length - 1);
            ans[i] = copy[0];
            i++;
            j++;
            if (j < nums.length) {
                copy[pos0] = nums[j];
            }
        }
        return ans;
    }

    private void heapify(int[] a, int len, int pos) {
        if (pos >= len) {
            return;
        }
        int c1 = pos * 2 + 1;
        int c2 = pos * 2 + 2;
        int maxPos = pos;
        if (c2 <= len) {
            maxPos = a[c1] >= a[c2] ? c1 : c2;
            maxPos = a[maxPos] >= a[pos] ? maxPos : pos;
        } else if (c1 <= len) {
            maxPos = a[c1] >= a[pos] ? c1 : pos;
        }
        if (maxPos > pos) {
            int temp = a[maxPos];
            a[maxPos] = a[pos];
            a[pos] = temp;
            if (pos == pos0) {
                pos0 = maxPos;
            } else if (maxPos == pos0) {
                pos0 = pos;
            }
            heapify(a, len, maxPos);
        }
    }

    private void buildHeap(int[] a, int len) {
        int start = (len - 1) / 2;
        for (int i = start; i >= 0; i--) {
            heapify(a, len, i);
        }
    }
}
