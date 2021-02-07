package org.example.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
            node.left = add(node.left, e);
        } else {
            node.right = add(node.right, e);
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
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 前序遍历以node为根的二分搜索树,递归算法
     */
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 前序遍历非递归
     */
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 中序遍历以node为根的二分搜索树,递归算法
     */
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 中序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 中序遍历以node为根的二分搜索树,递归算法
     */
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * 层序遍历
     */
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    /**
     * 寻找二分搜索树最小元素
     */
    public E minimum() {
        if (isEmpty()) {
            throw new IllegalArgumentException("BST is empty");
        }
        return minimum(root).e;
    }

    /**
     * 返回以node为根的二分搜索树的最小值所在的节点
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 寻找二分搜索树最大元素
     */
    public E maximum() {
        if (isEmpty()) {
            throw new IllegalArgumentException("BST is empty");
        }
        return maximum(root).e;
    }

    /**
     * 返回以node为根的二分搜索树的最大值所在的节点
     */
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    /**
     * 删除最小元素
     */
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    /**
     * 删除Node最小元素
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax() {
        E max = maximum();
        root = removeMax(root);
        return max;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    @Override
    public String toString() {
        StringBuffer res = new StringBuffer();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuffer res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < depth; i++) {
            res.append("-");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        Integer[] nums = new Integer[]{5, 3, 6, 8, 4, 2};
        for (Integer num : nums) {
            bst.add(num);
        }
        System.out.println(bst.minimum());
        System.out.println(bst.maximum());
        System.out.println("~~~~~~~~~~~~~~~");
        bst.removeMin();
        System.out.println("~~~~~~~~~~~~~~~");
        bst.removeMax();
        System.out.println(bst);
        /*
        System.out.println(bst.contains(3));

        System.out.println("~~~~~~~~~~~~~~~");
        System.out.println(bst);

        System.out.println("~~~~~~~~~~~~~~~");
        bst.preOrder();

        System.out.println("~~~~~~~~~~~~~~~");
        bst.preOrderNR();

        System.out.println("~~~~~~~~~~~~~~~");
        bst.inOrder();

        System.out.println("~~~~~~~~~~~~~~~");
        bst.postOrder();

        System.out.println("~~~~~~~~~~~~~~~");
        bst.levelOrder();
   */
    }
}
