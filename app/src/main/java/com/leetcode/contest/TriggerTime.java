package com.leetcode.contest;

/**
 * 在战略游戏中，玩家往往需要发展自己的势力来触发各种新的剧情。一个势力的主要属性有三种，分别是文明等级（C），资源储备（R）以及人口数量（H）。在游戏开始时（第 0 天），三种属性的值均为 0。
 *
 * 随着游戏进程的进行，每一天玩家的三种属性都会对应增加，我们用一个二维数组 increase 来表示每天的增加情况。这个二维数组的每个元素是一个长度为 3 的一维数组，例如 [[1,2,1],[3,4,2]] 表示第一天三种属性分别增加 1,2,1 而第二天分别增加 3,4,2。
 *
 * 所有剧情的触发条件也用一个二维数组 requirements 表示。这个二维数组的每个元素是一个长度为 3 的一维数组，对于某个剧情的触发条件 c[i], r[i], h[i]，如果当前 C >= c[i] 且 R >= r[i] 且 H >= h[i] ，则剧情会被触发。
 *
 * 根据所给信息，请计算每个剧情的触发时间，并以一个数组返回。如果某个剧情不会被触发，则该剧情对应的触发时间为 -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-qing-hong-fa-shi-jian
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TriggerTime {
    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        if (increase.length == 0) {
            int[] ans = new int[requirements.length];
            int pos = 0;
            for (int[] arr : requirements) {
                if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0) {
                    ans[pos] = 0;
                } else {
                    ans[pos] = -1;
                }
                pos++;
            }
            return ans;
        }
        long[][] sum = new long[increase.length + 1][increase[0].length];
        int[] ans = new int[requirements.length];
        sum[0][0] = 0;
        sum[0][1] = 0;
        sum[0][2] = 0;
        for (int i = 1; i < increase.length + 1; i++) {
            sum[i][0] = increase[i - 1][0] + sum[i - 1][0];
            sum[i][1] = increase[i - 1][1] + sum[i - 1][1];
            sum[i][2] = increase[i - 1][2] + sum[i - 1][2];
        }
        int pos = 0;
        for (int[] arr : requirements) {
            int index0 = getIndex(sum, 0, arr[0], 0);
            int index1 = getIndex(sum, 1, arr[1], index0);
            int index2 = getIndex(sum, 2, arr[2], index1);
            ans[pos] = index2;
            pos++;
        }
        return ans;
    }

    private int getIndex(long[][] sum, int pos, int target, int start) {
        if (start == -1) {
            return -1;
        }
        for (int i = start; i < sum.length; i++) {
            if (sum[i][pos] >= target) {
                return i;
            }
        }
        return -1;
    }
}
