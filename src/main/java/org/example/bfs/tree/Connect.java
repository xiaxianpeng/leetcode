package org.example.bfs.tree;

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
     * 使用层序遍历连接每个节点的 next 指针指向其右侧节点。
     *
     * @param root 二叉树的根节点
     * @return 修改后的二叉树根节点
     */
    public static Node connect(Node root) {
        if (root == null) {
            return root;// 如果树为空，直接返回 null
        }

        // 初始化队列并添加根节点
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // 开始层序遍历
        while (!queue.isEmpty()) {
            int size = queue.size();// 当前层的节点数量
            for (int i = 0; i < size; i++) {
                // 从队首取出一个节点
                Node node = queue.poll();
                // 连接当前节点的 next 指针
                if (i < size - 1) {// 如果不是当前层的最后一个节点
                    node.next = queue.peek();// 下一个节点即为队列的下一个元素
                }

                // 将当前节点的子节点加入队列，准备下一层遍历
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        // 返回修改后的根节点
        return root;
    }

    public static void main(String[] args) {
        // 二叉树：[1,2,3,4,5,null,7]
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6); // 添加节点 6
        root.right.right = new Node(7);

        connect(root);

        System.out.println("节点 1 的 next: " + getNextVal(root)); // null
        System.out.println("节点 2 的 next: " + getNextVal(root.left)); // 3
        System.out.println("节点 3 的 next: " + getNextVal(root.right)); // null
        System.out.println("节点 4 的 next: " + getNextVal(root.left.left)); // 5
        System.out.println("节点 5 的 next: " + getNextVal(root.left.right)); // 6
        System.out.println("节点 6 的 next: " + getNextVal(root.right.left)); // 7
        System.out.println("节点 7 的 next: " + getNextVal(root.right.right)); // null
    }

    /**
     * 获取节点的 next 指针值。
     *
     * @param node 目标节点
     * @return next 节点的值或 "null"
     */
    private static String getNextVal(Node node) {
        return (node.next == null) ? "null" : String.valueOf(node.next.val);
    }
}
