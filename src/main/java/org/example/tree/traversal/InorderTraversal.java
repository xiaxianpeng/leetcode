package org.example.tree.traversal;

import java.util.LinkedList;
import java.util.List;

import org.example.tree.TreeNode;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 * Created on 2024/11/22 19:32
 */
public class InorderTraversal {

    /**
     * @param root 根
     * @return 中序遍历结果
     * 中序遍历
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        traverseTree(root, result);
        return result;
    }

    private static void traverseTree(TreeNode node, LinkedList<Integer> result) {
        if (node == null) {
            return;
        }
        // 递归遍历左子树
        traverseTree(node.left, result);
        // 访问当前节点
        result.add(node.val);
        // 递归遍历右子树
        traverseTree(node.right, result);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        List<Integer> result = inorderTraversal(root);
        System.out.println("Inorder Traversal: " + result);
    }
}
