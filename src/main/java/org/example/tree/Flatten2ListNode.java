package org.example.tree;

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
     * 算法思想：
     * 核心思想是将二叉树展平成一个单链表，要求先序遍历的顺序。
     * 我们使用递归的方式进行树的展平，具体步骤如下：
     * 1、递归展平左右子树：递归地将左子树和右子树都展平成链表。
     * 2、将左子树接到右子树位置：将左子树的链表接到当前节点的右侧，并将左子树置为 null。
     * 3、将右子树接到新的右子树链表末端：找到当前右子树链表的末尾，并将原右子树接到这个末尾。
     * 树的展平操作是基于后序遍历：
     * .先递归展平左右子树。
     * .然后通过修改指针把左子树接到右子树的位置，右子树接到新的右子树末端
     */
    public static void flatten(TreeNode node) {
        // base case：如果当前节点为空，直接返回
        if (node == null) {
            return;
        }

        // 先递归展平左右子树
        flatten(node.left);
        flatten(node.right);

        // **** 后序遍历位置 ****/
        // 1、节点的左子树和右子树已经被展平为链表
        TreeNode left = node.left;
        TreeNode right = node.right;

        // 2、将左子树作为当前节点的右子树,并将左子树置为 null。
        node.right = left;
        node.left = null;

        // 3、找到当前右子树链表的末尾，并将原来的右子树接到这个末尾
        TreeNode p = node;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;

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
