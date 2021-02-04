package org.example.tree;

/**
 * @date 2021/02/04
 * @time 16:35
 * 二分搜索树(Binary Search Tree)
 */
public class BST<E extends Comparable<E>> {

    class Node {

        E e;
        Node left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }

    /**
     * 递归方式向二分搜索树插入元素e
     * 返回插入新节点后二分搜索树的根
     */
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node, e);
        } else {
            node.right = add(node, e);
        }
        return node;
    }
}
