package org.example.tree.pathsum;

import org.example.tree.TreeNode;
import org.example.util.TreeUtil;

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

    /**
     * 初始化最大路径和为最小整数值
     */
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
     * 计算以当前节点为端点的最大单边路径和，并更新最大路径和
     * 贡献值是 该节点的值 + 子节点贡献的最大值。
     *
     * @param node 当前处理的节点
     * @return 当前节点为端点的最大单边路径和，用于上层节点的路径和计算
     */
    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;// 如果节点为空，其贡献值为0
        }

        // 递归地计算左右子节点提供的最大贡献值，忽略负贡献值
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // 当前节点的路径和 = 节点值 + 其左右子节点的最大贡献值
        int currentPathSum = node.val + leftGain + rightGain;

        // 更新全局最大路径和
        maxPathSum = Math.max(maxPathSum, currentPathSum);

        System.out.println("节点值: " + node.val + ", 左贡献值: " + leftGain +
                ", 右贡献值: " + rightGain + ", 当前路径和: " + currentPathSum +
                ", 全局最大路径和: " + maxPathSum);

        // 返回当前节点的最大单边贡献值给父节点计算使用
        return node.val + Math.max(leftGain, rightGain);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        TreeUtil.printTree(root1);
        System.out.println("最大路径和为: " + new MaxPathSum().maxPathSum(root1)); // 输出: 6

        TreeNode root2 = new TreeNode(-10);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(20);
        root2.right.left = new TreeNode(15);
        root2.right.right = new TreeNode(7);
        TreeUtil.printTree(root2);
        System.out.println("最大路径和为: " + new MaxPathSum().maxPathSum(root2)); // 输出: 42
    }
}
