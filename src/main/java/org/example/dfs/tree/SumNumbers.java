package org.example.dfs.tree;

import org.example.tree.TreeNode;
import org.example.util.TreeUtil;

/**
 * 129. 求根节点到叶节点数字之和
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * 叶节点 是指没有子节点的节点。
 * 示例 1：
 * 输入：root = [1,2,3]
 * 输出：25
 * 解释：
 * 从根到叶子节点路径 1->2 代表数字 12
 * 从根到叶子节点路径 1->3 代表数字 13
 * 因此，数字总和 = 12 + 13 = 25
 * 示例 2：
 * 输入：root = [4,9,0,5,1]
 * 输出：1026
 * 解释：
 * 从根到叶子节点路径 4->9->5 代表数字 495
 * 从根到叶子节点路径 4->9->1 代表数字 491
 * 从根到叶子节点路径 4->0 代表数字 40
 * 因此，数字总和 = 495 + 491 + 40 = 1026
 * Created on 2024/12/7 00:20
 */
public class SumNumbers {

    /**
     * 计算从根节点到叶节点生成的所有数字之和。
     * 算法思路：
     * 使用深度优先搜索（DFS）遍历每一条从根到叶的路径，
     * 在遍历过程中构建当前路径对应的数字。
     * 当遍历到叶节点时，将当前数字加入总和。
     *
     * @param root 二叉树的根节点
     * @return 所有根到叶节点生成的数字之和
     */
    public static int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    /**
     * 深度优先搜索辅助方法，计算当前路径生成的数字之和。
     *
     * @param node       当前遍历的节点
     * @param currentSum 当前路径对应的数字
     * @return 当前子树所有路径生成的数字之和
     */
    private static int dfs(TreeNode node, int currentSum) {
        if (node == null) {
            return 0;// 空节点不贡献任何值
        }

        // 更新当前路径对应的数字
        currentSum = currentSum * 10 + node.val;

        // 如果是叶节点，返回当前路径的数字
        if (node.left == null && node.right == null) {
            return currentSum;
        }

        // 递归计算左子树和右子树的和
        int leftSum = dfs(node.left, currentSum);
        int rightSum = dfs(node.right, currentSum);

        // 返回左右子树的总和
        return leftSum + rightSum;
    }

    public static void main(String[] args) {

        //  [1,2,3]
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        TreeUtil.printTree(root1);
        int result1 = sumNumbers(root1);
        System.out.println("输出: " + result1);
        System.out.println("期望: 25\n");

        //  [4,9,0,5,1]
        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(0);
        root2.left.left = new TreeNode(5);
        root2.left.right = new TreeNode(1);
        TreeUtil.printTree(root2);
        int result2 = sumNumbers(root2);
        System.out.println("输出: " + result2);
        System.out.println("期望: 1026\n");

        TreeNode root3 = null;
        TreeUtil.printTree(root3);
        int result3 = sumNumbers(root3);
        System.out.println("输出: " + result3);
        System.out.println("期望: 0\n");

        TreeNode root4 = new TreeNode(0);
        TreeUtil.printTree(root4);
        int result4 = sumNumbers(root4);
        System.out.println("输出: " + result4);
        System.out.println("期望: 0\n");
    }
}
