package org.example.tree.dfs;

import org.example.tree.TreeNode;
import org.example.tree.traversal.PreorderTraversal;
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
     * 将二叉树展开为链表
     * 算法思路：
     * 1. 使用递归方式遍历树，返回当前子树展开后的尾节点。
     * 2. 对每个节点，先递归展开左子树和右子树。
     * 3. 如果左子树存在，将其插入到当前节点的右侧，并将原右子树连接到左子树的尾部。
     * 4. 返回当前子树展开后的尾节点。
     *
     * @param root 需要展开的二叉树的根节点
     */
    public static void flatten(TreeNode root) {
        flattenTree(root);
    }

    /**
     * 递归辅助方法，展开子树并返回展开后的尾节点。
     *
     * @param node 当前处理的节点
     * @return 展开后的子树的尾节点
     */
    private static TreeNode flattenTree(TreeNode node) {
        if (node == null) {
            return null;// 空节点直接返回
        }
        if (node.left == null && node.right == null) {
            return node;// 叶子节点本身就是尾节点
        }

        // 递归展开左子树
        TreeNode leftTail = flattenTree(node.left);
        // 递归展开右子树
        TreeNode rightTail = flattenTree(node.right);

        if (node.left != null) {
            // 将左子树插入到右子树的位置
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }

        // 返回展开后的尾节点
        return rightTail != null ? rightTail : leftTail;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(5);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.right = new TreeNode(6);
        TreeUtil.printTree(root1);
        System.out.println(PreorderTraversal.preOrderTraversal(root1));
        flatten(root1);
        TreeUtil.printTree(root1);


        TreeNode root2 = null;
        TreeUtil.printTree(root2);
        System.out.println(PreorderTraversal.preOrderTraversal(root2));
        flatten(root2);
        TreeUtil.printTree(root2);


        TreeNode root3 = new TreeNode(0);
        TreeUtil.printTree(root3);
        System.out.println(PreorderTraversal.preOrderTraversal(root3));
        flatten(root3);
        TreeUtil.printTree(root3);
    }
}
