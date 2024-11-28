package org.example.tree.dfs;

import org.example.tree.TreeNode;

/**
 * 题目：完全二叉树的节点个数
 * 给定一棵完全二叉树的根节点，计算并返回这棵树的节点总数。
 * 完全二叉树的定义是：除了最后一层之外，其他层的节点都是满的，
 * 且最后一层的节点从左到右连续排列。
 */
public class CountNodes {

    /**
     * 计算二叉树的节点个数。
     * 算法思路：
     * 1. 使用递归方法计算节点总数。
     * 2. 对于每个节点，递归计算其左右子树的节点总数，并加上自身。
     *
     * @param root 二叉树的根节点
     * @return 节点总数
     */
    public static int countNodes(TreeNode root) {
        // 基础情况：如果节点为 null，返回 0
        if (root == null) {
            return 0;
        }
        // 递归计算左子树和右子树的节点个数，加上当前节点
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        System.out.println("Total nodes: " + countNodes(root)); // 应该输出 6
    }
}
