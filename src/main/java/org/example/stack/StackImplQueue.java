package org.example.stack;

import java.util.Stack;

/**
 * @author xianpeng.xia
 * on 2022/4/5 11:03 AM
 * 使用栈实现队列
 */
public class StackImplQueue {

    private Stack<Integer> s1, s2;

    public StackImplQueue() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }

    /**
     * push
     *
     * @param x 元素
     */
    public void push(int x) {
        s1.push(x);
    }

    /**
     * 返回队头元素
     */
    public int peek() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    /**
     * 删除队头的元素并返回
     */
    public int pop() {
        // 先调用peek(),防止s2为空
        peek();
        return s2.pop();
    }

    /**
     * 判断队列是否为空
     */
    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
