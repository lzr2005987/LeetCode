package com.leetcode.interview;

import java.util.ArrayList;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * 示例 1：
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * <p>
 * 示例 2：
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 */
public class InterView57II {
    public int[][] findContinuousSequence(int target) {
        int left = 1, right = 2;
        ArrayList<int[]> ans = new ArrayList<>();
        while (right < target) {
            int sum = 0;
            for (int k = left; k <= right; k++) {
                sum += k;
            }
            if (sum < target) {
                right++;
            } else if (sum == target) {
                int[] list = new int[right - left + 1];
                for (int k = left; k <= right; k++) {
                    list[k - left] = k;
                }
                ans.add(list);
                left++;
            } else {
                left++;
            }
            if (left == right) {
                right++;
            }
        }
        int[][] mAns = new int[ans.size()][target];
        for (int i = 0; i < ans.size(); i++) {
            mAns[i] = ans.get(i);
        }
        return mAns;
    }
}
