package org.example.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author xianpeng.xia
 * on 2022/4/5 1:01 PM
 * 最小栈
 */
public class MinStack {

    /**
     * 数据栈
     */
    Deque<Integer> data;
    /**
     * 辅助栈
     */
    Deque<Integer> minStack;

    public MinStack() {
        this.data = new LinkedList<>();
        this.minStack = new LinkedList<>();
        this.minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        data.push(val);
        minStack.push(Math.min(minStack.peek(), val));
    }

    public void pop() {
        data.pop();
        minStack.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());//--> 返回 -3.
        minStack.pop();
        System.out.println(minStack.top());//--> 返回 0.
        minStack.getMin();

    }
}
