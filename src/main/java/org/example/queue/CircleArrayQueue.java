package org.example.queue;

/**
 * @date 2020/11/27
 * @time 11:11
 */
public class CircleArrayQueue {

    /**
     * 队列的所有元素
     */
    private int[] arr;
    /**
     * 队列的第一个元素位置
     */
    private int front = 0;
    /**
     * 队列的最后一个元素后一个位置
     */
    private int rear = 0;
    private int capacity;

    public CircleArrayQueue(int capacity) {
        this.capacity = capacity + 1;
        this.arr = new int[this.capacity];
    }

    /**
     * @param val 元素值
     *            添加
     */
    public void add(int val) {
        if (isFull()) {
            throw new RuntimeException("队列满..");
        }
        arr[rear] = val;
        rear = (rear + 1) % capacity;
    }

    /**
     * 出队列
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空..");
        }
        int val = arr[front];
        front = (front + 1) % capacity;
        return val;
    }

    /**
     * @return 队列的第一个元素
     */
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空..");
        }
        return arr[front];
    }

    /**
     * @return 队列是否空
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * @return 队列是否满
     */
    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }

    /**
     * @return 有效元素个数
     */
    public int size() {
        return (rear + capacity - front) % capacity;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("队列为空~~");
        }
        // 从front开始
        for (int i = front; i < front + size(); i++) {
            System.out.print(arr[i % capacity] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(3);
        circleArrayQueue.add(1);
        circleArrayQueue.add(2);
        circleArrayQueue.add(3);
        circleArrayQueue.print();
        circleArrayQueue.add(4);
        circleArrayQueue.print();
       /* circleArrayQueue.pop();
        circleArrayQueue.print();
        circleArrayQueue.pop();
        circleArrayQueue.print();*/

    }
}
