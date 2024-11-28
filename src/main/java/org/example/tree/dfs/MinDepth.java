package org.example.tree.dfs;

import org.example.tree.TreeNode;
import org.example.util.TreeUtil;

/**
 * 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点
 * Created on 2024/11/9 23:16
 */
public class MinDepth {

    /**
     * 计算二叉树的最小深度。
     * 最小深度是从根节点到最近叶子节点的路径上的节点数量。
     * 核心思路：使用深度优先搜索（DFS）递归求解最小深度。
     *
     * @param node 二叉树的父节点
     * @return 二叉树的最小深度
     */
    public static int minDepth(TreeNode node) {

        // 如果节点为空，深度为0
        if (node == null) {
            return 0;// 空节点的深度为0
        }

        // 如果当前节点是叶子节点
        if (node.left == null && node.right == null) {
            System.out.println("Leaf node reached. Node value: " + node.val + ", returning depth 1.");
            return 1;// 叶子节点的深度为1
        }


        // 如果有左子树，递归计算左子树的最小深度
        int minDepth = Integer.MAX_VALUE;
        if (node.left != null) {
            System.out.println("Exploring left subtree of node: " + node.val);
            minDepth = Math.min(minDepth, minDepth(node.left));
        }

        // 如果有右子树，递归计算右子树的最小深度
        if (node.right != null) {
            System.out.println("Exploring right subtree of node: " + node.val);
            minDepth = Math.min(minDepth, minDepth(node.right));
        }

        // 返回当前节点为根的子树的最小深度
        System.out.println("Returning min depth for node: " + node.val + ", Depth: " + (minDepth + 1));
        return minDepth + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        TreeUtil.printTree(root);
        System.out.println("Minimum Depth: " + minDepth(root));
    }
}
