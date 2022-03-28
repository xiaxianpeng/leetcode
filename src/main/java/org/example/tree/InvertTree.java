package org.example.tree;

/**
 * @author xianpeng.xia
 * on 2022/3/28 11:56 PM
 *
 * 如何翻转⼆叉树？其实就是把⼆叉树上的每个节点的左右⼦节点都交换⼀下
 */
public class InvertTree {

    public static TreeNode invertTree(TreeNode root) {
        traverse(root);
        return root;
    }

    static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // ---前序遍历位置---
        // 交换左右节点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        traverse(root.left);
        traverse(root.right);
    }

    /**
     * // 「分解问题」的思路
     *
     * @param root root
     * @return 翻转后的⼆叉树
     */
    public static TreeNode invertTree_(TreeNode root) {
        if (root == null) {
            return null;
        }

        // 先翻转左右子树
        TreeNode left = invertTree_(root.left);
        TreeNode right = invertTree_(root.right);
        // 交换左右子树
        root.left = right;
        root.right = left;
        // 和定义逻辑⾃恰：以 root 为根的这棵⼆叉树已经被翻转，返回 root
        return root;
    }
}
