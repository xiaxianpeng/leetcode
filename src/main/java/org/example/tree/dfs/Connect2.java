package org.example.tree.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 * 给定一个二叉树：
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。
 * 初始状态下，所有 next 指针都被设置为 NULL 。
 * 示例 1：
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指针连接），'#' 表示每层的末尾。
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 */


public class Connect2 {

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
     * 适用于任意二叉树，不仅限于完美二叉树。
     *
     * @param root 任意二叉树的根节点
     * @return 修改后的二叉树根节点
     */
    public static Node connect(Node root) {
        List<Node> previousNodes = new ArrayList<>();// 用于存储每层的前一个节点
        connectNodes(root, 0, previousNodes);
        return root;
    }

    /**
     * 深度优先搜索，连接每个节点的 next 指针。
     *
     * @param currentNode   当前节点
     * @param depth         当前节点的深度
     * @param previousNodes 存储每层前一个节点的列表
     */
    private static void connectNodes(Node currentNode, int depth, List<Node> previousNodes) {
        if (currentNode == null) {
            return;// 基础情况：节点为空，直接返回
        }
        if (depth == previousNodes.size()) {// currentNode 是这一层最左边的节点
            previousNodes.add(currentNode);
        } else {// previousNodes.get(depth) 是 currentNode 左边的节点
            Node lastNodeAtDepth = previousNodes.get(depth);
            lastNodeAtDepth.next = currentNode; // 将上一个节点的 next 指向当前节点
            previousNodes.set(depth, currentNode);// 更新当前层的前一个节点为 currentNode
        }

        // 先遍历左子节点，再遍历右子节点
        connectNodes(currentNode.left, depth + 1, previousNodes);
        connectNodes(currentNode.right, depth + 1, previousNodes);
    }

    public static void main(String[] args) {
        // 二叉树：[1,2,3,4,5,null,7]
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);

        connect(root);

        System.out.println("节点 1 的 next: " + getNextVal(root));//null
        System.out.println("节点 2 的 next: " + getNextVal(root.left));//3
        System.out.println("节点 3 的 next: " + getNextVal(root.right));//null
        System.out.println("节点 4 的 next: " + getNextVal(root.left.left));//5
        System.out.println("节点 5 的 next: " + getNextVal(root.left.right));//7
        System.out.println("节点 7 的 next: " + getNextVal(root.right.right));//null
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
