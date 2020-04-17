package com.leetcode.no351_400;

import java.util.ArrayList;
import java.util.HashMap;

public class No365DFS {
    private HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    private boolean ans = false;

    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        } else if (x + y == z) {
            return true;
        } else {
            return search(x, 0, y, 0, z);
        }

    }

    private boolean search(int x, int x1, int y, int y1, int z) {
        if (ans || x1 + y1 == z) {
            ans = true;
            return true;
        }
        if (map.containsKey(x1)) {
            if (map.get(x1).contains(y1)) {
                return false;
            } else {
                map.get(x1).add(y1);
            }
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(y1);
            map.put(x1, list);
        }
        boolean b1 = false, b2 = false, b3 = false, b4 = false, b5 = false, b6 = false;
        //add
        if (x1 == 0) {
            b1 = search(x, x, y, y1, z);
        }
        if (y1 == 0) {
            b2 = search(x, x1, y, y, z);
        }
        //transfer
        int xc = x - x1;
        int yc = y - y1;
        int newX, newY;
        if (yc >= x1) {
            newX = 0;
            newY = y1 + x1;
        } else {
            newX = x1 - yc;
            newY = y;
        }
        b3 = search(x, newX, y, newY, z);
        if (xc >= y1) {
            newX = x1 + y1;
            newY = 0;
        } else {
            newX = x;
            newY = y1 - xc;
        }
        b4 = search(x, newX, y, newY, z);
        //dump
        if (x == x1) {
            b5 = search(x, 0, y, y1, z);
        }
        if (y == y1) {
            b6 = search(x, x1, y, 0, z);
        }
        return b1 || b2 || b3 || b4 || b5 || b6;
    }
}
