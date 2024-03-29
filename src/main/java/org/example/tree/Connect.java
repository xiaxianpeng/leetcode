package org.example.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xianpeng.xia
 * on 2022/3/28 11:35 PM
 *
 * 填充每个节点的下⼀个右侧节点指针
 *
 *
 * 给定⼀个完美⼆叉树，其所有叶⼦节点都在同⼀层，每个⽗节点都有两个⼦节点。⼆叉树定义如下：
 *
 * * struct Node {
 * *    int val;
 * *    Node *left;
 * *    Node *right;
 * *    Node *next;
 * * }
 *
 * 填充它的每个 next 指针，让这个指针指向其下⼀个右侧节点。
 * 如果找不到下⼀个右侧节点，则将 next 指 针设置为 NULL。初始状态下，所有 next 指针都被设置为 NULL。
 * 输⼊：root = [1,2,3,4,5,6,7]
 * 输出：[1,#,2,3,#,4,5,6,7,#]
 * 解释：给定⼆叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下⼀个右侧节 点，如图 B 所示。序列化的输出按层序遍历排列，同⼀层节点由 next 指针连接，'#' 标志着每⼀ 层的结束。
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
    }

    /**
     * @param root root
     * @return 填充每个节点的下⼀个右侧节点指针
     */
    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        // 遍历[三叉树]，连接相邻节点
        traverse(root.left, root.right);
        return root;
    }

    // [三叉树]遍历框架
    private static void traverse(Node leftNode, Node rightNode) {
        if (leftNode == null || rightNode == null) {
            return;
        }
        // ---前序位置---
        // 将传入的两个节点串起来
        leftNode.next = rightNode;

        // 连接相同父节点的两个子节点
        traverse(leftNode.left, leftNode.right);
        traverse(rightNode.left, rightNode.right);

        // 连接跨越父节点的两个子节点
        traverse(leftNode.right, rightNode.left);
    }

    /**
     * @param root root
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

        Node connect = connectByLevelOrder(root);
        System.out.printf("");
    }
}
