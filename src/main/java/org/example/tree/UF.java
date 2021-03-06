package org.example.tree;

/**
 * @date 2021/03/06
 * @time 14:05
 * union find 并查集
 */
public interface UF {

    int getSize();

    boolean isConnected(int p, int q);

    void union(int p, int q);
}
