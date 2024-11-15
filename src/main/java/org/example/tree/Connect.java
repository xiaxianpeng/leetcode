package org.example.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * 示例 1：
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[1,#,2,3,#,4,5,6,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，
 * 如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
 * 示例 2:
 * 输入：root = []
 * 输出：[]
 * https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/description/?envType=study-plan-v2&envId=labuladong-algorithm-note
 */


public class Connect {

    private static class Node {

        int val;
        Node left;
        Node right;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    /**
     * 算法思路：
     * 1、主函数 connect：
     * 检查根节点是否为空。如果为空，直接返回null。
     * 调用辅助函数connectTwoNode，开始连接根节点的两个子节点。
     * 返回经过连接的树的根节点。
     * *
     * 2、辅助函数 connectTwoNode：
     * 该函数接受两个节点，如果其中任何一个为空，则直接返回。
     * 在前序位置连接这两个节点。
     * 递归地处理：
     * 连接左节点的左子节点和右子节点。
     * 连接右节点的左子节点和右子节点。
     * 连接左节点的右子节点和右节点的左子节点。
     */
    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        // 遍历[三叉树]，连接相邻节点
        connectTwoNode(root.left, root.right);
        return root;
    }

    // [三叉树]遍历框架
    private static void connectTwoNode(Node left, Node right) {
        if (left == null || right == null) {
            return;
        }
        // ---前序位置---
        // 将传入的两个节点串起来
        left.next = right;

        // 连接相同父节点的两个子节点
        connectTwoNode(left.left, left.right);
        connectTwoNode(right.left, right.right);

        // 连接跨越父节点的两个子节点
        connectTwoNode(left.right, right.left);
    }

    /**
     * 层序遍历
     */
    public static Node connectByLevelOrder(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 从队首取出元素
                Node node = queue.poll();
                // 连接
                if (i < size - 1) {
                    node.next = queue.peek();
                }
                // 拓展下一层节点
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        // 返回root
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node connect = connect(root);
        System.out.printf("");
    }
}
