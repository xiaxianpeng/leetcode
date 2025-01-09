package org.example.tree.dfs;

import org.example.tree.TreeNode;
import org.example.util.TreeUtil;

/**
 * 112. 路径总和
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 * 如果存在，返回 true ；否则，返回 false 。
 * 叶子节点 是指没有子节点的节点。
 * 示例 1：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 * 解释：等于目标和的根节点到叶节点路径如上图所示。
 * 示例 2：
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：false
 * 解释：树中存在两条根节点到叶子节点的路径：
 * (1 --> 2): 和为 3
 * (1 --> 3): 和为 4
 * 不存在 sum = 5 的根节点到叶子节点的路径。
 * 示例 3：
 * 输入：root = [], targetSum = 0
 * 输出：false
 * 解释：由于树是空的，所以不存在根节点到叶子节点的路径。
 * Created on 2024/11/28 09:25
 */
public class PathSum {

    /**
     * 判断是否存在从根节点到叶子节点的路径，其节点值之和等于 targetSum。
     *
     * @param node      根节点
     * @param targetSum 目标和
     * @return 是否存在满足条件的路径
     * 算法思路：
     * 1. 使用递归遍历每个节点，更新目标和。
     * 2. 如果当前节点为叶子节点且剩余目标和等于当前节点值，返回 true。
     * 3. 递归检查左右子树是否存在满足条件的路径。
     */
    public static boolean hasPathSum(TreeNode node, int targetSum) {
        // 如果树为空，则没有路径
        if (node == null) {
            return false;
        }

        // 检查是否到达叶子节点
        if (node.left == null && node.right == null) {
            // 到达叶子节点时，检查目标和是否为节点值
            return node.val == targetSum;
        }

        // 递归检查左子树和右子树
        boolean leftResult = hasPathSum(node.left, targetSum - node.val);
        boolean rightResult = hasPathSum(node.right, targetSum - node.val);

        // 返回左右子树中任意一条路径是否满足条件
        return leftResult || rightResult;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(8);
        root1.left.left = new TreeNode(11);
        root1.left.left.left = new TreeNode(7);
        root1.left.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(13);
        root1.right.right = new TreeNode(4);
        root1.right.right.right = new TreeNode(1);
        TreeUtil.printTree(root1);
        System.out.println("HasPathSum: " + hasPathSum(root1, 22)); // 输出 true

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        TreeUtil.printTree(root2);
        System.out.println("HasPathSum: " + hasPathSum(root2, 5)); // 输出 false

        TreeNode root3 = null;
        TreeUtil.printTree(root3);
        System.out.println("HasPathSum: " + hasPathSum(root3, 0)); // 输出 false
    }
}
