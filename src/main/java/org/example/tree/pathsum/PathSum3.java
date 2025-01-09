package org.example.tree.pathsum;

import org.example.tree.TreeNode;
import org.example.util.TreeUtil;

/**
 * 437. 路径总和III
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，
 * 求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 示例 1：
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 * 示例 2：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：3
 * Created on 2024/11/23 11:08
 */
public class PathSum3 {

    /**
     * 计算路径总和等于 targetSum 的路径数目。
     * 使用递归和前缀和的策略来高效地找到所有符合条件的路径。
     *
     * @param root      二叉树的根节点
     * @param targetSum 目标路径和
     * @return 路径数目
     */
    public static int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        // 递归计算以当前节点和其子节点为起点的路径数目
        return dfs(root, targetSum) + dfs(root.left, targetSum) + dfs(root.right, targetSum);
    }

    /**
     * 深度优先搜索辅助方法，以当前节点为起点计算路径数目。
     *
     * @param node      当前节点
     * @param targetSum 目标路径和
     * @return 路径数目
     */
    private static int dfs(TreeNode node, int targetSum) {
        if (node == null) {
            return 0;
        }
        // 当前路径是否满足 targetSum
        int count = (node.val == targetSum) ? 1 : 0;

        // 继续向下搜索左右子树
        count += dfs(node.left, targetSum - node.val);
        count += dfs(node.right, targetSum - node.val);

        return count;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(10);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(-3);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(2);
        root1.right.right = new TreeNode(11);
        root1.left.left.left = new TreeNode(3);
        root1.left.left.right = new TreeNode(-2);
        root1.left.right.right = new TreeNode(1);
        TreeUtil.printTree(root1);
        System.out.println("PathSum 1: " + pathSum(root1, 8)); // 输出: 3

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(8);
        root2.left.left = new TreeNode(11);
        root2.left.left.left = new TreeNode(7);
        root2.left.left.right = new TreeNode(2);
        root2.right.left = new TreeNode(13);
        root2.right.right = new TreeNode(4);
        root2.right.right.left = new TreeNode(5);
        root2.right.right.right = new TreeNode(1);
        TreeUtil.printTree(root2);
        System.out.println("PathSum 2: " + pathSum(root2, 22)); // 输出: 3
    }
}
