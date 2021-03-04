package org.example.tree;

/**
 * @date 2021/03/03
 * @time 18:50
 */
public interface Merger<E> {

    E merge(E a, E b);
}
