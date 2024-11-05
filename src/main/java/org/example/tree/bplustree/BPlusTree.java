package org.example.tree.bplustree;

/**
 * B+ 树的特点：
 * 1 每个节点中子节点的个数不能超过 m，也不能小于 m/2；
 * 2 根节点的子节点个数可以不超过 m/2，这是一个例外；
 * 3 m 叉树只存储索引，并不真正存储数据，这个有点儿类似跳表；
 * 4 通过链表将叶子节点串联在一起，这样可以方便按区间查找；
 * 5 一般情况，根节点会被存储在内存中，其他节点存储在磁盘中。
 * ***
 * ***
 * B- 树就是 B 树，英文翻译都是 B-Tree，这里的“-”并不是相对 B+ 树中的“+”，而只是一个连接符。这个很容易误解，所以我强调下。
 * 而 B 树实际上是低级版的 B+ 树，或者说 B+ 树是 B 树的改进版。B 树跟 B+ 树的不同点主要集中在这几个地方：
 * * B+ 树中的节点不存储数据，只是索引，而 B 树中的节点存储数据；
 * * B 树中的叶子节点并不需要链表来串联。
 * 也就是说，B 树只是一个每个节点的子节点个数不能小于 m/2 的 m 叉树。
 */
public class BPlusTree {
    /**
     * 这是 B+ 树非叶子节点的定义。
     * 假设 keywords=[3, 5, 8, 10]
     * 4 个键值将数据分为 5 个区间：(-INF,3), [3,5), [5,8), [8,10), [10,INF)
     * 5 个区间分别对应：children[0]...children[4]
     * m 值是事先计算得到的，计算的依据是让所有信息的大小正好等于页的大小：
     * PAGE_SIZE = (m-1)*4[keywordss 大小]+m*8[children 大小]
     */
    public static class BPlusTreeNode {
        // 5 叉树
        public static int m = 5;
        // 键值，用来划分数据区间
        public int[] keywords = new int[m - 1];
        // 保存子节点指针
        public BPlusTreeNode[] children = new BPlusTreeNode[m];
    }

    /**
     * 这是 B+ 树中叶子节点的定义。
     * B+ 树中的叶子节点跟内部结点是不一样的,
     * 叶子节点存储的是值，而非区间。
     * 这个定义里，每个叶子节点存储 3 个数据行的键值及地址信息。
     * k 值是事先计算得到的，计算的依据是让所有信息的大小正好等于页的大小：
     * PAGE_SIZE = k*4[keyw.. 大小]+k*8[dataAd.. 大小]+8[prev 大小]+8[next 大小]
     */
    public static class BPlusTreeLeafNode {
        public static int k = 3;
        // // 数据的键值
        public int[] keywords = new int[k];
        // 数据地址
        public long[] dataAddress = new long[k];
        // 这个结点在链表中的前驱结点
        public BPlusTreeLeafNode prev;
        // 这个结点在链表中的后继结点
        public BPlusTreeLeafNode next;
    }
}
