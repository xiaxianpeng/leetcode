package org.example.dfs.tree;

import org.example.tree.TreeNode;
import org.example.util.TreeUtil;

/**
 * 114. 二叉树展开为链表
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * 示例 1：
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * 输入：root = [0]
 * 输出：[0]
 */
public class Flatten2ListNode {

    /**
     * 114. 二叉树展开为链表
     * 给定二叉树的根结点 root ，请你将它展开为一个单链表：
     * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
     * 展开后的单链表应该与二叉树先序遍历顺序相同。
     */
    public static void flatten(TreeNode node) {
        // base case：如果当前节点为空，直接返回
        if (node == null) {
            return;
        }

        // 递归展开左子树和右子树
        flatten(node.left);
        flatten(node.right);

        // 1、暂存左子树
        TreeNode left = node.left;
        TreeNode right = node.right;

        // 2、将左子树接到右边
        node.right = left;
        node.left = null;

        // 3、寻找到右子树的最末端并连接原右子树
        TreeNode curr = node;
        while (curr.right != null) {
            curr = curr.right;
        }
        curr.right = right;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        TreeUtil.printTree(root);
        flatten(root);
        TreeUtil.printTree(root);
    }
}
