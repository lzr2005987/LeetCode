package com.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class No146 {
    class LRUCache extends LinkedHashMap<Integer, Integer> {
        private int capacity = 0;

        public LRUCache(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            if (containsKey(key)) {
                return super.get(key);
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }
}
