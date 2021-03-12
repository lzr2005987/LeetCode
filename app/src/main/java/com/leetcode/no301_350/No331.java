package com.leetcode.no301_350;

import java.util.Stack;

/**
 * 栈顶元素表示本层下面还有多少个空位可以放剩下的结点
 */
public class No331 {
    public boolean isValidSerialization(String preorder) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < preorder.length(); i++) {
            char c = preorder.charAt(i);
            if (c == ',' || (i != preorder.length() - 1 && preorder.charAt(i + 1) != ',')) {
                continue;
            }
            if (i == 0) {
                if (c != '#') {
                    stack.push(2);
                }
            } else {
                int pre = 0;
                while (pre == 0) {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    pre = stack.pop();
                }
                if (pre > 1) {
                    stack.push(pre - 1);
                }
                if (c != '#') {
                    stack.push(2);
                }
            }
        }
        return stack.isEmpty();
    }
}
