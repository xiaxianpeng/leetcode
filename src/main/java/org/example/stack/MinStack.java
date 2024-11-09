package org.example.stack;

import java.util.Stack;

/**
 * @author xianpeng.xia
 * on 2022/4/5 1:01 PM
 * 最小栈
 */
public class MinStack {

    /**
     * 数据栈
     */
    Stack<Integer> stack;
    /**
     * 辅助栈
     */
    Stack<Integer> minStack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val < minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        Integer val = stack.pop();
        if (val == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());//--> 返回 -3
        minStack.pop();
        System.out.println(minStack.top());//--> 返回 0
        System.out.println(minStack.getMin());//--> 返回 -2

    }
}
