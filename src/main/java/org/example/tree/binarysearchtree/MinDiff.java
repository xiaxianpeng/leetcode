package org.example.tree.binarysearchtree;

import org.example.tree.TreeNode;
import org.example.util.TreeUtil;

/**
 * 530. 二叉搜索树的最小绝对差
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * 差值是一个正数，其数值等于两值之差的绝对值。
 * 示例 1：
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * 示例 2：
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 */
public class MinDiff {

    private Integer previous;// 前一个节点的值
    private Integer minDiff;// 最小差值

    public MinDiff() {
        this.previous = null;
        this.minDiff = Integer.MAX_VALUE;
    }


    /**
     * 使用中序遍历（递归）找到二叉搜索树中任意两不同节点值之间的最小差值。
     * 算法思路：
     * 1. 对二叉搜索树进行中序遍历，因中序遍历结果为有序序列。
     * 2. 在遍历过程中，比较相邻节点的值，更新最小差值。
     * 3. 返回遍历过程中记录的最小差值。
     *
     * @param root 二叉搜索树的根节点
     * @return 树中任意两不同节点值之间的最小差值
     */
    public int getMinimumDifference(TreeNode root) {
        inorderTraverse(root);
        return minDiff;
    }

    /**
     * 中序遍历二叉搜索树并更新最小差值。
     *
     * @param node 当前遍历的节点
     */
    private void inorderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        // 递归遍历左子树
        inorderTraverse(node.left);

        System.out.println("访问节点: " + node.val);
        // 如果前一个节点存在，计算当前节点与前一个节点的差值
        if (previous != null) {
            int currDiff = node.val - previous;
            System.out.println("当前节点值: " + node.val + ", 前一个节点值: " + previous + ", 差值: " + currDiff);
            minDiff = Math.min(minDiff, currDiff);
            System.out.println("更新最小差值为: " + minDiff);
        }
        // 更新前一个节点的值为当前节点的值
        previous = node.val;

        // 递归遍历右子树
        inorderTraverse(node.right);
    }

    public static void main(String[] args) {
        // 二叉搜索树 [4,2,6,1,3]
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        TreeUtil.printTree(root1);
        System.out.println("示例 1 的最小绝对差值: " + new MinDiff().getMinimumDifference(root1)); // 输出: 1

        System.out.println("----------");

        // 二叉搜索树 [1,0,48,null,null,12,49]
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(0);
        root2.right = new TreeNode(48);
        root2.right.left = new TreeNode(12);
        root2.right.right = new TreeNode(49);
        TreeUtil.printTree(root2);
        // 重置前一个节点和最小差值
        System.out.println("示例 2 的最小绝对差值: " + new MinDiff().getMinimumDifference(root2)); // 输出: 1
    }
}
