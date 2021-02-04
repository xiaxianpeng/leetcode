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

    /**
     * 看二分搜索树中是否包含元素e
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 看以node为根的二叉搜索树是否包含元素e,递归算法
     */
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (node.e.compareTo(e) == 0) {
            return true;
        } else if (node.e.compareTo(e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }
}
