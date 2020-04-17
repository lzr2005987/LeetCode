package com.leetcode.no351_400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class No355 {
    class Node {
        Node next;
        int val;
        int time;

        public Node(int val, int time) {
            this.val = val;
            this.time = time;
        }
    }

    private HashMap<Integer, Node> map = new HashMap<>();
    private HashMap<Integer, List<Integer>> followMap = new HashMap<>();
    private int time = 0;

    /**
     * Initialize your data structure here.
     */
    public No355() {

    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (!map.containsKey(userId)) {
            map.put(userId, new Node(tweetId, time++));
        } else {
            Node node = map.get(userId);
            Node newNode = new Node(tweetId, time++);
            newNode.next = node;
            map.put(userId, newNode);
        }
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> followList = new ArrayList<>();
        if (followMap.containsKey(userId)) {
            followList = followMap.get(userId);
        } else {
            followList.add(userId);
        }
        List<Node> nodeList = new ArrayList<>();
        for (int id : followList) {
            Node node = map.get(id);
            while (node != null) {
                nodeList.add(node);
                node = node.next;
            }
        }

        Node[] arr = new Node[nodeList.size()];
        int index = 0;
        for (Node nodeItem : nodeList) {
            arr[index++] = nodeItem;
        }
        Arrays.sort(arr, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.time - o1.time;
            }
        });
        int end = Math.min(10, arr.length);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < end; i++) {
            result.add(arr[i].val);
        }
        return result;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        List<Integer> ids = new ArrayList<>();
        if (followMap.containsKey(followerId)) {
            ids = followMap.get(followerId);
        } else {
            ids.add(followerId);
        }
        if (!ids.contains(followeeId)) {
            ids.add(followeeId);
        }
        followMap.put(followerId, ids);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {

        if (followMap.containsKey(followerId)) {
            List<Integer> ids = followMap.get(followerId);
            int index = -1;
            for (int i = 0; i < ids.size(); i++) {
                if (ids.get(i) == followeeId) {
                    index = i;
                }
            }
            if (index != -1) {
                ids.remove(index);
            }
            followMap.put(followerId, ids);
        }
    }
}
