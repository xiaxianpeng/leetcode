package org.example.tree.dfs;

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
     * 使用深度优先搜索（DFS）递归方法连接每个节点的 next 指针指向其右侧节点。
     *
     * @param root 完美二叉树的根节点
     * @return 修改后的二叉树根节点
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
            return null;// 如果树为空，直接返回 null
        }
        // 遍历[三叉树]，连接相邻节点
        connectTwoNode(root.left, root.right);
        return root;
    }

    /**
     * 递归连接当前节点的两个子节点，以及跨越父节点的子节点。
     *
     * @param left  当前节点的左子节点
     * @param right 当前节点的右子节点
     */
    private static void connectTwoNode(Node left, Node right) {
        if (left == null || right == null) {
            return;// 如果其中一个子节点为空，直接返回
        }
        // ---前序位置---
        // 将左子节点的 next 指向右子节点
        left.next = right;

        // 连接相同父节点的子节点
        connectTwoNode(left.left, left.right);
        connectTwoNode(right.left, right.right);

        // 连接跨越父节点的子节点
        connectTwoNode(left.right, right.left);
    }

    public static void main(String[] args) {
        // 二叉树：[1,2,3,4,5,6,7]
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
