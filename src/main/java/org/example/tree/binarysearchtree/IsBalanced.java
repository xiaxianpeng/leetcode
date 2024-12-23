package org.example.tree.binarysearchtree;

import org.example.tree.TreeNode;
import org.example.util.TreeUtil;

/**
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是
 * 平衡二叉树
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * 示例 2：
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * 示例 3：
 * 输入：root = []
 * 输出：true
 * Created on 2024/12/23 21:50
 */
public class IsBalanced {

    /**
     * @param root
     * @return
     */
    public static boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    /**
     * 递归计算数的高度，并判断是否平衡
     *
     * @param node 当前节点
     * @return 如果子树平衡，则返回其高度，否则返回-1
     */
    private static int getHeight(TreeNode node) {
        // 如果节点为空，高度为0
        if (node == null) {
            return 0;
        }

        //递归计算左子树的高度，如果左子树不平衡，返回-1
        int leftHeight = getHeight(node.left);
        if (leftHeight == -1) {
            return -1;
        }

        //递归计算右子树的高度，如果右子树不平衡，返回-1
        int rightHeight = getHeight(node.right);
        if (rightHeight == -1) {
            return -1;
        }

        // 计算左右子树的高度差，如果高度超过1，不平衡，返回-1
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // 返回当前节点的高度
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        TreeUtil.printTree(root1);
        System.out.println(isBalanced(root1)); // 输出 true


        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(3);
        root2.left.left.left = new TreeNode(4);
        root2.left.left.right = new TreeNode(4);
        TreeUtil.printTree(root2);
        System.out.println(isBalanced(root2)); // 输出 false


        TreeNode root3 = null;
        System.out.println(isBalanced(root3)); // 输出 true
    }
}
