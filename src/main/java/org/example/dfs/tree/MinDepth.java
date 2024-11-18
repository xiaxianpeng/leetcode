package org.example.dfs.tree;

import org.example.tree.TreeNode;
import org.example.util.TreeUtil;

/**
 * 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点
 * https://leetcode.cn/problems/minimum-depth-of-binary-tree/description/?envType=study-plan-v2&envId=labuladong-algorithm-note。
 * Created on 2024/11/9 23:16
 */
public class MinDepth {

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }
        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            minDepth = Math.min(minDepth, minDepth(root.left));
        }
        if (root.right != null) {
            minDepth = Math.min(minDepth, minDepth(root.right));
        }
        return minDepth + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        TreeUtil.printTree(root);
        System.out.println(minDepth(root));
    }
}
