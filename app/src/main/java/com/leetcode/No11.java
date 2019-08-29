package com.leetcode;

public class No11 {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, max = 0;
        while (l < r) {
            int area = (r - l) * Math.min(height[l], height[r]);
            if (area > max) {
                max = area;
            }
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
