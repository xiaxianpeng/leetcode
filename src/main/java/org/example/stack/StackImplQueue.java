package org.example.stack;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * 实现 MyQueue 类：
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 说明：
 * 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 示例 1：
 * 输入：
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 1, 1, false]
 * 解释：
 * MyQueue myQueue = new MyQueue();
 * myQueue.push(1); // queue is: [1]
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * myQueue.peek(); // return 1
 * myQueue.pop(); // return 1, queue is [2]
 * myQueue.empty(); // return false
 */
public class StackImplQueue {

    // 使用两个栈来模拟队列
    // stackPush用来处理入队操作，stackPop用来处理出队操作
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public StackImplQueue() {
        this.stackPush = new Stack<>();
        this.stackPop = new Stack<>();
    }

    /**
     * 将元素x推到队列的末尾
     * 算法思路：
     * 将新元素直接压入stackPush中
     *
     * @param x 元素
     */
    public void push(int x) {
        stackPush.push(x);
    }

    /**
     * 返回队列开头的元素
     * 算法思路：
     * 如果stackPop为空，则将stackPush中所有元素弹出并压入stackPop
     * 此时stackPop的栈顶元素即为队首元素，然后返回stackPop的栈顶元素
     */
    public int peek() {
        if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }

    /**
     * 删除队头的元素并返回元素
     * 算法思路：
     * 先peek,再pop
     */
    public int pop() {
        // 先调用peek(),防止s2为空
        peek();
        return stackPop.pop();
    }

    /**
     * 判断队列是否为空
     * 算法思路：
     * 若两个栈都为空，则队列为空
     */
    public boolean isEmpty() {
        return stackPush.isEmpty() && stackPop.isEmpty();
    }

    public static void main(String[] args) {
        StackImplQueue myQueue = new StackImplQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());     // 应返回 1
        System.out.println(myQueue.pop());      // 应返回 1，队列中还剩 [2]
        System.out.println(myQueue.isEmpty());    // 应返回 false
    }
}
