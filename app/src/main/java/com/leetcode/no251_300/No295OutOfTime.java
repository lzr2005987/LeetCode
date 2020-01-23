package com.leetcode.no251_300;

import java.util.ArrayList;
import java.util.Arrays;

public class No295OutOfTime {
    ArrayList<Integer> list;
    double[] doubleList;
    /** initialize your data structure here. */
    public No295OutOfTime() {
        list=new ArrayList<>();
    }

    public void addNum(int num) {
        list.add(num);
        doubleList=new double[list.size()];
        for(int i=0;i<list.size();i++){
            doubleList[i]=list.get(i);
        }
        Arrays.sort(doubleList);
    }

    public double findMedian() {
        int size=doubleList.length;
        if(size%2==0){
            return (doubleList[size/2-1]+doubleList[size/2])/2f;
        }else{
            return doubleList[size/2];
        }
    }
}
