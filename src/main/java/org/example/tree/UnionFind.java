package org.example.tree;

import java.util.Random;

/**
 * @date 2021/03/06
 * @time 14:11
 * 并查集
 */
public class UnionFind implements UF {

    private int[] parent;
    /**
     * rank[i]表示以i为根的集合所表示的树的层数
     */
    private int[] rank;

    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * 查看元素p和元素q是否所属一个集合
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 合并元素p和元素q所属的集合
     */
    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        // 根据两个元素所在树的rank不同判断合并方向
        // 将rank低的集合合并到rank高的集合上

        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = pRoot;
        } else {//rank[pRoot] == rank[qRoot]
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
    }

    /**
     * 查找过程,查找元素p所对应的集合编号
     * O(h)复杂度,h为树的高度
     */
    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }
        if (p != parent[p]) {
            // 路径压缩
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }

    public static void main(String[] args) {
        int size = 1000;
        int m = 1000;

        UnionFind unionFind = new UnionFind(size);

        Random random = new Random();
        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            unionFind.union(a, b);
        }

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            unionFind.isConnected(a, b);
        }
    }
}
