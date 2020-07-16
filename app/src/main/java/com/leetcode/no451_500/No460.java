package com.leetcode.no451_500;

import java.util.HashMap;
import java.util.Map;

/**
 * 标准答案
 */
public class No460 {
    /**
     * key 就是题目中的 key
     * value 是结点类
     */
    private Map<Integer, ListNode> map;

    /**
     * 访问次数哈希表，使用 ListNode[] 也可以，不过要占用很多空间
     */
    private Map<Integer, DoubleLinkedList> frequentMap;

    /**
     * 外部传入的容量大小
     */
    private Integer capacity;

    /**
     * 全局最高访问次数，删除最少使用访问次数的结点时会用到
     */
    private Integer maxFrequent = 1;

    public No460(int capacity) {
        map = new HashMap<>(capacity);
        frequentMap = new HashMap<>();
        this.capacity = capacity;
    }

    /**
     * get 一次操作，访问次数就增加 1；
     * 从原来的链表调整到访问次数更高的链表的表头
     *
     * @param key
     * @return
     */
    public int get(int key) {
        // 测试测出来的，capacity 可能传 0
        if (capacity == 0) {
            return -1;
        }

        if (map.containsKey(key)) {
            // 获得结点类
            ListNode listNode = removeListNode(key);

            // 挂接到新的访问次数的双向链表的头部
            int frequent = listNode.frequent;
            addListNode2Head(frequent, listNode);
            return listNode.value;
        } else {
            return -1;
        }
    }

    /**
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        // 如果 key 存在，就更新访问次数 + 1，更新值
        if (map.containsKey(key)) {
            ListNode listNode = removeListNode(key);

            // 更新 value
            listNode.value = value;
            int frequent = listNode.frequent;
            addListNode2Head(frequent, listNode);
            return;
        }

        // 如果 key 不存在
        // 1、如果满了，先删除访问次数最小的的末尾结点，再删除 map 里对应的 key
        if (map.size() == capacity) {
            for (int i = 1; i <= maxFrequent; i++) {
                if (frequentMap.containsKey(i) && frequentMap.get(i).count > 0) {
                    // 1、从双链表里删除结点
                    DoubleLinkedList doubleLinkedList = frequentMap.get(i);
                    ListNode removeNode = doubleLinkedList.removeTail();

                    // 2、删除 map 里对应的 key
                    map.remove(removeNode.key);
                    break;
                }
            }
        }

        // 2、再创建新结点放在访问次数为 1 的双向链表的前面
        ListNode newListNode = new ListNode(key, value);
        addListNode2Head(1, newListNode);
        map.put(key, newListNode);
    }

    // 以下部分主要是结点类和双向链表的操作

    /**
     * 结点类，是双向链表的组成部分
     */
    private class ListNode {
        private int key;
        private int value;
        private int frequent = 1;
        private ListNode pre;
        private ListNode next;

        public ListNode() {

        }

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * 双向链表
     */
    private class DoubleLinkedList {
        /**
         * 虚拟头结点，它无前驱结点
         */
        private ListNode dummyHead;
        /**
         * 虚拟尾结点，它无后继结点
         */
        private ListNode dummyTail;

        /**
         * 当前双向链表的有效结点数
         */
        private int count;

        public DoubleLinkedList() {
            this.dummyHead = new ListNode(-1, -1);
            this.dummyTail = new ListNode(-1, -1);

            dummyHead.next = dummyTail;
            dummyTail.pre = dummyHead;
            count = 0;
        }

        /**
         * 把一个结点类添加到双向链表的开头（头部是最新使用数据）
         *
         * @param addNode
         */
        public void addNode2Head(ListNode addNode) {
            ListNode oldHead = dummyHead.next;
            // 两侧结点指向它
            dummyHead.next = addNode;
            oldHead.pre = addNode;
            // 它的前驱和后继指向两侧结点
            addNode.pre = dummyHead;
            addNode.next = oldHead;
            count++;
        }

        /**
         * 把双向链表的末尾结点删除（尾部是最旧的数据，在缓存满的时候淘汰）
         *
         * @return
         */
        public ListNode removeTail() {
            ListNode oldTail = dummyTail.pre;
            ListNode newTail = oldTail.pre;

            // 两侧结点建立连接
            newTail.next = dummyTail;
            dummyTail.pre = newTail;

            // 它的两个属性切断连接
            oldTail.pre = null;
            oldTail.next = null;
            count--;
            return oldTail;
        }
    }


    /**
     * 将原来访问次数的结点，从双向链表里脱离出来
     *
     * @param key
     * @return
     */
    private ListNode removeListNode(int key) {
        // 获得结点类
        ListNode deleteNode = map.get(key);

        ListNode preNode = deleteNode.pre;
        ListNode nextNode = deleteNode.next;
        // 两侧结点建立连接
        preNode.next = nextNode;
        nextNode.pre = preNode;
        // 删除去原来两侧结点的连接
        deleteNode.pre = null;
        deleteNode.next = null;

        // 维护双链表结点数
        frequentMap.get(deleteNode.frequent).count--;
        // 访问次数加 1
        deleteNode.frequent++;
        maxFrequent = Math.max(maxFrequent, deleteNode.frequent);

        return deleteNode;
    }


    /**
     * 把结点放在对应访问次数的双向链表的头部
     *
     * @param frequent
     * @param addNode
     */
    private void addListNode2Head(int frequent, ListNode addNode) {
        DoubleLinkedList doubleLinkedList;

        // 如果不存在，就初始化
        if (frequentMap.containsKey(frequent)) {
            doubleLinkedList = frequentMap.get(frequent);
        } else {
            doubleLinkedList = new DoubleLinkedList();
        }

        // 添加到 DoubleLinkedList 的表头
        doubleLinkedList.addNode2Head(addNode);
        frequentMap.put(frequent, doubleLinkedList);
    }

}
