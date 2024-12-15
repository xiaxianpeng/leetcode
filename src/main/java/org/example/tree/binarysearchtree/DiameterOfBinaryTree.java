package org.example.tree.binarysearchtree;

import org.example.tree.TreeNode;
import org.example.util.TreeUtil;

/**
 * 543. 二叉树的直径
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。
 * 这条路径可能经过也可能不经过根节点 root 。
 * 两节点之间路径的 长度 由它们之间边数表示。
 * 示例 1：
 * 输入：root = [1,2,3,4,5]
 * 输出：3
 * 解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
 * 示例 2：
 * 输入：root = [1,2]
 * 输出：1
 * Created on 2024/11/9 23:58
 */
public class DiameterOfBinaryTree {
    // 用于存储最大直径
    private int maxDiameter = 0;

    /**
     * 计算二叉树的直径
     * 直径等于树中任意两个节点之间最长路径的长度
     *
     * @param root 二叉树的根节点
     * @return 二叉树的直径
     * 思路：通过后序遍历计算每个节点的左右子树深度，并更新最大直径。
     */
    public int diameterOfBinaryTree(TreeNode root) {
        // 递归计算深度，同时更新直径
        maxDepth(root);
        return maxDiameter;
    }


    /**
     * 计算节点的深度,并更新最大直径
     *
     * @param node 当前处理的节点
     * @return 当前节点的最大深度
     */
    private int maxDepth(TreeNode node) {
        if (node == null) {
            // 如果节点为空，返回深度0
            return 0;
        }
        // 计算左子树的最大深度
        int leftMaxDepth = maxDepth(node.left);
        // 计算右子树的最大深度
        int rightMaxDepth = maxDepth(node.right);

        // 更新最大直径
        maxDiameter = Math.max(maxDiameter, leftMaxDepth + rightMaxDepth);

        // 返回当前节点的最大深度
        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        TreeUtil.printTree(root);

        int diameter = new DiameterOfBinaryTree().diameterOfBinaryTree(root);
        System.out.println("二叉树的直径是: " + diameter);
    }
}
