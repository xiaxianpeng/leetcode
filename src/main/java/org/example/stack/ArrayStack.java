package org.example.stack;

import org.example.array.Array;

/**
 * @date 2021/01/18
 * @time 15:16
 */
public class ArrayStack<E> implements Stack<E> {

    Array<E> array;

    public ArrayStack(int capacity) {
        this.array = new Array(capacity);
    }

    public ArrayStack() {
        this.array = new Array();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("ArrayStack: ");
        sb.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            sb.append(array.get(i) + ",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.peek();
        System.out.println(stack);
    }
}
