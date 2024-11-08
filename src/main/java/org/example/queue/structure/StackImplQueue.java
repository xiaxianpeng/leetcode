package org.example.queue.structure;

import java.util.Stack;

/**
 * @author xianpeng.xia
 * on 2022/4/5 11:03 AM
 * 使用栈实现队列
 */
public class StackImplQueue {

    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    public StackImplQueue() {
        this.pushStack = new Stack<>();
        this.popStack = new Stack<>();
    }

    /**
     * push
     *
     * @param x 元素
     */
    public void push(int x) {
        pushStack.push(x);
    }

    /**
     * 返回队头元素
     */
    public int peek() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.peek();
    }

    /**
     * 删除队头的元素并返回
     */
    public int pop() {
        // 先调用peek(),防止popStack为空
        peek();
        return popStack.pop();
    }

    /**
     * 判断队列是否为空
     */
    public boolean isEmpty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }

    /**
     * 返回队列中的元素数量
     */
    public int size() {
        return pushStack.size() + popStack.size();
    }
}
