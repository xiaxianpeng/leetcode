package org.example.tree.binarysearchtree;


import org.example.tree.TreeNode;
import org.example.util.TreeUtil;

/**
 * 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，
 * 请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * 示例 1：
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * 示例 2：
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 */
public class KthSmallest {

    // 用于记录已经遍历的节点数量
    private int count = 0;
    // 存储第K小的节点值
    private int result = 0;

    /**
     * 计算二叉搜索树中第K小的元素。
     * 核心思路：利用中序遍历遍历树，按升序访问节点并返回第K个节点的值。
     *
     * @param root 二叉搜索树的根节点
     * @param k    第K小的元素
     * @return 第K小的元素
     */
    public int kthSmallest(TreeNode root, int k) {
        // 在递归中找到第K个元素
        inorder(root, k);
        return result;
    }

    /**
     * 中序遍历辅助方法
     *
     * @param node 当前节点
     * @param k    目标第 k 小的索引
     */
    public void inorder(TreeNode node, int k) {
        // 递归结束条件：树为空
        if (node == null) {
            return;
        }
        // 遍历左子树
        inorder(node.left, k);

        //*****中序遍历位置*****//
        // 访问当前节点
        count++; // 节点访问次数
        if (count == k) {
            result = node.val;// 找到第K小的节点
            return;
        }
        //********************//

        // 遍历右子树
        inorder(node.right, k);
    }


    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.left.right = new TreeNode(2);
        TreeUtil.printTree(root1);
        System.out.println(new KthSmallest().kthSmallest(root1, 1)); // 输出 1

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(6);
        root2.left.left = new TreeNode(2);
        root2.left.right = new TreeNode(4);
        root2.left.left.left = new TreeNode(1);
        TreeUtil.printTree(root2);
        System.out.println(new KthSmallest().kthSmallest(root2, 3)); // 输出 3
    }
}
