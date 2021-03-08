package org.example.tree;


import org.example.map.AVLMap;

/**
 * @date 2021/03/08
 * @time 11:07
 * 红黑树
 */
public class RBTree<K extends Comparable<K>, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {

        public K key;
        public V value;
        public Node left, right;
        public boolean color;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.color = RED;
        }
    }

    private Node root;
    private int size;

    public RBTree() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 判断节点node的颜色
     */
    private boolean isRed(Node node) {
        if (node == null) {
            return BLACK;
        }
        return node.color;
    }

    /**
     * //   node                     x
     * //  /   \     左旋转         /  \
     * // T1   x   --------->   node   T3
     * //     / \              /   \
     * //    T2 T3            T1   T2
     * //当心添加的结点（红色）添加到叶子结点的右侧，需要对该叶子结点进行左旋转（逆时针）
     * //此处x为新添加结点，而node为x的父节点
     */
    private Node leftRotate(Node node) {
        Node x = node.right;
        Node T2 = x.left;

        // 左旋转
        node.right = T2;
        x.left = node;

        x.color = node.color;
        node.color = RED;

        return x;
    }

    /**
     * //     node                   x
     * //    /   \     右旋转       /  \
     * //   x    T2   ------->   y   node
     * //  / \                       /  \
     * // y  T1                     T1  T2
     */
    private Node rightRotate(Node node) {
        Node x = node.left;
        Node T1 = x.right;

        // 左旋转
        node.left = T1;
        x.right = node;

        x.color = node.color;
        node.color = RED;

        return x;
    }

    /**
     * 颜色反转
     */
    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    /**
     * 向红黑树中添加元素
     */
    public void add(K key, V value) {
        root = add(root, key, value);
        // 最终根节点为黑色节点
        root.color = BLACK;
    }

    /**
     * 向以node为根的红黑树中插入元素(key,value),递归算法
     * 返回插入新节点后红黑树的根
     */
    private Node add(Node node, K key, V value) {
        if (node == null) {
            // 默认插入红色节点
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }

        // 维护黑平衡
        if (isRed(node.right) && !isRed(node.left)) {
            node = leftRotate(node);
        }
        //
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rightRotate(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }
        return node;
    }

    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            return getNode(node.right, key);
        } else {
            return node;
        }
    }

    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
        node.value = newValue;
    }

    public static void main(String[] args) {
        RBTree<String, Integer> tree = new RBTree<>();
        tree.add("a", 1);
        tree.add("b", 2);
        tree.add("c", 3);
        tree.add("d", 4);

        System.out.println(tree.get("d"));
    }

}
