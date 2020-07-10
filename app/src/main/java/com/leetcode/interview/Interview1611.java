package com.leetcode.interview;

import java.util.ArrayList;
import java.util.List;

public class Interview1611 {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        } else if (shorter == longer) {
            return new int[]{shorter * k};
        }
        List<Integer> ans = new ArrayList<>();
        getAllPlan(ans, shorter, longer, 0, 0, k);
        int[] output = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            output[i] = ans.get(i);
        }
        return output;
    }

    private void getAllPlan(List<Integer> ans, int shorter, int longer, int curLength, int cur, int k) {
        if (cur == k) {
            if (!ans.contains(curLength)) {
                ans.add(curLength);
            }
            return;
        }
        getAllPlan(ans, shorter, longer, curLength + shorter, cur + 1, k);
        getAllPlan(ans, shorter, longer, curLength + longer, cur + 1, k);
    }

    public int[] divingBoard1(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        } else if (shorter == longer) {
            return new int[]{shorter * k};
        }
        int[] output = new int[k + 1];
        int s = shorter * k;
        int l = 0;
        int index = 0;
        while (s >= 0) {
            int total = s + l;
            output[index] = total;
            s -= shorter;
            l += longer;
            index++;
        }
        return output;
    }
}
