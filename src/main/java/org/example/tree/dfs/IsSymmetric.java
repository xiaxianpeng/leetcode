package org.example.tree.dfs;

import org.example.tree.TreeNode;

/**
 * 101. 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * 示例 1：
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * https://leetcode.cn/problems/symmetric-tree/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class IsSymmetric {

    /**
     * 检查二叉树是否为对称的。
     * 核心思路是使用递归检查每个节点的左子树和右子树是否互为镜像。
     *
     * @param root 二叉树的根节点
     * @return 二叉树是否对称
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;// 空树是对称的
        }
        return isMirror(root.left, root.right);
    }

    /**
     * 辅助方法，递归检查两棵子树是否互为镜像。
     *
     * @param left  左子树的节点
     * @param right 右子树的节点
     * @return 子树是否互为镜像
     */
    public static boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;// 两个空节点互为镜像
        }
        if (left == null || right == null) {
            return false;// 一个为空，另一个不为空，则不是镜像
        }
        if (left.val != right.val) {
            return false;// 值不相等，不是镜像
        }
        // 打印当前比较的节点
        System.out.println("Comparing nodes: " + left.val + " and " + right.val);

        // 递归比较：外侧和内侧节点
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(3);

        System.out.println("Is tree symmetric? " + isSymmetric(root1)); // 输出: true

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(3);

        System.out.println("Is tree symmetric? " + isSymmetric(root2)); // 输出: false
    }
}
