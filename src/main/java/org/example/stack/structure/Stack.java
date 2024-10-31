package org.example.stack.structure;

/**
 * @date 2021/01/18
 * @time 15:12
 */
public interface Stack<E> {

    void push(E e);

    E pop();

    E peek();

    int getSize();

    boolean isEmpty();
}
