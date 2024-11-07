package org.example.tree;

/**
 * 112. 路径总和
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 * 如果存在，返回 true ；否则，返回 false 。
 * 叶子节点 是指没有子节点的节点。
 * https://leetcode.cn/problems/path-sum/description/
 * ********
 * 思路及算法
 * 观察要求我们完成的函数，我们可以归纳出它的功能：询问是否存在从当前节点 root 到叶子节点的路径，满足其路径和为 sum。
 * 假定从根节点到当前节点的值之和为 val，我们可以将这个大问题转化为一个小问题：
 * 是否存在从当前节点的子节点到叶子的路径，满足其路径和为 sum - val。
 * 不难发现这满足递归的性质，若当前节点就是叶子节点，
 * 那么我们直接判断 sum 是否等于 val 即可（因为路径和已经确定，就是当前节点的值，我们只需要判断该路径和是否满足条件）。
 * 若当前节点不是叶子节点，我们只需要递归地询问它的子节点是否能满足条件即可。
 */
public class HasPath {
    public static boolean hasPath(TreeNode node, int targetSum) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null) {
            return targetSum == node.val;
        }
        return hasPath(node.left, targetSum - node.val) || hasPath(node.right, targetSum - node.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;

        System.out.println(hasPath(root, 3));
        System.out.println(hasPath(root, 4));
    }
}
