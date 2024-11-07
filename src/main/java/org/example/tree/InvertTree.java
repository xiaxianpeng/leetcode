package org.example.tree;

/**
 * @author xianpeng.xia
 * on 2022/3/28 11:56 PM
 * <p>
 * 226. 翻转二叉树
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * <p>
 * 方法一：递归法
 * 链接：https://leetcode.cn/problems/invert-binary-tree/solutions/2361621/226-fan-zhuan-er-cha-shu-fen-zhi-qing-xi-tqlf/
 * 根据二叉树镜像的定义，考虑递归遍历（dfs）二叉树，交换每个节点的左 / 右子节点，即可生成二叉树的镜像。
 * 递归解析：
 * 终止条件： 当节点 root 为空时（即越过叶节点），则返回 null 。
 * 递推工作：
 * 初始化节点 tmp ，用于暂存 root 的左子节点。
 * 开启递归 右子节点 invertTree(root.right) ，并将返回值作为 root 的 左子节点 。
 * 开启递归 左子节点 invertTree(tmp) ，并将返回值作为 root 的 右子节点 。
 * 返回值： 返回当前节点 root 。
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

    /**
     * * 根据二叉树镜像的定义，考虑递归遍历（dfs）二叉树，交换每个节点的左 / 右子节点，即可生成二叉树的镜像。
     * * 递归解析：
     * * 终止条件： 当节点 root 为空时（即越过叶节点），则返回 null 。
     * * 递推工作：
     * * 初始化节点 tmp ，用于暂存 root 的左子节点。
     * * 开启递归 右子节点 invertTree(root.right) ，并将返回值作为 root 的 左子节点 。
     * * 开启递归 左子节点 invertTree(tmp) ，并将返回值作为 root 的 右子节点 。
     * * 返回值： 返回当前节点 root 。
     */
    public static TreeNode invert(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode left = node.left;
        node.left = invert(node.right);
        node.right = invert(left);
        return node;
    }

    public static void main(String[] args) {

        // 构建一个示例二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeUtil.printTree(root);

        TreeNode invert = invert(root);
        TreeUtil.printTree(invert);

    }
}
