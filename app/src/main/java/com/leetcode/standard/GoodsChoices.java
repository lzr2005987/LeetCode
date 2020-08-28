package com.leetcode.standard;

import android.animation.ValueAnimator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GoodsChoices {
    public static class AttrList {
        public String label;
        public List<String> value;
    }

    private List<HashMap<String, String>> ans = new ArrayList<>();

    public List<HashMap<String, String>> getChoices(List<AttrList> labelList) {
        backtrack(labelList, new HashMap<String, String>(), 0);
        return ans;
    }

    private void backtrack(List<AttrList> labelList, HashMap<String, String> curMap, int curPos) {
        if (curPos == labelList.size()) {//递归的结束条件：所有的属性都取完了
            ans.add(curMap);
            return;
        }
        AttrList attrList = labelList.get(curPos);
        if (attrList.value == null || attrList.value.isEmpty()) {
            backtrack(labelList, curMap, curPos + 1);//跳过这个属性，回溯判断下一个属性列表
        } else {
            for (String s : attrList.value) {//遍历当前属性的所有值
                curMap.put(attrList.label, s);
                HashMap<String, String> copy = (HashMap<String, String>) curMap.clone();//深拷贝HashMap
                backtrack(labelList, copy, curPos + 1);//回溯，判断下一个属性列表
            }
        }
    }
}
