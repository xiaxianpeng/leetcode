package org.example.dfs.tree;

import org.example.tree.TreeNode;
import org.example.util.TreeUtil;

/**
 * 437. 路径总和 III
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 示例 1：
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 * 示例 2：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：3
 * Created on 2024/11/29 09:51
 */
public class PathSum3 {

    /**
     * 计算二叉树中路径和等于指定值的路径总数。
     *
     * @param root      二叉树的根节点。
     * @param targetSum 路径总和的目标值。
     * @return 符合条件的路径总数。
     */
    public static int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        // 从当前节点开始计算符合目标和的路径数量，再递归到左右子节点
        int pathsFromRoot = countPaths(root, targetSum, 0);
        int pathsFromLeft = pathSum(root.left, targetSum);
        int pathsFromRight = pathSum(root.right, targetSum);
        return pathsFromRoot + pathsFromLeft + pathsFromRight;
    }

    /**
     * 从指定节点出发，计算所有向下的路径中，和为指定值的路径数量。
     *
     * @param node       当前考察的节点。
     * @param targetSum  路径总和的目标值。
     * @param currentSum 当前路径上的累计和。
     * @return 从当前节点出发的符合条件的路径数。
     */
    private static int countPaths(TreeNode node, int targetSum, int currentSum) {
        if (node == null) {
            return 0;
        }

        // 更新当前路径和
        currentSum += node.val;

        System.out.println("At Node " + node.val + "; Current Path Sum: " + currentSum);

        // 判断当前路径和是否符合目标和
        int totalPathsFound = (currentSum == targetSum) ? 1 : 0;

        // 继续探索所有可能的子路径
        totalPathsFound += countPaths(node.left, targetSum, currentSum);
        totalPathsFound += countPaths(node.right, targetSum, currentSum);

        return totalPathsFound;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        TreeUtil.printTree(root);
        int targetSum = 8;
        int result = pathSum(root, targetSum);
        System.out.println("Total paths with sum " + targetSum + " are: " + result);
    }
}
