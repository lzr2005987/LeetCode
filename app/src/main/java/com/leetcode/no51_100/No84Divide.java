package com.leetcode.no51_100;

public class No84Divide {
    int max = 0;

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        findMin(0, heights.length - 1, heights);
        return max;
    }

    private void findMin(int left, int right, int[] heights) {
        int sum = 0;
        int pos = left;
        int min = heights[left];
        for (int i = left; i <= right; i++) {
            if (min > heights[i]) {
                min = heights[i];
                pos = i;
            }
        }
        sum = (right - left + 1) * min;
        max = max < sum ? sum : max;
        if (pos - 1 >= left) {
            findMin(left, pos - 1, heights);
        }
        if (pos + 1 <= right) {
            findMin(pos + 1, right, heights);
        }
    }
}
