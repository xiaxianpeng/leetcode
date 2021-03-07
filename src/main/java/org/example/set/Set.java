package org.example.set;

/**
 * @author xianpeng.xia
 * on 2021/3/7 8:37 下午
 */
public interface Set<E> {

    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();
}
