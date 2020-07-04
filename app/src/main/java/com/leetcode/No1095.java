package com.leetcode;

public class No1095 {
    interface MountainArray {
        public int get(int index);

        public int length();
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        if (mountainArr.length() == 0) {
            return -1;
        } else if (mountainArr.length() == 1) {
            return mountainArr.get(0) == target ? 0 : -1;
        } else {
            int pivot = findPivot(mountainArr, 0, mountainArr.length() - 1);
            int ans = findTarget(mountainArr, 0, pivot, target, false);
            if (ans == -1) {
                ans = findTarget(mountainArr, pivot, mountainArr.length() - 1, target, true);
            }
            return ans;
        }
    }

    private int findTarget(MountainArray mountainArr, int left, int right, int target, boolean isReverse) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (mountainArr.get(mid) == target) {
            return mid;
        } else {
            int num = mountainArr.get(mid);
            if ((num > target && !isReverse) || (num < target && isReverse)) {
                return findTarget(mountainArr, left, mid - 1, target, isReverse);
            } else {
                return findTarget(mountainArr, mid + 1, right, target, isReverse);
            }
        }
    }

    private int findPivot(MountainArray mountainArr, int left, int right) {
        int mid = (left + right) / 2;
        if (mid == 0) {
            if (mountainArr.length() > 2 && mountainArr.get(0) < mountainArr.get(1) && mountainArr.get(1) > mountainArr.get(2)) {
                return 1;
            } else {
                return 0;
            }
        } else if (mid == mountainArr.length() - 1) {
            return mountainArr.get(mid) < mountainArr.get(mid - 1) ? mid - 1 : 0;
        } else {
            int leftNum = mountainArr.get(mid - 1);
            int curNum = mountainArr.get(mid);
            int rightNum = mountainArr.get(mid + 1);
            if (leftNum < curNum && rightNum < curNum) {
                return mid;
            } else if (leftNum > curNum && rightNum < curNum) {
                return findPivot(mountainArr, left, mid - 1);
            } else if (leftNum < curNum && rightNum > curNum) {
                return findPivot(mountainArr, mid + 1, right);
            }
        }
        return 0;
    }
}
