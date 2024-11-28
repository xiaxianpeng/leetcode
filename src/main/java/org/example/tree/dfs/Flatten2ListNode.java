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
     * 方法：递归展开二叉树为单链表
     * 思路：使用前序遍历，将每个节点的左子树插入其右子树位置。
     *
     * @param node 二叉树的根节点
     */
    public static void flatten(TreeNode node) {
        // base case：如果当前节点为空，直接返回
        if (node == null) {
            return;
        }

        System.out.println("Flattening node with value: " + node.val);

        // 1、暂存左右子树
        TreeNode left = node.left;
        TreeNode right = node.right;

        // 2、将左子树接到右边
        node.right = left;
        node.left = null;

        // 3、找到新的右子树的最后一个节点并连接原右子树
        TreeNode curr = node;
        while (curr.right != null) {
            curr = curr.right;
        }

        // 4、将之前保存的右子树连接到新的右子树末端
        curr.right = right;

        flatten(node.right);
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
