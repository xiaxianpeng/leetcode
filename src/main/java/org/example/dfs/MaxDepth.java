package org.example.dfs;

import org.example.tree.TreeNode;
import org.example.tree.TreeUtil;

/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树 root ，返回其最大深度。
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/?envType=study-plan-v2&envId=labuladong-algorithm-note
 * Created on 2024/11/9 23:29
 */
public class MaxDepth {
    /**
     * 算法解析：
     * 终止条件： 当 root 为空，说明已越过叶节点，因此返回 深度 0 。
     * 递推工作： 本质上是对树做后序遍历。
     * 计算节点 root 的 左子树的深度 ，即调用 maxDepth(root.left)。
     * 计算节点 root 的 右子树的深度 ，即调用 maxDepth(root.right)。
     * 返回值： 返回 此树的深度 ，即 max(maxDepth(root.left), maxDepth(root.right)) + 1。
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        TreeUtil.printTree(root);
        System.out.println(maxDepth(root));
    }
}
