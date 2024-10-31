package org.example.queue.structure;

/**
 * @author xianpeng.xia
 * on 2021/1/18 10:34 下午
 */
public interface Queue<E> {

    void enqueue(E e);

    E dequeue();

    E getFront();

    int getSize();

    boolean isEmpty();
}
