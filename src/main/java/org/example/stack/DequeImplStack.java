package org.example.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xianpeng.xia
 * on 2022/4/5 1:28 PM
 * 队列实现栈
 */
public class DequeImplStack {

    Queue<Integer> queue = new LinkedList<>();
    int topElem = 0;

    /**
     * @param x x
     * 添加元素到栈顶
     */
    public void push(int x) {
        // x是队列的尾，是栈的顶
        queue.offer(x);
        topElem = x;
    }

    public int top() {
        return topElem;
    }

    public int pop() {
        int size = queue.size();
        // 留下队尾两个元素
        while (size > 2) {
            queue.offer(queue.poll());
            size--;
        }
        topElem = queue.peek();
        queue.offer(queue.poll());
        //
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        DequeImplStack stack = new DequeImplStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
