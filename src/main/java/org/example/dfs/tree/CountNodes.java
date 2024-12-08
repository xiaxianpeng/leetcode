package org.example.dfs.tree;

import org.example.tree.TreeNode;

/**
 * 222. 完全二叉树的节点个数
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * 完全二叉树 的定义如下：在完全二叉树中，
 * 除了最底层节点可能没填满外，其余每层节点数都达到最大值，
 * 并且最下面一层的节点都集中在该层最左边的若干位置。
 * 若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 * 示例 1：
 * 输入：root = [1,2,3,4,5,6]
 * 输出：6
 * 示例 2：
 * 输入：root = []
 * 输出：0
 * 示例 3：
 * 输入：root = [1]
 * 输出：1
 */
public class CountNodes {

    /**
     * 计算二叉树的节点个数。
     * 算法思路：
     * 1. 使用递归方法计算节点总数。
     * 2. 对于每个节点，递归计算其左右子树的节点总数，并加上自身。
     *
     * @param node 二叉树的根节点
     * @return 节点总数
     */
    public static int countNodes(TreeNode node) {
        // 基础情况：如果节点为 null，返回 0
        if (node == null) {
            return 0;
        }
        // 递归计算左子树和右子树的节点个数，加上当前节点
        int leftCount = countNodes(node.left); // 左
        int rightCount = countNodes(node.right);// 右
        int treeCount = leftCount + rightCount + 1;// 中
        return treeCount;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        System.out.println("Total nodes: " + countNodes(root)); // 输出 6
    }
}
