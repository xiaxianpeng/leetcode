package org.example.tree.pathsum;

import org.example.tree.TreeNode;

/**
 * 124. 二叉树中的最大路径和
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。
 * 同一个节点在一条路径序列中 至多出现一次 。
 * 该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * 示例 1：
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * 示例 2：
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 * Created on 2024/11/23 13:15
 */
public class MaxPathSum {

    // 用于存储全局最大路径和
    Integer maxPathSum = Integer.MIN_VALUE;

    /**
     * 计算二叉树的最大路径和。
     *
     * @param root 二叉树的根节点
     * @return 最大路径和
     */
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxPathSum;
    }

    /**
     * 计算节点的最大增益值。
     * 增益值是该节点的值加上子节点贡献的最大值。
     *
     * @param node 当前节点
     * @return 当前节点的最大增益值
     */
    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;// 空节点返回0，不影响路径和
        }

        // 递归计算左右子节点的最大增益值，负增益值设为0以不影响路径和
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // 当前路径和为节点值加上其左右子节点的最大增益
        int currentPathSum = node.val + leftGain + rightGain;

        // 更新全局最大路径和
        maxPathSum = Math.max(maxPathSum, currentPathSum);

        // 打印当前节点的信息
        System.out.println("Node: " + node.val + ", L-Gain: " + leftGain + ", R-Gain: " + rightGain +
                ", Curr-PathSum: " + currentPathSum + ", Global-MaxPathSum: " + maxPathSum);

        // 返回节点的最大增益值
        return node.val + Math.max(leftGain, rightGain);
    }

    public static void main(String[] args) {
        // 示例 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        System.out.println("Example 1: " + new MaxPathSum().maxPathSum(root1)); // 输出: 6

        // 示例 2
        TreeNode root2 = new TreeNode(-10);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(20);
        root2.right.left = new TreeNode(15);
        root2.right.right = new TreeNode(7);
        System.out.println("Example 2: " + new MaxPathSum().maxPathSum(root2)); // 输出: 42
    }
}
