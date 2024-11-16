package org.example.tree.binarysearchtree;


import org.example.tree.TreeNode;

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
    // 用于记录已访问节点的数量
    private int count = 0;
    // 用于存储第 k 小的节点值
    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        inOrderTraversal(root, k);
        return result;
    }

    public void inOrderTraversal(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        // 遍历左子树
        inOrderTraversal(node.left, k);

        //*****中序遍历位置*****//
        count++;
        if (count == k) {
            result = node.val;
            return;
        }
        //********************//

        // 遍历右子树
        inOrderTraversal(node.right, k);
    }


    public static void main(String[] args) {
        // 示例 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.left.right = new TreeNode(2);
        System.out.println(new KthSmallest().kthSmallest(root1, 1)); // 输出 1

        // 示例 2
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(6);
        root2.left.left = new TreeNode(2);
        root2.left.right = new TreeNode(4);
        root2.left.left.left = new TreeNode(1);
        System.out.println(new KthSmallest().kthSmallest(root2, 3)); // 输出 3
    }
}
