package org.example.tree.dfs;

import org.example.tree.TreeNode;
import org.example.util.TreeUtil;

/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树 root ，返回其最大深度。
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：3
 * 示例 2：
 * 输入：root = [1,null,2]
 * 输出：2
 * Created on 2024/11/9 23:29
 */
public class MaxDepth {
    /**
     * 计算二叉树的最大深度。
     * 最大深度是从根节点到最远叶子节点的最长路径上的节点数。
     * 核心思路：使用深度优先搜索（DFS）递归求解最大深度。
     *
     * @param root 二叉树的根节点
     * @return 二叉树的最大深度
     */
    public static int maxDepth(TreeNode root) {

        // 如果当前节点为空，深度为0
        if (root == null) {
            return 0;// 空树深度为0
        }
        // 递归计算左子树的最大深度
        int leftMaxDepth = maxDepth(root.left);
        // 递归计算右子树的最大深度
        int rightMaxDepth = maxDepth(root.right);

        // 返回较大的子树深度 + 1
        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        TreeUtil.printTree(root);
        System.out.println("Maximum Depth: " + maxDepth(root));
    }
}
